package linkedlist;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    public static class Entry<E> {
        public final E value;
        public Entry<E> next;

        Entry(E value) {
            this.value = value;
        }
    }


    protected Entry<E> firstElement;//002
    protected int size;

    @Override//O(1)
    public void insertFirst(E value) {
        Entry<E> entry = new Entry<>(value);//003
        entry.next = firstElement;
        firstElement = entry;
        size++;
    }

    @Override//O(1)
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Entry<E> removedValue = firstElement;
        firstElement = firstElement.next;

        size--;

        return removedValue.value;
    }

    @Override//O(N)
    public boolean remove(E value) {
        Entry<E> previousElement = null;
        Entry<E> currentElement = firstElement;
        while (currentElement != null) {
            if ( currentElement.value.equals(value) ) {
                break;
            }
            previousElement = currentElement;
            currentElement = currentElement.next;
        }

        if (currentElement == null) {
            return false;
        }

        if (currentElement == firstElement) {
            firstElement = firstElement.next;
        }
        else {
            previousElement.next = currentElement.next;
        }

        size--;
        return true;
    }

    @Override
    public void display() {
        System.out.println("------------");
        System.out.println("display " + this.getClass().getSimpleName());

        Entry<E> current = this.firstElement;
        while ( current != null ) {
            System.out.println(current.value);
            current = current.next;
        }

        System.out.println("------------");
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override//O(N)
    public boolean contains(E value) {
        Entry<E> currentElement = firstElement;
        while (currentElement != null) {
            if ( currentElement.value.equals(value) ) {
                return true;
            }
            currentElement = currentElement.next;
        }

        return false;
    }

    @Override
    public E getFirstElement() {
        return firstElement.value;
    }

    @Override
    public Entry<E> getFirst() {
        return firstElement;
    }
}
