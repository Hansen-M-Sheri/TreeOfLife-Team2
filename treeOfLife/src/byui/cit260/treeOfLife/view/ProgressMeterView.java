/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import byui.cit260.treeOfLife.control.GameControl;
import byui.cit260.treeOfLife.model.GameInventoryItems;
import byui.cit260.treeOfLife.model.ProgressMeter;
import citbyui.cit260.treeOfLife.exceptions.GameControlException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import treeoflife.TreeOfLife;

/**
 *
 * @author sherihansen
 */
public class ProgressMeterView extends View{
 public ProgressMeterView(){
        super("\n"
            +"\n======================================================"
            +"\n| Progress Meter                                      |"
            +"\n======================================================");
        
       
       try{
           ProgressMeter progressMeter = TreeOfLife.getCurrentGame().getProgressMeter();
         
           this.console.println(progressMeter.getDescription());
            this.console.println("\tL -  Current Level is "+ progressMeter.getCurrentLevel());
            this.console.println("\tF -  Faith stats are..."+ progressMeter.getFaithStat());
            this.console.println("\tK -  Knowledge stats are ..."+ progressMeter.getKnowledgeStat());
            this.console.println("\tO -  Obedience stats are ..." + progressMeter.getObedienceStat());
            
           this.console.println( "\nG - Game Menu"
           
            
            +"\n======================================================");
       }catch (Exception e){
           ErrorView.display(this.getClass().getName(), "Error reading input "+ e.getMessage());
       }
       
        }  

   
    @Override
     public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase(); //convert to all upper case
        char choice = value.charAt(0); //get first character entered
        switch (choice){
            case 'L':// display level of Player
                this.displayLevel();
                break;
            case 'F':// display Faith stats for player
                this.displayFaithStats();
                break;
            case 'K': // display knowledge stats for player
                this.displayKnowledeStats();
                break;
            case 'O': // display obedience stats for player
                this.displayObedienceStats();
                break;
            case 'E': // display armor items earned
               
            try {
                this.displayArmorItemsEarned();
            } catch (GameControlException e) {
//                Logger.getLogger(ProgressMeterView.class.getName()).log(Level.SEVERE, null, ex);
               ErrorView.display(this.getClass().getName(), "Error reading input: "+ e.getMessage());
            }
                break;
            case 'G': // display game menu
                this.displayGameMenu();              
                break;
//            case 'Q': // Quit Help Menu and return to Main Menu
//                this.displayMainMenu();            
//                break;
            default:
            ErrorView.display("ProgressMeterView", "****Invalid selection **** Try again");
                break;
}
                return true;

    
}

    private void displayLevel() {
        ProgressMeter progressMeter = new ProgressMeter();
               progressMeter.getCurrentLevel();
    }

    private void displayFaithStats() {
         ProgressMeter progressMeter = new ProgressMeter();
            progressMeter.getFaithStat();
    }

    private void displayKnowledeStats() {
       ProgressMeter progressMeter = new ProgressMeter();
          progressMeter.getKnowledgeStat();
    }

    private void displayObedienceStats() {
        ProgressMeter progressMeter = new ProgressMeter();
        progressMeter.getObedienceStat();
    }

    private void displayArmorItemsEarned()  throws GameControlException{
//       ArrayList<GameInventoryItems> armorItemsEarned = TreeOfLife.getCurrentGame().getPurchasedItems();
        GameControl gameControl = new GameControl();
       gameControl.displayCharacterInventory();
    }

    private void displayGameMenu() {
         GameMenuView gameMenu = new GameMenuView();
            gameMenu.display();
    }

    private void displayMainMenu() {
          MainMenuView mainMenu = new MainMenuView();
                mainMenu.display();
    }
}
