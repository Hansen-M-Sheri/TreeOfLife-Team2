/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.control;

import byui.cit260.treeOfLife.model.Game;
import byui.cit260.treeOfLife.model.GameInventoryItems;
import byui.cit260.treeOfLife.model.Map;
import byui.cit260.treeOfLife.model.Players;
import byui.cit260.treeOfLife.model.ProgressMeter;
import byui.cit260.treeOfLife.model.Scene;

/**
 *
 * @author Chuck
 */
public class GameControl {

    public static void createNewGame(Players player) {
        
        Game game = new Game();//create a new game
        ProgramControl.setCurrentGame(game);//save the game in TreeOfLife
        
        game.setPlayer(player);//save player in game
        
        GameInventoryItems[] armor = GameControl.createInventoryList();//create ProgressMeter in game
        game.setInventory(armor);//save ProgressMeter
        

        Map map = MapControl.createMap();//create the Map
        game.setMap(map);//save map in the game

        //move characters to starting position in the map
        MapControl.moveCharactersToStartingLocation(map);
        
        //System.out.println("*** createNewGame function called ***");
    
    
    }

    public static void assignScenesToLocations(Map map, Scene[] scenes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void assignScenesToLocations(Map map, Scene[] scenes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public enum Item{
            helmet,
            shield,
            belt,
            footCovering,
            sword,
            breastplate;
        }

    public static GameInventoryItems[] createInventoryList() {
        
        GameInventoryItems[] inventory = 
                new GameInventoryItems[Constants.NUMBER_OF_INVENTORY_ITEMS];
        
        //created array(list) of inventory items
        GameInventoryItems helmet = new GameInventoryItems();
        helmet.setDescription("Helmet");
        helmet.setQuantityInStock(0);
        helmet.setRequiredAmount(0);
        inventory[Item.helmet.ordinal()] = helmet;
        
        GameInventoryItems shield = new GameInventoryItems();
        shield.setDescription("Shield");
        shield.setQuantityInStock(0);
        shield.setRequiredAmount(0);
        inventory[Item.shield.ordinal()] = shield;
        
        GameInventoryItems belt = new GameInventoryItems();
        belt.setDescription("Belt");
        belt.setQuantityInStock(0);
        belt.setRequiredAmount(0);
        inventory[Item.belt.ordinal()] = belt;       
               
        GameInventoryItems footCovering = new GameInventoryItems();
        footCovering.setDescription("Foot Covering");
        footCovering.setQuantityInStock(0);
        footCovering.setRequiredAmount(0);
        inventory[Item.footCovering.ordinal()] = footCovering;
        
        GameInventoryItems sword = new GameInventoryItems();
        sword.setDescription("Sword");
        sword.setQuantityInStock(0);
        sword.setRequiredAmount(0);
        inventory[Item.sword.ordinal()] = sword;
        
        GameInventoryItems breastplate = new GameInventoryItems();
        breastplate.setDescription("Breastplate");
        breastplate.setQuantityInStock(0);
        breastplate.setRequiredAmount(0);
        inventory[Item.breastplate.ordinal()] = breastplate;
        
        return inventory;
        
    }

    
}



