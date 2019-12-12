package controller;

import model.factories.item.*;
import model.factories.unit.*;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.Location;
import model.tactician.Tactician;
import model.units.*;

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
  private List<Tactician> turnOrder;
  private Field gameMap;
  private int roundNumber = 1;
  private long mapSeed;
  private Random random = new Random(mapSeed);
  private Tactician turnOwner;
  private int turnNumber = 0;
  private int maxRounds = -1;
  private int numberOfPlayers;
  private int mapSize;
  private IUnit selectedUnit;
  private IEquipableItem selectedItem;
  private AlpacaFactory alpacaFactory = new AlpacaFactory();
  private ArcherFactory archerFactory = new ArcherFactory();
  private ClericFactory clericFactory = new ClericFactory();
  private FighterFactory fighterFactory = new FighterFactory();
  private HeroFactory heroFactory = new HeroFactory();
  private SorcererFactory sorcererFactory = new SorcererFactory();
  private SwordMasterFactory swordMasterFactory = new SwordMasterFactory();
  private AnimaMagicBookFactory animaMagicBookFactory = new AnimaMagicBookFactory();
  private AxeFactory axeFactory = new AxeFactory();
  private BowFactory bowFactory = new BowFactory();
  private DarkMagicBookFactory darkMagicBookFactory = new DarkMagicBookFactory();
  private LightMagicBookFactory lightMagicBookFactory = new LightMagicBookFactory();
  private SpearFactory spearFactory = new SpearFactory();
  private StaffFactory staffFactory = new StaffFactory();
  private SwordFactory swordFactory = new SwordFactory();

  /**
   * Creates the controller for a new game.
   *
   * @param numberOfPlayers the number of players for this game
   * @param mapSize         the dimensions of the map, for simplicity, all maps are squares
   */
  public GameController(int numberOfPlayers, int mapSize) {
    this.numberOfPlayers = numberOfPlayers;
    this.mapSize = mapSize;
    this.gameMap = new Field();
    tacticians = new ArrayList<>();
    tacticians = new ArrayList<>();
    turnOrder = new ArrayList<>();
    for (int i = 0; i < numberOfPlayers; i++) {
      Tactician tactician = new Tactician("Player " + i);
      tacticians.add(tactician);
    }
    reOrderTacticians();
    turnOwner = turnOrder.get(0);
  }

  /**
   * Creates the map for the game
   */
  public void initGameMap() {
    gameMap = new Field();
    gameMap.setSeed(mapSeed);
    for (int i = 0; i < mapSize; i++) {
      for (int j = 0; j < mapSize; j++) {
        gameMap.addCells(false, new Location(i, j));
      }
    }
    setMapTacticians();
  }

  /**
   * Sets all the map for all the tacticians
   */
  private void setMapTacticians() {
    for (Tactician tactician : turnOrder) {
      tactician.setMap(this.gameMap);
    }
  }

  /**
   * Sets the seed for the map and for the random number generator
   *
   * @param mapSeed The seed to be set
   */
  public void setMapSeed(long mapSeed) {
    this.mapSeed = mapSeed;
    this.gameMap.setSeed(mapSeed);
    random.setSeed(mapSeed);
  }

  /**
   * Creates the list of players for the game
   */
  private void reOrderTacticians() {
    turnOrder = new ArrayList<>();
    turnOrder.addAll(tacticians);
  }

  /**
   * Begins the turn for all the tacticians
   */
  private void beginTurnsTacticians() {
    for (Tactician tactician : this.turnOrder) {
      tactician.beginTurn();
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
  public List<Tactician> getTurnOrder() {
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
    return turnOwner;
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
   * Starts a new round
   */
  private void newRound() {
    turnNumber = 0;
    roundNumber++;
    Tactician a = turnOrder.get(0);
    while (a.equals(turnOrder.get(0))) {
      Collections.shuffle(turnOrder, random);
    }
    beginTurnsTacticians();
  }

  /**
   * Finishes the current player's turn.
   */
  public void endTurn() {
    if (turnNumber + 1 == turnOrder.size()) {
      newRound();
    } else {
      turnNumber++;
    }
    turnOwner = turnOrder.get(turnNumber);
  }

  /**
   * Removes a tactician and all of it's units from the game.
   *
   * @param tactician the player to be removed
   */
  public void removeTactician(String tactician) {
    turnOrder.remove(new Tactician(tactician));
  }

  /**
   * Starts the game.
   *
   * @param maxTurns the maximum number of turns the game can last
   */
  public void initGame(final int maxTurns) {
    this.maxRounds = maxTurns;
    this.roundNumber = 1;
    this.turnNumber = 0;
    if (turnOrder.size() < tacticians.size()) {
      reOrderTacticians();
    }
    initGameMap();
    beginTurnsTacticians();
    turnOwner = turnOrder.get(0);
  }


  /**
   * Starts a game without a limit of turns.
   */
  public void initEndlessGame() {
    this.maxRounds = -1;
    this.roundNumber = 1;
    this.turnNumber = 0;
    if (turnOrder.size() < tacticians.size()) {
      reOrderTacticians();
    }
    initGameMap();
    beginTurnsTacticians();
    turnOwner = turnOrder.get(0);
  }

  /**
   * @return the winner of this game, if the match ends in a draw returns a list of all the winners
   */
  public List<String> getWinners() {
    if (maxRounds == -1) {
      if (turnOrder.size() == 1) {
        return List.of(turnOrder.get(0).getName());
      } else {
        return null;
      }
    }
    if (roundNumber > maxRounds) {
      ArrayList<String> tacticianNames = new ArrayList<>();
      for (Tactician tactician : turnOrder) {
        tacticianNames.add(tactician.getName());
      }
      return tacticianNames;
    } else {
      return null;
    }
  }

  /**
   * Adds an Alpaca to a tactician's units
   *
   * @param tactician The tactician that the alpaca will be added to
   */
  public void addAlpaca(Tactician tactician) {
    Alpaca alpaca = alpacaFactory.create();
    tactician.addUnit(alpaca);
  }

  /**
   * Adds an Archer to a tactician's units
   *
   * @param tactician The tactician that the archer will be added to
   */
  public void addArcher(Tactician tactician) {
    Archer archer = archerFactory.create();
    tactician.addUnit(archer);
  }

  /**
   * Adds a Cleric to a tactician's units
   *
   * @param tactician The tactician that the cleric will be added to
   */
  public void addCleric(Tactician tactician) {
    Cleric cleric = clericFactory.create();
    tactician.addUnit(cleric);
  }

  /**
   * Adds an Alpaca to a tactician's units
   *
   * @param tactician The tactician that the alpaca will be added to
   */
  public void addFighter(Tactician tactician) {
    Fighter fighter = fighterFactory.create();
    tactician.addUnit(fighter);
  }

  /**
   * Adds a Hero to a tactician's units
   *
   * @param tactician The tactician that the hero will be added to
   */
  public void addHero(Tactician tactician) {
    Hero hero = heroFactory.create();
    tactician.addUnit(hero);
  }

  /**
   * Adds a Sorcerer to a tactician's units
   *
   * @param tactician The tactician that the sorcerer will be added to
   */
  public void addSorcerer(Tactician tactician) {
    Sorcerer sorcerer = sorcererFactory.create();
    tactician.addUnit(sorcerer);
  }

  /**
   * Adds a Sword Master to a tactician's units
   *
   * @param tactician The tactician that the Sword master will be added to
   */
  public void addSwordMaster(Tactician tactician) {
    SwordMaster swordMaster = swordMasterFactory.create();
    tactician.addUnit(swordMaster);
  }

  /**
   * @return the current player's selected unit
   */
  public IUnit getSelectedUnit() {
    return this.selectedUnit;
  }

  /**
   * Selects a unit in the game map
   *
   * @param x horizontal position of the unit
   * @param y vertical position of the unit
   */
  public void selectUnitIn(int x, int y) {
    this.selectedUnit = this.gameMap.getCell(x, y).getUnit();
  }

  /**
   * @return the inventory of the currently selected unit.
   */
  public List<IEquipableItem> getItems() {
    return this.selectedUnit.getItems();
  }

  /**
   * Equips an item from the inventory to the currently selected unit.
   *
   * @param index the location of the item in the inventory.
   */
  public void equipItem(int index) {
    if (selectedUnit != null) {
      this.selectedUnit.equip(this.selectedUnit.getItems().get(index));
    }
  }

  /**
   * Uses the equipped item on a target
   *
   * @param x horizontal position of the target
   * @param y vertical position of the target
   */
  public void useItemOn(int x, int y) {
    IUnit target;
    if (selectedUnit != null) {
      if ((target = gameMap.getCell(x, y).getUnit()) != null) {
        selectedUnit.beginCombat(target);
      }
    }
  }

  public IEquipableItem getSelectedItem() {
    return selectedItem;
  }

  /**
   * Selects an item from the selected unit's inventory.
   *
   * @param index the location of the item in the inventory.
   */
  public void selectItem(int index) {
    if (selectedUnit != null) {
      if (selectedUnit.getItems().size() >= index + 1) {
        this.selectedItem = this.getSelectedUnit().getItems().get(index);
      } else {
        this.selectedItem = null;
      }
    }
  }

  /**
   * Gives the selected item to a target unit.
   *
   * @param x horizontal position of the target
   * @param y vertical position of the target
   */
  public void giveItemTo(int x, int y) {
    IUnit target;
    if (selectedUnit != null && (target = gameMap.getCell(x, y).getUnit()) != null && selectedItem != null) {
      selectedUnit.giveItem(selectedItem, target);
    }
  }

  /**
   * Adds an Anima Magic Book to a unit
   *
   * @param i The index of the unit that the item will be added to
   */
  public void addAnimaMagicBook(int i) {
    if (turnOwner != null) {
      turnOwner.getUnits().get(i).addToInventory(animaMagicBookFactory.create());
    }

  }
  /**
   * Adds an Axe to a unit
   *
   * @param i The index of the unit that the item will be added to
   */
  public void addAxe(int i) {
    if (turnOwner != null) {
      turnOwner.getUnits().get(i).addToInventory(axeFactory.create());
    }
  }
  /**
   * Adds a Bow to a unit
   *
   * @param i The index of the unit that the item will be added to
   */
  public void addBow(int i) {
    if (turnOwner != null) {
      turnOwner.getUnits().get(i).addToInventory(bowFactory.create());
    }
  }
  /**
   * Adds a Dark Magic Book to a unit
   *
   * @param i The index of the unit that the item will be added to
   */
  public void addDarkMagicBook(int i) {
    if (turnOwner != null) {
      turnOwner.getUnits().get(i).addToInventory(darkMagicBookFactory.create());
    }
  }
  /**
   * Adds a Light Magic Book to a unit
   *
   * @param i The index of the unit that the item will be added to
   */
  public void addLightMagicBook(int i) {
    if (turnOwner != null) {
      turnOwner.getUnits().get(i).addToInventory(lightMagicBookFactory.create());
    }
  }
  /**
   * Adds a Spear to a unit
   *
   * @param i The index of the unit that the item will be added to
   */
  public void addSpear(int i) {
    if (turnOwner != null) {
      turnOwner.getUnits().get(i).addToInventory(spearFactory.create());
    }
  }
  /**
   * Adds a Staff to a unit
   *
   * @param i The index of the unit that the item will be added to
   */
  public void addStaff(int i) {
    if (turnOwner != null) {
      turnOwner.getUnits().get(i).addToInventory(staffFactory.create());
    }
  }
  /**
   * Adds a Sword to a unit
   *
   * @param i The index of the unit that the item will be added to
   */
  public void addSword(int i) {
    if (turnOwner != null) {
      turnOwner.getUnits().get(i).addToInventory(swordFactory.create());
    }
  }
}
