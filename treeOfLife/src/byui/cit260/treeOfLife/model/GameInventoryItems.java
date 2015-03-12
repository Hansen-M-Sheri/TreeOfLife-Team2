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
    helmet("helmet of Faith", 5,3, 10),
    breastPlate("breastPlate of righteousness", 10, 2, 8), 
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
    
//enum constructor
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
