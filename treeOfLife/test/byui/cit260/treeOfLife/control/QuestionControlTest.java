/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.control;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sherihansen
 */
public class QuestionControlTest {
    
    public QuestionControlTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calLevelQuestionPoints method, of class QuestionControl.
     */
    @Test
    public void testCalLevelQuestionPoints() {
        System.out.println("calLevelQuestionPoints");
        
        //test case #1
        System.out.println("\tTest case #1");
        
        //input values for test case 1
        int answeredCorrect = 1;
        int totalQuestionsAsked = 6;
        QuestionControl instance = new QuestionControl();
        
        int expResult = 5;  //expected output return value
        
        //call function to run test
        int result = instance.calLevelQuestionPoints(answeredCorrect, totalQuestionsAsked);
       
        //compare expected return value with actual value returned
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        
        ///TEST CASE #2/////
            
        System.out.println("\tTest case #2");
        
        //input values for test case 2
         answeredCorrect = 4;
         totalQuestionsAsked = 5;
//        QuestionControl instance = new QuestionControl();
        
         expResult = 21;  //expected output return value
        
        //call function to run test
         result = instance.calLevelQuestionPoints(answeredCorrect, totalQuestionsAsked);
       
        //compare expected return value with actual value returned
        assertEquals(expResult, result);
        
         ///TEST CASE #3/////////////////////////////////////////
            
        System.out.println("\tTest case #3 ");
        
        //input values for test case 3
         answeredCorrect = 7;
         totalQuestionsAsked = 9;
//        QuestionControl instance = new QuestionControl();
        
         expResult = 38;  //expected output return value
        
        //call function to run test
         result = instance.calLevelQuestionPoints(answeredCorrect, totalQuestionsAsked);
       
        //compare expected return value with actual value returned
        assertEquals(expResult, result);
        
        ///TEST CASE #4/////////////////////////////////////////
            
        System.out.println("\tTest case #4 ");
        
        //input values for test case 4
         answeredCorrect = 10;
         totalQuestionsAsked = 0;
//        QuestionControl instance = new QuestionControl();
        
         expResult = -1;  //expected output return value
        
        //call function to run test
         result = instance.calLevelQuestionPoints(answeredCorrect, totalQuestionsAsked);
       
        //compare expected return value with actual value returned
        assertEquals(expResult, result);
        
         ///TEST CASE #5/////////////////////////////////////////
            
        System.out.println("\tTest case #5 ");
        
        //input values for test case 5
         answeredCorrect = 0;
         totalQuestionsAsked = 3;
//        QuestionControl instance = new QuestionControl();
        
         expResult = 0;  //expected output return value
        
        //call function to run test
         result = instance.calLevelQuestionPoints(answeredCorrect, totalQuestionsAsked);
       
        //compare expected return value with actual value returned
        assertEquals(expResult, result);
        
        ///TEST CASE #6/////////////////////////////////////////
            
        System.out.println("\tTest case #6 ");
        
        //input values for test case 6
         answeredCorrect = 9;
         totalQuestionsAsked = 9;
//        QuestionControl instance = new QuestionControl();
        
         expResult = 48;  //expected output return value
        
        //call function to run test
         result = instance.calLevelQuestionPoints(answeredCorrect, totalQuestionsAsked);
       
        //compare expected return value with actual value returned
        assertEquals(expResult, result);
    }
    
}
