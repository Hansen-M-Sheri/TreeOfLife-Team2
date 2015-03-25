/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import treeoflife.TreeOfLife;

/**
 *
 * @author Chuck
 */
public abstract class View implements ViewInterface{
   
    private String promptMessage;
    
    protected final BufferedReader keyboard = TreeOfLife.getInFile();
    protected final PrintWriter console = TreeOfLife.getOutFile();
    
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
        
        this.console.println(this.promptMessage);//display the prompt
        value = this.getInput();  //get the user selection
        this.doAction(value);  // do action based on selection
        
        
    } while (!value.equals("Q")); //while the letter e has not been selected
    
    }
    
    @Override 
    public String getInput() {
        
       
        boolean valid =false; //indicates if the name has been recieved
        String selection = null;
        try {
        //while a valid name has not been retrieved
        while(!valid) { 
            
            //prompt for the player's name
            this.console.println("\t\nEnter your selection below:");
            
            //get the value entered from the keyboard
            selection = this.keyboard.readLine();
            selection = selection.trim();
            selection = selection.toUpperCase();
            
            //if the name is invalid(less than two character in length)
            if (selection.length() < 1) {
                ErrorView.display(this.getClass().getName(), "You must enter a value.");
               
                continue; // and repeat again
            }
            break; //out of the (exit) the repitition
        }
        }catch (Exception e) {
           ErrorView.display(this.getClass().getName(), "Error reading input "+ e.getMessage());
        }   
        return selection; // return the name
    
    }
}
