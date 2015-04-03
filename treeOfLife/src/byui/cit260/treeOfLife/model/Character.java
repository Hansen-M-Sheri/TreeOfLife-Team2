/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.model;

import java.awt.Point;
import java.util.Objects;
import java.io.Serializable;
import treeoflife.TreeOfLife;
/**
 *
 * @author Chuck
 */
public enum Character implements Serializable{
    
    Nephi("Faithful son and later the prophet and leader of the Nephites.", 10, 5, 5),
    Sariah("She is Lehi's wife and mother of Nephi and Jacob", 5,5,10),
    Jacob("Nephi's faithful brother, prophet and successor to Nephi.", 5,10,5);
    
    private final String description;
    private final Point coordinates;

    private final int origFaithLevel;
    private final int origKnowLevel;
    private final int origObedLevel;
    private Game gameID;
   

    public Game getGameID() {
        return gameID;
    }

    public void setGameID(Game gameID) {
        this.gameID = gameID;
    }

    

    
    
    Character(String description, int origFaithLevel,int origKnowLevel, int origObedLevel ){
    this.description = description;
    coordinates = new Point(0,1);//@todo change to 0,1 for live game - testing level1
//    origStatLevels = this.getOrigStatLevels();
    this.origFaithLevel = origFaithLevel;
    this.origKnowLevel = origKnowLevel;
    this.origObedLevel = origObedLevel;
    }

    public int getOrigFaithLevel() {
        return origFaithLevel;
    }

    public int getOrigKnowLevel() {
        return origKnowLevel;
    }

    public int getOrigObedLevel() {
        return origObedLevel;
    }

    public String getDescription() {
        return description;
    }
    
    
    
    public Point getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "Character{" + "description=" + description + ", coordinates=" + coordinates + ", origFaithLevel=" + origFaithLevel + ", origKnowLevel=" + origKnowLevel + ", origObedLevel=" + origObedLevel + ", gameID=" + gameID + '}';
    }

    

   
    
}
