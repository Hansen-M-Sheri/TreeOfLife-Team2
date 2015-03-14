/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.control;

import byui.cit260.treeOfLife.model.Game;
import byui.cit260.treeOfLife.model.GameInventoryItems;
import byui.cit260.treeOfLife.model.Location;
import byui.cit260.treeOfLife.model.Map;
import byui.cit260.treeOfLife.control.MapControl.SceneType;
import byui.cit260.treeOfLife.model.Players;
import byui.cit260.treeOfLife.model.ProgressMeter;
import byui.cit260.treeOfLife.model.Questions;
import byui.cit260.treeOfLife.model.Scene;
import java.util.ArrayList;
import treeoflife.TreeOfLife;

/**
 *
 * @author Chuck
 */
public class GameControl {

    public static void createNewGame(Players player) {
        
        Game game = new Game();//create a new game
        TreeOfLife.setCurrentGame(game);//save the game in TreeOfLife
        
        game.setPlayer(player);//save player in game
        
        ArrayList<GameInventoryItems> forSale = GameControl.createInventoryList();//create items for sale in game
//        game.setInventory();//don't think I need to save since inventory is enum
        

        Map map = MapControl.createMap();//create the Map
        game.setMap(map);//save map in the game

        //move characters to starting position in the map
        MapControl.moveCharactersToStartingLocation(map);
        
        //System.out.println("*** createNewGame function called ***");
    
    
    }
    //@todo - instructions said to have this private, but it caused issues in Map.createMap()
    public static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();
        
        
        locations[0][0].setScene(scenes[SceneType.armorShop.ordinal()]);
        //start point
        locations[0][1].setScene(scenes[SceneType.cottage.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.levelOne.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.spaciousBuilding.ordinal()]);
        locations[1][0].setScene(scenes[SceneType.temple.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.levelTwo.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.levelThree.ordinal()]);
        locations[1][3].setScene(scenes[SceneType.treeOfKnowledge.ordinal()]);
        locations[2][0].setScene(scenes[SceneType.mantle.ordinal()]);
        locations[2][1].setScene(scenes[SceneType.levelFour.ordinal()]);
        locations[2][2].setScene(scenes[SceneType.levelFive.ordinal()]);
        locations[2][3].setScene(scenes[SceneType.treeOfLife.ordinal()]);
    }


    public static ArrayList<GameInventoryItems> createInventoryList() {
        //get list of forSale items from current game
        Game game = TreeOfLife.getCurrentGame();
        //create an arrayList forSaleList
        ArrayList<GameInventoryItems> forSaleList = game.getForSale();
        //add each armor piece to the forSaleList
        forSaleList.add(GameInventoryItems.Helmet);
        forSaleList.add(GameInventoryItems.Shield);
        forSaleList.add(GameInventoryItems.Belt);
        forSaleList.add(GameInventoryItems.FootCovering);
        forSaleList.add(GameInventoryItems.TruthSword);
        forSaleList.add(GameInventoryItems.BreastPlate);
        //Below is how we will remove item from list - 
//        forSaleList.remove(GameInventoryItems.helmet);
        
        return forSaleList ;
        
    }
public enum QuestionType {
    temple,
    mantle,
    levelQuestions;
}
    public static  Questions[][] createQuestionArray() {
         Game game = TreeOfLife.getCurrentGame(); 
        // Create array of questions
        Questions[][] questions = new Questions[QuestionType.values().length][20];
      ///////////////////////////Temple Questions/////////////////////////////// 
    //create array of Question objects (type)
        Questions templeQuestion1 = new Questions();
        templeQuestion1.setQuestionNumber(1);
        templeQuestion1.setQuestionType(QuestionType.temple.ordinal());
        templeQuestion1.setQuestion("How many days out of the last seven days did you read the book of Mormon?");
        questions[QuestionType.temple.ordinal()][1] = templeQuestion1;
        
        Questions templeQuestion2 = new Questions();
        templeQuestion2.setQuestionNumber(2);
        templeQuestion2.setQuestionType(QuestionType.temple.ordinal());
        templeQuestion2.setQuestion("How many days out of the last seven days did you have your personal prayers?");
        questions[QuestionType.temple.ordinal()][2] = templeQuestion2;
        
        Questions templeQuestion3 = new Questions();
        templeQuestion3.setQuestionNumber(3);
        templeQuestion3.setQuestionType(QuestionType.temple.ordinal());
        templeQuestion3.setQuestion("How many days out of the last seven days did you exercise?");
        questions[QuestionType.temple.ordinal()][3] = templeQuestion3;
        
        Questions templeQuestion4 = new Questions();
        templeQuestion4.setQuestionNumber(4);
        templeQuestion4.setQuestionType(QuestionType.temple.ordinal());
        templeQuestion4.setQuestion("How many days out of the last seven days did you wake up early?");
        questions[QuestionType.temple.ordinal()][4] = templeQuestion4;
        
        Questions templeQuestion5 = new Questions();
        templeQuestion5.setQuestionNumber(5);
        templeQuestion5.setQuestionType(QuestionType.temple.ordinal());
        templeQuestion5.setQuestion("How many days out of the last seven days did you build your marriage (or relationship with someone important to you)?");
        questions[QuestionType.temple.ordinal()][5] = templeQuestion5;
    ////////////////////////Mantle Questions /////////////////////////////////////////    
        //set mantleQuestions in array
        Questions mantleQuestion1 = new Questions();
        mantleQuestion1.setQuestionNumber(1);
        mantleQuestion1.setQuestionType(QuestionType.mantle.ordinal());
        mantleQuestion1.setQuestion("How many days out of the last seven days did you serve a family member?");
        questions[QuestionType.mantle.ordinal()][1] = mantleQuestion1;
        
          Questions mantleQuestion2 = new Questions();
        mantleQuestion2.setQuestionNumber(2);
        mantleQuestion2.setQuestionType(QuestionType.mantle.ordinal());
        mantleQuestion2.setQuestion("How many days out of the last seven days did you attend the temple?");
        questions[QuestionType.mantle.ordinal()][2] = mantleQuestion2;
                
          Questions mantleQuestion3 = new Questions();
        mantleQuestion3.setQuestionNumber(3);
        mantleQuestion3.setQuestionType(QuestionType.mantle.ordinal());
        mantleQuestion3.setQuestion("How many days out of the last seven days did you help a stranger?");
        questions[QuestionType.mantle.ordinal()][3] = mantleQuestion3;
    ///////////////////////Level Questions //////////////////////////////
        Questions levelQuestion1 = new Questions();
        levelQuestion1.setQuestionNumber(1);
        levelQuestion1.setQuestionType(QuestionType.levelQuestions.ordinal());
        levelQuestion1.setQuestion("How many books are in the Book of Mormon?");
        questions[QuestionType.levelQuestions.ordinal()][1] = levelQuestion1;
        
         Questions levelQuestion2 = new Questions();
        levelQuestion2.setQuestionNumber(2);
        levelQuestion2.setQuestionType(QuestionType.levelQuestions.ordinal());
        levelQuestion2.setQuestion("How many men comprise the First Presidency and Quorum of Twelve?");
        questions[QuestionType.levelQuestions.ordinal()][2] = levelQuestion2;
        
         Questions levelQuestion3 = new Questions();
        levelQuestion3.setQuestionNumber(3);
        levelQuestion3.setQuestionType(QuestionType.levelQuestions.ordinal());
        levelQuestion3.setQuestion("How many Presidents have led the church since the restoration?");
        questions[QuestionType.levelQuestions.ordinal()][3] = levelQuestion3;
        
         Questions levelQuestion4 = new Questions();
        levelQuestion4.setQuestionNumber(4);
        levelQuestion4.setQuestionType(QuestionType.levelQuestions.ordinal());
        levelQuestion4.setQuestion("In what chapter of the Doctrine and Covenants is the \"Word of Wisdom\" found?");
        questions[QuestionType.levelQuestions.ordinal()][4] = levelQuestion4;
    //return questions array
        return questions;
    }
}



