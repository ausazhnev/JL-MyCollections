import java.lang.reflect.Array;
import java.util.Arrays;

public class CarArrayList implements CarList {
    private Car[] array = new Car[10];
    private int size = 0;

    @Override
    public Car get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public void add(Car car) {
        increaseArray();
        array[size] = car;
        this.size++;
    }

    @Override
    public void add(Car car, int index) {
        increaseArray();
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);

        // Old
//        for (int i = this.size; i > index; i--) {
//            this.array[i] = this.array[i - 1];
//        }
        this.array[index] = car;
        this.size++;
    }

    @Override
    public boolean remove(Car car) {
        for (int i = 0; i < this.size; i++) {
            if (array[i].equals(car)) {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        // Old
//        for (int i = index; i < size - 1; i++) {
//            array[i] = array[i + 1];
//        }
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

    private void increaseArray() {
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
    }
}
