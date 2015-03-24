/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author sherihansen
 */
public class ProgressMeter implements Serializable {
    
    //class instance variables
    private int faithStat;      //current stats in faith
    private int knowledgeStat;  //current stats in knowledge
    private int obedienceStat;  //current stats in obedience
    private int faithNeededToLevelUp;   //numb of faith needed to level up
    private int knowNeededToLevelUp;    //numb knowledge needed to level up
    private int obedNeededToLevelUp;    //number obedience needed to level up
    private int currentLevel;           //current level player is at
    private boolean helmetEarned;       //T if helmet earned
    private boolean shieldEarned;       
    private boolean beltEarned;
    private boolean footCoveringEarned;
    private boolean swordEarned;
    private boolean breastplateEarned;
    ArrayList<Game> gameID = new ArrayList<>();
    //constructor

    public ArrayList<Game> getGameID() {
        return gameID;
    }

    public void setGameID(ArrayList<Game> gameID) {
        this.gameID = gameID;
    }

    public ProgressMeter() {
    }

    public ProgressMeter(int faithStat, int knowledgeStat, int obedienceStat) {
        this.faithStat = faithStat;
        this.knowledgeStat = knowledgeStat;
        this.obedienceStat = obedienceStat;
    }
    
    
    public int getFaithStat() {
        System.out.println("getFaithStat() called");
        return faithStat;
    }

    public void setFaithStat(int faithStat) {
        
        this.faithStat = faithStat;
    }

    public int getKnowledgeStat() {
        System.out.println("getKnowledgeStat() called");
        return knowledgeStat;
    }

    public void setKnowledgeStat(int knowledgeStat) {
        this.knowledgeStat = knowledgeStat;
    }

    public int getObedienceStat() {
        System.out.println("getObedienceStat() called");
        return obedienceStat;
    }

    public void setObedienceStat(int obedienceStat) {
        this.obedienceStat = obedienceStat;
    }

    public int getFaithNeededToLevelUp() {
        return faithNeededToLevelUp;
    }

    public void setFaithNeededToLevelUp(int faithNeededToLevelUp) {
        this.faithNeededToLevelUp = faithNeededToLevelUp;
    }

    public int getKnowNeededToLevelUp() {
        return knowNeededToLevelUp;
    }

    public void setKnowNeededToLevelUp(int knowNeededToLevelUp) {
        this.knowNeededToLevelUp = knowNeededToLevelUp;
    }

    public int getObedNeededToLevelUp() {
        return obedNeededToLevelUp;
    }

    public void setObedNeededToLevelUp(int obedNeededToLevelUp) {
        this.obedNeededToLevelUp = obedNeededToLevelUp;
    }

    public int getCurrentLevel() {
        System.out.println("getCurrentLevel() called");
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public boolean isHelmetEarned() {
        return helmetEarned;
    }

    public void setHelmetEarned(boolean helmetEarned) {
        this.helmetEarned = helmetEarned;
    }

    public boolean isShieldEarned() {
        return shieldEarned;
    }

    public void setShieldEarned(boolean shieldEarned) {
        this.shieldEarned = shieldEarned;
    }

    public boolean isBeltEarned() {
        return beltEarned;
    }

    public void setBeltEarned(boolean beltEarned) {
        this.beltEarned = beltEarned;
    }

    public boolean isFootCoveringEarned() {
        return footCoveringEarned;
    }

    public void setFootCoveringEarned(boolean footCoveringEarned) {
        this.footCoveringEarned = footCoveringEarned;
    }

    public boolean isSwordEarned() {
        return swordEarned;
    }

    public void setSwordEarned(boolean swordEarned) {
        this.swordEarned = swordEarned;
    }

    public boolean isBreastplateEarned() {
        return breastplateEarned;
    }

    public void setBreastplateEarned(boolean breastplateEarned) {
        this.breastplateEarned = breastplateEarned;
    }

    @Override
    public String toString() {
        return "ProgressMeter{" + "faithStat=" + faithStat + ", knowledgeStat=" + knowledgeStat + ", obedienceStat=" + obedienceStat + ", faithNeededToLevelUp=" + faithNeededToLevelUp + ", knowNeededToLevelUp=" + knowNeededToLevelUp + ", obedNeededToLevelUp=" + obedNeededToLevelUp + ", currentLevel=" + currentLevel + ", helmetEarned=" + helmetEarned + ", shieldEarned=" + shieldEarned + ", beltEarned=" + beltEarned + ", footCoveringEarned=" + footCoveringEarned + ", swordEarned=" + swordEarned + ", breastplateEarned=" + breastplateEarned + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.faithStat;
        hash = 59 * hash + this.knowledgeStat;
        hash = 59 * hash + this.obedienceStat;
        hash = 59 * hash + this.faithNeededToLevelUp;
        hash = 59 * hash + this.knowNeededToLevelUp;
        hash = 59 * hash + this.obedNeededToLevelUp;
        hash = 59 * hash + this.currentLevel;
        hash = 59 * hash + (this.helmetEarned ? 1 : 0);
        hash = 59 * hash + (this.shieldEarned ? 1 : 0);
        hash = 59 * hash + (this.beltEarned ? 1 : 0);
        hash = 59 * hash + (this.footCoveringEarned ? 1 : 0);
        hash = 59 * hash + (this.swordEarned ? 1 : 0);
        hash = 59 * hash + (this.breastplateEarned ? 1 : 0);
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
        final ProgressMeter other = (ProgressMeter) obj;
        if (this.faithStat != other.faithStat) {
            return false;
        }
        if (this.knowledgeStat != other.knowledgeStat) {
            return false;
        }
        if (this.obedienceStat != other.obedienceStat) {
            return false;
        }
        if (this.faithNeededToLevelUp != other.faithNeededToLevelUp) {
            return false;
        }
        if (this.knowNeededToLevelUp != other.knowNeededToLevelUp) {
            return false;
        }
        if (this.obedNeededToLevelUp != other.obedNeededToLevelUp) {
            return false;
        }
        if (this.currentLevel != other.currentLevel) {
            return false;
        }
        if (this.helmetEarned != other.helmetEarned) {
            return false;
        }
        if (this.shieldEarned != other.shieldEarned) {
            return false;
        }
        if (this.beltEarned != other.beltEarned) {
            return false;
        }
        if (this.footCoveringEarned != other.footCoveringEarned) {
            return false;
        }
        if (this.swordEarned != other.swordEarned) {
            return false;
        }
        if (this.breastplateEarned != other.breastplateEarned) {
            return false;
        }
        return true;
    }

    public void getItemsEarned() { //use this to gather all items earned from armorshop for player
       System.out.println("getItemsEarned() funciton has been called");
    }
 
    
}
