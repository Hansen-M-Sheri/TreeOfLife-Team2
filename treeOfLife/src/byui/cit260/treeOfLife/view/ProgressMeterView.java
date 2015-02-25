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
 */
public class ProgressMeterView {
    private final String MENU = "\n"
            +"\n======================================================"
            +"\n| Progress Meter                                      |"
            +"\n======================================================"
            +"\n Current Level is ..."
            +"\n Faith is ..."
            +"\n Knowledge is ..."
            +"\n Obedience is ..."
            +"\n Faith needed to increase in level is ...."
            +"\n Knoweldge needed to increase in level is ...."
            +"\n Obedience needed to increase in level is ...."
            +"\n Armor Items Earned: "
             +"\n items earned here "
            +"\nG - Game Menu"
            +"\nQ- Return to Main Menu"
            
            +"\n======================================================";


public void displayProgressMeterMenu() {
      
    char selection = ' ';
    do {
        
        System.out.println(MENU);//display the main menu
        
        String input = this.getProgressMeterInput();  //get the user selection
        selection = input.charAt(0);  //perform the action associated with the selection
        
        this.doActionProgressMeter(selection);
        
    } while (selection != 'Q'); //while the letter e has not been selected

    
    
}
    //just copied contents of function in - AJDUST
    private String getProgressMeterInput() {
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

    private void doActionProgressMeter(char selection) {
        System.out.println("doActionProgressMeter function called");
    }
}