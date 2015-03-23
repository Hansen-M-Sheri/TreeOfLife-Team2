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
public class QuestionArray implements Serializable{
    
    private String questionAnswered;
    private String questionPoints;
    private static int numMantleQuestion = 0 ;
    private Scene scene;
   
    private static String[][] questionArray;
    private static Question[][] levelQuestionArray;
    private static int lastTempleQuestionAsked ;
    private static int lastMantleQuestionAsked ;
    private static int lastLevelQuestionAsked;
   

   
   
 public QuestionArray() {
     questionArray = new String[2][10];
     /*
     Put questions in the constructor - this way instead of questions needing to be stored the entire game, 
     QuestionsArray will be accessed when called (or new instance created).  
     This will work because questions never change, it is read only, never setting new questions
     */
     //define temple questions
     String[] templeQuestions = {"How many days out of the last seven days did you read the book of Mormon?",
                                     "How many days out of the last seven days did you have your personal prayers?",
                                     "How many days out of the last seven days did you exercise?",
                                      "How many days out of the last seven days did you wake up early?",
                                     "How many days out of the last seven days did you build your marriage (or relationship with someone important to you)?"
     };
     //define mantle questions
     String[] mantleQuestions = {"How many days out of the last seven days did you serve a family member?",
                                  "How many days out of the last seven days did you attend the temple?",
                                  "How many days out of the last seven days did you help a stranger?"
     };
     //store questions in array with both mantle and temple questions in it
     questionArray[QuestionType.temple.ordinal()] = templeQuestions;
     
     questionArray[QuestionType.mantle.ordinal()] = mantleQuestions;
     
     //create levelQuestion array - called a function here because this will contain 30 question objects and is long.
    this.createLevelQuestionArray();

 }
public enum QuestionType {
    temple,
    mantle,
    levelQuestions;
}
    private Question[][] createLevelQuestionArray() {
         levelQuestionArray = new Question[3][30];
         
        Question levelQuestion1 = new Question();
        levelQuestion1.setQuestion("How many books are in the Book of Mormon?");
        levelQuestion1.setAnswerToLevelQuestion("7");
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][0] = levelQuestion1;
        
         Question levelQuestion2 = new Question();
        levelQuestion2.setQuestion("How many men comprise the First Presidency and Quorum of Twelve?");
        levelQuestion2.setAnswerToLevelQuestion("15"); 
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][1] = levelQuestion2;
        
         Question levelQuestion3 = new Question();
        levelQuestion3.setQuestion("How many Presidents have led the church since the restoration?");
        levelQuestion3.setAnswerToLevelQuestion("16"); 
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][2] = levelQuestion3;
        
         Question levelQuestion4 = new Question();
        levelQuestion4.setQuestion("In what section of the Doctrine and Covenants is the \"Word of Wisdom\" found?");
        levelQuestion4.setAnswerToLevelQuestion("89"); 
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][3] = levelQuestion4;
         
         Question levelQuestion5 = new Question();
        levelQuestion5.setQuestion("How many sons did Lehi  & Sariah have?");
        levelQuestion4.setAnswerToLevelQuestion("6");
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][4] = levelQuestion5;
        
         Question levelQuestion6 = new Question();
        levelQuestion6.setQuestion("Who was the 10th prophet of the LDS church in the latter days?");
        levelQuestion6.setAnswerToLevelQuestion("Joseph Fielding Smith"); 
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][5] = levelQuestion6;
        
         Question levelQuestion7 = new Question();
        levelQuestion7.setQuestion("What year did Joseph Smith receive the first vision?");
        levelQuestion7.setAnswerToLevelQuestion("1820"); 
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][6] = levelQuestion7;
    //return questions array
        return levelQuestionArray;
    } 

  
    
    public void setNumMantleQuestion(int numMantleQuestion) {
        this.numMantleQuestion = numMantleQuestion;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public int getNumMantleQuestion() {
        return numMantleQuestion;
    }

    public Scene getScene() {
        return scene;
    }
   
    public String getQuestionAnswered() {
        return questionAnswered;
    }

    public void setQuestionAnswered(String questionAnswered) {
        this.questionAnswered = questionAnswered;
    }

    public String getQuestionPoints() {
        return questionPoints;
    }

    public void setQuestionPoints(String questionPoints) {
        this.questionPoints = questionPoints;
    }

    public int getLastTempleQuestionAsked() {
        return lastTempleQuestionAsked;
    }

    public void setLastTempleQuestionAsked(int lastTempleQuestionAsked) {
        this.lastTempleQuestionAsked = lastTempleQuestionAsked;
    }

    public int getLastLevelQuestionAsked() {
        return lastLevelQuestionAsked;
    }

    public void setLastLevelQuestionAsked(int lastLevelQuestionAsked) {
        this.lastLevelQuestionAsked = lastLevelQuestionAsked;
    }

    public int getLastMantleQuestionAsked() {
        return lastMantleQuestionAsked;
    }

    public void setLastMantleQuestionAsked(int lastMantleQuestionAsked) {
        this.lastMantleQuestionAsked = lastMantleQuestionAsked;
    }
    

    public String  getNextQuestion(QuestionType typeEnum) {
        int index = 0;
        switch (typeEnum){
            case temple:
                //get last temple question asked + 1 save to index
                //by checking modulus here it will return 0 if we go past length requirements so question will start all over
                 index = (this.getLastTempleQuestionAsked() + 1) % questionArray[QuestionType.temple.ordinal()].length;
                //increment last question Asked
                this.setLastTempleQuestionAsked(index++);
                break;
            case mantle:
                //by checking modulus here it will return 0 if we go past length requirements so question will start all over
                 index = (this.getLastMantleQuestionAsked() + 1) % questionArray[QuestionType.mantle.ordinal()].length;
                //increment last question Asked
                this.setLastMantleQuestionAsked(index);
                break;
            case levelQuestions:
                 //by checking modulus here it will return 0 if we go past length requirements so question will start all over
                 index = (this.getLastLevelQuestionAsked() + 1) % questionArray[QuestionType.levelQuestions.ordinal()].length;
                //increment last question Asked
                this.setLastLevelQuestionAsked(index);
                break;
                default: 
                    break;
           
        } 
                
        return questionArray[typeEnum.ordinal()][index];  
    }

    @Override
    public String toString() {
        return "QuestionArray{" + "questionAnswered=" + questionAnswered + ", questionPoints=" + questionPoints + ", mantleQuestionsAsked=" + numMantleQuestion + ", scene=" + scene + ", lastTempleQuestionAsked=" + lastTempleQuestionAsked + ", lastMantleQuestionAsked=" + lastMantleQuestionAsked + ", lastLevelQuestionAsked=" + lastLevelQuestionAsked + '}';
    }
    


   


    public void setQuestionArray(String[][] questionArray) {
        this.questionArray = questionArray;
    }

//    @Override
//    public String toString() {
//        return "QuestionArray{" + "questionType=" + questionType + ", questionAnswered=" + questionAnswered + ", questionNumber=" + questionNumber + ", questionPoints=" + questionPoints + '}';
//    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.questionAnswered);
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
        final QuestionArray other = (QuestionArray) obj;
        if (!Objects.equals(this.questionAnswered, other.questionAnswered)) {
            return false;
        }
        if (!Objects.equals(this.questionPoints, other.questionPoints)) {
            return false;
        }
        if (this.numMantleQuestion != other.numMantleQuestion) {
            return false;
        }
        if (!Objects.equals(this.scene, other.scene)) {
            return false;
        }
        if (this.lastTempleQuestionAsked != other.lastTempleQuestionAsked) {
            return false;
        }
        if (this.lastMantleQuestionAsked != other.lastMantleQuestionAsked) {
            return false;
        }
        if (this.lastLevelQuestionAsked != other.lastLevelQuestionAsked) {
            return false;
        }
        return true;
    }



}