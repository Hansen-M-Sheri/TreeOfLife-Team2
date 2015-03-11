/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.model;


import byui.cit260.treeOfLife.control.GameControl;
import byui.cit260.treeOfLife.control.MapControl;
import byui.cit260.treeOfLife.control.ProgramControl;
import java.awt.image.BufferedImage;
import java.util.Objects;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Chuck
 */


public class Map implements Serializable{

    public enum SceneType{
    cottage,
    levelOne,
    levelTwo,
    levelThree,
    levelFour,
    levelFive,
    mantle,
    temple,
    armorShop,
    treeOfLife,
    treeOfKnowledge,
    spaciousBuilding, 
    finish;
    }
    private static Scene[] createScenes()throws MapControlException{
        BufferedImage image = null;
        
        Game game = ProgramControl.getCurrentGame(); 

        //Create the scenes array
        Scene[] scenes = new Scene[SceneType.values().length];
        //Create scene 1
        Scene startingScene = new Scene();
        startingScene.setDescription(
                "\nCottage Opening Scene Description"
                +"Need to add content");
        startingScene.setMapSymbol(" ST ");
        startingScene.setBlocked(false);
        ImageIcon startingSceneImage = MapControl.getImage(startingScene,
                "/citbyui/citC260/curiousworkmanship/images/startingPoint.jpg");
        startingScene.setIcon(startingSceneImage);
        scenes[SceneType.cottage.ordinal()] = startingScene;
        
        Scene finishScene = new Scene();
        finishScene.setDescriptions(
                "\nCongratulations! Well done you have made it to the Tree of Life."
                +"add more content");
        finishScene.setMapSymbol(" FN");
        finishScene.setBlocked(false);
        ImageIcon finishSceneImage = MapControl.getImage(finishScene,
                "/citbyui/citC260/curiousworkmanship/images/finish.jpg");
                finishScene.setIcon(finishSceneImage);
        scenes[SceneType.finish.ordinal()] = finishScene;
        
        
        
        //Assign scene 1 to array
        //…
        //Create scene N
        //Assign scene N to array
        //return scenes array 
    
    }
    
    private int rowCount;
    private int columnCount;
    ArrayList<Game> gameID = new ArrayList<>();
    private Location[][] locations;
    
    public ArrayList<Game> getGameID() {
        return gameID;
    }

    public void setGameID(ArrayList<Game> gameID) {
        this.gameID = gameID;
    }

    public Map() {
    }
    
    public Map(int rowCount, int columnCount){
        
        if (rowCount < 1 || columnCount <1){
            System.out.println("The number of rows and columns > zero");
            return;
        }
        
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        
        // create 2-D array for lcoation objects
        this.locations = new Location[rowCount][columnCount];
        
        for (int row = 0; row < rowCount; row++){
            for(int column = 0; column < columnCount; column++){
                //create and initialize New Location object instance
                Location location = new Location();
                location.setColumn(column);
                location.setRow(row);
                location.setVisited(false);
                
                // assign the Location object to the current postion in array
                locations[row][column] = location;
                
            }
        
        
    }
        
    }
    
    private static Map createMap(){
        
        //Create and initialize new map
        Map map = new Map(3, 4);
        //Create all of the scenes for the map
        Scene[] scenes = createScenes();
        //Assign each scene to a location in the map 
        GameControl.assignScenesToLocations(map, scenes);
        
        return map;
        
    }
    
    
    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    @Override
    public String toString() {
        return "Map{" + "rowCount=" + rowCount + ", columnCount=" + columnCount + '}';
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.rowCount);
        hash = 97 * hash + Objects.hashCode(this.columnCount);
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
        final Map other = (Map) obj;
        if (!Objects.equals(this.rowCount, other.rowCount)) {
            return false;
        }
        if (!Objects.equals(this.columnCount, other.columnCount)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
