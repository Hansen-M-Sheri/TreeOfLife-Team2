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

        super("\n=================================================================");
                this.console.println("\n================================================================="
                + "\n\t\t\t Character Menu                       "
                + "\n=================================================================");
        //get Characters in game
        Character[] characters = Character.values();
        for (Character character : characters) {
            char firstCharacter = character.name().charAt(0);
            this.console.println(firstCharacter + " - Select " + character.name());
            this.console.println("\t " + character.getDescription());
            this.console.println("\tFaith points = " + character.getOrigFaithLevel());
            this.console.println("\tKnowledge points = " + character.getOrigKnowLevel());
            this.console.println("\tObedience points = " + character.getOrigObedLevel());
        }
        this.console.println(
               
              );

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
           
            default:
                ErrorView.display("CharacterMenuView","*** Invalid help menu selection *** Try again");
                break;
        }
        return true;

    }

    private void selectNephi() {

        
        TreeOfLife.getCurrentGame().setCharacter(Character.Nephi);
        //set faith stat
        int faith = TreeOfLife.getCurrentGame().getCharacter().getOrigFaithLevel();
        TreeOfLife.getCurrentGame().getProgressMeter().setFaithStat(faith);
        //set Knowledge stat
        int knowledge = TreeOfLife.getCurrentGame().getCharacter().getOrigKnowLevel();
        TreeOfLife.getCurrentGame().getProgressMeter().setKnowledgeStat(knowledge);
        //set obedience stat
        int obedience = TreeOfLife.getCurrentGame().getCharacter().getOrigObedLevel();
        TreeOfLife.getCurrentGame().getProgressMeter().setObedienceStat(obedience);
        this.console.println("Welcome Nephi, let's begin your journey to the Tree of Life!");
//        this.console.println("Select Q to begin!");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void selectSariah() {

        TreeOfLife.getCurrentGame().setCharacter(Character.Sariah);
        //set faith stat
        int faith = TreeOfLife.getCurrentGame().getCharacter().getOrigFaithLevel();
        TreeOfLife.getCurrentGame().getProgressMeter().setFaithStat(faith);
        //set Knowledge stat
        int knowledge = TreeOfLife.getCurrentGame().getCharacter().getOrigKnowLevel();
        TreeOfLife.getCurrentGame().getProgressMeter().setKnowledgeStat(knowledge);
        //set obedience stat
        int obedience = TreeOfLife.getCurrentGame().getCharacter().getOrigObedLevel();
        TreeOfLife.getCurrentGame().getProgressMeter().setObedienceStat(obedience);
        this.console.println("Welcome Sariah, let's begin your journey to the Tree of Life!");
//        this.console.println("Select Q to begin!");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
       
    }

    private void selectJacob() {

        TreeOfLife.getCurrentGame().setCharacter(Character.Jacob);
        //set faith stat
        int faith = TreeOfLife.getCurrentGame().getCharacter().getOrigFaithLevel();
        TreeOfLife.getCurrentGame().getProgressMeter().setFaithStat(faith);
        //set Knowledge stat
        int knowledge = TreeOfLife.getCurrentGame().getCharacter().getOrigKnowLevel();
        TreeOfLife.getCurrentGame().getProgressMeter().setKnowledgeStat(knowledge);
        //set obedience stat
        int obedience = TreeOfLife.getCurrentGame().getCharacter().getOrigObedLevel();
        TreeOfLife.getCurrentGame().getProgressMeter().setObedienceStat(obedience);
        this.console.println("Welcome Jacob, let's begin your journey to the Tree of Life!");
//       this.console.println("Select Q to begin!");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void returnToMainMenu() {
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.display();

    }

}
