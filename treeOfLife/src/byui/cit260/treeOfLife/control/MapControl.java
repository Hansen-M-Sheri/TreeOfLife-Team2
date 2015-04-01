/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.control;

import byui.cit260.treeOfLife.model.Game;
import byui.cit260.treeOfLife.model.Map;
import byui.cit260.treeOfLife.model.QuestionArray;
import byui.cit260.treeOfLife.model.Scene;
import citbyui.cit260.treeOfLife.exceptions.MapControlException;
import java.awt.Point;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import treeoflife.TreeOfLife;
import byui.cit260.treeOfLife.model.Character;
import byui.cit260.treeOfLife.model.Location;
import java.io.Serializable;

/**
 *
 * @author Chuck
 */
public class MapControl {

    //this was private, but changed to fix error in GameControl.createNewGame()

    public static Map createMap() {

        //Create and initialize new map
        Map map = new Map(3, 4);
        //Create all of the scenes for the map
        Scene[] scenes = createScenes();
        //Assign each scene to a location in the map 
        GameControl.assignScenesToLocations(map, scenes);
        
        return map;

    }

    public enum SceneType implements Serializable{

        cottage("Starting Point in the Game"),
        levelOne("First Level in the Game"),
        levelTwo("Second Level in the Game"),
        levelThree("Third Level in the Game"),
        levelFour("Fourth Level in the Game"),
        levelFive("Fifth Level in the Game"),
        mantle("The Mantle is where you can repent and increase your faith points"),
        temple("The Temple is where you can gain Faith, Obedience and Knowledge Points"),
        armorShop("The Armor Shop is where you can purchase Armor Pieces to increase Faith Points"),
        treeOfLife("The Tree of Life is the highest level achieved at the end of the game"),
        treeOfKnowledge("The Tree of Knowledge is the second highest level achieved at the end of the game"),
        spaciousBuilding("The Spacious Building is the lowest level of achievement at the end of the game"),
        ;
//    finish; //removing since this will not be on map
        private String locationDescription;

        SceneType(String locationDescription) {
        this.locationDescription = locationDescription;
        }
        
        public String getLocationDescription() {
        return locationDescription; 
        }
    }

    private static Scene[] createScenes() { //uncomment setIcon, getImage when implementing images
        BufferedImage image = null;

        Game game = TreeOfLife.getCurrentGame();

        //Create the scenes array
        Scene[] scenes = new Scene[SceneType.values().length];

        //Create scene 1
        Scene startingScene = new Scene();
        startingScene.setDescriptions(
                "\n\t\t\tCottage "
                + "\n\tStarting Location");
        startingScene.setMapSymbol(" -C- ");
        startingScene.setBlocked(false);
//        ImageIcon startingSceneImage = MapControl.getImage(startingScene,
//                "/citbyui/citC260/curiousworkmanship/images/startingPoint.jpg");
//        startingScene.setIcon(startingSceneImage);
        scenes[SceneType.cottage.ordinal()] = startingScene;
        
        

        //create scene for Level One
        Scene levelOneScene = new Scene();
        levelOneScene.setDescriptions(
                "\n\t\t\tWelcome to Level One!"
                +"\n\t You must answer atleast 1 set of three questions"
                +"\n\t  before continuing to the next level");
        levelOneScene.setMapSymbol("LVL 1");
        levelOneScene.setBlocked(false);
//        ImageIcon levelOneSceneImage = MapControl.getImage(levelOneScene,
//                "/citbyui/citC260/curiousworkmanship/images/levelOne.jpg");
//        levelOneScene.setIcon(levelOneSceneImage);
        scenes[SceneType.levelOne.ordinal()] = levelOneScene;

        //create scene for Level Two
        Scene levelTwoScene = new Scene();
        levelTwoScene.setDescriptions(
                "\n\t\t\tLevel Two "
                + "\n\tYou are progessing well, "
                + "\n\tbut must continue to answer "
                + "\n\tquestions to progress");
        levelTwoScene.setMapSymbol("LVL 2");
        levelTwoScene.setBlocked(true);
//        ImageIcon levelTwoSceneImage = MapControl.getImage(levelTwoScene,
//                "/citbyui/citC260/curiousworkmanship/images/levelTwoScene.jpg");
//        levelTwoScene.setIcon(levelTwoSceneImage);
        scenes[SceneType.levelTwo.ordinal()] = levelTwoScene;

        //create scene for Level Three
        Scene levelThreeScene = new Scene();
        levelThreeScene.setDescriptions(
                "\n\t\t\tLevel Three "
                +"\n\t You must answer atleast 1 set of three questions"
                +"\n\t  before continuing to the next level"
                + "\n\tYou are making EXCELLENT progress!!");
        levelThreeScene.setMapSymbol("LVL 3");
        levelThreeScene.setBlocked(true);
//        ImageIcon levelThreeSceneImage = MapControl.getImage(levelThreeScene,
//                "/citbyui/citC260/curiousworkmanship/images/levelThreeScene.jpg");
//        levelThreeScene.setIcon(levelThreeSceneImage);
        scenes[SceneType.levelThree.ordinal()] = levelThreeScene;

        //create scene for Level Four
        Scene levelFourScene = new Scene();
        levelFourScene.setDescriptions(
                "\n\t\t\tLevel Four "
                +"\n\t You must answer atleast 1 set of three questions"
                +"\n\t  before continuing to the next level"
                + "Need to add content");
        levelFourScene.setMapSymbol("LVL 4");
        levelFourScene.setBlocked(true);
//        ImageIcon levelFourSceneImage = MapControl.getImage(levelFourScene,
//                "/citbyui/citC260/curiousworkmanship/images/levelFourScene.jpg");
//        levelFourScene.setIcon(levelFourSceneImage);
        scenes[SceneType.levelFour.ordinal()] = levelFourScene;

        //create scene for Level Five
        Scene levelFiveScene = new Scene();
        levelFiveScene.setDescriptions(
                "\n\t\t\tLevel Five "
                + "\n\tYou are at the final level!!"
                + "\n\tGather points while you can!");
        levelFiveScene.setMapSymbol("LVL 5");
        levelFiveScene.setBlocked(true);
//        ImageIcon levelFiveSceneImage = MapControl.getImage(levelFiveScene,
//                "/citbyui/citC260/curiousworkmanship/images/levelFiveScene.jpg");
//        levelFiveScene.setIcon(levelFiveSceneImage);
        scenes[SceneType.levelFive.ordinal()] = levelFiveScene;

        //create scene for mantle
        Scene mantleScene = new Scene();
        mantleScene.setDescriptions(
                "\n\t\t\tMantle"
                + "\n\tHere at you can rejuvenate your spirits and strength"
                + "\n\t Just answer a question and see how much better you feel.");
        mantleScene.setMapSymbol(" -M- ");
        mantleScene.setBlocked(false);
//        ImageIcon mantleSceneImage = MapControl.getImage(mantleScene,
//                "/citbyui/citC260/curiousworkmanship/images/mantleScene.jpg");
//        mantleScene.setIcon(mantleSceneImage);
        scenes[SceneType.mantle.ordinal()] = mantleScene;

        //create scene for temple
        Scene templeScene = new Scene();
        templeScene.setDescriptions(
                "\n\t\t\t Temple "
                + "\n\t Through your service here, you will find"
                + "\n\t an increase of strength and protection"
                + "\n\t Answer a question to obtain the blessings");
        templeScene.setMapSymbol(" -T- ");
        templeScene.setBlocked(false);
//        ImageIcon templeSceneImage = MapControl.getImage(templeScene,
//                "/citbyui/citC260/curiousworkmanship/images/templeScene.jpg");
//        templeScene.setIcon(templeSceneImage);
        scenes[SceneType.temple.ordinal()] = templeScene;

        //create scene for armorShop
        Scene armorShopScene = new Scene();
        armorShopScene.setDescriptions(
                "\n\t\t\t Armor Shop "
                + "\n\tPut on the Armor of God "
                        + "\n\t and see how you are strengthened."
                        + "\n\t Make sure you have enough faith for the purchase!");
        armorShopScene.setMapSymbol(" -A- ");
        armorShopScene.setBlocked(false);
//        ImageIcon armorShopSceneImage = MapControl.getImage(armorShopScene,
//                "/citbyui/citC260/curiousworkmanship/images/armorShopScene.jpg");
//        armorShopScene.setIcon(armorShopSceneImage);
        scenes[SceneType.armorShop.ordinal()] = armorShopScene;

        //create scene for treeOfLife
        Scene treeOfLifeScene = new Scene();
        treeOfLifeScene.setDescriptions(
                "\n Tree of Life Scene Description"
                + "Need to add content");
        treeOfLifeScene.setMapSymbol("  *  ");
        treeOfLifeScene.setBlocked(true);
//        ImageIcon treeOfLifeSceneImage = MapControl.getImage(treeOfLifeScene,
//                "/citbyui/citC260/curiousworkmanship/images/treeOfLifeScene.jpg");
//        treeOfLifeScene.setIcon(treeOfLifeSceneImage);
        scenes[SceneType.treeOfLife.ordinal()] = treeOfLifeScene;

        //create scene for treeOfKnowledge
        Scene treeOfKnowledgeScene = new Scene();
        treeOfKnowledgeScene.setDescriptions(
                "\n Tree of Knowledge Scene Description"
                + "Need to add content");
        treeOfKnowledgeScene.setMapSymbol("  !  ");
        treeOfKnowledgeScene.setBlocked(true);
//        ImageIcon treeOfKnowledgeSceneImage = MapControl.getImage(treeOfKnowledgeScene,
//                "/citbyui/citC260/curiousworkmanship/images/treeOfKnowledgeScene.jpg");
//        treeOfKnowledgeScene.setIcon(treeOfKnowledgeSceneImage);
        scenes[SceneType.treeOfKnowledge.ordinal()] = treeOfKnowledgeScene;

        //create scene for spaciousBuilding
        Scene spaciousBuildingScene = new Scene();
        spaciousBuildingScene.setDescriptions(
                "\n Spacious Building Scene Description"
                + "Need to add content");
        spaciousBuildingScene.setMapSymbol(" #$& ");
        spaciousBuildingScene.setBlocked(true);
//        ImageIcon spaciousBuildingSceneImage = MapControl.getImage(spaciousBuildingScene,
//                "/citbyui/citC260/curiousworkmanship/images/spaciousBuildingScene.jpg");
//        spaciousBuildingScene.setIcon(spaciousBuildingSceneImage);
        scenes[SceneType.spaciousBuilding.ordinal()] = spaciousBuildingScene;

//        Scene finishScene = new Scene();
//        finishScene.setDescriptions(
//                "\nCongratulations! Well done you have made it to the Tree of Life."
//                +"add more content");
//        finishScene.setMapSymbol(" FN");
//        finishScene.setBlocked(false);
//        ImageIcon finishSceneImage = MapControl.getImage(finishScene,
//                "/citbyui/citC260/curiousworkmanship/images/finish.jpg");
//                finishScene.setIcon(finishSceneImage);
//        scenes[SceneType.finish.ordinal()] = finishScene;
//
        return scenes;

    }

    public static void moveCharactersToStartingLocation(Map map) throws MapControlException {

       // System.out.println("*** called moveCharactersToStartingLocation() ****");

        Character character = TreeOfLife.getCurrentGame().getCharacter();
     

        Point coordinates = character.getCoordinates();
        MapControl.moveCharactersToLocation(character, coordinates);
//        System.out.println(coordinates);

    }

   public static void moveCharactersToLocation(Character character, Point coordinates) throws MapControlException {
//        System.out.println("*** called moveCharactersToStartingLocation() ****");
        Map map = TreeOfLife.getCurrentGame().getMap();
//        int newRow = coordinates.x - 1;
//        int newColumn = coordinates.y - 1;
         int newRow = coordinates.x ; //@todo removing -1 gets rid of error (location is outside the bounds of the map).  Why is it necessary? 
        int newColumn = coordinates.y ;

        if (newRow < 0 || newRow >= map.getRowCount()
                || newColumn < 0 || newColumn >= map.getColumnCount()) {
            throw new MapControlException("Can not move actor to location "
                    + coordinates.x + ", " + coordinates.y
                    + " because that location is outside "
                    + " the bounds of the map.");
        }
        character.getCoordinates().x = coordinates.x;
        character.getCoordinates().y = coordinates.y;
        //set location as visited
        Location location = map.getLocations()[coordinates.x][coordinates.y];
//       throw new MapControlException("starting location is: "+location); //this is to test location 
        location.setVisited(true);
         //if moves to new level then setCurrentLevel
        
        
    }

    public static ImageIcon getImage(Scene startingScene, String citbyuicitC260curiousworkmanshipimagessta) {
        System.out.println("*** called getImage() function ****");
        return null;
    }

}
