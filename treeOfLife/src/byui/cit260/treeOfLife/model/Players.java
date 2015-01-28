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
public class Players implements Serializable {
    private String name;

    /*public Players(String name) {
        this.name = name;
    }*/
    
    public Players() {
 
        
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        
        
    }

    @Override
    public String toString() {
        return "Players{" + "name=" + name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.name);
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
        final Players other = (Players) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
}
