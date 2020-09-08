package agentes;

import jade.core.Agent;

/**
 *
 * @author FranciscoHernandez
 */
public class Agente extends Agent {

    protected void setup() {
        Comportamiento comportamiento = new Comportamiento(this.getAID().getName());
        this.addBehaviour(comportamiento);
    }

}
