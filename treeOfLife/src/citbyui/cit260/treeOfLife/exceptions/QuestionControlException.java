/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.treeOfLife.exceptions;

/**
 *
 * @author sherihansen
 */
public class QuestionControlException extends Exception{

    public QuestionControlException() {
    }

    public QuestionControlException(String message) {
        super(message);
    }

    public QuestionControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionControlException(Throwable cause) {
        super(cause);
    }

    public QuestionControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
