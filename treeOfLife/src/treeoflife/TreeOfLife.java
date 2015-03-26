/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeoflife;

import byui.cit260.treeOfLife.model.Game;
import byui.cit260.treeOfLife.model.Players;
import byui.cit260.treeOfLife.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Chuck
 */
public class TreeOfLife {

//    private static Object questionOne; //why is this here? 
    private static int lastGameId = 0;
    private static Game currentGame = null;
    private static Players player = null;

    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    private static PrintWriter logFile = null;
    

//    public static void setPlayers(Players player) { //duplicate
//       TreeOfLife.player = player;
//    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TreeOfLife obj = new TreeOfLife ();
        obj.start (args);
   
}

    
    public  void start(String[] args)   {
        try{
            //open character stream files for end user input and output
            TreeOfLife.inFile = new BufferedReader(new InputStreamReader(System.in));
            TreeOfLife.outFile = new PrintWriter(System.out, true);
            
            //open log file
//            String filePath = "/Documents/tmp/logfile.txt"; //might have to use full file path /users/Documents/tmp/logfile.txt (Mac) or something similar
             String filePath = "logfile.txt";
            TreeOfLife.logFile = new PrintWriter(filePath);
           
            
            StartProgramView startProgramView = new StartProgramView();
        try {
            startProgramView.startProgram();
        } catch (Throwable te) {
            System.out.println(te.getMessage());
            te.printStackTrace();
            startProgramView.displayBanner();
        }
        }
        catch (Exception e) {
                System.out.println("Exception: " + e.toString() +
                                    "\nCause: " + e.getCause() +
                                    "\nMessage: "+ e.getMessage());
        }
        finally {
            try {
                if(TreeOfLife.inFile !=null){
                    TreeOfLife.inFile.close();
                }
                if(TreeOfLife.outFile != null){
                    TreeOfLife.outFile.close();
                }
                if(TreeOfLife.logFile != null){
                    TreeOfLife.outFile.close();
                }
            } catch (IOException ex) {
//                Logger.getLogger(TreeOfLife.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error closing files");
                return;
            }
            
        }
       
        
    }

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

    public static int getLastGameId() {
        return lastGameId;
    }

    public static void setLastGameId(int lastGameId) {
        TreeOfLife.lastGameId = lastGameId;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        TreeOfLife.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        TreeOfLife.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        TreeOfLife.logFile = logFile;
    }

}
