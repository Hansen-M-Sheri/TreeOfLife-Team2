/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.model;

import java.util.Objects;
import java.io.Serializable;
/**
 *
 * @author Chuck
 */
public class Questions implements Serializable{
    
    private int questionType;
    private String questionAnswered;
    private int questionNumber;
    private String questionPoints;
    private int mantleQuestionsAsked = 0;
    private Scene scene;
    private String question;
   
// public Questions() {
//    }

    public void setMantleQuestionsAsked(int mantleQuestionsAsked) {
        this.mantleQuestionsAsked = mantleQuestionsAsked;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public int getMantleQuestionsAsked() {
        return mantleQuestionsAsked;
    }

    public Scene getScene() {
        return scene;
    }
    
    

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public String getQuestionAnswered() {
        return questionAnswered;
    }

    public void setQuestionAnswered(String questionAnswered) {
        this.questionAnswered = questionAnswered;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestionPoints() {
        return questionPoints;
    }

    public void setQuestionPoints(String questionPoints) {
        this.questionPoints = questionPoints;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Questions{" + "questionType=" + questionType + ", questionAnswered=" + questionAnswered + ", questionNumber=" + questionNumber + ", questionPoints=" + questionPoints + ", mantleQuestionsAsked=" + mantleQuestionsAsked + ", scene=" + scene + ", question=" + question + '}';
    }

//    @Override
//    public String toString() {
//        return "Questions{" + "questionType=" + questionType + ", questionAnswered=" + questionAnswered + ", questionNumber=" + questionNumber + ", questionPoints=" + questionPoints + '}';
//    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.questionType);
        hash = 71 * hash + Objects.hashCode(this.questionAnswered);
        hash = 71 * hash + Objects.hashCode(this.questionNumber);
        hash = 71 * hash + Objects.hashCode(this.questionPoints);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Questions other = (Questions) obj;
        if (!Objects.equals(this.questionType, other.questionType)) {
            return false;
        }
        if (!Objects.equals(this.questionAnswered, other.questionAnswered)) {
            return false;
        }
        if (!Objects.equals(this.questionNumber, other.questionNumber)) {
            return false;
        }
        if (!Objects.equals(this.questionPoints, other.questionPoints)) {
            return false;
        }
        return true;
    }

    public void incrementMantleQuestionsAsked() {
        mantleQuestionsAsked ++;
//        System.out.println(mantleQuestionsAsked);
    }
    
    public void resetMantleQuestionsAsked() {
        mantleQuestionsAsked = 0;
    }
}
