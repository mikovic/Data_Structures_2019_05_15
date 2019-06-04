import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int max = 25;
        int min = -25;
        int balancedTree = 0;
        Random r = new Random();
        for (int i = 0; i <20; i++) {

            Tree<Integer> tree = new TreeImpl<>();
            for (int j = 0; j < 100; j++) {
                tree.add(randomInt(r, 25, min));
            }
            tree.display();
            tree.traverse(Tree.TraverseMode.IN_ORDER);

            System.out.println("------------------------");
            if (((TreeImpl<Integer>) tree).isBalanced(((TreeImpl<Integer>) tree).getRoot())) {
                balancedTree++;
                System.out.println("Дерево " + i + " сбалансировано");
            }
        }

        System.out.println("Количество сбалансированных деревьев " + balancedTree + ". В процентах: "+ balancedTree * 5);




    }
    public static int randomInt(Random rnd, int max, int min){
        return rnd.nextInt((max - min) + 1) + min;
    }
}
