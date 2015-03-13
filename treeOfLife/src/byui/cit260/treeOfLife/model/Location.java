/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.model;

import java.io.Serializable;

/**
 *
 * @author sherihansen
 */
public class Location implements Serializable{
    
    //class instance variables
    private int row;
    private int column;
    private int xCoordinate;
    private int yCoordinate;
    private boolean blocked;
    private boolean visited;
    private Scene scene;
    private Character[] character; 
    
    //constructor
    public Location() {
    }
    
    //getters and setters

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    
    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public boolean isBlocked() {
        return blocked;
//        return false; //for testing purposes only
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Character[] getCharacter() {
        return character;
    }

    public void setCharacter(Character[] character) {
        this.character = character;
    }
    

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
    @Override
    public String toString() {
        return "Location{" + "xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate + ", blocked=" + blocked + ", visited=" + visited + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.xCoordinate;
        hash = 83 * hash + this.yCoordinate;
        hash = 83 * hash + (this.blocked ? 1 : 0);
        hash = 83 * hash + (this.visited ? 1 : 0);
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
        final Location other = (Location) obj;
        if (this.xCoordinate != other.xCoordinate) {
            return false;
        }
        if (this.yCoordinate != other.yCoordinate) {
            return false;
        }
        if (this.blocked != other.blocked) {
            return false;
        }
        if (this.visited != other.visited) {
            return false;
        }
        return true;
    }


    
    
    
}
