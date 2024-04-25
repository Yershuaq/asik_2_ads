import java.util.Iterator;
public interface MyList<E> {
    void add(E element);
    void add(int index, E element);
    E get(int index);
    E remove(int index);
    int size();
    boolean isEmpty();
    boolean contains(E element);
    java.util.Iterator<E> iterator();
    void set(int index, E element); // Добавляем метод set
}

