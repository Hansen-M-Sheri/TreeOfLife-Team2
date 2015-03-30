/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import byui.cit260.treeOfLife.control.MapControl.SceneType;
import byui.cit260.treeOfLife.model.Game;
import byui.cit260.treeOfLife.model.Location;
import byui.cit260.treeOfLife.model.Map;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import treeoflife.TreeOfLife;

/**
 *
 * @author Chuck
 */
public class MapView extends View{
     public MapView(){
        super("\n"

            +"\n========================================"
            +"\n| Map Menu                             |"
            +"\n========================================" 
            +"\nT - Temple"
            +"\nM - Mantle"
            +"\nA - Armor Shop"
            +"\nC - Choose Level Menu" 
            +"\nH - Help Menu"
            +"\nG - Game Menu"
            +"\nL - Print List of Locations and Description"
//            +"\nQ - Return to Main Menu" 
            +"\n========================================");
     }
    
     
    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase(); //convert to all upper case
        char choice = value.charAt(0); //get first character entered
        switch (choice){
            
            case 'T':// go to temple
                this.goToTempleMenu();
                break;
            case 'M': // go to the mantle
                this.goToMantleMenu();
                break;
            case 'A': // to to Armor Shop Menu
                this.goToArmorShopMenu();
                break;
            case 'C': // go to level view
                this.goToLevelMenu(); 
                break;
            case 'H': // go to the Main Menu
                this.displayHelpMenu();
                break;
            case 'G':  // Go To the Game Menu
                this.displayGameMenu(); 
                break;
            case 'L':  // Print a list of all map locations
                this.printLocations(); 
                break;
//            case 'Q': // Quit the Map Menu and return to the Main Menu
//                this.returnToMainMenu();
//                break;
            default:
            ErrorView.display("MapView","n*** Invalid map menu selection *** Try again");
                break;
}
         return true;
}

    private void goToTempleMenu() {
        //set in game that this has been visited
//        Game game = TreeOfLife.getCurrentGame().; 
//         Map map = game.getMap();
        Location  location = new Location();
         location.setVisited(true);
        TempleMenuView templeMenu = new TempleMenuView();
        templeMenu.display();
    }

    private void goToMantleMenu() {
        MantleMenuView mantleMenu = new MantleMenuView();
        mantleMenu.display();
    }

    private void goToArmorShopMenu() {
        ArmorShopMenuView armorMenu = new ArmorShopMenuView();
        armorMenu.display();
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

    private void goToLevelMenu() {
        this.console.println("*** goToLevelMenu function called ***");
    }

    private void displayGameMenu() {
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void returnToMainMenu() {
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.display();
    }
    
    private void printLocations() {
            //prompt for and get the name of the file to save the game in
        this.console.println("\n\nEnter the file path for file where the list of locations is to be saved.");
        
        String filePath = this.getInput();
        
        try {
            ArrayList<SceneType> locations = TreeOfLife.getCurrentGame().getlocationList();
            // save the game to the specified file
            this.printScenes(locations,filePath);
        }catch(Exception ex) {
            ErrorView.display("MapLocationsView", ex.getMessage());
        }
        this.displayGameMenu();
    }

    private void printScenes(ArrayList<SceneType> locations, String filePath)  {
        try( FileOutputStream fops = new FileOutputStream(filePath)){
            ObjectOutputStream output = new ObjectOutputStream(fops);
         
       String locationList = "\n\nList of all Locations";
       
            try {
                if(locations.size() < 1) {
                    ErrorView.display(this.getClass().getName(), "There are no more items available in the Armor Shop");
                }
                else {

                    //for each item in list
                    for (SceneType item : locations) {
                        //get first letter of item name
                        char locationName = item.name().charAt(0);
                        //print first letter and description of item
                        String  locationDescription = item.getLocationDescription();
                        locationList += ("\n" + locationName + " - " + locationDescription);
                    }
               

                } 
            }catch (Exception e) {
               ErrorView.display(this.getClass().getName(), "Error reading input "+ e.getMessage());
            }

                output.writeObject(locationList); //write the locationList ArrayList out to file
                
               
            }
         catch(Exception e) {
             ErrorView.display("MapLocationsView", e.getMessage());
         }
        //check file size
        if(filePath.length()> 1){
            this.console.println("Congrats! Your location list has printed to the specified file.");
            
        }
        
    }
}

   

    