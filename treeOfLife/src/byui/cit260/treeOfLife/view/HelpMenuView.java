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
public class HelpMenuView {
    private final String MENU = "\n"
            +"\n========================================"
            +"\n| Help Menu                            |"
            +"\n========================================"
            +"\nG - What is the goal of the game?"
            +"\nM - How to move"
            +"\nT - What is the Temple"
            +"\nP - What is the Praying Mantle"
            +"\nA - What is the Armor Shop"
            +"\nQ - Quit - Return to Main Menu"
            +"\n========================================";



public void displayHelpMenu() {
      
    char selection = ' ';
    do {
        
        System.out.println(MENU);//display the main menu
        
        String input = this.getHelpInput();  //get the user selection
        selection = input.charAt(0);  //perform the action associated with the selection
        
        this.doActionHelp(selection);
        
    } while (selection != 'E'); //while the letter e has not been selected

    
    
    }

public String getHelpInput() {
         boolean valid =false; //indicates if the name has been recieved
        String userInput = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //while a valid name has not been retrieved
            
            //prompt for the player's name
            System.out.println("Enter help menu selection");
            
            //get the name from the keyboard and trim off the blanks
            userInput = keyboard.nextLine();
            userInput = userInput.trim();
            userInput = userInput.toUpperCase();
            
            //if the name is invalid(less than two character in length)
            if (userInput.length() < 1 || userInput.length() > 1) {
                System.out.println("Invalid selection - Must select a help menu letter");
                continue; // and repeat again
            }
            break; //out of the (exit) the repitition
        }
        
        return userInput; // return the name
    
    }

 public void doActionHelp(char choice) {
        switch (choice){
            case 'G':// What is the goal of the game
                this.helpGoalOfGame();
                break;
            case 'M': // How to move
                this.helpHowToMove();
                break;
            case 'T': // What is the Temple
                this.helpTemple();
                break;
            case 'P': // What is the Praying Mantle
                this.helpMantle(); // save the current game
                break;
            case 'A': //What is the Armor Shop
                this.helpArmor(); // save the current game
                break;
            case 'Q': // Quit
                this.returnToMainMenu();
                break;
            default:
            System.out.println("n*** Invalid help menu selection *** Try again");
                break;
}

    
    }

    private void helpGoalOfGame() {
        System.out.println("*** helpGoalOfGame function called ***");
    }

    private void helpHowToMove() {
        System.out.println("*** helpHowToMove function called ***");
     }

    private void helpTemple() {
      System.out.println("*** helpTemple function called ***");
    }

    private void helpMantle() {
        System.out.println("*** helpMantle function called ***");
    }

    private void helpArmor() {
        System.out.println("*** helpArmor function called ***");
    }

    private void returnToMainMenu() {
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.displayMenu();
    
    }




}

