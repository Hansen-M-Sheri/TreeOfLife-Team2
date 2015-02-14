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

}
