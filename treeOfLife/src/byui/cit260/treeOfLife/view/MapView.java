/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import java.util.Scanner;

/**
 *
 * @author Chuck
 */
public class MapView {
    
     private final String MENU = "\n"
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
            +"\n========================================";
     
public void displayMapMenu() {
      
    char selection = ' ';
    do {
        
        System.out.println(MENU);//display the main menu
        
        String input = this.getMapInput();  //get the user selection
        selection = input.charAt(0);  //perform the action associated with the selection
        
        this.doActionMap(selection);
        
    } while (selection != 'Q'); //while the letter e has not been selected

    
    
    }     
     
    public String getMapInput() {
        boolean valid =false; //indicates if the name has been recieved
        String userInput = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //while a valid name has not been retrieved
            
            //prompt for the player's name
            System.out.println("Enter menu selection");
            
            //get the name from the keyboard and trim off the blanks
            userInput = keyboard.nextLine();
            userInput = userInput.trim();
            userInput = userInput.toUpperCase();
            
            //if the name is invalid(less than two character in length)
            if (userInput.length() < 1 || userInput.length() > 1) {
                System.out.println("Invalid selection - Must select a menu letter");
                continue; // and repeat again
            }
            break; //out of the (exit) the repitition
        }
        
        return userInput; // return the name
    
    } 

    private void doActionMap(char choice) {
        switch (choice){
            case 'T':// create and start a new game
                this.goToTempleMenu();
                break;
            case 'M': // get and start an existing game
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
            System.out.println("n*** Invalid map menu selection *** Try again");
                break;
}
}

    private void goToTempleMenu() {
        TempleMenuView templeMenu = new TempleMenuView();
        templeMenu.displayTempleMenu();
    }

    private void goToMantleMenu() {
        MantleMenuView mantleMenu = new MantleMenuView();
        mantleMenu.displayMantleMenu();
    }

    private void goToArmorShopMenu() {
        ArmorShopMenuView armorMenu = new ArmorShopMenuView();
        armorMenu.displayArmorShopMenu();
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.displayHelpMenu();
    }

    private void goToLevelMenu() {
        System.out.println("*** goToLevelMenu function called ***");
    }

    private void displayGameMenu() {
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayGameMenu();
    }

    private void returnToMainMenu() {
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.displayMenu();
    }
     
     
}
