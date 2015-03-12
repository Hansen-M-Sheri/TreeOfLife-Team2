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
        MapView mapMenu = new MapView();
        mapMenu.display();
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
//       //Get sorted list of inventory items
//       InventoryItem[] inventory = GameControl.getCharacterInventoryList();
//       //DISPLAY the column headings
//       System.out.println("\nList of Armor Pieces Earned"); //adjust this phrase if needed
//       System.out.println("Description" + "\t" +
//                            "Faith Stats" + "\t" +
//                            "Obedience Stats" + "\t" +
//                            "Knowledge Stats" );
////For everyitem in the inventory list
//       for(InventoryItem inventoryItem : inventory) {
//            //Display i.description, item.quantityInStock
//           System.out.println(inventoryItem.getDescription() + "\t  "+
//                              inventoryItem.getFaithStats() + "\t   " +
//                              inventoryItem.getObedienceStats())
//       }
//       
//       //ENDFOR
    }
    
    
}
