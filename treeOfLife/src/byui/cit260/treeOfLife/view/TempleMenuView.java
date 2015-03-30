/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import byui.cit260.treeOfLife.control.QuestionControl;
import citbyui.cit260.treeOfLife.exceptions.QuestionControlException;
import java.awt.Point;
import java.util.Scanner;
import treeoflife.TreeOfLife;

/**
 *
 * @author Chuck
 */
public class TempleMenuView extends View{
    public TempleMenuView(){
        super("\n"
  
            +"\n========================================"
            +"\n| Temple Menu                             |"
            +"\n========================================"
            //+"\nR - Rest at Temple" Potential variance in game - faith dwindles with questions asked, can be restored here. What would be the consequence of not having faith?
            +"\nA - Answer Temple Questions"
            +"\nM - Go back to Map"
            +"\nG - Go to Game Menu"
//            +"\nQ - Return to Main Menu" 
            +"\n========================================");
   
    }
    

    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase(); //convert to all upper case
        char choice = value.charAt(0); //get first character entered
             switch (choice){
            //case 'R':// Rest at Temple and restore Faith Meter
            //  this.restAtTemple();
            //  break;
            case 'A': // get and start an existing game//              
               
                     this.answerTempleQuestions();   
               return true;
//                break;
            case 'M': // to to Armor Shop Menu
                this.displayMapView();
                break;
            case 'G': // go to level view
                this.displayGameMenu(); 
                break;
//            case 'Q': // go to the Main Menu
//                this.returnToMainMenu();
//                break;
            default:
            ErrorView.display("TempleMenuView", "\n*** Invalid Temple Menu selection *** Try again");
                break;
}
        return true;
        

    }
    
    

    //private void restAtTemple() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    private void answerTempleQuestions()  {
    QuestionControl templeQuestion = new QuestionControl();
        //get question
        Point coordinates = TreeOfLife.getCurrentGame().getCharacter().getCoordinates();
        this.console.println("coordinates = "+ coordinates);
        try{
        //templeQuestion.getMantleOrTempleQuestion(coordinates);  
        templeQuestion.getTempleQuestions();
//process user's response to question
        templeQuestion.responseTempleQuestion();
        //bonus question procedure
        templeQuestion.templeBonusQuestionProcess();
        }catch (QuestionControlException qe){
            ErrorView.display(this.getClass().getName(), "Error reading input: "+ qe.getMessage());
             
            GameMenuView.displayMap();
        }
       
        
        //assign points templePoints to progress meter
        //if 1st visit points go to knowledge, 2nd obedience, 3rd faith
    
    }

    private void displayMapView() {
//    MapView mapMenu = new MapView();
//    mapMenu.displayMap(); 
      GameMenuView gameMenu = new GameMenuView();
      gameMenu.displayMap();
    }

    private void displayGameMenu() {
    GameMenuView gameMenu = new GameMenuView();
    gameMenu.display();     
    }

    private void returnToMainMenu() {
    MainMenuView mainMenu = new MainMenuView();
    mainMenu.display();}
 }

    
    