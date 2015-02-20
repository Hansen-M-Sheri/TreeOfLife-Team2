/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.control;

import byui.cit260.treeOfLife.model.Players;
import treeoflife.TreeOfLife;

/**
 *
 * @author Chuck
 */
public class ProgramControl {

    public static Players createPlayer(String name) {
       System.out.println("\n**** createPlayer function called ****");
       
       if (name == null){
           return null;
       }
       
       Players player = new Players();
       player.setName(name);
       
       TreeOfLife.setPlayers(player);
       
       return player;
    }
    
}
