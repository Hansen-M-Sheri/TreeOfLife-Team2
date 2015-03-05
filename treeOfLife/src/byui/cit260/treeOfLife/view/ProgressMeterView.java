/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import java.util.Scanner;

/**
 *
 * @author sherihansen
 */
public class ProgressMeterView extends View{
 public ProgressMeterView(){
        super("\n"
            +"\n======================================================"
            +"\n| Progress Meter                                      |"
            +"\n======================================================"
            +"\n Current Level is ..."
            +"\n Faith is ..."
            +"\n Knowledge is ..."
            +"\n Obedience is ..."
            +"\n Faith needed to increase in level is ...."
            +"\n Knoweldge needed to increase in level is ...."
            +"\n Obedience needed to increase in level is ...."
            +"\n Armor Items Earned: "
             +"\n items earned here "
            +"\nG - Game Menu"
            +"\nQ- Return to Main Menu"
            
            +"\n======================================================");

        }  

   

    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase(); //convert to all upper case
        char choice = value.charAt(0); //get first character entered
        System.out.println("doActionProgressMeter function called");
                return true;
    }
}