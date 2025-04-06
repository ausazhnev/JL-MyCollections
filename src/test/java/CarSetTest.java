import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarSetTest {
    private CarHashSet carSet;

    @BeforeEach
    void setUp() {
        carSet = new CarHashSet();
        for (int i = 0; i < 100; i++) {
            carSet.add(new Car("Brand" + i, i));
        }

    }

    @Test
    void add() {
        assertEquals(100, carSet.size());
        assertTrue(carSet.add(new Car("Mazda", 123)));
        assertEquals(101, carSet.size());
        assertFalse(carSet.add(new Car("Mazda", 123)));
        assertFalse(carSet.add(new Car("Mazda", 123)));
        assertEquals(101, carSet.size());
    }

    @Test
    void remove() {
        assertEquals(100, carSet.size());
        assertTrue(carSet.remove(new Car("Brand30", 30)));
        assertEquals(99, carSet.size());
        assertFalse(carSet.remove(new Car("Brand30", 30)));
        assertEquals(99, carSet.size());
    }

    @Test
    void size() {
        assertEquals(100, carSet.size());
    }

    @Test
    void clear() {
        carSet.clear();
        assertEquals(0, carSet.size());
    }
}