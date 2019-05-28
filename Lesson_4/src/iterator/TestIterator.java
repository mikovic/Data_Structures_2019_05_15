package iterator;

import linkedlist.LinkedList;
import linkedlist.LinkedQueueImpl;
import linkedlist.SimpleLinkedListImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestIterator {

    public static void main(String[] args) {
        int[] array = {1, 2, 3};

        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            System.out.println(value);
        }

        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);

//        for (Integer integer : linkedList) {
//            System.out.println(integer);
//        }


        SimpleLinkedListImpl.Entry<Integer> current = linkedList.getFirst();
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }

        System.out.println("------------ JDK ---");

        List<Integer> collection = new java.util.LinkedList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);

        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println(value);
        }

        for (Integer integer : collection) {
            System.out.println(integer);
        }
        collection.add(11);
        collection.add(22);
        collection.add(33);
        for (Integer integer : collection) {
            System.out.println(integer);
        }
        System.out.println("--------------------------");
        LinkedList<Integer> ld = new SimpleLinkedListImpl<>();
        ld.insertFirst(10);
        ld.insertFirst(20);
        ld.insertFirst(30);
        System.out.println("----Итератор Для SimpleLinkedListImpl  ---");

        Iterator<Integer> myIterator =((SimpleLinkedListImpl<Integer>)ld).iterator();
        while (myIterator.hasNext()) {
            Integer value = myIterator.next();
            System.out.println(value);
        }
        ld.insertFirst(400);
        ld.insertFirst(200);
        ld.insertFirst(300);
        System.out.println("---Итератор после новой вставке Для SimpleLinkedListImpl  ---");
        while (myIterator.hasNext()) {
            Integer value = myIterator.next();
            System.out.println(value);
        }
        System.out.println("------------for Each Для SimpleLinkedQueueImpl ---");
        for(Integer value : ld) {
            System.out.println(value);
        }


        LinkedQueueImpl<Integer> lq = new LinkedQueueImpl<>();
        lq.insert(555);
        lq.insert(444);
        lq.insert(333);
        System.out.println("----Итератор Для LinkedQueueImpl  ---");
        Iterator<Integer> newIterator = lq.iterator();
        while (newIterator.hasNext()) {
            Integer value = newIterator.next();
            System.out.println(value);
        }
        lq.insert(1000);
        lq.insert(4000);
        lq.insert(3000);
        System.out.println("--for Each  Для LinkedQueueImpl после новой вставки ---");
        for(Integer value : lq) {
            System.out.println(value);
        }

        System.out.println("---Удаление Итератором из SimpleLinkedListImpl  ---");
        while (myIterator.hasNext()) {
            myIterator.remove();
        }
        if(ld.isEmpty()) System.out.println("После удаления размер: " + ld.getSize()+". SimpleLinkedListImpl пуст");

    }

}
