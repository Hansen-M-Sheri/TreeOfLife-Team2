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
}
