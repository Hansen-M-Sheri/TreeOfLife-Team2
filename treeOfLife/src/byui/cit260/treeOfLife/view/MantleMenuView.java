/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import byui.cit260.treeOfLife.control.QuestionControl;
import byui.cit260.treeOfLife.model.Questions;
import java.util.Scanner;

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
            +"\nQ - Return to Main Menu" 
            +"\n========================================");
        }   
   

   

    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase(); //convert to all upper case
        char choice = value.charAt(0); //get first character entered
          switch (choice){
           
            case 'A': // answer Mantle Questions
                this.answerMantleQuestions();
                break;
            case 'M': // display Map view
                this.displayMapView();
                break;
            case 'G': // display game menu
                this.displayGameMenu(); 
                break;
            case 'Q': // return to the  Main Menu
                this.returnToMainMenu();
                break;
            default:
            System.out.println("n*** Invalid Mantle menu selection *** Try again");
                break;
}
    return true;
    }

    private void answerMantleQuestions() {
       QuestionControl mantleQuestion = new QuestionControl();
        mantleQuestion.getMantleQuestion(); //get first question, validate, etc
        //maybe need to call calMantlePoints here, include total phrase, you just earned... points.  Would you like to answer....?
        System.out.println("Would you like to answer another mantle question? (A) or return to the Mantle Menu?(M) ");
       String wantContinue = this.getInput();
       //check if mantleQuestionsAsked > 3 if so 
//       call    antlePoints, 
//       return give message and return to menu, else ask if they would like another ?
       System.out.println("wantContinue input is: " + wantContinue);
       this.doActionWantContinue(wantContinue);
       //get answer to getAnotherMantleQuestion input
       //incrementMantleQuestionsAsked - do this step in getAnotherMantleQuestion? Not sure
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

   
    private void doActionWantContinue(String wantContinue) {
        switch (wantContinue) {
            case "A":
                QuestionControl anotherQuestion = new QuestionControl();
                anotherQuestion.getAnotherMantleQuestion();
                break;
            case "M":
                Questions question = new Questions();
                question.resetMantleQuestionsAsked();
                this.display();
                break;
            default:
                System.out.println("Your entry was invalid.  Please enter an A or an M");
                this.getInput();
                break;
        }
    }
    
    
}
