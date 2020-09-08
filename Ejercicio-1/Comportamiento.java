package agentes;

import jade.core.behaviours.Behaviour;

/**
 *
 * @author FranciscoHernandez
 */
public class Comportamiento extends Behaviour{
    private String nombre;
    
    public Comportamiento(String nombre){
        this.nombre = nombre;
    }
    
    public void action() {
        System.out.println("Hola, Yo soy el agente --> " + nombre);
    }

    public boolean done() {
        return true;
    }
    
}
