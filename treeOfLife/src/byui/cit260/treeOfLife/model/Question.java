/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.model;

import java.io.Serializable;

/**
 *
 * @author sherihansen
 */
public class Question implements Serializable{
     private String question;
      private String answerToLevelQuestion;

    public Question() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerToLevelQuestion() {
        return answerToLevelQuestion;
    }

    public void setAnswerToLevelQuestion(String answerToLevelQuestion) {
        this.answerToLevelQuestion = answerToLevelQuestion;
    }
      
      
}
