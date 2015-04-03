/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.model;

import byui.cit260.treeOfLife.control.QuestionControl;
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
    private static int numLevelQuestionsAnswered = 0;
    private static int numSetsOfLevelQuestionsAsked ;
    private Scene scene;
   
    private static String[][] questionArray;
    private static Question[][] levelQuestionArray;
    private static int lastTempleQuestionAsked ;
    private static int lastMantleQuestionAsked ;
    private static int lastLevelQuestionAsked;
    private static int numTempleQuestion;

   
   
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
         levelQuestionArray = new Question[3][21];
         
        Question levelQuestion1 = new Question();
        levelQuestion1.setQuestion("What is the name of the prophet that preached repentance to King Noah and suffered death by fire?");
        levelQuestion1.setAnswerToLevelQuestion("Abinadi");
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
        levelQuestion5.setAnswerToLevelQuestion("6");
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][4] = levelQuestion5;
        
         Question levelQuestion6 = new Question();
        levelQuestion6.setQuestion("Who was the 10th prophet of the LDS church in the latter days?");
        levelQuestion6.setAnswerToLevelQuestion("Joseph Fielding Smith"); 
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][5] = levelQuestion6;
        
         Question levelQuestion7 = new Question();
        levelQuestion7.setQuestion("What year did Joseph Smith receive the first vision?");
        levelQuestion7.setAnswerToLevelQuestion("1820"); 
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][6] = levelQuestion7;
        
        Question levelQuestion8 = new Question();
        levelQuestion8.setQuestion("What is fourth book in the Book of Mormon?");
        levelQuestion8.setAnswerToLevelQuestion("Enos"); 
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][7] = levelQuestion8;
        
        Question levelQuestion9 = new Question();
        levelQuestion9.setQuestion("Besides Ether who were the last two survivors of the Jaredite Nation?");
        levelQuestion9.setAnswerToLevelQuestion("Coriantumr and Shiz"); 
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][8] = levelQuestion9;
        
        Question levelQuestion10 = new Question();
        levelQuestion10.setQuestion("What year did Joseph Smith receive the first vision?");
        levelQuestion10.setAnswerToLevelQuestion("1820"); 
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][9] = levelQuestion10;
        
        Question levelQuestion11 = new Question();
        levelQuestion11.setQuestion("Who demanded a sign of Alma the Younger?");
        levelQuestion11.setAnswerToLevelQuestion("Korihor"); 
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][10] = levelQuestion11;
        
        Question levelQuestion12 = new Question();
        levelQuestion12.setQuestion("Which office of the Aaronic priesthood is in charge of passing the sacrament?");
        levelQuestion12.setAnswerToLevelQuestion("Deacon"); 
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][11] = levelQuestion12;
        
        Question levelQuestion13 = new Question();
        levelQuestion13.setQuestion("How many books are in the Book of Mormon?");
        levelQuestion13.setAnswerToLevelQuestion("15"); 
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][12] = levelQuestion13;
        
        Question levelQuestion14 = new Question();
        levelQuestion14.setQuestion("What was the name of the stones with which Joseph Smith translated the Book of Mormon??");
        levelQuestion14.setAnswerToLevelQuestion("Urim and Thummim"); 
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][13] = levelQuestion14;
        
        Question levelQuestion15 = new Question();
        levelQuestion15.setQuestion("Who was Enos’ father?");
        levelQuestion15.setAnswerToLevelQuestion("Jacob"); 
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][14] = levelQuestion15;
        
        Question levelQuestion16 = new Question();
        levelQuestion16.setQuestion("How many witnesses were mentioned in the front of the Book of Mormon?");
        levelQuestion16.setAnswerToLevelQuestion("11"); 
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][15] = levelQuestion16;
        
        Question levelQuestion17 = new Question();
        levelQuestion17.setQuestion("What type of metal was the Liahona made of?");
        levelQuestion17.setAnswerToLevelQuestion("brass"); 
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][16] = levelQuestion17;
        
        Question levelQuestion18 = new Question();
        levelQuestion18.setQuestion("For how many years did Joseph Smith serve as President of the church?");
        levelQuestion18.setAnswerToLevelQuestion("14"); 
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][17] = levelQuestion18;
        
        Question levelQuestion19 = new Question();
        levelQuestion19.setQuestion("Fill in the blank to this primary song. \"Jesus wants me for a \n" +
"_____________.\"");
        levelQuestion19.setAnswerToLevelQuestion("sunbeam"); 
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][18] = levelQuestion19;
        
        Question levelQuestion20 = new Question();
        levelQuestion20.setQuestion("Daniel was thrown into a den of _________________.");
        levelQuestion20.setAnswerToLevelQuestion("Lion"); 
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][19] = levelQuestion20;
        
        Question levelQuestion21 = new Question();
        levelQuestion21.setQuestion("What Lamanite stood on the city wall and called the Nephites To Repentance?");
        levelQuestion21.setAnswerToLevelQuestion("Samuel"); 
        levelQuestionArray[QuestionType.levelQuestions.ordinal()][20] = levelQuestion21;
    //return questions array
        return levelQuestionArray;
    } 

    public static int getNumSetsOfLevelQuestionsAsked() {
        return numSetsOfLevelQuestionsAsked;
    }

    public static void setNumSetsOfLevelQuestionsAsked(int numSetsOfLevelQuestionsAsked) {
        QuestionArray.numSetsOfLevelQuestionsAsked = numSetsOfLevelQuestionsAsked;
    }

    public static int getNumTempleQuestion() {
        return numTempleQuestion;
    }
     public static void setNumTempleQuestion(int numTempleQuestion) {
        QuestionArray.numTempleQuestion = numTempleQuestion;
    }
    public static int getNumLevelQuestionsAnswered() {
        return numLevelQuestionsAnswered;
    }

    public static void setNumLevelQuestionsAnswered(int numLevelQuestionsAnswered) {
        QuestionArray.numLevelQuestionsAnswered = numLevelQuestionsAnswered;
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
                 index = (this.lastTempleQuestionAsked + 1) % questionArray[QuestionType.temple.ordinal()].length;
                //increment last question Asked
                this.lastTempleQuestionAsked++;
                break;
            case mantle:
                //by checking modulus here it will return 0 if we go past length requirements so question will start all over
                 index = (this.getLastMantleQuestionAsked() + 1) % questionArray[QuestionType.mantle.ordinal()].length;
                //increment last question Asked
                this.setLastMantleQuestionAsked(index);
                break;
//            case levelQuestions:
//                 //by checking modulus here it will return 0 if we go past length requirements so question will start all over
//                 index = (this.getLastLevelQuestionAsked() + 1) % levelQuestionArray[QuestionType.levelQuestions.ordinal()].length;
//                //increment last question Asked
//                this.setLastLevelQuestionAsked(index);
//                Question question =  levelQuestionArray[QuestionType.levelQuestions.ordinal()][index];
//                
//                return question.getQuestion();
                default: 
                    break;
           
        } 
                
        return questionArray[typeEnum.ordinal()][index];  
    }
    
    public Question getNextLevelQuestion() {
        //by checking modulus here it will return 0 if we go past length requirements so question will start all over
        int index = (this.getLastLevelQuestionAsked() + 1) % levelQuestionArray[QuestionType.levelQuestions.ordinal()].length;
        //increment last question Asked
        this.setLastLevelQuestionAsked(index);
        Question question =  levelQuestionArray[QuestionType.levelQuestions.ordinal()][index];

        return question; 
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