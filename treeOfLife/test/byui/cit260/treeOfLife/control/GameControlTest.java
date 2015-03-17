/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.control;

import byui.cit260.treeOfLife.model.GameInventoryItems;
import byui.cit260.treeOfLife.model.Map;
import byui.cit260.treeOfLife.model.Players;
import byui.cit260.treeOfLife.model.Scene;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sherihansen
 */
public class GameControlTest {
    
    public GameControlTest() {
    }

    /**
     * Test of createNewGame method, of class GameControl.
     */
    @Test
    public void testCreateNewGame() {
        System.out.println("createNewGame");
        Players player = null;
        GameControl.createNewGame(player);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of assignScenesToLocations method, of class GameControl.
     */
    @Test
    public void testAssignScenesToLocations() {
        System.out.println("assignScenesToLocations");
        Map map = null;
        Scene[] scenes = null;
        GameControl.assignScenesToLocations(map, scenes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createInventoryList method, of class GameControl.
     */
    @Test
    public void testCreateInventoryList() {
        System.out.println("createInventoryList");
        ArrayList<GameInventoryItems> expResult = null;
        ArrayList<GameInventoryItems> result = GameControl.createInventoryList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSortedPurchasedItems method, of class GameControl.
     */
    @Test
    public void testGetSortedPurchasedItems() {
        System.out.println("getSortedPurchasedItems");
        ArrayList<GameInventoryItems> expResult = null;
        ArrayList<GameInventoryItems> result = GameControl.getSortedPurchasedItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayCharacterInventory method, of class GameControl.
     */
    @Test
    public void testDisplayCharacterInventory() {
        System.out.println("displayCharacterInventory");
        GameControl.displayCharacterInventory();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCharacterInventoryByHighestStats method, of class GameControl.
     */
    @Test
    public void testGetCharacterInventoryByHighestStats() {
        System.out.println("getCharacterInventoryByHighestStats");
        ArrayList<GameInventoryItems> expResult = null;
        ArrayList<GameInventoryItems> result = GameControl.getCharacterInventoryByHighestStats();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
