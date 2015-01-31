/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeoflife;

import byui.cit260.treeOfLife.model.Game;
import byui.cit260.treeOfLife.model.GameInventoryItems;
import byui.cit260.treeOfLife.model.Location;
import byui.cit260.treeOfLife.model.Map;
import byui.cit260.treeOfLife.model.Players;
import byui.cit260.treeOfLife.model.Questions;


/**
 *
 * @author Chuck
 */
public class TreeOfLife {
    private static Object questionOne;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Players playerOne = new Players();
        
        playerOne.setName("Fred Flinstone");
        
        String playerInfo = playerOne.toString();
        
        System.out.println(playerInfo);
        
        //Map Class
        Map mapOne = new Map();
        
        mapOne.setRowCount("One");
        mapOne.setColumnCount("Two");
        
        String mapInfo = mapOne.toString();
        
        System.out.println(mapInfo);
        
        //Questions Class
        Questions questionOne = new Questions();
        
        questionOne.setQuestionType("Faith");
        questionOne.setQuestionNumber("1");
        questionOne.setQuestionAnswered("Yes");
        questionOne.setQuestionPoints("10");
        
        String questionInfo = questionOne.toString();
        
        System.out.println(questionInfo);
        
    }
}
    
    
