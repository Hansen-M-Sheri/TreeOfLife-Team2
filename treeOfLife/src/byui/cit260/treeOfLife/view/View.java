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
public abstract class View implements ViewInterface{
   
    private String promptMessage;
    
    public View(String promptMessage){
        this.promptMessage = promptMessage;
    }

    public String getPromptMessage() {
        return promptMessage;
    }

    public void setPromptMessage(String promptMessage) {
        this.promptMessage = promptMessage;
    }
    
    @Override
    public void display() {
      String value;
    
    do {
        
        System.out.println(this.promptMessage);//display the prompt
        value = this.getInput();  //get the user selection
        this.doAction(value);  // do action based on selection
        
        
    } while (!value.equals("Q")); //while the letter e has not been selected
    
    }
    
    @Override 
    public String getInput() {
        
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        boolean valid =false; //indicates if the name has been recieved
        String selection = null;
        
        //while a valid name has not been retrieved
        while(!valid) { 
            
            //prompt for the player's name
            System.out.println("\t\nEnter your selection below:");
            
            //get the value entered from the keyboard
            selection = keyboard.nextLine();
            selection = selection.trim();
            selection = selection.toUpperCase();
            
            //if the name is invalid(less than two character in length)
            if (selection.length() < 1) {
                System.out.println("\n*** Invalid selection *** Try again");
                continue; // and repeat again
            }
            break; //out of the (exit) the repitition
        }
        
        return selection; // return the name
    
    }
}
