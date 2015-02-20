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
import byui.cit260.treeOfLife.model.Scene;
import byui.cit260.treeOfLife.model.Character;
import byui.cit260.treeOfLife.view.StartProgramView;


/**
 *
 * @author Chuck
 */
public class TreeOfLife {
    private static Object questionOne;

    private static Game currentGame = null;
    private static Players player = null;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        TreeOfLife.currentGame = currentGame;
    }

    public static Players getPlayer() {
        return player;
    }

    public static void setPlayer(Players player) {
        TreeOfLife.player = player;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       StartProgramView startProgramView = new StartProgramView();
       startProgramView.startProgram();
        
        
    }

    public static void setPlayers(Players player) {
       TreeOfLife.player = player;
    }
}
    
    
