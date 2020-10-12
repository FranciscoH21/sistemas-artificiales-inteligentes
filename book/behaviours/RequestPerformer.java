package book.behaviours;

import book.agents.BuyerAgent;
import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import javax.swing.JOptionPane;

public class RequestPerformer extends Behaviour {

    private AID bestSeller;
    private int bestPrice;
    private int repliesCount = 0;
    private MessageTemplate messageTemplate;
    private int step = 0;
    private BuyerAgent buyerAgent;
    private String bookTitle;

    public RequestPerformer(BuyerAgent buyerAgent) {
        this.buyerAgent = buyerAgent;
        bookTitle = buyerAgent.getBookTitle();
        System.out.println("title:" + bookTitle);
    }

    public void action() {
        switch (step) {
            case 0:
                ACLMessage cfp = new ACLMessage(ACLMessage.CFP);
                for (int i = 0; i < buyerAgent.getSellerAgents().length; i++) {
                    cfp.addReceiver(buyerAgent.getSellerAgents()[i]);
                }

                cfp.setContent(bookTitle);
                cfp.setConversationId("book-trade");
                cfp.setReplyWith("cfp" + System.currentTimeMillis());
                myAgent.send(cfp);

                messageTemplate = MessageTemplate.and(MessageTemplate.MatchConversationId("book-trade"),
                        MessageTemplate.MatchInReplyTo(cfp.getReplyWith()));
                step = 1;
                break;

            case 1:
                ACLMessage reply = buyerAgent.receive(messageTemplate);
                if (reply != null) {
                    if (reply.getPerformative() == ACLMessage.PROPOSE) {
                        int price = Integer.parseInt(reply.getContent());
                        if (bestSeller == null || price < bestPrice) {
                            bestPrice = price;
                            bestSeller = reply.getSender();
                        }
                    }
                    repliesCount++;
                    if (repliesCount >= buyerAgent.getSellerAgents().length) {
                        step = 2;
                    }
                } else {
                    block();
                }
                break;

            case 2:
                ACLMessage order = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
                order.addReceiver(bestSeller);
                order.setContent(bookTitle);
                order.setConversationId("book-trade");
                order.setReplyWith("order" + System.currentTimeMillis());
                buyerAgent.send(order);

                messageTemplate = MessageTemplate.and(MessageTemplate.MatchConversationId("book-trade"),
                        MessageTemplate.MatchInReplyTo(order.getReplyWith()));

                step = 3;

                break;

            case 3:
                reply = myAgent.receive(messageTemplate);
                if (reply != null) {
                    if (reply.getPerformative() == ACLMessage.INFORM) {
                        JOptionPane.showMessageDialog(null, bookTitle + " successfully purchased from agent " + reply.getSender().getName());
                        System.out.println(bookTitle + " successfully purchased from agent " + reply.getSender().getName());
                        System.out.println("Price = " + bestPrice);
                        buyerAgent.setBuyDetails(new String[]{reply.getSender().getName(), Integer.toString(bestPrice), bookTitle});

                        myAgent.doDelete();
                    } else {
                        buyerAgent.setBuyDetails(new String[]{null, null, null});

                        JOptionPane.showMessageDialog(null, "Attempt failed: requested book already sold.");
                        System.out.println("Attempt failed: requested book already sold.");
                    }
                    buyerAgent.setBuyState(true);

                    step = 4;
                } else {
                    block();
                }
                break;
        }
    }

    public boolean done() {
        if (step == 2 && bestSeller == null) {
            buyerAgent.setBuyState(true);
            JOptionPane.showMessageDialog(null, "Attempt failed: " + bookTitle + " not available for sale");
            System.out.println("Attempt failed: " + bookTitle + " not available for sale");
        }
        return ((step == 2 && bestSeller == null) || step == 4);
    }
}
