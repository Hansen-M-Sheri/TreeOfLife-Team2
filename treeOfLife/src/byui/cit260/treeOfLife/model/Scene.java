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
public class Scene implements Serializable{
   
    private String descriptions;
    private String userQuestions;

    public Scene() {
    }
    
    

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getUserQuestions() {
        return userQuestions;
    }

    public void setUserQuestions(String userQuestions) {
        this.userQuestions = userQuestions;
    }

    @Override
    public String toString() {
        return "Scene{" + "descriptions=" + descriptions + ", userQuestions=" + userQuestions + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.descriptions);
        hash = 61 * hash + Objects.hashCode(this.userQuestions);
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
        final Scene other = (Scene) obj;
        if (!Objects.equals(this.descriptions, other.descriptions)) {
            return false;
        }
        if (!Objects.equals(this.userQuestions, other.userQuestions)) {
            return false;
        }
        return true;
    }
    
    
}
