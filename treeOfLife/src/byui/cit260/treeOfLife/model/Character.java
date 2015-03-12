/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.model;

import java.awt.Point;
import java.util.Objects;
import java.io.Serializable;
/**
 *
 * @author Chuck
 */
public enum Character implements Serializable{
    
    Nephi("Faithful son and later the prophet and leader of the Nephites."),
    Sariah("She is Lehi's wife and mother of Nephi and Jacob"),
    Jacob("Nephi's faithful brother, prophet and successor to Nephi.");
    
    private final String description;
    private final Point coordinates;
    private final String origStatLevels;
    private Game gameID;
    private Location location;

    public Game getGameID() {
        return gameID;
    }

    public void setGameID(Game gameID) {
        this.gameID = gameID;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    Character(String description){
    this.description = description;
    coordinates = new Point(1,1);
    origStatLevels = this.getOrigStatLevels();
    }

    public String getDescription() {
        return description;
    }
    
    public String getOrigStatLevels() {
       return origStatLevels;
    }

    @Override
    public String toString() {
        return "Character{ description=" + description + ", origStatLevels=" + origStatLevels + '}';
    }

   

   
    
    
}
