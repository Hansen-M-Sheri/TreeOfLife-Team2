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
public enum GameInventoryItems implements Serializable{
    //define list of items in class
//define list of items in class
//define list of items in class
//define list of items in class
//define list of items in class
//define list of items in class
//define list of items in class
//define list of items in class
    Helmet("Helmet of Salvation", 5,3, 10),
    ProtectiveShield("Protective sheriShield of Faith", 10, 5, 5),
    TruthBelt("Belt of Truth", 4, 8, 4),
    FootCovering("Feet shod with Peace", 3, 3, 6),
    Sword("Sword of Truth", 8, 8, 8),
    BreastPlate("BreastPlate of Righteousness", 10, 2, 8), 
    
    ;
    
    
    //class instance variables
    private String itemDescription;
    private String armorPiece;
    private int faithPoints;      //faith points associated with armor piece
    private int obedPoints;       // obedience points associated with armor piece
    private int knowPoints;       // knowledge points associated with armor piece 
    
    //constructor
    GameInventoryItems(String itemDescription, int faithPoints, int obedPoints, int knowPoints) {
        this.itemDescription = itemDescription;
        this.faithPoints = faithPoints;
        this.obedPoints = obedPoints;
        this.knowPoints = knowPoints;
    }
    
//
    //getter and setters

    public String getItemDescription() {
        return itemDescription;
    }

   
    public String getArmorPiece() {
        return armorPiece;
    }

    

    public int getFaithPoints() {
        return faithPoints;
    }

    

    public int getObedPoints() {
        return obedPoints;
    }

    

    public int getKnowPoints() {
        return knowPoints;
    }

   

    @Override
    public String toString() {
        return "GameInventoryItems{" + "itemDescription=" + itemDescription + ", armorPiece=" + armorPiece + ", armorPieceFaithPoints=" + faithPoints + ", armorPieceObedPoints=" + obedPoints + ", armorPieceKnowPoints=" + knowPoints + '}';
    }

    

   

    
}
