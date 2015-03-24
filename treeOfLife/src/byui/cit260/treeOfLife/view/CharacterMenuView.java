/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.treeOfLife.view;

import treeoflife.TreeOfLife;
import byui.cit260.treeOfLife.model.Character;

/**
 *
 * @author Chuck
 */
public class CharacterMenuView extends View {

    public CharacterMenuView() {

        super("\n"
                + "\n========================================"
                + "\n| Character Menu                       |"
                + "\n========================================");
        //get Characters in game
        Character[] characters = Character.values();
        for (Character character : characters) {
            char firstCharacter = character.name().charAt(0);
            System.out.println(firstCharacter + " - Select " + character.name());
            System.out.println("\t " + character.getDescription());
            System.out.println("\tFaith points = " + character.getOrigFaithLevel());
            System.out.println("\tKnowledge points = " + character.getOrigKnowLevel());
            System.out.println("\tObedience points = " + character.getOrigObedLevel());
        }
        System.out.println(
                "\nQ - Quit - "
                + "\n========================================");

    }

    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase(); //convert to all upper case
        char choice = value.charAt(0); //get first character entered
        switch (choice) {

            case 'N':// Select Nephi as a character
                this.selectNephi();
                break;
            case 'S': // Select Sariah as a character
                this.selectSariah();
                break;
            case 'J': // Select Jacob as a character
                this.selectJacob();
                break;
            case 'Q': // Quit Help Menu and return previous menu

                break;
            default:
                System.out.println("n*** Invalid help menu selection *** Try again");
                break;
        }
        return true;

    }

    private void selectNephi() {
//        System.out.println("*** selcectNephi function called ***");

        TreeOfLife.getCurrentGame().setCharacter(Character.Nephi);
        System.out.println("Welcome Nephi, let's begin your journey to the Tree of Life!");
    }

    private void selectSariah() {
//        System.out.println("*** selectSariah function called ***");
        TreeOfLife.getCurrentGame().setCharacter(Character.Sariah);
        System.out.println("Welcome Sariah, let's begin your journey to the Tree of Life!");
    }

    private void selectJacob() {
//      System.out.println("*** selectJacob function called ***");
        TreeOfLife.getCurrentGame().setCharacter(Character.Jacob);
        System.out.println("Welcome Jacob, let's begin your journey to the Tree of Life!");
    }

    private void returnToMainMenu() {
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.display();

    }

}
