public class ain{
   public static void main(String[] args) {
       String[] dish={"Sandwich","Coffee","Fries","Chai"};
       double[] cost ={99,89,99,49};
       Bill myBill=new Bill();
       myBill.Addorder("Sandwich", 2, dish, cost);
       myBill.getOrder();
       System.out.println(myBill.gettotal());
   }
}