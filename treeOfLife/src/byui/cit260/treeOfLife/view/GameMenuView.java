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
class GameMenuView {
    
    private final String MENU = "\n"
            +"\n========================================"
            +"\n| Game Menu                             |"
            +"\n========================================"
            +"\nM - Go to the Map"
            +"\nP - View Progress Meter"
            +"\nH - Help Menu"
            +"\nQ - Return to Main Menu" 
            +"\n========================================";
    
public void displayGameMenu() {
      
    char selection = ' ';
    do {
        
        System.out.println(MENU);//display the main menu
        
        String input = this.getGameMenuInput();  //get the user selection
        selection = input.charAt(0);  //perform the action associated with the selection
        
        this.doActionGameMenu(selection);
        
    } while (selection != 'Q'); //while the letter e has not been selected

    
    
    }    

    private String getGameMenuInput() {
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
    
    public void doActionGameMenu(char choice) {
        switch (choice){
            case 'M':// Go to the Map
                this.displayMapMenu();
                break;
            case 'P': // View Progress Meter
                this.viewProgressMeter();
                break;
            case 'H': // Go to the Help Menu
                this.displayHelpMenu();
                break;
            case 'Q': // Quit and return to the Main Menu
                this.returnToMainMenu(); 
                break;
            
            default:
            System.out.println("n*** Invalid game menu selection *** Try again");
                break;
}

    
    }

    private void displayMapMenu() {
        MapView mapMenu = new MapView();
        mapMenu.displayMapMenu(); 
    }

    private void viewProgressMeter() {
        System.out.println("*** viewProgressMeter function called ***");
    }

    private void returnToMainMenu() {
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.displayMenu(); 
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.displayHelpMenu(); 
    }
    
    
}
