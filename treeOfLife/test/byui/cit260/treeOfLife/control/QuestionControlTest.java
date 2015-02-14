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

    /**
     * Test of calTemplePoints method, of class QuestionControl.
     */
    @Test
    public void testCalTemplePoints() {
        System.out.println("calTemplePoints");
        
        /*******************************
         * Test Case #1
         *******************************/
        System.out.println("\tTest case #1");
        //input values 
        int actionRange = 1;
        int qualityRange = 1;
        QuestionControl instance = new QuestionControl();
        int expResult = 1; //expected output returned
        int result = instance.calTemplePoints(actionRange, qualityRange);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        
        
         /*******************************
         * Test Case #2
         *******************************/
        System.out.println("\tTest case #2");
        //input values 
        actionRange = 2;
        qualityRange = 1;
        expResult = 2; //expected output returned
        result = instance.calTemplePoints(actionRange, qualityRange);
        assertEquals(expResult, result);
        
                 /*******************************
         * Test Case #3
         *******************************/
        System.out.println("\tTest case #3");
        //input values 
        actionRange = 3;
        qualityRange = 1;
        expResult = 6; //expected output returned
        result = instance.calTemplePoints(actionRange, qualityRange);
        assertEquals(expResult, result);
        
                 /*******************************
         * Test Case #4
         *******************************/
        System.out.println("\tTest case #4");
        //input values 
        actionRange = 1;
        qualityRange = 2;
        expResult = 2; //expected output returned
        result = instance.calTemplePoints(actionRange, qualityRange);
        assertEquals(expResult, result);
        
                 /*******************************
         * Test Case #5
         *******************************/
        System.out.println("\tTest case #5");
        //input values 
        actionRange = 2;
        qualityRange = 2;
        expResult = 3; //expected output returned
        result = instance.calTemplePoints(actionRange, qualityRange);
        assertEquals(expResult, result);
        
        /*******************************
         * Test Case #6
         *******************************/
        System.out.println("\tTest case #6");
        //input values 
        actionRange = 3;
        qualityRange = 2;
        expResult = 8; //expected output returned
        result = instance.calTemplePoints(actionRange, qualityRange);
        assertEquals(expResult, result);
        
                 /*******************************
         * Test Case #7
         *******************************/
        System.out.println("\tTest case #7");
        //input values 
        actionRange = 1;
        qualityRange = 3;
        expResult = 6; //expected output returned
        result = instance.calTemplePoints(actionRange, qualityRange);
        assertEquals(expResult, result);
        
                 /*******************************
         * Test Case #8
         *******************************/
        System.out.println("\tTest case #8");
        //input values 
        actionRange = 2;
        qualityRange = 3;
        expResult = 8; //expected output returned
        result = instance.calTemplePoints(actionRange, qualityRange);
        assertEquals(expResult, result);
        
        /*******************************
         * Test Case #9
         *******************************/
        System.out.println("\tTest case #9");
        //input values 
        actionRange = 3;
        qualityRange = 3;
        expResult = 15; //expected output returned
        result = instance.calTemplePoints(actionRange, qualityRange);
        assertEquals(expResult, result);
        
               /*******************************
         * Test Case #10
         *******************************/
        System.out.println("\tTest case #10");
        //input values 
        actionRange = 4;
        qualityRange = 2;
        expResult = -1; //expected output returned
        result = instance.calTemplePoints(actionRange, qualityRange);
        assertEquals(expResult, result);
        
               /*******************************
         * Test Case #11
         *******************************/
        System.out.println("\tTest case #11");
        //input values 
        actionRange = 1;
        qualityRange = 0;
        expResult = -1; //expected output returned
        result = instance.calTemplePoints(actionRange, qualityRange);
        assertEquals(expResult, result);
        
               /*******************************
         * Test Case #12
         *******************************/
        System.out.println("\tTest case #12");
        //input values 
        actionRange = 1;
        qualityRange = 1;
        expResult = 1; //expected output returned
        result = instance.calTemplePoints(actionRange, qualityRange);
        assertEquals(expResult, result);
        
               /*******************************
         * Test Case #13
         *******************************/
        System.out.println("\tTest case #13");
        //input values 
        actionRange = 3;
        qualityRange = 3;
        expResult = 15; //expected output returned
        result = instance.calTemplePoints(actionRange, qualityRange);
        assertEquals(expResult, result);
    }
    
}
