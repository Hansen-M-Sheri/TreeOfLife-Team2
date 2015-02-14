/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.control;

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
    
    
    /**
     * This function calculates the points earned within a  level
     * @param answeredCorrect
     * @param totalQuestionsAsked
     * @return integer questionPoints
     * User must answer set of 3 questions correctly to earn a bonus.  
     * 
     */
    public int calLevelQuestionPoints(int answeredCorrect, int totalQuestionsAsked) {
        //if to few questions or too many are asked, return error
        if (totalQuestionsAsked < 3 || totalQuestionsAsked > 9){
            return -1;
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
   public int calTemplePoints(int actionRange, int qualityRange) {
        
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
            return -1;
        }
        //verify qualityRange is valid & set qualityPoints
        if(qualityRange <1 || qualityRange >3) {
            return -1;
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
   
public int calMantlePoints(int answeredCorrect, int totalQuestionsAsked) {
        //if too few questions or too many are asked, return error
        if(totalQuestionsAsked <= 0 || totalQuestionsAsked> 3){
            return -1;
            
        
        
        //Each question is service based. 
        //The questions will require the user to enter a number 0-7
        //Example – How many days in the last seven days did you provide service to a neighbor or friend? 
        //User enters in a value between 0 and 7. Bonus 0 for <3, Bonus 1 for 3-4, bonus 3 for 5-6, 5 point bonus for 7

        }else{
        //If you answer less than zero, return error
            if(answeredCorrect <0){
                return -1;
        }
        // bonus structure for the correct expexted response from user if answered between 0 and 2 is zero bonus point
            else if(answeredCorrect < 3){
            bonus = 0;
        
        }
        // bonus structure for the correct expexted response from user if answered between 3 and 4 is one bonus point
            else if(answeredCorrect >= 3 && answeredCorrect < 5) {
            bonus = 1;
            
        }
        // bonus structure for the correct expexted response from user if answered between 5 and 6 is three bonus points
            else if(answeredCorrect >= 5 && answeredCorrect < 7) {
            bonus = 3;
        }
        // bonus structure for the correct expexted response from user if answered 7 is 5 bonus points 
            else if(answeredCorrect == 7) {
            bonus = 5;
            
        }
        // return error if the user answers more than 7.
            else if(answeredCorrect > 7){
                return -1;
        }
                
            
        
          
}       //total points per question asked
        pointValuePerQuestion = 5;	
        
        //calculations to determine the points during your session at the Mantle
        mantleQuestionPoints = totalQuestionsAsked * pointValuePerQuestion + bonus;
        return mantleQuestionPoints;
    
}

}

        
    
    


