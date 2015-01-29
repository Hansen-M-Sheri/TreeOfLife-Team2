/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeoflife;

import byui.cit260.treeOfLife.model.Game;
import byui.cit260.treeOfLife.model.GameInventoryItems;
import byui.cit260.treeOfLife.model.Location;
import byui.cit260.treeOfLife.model.Players;
import byui.cit260.treeOfLife.model.ProgressMeter;

/**
 *
 * @author Chuck
 */
public class TreeOfLife {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Players playerOne = new Players();
        
        playerOne.setName("Fred Flinstone");
        
        String playerInfo = playerOne.toString();
        
        System.out.println(playerInfo);
        
        //test for Game class
        Game game1 = new Game();
        
        game1.setId(1);
        
        String gameID = game1.toString();
        System.out.println(gameID);
        
        //test for ProgressMeter class 
        ProgressMeter playerTwo = new ProgressMeter();
        
        playerTwo.setFaithStat(3);
      
        
        String faithStat = playerTwo.toString();
        System.out.println(faithStat);
        
        //test for GameInventoryItems class
        GameInventoryItems helmet = new GameInventoryItems();
        
        helmet.setItemDescription("Helmet of Salvation");
        helmet.setArmorPiece("Helmet");
        helmet.setArmorPieceFaithPoints(3);
        
        String helmetInfo = helmet.toString();
        System.out.println(helmetInfo);
        
        //test for Location class
        Location armorShop = new Location();
        
        armorShop.setxCoordinate(1);
        armorShop.setyCoordinate(1);
        armorShop.setBlocked(false);
        armorShop.setVisited(false);
        
        String armorShopLocation = armorShop.toString();
        System.out.println(armorShopLocation);
        
    }
    
}
