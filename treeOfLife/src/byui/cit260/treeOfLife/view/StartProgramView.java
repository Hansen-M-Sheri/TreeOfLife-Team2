/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import byui.cit260.treeOfLife.control.ProgramControl;
import byui.cit260.treeOfLife.model.Players;
import java.util.Scanner;





/**
 *
 * @author Chuck
 */
public class StartProgramView {//We did not extend this class because it does not have a getInput and does not have a doAction.
  
    public void startProgram(){

    //Display the banner screen
    this.displayBanner();
       
    //Prompt the player to enter their name retrieve the name of the player
    String playersName = this.getPlayersName();
        
    //Create and save the player object
    Players player = ProgramControl.createPlayer(playersName);

    //DISPLAY a customized welcome message
    this.displayWelcomeMessage(player);
    
    
    //DISPLAY the main menu
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.display();
        
    
    
    
    
    

    }

    public void displayBanner() {
        
        System.out.println("\n\n****************************** ");
        
        System.out.println("*                                                                                                     *"
                        + "+\n* The Tree of Life Game is a text based role playing game. In this game you will have                 *"
                        + "+\n* the opportunity to choose between three characters to embark on a journey to the                    *"
                        + "+\n* Tree of Life. Your journey will begin in the land of Ambrosia taking you through                    *"
                        + "+\n* different environments from the desert, to the forest, across rivers, through                       *"
                        + "+\n* mountains in hopes of reaching your final destination, The Tree of Life.                            *");

        System.out.println("*                                                                                                     *"
                        + "+\n* As a young person you’ve learned that the Tree of Life is the destination that many                 *"
                        + "+\n* seek but not all find. It’s like finding the end of the rainbow to find a pot of gold, but          *"
                        + "+\n* instead of gold, you find a much greater gift. At the Tree of Life the vision reveals               *"
                        + "+\n* Those who reach the Tree of Life, will received the gift of everlasting knowledge of                *"
                        + "+\n* the creation of the worlds and the ultimate gift of eternal life.                                   *");

        System.out.println("*                                                                                                     *"
                        + "+\n* The journey will not be an easy one. It will require faith and the ability to stay the              *"
                        + "+\n* course despite the hardships you encounter. You will need to acquire the Armor of                   *"
                        + "+\n* God and the Shield of Faith along the way to overcome the challenges ahead. Make                    *"
                        + "+\n* sure you take the time to restore your faith by vising the temple often. Here you will              *"
                        + "+\n* be strengthened in your faith. If you take a wrong turn or explore an area that takes               *"
                        + "+\n* you from your course, you have the chance to reset by praying at the mantle where                   *"
                        + "+\n* you can repent from your poor decisions. Be careful, if you spend more time at the                  *"
                        + "+\n* praying mantle, other future opportunities may not present themselves later in your                 *"
                        + "+\n* journey. The goal is to reach the Tree of Life, but depending on your faith, you may                *"
                        + "+\n* find yourself stuck in a large and spacious building or at the Tree of Knowledge. The               *"
                        + "+\n* Tree of Knowledge only grants you one gift and if you fail to reach either tree, you                *"
                        + "+\n* will surely have been lost in the Spacious Building.                                                *");

        System.out.println("*                                                                                                     *"
                        + "+\n* Are you ready for the journey? The game begins as you choose your character. You                    *"
                        + "+\n* will start in your small thatched roof cottage in the woods. The Elder’s Scrolls are                *"
                        + "+\n* provided to you before you begin the challenge from the village elders. Here you will               *"
                        + "+\n* be receive instruction and learn of the Tree of Life. The door will open in your home,              *"
                        + "+\n* you will take your first steps outside and enter the world of Ambrosia.                             *");

        System.out.println("*                                                                                                     *"
                        + "+\n* Choose wisely, build your faith and endure to the end!                                              *");

               
    }

    public String getPlayersName() {
        boolean valid =false; //indicates if the name has been recieved
        String playersName = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //while a valid name has not been retrieved
            
            //prompt for the player's name
            System.out.println("Enter the player's name below:");
            
            //get the name from the keyboard and trim off the blanks
            playersName = keyboard.nextLine();
            playersName = playersName.trim();
            
            //if the name is invalid(less than two character in length)
            if (playersName.length() < 2) {
                System.out.println("Invalid name = the name must not be blank");
                continue; // and repeat again
            }
            break; //out of the (exit) the repitition
        }
        
        return playersName; // return the name
    }

    public void displayWelcomeMessage(Players player) {
        System.out.println("\n\n=============================");
        System.out.println("\tWelcome to the game " + player.getName());
        System.out.println("\tWe hope you have a lot of fun!");
        System.out.println("=============================");
    }
    
    
}
    

