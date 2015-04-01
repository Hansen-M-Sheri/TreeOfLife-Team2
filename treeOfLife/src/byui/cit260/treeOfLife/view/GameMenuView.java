/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import byui.cit260.treeOfLife.control.GameControl;
import byui.cit260.treeOfLife.model.Location;
import byui.cit260.treeOfLife.model.Scene;
import citbyui.cit260.treeOfLife.exceptions.GameControlException;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import treeoflife.TreeOfLife;

/**
 *
 * @author Chuck
 */
public class GameMenuView extends View {
    
    public GameMenuView(){
        super("\n"
    
            +"\n========================================"
            +"\n| Game Menu                             |"
            +"\n========================================"
            +"\nM - Go to the Map"
            +"\nP - View Progress Meter"
            +"\nI - View Character Inventory"          
            +"\nH - Help Menu"
            +"\nQ - Quit the Game" 
            +"\n========================================");
    }


    
    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase(); //convert to all upper case
        char choice = value.charAt(0); //get first character entered
        switch (choice){
            case 'M':// Go to the Map
                this.displayMap();
                break;
            case 'P': // View Progress Meter
                this.viewProgressMeter();
                break;
            case 'I': {
            try {
                // View Character Inventory
                this.viewCharacterInventory();
            } catch (GameControlException ex) {
                //Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex); *** creates log for programmer on issues
                this.console.println(ex.getMessage());
            }
        }
                break;

            case 'H': // Go to the Help Menu
                this.displayHelpMenu();
                break;
            case 'Q': // Quit and return to the Main Menu
                this.returnToMainMenu(); 
                break;
            
            default:
            ErrorView.display("GameMenuView", "*** Invalid game menu selection *** Try again");
                break;
}
        return true;

    
    }
  public static void displayMap() {//changed this to public so can call this to display map from multiple menu's 
 
        //get the map locations from the current game
      Location[][]locations = TreeOfLife.getCurrentGame().getMap().getLocations();

        //DISPLAY title
        System.out.println("Tree of Life Map");
        //DISPLAY row of column numbers

        System.out.println("\n | --0-- | --1-- | --2-- | --3-- |");
        for(int i = 0; i < locations.length; i++){
//             DISPLAY row divider
                System.out.println("--------------------------------");

            String grid = i + "|";
            for(int j = 0; j<locations[i].length; j++){
                Location location = locations[i][j];
//                 
                    // IF location has been visited

                   String symbol;
                   //@todo - adding a way to show character if on spot
                   Point currentCoordinates= TreeOfLife.getCurrentGame().getCharacter().getCoordinates();
                   Location characterLocation = locations[currentCoordinates.x][currentCoordinates.y];
                   
                   if(location == characterLocation) {
                       symbol = "URHere";
                   }
                   else if(location.isVisited() ) { 
                       //get current game
                        
                       Scene scene = location.getScene();
                       symbol = scene.getMapSymbol();
                    }
                    else {
                       symbol = "?????";
                    }
//                   DISPLAY column divider
                     grid += ( " "+ symbol + " |");
            }
            System.out.println(grid);
//            System.out.println("|");
        }

        // DISPLAY ending row divider  
        System.out.println("--------------------------------");
        
        
       
        
        
        //print out map menu
    MapView mapView = new MapView(); 
    mapView.display();
        
    }

    
    private void viewProgressMeter() {
      ProgressMeterView progressMeter = new ProgressMeterView();
      progressMeter.display();
    }

    private void returnToMainMenu() {
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.display(); 
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display(); 
    }

    private void displayCharacterMenu() {
        CharacterMenuView characterMenu = new CharacterMenuView();
        characterMenu.display();
    }

    private void viewCharacterInventory() throws GameControlException {

       //get Character inventory from purchaseList
       GameControl.displayCharacterInventory();

    }

    private void displayMapMenu() {
        MapView mapMenu = new MapView();
        mapMenu.display();
    }
    
    
  
    
}
