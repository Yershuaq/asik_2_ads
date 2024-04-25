import java.util.NoSuchElementException;

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
