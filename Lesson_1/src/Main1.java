import java.util.ArrayList;
import java.util.List;

public class Main1 {

    private static int b;

    public static void main(String[] args) {
        int a = 5;//001[5]
        System.out.println(a);

        List<String> list = new ArrayList<>();


        Person p1 = new Person("Ivan", 25);//001[005]
        Person p2 = new Person("Ivan", 25);//002[008]

        System.out.println(p1 == p2);//005 == 008
        System.out.println("p1 equals p2: " + p1.equals(p2));

        String str1 = "str";
        String str2 = new String("str");
        System.out.println("str1 == str2:" + (str1 == str2));

        System.out.println("str1 equals str2:" + str1.equals(str2));

        int c = 5;
        int d = 5;
        System.out.println(c == d);

        System.out.println("-------------");

        System.out.println(c);
        testA(c);
        System.out.println(c);

        System.out.println("-------------");
        Person p3 = new Person("Ivan", 25);//001[005]
        System.out.println(p3);
        testB(p3);//<- 005

        System.out.println(p3);//001 [005] -> [007, 008]

        int[] arr = {1, 3};
        Integer[] arr1 = {1, 3};
    }

    private static void testB(Person p3) {//002 [005]
        System.out.println(p3);//002 [005] -> [006, 008]
        p3.setName("Pavel");//002 [005] -> [007, 008]
        p3 = new Person("Petr", 33);;//002 [007]
        System.out.println(p3);
    }

    private static void testA(Integer c) {
        System.out.println(c);
        c = 7;
        System.out.println(c);
    }
}
