/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author sherihansen
 */
public class GameInventoryItems implements Serializable{
    
    //class instance variables
    private String itemDescription;
    private String armorPiece;
    private int armorPieceFaithPoints;      //faith points associated with armor piece
    private int armorPieceObedPoints;       // obedience points associated with armor piece
    private int armorPieceKnowPoints;       // knowledge points associated with armor piece 
  
    //constructor
    public GameInventoryItems() {
    }
    
    //getter and setters

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getArmorPiece() {
        return armorPiece;
    }

    public void setArmorPiece(String armorPiece) {
        this.armorPiece = armorPiece;
    }

    public int getArmorPieceFaithPoints() {
        return armorPieceFaithPoints;
    }

    public void setArmorPieceFaithPoints(int armorPieceFaithPoints) {
        this.armorPieceFaithPoints = armorPieceFaithPoints;
    }

    public int getArmorPieceObedPoints() {
        return armorPieceObedPoints;
    }

    public void setArmorPieceObedPoints(int armorPieceObedPoints) {
        this.armorPieceObedPoints = armorPieceObedPoints;
    }

    public int getArmorPieceKnowPoints() {
        return armorPieceKnowPoints;
    }

    public void setArmorPieceKnowPoints(int armorPieceKnowPoints) {
        this.armorPieceKnowPoints = armorPieceKnowPoints;
    }

    @Override
    public String toString() {
        return "GameInventoryItems{" + "itemDescription=" + itemDescription + ", armorPiece=" + armorPiece + ", armorPieceFaithPoints=" + armorPieceFaithPoints + ", armorPieceObedPoints=" + armorPieceObedPoints + ", armorPieceKnowPoints=" + armorPieceKnowPoints + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.itemDescription);
        hash = 29 * hash + Objects.hashCode(this.armorPiece);
        hash = 29 * hash + this.armorPieceFaithPoints;
        hash = 29 * hash + this.armorPieceObedPoints;
        hash = 29 * hash + this.armorPieceKnowPoints;
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
        final GameInventoryItems other = (GameInventoryItems) obj;
        if (!Objects.equals(this.itemDescription, other.itemDescription)) {
            return false;
        }
        if (!Objects.equals(this.armorPiece, other.armorPiece)) {
            return false;
        }
        if (this.armorPieceFaithPoints != other.armorPieceFaithPoints) {
            return false;
        }
        if (this.armorPieceObedPoints != other.armorPieceObedPoints) {
            return false;
        }
        if (this.armorPieceKnowPoints != other.armorPieceKnowPoints) {
            return false;
        }
        return true;
    }

    
}
