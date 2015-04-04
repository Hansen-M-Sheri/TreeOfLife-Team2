/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import byui.cit260.treeOfLife.model.ProgressMeter;
import treeoflife.TreeOfLife;

/**
 *
 * @author Chuck
 */
public class JudgementBarView extends View {

    public JudgementBarView() {
        super("\n"
    
            +"\n================================================================="
            +"\n\t\t\t Day of Judgement                          "
            +"\n================================================================="
            +"\nJ - Judgment Day - Discover Your Fate!"
            +"\n=================================================================");
    
        
        // Display Message
        //pull progress meter data
        //compare faith points to determine final stage of game
        //based on faith point total go to correct end game scene
        
    }

    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase(); //convert to all upper case
        char choice = value.charAt(0); //get first character entered
        switch (choice){
            case 'J':// Go to the Map
                this.calculateEndFaithPoints();
                break;
            default:
            ErrorView.display("JudgmentBarView", "*** Invalid game menu selection *** Try again");
                break;
    
    }
     return true;   
    }
    

       
    


    private void calculateEndFaithPoints() {
        int finalFaith = TreeOfLife.getCurrentGame().getProgressMeter().getFaithStat();
       
       if (finalFaith < 487){
           View endView = new EndGameBuildingView();
                if (endView != null){
                endView.display();
                }
       }else if(finalFaith >= 487 && finalFaith < 1083){
           View endView = new EndGameKnowledgeView();
                if (endView != null){
                endView.display();
                }
       }else if(finalFaith >= 1084 || finalFaith > 487 && finalFaith < 1083){
           View endView = new EndGameLifeView();
                if (endView != null){
                endView.display();
                }
       }
    }
}
