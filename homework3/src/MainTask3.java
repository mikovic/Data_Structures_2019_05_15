import queue.PriorityQueue;

import java.util.regex.Pattern;



public class MainTask3 {
    public static void main(String[] args) {


        Deque<Integer> deque = new DequeImpl<>(10);
        addToQueue(deque, 2);
        addToQueue(deque, 4);
        addToQueue(deque, 1);
        addToQueue(deque, 5);
        addToQueue(deque, 3);
        ((DequeImpl<Integer>) deque).display();
        deque.insertRight(10);
        ((DequeImpl<Integer>) deque).display();
        deque.insertLeft(100);
        ((DequeImpl<Integer>) deque).display();
        deque.insertLeft(200);
        ((DequeImpl<Integer>) deque).display();
        deque.insertRight(20);
        ((DequeImpl<Integer>) deque).display();
        deque.insertRight(30);
        ((DequeImpl<Integer>) deque).display();
        deque.removeRight();
        ((DequeImpl<Integer>) deque).display();
        deque.removeRight();
        ((DequeImpl<Integer>) deque).display();
        deque.removeRight();
        ((DequeImpl<Integer>) deque).display();
        deque.insertRight(50);
        ((DequeImpl<Integer>) deque).display();
        deque.insertLeft(300);
        ((DequeImpl<Integer>) deque).display();
        deque.removeLeft();
        ((DequeImpl<Integer>) deque).display();
        deque.removeLeft();
        ((DequeImpl<Integer>) deque).display();
        deque.removeLeft();
        ((DequeImpl<Integer>) deque).display();

        deque.insertLeft(500);
        ((DequeImpl<Integer>) deque).display();
        System.out.println("---------------------------");
        System.out.println("Переворот:");
        String str = reverse("1   2, 3! 4 5");
        System.out.println(str);
        System.out.println("---------------------------");
        System.out.println("Сортировка:");
        Character[] chars = {'A', 'C', 'B', 'M', 'D','L', 'K'};
        ArrayImpl array = sort(chars);
        System.out.println(array);
        System.out.println("Минимальное число:");
        Integer[] nums = {23, 56, 98, 24, 1};
        System.out.println(min(nums));





    }


    private static void addToQueue(Deque<Integer> deque, int value) {
        if (!deque.isFull()) {
            deque.insertRight(value);
        }

    }
   public static String reverse (String str) {
       String[] subStr;
       String delimeter = " ";
       StringBuilder sb = new StringBuilder();
       Pattern pattern = Pattern.compile("\\s*(\\s|,|!|\\.)\\s*");
       subStr = pattern.split(str);

       ArrayImpl array = new ArrayImpl(16);
       for (String word : subStr) {
           array.add(word);
       }
      int len = array.currentSize - 1;
       for(int i = len ; i>=0; i--){
           String temp = (String) array.get(i);
           sb.append(temp);
           sb.append(delimeter);
           array.remove(temp);

       }

       return sb.toString().trim();
   }

   public static ArrayImpl sort (Character[] chars){
      ArrayImpl array = new ArrayImpl(chars);
      array.setCurrentSize(chars.length);
      array.sortInsert();
      return array;
   }

    public static int min (Integer[] data){
        ArrayImpl array = new ArrayImpl(data);
        array.sortInsert();
        PriorityQueue pq = new PriorityQueue(data);
        pq.setSize(data.length);
        return (int) pq.remove();
    }
}
