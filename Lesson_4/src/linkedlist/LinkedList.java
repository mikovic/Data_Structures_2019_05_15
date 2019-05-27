package linkedlist;

public interface LinkedList<E> {

    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    void display();

    boolean isEmpty();

    int getSize();

    boolean contains(E value);

    E getFirstElement();

    SimpleLinkedListImpl.Entry<E> getFirst();

}
