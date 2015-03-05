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
 * @author Chuck
 */
public class TempleMenuView {
    
    private final String MENU = "\n"
            +"\n========================================"
            +"\n| Temple Menu                             |"
            +"\n========================================"
            //+"\nR - Rest at Temple" Potential variance in game - faith dwindles with questions asked, can be restored here. What would be the consequence of not having faith?
            +"\nA - Answer Temple Questions"
            +"\nM - Go back to Map"
            +"\nG - Go to Game Menu"
            +"\nQ - Return to Main Menu" 
            +"\n========================================";
public void displayTempleMenu() {
      
    char selection = ' ';
    do {
        
        System.out.println(MENU);//display the main menu
        
        String input = this.getTempleInput();  //get the user selection
        selection = input.charAt(0);  //perform the action associated with the selection
        
        this.doActionTemple(selection);
        
    } while (selection != 'Q'); //while the letter e has not been selected

    
    
    }    

    private String getTempleInput() {
        boolean valid =false; //indicates if the name has been recieved
        String userInput = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //while a valid name has not been retrieved
            
            //prompt for the player's name
            System.out.println("Enter Temple menu selection");
            
            //get the name from the keyboard and trim off the blanks
            userInput = keyboard.nextLine();
            userInput = userInput.trim();
            userInput = userInput.toUpperCase();
            
            //if the name is invalid(less than two character in length)
            if (userInput.length() < 1 || userInput.length() > 1) {
                System.out.println("Invalid Temple Menu selection - Must select a menu letter");
                continue; // and repeat again
            }
            break; //out of the (exit) the repitition
        }
        
        return userInput; // return the name
    
    }

    private void doActionTemple(char choice) {
             switch (choice){
            //case 'R':// Rest at Temple and restore Faith Meter
            //  this.restAtTemple();
            //  break;
            case 'A': // get and start an existing game
                this.answerTempleQuestions();
                break;
            case 'M': // to to Armor Shop Menu
                this.displayMapView();
                break;
            case 'G': // go to level view
                this.displayGameMenu(); 
                break;
            case 'Q': // go to the Main Menu
                this.returnToMainMenu();
                break;
            default:
            System.out.println("n*** Invalid Temple Menu selection *** Try again");
                break;
}
        

    }
    
    

    //private void restAtTemple() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    private void answerTempleQuestions() {
    QuestionControl templeQuestion = new QuestionControl();
    templeQuestion.getTempleQuestions();  
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
    mainMenu.displayMenu();}
 }

    
    