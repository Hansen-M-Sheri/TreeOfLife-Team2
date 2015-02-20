/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import byui.cit260.treeOfLife.control.GameControl;
import java.util.Scanner;
import treeoflife.TreeOfLife;

/**
 *
 * @author Chuck
 */
public class MainMenuView {
    
    private final String MENU = "\n"
            +"\n========================================"
            +"\n| Main Menu                            |"
            +"\n========================================"
            +"\nN - Start new game"
            +"\nG - Get and start saved game"
            +"\nH - Get help on how to play the game"
            +"\nS - Save game"
            +"\nE - Exit"
            +"\n========================================";

public void displayMenu() {
      
    char selection = ' ';
    do {
        
        System.out.println(MENU);//display the main menu
        
        String input = this.getInput();  //get the user selection
        selection = input.charAt(0);  //perform the action associated with the selection
        
        this.doAction(selection);
        
    } while (selection != 'E'); //while the letter e has not been selected

    
    
    }

    public String getInput() {
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

    public void doAction(char choice) {
        switch (choice){
            case 'N':// create and start a new game
                this.startNewGame();
                break;
            case 'G': // get and start an existing game
                this.startExistingGame();
                break;
            case 'H': // display the help menu
                this.displayHelpMenu();
                break;
            case 'S': //save teh current game
                this.saveGame(); // save the current game
                break;
            case 'E': // Exit the program
                return;
            default:
            System.out.println("n*** Invalid selection *** Try again");
                break;
}

    
    }

    private void startNewGame() {
        System.out.println("*** startNewGame function called ***");
    
        //Create a new Game
        GameControl.createNewGame(TreeOfLife.getPlayer());
        
        //Display the Game Menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMenu();
    }

    private void startExistingGame() {
        System.out.println("*** startExistingGame function called ***");
    
    }

    private void displayHelpMenu() {
        //Display the Game Menu
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.displayHelpMenu();
    
    }

    private void saveGame() {
         System.out.println("*** saveGame function called ***");
        
    }
}

   
        
       
    
    
    
    

   
