import java.util.NoSuchElementException;

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

    private void heapifyUp() {
        int index = list.size() - 1;
        while (hasParent(index) && parent(index).compareTo(list.get(index)) > 0) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = leftChildIndex(index);
            if (hasRightChild(index) && rightChild(index).compareTo(leftChild(index)) < 0) {
                smallerChildIndex = rightChildIndex(index);
            }
            if (list.get(index).compareTo(list.get(smallerChildIndex)) < 0) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    private boolean hasParent(int index) {
        return index > 0;
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private E parent(int index) {
        return list.get(parentIndex(index));
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) < list.size();
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private E leftChild(int index) {
        return list.get(leftChildIndex(index));
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < list.size();
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    private E rightChild(int index) {
        return list.get(rightChildIndex(index));
    }

    private void swap(int index1, int index2) {
        E temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
}
