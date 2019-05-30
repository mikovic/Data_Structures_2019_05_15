import java.util.ArrayList;
import java.util.List;

public class BackPack {
List<Entity> bestList;
double maxWeiht;
double bestValue;
double weigtSet;

    public BackPack(double maxWeiht) {
        this.maxWeiht = maxWeiht;
    }

    public double calculateWeigt(List<Entity> list) {
        double sum = 0;
        for (Entity entity : list){
            sum =sum + entity.weiht;
        }
        return sum;
    }
    private double calculatePrice(List<Entity> list)
    {
        double sum = 0;
        for (Entity entity : list){
            sum =sum + entity.value;
        }
        return sum;

    }
    private void chek(List<Entity> list)
    {
        if (bestList == null)
        {
            if (calculateWeigt(list) <= maxWeiht)
            {
                bestList = list;
                bestValue = calculatePrice(list);
                weigtSet = calculateWeigt(list);
            }
        }
        else
        {
            if(calculateWeigt(list) <= maxWeiht && calculatePrice(list) > bestValue)
            {
                bestList = list;
                bestValue = calculatePrice(list);
                weigtSet = calculateWeigt(list);
            }
        }
    }
    public void search(List<Entity>  list)
    {
        if (list.size() > 0)
            chek(list);

        for (int i = 0; i < list.size(); i++)
        {
            List<Entity> newList = new ArrayList<>(list);
            newList.remove(i);
            search(newList);
        }

    }
    public void display(){
        System.out.println("Лучший набор. Общая ценность "+ bestValue + " Вес набора "+  weigtSet);
        for (Entity entity : bestList){
            System.out.println(entity.name + " Вес: "+ entity.weiht  +" Цена: "+ entity.weiht);

        }
    }


}
