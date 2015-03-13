/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

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
        ArrayList<GameInventoryItems> forSale = game.getForSale();
        //for each item in list
        for (GameInventoryItems item : forSale) {
            //get first letter of item name
            char armorPiece = item.name().charAt(0);
            //print first letter and description of item
            String armorDescription = item.getItemDescription();
            System.out.println("\n" + armorPiece + " - " + armorDescription);
        }
            
        System.out.println(
            "\nG - Game Menu"
            +"\nQ - Return to Main Menu"
            +"\n========================================");
            
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
            case 'D': // get the Shield
                this.getShield();
                break;
            case 'T': // get Belt
                this.getBelt();
                break;
            case 'F': // get Foot Covering
                this.getFootCovering(); 
                break;
            case 'S': // get Sword
                this.getSword();
                break;
            case 'B':  // get Breastplate
                this.getBreastplate(); 
                break;
            case 'G':  // go to game menu
                this.goToGameMenu(); 
                break;
            case 'Q': // Quit the Map Menu and return to the Main Menu
                this.returnToMainMenu();
                break;
            default:
            System.out.println("n*** Invalid Armor menu selection *** Try again");
                break;
        }       
        return true;
    }

    private void getHelmet() {
        System.out.println("getHelmet function called");
        //once selected either by purchase/earned 
        //remove from forSaleList arrayList
         //Below is how we will remove item from list - 
//        forSaleList.remove(GameInventoryItems.helmet);
        //add to characterInventoryList - do we need a function called createCharacterInventory?  Or just addto CharacterInventory? 
    }

    private void getShield() {
        System.out.println("getShield function called");
    }

    private void getBelt() {
        System.out.println("getBelt function called");
    }

    private void getFootCovering() {
        System.out.println("getFootCovering function called");
    }

    private void getSword() {
        System.out.println("getSword function called");
    }

    private void getBreastplate() {
        System.out.println("getBreastplate function called");
    }

    private void goToGameMenu() {
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display(); 
    }

    private void returnToMainMenu() {
       MainMenuView mainMenu = new MainMenuView();
       mainMenu.display();
    }
    


}