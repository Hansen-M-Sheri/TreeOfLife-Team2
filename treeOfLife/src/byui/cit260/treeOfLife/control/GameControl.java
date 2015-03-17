/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.control;

import byui.cit260.treeOfLife.model.Game;
import byui.cit260.treeOfLife.model.GameInventoryItems;
import byui.cit260.treeOfLife.model.Location;
import byui.cit260.treeOfLife.model.Map;
import byui.cit260.treeOfLife.control.MapControl.SceneType;
import byui.cit260.treeOfLife.model.Players;
import byui.cit260.treeOfLife.model.Scene;
import java.util.ArrayList;
import treeoflife.TreeOfLife;

/**
 *
 * @author Chuck
 */
public class GameControl {

    public static void createNewGame(Players player) {
        
        Game game = new Game();//create a new game
        TreeOfLife.setCurrentGame(game);//save the game in TreeOfLife
        
        game.setPlayer(player);//save player in game
        
        ArrayList<GameInventoryItems> forSale = GameControl.createInventoryList();//create items for sale in game
//        game.setInventory();//don't think I need to save since inventory is enum
        

        Map map = MapControl.createMap();//create the Map
        game.setMap(map);//save map in the game

        //move characters to starting position in the map
        MapControl.moveCharactersToStartingLocation(map);
        
        //System.out.println("*** createNewGame function called ***");
    
    
    }
    //@todo - instructions said to have this private, but it caused issues in Map.createMap()
    public static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();
        
        
        locations[0][0].setScene(scenes[SceneType.armorShop.ordinal()]);
        //start point
        locations[0][1].setScene(scenes[SceneType.cottage.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.levelOne.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.spaciousBuilding.ordinal()]);
        locations[1][0].setScene(scenes[SceneType.temple.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.levelTwo.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.levelThree.ordinal()]);
        locations[1][3].setScene(scenes[SceneType.treeOfKnowledge.ordinal()]);
        locations[2][0].setScene(scenes[SceneType.mantle.ordinal()]);
        locations[2][1].setScene(scenes[SceneType.levelFour.ordinal()]);
        locations[2][2].setScene(scenes[SceneType.levelFive.ordinal()]);
        locations[2][3].setScene(scenes[SceneType.treeOfLife.ordinal()]);
    }


    public static ArrayList<GameInventoryItems> createInventoryList() {
        //get list of forSale items from current game
        Game game = TreeOfLife.getCurrentGame();
        //create an arrayList forSaleList
        ArrayList<GameInventoryItems> forSaleList = game.getForSale();
        //add each armor piece to the forSaleList
        forSaleList.add(GameInventoryItems.Helmet);
        forSaleList.add(GameInventoryItems.ProtectiveShield);
        forSaleList.add(GameInventoryItems.TruthBelt);
        forSaleList.add(GameInventoryItems.FootCovering);
        forSaleList.add(GameInventoryItems.Sword);
        forSaleList.add(GameInventoryItems.BreastPlate);
        //Below is how we will remove item from list - 
//        forSaleList.remove(GameInventoryItems.helmet);
        
        return forSaleList ;
        
    }
    
    public static   ArrayList<GameInventoryItems> getSortedPurchasedItems(){
       
        ArrayList<GameInventoryItems> originalPurchasedItemsList = new ArrayList<>();
        
        //get list of items purchased for current game
         originalPurchasedItemsList = TreeOfLife.getCurrentGame().getPurchasedItems();
        if(originalPurchasedItemsList.size() <= 1 ) { //if only 1 item in list return list
            return originalPurchasedItemsList;
        }
        else { //if more than one item in arrayList, sort alphabetically
         ArrayList<GameInventoryItems> purchasedItemsList = new ArrayList<>();
        // make a copy (clone) original
        purchasedItemsList = (ArrayList<GameInventoryItems>) originalPurchasedItemsList.clone();
        //use bubble sort to sort list of purchaseItems by name
        GameInventoryItems tempGameInventoryItem;
        //loop over every item in the list
        for (int i = 0; i < purchasedItemsList.size()-1; i++){
//        int i = 0;
//        for( GameInventoryItems value : purchasedItemsList ){
//            i++;
            // for each item in list, compare to other list
            for (int j = 0; j < purchasedItemsList.size()-1-i; j++){
           int k = j+ 1;
//            for( GameInventoryItems index : purchasedItemsList ){

                if (purchasedItemsList.get(j).compareTo(purchasedItemsList.get(k)) > 0) {
                    
                    tempGameInventoryItem = purchasedItemsList.get(j);
                    purchasedItemsList.set(j,purchasedItemsList.get(k));
                    purchasedItemsList.set(k, tempGameInventoryItem);
                }
            }
    }
        return purchasedItemsList;

    }
}
    public static void displayCharacterInventory() {
        ArrayList<GameInventoryItems> purchasedItemsList = new ArrayList<>();
         purchasedItemsList = TreeOfLife.getCurrentGame().getPurchasedItems();
         
         for(GameInventoryItems armor: purchasedItemsList) {
             String armorPiece = armor.getArmorPiece();
             String armorDescr = armor.getItemDescription();
             int armorFaithPoints = armor.getFaithPoints();
             int armorObedPoints = armor.getObedPoints();
             int armorKnowPoints = armor.getKnowPoints();
             System.out.println( armorPiece + "-" + armorDescr);
             System.out.println("Faith pts = " + armorFaithPoints);
             System.out.println("Obedience pts = " + armorObedPoints); 
             System.out.println("Knowledge pts =" + armorKnowPoints);
         
         }
         
    }
}



