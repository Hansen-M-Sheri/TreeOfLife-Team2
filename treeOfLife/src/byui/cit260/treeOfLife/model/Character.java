/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.model;

import java.util.Objects;
import java.io.Serializable;
/**
 *
 * @author Chuck
 */
public class Character implements Serializable{
    
    private String name;
    private String description;
    private String origStatLevels;

    public Character() {
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrigStatLevels() {
        return origStatLevels;
    }

    public void setOrigStatLevels(String origStatLevels) {
        this.origStatLevels = origStatLevels;
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
