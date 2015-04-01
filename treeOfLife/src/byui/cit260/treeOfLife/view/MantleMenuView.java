/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import byui.cit260.treeOfLife.control.QuestionControl;
import byui.cit260.treeOfLife.model.Game;
import byui.cit260.treeOfLife.model.Location;
import byui.cit260.treeOfLife.model.ProgressMeter;
import byui.cit260.treeOfLife.model.QuestionArray;
import citbyui.cit260.treeOfLife.exceptions.QuestionControlException;
import java.util.Scanner;
import treeoflife.TreeOfLife;

/**
 *
 * @author sherihansen
 */
public class MantleMenuView extends View{
public MantleMenuView(){
        super("\n"
            +"\n========================================"
            +"\n| Mantle Menu                             |"
            +"\n========================================"
            +"\nA - Answer Mantle Questions"
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
           
            case 'A': // answer Mantle QuestionArray
                try{
                this.answerMantleQuestions();
                }catch (QuestionControlException qe) {
                   ErrorView.display(this.getClass().getName(), "Error reading input:"+ qe.getMessage());
                } 
                break;
            case 'M': // display Map view
                this.displayMapView();
                break;
            case 'G': // display game menu
                this.displayGameMenu(); 
                break;
//            case 'Q': // return to the  Main Menu
//                this.returnToMainMenu();
//                break;
            default:
            ErrorView.display("MantleMenuView", "*** Invalid Mantle menu selection *** Try again");
                break;
}
    return true;
    }
// private void answerMantleQuestions() throws QuestionControlException {
//    QuestionControl mantleQuestion = new QuestionControl();
//        //get question
//        mantleQuestion.getMantleQuestions();  
//        //process user's response to question
//        mantleQuestion.mantleResponse();
//        //bonus question procedure
//        mantleQuestion.templeBonusQuestionProcess();
//        //assign points templePoints to progress meter
//        //if 1st visit points go to knowledge, 2nd obedience, 3rd faith
//    
//    }
    private void answerMantleQuestions() throws QuestionControlException {
       QuestionControl mantleQuestion = new QuestionControl();
       //get first question, validate, etc
        mantleQuestion.getMantleQuestions(); 
        //increment mantleQuestions asked (this determines what stat points will be earned for
        //since numQuestions will start at 0, increment after asking first question (this will match how many quesitons have been asked)
        QuestionArray mantleQuestAsked = new QuestionArray();
        //set number of mantle questions asked to determine what stat gets points 
        int numQuestions = mantleQuestAsked.getNumMantleQuestion();
        if(numQuestions >= 3){
                // 
                mantleQuestAsked.setNumMantleQuestion(0);
            }
       
         int increment = numQuestions + 1;
        mantleQuestAsked.setNumMantleQuestion(increment);
      
       //get user's response
        int answer = mantleQuestion.mantleResponse();
    
      
        
//     int faith = TreeOfLife.getCurrentGame().getProgressMeter().getFaithStat();
      int pointsEarned = mantleQuestion.calMantlePoints(answer);
//maybe need to call calMantlePoints here, include total phrase, you just earned... points. 
       mantleQuestion.assignMantlePoints(increment, pointsEarned);
        //@todo - set this section to blocked
        Location[][] locations = TreeOfLife.getCurrentGame().getMap().getLocations();
        locations[2][0].setBlocked(true);

        this.console.println("Thank you for visiting the mantle.");
        //display mapView menu
        this.displayMapView();       //incrementMantleQuestionsAsked - do this step in getAnotherMantleQuestion? Not sure
       //add answer to combinedMantleAnswer (do this for each answer)
       
       
    }

    private void displayMapView() {
//       MapView mapMenu = new MapView();
//    mapMenu.display(); 
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMap();
    }

    private void displayGameMenu() {
        GameMenuView gameMenu = new GameMenuView();
    gameMenu.display();     
    }

    private void returnToMainMenu() {
        MainMenuView mainMenu = new MainMenuView();
    mainMenu.display();
    }

   
//    private void doActionWantContinue(String wantContinue) {
//        switch (wantContinue) {
//            case "A":
//                QuestionControl anotherQuestion = new QuestionControl();
//                anotherQuestion.getAnotherMantleQuestion();
//                break;
//            case "M":
//                QuestionArray question = new QuestionArray();
//                question.resetMantleQuestionsAsked();
//                this.display();
//                break;
//            default:
//                this.console.println("Your entry was invalid.  Please enter an A or an M");
//                this.getInput();
//                break;
//        }
//    }
//    
//    
}
