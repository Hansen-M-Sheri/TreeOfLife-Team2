/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

/**
 *
 * @author Chuck
 */
public class CharacterMenuView extends View{
    public CharacterMenuView(){
        super("\n"
            +"\n========================================"
            +"\n| Character Menu                       |"
            +"\n========================================"
            +"\nG - Go to Game Main Menu"
            +"\nN - Select Nephi"
            +"\nS - Select Sariah"
            +"\nJ - Select Jacob"
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
                this.displayGameMenu();
                break;
            case 'N':// Select Nephi as a character
                this.selectNephi();
                break;
            case 'S': // Select Sariah as a character
                this.selectSariah();
                break;
            case 'J': // Select Jacob as a character
                this.selectJacob();
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

    private void selectNephi() {
        System.out.println("*** selcectNephi function called ***");
    }

    private void selectSariah() {
        System.out.println("*** selectSariah function called ***");
     }

    private void selectJacob() {
      System.out.println("*** selectJacob function called ***");
    }

    private void returnToMainMenu() {
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.display();
    
    }






}

