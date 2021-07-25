import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class billing {

   static Scanner sc = new Scanner(System.in);
   // case val
   static int Sno;
   static String Item = "";
   static int Quantity;
   static Double productTotal = 0.0;
   static double subtotal = 0;

   // calculation val
   static final double gst = 0.0675;
   static double GstAmount;
   static Double Total;
   static double MINtip = 0.1;
   static double tipAmount;
   static double Usertip = 0;

   static String OrderAgain;
   // store data?
   static ArrayList<String> orderedItem = new ArrayList<String>(); // Create an ArrayList object
   static ArrayList<Double> orderedtotal = new ArrayList<Double>(); // Create an ArrayList object
   static ArrayList<Integer> orderQuantity = new ArrayList<Integer>(); // Create an ArrayList object

   public static void main(String[] args) {

      menu();
      select();
      calSubTotal();
      calGST();
      calTip();
      calTotal();
      DisplayOrder();

   }

   // display of the menu
   public static void menu() {
      System.out.println("                 Menu   \n________________________________________");
      System.out.println("S/o         Order          Price");
      System.out.println(
            " 1      Steak               $30 \n 2      Calamari            $15 \n 3      Coke                $7 \n 4      Wine                $20");

   }

   // user input for selecting their choices
   public static void select() {
      System.out.println("enter the Serial number");
      Sno = sc.nextInt();
      System.out.println("enter the quantity");
      Quantity = sc.nextInt();
      productTotal = 0.0;

      foodSelected();
   }

   // input the calculated field based on the case/serial number into arraylists
   // created
   public static void foodSelected() {
      
         switch (Sno) {
            case 1:
               productTotal += (Quantity * 30);
               Item = "Steak";
               orderedItem.add(Item);
               orderedtotal.add(productTotal);
               orderQuantity.add(Quantity);
               break;
            case 2:
               productTotal += (Quantity * 15);
               Item = "Calamari";
               orderedItem.add(Item);
               orderedtotal.add(productTotal);
               orderQuantity.add(Quantity);

               break;
            case 3:
               productTotal += (Quantity * 7);
               Item = "Coke";
               orderedItem.add(Item);
               orderedtotal.add(productTotal);
               orderQuantity.add(Quantity);

               break;
            case 4:
               productTotal += (Quantity * 20);
               Item = "Wine";
               orderedItem.add(Item);
               orderedtotal.add(productTotal);
               orderQuantity.add(Quantity);

               break;

            default:
               System.out.println("doesnt exist"); 
               select();
         }
      
      addorder();
   }

   // add if got any extra order besides the first one
   static void addorder() {
      System.out.println("Would u like to buy anything else? y/n");
      OrderAgain = sc.next();

      if (OrderAgain.equals("y")) {

         select();

      } else if (OrderAgain.equals("n")) {
         System.out.println("\nCheck your bill \n                   ");
         
      }

   }

   // to calculate the GST/Tax
   static void calGST() {

      GstAmount = subtotal * gst;

   }

   // to calculate the absolute total
   static void calTotal() {
      Total = GstAmount + subtotal + tipAmount;

   }

   // calculate subtotal- from arraylist
   static void calSubTotal() {
      for (Double d : orderedtotal) {
         subtotal += d;
      }

   }

   // the tip payment based on how much the user want to give
   static void calTip() {

      System.out.println(" How much would you like to tip minimum 10% \n  ");
      double Usertip = sc.nextInt();
      double inflation;
      inflation = (Usertip / 100.0);
      if (Usertip >= 10) {
         tipAmount = inflation * subtotal;

      } else if (Usertip < 10) {
         tipAmount = MINtip * subtotal;

      }

   }

   // display order/receipt
   static void DisplayOrder() {
      System.out.println(
            "------------------------------------------- \n                   Receipt  \n-------------------------------------------");
      System.out.println("Item               Qty               Cost \n--------------------------------------------");

      int i = 0;
      for (String s : orderedItem) {
         System.out.println(s + "               " + orderQuantity.get(i) + "                   $ " + orderedtotal.get(i));
         i++;
      }
      System.out.println("------------------------------------------- ");
      System.out.println("                   " + "Subtotal       " + "$" + subtotal);
      System.out.println("                   " + "GST (6.75%)    " + "$" + GstAmount);
      System.out.println("                   " + "Tip" + "            " + "$" + tipAmount);
      System.out.println("                   " + "Total          " + "$" + Total);

   }

}
