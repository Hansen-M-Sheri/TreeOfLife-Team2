/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import byui.cit260.treeOfLife.control.GameControl;
import citbyui.cit260.treeOfLife.exceptions.MapControlException;
import java.util.Scanner;
import treeoflife.TreeOfLife;

/**
 *
 * @author Chuck
 */
public class MainMenuView extends View{
    
    public MainMenuView(){
        super("n"
            +"\n========================================"
            +"\n| Main Menu                            |"
            +"\n========================================"
            +"\nN - Start new game"
            +"\nG - Get and start saved game"
            +"\nS - Save game"
            +"\nQ - Quit"
            +"\n========================================");
    }



    
    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase(); //convert to all upper case
        char choice = value.charAt(0); //get first character entered
        
        switch (choice){
            case 'N':// create and start a new game
                this.startNewGame();
                break;
            case 'G': // get and start an existing game
                this.startExistingGame();
                break;
                //removing help from main menu to avoid access to game without creating new game
//            case 'H': // display the help menu
//                this.displayHelpMenu();
//                break;
            case 'S': //save the current game
                this.saveGame(); // save the current game
                break;
            case 'Q': // Exit the program
                this.console.println("Thank you for playing Tree of Life.");
                return true;
            default:
            ErrorView.display("MainMenuView","*** Invalid selection *** Try again");
                break;
}
        return true;

    
    }

    private void startNewGame()  {
      
        try{
        //Create a new Game
        GameControl.createNewGame(TreeOfLife.getPlayer());
        } catch (MapControlException me){
           ErrorView.display(this.getClass().getName(), "Error reading input: "+ me.getMessage());
        }
 
//        Display the Game Menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void startExistingGame() {
        //prompt for and get the name of the file to save the game in
        this.console.println("\n\nEnter the file path for where the game is to be saved.");
        
        String filePath = this.getInput();
        
        try{
            //start a saved game
            GameControl.getExistingGame(filePath);
        }catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        
        //display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void displayHelpMenu() {
        //Display the Game Menu
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    
    }

    private void saveGame() {
          //prompt for and get the name of the file to save the game in
        this.console.println("\n\nEnter the file path for file where the game is to be saved.");
        
        String filePath = this.getInput();
        
        try {
            // save the game to the specified file
            GameControl.saveGame(TreeOfLife.getCurrentGame(), filePath);
        }catch(Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
         }

    
    
}

   
        
       
    
    
    
    

   
