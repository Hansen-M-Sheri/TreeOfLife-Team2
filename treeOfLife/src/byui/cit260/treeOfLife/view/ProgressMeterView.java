/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import byui.cit260.treeOfLife.model.ProgressMeter;
import java.util.Scanner;

/**
 *
 * @author sherihansen
 */
public class ProgressMeterView extends View{
 public ProgressMeterView(){
        super("\n"
            +"\n======================================================"
            +"\n| Progress Meter                                      |"
            +"\n======================================================"
            +"\nL -  Current Level is ..."
            +"\nF -  Faith stats are..."
            +"\nK -  Knowledge stats are ..."
            +"\nO -  Obedience stats are ..."
            +"\nE - Armor Items Earned: "
            +"\nG - Game Menu"
            +"\nQ- Return to Main Menu"
            
            +"\n======================================================");

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
                this.displayArmorItemsEarned();
                break;
            case 'G': // display game menu
                this.displayGameMenu();              
                break;
            case 'Q': // Quit Help Menu and return to Main Menu
                this.displayMainMenu();            
                break;
            default:
            System.out.println("n*** Invalid help menu selection *** Try again");
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

    private void displayArmorItemsEarned() {
         ProgressMeter progressMeter = new ProgressMeter();
               progressMeter.getItemsEarned();
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
