public class MyLinkedList<E> implements MyList<E> {
    private class MyNode {
        E element;
        MyNode next;
        MyNode previous;

        public MyNode(E element) {
            this.element = element;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(E element) {
        MyNode newNode = new MyNode(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, E element) {}

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
        MyNode current = head;
        while (current != null) {
            if (current.element.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}

public class MyStack<E> {
    private MyList<E> list;

    public MyStack(MyList<E> list) {
        this.list = list;
    }

    public void push(E element) {
        list.add(element);
    }

    public E pop() {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        return list.remove(list.size() - 1);
    }

    public E peek() {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}

public class MyQueue<E> {
    private MyList<E> list;

    public MyQueue(MyList<E> list) {
        this.list = list;
    }

    public void enqueue(E element) {
        list.add(element);
    }

    public E dequeue() {
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.remove(0);
    }

    public E peek() {
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}

public class MyMinHeap<E extends Comparable<E>> {
    private MyList<E> list;

    public MyMinHeap(MyList<E> list) {
        this.list = list;
    }

    public void insert(E element) {
        list.add(element);
        heapifyUp();
    }

    public E extractMin() {
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        E min = list.get(0);
        E last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            heapifyDown();
        }
        return min;
    }

    public E getMin() {
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    private void heapifyUp() {}

    private void heapifyDown() {}
}
