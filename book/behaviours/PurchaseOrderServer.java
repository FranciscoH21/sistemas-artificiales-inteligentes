package book.behaviours;

import book.agents.SellerAgent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import javax.swing.JOptionPane;

public class PurchaseOrderServer extends CyclicBehaviour {

    SellerAgent sellerAgent;

    public PurchaseOrderServer(SellerAgent sellerAgent) {
        this.sellerAgent = sellerAgent;
    }

    public void action() {
        MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.ACCEPT_PROPOSAL);
        ACLMessage msg = sellerAgent.receive(mt);

        if (msg != null) {
            String title = msg.getContent();
            ACLMessage reply = msg.createReply();

            Integer price = sellerAgent.getCatalogue().remove(title);
            if (price != null) {
                reply.setPerformative(ACLMessage.INFORM);
                JOptionPane.showMessageDialog(null, title + " sold to agent " + msg.getSender().getName());
                System.out.println(title + " sold to agent " + msg.getSender().getName());
                sellerAgent.printBuyer(title, msg.getSender().getName(), price);
            } else {
                reply.setPerformative(ACLMessage.FAILURE);
                reply.setContent("not-available");
            }
            sellerAgent.send(reply);
        } else {
            block();
        }
    }

}
