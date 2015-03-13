/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import byui.cit260.treeOfLife.model.Location;
import byui.cit260.treeOfLife.model.Map;
import byui.cit260.treeOfLife.model.MapSymbol;
import static byui.cit260.treeOfLife.model.MapSymbol.location;
import java.util.Scanner;
import treeoflife.TreeOfLife;

/**
 *
 * @author Chuck
 */
class GameMenuView extends View {
    public GameMenuView(){
        super("\n"
    
            +"\n========================================"
            +"\n| Game Menu                             |"
            +"\n========================================"
            +"\nM - Go to the Map"
            +"\nP - View Progress Meter"
            +"\nI - View Character Inventory"
            +"\nC - Choose Character for Game"              
            +"\nH - Help Menu"
            +"\nQ - Return to Main Menu" 
            +"\n========================================");
    }


    
    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase(); //convert to all upper case
        char choice = value.charAt(0); //get first character entered
        switch (choice){
            case 'M':// Go to the Map
                this.displayMapMenu();
                break;
            case 'P': // View Progress Meter
                this.viewProgressMeter();
                break;
            case 'I': // View Character Inventory
                this.viewCharacterInventory();
                break;
            case 'C':// Go to the Map
                this.displayCharacterMenu();
                break;
            case 'H': // Go to the Help Menu
                this.displayHelpMenu();
                break;
            case 'Q': // Quit and return to the Main Menu
                this.returnToMainMenu(); 
                break;
            
            default:
            System.out.println("n*** Invalid game menu selection *** Try again");
                break;
}
        return true;

    
    }

    private void displayMapMenu() {
//        MapView mapMenu = new MapView();
//        mapMenu.display();
        //get the map locations from the current game
        Map map = new Map();
       Location[][] locations = map.getLocations();
        //DISPLAY title
        System.out.println("Tree of Life Map");
        //DISPLAY row of column numbers
        System.out.println("\n    0   |   1   |   2   |   3   |");
        //FOR every row in map
            for (Location[] row : locations) {
//                 DISPLAY row divider
                System.out.println(" ------------------------------"
                                +"\n 2");
                 // FOR every column in row
                for (Location[] column: locations) {
                     // DISPLAY column divider
                    System.out.println("|\t \t \t|\t \t \t|\t \t \t|\t \t \t|");
                     Location[][] currentLocation = location[row][column];
//                    GameMenuView[][];
                    // IF location has been visited
                    Location location = new Location();
                    if(location.isVisited()) {
                        MapSymbol symbol = new MapSymbol();
                        symbol.
                    }
                    else {
                        System.out.println("??");
                    }
                }
        
          
                
            
           
               
                
                
                // DISPLAY the map symbol for location
                // ELSE
                // DISPLAY " ?? "
                // ENDIF
                // DISPLAY ending column divider
            // ENDFOR
            }
        // DISPLAY ending row divider      
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

    private void viewCharacterInventory() {
       System.out.println("*** viewInventory stub function called ***");
       //get Character inventory from purchaseList

    }
    
    
}
