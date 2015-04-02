/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.model;

import byui.cit260.treeOfLife.view.View;
import java.util.Objects;
import java.io.Serializable;
import javax.swing.ImageIcon;
/**
 *
 * @author Chuck
 */
public class Scene implements Serializable{
   
    private String descriptions;
    private String userQuestions;
    private Location location;
    private QuestionArray[][] questions;
    private String mapSymbol;
    private Boolean blocked;
    private View sceneView;

     public Scene() {
    }

    public View getSceneView() {
        return sceneView;
    }

    public void setSceneView(View sceneView) {
        this.sceneView = sceneView;
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

       
   public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public QuestionArray[][] getQuestions() {
        return questions;
    }

    public void setQuestions(QuestionArray[][] questions) {
        this.questions = questions;
    }
    
    public String getMapSymbol() {
        return mapSymbol;
    }

    public void setMapSymbol(String mapSymbol) {
        this.mapSymbol = mapSymbol;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

   public void setIcon(ImageIcon startingSceneImage) {
        System.out.println("**** setIcon() function was called ****");
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
//believe these are duplicates
//    void setDescription(String string) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    void setMapSymbol(String _st_) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    void setBlocked(boolean b) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
    
    
    
}
