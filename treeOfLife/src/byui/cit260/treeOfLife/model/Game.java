/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.model;

import byui.cit260.treeOfLife.control.MapControl.SceneType;
import byui.cit260.treeOfLife.control.QuestionControl;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author sherihansen
 */
public class Game implements Serializable {
    
    //class instance variables
    private int id;
    private Players player;
    private ProgressMeter progressMeter;
    private Map map;
    private ArrayList<GameInventoryItems> forSale;
    private ArrayList<GameInventoryItems> purchasedItems ;
    private Character[] characters;
    private Character character;
    private QuestionControl totalQuestionsAsked;
    private QuestionArray numLevelQuestionsAnswered;
    private QuestionArray numSetsOfLevelQuestionsAsked ;
    private QuestionArray lastTempleQuestionAsked ;
    private QuestionArray lastMantleQuestionAsked ;
    private QuestionArray lastLevelQuestionAsked;

    public QuestionArray getNumLevelQuestionsAnswered() {
        return numLevelQuestionsAnswered;
    }

    public void setNumLevelQuestionsAnswered(QuestionArray numLevelQuestionsAnswered) {
        this.numLevelQuestionsAnswered = numLevelQuestionsAnswered;
    }

    public QuestionArray getNumSetsOfLevelQuestionsAsked() {
        return numSetsOfLevelQuestionsAsked;
    }

    public void setNumSetsOfLevelQuestionsAsked(QuestionArray numSetsOfLevelQuestionsAsked) {
        this.numSetsOfLevelQuestionsAsked = numSetsOfLevelQuestionsAsked;
    }

    public QuestionArray getLastTempleQuestionAsked() {
        return lastTempleQuestionAsked;
    }

    public void setLastTempleQuestionAsked(QuestionArray lastTempleQuestionAsked) {
        this.lastTempleQuestionAsked = lastTempleQuestionAsked;
    }

    public QuestionArray getLastMantleQuestionAsked() {
        return lastMantleQuestionAsked;
    }

    public void setLastMantleQuestionAsked(QuestionArray lastMantleQuestionAsked) {
        this.lastMantleQuestionAsked = lastMantleQuestionAsked;
    }

    public QuestionArray getLastLevelQuestionAsked() {
        return lastLevelQuestionAsked;
    }

    public void setLastLevelQuestionAsked(QuestionArray lastLevelQuestionAsked) {
        this.lastLevelQuestionAsked = lastLevelQuestionAsked;
    }
    

    
    
    public QuestionControl getTotalQuestionsAsked() {
        return totalQuestionsAsked;
    }

    public void setTotalQuestionsAsked(QuestionControl totalQuestionsAsked) {
        this.totalQuestionsAsked = totalQuestionsAsked;
    }

    public Players getPlayer() {
        return player;
    }

    public void setPlayer(Players player) {
        this.player = player;
    }

    public ProgressMeter getProgressMeter() {
        return progressMeter;
    }

    public void setProgressMeter(ProgressMeter progressMeter) {
        this.progressMeter = progressMeter;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    
    public Character[] getCharactersArray() {
        return characters;
    }

    public void setCharactersArray(Character[] characters) {
        this.characters = characters;
    }

    public ArrayList<GameInventoryItems> getForSale() {
        return forSale;
    }

    public void setForSale(ArrayList<GameInventoryItems> forSale) {
        this.forSale = forSale;
    }

    public ArrayList<GameInventoryItems> getPurchasedItems() {
        return purchasedItems;
    }

    public void setPurchasedItems(ArrayList<GameInventoryItems> purchasedItems) {
        this.purchasedItems = purchasedItems;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
    

    public Game() {
    }

  
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Game{" + "id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.id;
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
        final Game other = (Game) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

   
    
}
