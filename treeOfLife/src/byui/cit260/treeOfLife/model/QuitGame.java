/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.model;

import java.io.Serializable;

/**
 *
 * @author Chuck
 */
public class QuitGame implements Serializable {
    
    public QuitGame()
    { 
        System.out.println("Thanks for playing Tree of Life - Copyright 2015 Hansen-Gray");

        System.exit(0);  // is it necessary? And when it must be called? 
    }   

    public void display() {
        }

   
    
}
