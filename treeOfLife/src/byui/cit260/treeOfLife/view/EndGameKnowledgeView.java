/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

/**
 *
 * @author Chuck
 */
public class EndGameKnowledgeView extends View {

    public EndGameKnowledgeView() {
        super("\n"
  
            +"\n===================================================================="
            +"\n\t\t\tThe Tree of Knowledge                                 "
            +"\n===================================================================="
            +"\nYou achieved the Tree of Knowledge. While you achieved many things "
            +"\nduring your journey, your faith was not great enough to achieve the "
            +"\nTree of Life."
            +"\n"
            +"\nPlease try again to see if you have what it takes to make it to"
            +"\nthe tree of life!"
            +"\nThanks for playing the Tree Of Life!"
//            +"\nQ - Return to Main Menu" 
            +"\n====================================================================");
        
        //Display Final Message based on end user result
        //Hit Q to end game
    }

    

    @Override
    public boolean doAction(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
