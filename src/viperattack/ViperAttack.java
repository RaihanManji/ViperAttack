/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viperattack;

import environment.ApplicationStarter;

/**
 *
 * @author User
 */
public class ViperAttack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        ApplicationStarter.run("Viper Attack", new SnakeEnvironment());
    }
    
}
