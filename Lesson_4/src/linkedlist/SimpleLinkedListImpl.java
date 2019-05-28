package linkedlist;



import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E>, Iterable<E> {

    protected Entry<E> firstElement;//002
    protected Entry<E> currentElement;

    protected int size;

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<E>();

    }
    private class MyIterator<E> implements Iterator<E>{
        public MyIterator() {
            currentElement = firstElement;
        }

        @Override
        public boolean hasNext() {
            boolean flag = true;
            if (currentElement == null) {
                flag = false;
                currentElement = firstElement;

            }
            return flag;
        }

        @Override
        public E next() {
            SimpleLinkedListImpl.Entry<E> element = null;
            if (hasNext()) {
                element = (Entry<E>) currentElement;
                currentElement = currentElement.next;

            }
            return element.value;
        }

        @Override
        public void remove() {
            if (!isEmpty()) {
                firstElement = firstElement.next;
                currentElement = firstElement;
                size--;
            }

        }
    }


    public static class Entry<E> {
        public final E value;
        public Entry<E> next;

        Entry(E value) {
            this.value = value;
        }
    }



    @Override//O(1)
    public void insertFirst(E value) {
        Entry<E> entry = new Entry<>(value);//003
        entry.next = firstElement;
        firstElement = entry;
        currentElement = entry;
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
