public class CarLinkedList implements CarList {

    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public Car get(int index) {
        checkIndex(index);
        return getNode(index).value;
//        Old
//        if (index < 0 || index > size) {
//            throw new IndexOutOfBoundsException();
//        }
//        Node node = first;
//        for (int i = 0; i < size; i++) {
//            if (i == index) {
//                return node.value;
//            }
//            node = node.next;
//        }
//        return null;
    }

    @Override
    public boolean add(Car car) {
        if (this.size == 0) {
            Node node = new Node(null, car, null);
            this.first = node;
            this.last = node;
        } else {
            Node secondLast = this.last;
            this.last = new Node(secondLast, car, null);
            secondLast.next = last;
        }
        this.size++;
        return true;
    }

    @Override
    public boolean add(Car car, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            return add(car);
        }

        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;

        Node newNode = new Node(nodePrevious, car, nodeNext);

        nodeNext.previous = newNode;
        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        } else {
            first = newNode;
        }
        this.size++;
        return true;
    }

    @Override
    public boolean remove(Car car) {
        Node node = this.first;
        for (int i = 0; i < this.size; i++) {
            if (node.value.equals(car)) {
                return removeAt(i);
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);

        Node deleteNode = getNode(index);
        Node nodeNext = deleteNode.next;
        Node nodePrevious = deleteNode.previous;

        if (nodeNext != null) {
            nodeNext.previous = nodePrevious;
        } else {
            last = nodePrevious;
        }
        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            this.first = nodeNext;
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
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    private Node getNode(int index) {
        checkIndex(index);
        Node node = first;
        if (index != 0) {
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }

        return node;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private static class Node {
        private Node previous;
        private Car value;
        private Node next;

        public Node(Node previous, Car value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
