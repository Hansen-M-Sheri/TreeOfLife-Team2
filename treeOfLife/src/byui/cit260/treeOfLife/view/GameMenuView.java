/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import byui.cit260.treeOfLife.control.GameControl;
import byui.cit260.treeOfLife.model.Game;
import byui.cit260.treeOfLife.model.Location;
import byui.cit260.treeOfLife.model.Map;
import byui.cit260.treeOfLife.model.Scene;
import java.util.Arrays;
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
                this.displayMap();
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
  public void displayMap() {//changed this to public so can call this to display map from multiple menu's 
 
        //get the map locations from the current game
      Location[][]locations = TreeOfLife.getCurrentGame().getMap().getLocations();
//      Game game = TreeOfLife.getCurrentGame();
//      Map map = game.getMap();
// 
//         Location[][] locations = map.getLocations();
        //DISPLAY title
        System.out.println("Tree of Life Map");
        //DISPLAY row of column numbers

        System.out.println("\n | --0-- | --1-- | --2-- | --3-- |");
//        String width = "-";
        int columnWidth = 6;
        int w = 0;
//            System.out.println("\n \t" +  0  +"|\t" + 1 +"|\t" + 2  + "|\t" +  3 + " |");
        for(int i = 0; i < locations.length; i++){
//             DISPLAY row divider
                System.out.println("--------------------------------");

            String grid = i + "|";
            for(int j = 0; j<locations[i].length; j++){
                Location location = locations[i][j];
//                 
                    // IF location has been visited

                   String symbol;
                   if(location.isVisited() == false) { //change to true for game, this is false to test isVisited
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
       this.displayMapMenu();
        
    }

//    private void displayMap() {
// 
//        //get the map locations from the current game
//        Map map = new Map();
//       Location[][] locations = map.getLocations();
//        //DISPLAY title
//        System.out.println("Tree of Life Map");
//        //DISPLAY row of column numbers
//        System.out.println("\n    0   |   1   |   2   |   3   |");
//
//        for (Location[] location1 : locations) {
//            //             DISPLAY row divider
//            System.out.println(" ------------------------------"
//                    +"\n 2");
//            for (Location location : location1) {
//                //                 DISPLAY column divider
//                System.out.println("|\t \t \t|\t \t \t|\t \t \t|\t \t \t|");
//                // IF location has been visited
//                System.out.println(location);
//                if(location.isVisited()) {
//                    Scene scene = new Scene();
//                    scene.getMapSymbol();
//                }
//                else {
//                    System.out.println("??");
//                }
//            }
//        }
//        // DISPLAY ending row divider  
//        System.out.println(" ------------------------------");
//    }
    
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
//       System.out.println("*** viewInventory stub function called ***");
       //get Character inventory from purchaseList
       GameControl gameControl = new GameControl();
       gameControl.displayCharacterInventory();

    }

    private void displayMapMenu() {
        MapView mapMenu = new MapView();
        mapMenu.display();
    }
    
    
}
