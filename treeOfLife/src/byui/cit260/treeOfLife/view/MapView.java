/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import byui.cit260.treeOfLife.control.MapControl;
import byui.cit260.treeOfLife.control.MapControl.SceneType;
import static byui.cit260.treeOfLife.control.MapControl.moveCharactersToLocation;
import byui.cit260.treeOfLife.model.Game;
import byui.cit260.treeOfLife.model.Location;
import byui.cit260.treeOfLife.model.Map;
import citbyui.cit260.treeOfLife.exceptions.MapControlException;
import java.awt.Point;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import treeoflife.TreeOfLife;

/**
 *
 * @author Chuck
 */
public class MapView extends View {

    public MapView() {
        super("\n"
                + "\n========================================"
                + "\n| Map Menu                             |"
                + "\n========================================"
                + "\nE - Enter Map Coordinates"
                //           +"\nT - Temple"
                //            +"\nM - Mantle"
                //            +"\nA - Armor Shop"
                //            +"\nC - Choose Level Menu" 
                + "\nH - Help Menu"
                + "\nG - Game Menu"
                + "\nL - Print List of Locations and Description"
                //            +"\nQ - Return to Main Menu" 
                + "\n========================================");
    }

    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase(); //convert to all upper case
        char choice = value.charAt(0); //get first character entered
        switch (choice) {
//
//            case 'T':// go to temple
//                this.goToTempleMenu();
//                break;
//            case 'M': // go to the mantle
//                this.goToMantleMenu();
//                break;
//            case 'A': // to to Armor Shop Menu
//                this.goToArmorShopMenu();
//                break;
//            case 'C': // go to level view
//                this.goToLevelMenu();
//                break;
            case 'H': // go to the Main Menu  
                this.displayHelpMenu();
                break;
            case 'G':  // Go To the Game Menu
                this.displayGameMenu();
                break;
            case 'L':  // Print a list of all map locations
                this.printLocations();
                break;
            case 'E':  // Print a list of all map locations
                this.enterCoordinates();
                break;
//            case 'Q': // Quit the Map Menu and return to the Main Menu
//                this.returnToMainMenu();
//                break;
            default:
                ErrorView.display("MapView", "\n*** Invalid map menu selection *** Try again");
                break;
        }
        return true;
    }

//    private void goToTempleMenu() {
//        //set in game that this has been visited
////        Game game = TreeOfLife.getCurrentGame().; 
////         Map map = game.getMap();
//        Location location = new Location();
//        location.setVisited(true);
//        TempleMenuView templeMenu = new TempleMenuView();
//        templeMenu.display();
//    }
//
//    private void goToMantleMenu() {
//        MantleMenuView mantleMenu = new MantleMenuView();
//        mantleMenu.display();
//    }
//
//    private void goToArmorShopMenu() {
//        ArmorShopMenuView armorMenu = new ArmorShopMenuView();
//        armorMenu.display();
//    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

    private void goToLevelMenu() {
        LevelView levelMenu = new LevelView();
        levelMenu.display();
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

            // save the game to the specified fil
            this.printScenes(filePath);
        } catch (Exception ex) {
            ErrorView.display("MapLocationsView", ex.getMessage());
        }
        this.displayGameMenu();
    }

    private void printScenes(String filePath) {
        try (PrintWriter output = new PrintWriter(filePath)) {

            String locationList = "\n\nList of all Locations";

            try {

                //for each item in list
                SceneType[] scenes = SceneType.values();
                for (SceneType item : scenes) {
                    //get first letter of item name
                    char locationName = item.name().charAt(0);
                    //print first letter and description of item
                    String locationDescription = item.getLocationDescription();
                    locationList += ("\n" + locationName + " - " + locationDescription);
                }

            } catch (Exception e) {
                ErrorView.display(this.getClass().getName(), "Error reading input " + e.getMessage());
            }

            output.println(locationList); //write the locationList ArrayList out to file

        } catch (Exception e) {
            ErrorView.display("MapLocationsView", e.getMessage());
        }
        //check file size
        if (filePath.length() > 1) {
            this.console.println("Congrats! Your location list has printed to the specified file.");

        }

    }

   
    private void enterCoordinates() {
        //Code to get input for map movement
        this.console.println("\n\nEnter the Coordinates to move to a different location."
                + "\nFirst enter Row Number and then Column Number."
                + "\n(Example 1,0 will take you to the Temple)");

        String value = this.getInput();
        
            String[] values = value.split("\\s*,\\s*");
            try{
                int x = Integer.parseInt(values[0]);
                int y = Integer.parseInt(values[1]);
            
        if (x < 0 || x > TreeOfLife.getCurrentGame().getMap().getRowCount()) {
            ErrorView.display("MapView", "You have entered an incorrect row number. Please enter a value between 0 and 3.");
            return;
        }
        if (y < 0 || y > TreeOfLife.getCurrentGame().getMap().getColumnCount()) {
            ErrorView.display("MapView", "You have entered an incorrect column number. Please enter a value between 0 and 2.");
            return;
        }
//        try {
        //check if location is blocked
        Location location = TreeOfLife.getCurrentGame().getMap().getLocations()[x][y];
        if(location.isBlocked() == true){
            ErrorView.display("MapView", "This location is blocked. Please try another"
                            + "\n Once you choose to leave a level you may not return to it."
                            + "\nIf temple or mantle are blocked, you must answer more level questions"
                            + "\n Answering 3 more questions will give you access. ");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMap();
        }
        else {
            //moveCharacterToLocation
            MapControl.moveCharactersToLocation(TreeOfLife.getCurrentGame().getCharacter(), new Point(x, y));
            //get location
            Location[][] locations = TreeOfLife.getCurrentGame().getMap().getLocations();
            Location currentLocation = locations[x][y];
            //display the location scene
            //display scene descrption
            String description = currentLocation.getScene().getDescriptions();
            this.console.println(description);

            
            //if (myView != null){
                
//            //}
            if (currentLocation == locations[0][2] || currentLocation == locations[1][2] || currentLocation == locations[1][1] || currentLocation == locations[2][1] || currentLocation == locations[2][2]){
               // currentLocation.getScene().setSceneView(new LevelView());
                //myView.display();
                View myView = new LevelView();
                if (myView != null){
                myView.display();
                }
            }else if (currentLocation == locations[0][0]){
                //currentLocation.getScene().setSceneView(new ArmorShopMenuView());
                View myView = new ArmorShopMenuView();
                if (myView != null){
                myView.display();
                }
            }else{
                View myView = currentLocation.getScene().getSceneView();
            if (myView != null){
                myView.display();
            }
            }   
            }
            //deterime and select scene type  
          //if ( ){
////                
//            }


                //create scene view for selected scene type
                //display scene view
                //return
          
        } catch (MapControlException ex) {
            ErrorView.display("MapView", ex.getMessage());
        }catch (NumberFormatException nfe){
                ErrorView.display("MapView", "You must enter a number, no letters please!");
            }

    }

}
