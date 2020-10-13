package book.agents;

import book.behaviours.RequestPerformer;
import book.views.BuyerView;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;

public class BuyerAgent extends Agent {

    private String bookTitle;
    private AID[] sellerAgents;
    private int ticker_timer = 10000;
    private BuyerAgent this_agent = this;
    private BuyerView buyerView;
    private String[] buyDetails = {null, null, null};

    @Override
    protected void setup() {
        System.out.println("Buyer agent " + getAID().getName() + " is ready");

        buyerView = new BuyerView(this);
        buyerView.setVisible(true);
    }

    public void buyBook(final String bookTitle) {
        //System.out.println(bookTitle);
        this.bookTitle = bookTitle;
        addBehaviour(new TickerBehaviour(this, ticker_timer) {
            protected void onTick() {
                System.out.println("Trying to buy " + bookTitle);

                DFAgentDescription template = new DFAgentDescription();
                ServiceDescription sd = new ServiceDescription();
                sd.setType("book-selling");
                template.addServices(sd);

                try {
                    DFAgentDescription[] result = DFService.search(myAgent, template);
                    System.out.println("Found the following seller agents:");
                    sellerAgents = new AID[result.length];

                    for (int i = 0; i < result.length; i++) {
                        sellerAgents[i] = result[i].getName();
                        System.out.println(sellerAgents[i].getName());
                    }
                    buyerView.printSellers(sellerAgents);

                } catch (FIPAException fe) {
                    fe.printStackTrace();
                }
                myAgent.addBehaviour(new RequestPerformer(this_agent));
            }
        });
    }

    public String[] getBuyDetails() {
        return buyDetails;
    }

    public void setBuyDetails(String[] buyDetails) {
        this.buyDetails = buyDetails;
    }

    @Override
    protected void takeDown() {
        buyerView.printDetails(buyDetails);
        System.out.println("Buyer agent " + getAID().getName() + " terminating");
    }

    public AID[] getSellerAgents() {
        return sellerAgents;
    }

    public String getBookTitle() {
        return bookTitle;
    }

}
