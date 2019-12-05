package controller;


import model.factories.item.*;
import model.factories.unit.*;
import model.map.Field;
import model.map.Location;
import model.tactician.Tactician;
import model.units.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ignacio Slater Muñoz
 * @since v2.0
 */
class GameControllerTest {
  private GameController controller;
  private long randomSeed;
  private List<String> testTacticians;
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

  @BeforeEach
  void setUp() {
    // Se define la semilla como un número aleatorio para generar variedad en los tests
    randomSeed = new Random().nextLong();
    controller = new GameController(4, 7);
    controller.setMapSeed(randomSeed);
    testTacticians = List.of("Player 0", "Player 1", "Player 2", "Player 3");
    controller.initGameMap();
  }

  @Test
  void getTacticians() {
    List<Tactician> tacticians = controller.getTacticians();
    assertEquals(4, tacticians.size());
    for (int i = 0; i < tacticians.size(); i++) {
      assertEquals("Player " + i, tacticians.get(i).getName());
    }
  }

  @Test
  void getGameMap() {
    Field gameMap = controller.getGameMap();
    assertEquals(7, gameMap.getSize()); // getSize deben definirlo
    assertTrue(controller.getGameMap().isConnected());
    Field testMap = new Field();
    testMap.setSeed(randomSeed);
    for (int i = 0; i < gameMap.getSize(); i++) {
      for (int j = 0; j < gameMap.getSize(); j++) {
        testMap.addCells(false, new Location(i, j));
      }
    }
    for (int i = 0; i < gameMap.getSize(); i++) {
      for (int j = 0; j < gameMap.getSize(); j++) {
        for (Location neighbour : gameMap.getCell(i, j).getNeighbours()) {
          boolean found = false;
          for (Location l : testMap.getCell(i, j).getNeighbours()) {
            if (l.equals(neighbour)) {
              found = true;
            }
          }
          assertTrue(found, "Expected :" + neighbour.toString());
        }
      }
    }
    // Para testear funcionalidades que dependen de valores aleatorios se hacen 2 cosas:
    //  - Comprobar las invariantes de las estructuras que se crean (en este caso que el mapa tenga
    //    las dimensiones definidas y que sea conexo.
    //  - Setear una semilla para el generador de números aleatorios. Hacer esto hace que la
    //    secuencia de números generada sea siempre la misma, así pueden predecir los
    //    resultados que van a obtener.
    //    Hay 2 formas de hacer esto en Java, le pueden pasar el seed al constructor de Random, o
    //    usar el método setSeed de Random.
    //  ESTO ÚLTIMO NO ESTÁ IMPLEMENTADO EN EL MAPA, ASÍ QUE DEBEN AGREGARLO (!)
  }

  @Test
  void getTurnOwner() {
    //  En este caso deben hacer lo mismo que para el mapa
    assertEquals(controller.getTurnOrder().size(), controller.getTacticians().size());
    assertSame(controller.getTurnOwner(), controller.getTurnOrder().get(0));
    Random testRandom = new Random(randomSeed);
    List<Tactician> testTurnOrder = new ArrayList();
    testTurnOrder.addAll(controller.getTurnOrder());
    controller.initEndlessGame();
    for (int i = 0; i < 50; i++) {
      for (int j = 0; j < 4; j++) {
        assertEquals(testTurnOrder.get(j),controller.getTurnOwner());
        controller.endTurn();
      }
      Tactician a = testTurnOrder.get(0);
      while (a.equals(testTurnOrder.get(0))) {
        Collections.shuffle(testTurnOrder, testRandom);
      }
    }
  }

  @Test
  void getRoundNumber() {
    controller.initGame(10);
    for (int i = 1; i < 10; i++) {
      assertEquals(i, controller.getRoundNumber());
      for (int j = 0; j < 4; j++) {
        controller.endTurn();
      }
    }
  }

  @Test
  void getMaxRounds() {
    Random randomTurnSequence = new Random();
    IntStream.range(0, 50).map(i -> randomTurnSequence.nextInt() & Integer.MAX_VALUE).forEach(nextInt -> {
      controller.initGame(nextInt);
      System.out.println(nextInt);
      assertEquals(nextInt, controller.getMaxRounds());
      System.out.println(nextInt);
    });
    controller.initEndlessGame();
    assertEquals(-1, controller.getMaxRounds());
  }

  @Test
  void endTurn() {
    Tactician firstPlayer = controller.getTurnOwner();
    // Nuevamente, para determinar el orden de los jugadores se debe usar una semilla
    Tactician secondPlayer = controller.getTurnOrder().get(1); // <- Deben cambiar esto (!)
    assertNotEquals(secondPlayer.getName(), firstPlayer.getName());

    controller.endTurn();
    assertNotEquals(firstPlayer.getName(), controller.getTurnOwner().getName());
    assertEquals(secondPlayer.getName(), controller.getTurnOwner().getName());
  }

  @Test
  void removeTactician() {
    assertEquals(4, controller.getTurnOrder().size());
    controller.getTurnOrder()
            .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));
    controller.getTurnOrder().forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));

    controller.removeTactician("Player 0");
    assertEquals(3, controller.getTurnOrder().size());
    controller.getTurnOrder().forEach(tactician -> assertNotEquals("Player 0", tactician));
    controller.getTurnOrder().forEach(tactician -> assertNotEquals("Player 0 ", tactician));
    controller.getTurnOrder()
            .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));

    controller.removeTactician("Player 5");
    assertEquals(3, controller.getTurnOrder().size());
    controller.getTurnOrder()
            .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));
  }

  @Test
  void getWinners() {
    controller.initGame(2);
    IntStream.range(0, 8).forEach(i -> controller.endTurn());
    assertEquals(4, controller.getWinners().size());
    controller.getWinners()
            .forEach(player -> Assertions.assertTrue(testTacticians.contains(player)));

    controller.initGame(2);
    IntStream.range(0, 4).forEach(i -> controller.endTurn());
    assertNull(controller.getWinners());
    controller.removeTactician("Player 0");
    controller.removeTactician("Player 2");
    IntStream.range(0, 2).forEach(i -> controller.endTurn());
    List<String> winners = controller.getWinners();
    assertEquals(2, winners.size());
    assertTrue(List.of("Player 1", "Player 3").containsAll(winners));
    controller.initEndlessGame();
    for (int i = 0; i < 3; i++) {
      assertNull(controller.getWinners());
      controller.removeTactician("Player " + i);
    }
    assertTrue(List.of("Player 3").containsAll(controller.getWinners()));
  }

  // Desde aquí en adelante, los tests deben definirlos completamente ustedes
  @Test
  void getSelectedUnit() {
  }

  @Test
  void selectUnitIn() {
    controller.addAlpaca(controller.getTurnOrder().get(0));
    ArrayList<Integer> locations = new ArrayList<>();
    locations.add(0);
    locations.add(1);
    controller.getTurnOrder().get(0).setLocation(locations);
    controller.initEndlessGame();
    controller.selectUnitIn(0, 1);
    Alpaca alpaca = alpacaFactory.create();
    alpaca.setLocation(new Location(0, 1));
    assertEquals(alpaca, controller.getSelectedUnit());
  }

  @Test
  void getItems() {
    controller.addAlpaca(controller.getTurnOrder().get(0));
    ArrayList<Integer> locations = new ArrayList<>();
    locations.add(0);
    locations.add(1);
    controller.getTurnOrder().get(0).setLocation(locations);
    controller.initEndlessGame();
    controller.addAnimaMagicBook(0);
    controller.selectUnitIn(0, 1);
    assertTrue(controller.getItems().contains(animaMagicBookFactory.create()));
  }

  @Test
  void equipItem() {
    controller.addArcher(controller.getTurnOrder().get(0));
    ArrayList<Integer> locations = new ArrayList<>();
    locations.add(0);
    locations.add(1);
    controller.getTurnOrder().get(0).setLocation(locations);
    controller.initEndlessGame();
    controller.addBow(0);
    controller.selectUnitIn(0, 1);
    controller.equipItem(0);
    assertEquals(bowFactory.create(), controller.getSelectedUnit().getEquippedItem());
  }

  @Test
  void useItemOn() {

  }

  @Test
  void selectItem() {
  }

  @Test
  void giveItemTo() {

  }

  @Test
  void addItems() {
    controller.addAlpaca(controller.getTurnOrder().get(0));
    ArrayList<Integer> locations = new ArrayList<>();
    locations.add(0);
    locations.add(1);
    controller.getTurnOrder().get(0).setLocation(locations);
    controller.initEndlessGame();
    controller.addAnimaMagicBook(0);
    assertTrue(controller.getTurnOrder().get(0).getUnits().get(0).getItems().contains(animaMagicBookFactory.create()));
    controller.addAxe(0);
    assertTrue(controller.getTurnOrder().get(0).getUnits().get(0).getItems().contains(axeFactory.create()));
    controller.addBow(0);
    assertTrue(controller.getTurnOrder().get(0).getUnits().get(0).getItems().contains(bowFactory.create()));
    controller.addDarkMagicBook(0);
    assertTrue(controller.getTurnOrder().get(0).getUnits().get(0).getItems().contains(darkMagicBookFactory.create()));
    controller.addLightMagicBook(0);
    assertTrue(controller.getTurnOrder().get(0).getUnits().get(0).getItems().contains(lightMagicBookFactory.create()));
    controller.addSpear(0);
    assertTrue(controller.getTurnOrder().get(0).getUnits().get(0).getItems().contains(spearFactory.create()));
    controller.addStaff(0);
    assertTrue(controller.getTurnOrder().get(0).getUnits().get(0).getItems().contains(staffFactory.create()));
    controller.addSword(0);
    assertTrue(controller.getTurnOrder().get(0).getUnits().get(0).getItems().contains(swordFactory.create()));
  }

  @Test
  void addUnits() {
    controller.addAlpaca(controller.getTacticians().get(0));
    Alpaca alpaca = alpacaFactory.create();
    assertTrue(controller.getTacticians().get(0).getUnits().contains(alpaca));
    controller.addArcher(controller.getTacticians().get(0));
    Archer archer = archerFactory.create();
    assertTrue(controller.getTacticians().get(0).getUnits().contains(archer));
    controller.addCleric(controller.getTacticians().get(0));
    Cleric cleric = clericFactory.create();
    assertTrue(controller.getTacticians().get(0).getUnits().contains(cleric));
    controller.addFighter(controller.getTacticians().get(0));
    Fighter fighter = fighterFactory.create();
    assertTrue(controller.getTacticians().get(0).getUnits().contains(fighter));
    controller.addHero(controller.getTacticians().get(0));
    Hero hero = heroFactory.create();
    assertTrue(controller.getTacticians().get(0).getUnits().contains(hero));
    controller.addSorcerer(controller.getTacticians().get(0));
    Sorcerer sorcerer = sorcererFactory.create();
    assertTrue(controller.getTacticians().get(0).getUnits().contains(sorcerer));
    controller.addSwordMaster(controller.getTacticians().get(0));
    SwordMaster swordMaster = swordMasterFactory.create();
    assertTrue(controller.getTacticians().get(0).getUnits().contains(swordMaster));
  }
}