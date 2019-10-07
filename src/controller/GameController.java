package controller;

import model.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.Location;
import model.units.IUnit;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.lang.Math.max;

/**
 * Controller of the game.
 * The controller manages all the input received from de game's GUI.
 *
 * @author Ignacio Slater Muñoz
 * @version 2.0
 * @since 2.0
 */
public class GameController {
    private List<Tactician> tacticians = new ArrayList<>();
    private List<Integer> turnOrder = new ArrayList<>();
    private Field gamemap = new Field();
    private int roundNumber = 1;
    private Random randomseed = new Random();
    private int turnOwner = 0;
    private int maxRounds = -1;

    /**
     * Creates the controller for a new game.
     *
     * @param numberOfPlayers the number of players for this game
     * @param mapSize         the dimensions of the map, for simplicity, all maps are squares
     */
    public GameController(int numberOfPlayers, int mapSize) {
        for (int i = 0; i < numberOfPlayers; i++) {
            Tactician tactician = new Tactician("Player " + i);
            tacticians.add(tactician);
            turnOrder.add(i);
        }
        //TODO builders para unidades, items, mapa
        int count = 0;
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                gamemap.addCells(false, new Location(i,j));
                count++;
                if (count==mapSize){
                    break;
                }
            }
        }
        Collections.shuffle(turnOrder);
    }

    /**
     * @return the list of all the tacticians participating in the game.
     */
    public List<Tactician> getTacticians() {
        return tacticians;
    }

    /**
     * @return the list with the order of turns in this round
     */
    public List<Integer> getTurnOrder(){
        return turnOrder;
    }
    /**
     * @return the map of the current game
     */
    public Field getGameMap() {
        return gamemap;
    }

    /**
     * @return the tactician that's currently playing
     */
    public Tactician getTurnOwner() {
        return tacticians.get(turnOrder.get(turnOwner));
    }

    /**
     * @return the number of rounds since the start of the game.
     */
    public int getRoundNumber() {
        return roundNumber;
    }

    /**
     * @return the maximum number of rounds a match can last
     */
    public int getMaxRounds() {
        return maxRounds;
    }
    /**
     * Finishes the current player's turn.
     */
    public void endTurn() {
        if(roundNumber<= maxRounds | maxRounds == -1) {
            if (turnOwner < tacticians.size()-1) {
                turnOwner++;
            } else {
                roundNumber++;
                int a = turnOrder.get(0);
                while(a == turnOrder.get(0)){
                    Collections.shuffle(turnOrder);
                }
                turnOwner = 0;
            }
        }
    }

    /**
     * Removes a tactician and all of it's units from the game.
     *
     * @param tactician the player to be removed
     */
    public void removeTactician(String tactician) {
        tacticians.remove(new Tactician(tactician));

    }

    /**
     * Starts the game.
     *
     * @param maxTurns the maximum number of turns the game can last
     */
    public void initGame(final int maxTurns) {
        this.maxRounds = maxTurns;
        this.roundNumber = 0;
        tacticians.get(turnOrder.get(turnOwner)).beginTurn();
    }

    /**
     * Starts a game without a limit of turns.
     */
    public void initEndlessGame() {
        maxRounds = -1;
    }

    /**
     * @return the winner of this game, if the match ends in a draw returns a list of all the winners
     */
    public List<String> getWinners() {
        if (roundNumber == maxRounds){
            ArrayList<String> tacticianNames = new ArrayList<String>();
            for (Tactician tactician : tacticians){
                tacticianNames.add(tactician.getName());
            }
            return tacticianNames;
        }
        else {
            return null;
        }
    }

    /**
     * @return the current player's selected unit
     */
    public IUnit getSelectedUnit() {
        return null;
    }

    /**
     * Selects a unit in the game map
     *
     * @param x horizontal position of the unit
     * @param y vertical position of the unit
     */
    public void selectUnitIn(int x, int y) {

    }

    /**
     * @return the inventory of the currently selected unit.
     */
    public List<IEquipableItem> getItems() {
        return null;
    }

    /**
     * Equips an item from the inventory to the currently selected unit.
     *
     * @param index the location of the item in the inventory.
     */
    public void equipItem(int index) {

    }

    /**
     * Uses the equipped item on a target
     *
     * @param x horizontal position of the target
     * @param y vertical position of the target
     */
    public void useItemOn(int x, int y) {

    }

    /**
     * Selects an item from the selected unit's inventory.
     *
     * @param index the location of the item in the inventory.
     */
    public void selectItem(int index) {

    }

    /**
     * Gives the selected item to a target unit.
     *
     * @param x horizontal position of the target
     * @param y vertical position of the target
     */
    public void giveItemTo(int x, int y) {

    }
}
