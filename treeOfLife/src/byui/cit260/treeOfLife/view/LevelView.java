/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;
import byui.cit260.treeOfLife.control.QuestionControl;
import byui.cit260.treeOfLife.model.Location;
import byui.cit260.treeOfLife.model.QuestionArray;
import byui.cit260.treeOfLife.model.Scene;
import java.awt.Point;
import treeoflife.TreeOfLife;
/**
 *
 * @author sherihansen
 */
public class LevelView extends View {
    private Point currentCoordinates;

    public LevelView() {
//        super("\n"
//  
//            +"\n========================================"
//            +"\n| Level Menu                             |"
//            +"\n========================================"
//            //+"\nR - Rest at Temple" Potential variance in game - faith dwindles with questions asked, can be restored here. What would be the consequence of not having faith?
//            +"\nA - Answer Level Questions"
//            +"\nM - Go back to Map"
//            +"\nG - Go to Game Menu"
////            +"\nQ - Return to Main Menu" 
//            +"\n========================================");
//   
//    }
    
     super("\n========================================");
     
        currentCoordinates = TreeOfLife.getCurrentGame().getCharacter().getCoordinates();
        Location location =  TreeOfLife.getCurrentGame().getMap().getLocations()[currentCoordinates.x][currentCoordinates.y];
        String description = location.getScene().getDescriptions();
        Scene levelName = location.getScene();
     
this.console.println("\n========================================"
            +"\n| "+ description + "                      |"
            +"\n========================================"
           
            +"\nA - Answer Level Questions"
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
          
            case 'A': // answer levelQuestions//              
               
                     this.answerLevelQuestions();   
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
            ErrorView.display("LevelView", "\n*** Invalid Level Menu selection *** Try again");
                break;
}
        return true;
        

    }

    private void answerLevelQuestions() {
        
        QuestionArray levelQuestion = new QuestionArray();
        //get first (in group of 3 level questions)
        int numQuestionsAnswered = levelQuestion.getNumLevelQuestionsAnswered();
        //check answer
        //loop 3 times - while numLevelQuestionAnswere <=3 continue
        while (numQuestionsAnswered <= 3) {            
            //ask a question
            //get input
            //check answer
            //assign points
        }
        this.wantMoreQuestions();
        
        
    }

    private void displayMapView() {
      GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMap();
    }

    private void displayGameMenu() {
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();     
    }

    private void wantMoreQuestions() {
        //ask for user input
    this.console.println("Would you like to (A)answer another set of questions or (C)continue to the next level?");
    //get user input
    this.getAnotherQuestionInput();
    }

    private String getAnotherQuestionInput() {
        boolean valid = false; //indicates if the input has been recieved
String response = "";
        try {
            while (!valid) { //while a valid name has not been retrieved
                  response = this.keyboard.readLine();
            break; //out of the (exit) the repitition
            }

        } catch (Exception e) { //program said it was IOException
            System.out.println("Error reading input: " + e.getMessage());
        }
        return response; // return the name

    }
       
}
