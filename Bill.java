import java.util.*;
public class Bill{
     private ArrayList<String> FoodOrdered;
     private ArrayList<Integer> QuantityOrdered;
     public Bill(){
        FoodOrdered =new ArrayList<String>();
        QuantityOrdered =new ArrayList<Integer>();
     }
     private double totalcost;
     public double gettotal(){
        return totalcost;
     }
     public void Addorder(String meal, int quantity,String[] dish,double[] cost){
         FoodOrdered.add(meal);
         QuantityOrdered.add(quantity);
         for(int i=0; i<dish.length;i++){
            if(meal.equals(dish[i])){
            totalcost+=quantity*cost[i];
            }
         }
     }
         public void getOrder(){
            for(int i=0;i<FoodOrdered.size();i++){
                System.out.println(FoodOrdered.get(i)+" "+QuantityOrdered.get(i));
            }
         }

     }
