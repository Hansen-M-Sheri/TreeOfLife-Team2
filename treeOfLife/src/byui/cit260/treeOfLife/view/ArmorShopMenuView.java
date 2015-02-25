/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import java.util.Scanner;

/**
 *
 * @author sherihansen
 * Armor Shop
 * 
 */
public class ArmorShopMenuView {
    private final String MENU = "\n"
            +"\n========================================"
            +"\n| Armor Shop Menu                            |"
            +"\n========================================"
            +"\nH - Helmet of Salvation"
            +"\nD - Shield of Faith"
            +"\nT - Belt of Truth"
            +"\nF - Foot Coverings (Feet Shod with Gospel of Peace)"
            +"\nS - Sword"
            +"\nB - Breastplate"
            +"\nG - Game Menu"
            +"\nQ - Return to Main Menu"
            +"\n========================================";


/**
 * Displays Armor Shop Menu 
 * until "Q" is selected by user
 */
public void displayArmorShopMenu() {
      
    char selection = ' ';
    do {
        
        System.out.println(MENU);//display the main menu
        
        String input = this.getArmorInput();  //get the user selection
        selection = input.charAt(0);  //perform the action associated with the selection
        
        this.doActionArmor(selection);
        
    } while (selection != 'Q'); //while the letter e has not been selected

    
    
}
/**
 * Gets user input for Armor Shop Menu and
 * validates it is only single letter
 * @return - returns letter entered by user (if valid)
 */
    public String getArmorInput() {
         boolean valid =false; //indicates if the name has been recieved
        String userInput = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //while a valid name has not been retrieved
            
            //prompt for the player's selection
            System.out.println("Enter menu selection");
            
            //get the selection from the keyboard and trim off the blanks
            userInput = keyboard.nextLine();
            userInput = userInput.trim();
            userInput = userInput.toUpperCase();
            
            //if the selection is invalid(less than two character in length)
            if (userInput.length() < 1 || userInput.length() > 1) {
                System.out.println("Invalid selection - Must select a menu letter");
                continue; // and repeat again
            }
            break; //out of the (exit) the repetition
        }
        
        return userInput; // return the name
    }
/**
 * Validates and calls correct action for Armor Shop Menu
 * @param selection 
 */
    public void doActionArmor(char selection) {
       
        switch (selection){
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
    }

    private void getHelmet() {
        System.out.println("getHelmet function called");
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
        gameMenu.displayGameMenu(); 
    }

    private void returnToMainMenu() {
       MainMenuView mainMenu = new MainMenuView();
       mainMenu.displayMenu();
    }
    


}