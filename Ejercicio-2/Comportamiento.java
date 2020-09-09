package ejercicio2;

import jade.core.behaviours.Behaviour;

/**
 *
 * @author FranciscoHernandez
 */
public class Comportamiento extends Behaviour {

    private int contador = 0;

    public void action() {
        contador++;
        System.out.println(contador);
    }

    public boolean done() {
        return contador == 100;
    }
}
