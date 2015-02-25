/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import byui.cit260.treeOfLife.control.QuestionControl;
import java.util.Scanner;

/**
 *
 * @author sherihansen
 */
public class MantleMenuView {
    private final String MENU = "\n"
            +"\n========================================"
            +"\n| Mantle Menu                             |"
            +"\n========================================"
            +"\nA - Answer Mantle Questions"
            +"\nM - Go back to Map"
            +"\nG - Go to Game Menu"
            +"\nQ - Return to Main Menu" 
            +"\n========================================";
 
    public void displayMantleMenu() {
      
    char selection = ' ';
    do {
        
        System.out.println(MENU);//display the main menu
        
        String input = this.getMantleInput();  //get the user selection
        selection = input.charAt(0);  //perform the action associated with the selection
        
        this.doActionMantle(selection);
        
    } while (selection != 'Q'); //while the letter e has not been selected

    
    
    }  

    private String getMantleInput() {
      boolean valid =false; //indicates if the name has been recieved
        String userInput = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //while a valid name has not been retrieved
            
            //prompt for the player's name
            System.out.println("Enter Mantle menu selection");
            
            //get the name from the keyboard and trim off the blanks
            userInput = keyboard.nextLine();
            userInput = userInput.trim();
            userInput = userInput.toUpperCase();
            
            //if the name is invalid(less than two character in length)
            if (userInput.length() < 1 || userInput.length() > 1) {
                System.out.println("Invalid Mantle Menu selection - Must select a menu letter");
                continue; // and repeat again
            }
            break; //out of the (exit) the repitition
        }
        
        return userInput; // return the name
    }

    private void doActionMantle(char selection) {
          switch (selection){
           
            case 'A': // answer Mantle Questions
                this.answerMantleQuestions();
                break;
            case 'M': // display Map view
                this.displayMapView();
                break;
            case 'G': // display game menu
                this.displayGameMenu(); 
                break;
            case 'Q': // return to the  Main Menu
                this.returnToMainMenu();
                break;
            default:
            System.out.println("n*** Invalid Mantle menu selection *** Try again");
                break;
}
    }

    private void answerMantleQuestions() {
       QuestionControl mantleQuestion = new QuestionControl();
        mantleQuestion.getMantleQuestion();
    }

    private void displayMapView() {
       MapView mapMenu = new MapView();
    mapMenu.displayMapMenu(); 
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
