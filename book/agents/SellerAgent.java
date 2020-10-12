package book.agents;

import book.behaviours.OfferRequestServer;
import book.behaviours.PurchaseOrderServer;
import book.views.SellerView;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class SellerAgent extends Agent {

    private SellerView sellerView;
    private HashMap<String, Integer> catalogue;

    public HashMap<String, Integer> getCatalogue() {
        return catalogue;
    }

    @Override
    protected void setup() {
        catalogue = new HashMap<>();
        sellerView = new SellerView(this);
        sellerView.setVisible(true);

        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());

        ServiceDescription sd = new ServiceDescription();
        sd.setType("book-selling");
        sd.setName("book-trading");
        dfd.addServices(sd);

        try {
            DFService.register(this, dfd);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }

        addBehaviour(new OfferRequestServer(this));

        addBehaviour(new PurchaseOrderServer(this));

    }

    @Override
    protected void takeDown() {
        try {
            DFService.deregister(this);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }

        sellerView.dispose();

        System.out.println("Seller agent " + getAID().getName() + "terminating");
    }

    public void updateCatalogue(final String title, final int price) {
        System.out.println("trying to add new book");
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                catalogue.put(title, price);
                System.out.println(title + " inserted with a price of " + price);
                JOptionPane.showMessageDialog(sellerView, title + " saved with a price of " + price);
            }
        });
    }
    
    public void printBuyer(String title, String buyer, int price){
        sellerView.printBuyer(title, buyer, price);
    }
}
