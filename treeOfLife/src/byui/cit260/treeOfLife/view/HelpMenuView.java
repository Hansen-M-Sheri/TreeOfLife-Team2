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
public class HelpMenuView extends View{
    public HelpMenuView(){
        super("\n"
            +"\n========================================"
            +"\n| Help Menu                            |"
            +"\n========================================"
            +"\nG - Go to Game Main Menu"
            +"\nI - Info - What is the goal of the game?"
            +"\nM - How to move"
            +"\nT - What is the Temple"
            +"\nP - What is the Praying Mantle"
            +"\nA - What is the Armor Shop"
            +"\nQ - Quit - Return to Main Menu"
            +"\n========================================");
    }





 @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase(); //convert to all upper case
        char choice = value.charAt(0); //get first character entered
        switch (choice){
            case 'G':// Go to Game Menu
                this.display();
                break;
            case 'I':// What is the goal of the game
                this.helpGoalOfGame();
                break;
            case 'M': // How to move
                this.helpHowToMove();
                break;
            case 'T': // What is the Temple
                this.helpTemple();
                break;
            case 'P': // What is the Praying Mantle
                this.helpMantle(); 
                break;
            case 'A': //What is the Armor Shop
                this.helpArmor();
                break;
            case 'Q': // Quit Help Menu and return to Main Menu
                this.returnToMainMenu();
                break;
            default:
            System.out.println("n*** Invalid help menu selection *** Try again");
                break;
}
                return true;

    
}
 
    private void displayGameMenu() {
    GameMenuView gameMenu = new GameMenuView();
    gameMenu.display();    
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
        mainMenu.display();
    
    }






}

