
package book.behaviours;

import book.agents.SellerAgent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class OfferRequestServer extends CyclicBehaviour{

    SellerAgent sellerAgent;
  
  public OfferRequestServer(SellerAgent sellerAgent) {
    this.sellerAgent = sellerAgent;
  }
  
  public void action() {
    MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.CFP);
    ACLMessage msg = sellerAgent.receive(mt);
    
    if(msg != null) {
      String title = msg.getContent();
      ACLMessage reply = msg.createReply();
      
      Integer price = (Integer) sellerAgent.getCatalogue().get(title);
      
      if(price != null) {
        reply.setPerformative(ACLMessage.PROPOSE);
        reply.setContent(String.valueOf(price.intValue()));
      } else {
        reply.setPerformative(ACLMessage.REFUSE);
        reply.setContent("not-available");
      }
      
      sellerAgent.send(reply);
    } else {
      block();
    }
  }
    
}
