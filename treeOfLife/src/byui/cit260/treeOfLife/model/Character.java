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
}
    @Override
    public String toString() {
        return "Character{" + "name=" + name + ", description=" + description + ", origStatLevels=" + origStatLevels + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.name);
        hash = 61 * hash + Objects.hashCode(this.description);
        hash = 61 * hash + Objects.hashCode(this.origStatLevels);
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
        final Character other = (Character) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.origStatLevels, other.origStatLevels)) {
            return false;
        }
        return true;
    }

   
    
    
}
