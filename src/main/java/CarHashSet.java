public class CarHashSet implements CarSet {

    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private Entry[] array = new Entry[INITIAL_CAPACITY];
    private int size = 0;


    @Override
    public boolean add(Car car) {
        if (this.size >= (array.length * LOAD_FACTOR)) {
            increaseArray();
        }
        boolean added = add(car, this.array);
        if (added) {
            size++;
        }
        return added;
    }

    @Override
    public boolean remove(Car car) {
        int position = getElementPosition(car, this.array.length);
        if (this.array[position] == null) {
            return false;
        }

        Entry secondLast = array[position];
        Entry last = secondLast.next;

        if (secondLast.value.equals(car)) {
            array[position] = last;
            size--;
            return true;
        }
        while (last != null) {
            if (last.value.equals(car)) {
                secondLast.next = last.next;
                size--;
                return true;
            } else {
                secondLast = last;
                last = secondLast.next;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        array = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    private int getElementPosition(Car car, int arrayLength) {
        return Math.abs(car.hashCode() % arrayLength);
    }

    private void increaseArray(){
        Entry[] newArray = new Entry[this.array.length * 2];
        for (Entry entry : array) {
            Entry existesElement = entry;
            while (existesElement != null) {
                add(existesElement.value, newArray);
                existesElement = existesElement.next;
            }
        }
        this.array = newArray;
    }

    private boolean add (Car car, Entry[] workArray) {
        int position = getElementPosition(car, workArray.length);
        if (workArray[position] == null) {
            workArray[position] = new Entry(car, null);
            return true;
        } else {
            Entry existedElement = workArray[position];
            while (true) {
                if (existedElement.value.equals(car)) {
                    return false;
                } else if (existedElement.next == null) {
                    existedElement.next = new Entry(car, null);
                    return true;
                } else {
                    existedElement = existedElement.next;
                }
            }
        }
    }

    private static class Entry {
        Car value;
        Entry next;

        public Entry(Car value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }
}


