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
public class EndGameLifeView extends View {

    public EndGameLifeView() {
        super("\n"
  
            +"\n===================================================================="
            +"\n\t\t\tThe Tree of Life                              "
            +"\n===================================================================="
            +"\nAfter great effort and faith during your journey, you are rewarded"
            +"\nwith with all the blessings in heaven! The trumpets have sounded and "
            +"\nthe Angels are singing, Welcome home to the Tree of Life!"
            +"\n"
            +"\nThanks for playing the Tree Of Life!"
            +"\nBe sure to give us an A after playing our game!"    
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
