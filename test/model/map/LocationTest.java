package model.map;

import model.units.Alpaca;
import model.units.IUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
class LocationTest {

    /**
     * Test locations
     */
    private Location
            locationA0,
            locationB0,
            locationA1;
    /**
     * Test unit
     */
    private IUnit testAlpaca;

    @BeforeEach
    void setUp() {
        locationA0 = new Location(0, 0);
        locationB0 = new Location(1, 0);
        locationA1 = new Location(0, 1);
    }

    /**
     * Tests that the id of the locations can be retrieved correctly
     */
    @Test
    void testLocationId() {
        assertEquals("(0, 0)", locationA0.toString());
        assertEquals("(1, 0)", locationB0.toString());
        assertEquals("(0, 1)", locationA1.toString());
    }
    @Test
    public void testInvalidLocation(){
        InvalidLocation noLocation = new InvalidLocation();
        assertEquals(new HashSet<>(), noLocation.getNeighbours());
        noLocation.addNeighbour(locationA0);
        assertEquals(new HashSet<>(), noLocation.getNeighbours());
    }
    @Test
    void testEquals() {
        Location sameLocation = new Location(0, 0);
        assertEquals(sameLocation, locationA0);
        assertNotEquals(locationA1, locationA0);
        assertNotEquals(locationB0, locationA0);
        assertNotEquals(locationA1, locationB0);
    }

    /**
     * Tests that the neighbourhood operations operates correctly.
     * <p>
     * All locations should start without neighbours. Also note that the neighbourhood is a symmetric
     * relation.
     * <p>
     * After the first addition, the expected graph is:
     * <pre>
     *   A0 -- B0
     *
     *   A1
     * </pre>
     * After the second addition:
     * <pre>
     *   A0 -- B0
     *   |
     *   A1
     * </pre>
     * And the third addition <b>shouldn't change</b> the graph because it adds an already existing
     * connection.
     */
    @Test
    void testNeighbourhood() {
        assertTrue(locationA0.getNeighbours().isEmpty());
        assertTrue(locationA1.getNeighbours().isEmpty());
        assertTrue(locationB0.getNeighbours().isEmpty());

        locationA0.addNeighbour(locationB0);
        assertEquals(1, locationA0.getNeighbours().size());
        assertEquals(1, locationB0.getNeighbours().size());
        assertTrue(locationA1.getNeighbours().isEmpty());
        assertTrue(locationA0.isNeighbour(locationB0));
        assertTrue(locationB0.isNeighbour(locationA0));
        assertFalse(locationA0.isNeighbour(locationA1));
        assertFalse(locationB0.isNeighbour(locationA1));

        locationA0.addNeighbour(locationA1);
        assertEquals(2, locationA0.getNeighbours().size());
        assertEquals(1, locationB0.getNeighbours().size());
        assertEquals(1, locationA1.getNeighbours().size());
        assertTrue(locationA0.isNeighbour(locationA1));
        assertTrue(locationA1.isNeighbour(locationA0));
        assertTrue(locationA0.isNeighbour(locationB0));
        assertTrue(locationB0.isNeighbour(locationA0));
        assertFalse(locationB0.isNeighbour(locationA1));
        assertFalse(locationA1.isNeighbour(locationB0));

        locationA0.addNeighbour(locationB0);
        locationA0.addNeighbour(locationA1);
        assertEquals(2, locationA0.getNeighbours().size());
    }

    /**
     * Checks if the neighbour relation can be removed correctly.
     */
    @Test
    void testRemoveNeighbour() {
        locationA0.addNeighbour(locationB0);
        locationA0.addNeighbour(locationA1);

        assertEquals(2, locationA0.getNeighbours().size());

        locationA0.removeNeighbour(locationB0);
        assertEquals(1, locationA0.getNeighbours().size());
        assertFalse(locationA0.getNeighbours().contains(locationB0));
    }

    /**
     * checks if a unit is added correctly to the location.
     */
    @Test
    void testSetUnit() {
        testAlpaca = new Alpaca(10, 10, locationA0);
        assertEquals(testAlpaca, locationA0.getUnit());
    }
}