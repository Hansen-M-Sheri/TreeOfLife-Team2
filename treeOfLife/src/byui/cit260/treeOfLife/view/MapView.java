/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import byui.cit260.treeOfLife.model.Game;
import byui.cit260.treeOfLife.model.Location;
import byui.cit260.treeOfLife.model.Map;
import java.util.Scanner;
import treeoflife.TreeOfLife;

/**
 *
 * @author Chuck
 */
public class MapView extends View{
     public MapView(){
        super("\n"

            +"\n========================================"
            +"\n| Map Menu                             |"
            +"\n========================================" 
            +"\nT - Temple"
            +"\nM - Mantle"
            +"\nA - Armor Shop"
            +"\nL - Level Menu" 
            +"\nH - Help Menu"
            +"\nG - Game Menu"
            +"\nQ - Return to Main Menu" 
            +"\n========================================");
     }
    
     
    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase(); //convert to all upper case
        char choice = value.charAt(0); //get first character entered
        switch (choice){
            
            case 'T':// go to temple
                this.goToTempleMenu();
                break;
            case 'M': // go to the mantle
                this.goToMantleMenu();
                break;
            case 'A': // to to Armor Shop Menu
                this.goToArmorShopMenu();
                break;
            case 'C': // go to level view
                this.goToLevelMenu(); 
                break;
            case 'H': // go to the Main Menu
                this.displayHelpMenu();
                break;
            case 'G':  // Go To the Game Menu
                this.displayGameMenu(); 
                break;
            case 'Q': // Quit the Map Menu and return to the Main Menu
                this.returnToMainMenu();
                break;
            default:
            ErrorView.display("MapView","n*** Invalid map menu selection *** Try again");
                break;
}
         return true;
}

    private void goToTempleMenu() {
        //set in game that this has been visited
//        Game game = TreeOfLife.getCurrentGame().; 
//         Map map = game.getMap();
        Location  location = new Location();
         location.setVisited(true);
        TempleMenuView templeMenu = new TempleMenuView();
        templeMenu.display();
    }

    private void goToMantleMenu() {
        MantleMenuView mantleMenu = new MantleMenuView();
        mantleMenu.display();
    }

    private void goToArmorShopMenu() {
        ArmorShopMenuView armorMenu = new ArmorShopMenuView();
        armorMenu.display();
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

    private void goToLevelMenu() {
        this.console.println("*** goToLevelMenu function called ***");
    }

    private void displayGameMenu() {
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void returnToMainMenu() {
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.display();
    }
     
     
}
