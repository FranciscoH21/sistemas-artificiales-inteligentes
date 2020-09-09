/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import jade.core.Agent;

/**
 *
 * @author FranciscoHernandez
 */
public class Agente extends Agent{
    
    protected void setup() {
        Comportamiento comportamiento = new Comportamiento();
        this.addBehaviour(comportamiento);
    }

}
