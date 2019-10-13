package controller;

import model.items.IEquipableItem;
import model.map.Field;
import model.map.Location;
import model.tactician.Tactician;
import model.units.Alpaca;
import model.units.IUnit;
import model.units.factories.AlpacaFactory;
import model.units.factories.ArcherFactory;
import model.units.factories.ClericFactory;
import model.units.factories.FighterFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Controller of the game.
 * The controller manages all the input received from the game's GUI.
 *
 * @author Martin Araya Zavala
 * @version 2.0
 * @since 2.0
 */
public class GameController {
    private List<Tactician> tacticians;
    private List<Integer> turnOrder = new ArrayList<>();
    private Field gameMap;
    private int roundNumber = 1;
    private Random randomseed = new Random();
    private int turnOwner = 0;
    private int maxRounds = -1;
    private int numberOfPlayers;
    private int mapSize;
    private IUnit SelectedUnit;
    private AlpacaFactory alpacaFactory = new AlpacaFactory();
    private ArcherFactory archerFactory = new ArcherFactory();
    private ClericFactory clericFactory = new ClericFactory();
    private FighterFactory fighterFactory = new FighterFactory();

    /**
     * Creates the controller for a new game.
     *
     * @param numberOfPlayers the number of players for this game
     * @param mapSize         the dimensions of the map, for simplicity, all maps are squares
     */
    public GameController(int numberOfPlayers, int mapSize) {
        this.numberOfPlayers = numberOfPlayers;
        this.mapSize = mapSize;
        initTacticians(this.numberOfPlayers);
        initGameMap(this.mapSize);
        Collections.shuffle(turnOrder);
    }

    /**
     * Creates the map for the game
     *
     * @param mapSize The dimensions of the map, for simplicity, all maps are squares
     */
    private void initGameMap(int mapSize) {
        gameMap = new Field();
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                gameMap.addCells(false, new Location(i, j));
            }
        }
    }

    /**
     * Creates the list of players for the game
     *
     * @param numberOfPlayers the number of players for this game
     */
    private void initTacticians(int numberOfPlayers) {
        tacticians = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            Tactician tactician = new Tactician("Player " + i);
            tacticians.add(tactician);
            turnOrder.add(i);
        }
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
    public List<Integer> getTurnOrder() {
        return turnOrder;
    }

    /**
     * @return the map of the current game
     */
    public Field getGameMap() {
        return gameMap;
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
        if (roundNumber <= maxRounds | maxRounds == -1) {
            if (turnOwner < tacticians.size() - 1) {
                turnOwner++;
            } else {
                roundNumber++;
                int a = turnOrder.get(0);
                while (a == turnOrder.get(0)) {
                    Collections.shuffle(turnOrder);
                }
                turnOwner = 0;
            }
        }
        tacticians.get(turnOrder.get(turnOwner)).beginTurn();
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
        this.roundNumber = 1;
        initTacticians(numberOfPlayers);
        initGameMap(mapSize);
        Collections.shuffle(turnOrder);
    }

    /**
     * Starts a game without a limit of turns.
     */
    public void initEndlessGame() {
        maxRounds = -1;
        initTacticians(numberOfPlayers);
        initGameMap(mapSize);
        Collections.shuffle(turnOrder);
    }

    /**
     * @return the winner of this game, if the match ends in a draw returns a list of all the winners
     */
    public List<String> getWinners() {
        if (maxRounds == -1) {
            if (tacticians.size() == 1) {
                ArrayList<String> tacticianNames = new ArrayList<String>();
                for (Tactician tactician : tacticians) {
                    tacticianNames.add(tactician.getName());
                }
                return tacticianNames;
            } else {
                return null;
            }
        }
        if (roundNumber > maxRounds) {
            ArrayList<String> tacticianNames = new ArrayList<String>();
            for (Tactician tactician : tacticians) {
                tacticianNames.add(tactician.getName());
            }
            return tacticianNames;
        } else {
            return null;
        }
    }

    public void addAlpaca() {
        Alpaca alpaca = alpacaFactory.create();
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
