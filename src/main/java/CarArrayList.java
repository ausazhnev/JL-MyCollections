import java.lang.reflect.Array;
import java.util.Arrays;

public class CarArrayList implements CarList{
    private Car[] array = new Car[10];
    private int size = 0;

    @Override
    public Car get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public void add(Car car) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
            // Old
//            Car[] newArray = new Car[array.length * 2];
//            for (int i = 0; i < array.length; i++) {
//                newArray[i] = array[i];
//                array = newArray;
//                newArray = null;
//            }
        }

        array[size] = car;
        this.size++;
    }

    @Override
    public boolean remove(Car car) {
        for (int i = 0; i < this.size; i ++) {
            if (array[i].equals(car)) {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        this.size--;
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.array = new Car[10];
        this.size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
