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
public class EndGameBuildingView extends View{

    public EndGameBuildingView() {
        super("\n"
  
            +"\n================================================================="
            +"\n\t\t\tThe Large and Spacious Building                           "
            +"\n================================================================="
            +"\nYou only achieved the Large and Spacious Building. A great deal "
            +"\nmore faith is required on you part."
            +"\n"
            +"\nPlease try again to see if you have what it takes to make it to"
            +"\nthe tree of life!"
            +"\nThanks for playing the Tree Of Life!"
//            +"\nQ - Return to Main Menu" 
            +"\n=================================================================");
   
        
        
        //Display Final Message based on end user result
        //Hit Q to end game
    }

    

    @Override
    public boolean doAction(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
