import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(step(10, 3));
        BackPack backPack = new BackPack(1.5);
        Entity entity = new Entity("IPhone", 0.2,850 );
        Entity entity1 = new Entity("SmartNoname", 0.3,150 );
        Entity entity2 = new Entity("Notebook", 0.6,350 );
        Entity entity3 = new Entity("Mcbook", 0.2,1000 );
        Entity entity4 = new Entity("Galaxy10", 0.25,650 );
        Entity entity5= new Entity("IPad", 0.3,350 );
        Entity entity6 = new Entity("Note", 0.3,150 );
        Entity entity7 = new Entity("Beetze", 0.3,300 );
        Entity entity8 = new Entity("watch", 0.1,300 );
        Entity entity9 = new Entity("GamePad", 0.15,200 );
        Entity entity10 = new Entity("JBL", 0.25,230 );
        List<Entity> list = new ArrayList<>();
        list.add(entity);
        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        list.add(entity4);
        list.add(entity5);
        list.add(entity6);
        list.add(entity7);
        list.add(entity8);
        list.add(entity9);
        list.add(entity10);
        backPack.search(list);
        backPack.display();




    }
    public static int step(int x, int n){
        if(n == 0) return 1;
        return x * step(x, n - 1);
    }

}
