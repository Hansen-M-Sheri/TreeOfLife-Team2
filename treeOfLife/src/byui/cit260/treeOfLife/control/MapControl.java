/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.control;

import byui.cit260.treeOfLife.model.Game;
import byui.cit260.treeOfLife.model.Map;
import byui.cit260.treeOfLife.model.MapControlException;
import byui.cit260.treeOfLife.model.Scene;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import treeoflife.TreeOfLife;

/**
 *
 * @author Chuck
 */
public class MapControl {

 private static Map createMap() {
        
        //Create and initialize new map
        Map map = new Map(3, 4);
        //Create all of the scenes for the map
        Scene[] scenes = createScenes();
        //Assign each scene to a location in the map 
        GameControl.assignScenesToLocations(map, scenes);
        
        return map;
        
    }
 
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
        
        Game game = TreeOfLife.getCurrentGame(); 

        //Create the scenes array
        Scene[] scenes = new Scene[SceneType.values().length];
       
        //Create scene 1
        Scene startingScene = new Scene();
        startingScene.setDescriptions(
                "\nCottage Opening Scene Description"
                +"Need to add content");
        startingScene.setMapSymbol(" -C- ");
        startingScene.setBlocked(false);
        ImageIcon startingSceneImage = MapControl.getImage(startingScene,
                "/citbyui/citC260/curiousworkmanship/images/startingPoint.jpg");
        startingScene.setIcon(startingSceneImage);
        scenes[SceneType.cottage.ordinal()] = startingScene;
        
        //create scene for Level One
         Scene levelOneScene = new Scene();
        levelOneScene.setDescriptions(
                "\nLevel One Scene Description"
                +"Need to add content");
        levelOneScene.setMapSymbol(" LVL 1");
        levelOneScene.setBlocked(false);
        ImageIcon levelOneSceneImage = MapControl.getImage(levelOneScene,
                "/citbyui/citC260/curiousworkmanship/images/levelOne.jpg");
        levelOneScene.setIcon(levelOneSceneImage);
        scenes[SceneType.levelOne.ordinal()] = levelOneScene;
        
         //create scene for Level Two
         Scene levelTwoScene = new Scene();
        levelTwoScene.setDescriptions(
                "\nLevel Two Scene Description"
                +"Need to add content");
        levelTwoScene.setMapSymbol(" LVL 2");
        levelTwoScene.setBlocked(false);
        ImageIcon levelTwoSceneImage = MapControl.getImage(levelTwoScene,
                "/citbyui/citC260/curiousworkmanship/images/levelTwoScene.jpg");
        levelTwoScene.setIcon(levelTwoSceneImage);
        scenes[SceneType.levelTwo.ordinal()] = levelTwoScene;
        
        //create scene for Level Three
         Scene levelThreeScene = new Scene();
        levelThreeScene.setDescriptions(
                "\nLevel Three Scene Description"
                +"Need to add content");
        levelThreeScene.setMapSymbol(" LVL 1");
        levelThreeScene.setBlocked(false);
        ImageIcon levelThreeSceneImage = MapControl.getImage(levelThreeScene,
                "/citbyui/citC260/curiousworkmanship/images/levelThreeScene.jpg");
        levelThreeScene.setIcon(levelThreeSceneImage);
        scenes[SceneType.levelThree.ordinal()] = levelThreeScene;
        
        
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

        return scenes;
    
    }

    static void moveCharactersToStartingLocation(Map map) {
              System.out.println("*** called moveCharactersToStartingLocation() ****");

    }

    public static ImageIcon getImage(Scene startingScene, String citbyuicitC260curiousworkmanshipimagessta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
