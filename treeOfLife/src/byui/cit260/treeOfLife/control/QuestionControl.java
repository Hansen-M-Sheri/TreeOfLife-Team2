/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.control;

import byui.cit260.treeOfLife.model.Game;
import byui.cit260.treeOfLife.model.Location;
import byui.cit260.treeOfLife.model.Questions;
import citbyui.cit260.treeOfLife.exceptions.QuestionControlException;
import java.util.Random;
import java.util.Scanner;
import treeoflife.TreeOfLife;

/**
 *
 * @author Chuck
 */
public class QuestionControl {
    private int totalQuestionsAsked;
    private int bonus;
    private int pointValuePerQuestion;
    private int questionPoints;
    private int actionPoints;
    private int qualityPoints;
    private int templeQuestionPoints;
    private int answeredCorrect;
    private int mantleQuestionPoints;
    private int actionRange;
    private int qualityRange;
    private int combinedMantleAnswer;
    private String bonusAnswer;
    //private String BONUS;
    /**
     * This function calculates the points earned within a  level
     * @param answeredCorrect
     * @param totalQuestionsAsked
     * @return integer questionPoints
     * User must answer set of 3 questions correctly to earn a bonus.  
     * 
     */
    public int calLevelQuestionPoints(int answeredCorrect, int totalQuestionsAsked)   {//throws QuestionControlException
        //if to few questions or too many are asked, return error
        if (totalQuestionsAsked < 3 || totalQuestionsAsked > 9){
            return -1;
//            throw new QuestionControlException("You must answer 3 questions, but no more than 9 questions");
        }   
	//if questions asked is within range, determine bonus points earned
        else {
           if(answeredCorrect <3) { 
		bonus = 0;
            }
            else if(answeredCorrect >=3 && answeredCorrect <6){
                bonus = 1;
            }
            else if (answeredCorrect >=6 && answeredCorrect <10) {
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
     * @param actionRange
     * @param qualityRange
     * @return templeQuestionPoints (integer)
     * At each visit to temple, user will be asked two questions. 
     * 1st based on action performed this week
     * 2nd based on quality of action (ie: good, better, best)
     * Their answer will fall into a range for action and quality
     * For each range a point value is assigned
     * Bonus points are available for any combo where highest range is hit
     *  if highest range in both categories is achieved , larger bonus occurs
     * Range options are 1,2,3 with 3 being highest
     */
   public int calTemplePoints(int actionRange, int qualityRange)throws QuestionControlException {
        
       //determine actionRange and set actionPoints
       if(actionRange == 1) {
            actionPoints = 0;
        }
        else if(actionRange == 2) {
            actionPoints = 1;
        }       
           
        else if(actionRange == 3) {
            actionPoints = 2;
        }
        else {
//            return -1;
            throw new QuestionControlException("Invalid Selection. You must select 1, 2, or 3, to continue");
        }
        //verify qualityRange is valid & set qualityPoints
        if(qualityRange <1 || qualityRange >3) {
           throw new QuestionControlException("Invalid Selection. You must select 1, 2, or 3, to continue");
        }
        else {
        //points will be 1, 2, or 3 ; same integer as qualityRange
            qualityPoints = qualityRange;

        }
        
        //determine bonus points
        if(actionRange == 3 && qualityRange == 3) {
            bonus = 3;
        }
        else if (actionRange ==3 || qualityRange ==3 ) {
            bonus = 2;
        }
        else {
            bonus = 1;
        }
        templeQuestionPoints = (actionPoints + qualityPoints) * bonus;
        return templeQuestionPoints;
    }
   
   /**
     * This function calculates how many points earned in mantle
     * @param answeredCorrect
     * @param totalQuestionsAsked
     * @return mantleQuestionPoints (integer)
     * At each visit to mantle, user will be asked one question type. 
     * How many days out of seven did the user complete, do or provide service, etc.
     * By coming to the Mantle and taking one question - user automatically gets 5 points.
     * Depending on the answer, the can get a bonus of 0, 1, 3 or 5 points.
     * Calculations is total questions asked multiplied by the point value per question at 5 plus their bonus earned.
     * Answering outside the parameters of 0-7 will result in an error.
     * Once at the mantle, if you try and leave before the question is asked, it will return an error.
     * Once at the mantle, if you try and answer more than three questions, it will return an error.
     * The mantle will be used to regain faith points lost during the game.
     */
   
    public int calMantlePoints(int answerAverage, int mantleQuestionsAsked) throws QuestionControlException {
        //if too few questions or too many are asked, return error
        if(mantleQuestionsAsked <= 0 || mantleQuestionsAsked> 3){
//            return -1;
             throw new QuestionControlException("Invalid number of Questions answered. Must be between 0  & 3");
        
        
        //Each question is service based. 
        //The questions will require the user to enter a number 0-7
        //Example – How many days in the last seven days did you provide service to a neighbor or friend? 
        //User enters in a value between 0 and 7. Bonus 0 for <3, Bonus 1 for 3-4, bonus 3 for 5-6, 5 point bonus for 7

        }else{
        //If you answer less than zero, return error
            if(answerAverage <0){
//                return -1;
                throw new QuestionControlException("Invalid average number of questions answered");
        }
        // bonus structure for the correct expexted response from user if answered between 0 and 2 is zero bonus point
            else if(answerAverage < 3){
            bonus = 0;
        
        }
        // bonus structure for the correct expexted response from user if answered between 3 and 4 is one bonus point
            else if(answerAverage >= 3 && answerAverage < 5) {
            bonus = 1;
            
        }
        // bonus structure for the correct expexted response from user if answered between 5 and 6 is three bonus points
            else if(answerAverage >= 5 && answerAverage < 7) {
            bonus = 3;
        }
        // bonus structure for the correct expexted response from user if answered 7 is 5 bonus points 
            else if(answerAverage == 7) {
            bonus = 5;
            
        }
        // return error if the user answers more than 7.
            else if(answerAverage > 7){
//                return -1;
                throw new QuestionControlException("Invalid answer. Must be less than 7");
        }
                
            
        
          
    }       //total points per question asked
        pointValuePerQuestion = 5;	
        
        //calculations to determine the points during your session at the Mantle
        mantleQuestionPoints = mantleQuestionsAsked * pointValuePerQuestion + bonus;
        return mantleQuestionPoints;
    
    }   

    public void getTempleQuestions() throws QuestionControlException {
        //check isBlocked - determine how we determine block and not blocked to answer questions
        //Location location = new Location();
        //boolean isBlocked = location.isBlocked();
      
        //if(isBlocked == true) {
        //   System.out.println("Sorry, you need to answer more level questions before you can answer an additional Temple question.");
        //}
        //else {
            //display random question
            Random rand = new Random();
                int range = 2 - 1 + 1;
                int randomNum = rand.nextInt(range) + 1;
                this.displayQuestion(randomNum);
                
                //get answer from user
                int templeAnswer = this.getTempleInput();

                //validate answer and provide response
                boolean valid = this.doActionTempleQuestions(templeAnswer);

                //ask follow up question for bonus
                this.displayBonusQuestion();

                //validate answer and provide response
                int bonusAnswer = this.getTempleBonusInput();
                
        //        this.doActionTempleBonus(bonusAnswer); // working on calling point functions.
                boolean bonusValid = this.doActionBonusQuestions(bonusAnswer);
        //        generate response by calling calTemplePoints function
                int templePoints = this.calTemplePoints(actionRange, qualityRange);
                
                //return to game menue after finishing up temple questions
                this.askReturnToGameMenu();
                
                int returnGameMenu = this.getReturntoGameMenu();
                
                boolean validReturn = this.doActionReturnToGame(returnGameMenu);
                
        //        display string "You achieved XXX number of days with XXX effort and are rewarded with Call calTemplePoints"
        //        System.out.println("Based on your response, you have increased your obedience meter by " + templePoints + ".");

        //        display prompt "Enter Q to retun to Temple Menu"
        //        System.out.println("Enter Q to return to the Temple Menu");

                //validate response for returning to Temple Menu
                //String returnTempleMenu = this.displayTempleMenu();
    
    
    
    
        
        
    
    }
    
    private void displayQuestion(int randomNum) {
        
        if (randomNum == 1){
            System.out.println("How many days out of the last seven days did you read the book of Mormon?");
        }
        else if (randomNum ==2){
            System.out.println("How many days out of the last seven days did you have your personal prayers?");
        }
    }       
  

    public int getTempleInput() {
        boolean valid =false; //indicates if the input has been recieved
        int userInput = 0;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //while a valid name has not been retrieved
            
            //prompt for user input for a value between 0 through 7
            System.out.println("Enter a value between 0 through 7 for the number of days you completed the activity.");
            
            //get the name from the keyboard and trim off the blanks
            //userInput = keyboard.nextLine();
            if(keyboard.hasNextInt()) {
                userInput = keyboard.nextInt();
                //userInput = userInput.trim();
                //userInput = userInput.toUpperCase();
            }
            else {
                System.out.println("Invalid selection - Must select a nubmer between 0 and 7.");
                this.getTempleInput();
            }
            //if the input is invalid
            //if (userInput.length() < 1 || userInput.length() > 1) {
                if (userInput < 0 || userInput > 7) {
                    System.out.println("Invalid selection - Must select a nubmer between 0 and 7.");
                    continue; // and repeat again
                }
                break; //out of the (exit) the repitition
        }
        
            return userInput; // return the name
    
    }
    
    private boolean doActionTempleQuestions(int templeAnswer) {
        
        if (templeAnswer < 0 || templeAnswer >7){
        System.out.println("You have entered an incorrect response. Please enter a number between 0 and 7.");
            return false;
        }
        else{
           System.out.println("Thanks for your answer. Let's move on to the bonus question");
           return true;
        }
    }
        
    public void displayBonusQuestion() {
      
            System.out.println("Do you feel your effort was (1) poor, (2) good or (3) outstanding?");
            
            
    }          
     
    private int getTempleBonusInput() {
    
        boolean valid =false; //indicates if the input has been recieved
            int userInput = 0;
            Scanner keyboard = new Scanner(System.in); //keyboard input stream

            while(!valid) { //while a valid name has not been retrieved

                //prompt for user input for a value between 0 through 7
                System.out.println("Enter the value 1 for poor, 2 for good and 3 for outstanding.");

                //get the name from the keyboard and trim off the blanks
                //userInput = keyboard.nextLine();
                if(keyboard.hasNextInt()) {
                    userInput = keyboard.nextInt();
                    //userInput = userInput.trim();
                    //userInput = userInput.toUpperCase();
                }
                else {
                    System.out.println("Invalid selection - Must select either 1, 2 or 3.");
                    this.getTempleInput();
                }
                //if the input is invalid
                //if (userInput.length() < 1 || userInput.length() > 1) {
                    if (userInput < 1 || userInput > 3) {
                        System.out.println("Invalid selection - Must select either 1, 2 or 3.");
                        continue; // and repeat again
                    }
                    break; //out of the (exit) the repitition
            }

                return userInput; // return the name


    }
    
    private boolean doActionBonusQuestions(int bonusAnswer) {
    
        if (bonusAnswer < 0 || bonusAnswer >7){
        System.out.println("You have entered an incorrect response. Please enter a number between 0 and 7.");
            return false;
        }
        else{
            if (bonusAnswer == 1){
               System.out.println("In order to gain extra obedience points, you will need to put forth more effort!");
            }
            if (bonusAnswer == 2){
               System.out.println("Feels good to to put forth a good effort when accomplishing this task.");
            }
            if (bonusAnswer == 3){
               System.out.println("Outstanding effort! For this level of commitment you will be rewarded with many blessings");
            }
            return true;
        }
    }

    private void askReturnToGameMenu() {
        System.out.println("Enter 9 to Return to the Temple Menu");
    
    }
    
    private int getReturntoGameMenu() {
        boolean valid =false; //indicates if the input has been recieved
            int userInput = 0;
            Scanner keyboard = new Scanner(System.in); //keyboard input stream

            while(!valid) { //while a valid name has not been retrieved

                //prompt for user input for the number 9
                System.out.println("Enter the value 9 in order to return to the Temple Menu");

                //get the name from the keyboard and trim off the blanks
                //userInput = keyboard.nextLine();
                if(keyboard.hasNextInt()) {
                    userInput = keyboard.nextInt();
                    //userInput = userInput.trim();
                    //userInput = userInput.toUpperCase();
                }
                else {
                    System.out.println("Invalid selection - Must select 9 to return to the Game Menu");
                    this.getTempleInput();
                }
                //if the input is invalid
                //if (userInput.length() < 1 || userInput.length() > 1) {
                    if (userInput < 9 || userInput > 9) {
                        System.out.println("Invalid selection - Must select 9 to return to the Game Menu");
                        continue; // and repeat again
                    }
                    break; //out of the (exit) the repitition
            }

                return userInput; // return the name
    
    }
    
    private boolean doActionReturnToGame(int returnGameMenu) {
        if (returnGameMenu < 9 || returnGameMenu >9){
        System.out.println("You have entered an incorrect response. Please enter the number 9 to return to the Temple Menu.");
            return false;
        }
        else{
            if (returnGameMenu == 9){
               System.out.println("You will now be returned ot the Temple Menu");
              
            }
            
            return true;
        }
    }
    
    
   
    
    
    
    
    public void getMantleQuestion() {
    //check isBlocked - determine how we determine block and not blocked to answer questions
//        Location location = new Location();
//        boolean isBlocked = location.isBlocked();
//      
//        if(isBlocked == true) {
//            System.out.println("Sorry, you need to answer more level questions before you can answer a mantle question.  ");
//        }
//        else {
            //display random question
            Random rand = new Random();
            int range = 33 - 30 + 1;    //mantle questions will range from 30 - 40
            int randomNum = rand.nextInt(range) + 30;
            this.displayMantleQuestion(randomNum);
//            System.out.println("randNumb generated " + randomNum);

            //get answer from user
//            String mantleAnswer = this.getMantleInput();
            int answer = this.getMantleInput();

            combinedMantleAnswer = answer; //this will gather the totals from each question asked, add them and use this to get average
//  System.out.println("mantleAnswer generated " + mantleAnswer);
             //validate answer and provide response if invalid answer
            boolean valid = this.doActionMantleQuestions(answer); //either returns false for error - invalid response  or true if valid
            
            //track total questions asked in mantle
            Questions question = new Questions();
            question.incrementMantleQuestionsAsked();//not sure if this is adding one each time
            
            //if invalid answer is given ask for valid input until response is valid
           while(valid == false){
                System.out.println("Please enter a number between 0 and 7");
                
            }
//        }
    }  

    private int getMantleInput() {
       boolean valid =false; //indicates if the name has been recieved
        int userInput = 0;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //while a valid name has not been retrieved
            
            //prompt for the player's name
            System.out.println("Enter a value between 0 through 7 for the number of days you completed the activity.");
            
            //get the name from the keyboard and trim off the blanks
//            userInput = keyboard.nextLine();
            if(keyboard.hasNextInt()) {
                userInput = keyboard.nextInt();
//                userInput = userInput.trim();
//                userInput = userInput.toUpperCase();
            }
            else {
                System.out.println("Sorry try a number between 0 & 7");
                this.getMantleInput();
            }
            //if the name is invalid(less than two character in length)
//            if (userInput.length() < 1 || userInput.length() > 1) {
                 if (userInput < 0 || userInput > 7) {
                System.out.println("Invalid selection - Must select a nubmer between 0 and 7.");
                continue; // and repeat again
            }
            break; //out of the (exit) the repitition
        }
        
        return userInput; // return the name
    
    } 

    private void displayMantleQuestion(int randomNum) {
        if(randomNum == 30){
           System.out.println("How many days out of the last seven days did you serve a family member?");
        }           
        else if (randomNum == 31){
            System.out.println("How many times in the last seven days did you attend the temple?");
        }
        else if (randomNum == 32){
            System.out.println("How many days out of the last seven days did you participate in family history work?");
        }
        else if (randomNum == 33){
            System.out.println("How many days out of the last seven days did you perform service for a stranger?");
        }
    }

    private boolean doActionMantleQuestions(int answer) {
       
        if (answer < 0 || answer >7){
        System.out.println("You have entered an incorrect response. Please enter a number between 0 and 7.");
            return false;
        }
        else{
            System.out.println("Thanks for your answer.");
            return true;
           
        }
    }

    public void getAnotherMantleQuestion() {
        System.out.println("getAnotherMantleQuestion function called");
    }

    public enum QuestionType {
    temple,
    mantle,
    levelQuestions;
}
    public static  Questions[][] createQuestionArray() {
         Game game = TreeOfLife.getCurrentGame(); 
        // Create array of questions
        Questions[][] questions = new Questions[QuestionType.values().length][20];
      ///////////////////////////Temple Questions/////////////////////////////// 
    //create array of Question objects (type)
        Questions templeQuestion1 = new Questions();
        templeQuestion1.setQuestionNumber(1);
        templeQuestion1.setQuestionType(QuestionType.temple.ordinal());
        templeQuestion1.setQuestion("How many days out of the last seven days did you read the book of Mormon?");
        questions[QuestionType.temple.ordinal()][1] = templeQuestion1;
        
        Questions templeQuestion2 = new Questions();
        templeQuestion2.setQuestionNumber(2);
        templeQuestion2.setQuestionType(QuestionType.temple.ordinal());
        templeQuestion2.setQuestion("How many days out of the last seven days did you have your personal prayers?");
        questions[QuestionType.temple.ordinal()][2] = templeQuestion2;
        
        Questions templeQuestion3 = new Questions();
        templeQuestion3.setQuestionNumber(3);
        templeQuestion3.setQuestionType(QuestionType.temple.ordinal());
        templeQuestion3.setQuestion("How many days out of the last seven days did you exercise?");
        questions[QuestionType.temple.ordinal()][3] = templeQuestion3;
        
        Questions templeQuestion4 = new Questions();
        templeQuestion4.setQuestionNumber(4);
        templeQuestion4.setQuestionType(QuestionType.temple.ordinal());
        templeQuestion4.setQuestion("How many days out of the last seven days did you wake up early?");
        questions[QuestionType.temple.ordinal()][4] = templeQuestion4;
        
        Questions templeQuestion5 = new Questions();
        templeQuestion5.setQuestionNumber(5);
        templeQuestion5.setQuestionType(QuestionType.temple.ordinal());
        templeQuestion5.setQuestion("How many days out of the last seven days did you build your marriage (or relationship with someone important to you)?");
        questions[QuestionType.temple.ordinal()][5] = templeQuestion5;
    ////////////////////////Mantle Questions /////////////////////////////////////////    
        //set mantleQuestions in array
        Questions mantleQuestion1 = new Questions();
        mantleQuestion1.setQuestionNumber(1);
        mantleQuestion1.setQuestionType(QuestionType.mantle.ordinal());
        mantleQuestion1.setQuestion("How many days out of the last seven days did you serve a family member?");
        questions[QuestionType.mantle.ordinal()][1] = mantleQuestion1;
        
          Questions mantleQuestion2 = new Questions();
        mantleQuestion2.setQuestionNumber(2);
        mantleQuestion2.setQuestionType(QuestionType.mantle.ordinal());
        mantleQuestion2.setQuestion("How many days out of the last seven days did you attend the temple?");
        questions[QuestionType.mantle.ordinal()][2] = mantleQuestion2;
                
          Questions mantleQuestion3 = new Questions();
        mantleQuestion3.setQuestionNumber(3);
        mantleQuestion3.setQuestionType(QuestionType.mantle.ordinal());
        mantleQuestion3.setQuestion("How many days out of the last seven days did you help a stranger?");
        questions[QuestionType.mantle.ordinal()][3] = mantleQuestion3;
    ///////////////////////Level Questions //////////////////////////////
        Questions levelQuestion1 = new Questions();
        levelQuestion1.setQuestionNumber(1);
        levelQuestion1.setQuestionType(QuestionType.levelQuestions.ordinal());
        levelQuestion1.setQuestion("How many books are in the Book of Mormon?");
        questions[QuestionType.levelQuestions.ordinal()][1] = levelQuestion1;
        
         Questions levelQuestion2 = new Questions();
        levelQuestion2.setQuestionNumber(2);
        levelQuestion2.setQuestionType(QuestionType.levelQuestions.ordinal());
        levelQuestion2.setQuestion("How many men comprise the First Presidency and Quorum of Twelve?");
        questions[QuestionType.levelQuestions.ordinal()][2] = levelQuestion2;
        
         Questions levelQuestion3 = new Questions();
        levelQuestion3.setQuestionNumber(3);
        levelQuestion3.setQuestionType(QuestionType.levelQuestions.ordinal());
        levelQuestion3.setQuestion("How many Presidents have led the church since the restoration?");
        questions[QuestionType.levelQuestions.ordinal()][3] = levelQuestion3;
        
         Questions levelQuestion4 = new Questions();
        levelQuestion4.setQuestionNumber(4);
        levelQuestion4.setQuestionType(QuestionType.levelQuestions.ordinal());
        levelQuestion4.setQuestion("In what chapter of the Doctrine and Covenants is the \"Word of Wisdom\" found?");
        questions[QuestionType.levelQuestions.ordinal()][4] = levelQuestion4;
    //return questions array
        return questions;
    }

    

    

    

    

   

}






    
