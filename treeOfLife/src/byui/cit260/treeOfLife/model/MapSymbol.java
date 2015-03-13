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
public enum MapSymbol implements Serializable{
   
    //define list of items in class
    Mantle("-M-"),
    Temple("-T-"),
    ArmorShop("-A-"),
    Level1("LVL 1"),
    Level2("LVL 2"),
    Level3("LVL 3"),
    Level4("LVL 4"),
    Level5("LVL 5"),
    Cottage("-C-"),
    TreeOfLife("*"),
    TreeOfKnowledge("!"),
    SpaciousBuilding("#$&");
    
//     define list of items in class
//    Mantle("-M-"),
//    Temple("-T-"),
//    ArmorShop("-A-"),
//    Level1("LVL 1"),
//    Level2("LVL 2"),
//    Level3("LVL 3"),
//    Level4("LVL 4"),
//    Level5("LVL 5"),
//    Cottage("-C-"),
//    TreeOfLife("*"),
//    TreeOfKnowledge("!"),
//    SpaciousBuilding("#$&");
    
  private String symbol;
     //constructor
    MapSymbol(String symbol) {
        this.symbol = symbol;
       
    }
    public String getSymbol() {
        return symbol;
    }
}
