import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarListTest {

    private CarList carList;

    @BeforeEach
    void setUp() throws Exception {
        carList = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdd100ElementsThenSizeMustBe100() {
        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementRemoveByIndexThenSizeMustBuDecreased() {
        assertTrue(carList.removeAt(0));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenElementRemoveThenSizeMustBuDecreased() {
        Car car = new Car("Mazda", 42);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        Car car = new Car("Mazda", 42);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());

    }

    public void whenListClearedThenSizeMustBe0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test
    public void whenIndexOutOfBounbsThenThrownException() {
        assertThrows(IndexOutOfBoundsException.class, () -> carList.get(100));
    }

    @Test
    public void methodGetReturmedRightValue() {
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());
    }

    @Test
    public void insertIntoMiddle() {
        Car car = new Car("Mazda", 42);
        carList.add(car, 50);
        Car carFromList = carList.get(50);
        assertEquals("Mazda", carFromList.getBrand());
    }

    @Test
    public void insertIntoFirstPosition() {
        Car car = new Car("Mazda", 42);
        carList.add(car, 0);
        Car carFromList = carList.get(0);
        assertEquals("Mazda", carFromList.getBrand());
    }

    @Test
    public void insertIntoLastPosition() {
        Car car = new Car("Mazda", 42);
        carList.add(car, carList.size());
        Car carFromList = carList.get(carList.size() - 1);
        assertEquals("Mazda", carFromList.getBrand());
    }
}