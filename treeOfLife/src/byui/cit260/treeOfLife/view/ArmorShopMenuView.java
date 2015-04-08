/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import byui.cit260.treeOfLife.control.GameControl;
import byui.cit260.treeOfLife.model.Game;
import byui.cit260.treeOfLife.model.GameInventoryItems;
import java.io.PrintWriter;
import java.util.ArrayList;
import treeoflife.TreeOfLife;

/**
 *
 * @author sherihansen
 * Armor Shop
 * 
 */
public class ArmorShopMenuView extends View{
    //go to the Game, get the forSaleList to see what is still available
    public ArmorShopMenuView(){
        
        super("\n=================================================================");
            this.console.println("\n================================================================="
            +"\n\t\t Armor Shop Menu                            "
            +"\n=================================================================");
        //get the list of forsale items from the game
        Game game = TreeOfLife.getCurrentGame();
        try{
        ArrayList<GameInventoryItems> forSale = game.getForSale();
       
        if(forSale.size() < 1) {
            ErrorView.display(this.getClass().getName(), "There are no more items available in the Armor Shop");
        }
        else {
            
            //for each item in list
            for (GameInventoryItems item : forSale) {
                //get first letter of item name
                char armorPiece = item.name().charAt(0);
                //print first letter and description of item
                String armorDescription = item.getItemDescription();
                this.console.println("\n" + armorPiece + " - " + armorDescription);
            }

            this.console.println(
                "\nF - Sort Faith Points"
//                +"\n"
//                +"\nO - Sort Obedience Points"
//                +"\n"
//                +"\nK - Sort Knowledge Points" 
                +"\n"
                +"\nR - Print Armor items available and items purchased"        
                +"\n"
                +"\nM - Go back to Map"        
                 //+"\nQ - Return to Main Menu"      
                );
        } 
        }catch (Exception e) {
           ErrorView.display(this.getClass().getName(), "Error reading input "+ e.getMessage());
        }
    }


//go to game, get for sale list


/**
 * Validates and calls correct action for Armor Shop Menu
 * @param selection 
 */
   
    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase(); //convert to all upper case
        char choice = value.charAt(0); //get first character entered
       int currentFaithPoints = TreeOfLife.getCurrentGame().getProgressMeter().getFaithStat();
        switch (choice){
            case 'H':// get Helmet
                 if(currentFaithPoints <= 650) {
                    this.console.println("You need atleast 650 faith points to be able to get this item.  ");
                }
                else {
                this.getHelmet();
                 }
                break;
            case 'P': // get the ProtectiveShield
                 if(currentFaithPoints <=160) {
                    this.console.println("You need atleast 160 faith points to be able to get this item.  ");
                }
                else {
                this.getShield();
                 }
                break;
            case 'T': // get TruthBelt
                //check if enough faith points, if so earn belt
                if(currentFaithPoints <= 75) {
                    this.console.println("You need atleast 75 faith points to be able to get this item.  ");
                }
                else {
                this.getBelt();
                }
                break;
            case 'B': // get Boots
                 if(currentFaithPoints <= 480) {
                    this.console.println("You need atleast 480 faith points to be able to get this item.  ");
                }
                else {
                this.getBoots();
                 }
                break;
            case 'S': // get Sword
                if(currentFaithPoints <= 350) {
                    this.console.println("You need atleast 350 faith points to be able to get this item.  ");
                }
                else {
                this.getSword();
                }
                break;
            case 'I':  // get IronBreastplate
                if(currentFaithPoints <= 950) {
                    this.console.println("You need atleast 950 faith points to be able to get this item.  ");
                }
                else {
                this.getIronBreastplate(); 
                }
                break;
            case 'F':  // get FaithPoints
                this.getSortFaithPoints(); 
                break;
//            case 'O':  // get ObedientPoints
//                this.getSortObedPoints(); 
//                break;
//            case 'K':  // get KnowledgePoints
//                this.getSortKnowPoints(); 
//                break;
            case 'R':  // print list of items available and purchased
                this.printInventory(); 
                break;
            case 'M': // to to Armor Shop Menu
                this.displayMapView();
                break;
            
            default:
            ErrorView.display("ArmorShopMenuView ","\n*** Invalid Armor menu selection *** Try again");
                break;
        }       
        return true;
    }

    private void getHelmet() {

        //once selected either by purchase/earned 
        //remove from forSaleList arrayList
        Game game = TreeOfLife.getCurrentGame();
        game.getForSale().remove(GameInventoryItems.Helmet);
        if(game.getPurchasedItems() == null){
            ArrayList<GameInventoryItems> purchaseItems = new ArrayList<>();
           purchaseItems.add(GameInventoryItems.Helmet);
            game.setPurchasedItems(purchaseItems);
  
        }
        else {
        //add to purchased list
        game.getPurchasedItems().add(GameInventoryItems.Helmet);
        //add armor faith points to progressMeter
        int faith = GameInventoryItems.Helmet.getFaithPoints();
        int currentFaith = TreeOfLife.getCurrentGame().getProgressMeter().getFaithStat();
        TreeOfLife.getCurrentGame().getProgressMeter().setFaithStat(faith + currentFaith);
        }
        this.console.println("Your helmet has been added to your inventory");
        ArmorShopMenuView armorMenu = new ArmorShopMenuView();
        armorMenu.display();
        
    }

    private void getShield() {
//        this.console.println("getShield function called");
        Game game = TreeOfLife.getCurrentGame();
        game.getForSale().remove(GameInventoryItems.ProtectiveShield);
        if(game.getPurchasedItems() == null){
            ArrayList<GameInventoryItems> purchaseItems = new ArrayList<>();
           purchaseItems.add(GameInventoryItems.ProtectiveShield);
            game.setPurchasedItems(purchaseItems);
        }
        else {
        //add to purchased list
        game.getPurchasedItems().add(GameInventoryItems.ProtectiveShield);
        int faith = GameInventoryItems.ProtectiveShield.getFaithPoints();
        int currentFaith = TreeOfLife.getCurrentGame().getProgressMeter().getFaithStat();
        TreeOfLife.getCurrentGame().getProgressMeter().setFaithStat(faith + currentFaith);
        }
        this.console.println("Your Shield has been added to your inventory");
         ArmorShopMenuView armorMenu = new ArmorShopMenuView();
        armorMenu.display();
    }

    private void getBelt() {
//        this.console.println("getBelt function called");
        Game game = TreeOfLife.getCurrentGame();
        game.getForSale().remove(GameInventoryItems.TruthBelt);
        if(game.getPurchasedItems() == null){
            ArrayList<GameInventoryItems> purchaseItems = new ArrayList<>();
           purchaseItems.add(GameInventoryItems.TruthBelt);
            game.setPurchasedItems(purchaseItems);
        }
        else {
        //add to purchased list
        game.getPurchasedItems().add(GameInventoryItems.TruthBelt);
        int faith = GameInventoryItems.TruthBelt.getFaithPoints();
        int currentFaith = TreeOfLife.getCurrentGame().getProgressMeter().getFaithStat();
        TreeOfLife.getCurrentGame().getProgressMeter().setFaithStat(faith + currentFaith);
        }
         this.console.println("Your Belt has been added to your inventory");
         ArmorShopMenuView armorMenu = new ArmorShopMenuView();
        armorMenu.display();
    }

    private void getBoots() {

        Game game = TreeOfLife.getCurrentGame();
        game.getForSale().remove(GameInventoryItems.Boots);
        if(game.getPurchasedItems() == null){
            ArrayList<GameInventoryItems> purchaseItems = new ArrayList<>();
           purchaseItems.add(GameInventoryItems.Boots);
            game.setPurchasedItems(purchaseItems);
        }
        else {
        //add to purchased list
        game.getPurchasedItems().add(GameInventoryItems.Boots);
        int faith = GameInventoryItems.Boots.getFaithPoints();
        int currentFaith = TreeOfLife.getCurrentGame().getProgressMeter().getFaithStat();
        TreeOfLife.getCurrentGame().getProgressMeter().setFaithStat(faith + currentFaith);
        }
         this.console.println("Your Boots have been added to your inventory");
         ArmorShopMenuView armorMenu = new ArmorShopMenuView();
        armorMenu.display();
    }

    private void getSword() {

        Game game = TreeOfLife.getCurrentGame();
        game.getForSale().remove(GameInventoryItems.Sword);
       if(game.getPurchasedItems() == null){
            ArrayList<GameInventoryItems> purchaseItems = new ArrayList<>();
           purchaseItems.add(GameInventoryItems.Sword);
            game.setPurchasedItems(purchaseItems);
        }
        else {
        //add to purchased list
        game.getPurchasedItems().add(GameInventoryItems.Sword);
        int faith = GameInventoryItems.Sword.getFaithPoints();
        int currentFaith = TreeOfLife.getCurrentGame().getProgressMeter().getFaithStat();
        TreeOfLife.getCurrentGame().getProgressMeter().setFaithStat(faith + currentFaith);
        }
          this.console.println("Your Sword has been added to your inventory");
         ArmorShopMenuView armorMenu = new ArmorShopMenuView();
        armorMenu.display();
    }

    private void getIronBreastplate() {

        Game game = TreeOfLife.getCurrentGame();
        game.getForSale().remove(GameInventoryItems.IronBreastPlate);
        if(game.getPurchasedItems() == null){
            ArrayList<GameInventoryItems> purchaseItems = new ArrayList<>();
           purchaseItems.add(GameInventoryItems.IronBreastPlate);
            game.setPurchasedItems(purchaseItems);
        }
        else {
        //add to purchased list
        game.getPurchasedItems().add(GameInventoryItems.IronBreastPlate);
        int faith = GameInventoryItems.IronBreastPlate.getFaithPoints();
        int currentFaith = TreeOfLife.getCurrentGame().getProgressMeter().getFaithStat();
        TreeOfLife.getCurrentGame().getProgressMeter().setFaithStat(faith + currentFaith);
        }
         this.console.println("Your Iron Breast Plate has been added to your inventory");
         ArmorShopMenuView armorMenu = new ArmorShopMenuView();
        armorMenu.display();
    }

    private void goToGameMenu() {
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display(); 
    }

    private void returnToMainMenu() {
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.display();
    }

    private void getSortFaithPoints() {
        GameControl sortFaith = new GameControl();
        sortFaith.display();
    }

//    private void getSortObedPoints() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private void getSortKnowPoints() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    private void printInventory() {
            //prompt for and get the name of the file to save the game in
        this.console.println("\n\nEnter the file path where Inventory List will be saved.");
        
        String filePath = this.getInput();
        
        try {
            ArrayList<GameInventoryItems> forSale = TreeOfLife.getCurrentGame().getForSale();
            ArrayList<GameInventoryItems> purchasedItems = TreeOfLife.getCurrentGame().getPurchasedItems();
            // save the game to the specified file
            this.printItems(forSale, purchasedItems, filePath);
        }catch(Exception ex) {
            ErrorView.display("ArmorShopMenuView", ex.getMessage());
        }
      ArmorShopMenuView armorMenu = new ArmorShopMenuView();
        armorMenu.display();
    }

    private void printItems(ArrayList<GameInventoryItems> forSale, ArrayList<GameInventoryItems> purchasedItems, String filePath) {
//        try( FileOutputStream fops = new FileOutputStream(filePath)){
//            ObjectOutputStream output = new ObjectOutputStream(fops);
         try (PrintWriter output = new PrintWriter(filePath)) {
             
       String armorShopList = "\n\nArmor Inventory";
//       String armorPurchaseList = "\n\n\nPurchased Armor Items";
            try {
                if(forSale.size() < 1) {
                    ErrorView.display(this.getClass().getName(), "There are no more items available in the Armor Shop");
                }
                else {

                    //for each item in list
                    for (GameInventoryItems item : forSale) {
                        //get first letter of item name
                        char armorPiece = item.name().charAt(0);
                        //print first letter and description of item
                        String armorDescription = item.getItemDescription();
                        armorShopList += ("\n" + armorPiece + " - " + armorDescription);
                    }
                }
//                if(purchasedItems.size() < 1) {
//                    ErrorView.display(this.getClass().getName(), "You have not purchased any armor pieces yet");
//                }
//                else {
//
//                    //for each item in list
//                    for (GameInventoryItems item : purchasedItems) {
//                        //get first letter of item name
//                        char armorPiece = item.name().charAt(0);
//                        //print first letter and description of item
//                        String armorDescription = item.getItemDescription();
//                        armorPurchaseList +=("\n" + armorPiece + " - " + armorDescription);
//                    }
//
//
//                } 
            }catch (Exception e) {
               ErrorView.display(this.getClass().getName(), "Error reading input "+ e.getMessage());
            }

//                output.writeObject(armorShopList); //write the forSale ArrayList out to file
//                output.writeObject(armorPurchaseList); 
               output.println(armorShopList);
            }
         catch(Exception e) {
             ErrorView.display("ArmorShopMenuView", e.getMessage());
         }
        //check file size
        if(filePath.length()> 1){
            this.console.println("Congrats! Your list has printed to the specified file.");
            
        }
        
    }

    private void displayMapView() {
      GameMenuView gameMenu = new GameMenuView();
      gameMenu.displayMap();
    }
    


}