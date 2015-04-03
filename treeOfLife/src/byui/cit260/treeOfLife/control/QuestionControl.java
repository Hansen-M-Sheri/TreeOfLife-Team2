/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.control;

import byui.cit260.treeOfLife.model.Game;
import byui.cit260.treeOfLife.model.Location;
import byui.cit260.treeOfLife.model.Map;
import byui.cit260.treeOfLife.model.QuestionArray;
import byui.cit260.treeOfLife.view.ErrorView;
import byui.cit260.treeOfLife.view.GameMenuView;
import byui.cit260.treeOfLife.view.TempleMenuView;
import citbyui.cit260.treeOfLife.exceptions.QuestionControlException;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import treeoflife.TreeOfLife;

/**
 *
 * @author Chuck
 */
public class QuestionControl {

    protected final BufferedReader keyboard = TreeOfLife.getInFile();
    protected final PrintWriter console = TreeOfLife.getOutFile();

    private static int totalQuestionsAsked;
    private int bonus;
    private int pointValuePerQuestion;
    private int questionPoints;
    private int actionPoints;
    private int qualityPoints;
    private int templeQuestionPoints;
    private int answeredCorrect;
    private int mantleQuestionPoints;
    private int actionRange = 0;
    private int qualityRange = 0;
    private int combinedMantleAnswer;
    private String bonusAnswer;

    //private String BONUS;
    public QuestionControl() {
    }

    /**
     * This function calculates the points earned within a level
     *
     * @param answeredCorrect
     * @param totalQuestionsAsked
     * @return integer questionPoints User must answer set of 3 questions
     * correctly to earn a bonus.
     *
     */
    public int calLevelQuestionPoints(int answeredCorrect, int totalQuestionsAsked) throws QuestionControlException {
        //if to few questions or too many are asked, return error
        if (totalQuestionsAsked < 3 || totalQuestionsAsked > 9) {

            throw new QuestionControlException("You must answer 3 questions, but no more than 9 questions");
        } //if questions asked is within range, determine bonus points earned
        else {
            if (answeredCorrect < 3) {
                bonus = 0;
            } else if (answeredCorrect >= 3 && answeredCorrect < 6) {
                bonus = 1;
            } else if (answeredCorrect >= 6 && answeredCorrect < 10) {
                bonus = 3;
            }
        }
        pointValuePerQuestion = 5;

        //multiply how many questions were answered correctly by pointValue per
        //question and add bonus points earned
        questionPoints = answeredCorrect * pointValuePerQuestion + bonus;
        return questionPoints;
    }

    /**
     * This function calculates how many points earned in temple
     *
     * @param actionRange
     * @param qualityRange
     * @return templeQuestionPoints (integer) At each visit to temple, user will
     * be asked two questions. 1st based on action performed this week 2nd based
     * on quality of action (ie: good, better, best) Their answer will fall into
     * a range for action and quality For each range a point value is assigned
     * Bonus points are available for any combo where highest range is hit if
     * highest range in both categories is achieved , larger bonus occurs Range
     * options are 1,2,3 with 3 being highest
     */
    public int calTemplePoints(int actionRange, int qualityRange) throws QuestionControlException {

        //determine actionRange and set actionPoints
        if (actionRange == 1) {
            actionPoints = 0;
        } else if (actionRange == 2) {
            actionPoints = 1;
        } else if (actionRange == 3) {
            actionPoints = 2;
        } else {
//            return -1;
            throw new QuestionControlException("Invalid Selection. You must select 1, 2, or 3, to continue");
        }
        //verify qualityRange is valid & set qualityPoints
        if (qualityRange < 1 || qualityRange > 3) {
            throw new QuestionControlException("Invalid Selection. You must select 1, 2, or 3, to continue");
        } else {
            //points will be 1, 2, or 3 ; same integer as qualityRange
            qualityPoints = qualityRange;

        }

        //determine bonus points
        if (actionRange == 3 && qualityRange == 3) {
            bonus = 3;
        } else if (actionRange == 3 || qualityRange == 3) {
            bonus = 2;
        } else {
            bonus = 1;
        }
        templeQuestionPoints = (actionPoints + qualityPoints) * bonus;
        System.out.println("Congratulations! You just earned " + templeQuestionPoints + " points");
        return templeQuestionPoints;
    }

    /**
     * This function assigns points for Temple questions (replaces
     * calMantlePoints For 1st question asked at temple - points will be earned
     * for knowledge For 2nd question asked at temple - points will be earned
     * for obedience for 3rd question asked at temple - points will be earned
     * for faith
     *
     * @param numTempleQuestions
     * @param templeQuestionPoints
     * @param int templeQuestionPoints is calculated in calTemplePoints
     */
    public void assignTemplePoints(int numTempleQuestions, int templeQuestionPoints) {
        switch (numTempleQuestions) {
            case 1:
                int knowledge = TreeOfLife.getCurrentGame().getProgressMeter().getKnowledgeStat();
                int currentKnowStat = knowledge + templeQuestionPoints; //@todo - need to set correct amount for 1st visit
                TreeOfLife.getCurrentGame().getProgressMeter().setKnowledgeStat(currentKnowStat);

                break;
            case 2:
                int obedience = TreeOfLife.getCurrentGame().getProgressMeter().getObedienceStat();
                int currentObedStat = obedience + templeQuestionPoints; //@todo - need to set correct amount for 1st visit
                TreeOfLife.getCurrentGame().getProgressMeter().setObedienceStat(currentObedStat);

                break;
            case 3:
                int faith = TreeOfLife.getCurrentGame().getProgressMeter().getFaithStat();
                int currentFaithStat = faith + templeQuestionPoints; //@todo - need to set correct amount for 1st visit
                TreeOfLife.getCurrentGame().getProgressMeter().setFaithStat(currentFaithStat);

                break;
        }
    }

    /**
     * This function assigns points for Mantle questions (replaces
     * calMantlePoints For 1st question asked at mantle - points will be earned
     * for faith For 2nd question asked at mantle - points will be earned for
     * knowledge for 3rd question asked at mantle - points will be earned for
     * obedience
     */
    public void assignMantlePoints(int numMantleQuestions, int pointsEarned) {

        switch (numMantleQuestions) {
            case 1:
                int faith = TreeOfLife.getCurrentGame().getProgressMeter().getFaithStat();
//             System.out.println("getFaithStat returns "+ faith);
                int currentFaithStat = faith + pointsEarned; //@todo - need to set correct amount for 1st visit
                TreeOfLife.getCurrentGame().getProgressMeter().setFaithStat(currentFaithStat);
                this.console.println("Congratulations!  You just increased your faith by " + pointsEarned);
                break;
            case 2:
                int knowledge = TreeOfLife.getCurrentGame().getProgressMeter().getKnowledgeStat();
                int currentKnowStat = knowledge + pointsEarned; //@todo - need to set correct amount for 1st visit
                TreeOfLife.getCurrentGame().getProgressMeter().setKnowledgeStat(currentKnowStat);
                this.console.println("Congratulations!  You just increased your knowledge by " + pointsEarned);
                break;
            case 3:
                int obedience = TreeOfLife.getCurrentGame().getProgressMeter().getObedienceStat();
                int currentObedStat = obedience + pointsEarned; //@todo - need to set correct amount for 1st visit
                TreeOfLife.getCurrentGame().getProgressMeter().setObedienceStat(currentObedStat);
                this.console.println("Congratulations!  You just increased your obedience by " + pointsEarned);
                break;
            default:
//               System.out.println("your number of questions is " + numMantleQuestions);
                break;
        }
    }

    /*Questions require 0 -7 answer
     User enters in a value between 0 and 7. Points awarded based on answer
     */
    public int calMantlePoints(int answer) {
        int pointsEarned = 0;
        if (answer > 0 && answer < 3) {
            pointsEarned = 15;
        } else if (answer >= 3 && answer < 6) {
            pointsEarned = 25;
        } else {
            pointsEarned = 50;
        }
        return pointsEarned;

    }

    /**
     * This function calculates how many points earned in mantle
     *
     * @param answeredCorrect
     * @param totalQuestionsAsked
     * @return mantleQuestionPoints (integer) At each visit to mantle, user will
     * be asked one question type. How many days out of seven did the user
     * complete, do or provide service, etc. By coming to the Mantle and taking
     * one question - user automatically gets 5 points. Depending on the answer,
     * the can get a bonus of 0, 1, 3 or 5 points. Calculations is total
     * questions asked multiplied by the point value per question at 5 plus
     * their bonus earned. Answering outside the parameters of 0-7 will result
     * in an error. Once at the mantle, if you try and leave before the question
     * is asked, it will return an error. Once at the mantle, if you try and
     * answer more than three questions, it will return an error. The mantle
     * will be used to regain faith points lost during the game.
     */
//    public int calMantlePoints(int answerAverage, int mantleQuestionsAsked) throws QuestionControlException {
//        //if too few questions or too many are asked, return error
//        if(mantleQuestionsAsked <= 0 || mantleQuestionsAsked> 3){
////            return -1;
//             throw new QuestionControlException("Invalid number of Questions answered. Must be between 0  & 3");
//        
//        
//        //Each question is service based. 
//        //The questions will require the user to enter a number 0-7
//        //Example – How many days in the last seven days did you provide service to a neighbor or friend? 
//        //User enters in a value between 0 and 7. Bonus 0 for <3, Bonus 1 for 3-4, bonus 3 for 5-6, 5 point bonus for 7
//
//        }else{
//        //If you answer less than zero, return error
//            if(answerAverage <0){
////                return -1;
//                throw new QuestionControlException("Invalid average number of questions answered");
//        }
//        // bonus structure for the correct expexted response from user if answered between 0 and 2 is zero bonus point
//            else if(answerAverage < 3){
//            bonus = 0;
//        
//        }
//        // bonus structure for the correct expexted response from user if answered between 3 and 4 is one bonus point
//            else if(answerAverage >= 3 && answerAverage < 5) {
//            bonus = 1;
//            
//        }
//        // bonus structure for the correct expexted response from user if answered between 5 and 6 is three bonus points
//            else if(answerAverage >= 5 && answerAverage < 7) {
//            bonus = 3;
//        }
//        // bonus structure for the correct expexted response from user if answered 7 is 5 bonus points 
//            else if(answerAverage == 7) {
//            bonus = 5;
//            
//        }
//        // return error if the user answers more than 7.
//            else if(answerAverage > 7){
////                return -1;
//                throw new QuestionControlException("Invalid answer. Must be less than 7");
//        }
//                
//            
//        
//          
//    }       //total points per question asked
//        pointValuePerQuestion = 5;	
//        
//        //calculations to determine the points during your session at the Mantle
//        mantleQuestionPoints = mantleQuestionsAsked * pointValuePerQuestion + bonus;
//        return mantleQuestionPoints;
//    
//    }   
//
    public void getTempleQuestions() throws QuestionControlException {

        //check isBlocked - determine how we determine block and not blocked to answer questions
        Location[][] locations = TreeOfLife.getCurrentGame().getMap().getLocations();

        if (locations[1][0].isBlocked() == true) {
            System.out.println("Sorry, you need to answer more level questions before you can answer an additional Temple question.");
            // if blocked return to map
            GameMenuView gameMenu = new GameMenuView();
            gameMenu.displayMap();
        } else {
            //get next question
            QuestionArray question = new QuestionArray();
            String nextQuestion = question.getNextQuestion(QuestionArray.QuestionType.temple);
            if (nextQuestion.isEmpty() || nextQuestion == null) {
                throw new QuestionControlException("Question is empty");
            } else {
                System.out.println(nextQuestion);

            }
        }
    }

    public void getMantleQuestions() throws QuestionControlException {

        //check isBlocked - determine how we determine block and not blocked to answer questions
        Location[][] locations = TreeOfLife.getCurrentGame().getMap().getLocations();

        if (locations[2][0].isBlocked() == true) {
            ErrorView.display("QuestionControl", "Sorry, you need to answer more level questions before you can answer an additional Mantle questions.");
            // if blocked return to map
            GameMenuView gameMenu = new GameMenuView();
            gameMenu.displayMap();
        } else {
            //get next question
            QuestionArray question = new QuestionArray();
            String nextQuestion = question.getNextQuestion(QuestionArray.QuestionType.mantle);
            if (nextQuestion.isEmpty() || nextQuestion == null) {
                throw new QuestionControlException("Question is empty");
            } else {
                System.out.println(nextQuestion);

            }
        }
    }
//    getTempleQuestion and getMantleQuestion are almost duplicates - this would be more efficient if we can get it workingsher
    //work on this to avoid duplication - nextQuestion isn't liking questionEnum - how to call a passed parameter enum?
//    public void getMantleOrTempleQuestion(Point coordinates) throws QuestionControlException {
////       boolean currentLocationIsBlocked = false; 
//       String message = " ";
//       
////       switch(questionEnum){
////           case temple:
////                //check isBlocked - determine how we determine block and not blocked to answer questions
////                Location[][] locations = TreeOfLife.getCurrentGame().getMap().getLocations();
////                currentLocationIsBlocked = locations[1][0].isBlocked();
////                message = "Sorry, you need to answer more level questions before you can answer any more Temple questions";
////               break;
////           case mantle:
////                locations = TreeOfLife.getCurrentGame().getMap().getLocations();
////                currentLocationIsBlocked = locations[2][0].isBlocked();
////                message = "Sorry, you need to answer more level questions before you can answer any more Mantle questions";
////               break;
////               
////           default:
////               break;
////          
////       } 
//      
//       Location location = TreeOfLife.getCurrentGame().getMap().getLocations()[coordinates.x][coordinates.y];
//        System.out.println("location = "+ location);
//       if(location.isBlocked()) {
//           throw new QuestionControlException("Sorry you need to answer more level questions before you can answer any more questions here.");
//           // if blocked return to map
////           GameMenuView gameMenu = new GameMenuView();
////            gameMenu.displayMap();
//           
//        }
//        else {
//            //get next question
//            QuestionArray question = new QuestionArray();
//            String nextQuestion = question.getNextQuestion(QuestionArray.QuestionType.temple);
//            if(nextQuestion.isEmpty() || nextQuestion == null) {
//                throw new QuestionControlException("Question is empty");
//            }
//            else {
//                System.out.println(nextQuestion);
//            
//            }
//        }
//    }
    // this function deals with verifying response of user to templeQuestion

    public void responseTempleQuestion() throws QuestionControlException {

        //get answer from user
        int templeAnswer = this.getUserInput();

        //validate answer and provide response
        this.doActionTempleQuestions(templeAnswer);
    }

    public void templeBonusQuestionProcess() throws QuestionControlException {

        //ask follow up question for bonus
        this.displayBonusQuestion();

        //validate answer and provide response
        int bonusAnswer = this.getUserInput();

        //        this.doActionTempleBonus(bonusAnswer); // working on calling point functions.
//                boolean bonusValid = this.doActionBonusQuestions(bonusAnswer);
        this.doActionBonusQuestions(bonusAnswer);
        //        generate response by calling calTemplePoints function
        int templePoints = this.calTemplePoints(actionRange, qualityRange);

        int numTempleQuestion = QuestionArray.getNumTempleQuestion();

        this.assignTemplePoints(numTempleQuestion, templePoints);

        //set temple to be blocked (until 3 more level questions are asked)
        Location[][] locations = TreeOfLife.getCurrentGame().getMap().getLocations();
        locations[1][0].setBlocked(true);

        //return to game menue after finishing up temple questions
        this.console.println("Thank you for coming to the Temple. "
                +"\nYou will not be able to visit the temple again until you "
                + "\n have answered 3 level questions."
                +" \nTo help you continue your journey you will"
                +"\n be taken to the game menu.");

//                this.askReturnToGameMenu(); //this is repeating what is done in next method
//                int returnGameMenu = this.getUserInput();
//                
//                this.doActionReturnToGame(returnGameMenu);
        //        display string "You achieved XXX number of days with XXX effort and are rewarded with Call calTemplePoints"
//                System.out.println("Based on your response, you have increased your obedience meter by " + templePoints + ".");
        //        display prompt "Enter Q to retun to Temple Menu"
//                System.out.println("Enter Q to return to the Temple Menu");
        //return to temple menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
//                //validate response for returning to Temple Menu
//                String returnTempleMenu = this.displayTempleMenu();

    }

//    private void displayQuestion(int randomNum) {
//        
//        if (randomNum == 1){
//            System.out.println("How many days out of the last seven days did you read the book of Mormon?");
//        }
//        else if (randomNum ==2){
//            System.out.println("How many days out of the last seven days did you have your personal prayers?");
//        }
//    }   
    
    public int getUserInput() {
        boolean valid = false; //indicates if the input has been recieved

        int response = 0;
        try {
            while (!valid) { //while a valid name has not been retrieved

            //prompt for user input for a value between 0 through 7
//            this.console.println("Enter a value between 0 through 7 for the number of days you completed the activity.");
                //get the name from the keyboard and trim off the blanks
                //userInput = keyboard.nextLine();
//            if(keyboard.hasNextInt()) {
//            int response = this.keyboard.read();
                String userResponse = this.keyboard.readLine();
                //convert to int
                response = Integer.parseInt(userResponse);
//                this.console.println("response = "+ response);
//                if(response >= 0 || response <= 7) { //using this one because it is an int
//                    userInput = this.keyboard.read();
                //userInput = userInput.trim();
                //userInput = userInput.toUpperCase();
//                }
//                else {
//                    this.console.println("Invalid selection - Must select a nubmer between 0 and 7.");
//                    this.getUserInput();
//                }
//        
//            //if the input is invalid
//            //if (userInput.length() < 1 || userInput.length() > 1) {
//                if (userInput < 0 || userInput > 7) {
//                    System.out.println("Invalid selection - Must select a nubmer between 0 and 7.");
//                    continue; // and repeat again
//                }
                break; //out of the (exit) the repitition
            }

        } catch (Exception e) { //program said it was IOException
            ErrorView.display(this.getClass().getName(), "Error reading input "+ e.getMessage());
        }
        return response; // return the name

    }

    //sets actionRange value

    private void doActionTempleQuestions(int templeAnswer) throws QuestionControlException {

        if (templeAnswer < 0 || templeAnswer > 7) {
            throw new QuestionControlException("You have entered an incorrect response. Please enter a number between 0 and 7.");

        } else {
            if (templeAnswer >= 0 || templeAnswer < 3) {
                this.setActionRange(1);
            }
            if (templeAnswer >= 3 || templeAnswer < 6) {
                this.setActionRange(2);
            }
            if (templeAnswer >= 6 || templeAnswer <= 7) {
                this.setActionRange(3);
            }
            this.console.println("Thanks for your answer. Let's move on to the bonus question");
        }
    }

    public void displayBonusQuestion() {

        this.console.println("Do you feel your effort was (1) poor, (2) good or (3) outstanding?");

    }

//    private int getTempleBonusInput() {
//    
//        boolean valid =false; //indicates if the input has been recieved
//            int userInput = 0;
//            
//        try{
//            while(!valid) { //while a valid name has not been retrieved
//
//                //prompt for user input for a value between 0 through 7
//                System.out.println("Enter the value 1 for poor, 2 for good and 3 for outstanding.");
//
//                //get the integer from the keyboard 
//                //userInput = keyboard.nextLine();
//                if(keyboard.read() > 0 || keyboard.read() <= 7) {
//                    userInput = keyboard.read();
//                    //userInput = userInput.trim();
//                    //userInput = userInput.toUpperCase();
//                }
//                else {
//                    System.out.println("Invalid selection - Must select either 1, 2 or 3.");
//                    this.getUserInput();
//                }
//                //if the input is invalid
//                //if (userInput.length() < 1 || userInput.length() > 1) {
//                    if (userInput < 1 || userInput > 3) {
//                        System.out.println("Invalid selection - Must select either 1, 2 or 3.");
//                        continue; // and repeat again
//                    }
//                    break; //out of the (exit) the repitition
//            }
//        } catch (Exception e) { //program said it was IOException
//                System.out.println("Error reading input: " + e.getMessage());
//            }
//                return userInput; // return the name
//
//
//    }
    private void doActionBonusQuestions(int bonusAnswer) throws QuestionControlException {

        if (bonusAnswer < 0 || bonusAnswer > 3) {
            throw new QuestionControlException("You have entered an incorrect response. Please enter a number between 0 and 7.");

        } else {
            if (bonusAnswer == 1) {
                this.setQualityRange(1);
                System.out.println("In order to gain extra obedience points, you will need to put forth more effort!");
            }
            if (bonusAnswer == 2) {
                this.setQualityRange(2);
                System.out.println("Feels good to to put forth a good effort when accomplishing this task.");
            }
            if (bonusAnswer == 3) {
                this.setQualityRange(3);
                System.out.println("Outstanding effort! For this level of commitment you will be rewarded with many blessings");
            }

        }
    }

//    private void askReturnToGameMenu() {
//        System.out.println("Enter 9 to Return to the Temple Menu");
//    
//    }
//    private int getReturntoGameMenu() {
//        boolean valid =false; //indicates if the input has been recieved
//            int userInput = 0;
//           
//            try{
//            while(!valid) { //while a valid name has not been retrieved
//
//                //prompt for user input for the number 9
//                System.out.println("Enter the value 9 in order to return to the Temple Menu");
//
//                //get the name from the keyboard and trim off the blanks
//                //userInput = keyboard.nextLine();
//                if(keyboard.read() == 9) {
//                    userInput = keyboard.read();
//                    //userInput = userInput.trim();
//                    //userInput = userInput.toUpperCase();
//                }
//                else {
//                    System.out.println("Invalid selection - Must select 9 to return to the Game Menu");
//                    this.getUserInput();
//                }
//                //if the input is invalid
//                //if (userInput.length() < 1 || userInput.length() > 1) {
//                    if (userInput < 9 || userInput > 9) {
//                        System.out.println("Invalid selection - Must select 9 to return to the Game Menu");
//                        continue; // and repeat again
//                    }
//                    break; //out of the (exit) the repitition
//            }
//              } catch (Exception e) { //program said it was IOException
//                System.out.println("Error reading input: " + e.getMessage());
//            }
//                return userInput; // return the name
//    
//    }
//    
//    private void doActionReturnToGame(int returnGameMenu) throws QuestionControlException{
//        if (returnGameMenu < 9 || returnGameMenu >9){
//        throw new QuestionControlException("You have entered an incorrect response. Please enter the number 9 to return to the Temple Menu.");
//            
//        }
//        else{
//            if (returnGameMenu == 9){
//               System.out.println("You will now be returned ot the Temple Menu");
//              
//            }
//        }
//    }
    public int mantleResponse() throws QuestionControlException {
        //get answer from user
//            String mantleAnswer = this.getMantleInput();
        int answer = this.getUserInput();

        combinedMantleAnswer = answer; //this will gather the totals from each question asked, add them and use this to get average
//  System.out.println("mantleAnswer generated " + mantleAnswer);
        //validate answer and provide response if invalid answer
        this.doActionMantleQuestions(answer); //either returns false for error - invalid response  or true if valid

        //if invalid answer is given ask for valid input until response is valid
//           while(valid == false){
//                System.out.println("Please enter a number between 0 and 7");
//                
//            }
//        }
        return answer;
    }

//    private int getMantleInput() {
//       boolean valid =false; //indicates if the name has been recieved
//        int userInput = 0;
//        
//    try{
//        while(!valid) { //while a valid name has not been retrieved
//            
//            //prompt for the player's name
//            System.out.println("Enter a value between 0 through 7 for the number of days you completed the activity.");
//            
//            //get the name from the keyboard and trim off the blanks
////            userInput = keyboard.nextLine();
//            if(keyboard.read() > 0 || keyboard.read() <= 7) {
//                userInput = keyboard.read();
////                userInput = userInput.trim();
////                userInput = userInput.toUpperCase();
//            }
//            else {
//                System.out.println("Sorry try a number between 0 & 7");
//                this.getMantleInput();
//            }
//            //if the name is invalid(less than two character in length)
////            if (userInput.length() < 1 || userInput.length() > 1) {
//                 if (userInput < 0 || userInput > 7) {
//                System.out.println("Invalid selection - Must select a nubmer between 0 and 7.");
//                continue; // and repeat again
//            }
//            break; //out of the (exit) the repitition
//        }
//    } catch (Exception e) { //program said it was IOException
//           System.out.println("Error reading input: " + e.getMessage());
//       }
//        return userInput; // return the name
//    
//    } 
//    private void displayMantleQuestion(int randomNum) {
//        if(randomNum == 30){
//           System.out.println("How many days out of the last seven days did you serve a family member?");
//        }           
//        else if (randomNum == 31){
//            System.out.println("How many times in the last seven days did you attend the temple?");
//        }
//        else if (randomNum == 32){
//            System.out.println("How many days out of the last seven days did you participate in family history work?");
//        }
//        else if (randomNum == 33){
//            System.out.println("How many days out of the last seven days did you perform service for a stranger?");
//        }
//    }
    private void doActionMantleQuestions(int answer) throws QuestionControlException {

        if (answer < 0 || answer > 7) {
            throw new QuestionControlException("You have entered an incorrect response. Please enter a number between 0 and 7.");

        }

    }

//    public void getAnotherMantleQuestion() {
//        System.out.println("getAnotherMantleQuestion function called");
//    }
    public int getTotalQuestionsAsked() {
        return totalQuestionsAsked;
    }

    public void setTotalQuestionsAsked(int totalQuestionsAsked) {
        this.totalQuestionsAsked = totalQuestionsAsked;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getPointValuePerQuestion() {
        return pointValuePerQuestion;
    }

    public void setPointValuePerQuestion(int pointValuePerQuestion) {
        this.pointValuePerQuestion = pointValuePerQuestion;
    }

    public int getQuestionPoints() {
        return questionPoints;
    }

    public void setQuestionPoints(int questionPoints) {
        this.questionPoints = questionPoints;
    }

    public int getActionPoints() {
        return actionPoints;
    }

    public void setActionPoints(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    public int getQualityPoints() {
        return qualityPoints;
    }

    public void setQualityPoints(int qualityPoints) {
        this.qualityPoints = qualityPoints;
    }

    public int getTempleQuestionPoints() {
        return templeQuestionPoints;
    }

    public void setTempleQuestionPoints(int templeQuestionPoints) {
        this.templeQuestionPoints = templeQuestionPoints;
    }

    public int getAnsweredCorrect() {
        return answeredCorrect;
    }

    public void setAnsweredCorrect(int answeredCorrect) {
        this.answeredCorrect = answeredCorrect;
    }

    public int getMantleQuestionPoints() {
        return mantleQuestionPoints;
    }

    public void setMantleQuestionPoints(int mantleQuestionPoints) {
        this.mantleQuestionPoints = mantleQuestionPoints;
    }

    public int getActionRange() {
        return actionRange;
    }

    public void setActionRange(int actionRange) {
        this.actionRange = actionRange;
    }

    public int getQualityRange() {
        return qualityRange;
    }

    public void setQualityRange(int qualityRange) {
        this.qualityRange = qualityRange;
    }

    public int getCombinedMantleAnswer() {
        return combinedMantleAnswer;
    }

    public void setCombinedMantleAnswer(int combinedMantleAnswer) {
        this.combinedMantleAnswer = combinedMantleAnswer;
    }

    public String getBonusAnswer() {
        return bonusAnswer;
    }

    public void setBonusAnswer(String bonusAnswer) {
        this.bonusAnswer = bonusAnswer;
    }

}
