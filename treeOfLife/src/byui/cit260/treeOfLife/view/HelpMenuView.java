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
            +"\n================================================================="
            +"\n\t\t Help Menu                            "
            +"\n================================================================="
            +"\nG - Go to Game Main Menu"
            +"\nI - Info - What is the goal of the game?"
            +"\nM - How to move"
            +"\nT - What is the Temple"
            +"\nP - What is the Praying Mantle"
            +"\nA - What is the Armor Shop"
//            +"\nQ - Quit - Return to Main Menu"
            +"\n=================================================================");
    }





 @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase(); //convert to all upper case
        char choice = value.charAt(0); //get first character entered
        switch (choice){
            case 'G':// Go to Game Menu
                this.displayGameMenu();
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
//            case 'Q': // Quit Help Menu and return to Main Menu
//                this.returnToMainMenu();
//                break;
            default:
           ErrorView.display("HelpMenuView","n*** Invalid help menu selection *** Try again");
                break;
}
                return true;

    
}
 
    private void displayGameMenu() {
    GameMenuView gameMenu = new GameMenuView();
    gameMenu.display();    
    }

    private void helpGoalOfGame() {
       this.console  .println("Throughout the course of this game, you will have "
               + "\nopportunities to earn faith points (by answering questions and obtaining armor).  "
               + "\nAfter you have gone through each of the levels and answered questions to "
               + "\n demonstrate and strengthen your faith, you will be judged."
               + "\n Your goal is to reach the highest reward, that of reaching the "
               + "\n Tree of Life!!!!  "
               + "\n"
               + "\n Good luck in your journey");
    }

    private void helpHowToMove() {
        this.console  .println("In the Map, you are able to enter an option to"
                + "\nEnter Map Coordinates.  If you select this option you "
                + "\nare asked to input the location on the map you desire to go."
                + "\n The format of your location input must be"
                + "\n ROW , COLUMN in order for your input to be accepted.");
     }

    private void helpTemple() {
      this.console  .println("The Temple is a place you can go to increase your faith."
              + "\n This is done by asking you a question of how frequently you "
              + "\n have participated in a specific activity in the last 7 days. "
              + "\n After answering that, you are prompted to answer the quality of "
              + "\n your activity.  Did you perform your activity to the Best of your ability?"
              + "\n Or was it just Good?  Or maybe even Poor?"
                +"\n Based on your answers you will earn faith points."
              + "\n You are allowed to visit the temple once each level.");
    }

    private void helpMantle() {
        this.console  .println("The Mantle is a place to increase your faith through service."
                + "\n This is done by asking you how frequently you have"
                + "\n participated in a specific service activity in the last 7 days."
                + "\n Based on your answers you will earn faith points. "
                + "\n You are allowed to visit the temple once each level.");
    }

    private void helpArmor() {
        this.console  .println("The Armor Shop contains all the armor pieces available to earn."
                + "\n You can earn armor by obtaining faith points.  Each piece of armor requires a specific "
                + "\n amount of faith in order to obtain it. Once you have enough faith, you can select a"
                + "\n specific armor piece and it will be added to your personal inventory, and will "
                + "\n increase your faith even more. "
                + "\n Please note that when a piece of armor is added to your personal inventory,"
                + "\n it does NOT decrease your faith points.");
    }

    private void returnToMainMenu() {
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.display();
    
    }






}

