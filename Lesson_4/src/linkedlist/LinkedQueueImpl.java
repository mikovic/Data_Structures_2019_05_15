package linkedlist;

import queue.Queue;

import java.util.Iterator;

public class LinkedQueueImpl<E> implements Queue<E>,Iterable<E> {

    private TwoSideLinkedList<E> data;

    public LinkedQueueImpl() {
        this.data = new TwoSideLinkedListImpl<>();
    }

    @Override
    public void insert(E value) {
        data.insertLast(value);
    }

    @Override
    public E remove() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.getFirstElement();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}