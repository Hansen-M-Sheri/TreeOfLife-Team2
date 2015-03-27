/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import byui.cit260.treeOfLife.control.GameControl;
import byui.cit260.treeOfLife.control.ProgramControl;
import byui.cit260.treeOfLife.model.Game;
import byui.cit260.treeOfLife.model.GameInventoryItems;
import java.util.ArrayList;
import java.util.Scanner;
import treeoflife.TreeOfLife;

/**
 *
 * @author sherihansen
 * Armor Shop
 * 
 */
public class ArmorShopMenuView extends View{
    //go to the Game, get the forSaleList to see what is still available
    public ArmorShopMenuView(){
        
        super("\n"
            +"\n========================================"
            +"\n| Armor Shop Menu                            |"
            +"\n========================================");
        //get the list of forsale items from the game
        Game game = TreeOfLife.getCurrentGame();
        try{
        ArrayList<GameInventoryItems> forSale = game.getForSale();
       
        if(forSale.size() < 1) {
            ErrorView.display(this.getClass().getName(), "There are no more items available in the Armor Shop");
        }
        else {
            
            //for each item in list
            for (GameInventoryItems item : forSale) {
                //get first letter of item name
                char armorPiece = item.name().charAt(0);
                //print first letter and description of item
                String armorDescription = item.getItemDescription();
                this.console.println("\n" + armorPiece + " - " + armorDescription);
            }

            this.console.println(
                "\nF - Sort Faith Points"
                +"\n"
                +"\nO - Sort Obedience Points"
                +"\n"
                +"\nK - Sort Knowledge Points" 
                +"\n"
                +"\nG - Game Menu"
                +"\n"
                +"\nQ - Return to Main Menu"
                +"\n========================================");
        } 
        }catch (Exception e) {
           ErrorView.display(this.getClass().getName(), "Error reading input "+ e.getMessage());
        }
    }


//go to game, get for sale list


/**
 * Validates and calls correct action for Armor Shop Menu
 * @param selection 
 */
   
    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase(); //convert to all upper case
        char choice = value.charAt(0); //get first character entered
       
        switch (choice){
            case 'H':// get Helmet
                this.getHelmet();
                break;
            case 'P': // get the ProtectiveShield
                this.getShield();
                break;
            case 'T': // get TruthBelt
                this.getBelt();
                break;
            case 'B': // get Boots
                this.getBoots(); 
                break;
            case 'S': // get Sword
                this.getSword();
                break;
            case 'I':  // get IronBreastplate
                this.getIronBreastplate(); 
                break;
            case 'F':  // get FaithPoints
                this.getSortFaithPoints(); 
                break;
            case 'O':  // get ObedientPoints
                this.getSortObedPoints(); 
                break;
            case 'K':  // get KnowledgePoints
                this.getSortKnowPoints(); 
                break;
            case 'G':  // go to game menu
                this.goToGameMenu(); 
                break;
            case 'Q': // Quit the Map Menu and return to the Main Menu
                this.returnToMainMenu();
                break;
            default:
            ErrorView.display("ArmorShopMenuView ","\n*** Invalid Armor menu selection *** Try again");
                break;
        }       
        return true;
    }

    private void getHelmet() {

        //once selected either by purchase/earned 
        //remove from forSaleList arrayList
        Game game = TreeOfLife.getCurrentGame();
        game.getForSale().remove(GameInventoryItems.Helmet);
        if(game.getPurchasedItems() == null){
            ArrayList<GameInventoryItems> purchaseItems = new ArrayList<>();
           purchaseItems.add(GameInventoryItems.Helmet);
            game.setPurchasedItems(purchaseItems);
            this.console.println(game.getPurchasedItems());
            
        }
        else {
        //add to purchased list
        game.getPurchasedItems().add(GameInventoryItems.Helmet);
        }
        this.console.println("Your helmet has been added to your inventory");
        ArmorShopMenuView armorMenu = new ArmorShopMenuView();
        armorMenu.display();
        
    }

    private void getShield() {
//        this.console.println("getShield function called");
        Game game = TreeOfLife.getCurrentGame();
        game.getForSale().remove(GameInventoryItems.ProtectiveShield);
        if(game.getPurchasedItems() == null){
            ArrayList<GameInventoryItems> purchaseItems = new ArrayList<>();
           purchaseItems.add(GameInventoryItems.ProtectiveShield);
            game.setPurchasedItems(purchaseItems);
        }
        else {
        //add to purchased list
        game.getPurchasedItems().add(GameInventoryItems.ProtectiveShield);
        }
        this.console.println("Your Shield has been added to your inventory");
         ArmorShopMenuView armorMenu = new ArmorShopMenuView();
        armorMenu.display();
    }

    private void getBelt() {
//        this.console.println("getBelt function called");
        Game game = TreeOfLife.getCurrentGame();
        game.getForSale().remove(GameInventoryItems.TruthBelt);
        if(game.getPurchasedItems() == null){
            ArrayList<GameInventoryItems> purchaseItems = new ArrayList<>();
           purchaseItems.add(GameInventoryItems.TruthBelt);
            game.setPurchasedItems(purchaseItems);
        }
        else {
        //add to purchased list
        game.getPurchasedItems().add(GameInventoryItems.TruthBelt);
        }
         this.console.println("Your Belt has been added to your inventory");
         ArmorShopMenuView armorMenu = new ArmorShopMenuView();
        armorMenu.display();
    }

    private void getBoots() {

        Game game = TreeOfLife.getCurrentGame();
        game.getForSale().remove(GameInventoryItems.Boots);
        if(game.getPurchasedItems() == null){
            ArrayList<GameInventoryItems> purchaseItems = new ArrayList<>();
           purchaseItems.add(GameInventoryItems.Boots);
            game.setPurchasedItems(purchaseItems);
        }
        else {
        //add to purchased list
        game.getPurchasedItems().add(GameInventoryItems.Boots);
        }
         this.console.println("Your Boots have been added to your inventory");
         ArmorShopMenuView armorMenu = new ArmorShopMenuView();
        armorMenu.display();
    }

    private void getSword() {

        Game game = TreeOfLife.getCurrentGame();
        game.getForSale().remove(GameInventoryItems.Sword);
        //add to purchased list
        game.getPurchasedItems().add(GameInventoryItems.Sword);
          this.console.println("Your Sword has been added to your inventory");
         ArmorShopMenuView armorMenu = new ArmorShopMenuView();
        armorMenu.display();
    }

    private void getIronBreastplate() {

        Game game = TreeOfLife.getCurrentGame();
        game.getForSale().remove(GameInventoryItems.IronBreastPlate);
        if(game.getPurchasedItems() == null){
            ArrayList<GameInventoryItems> purchaseItems = new ArrayList<>();
           purchaseItems.add(GameInventoryItems.IronBreastPlate);
            game.setPurchasedItems(purchaseItems);
        }
        else {
        //add to purchased list
        game.getPurchasedItems().add(GameInventoryItems.IronBreastPlate);
        }
         this.console.println("Your Iron Breast Plate has been added to your inventory");
         ArmorShopMenuView armorMenu = new ArmorShopMenuView();
        armorMenu.display();
    }

    private void goToGameMenu() {
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display(); 
    }

    private void returnToMainMenu() {
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.display();
    }

    private void getSortFaithPoints() {
        GameControl sortFaith = new GameControl();
        sortFaith.display();
    }

    private void getSortObedPoints() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void getSortKnowPoints() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


}