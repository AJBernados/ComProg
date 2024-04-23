
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
   private static ArrayList<Item> shoppingCart = new ArrayList<>();
   private static Scanner input = new Scanner(System.in);
   
   public static void main(String[] args) throws Exception {
      
      String menuItems = "y";
      boolean selection = true;
      while(selection) {
         System.out.println("-----------------------------------------------");
         System.out.println("A: Add items to cart");
         System.out.println("V: View cart");
         System.out.println("E: Edit item");
         System.out.println("D: Delete item");
         System.out.println("C: Compute Total and Clear the cart");
         System.out.println("Q: Quit");
         System.out.print("Enter choice: ");
         menuItems = input.nextLine();
         System.out.println("-----------------------------------------------");
         switch(menuItems.toUpperCase()) {
            case "A" :  addItemtoCart(shoppingCart);
                     break;
            case "V" :  viewCart(shoppingCart);
                     break;
            case "E" :  editItem(shoppingCart);
                     break;
            case "D" :  deleteItem(shoppingCart);
                     break;
            case "C" :  checkOut(shoppingCart);
                     break;
            case "Q" :  selection = false;
                     break;
         }
      }
   }
   
    public static void addItemtoCart(ArrayList<Item> sCart) {
       Scanner scanner = new Scanner(System.in);
       String itemName = scanner.nextLine();
       int quantity = scanner.nextInt();
       double price = scanner.nextDouble();
       scanner.nextLine();
       
       Item newCartItem = new Item(itemName, quantity, price);
       sCart.add(newCartItem);
   }
   
    public static void viewCart(ArrayList<Item> sCart) {
        int index = 1;
        for (Item item : sCart) {
            System.out.printf("[%d] %s\n", index++, item.toString());
        }
   }
   
    public static void editItem(ArrayList<Item> sCart) {
        viewCart(sCart);
        if (sCart.isEmpty()) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Which item do you want to edit? ");
        int index = scanner.nextInt();
        scanner.nextLine();
        String itemName = scanner.nextLine();
        int quantity = scanner.nextInt();
        double price = scanner.nextDouble();

        Item updatedItem = new Item(itemName, quantity, price);
        index -= 1;
        sCart.set(index, updatedItem);
   }
   
    public static void deleteItem(ArrayList<Item> sCart) {
        viewCart(sCart);
        if (sCart.isEmpty()) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Which item do you want to delete? ");
        int index = scanner.nextInt();
        
        index -= 1;
        sCart.remove(index);
   }
   
    public static void checkOut(ArrayList<Item> sCart) {
        double total = 0;
        for (Item item : sCart) {
            total += item.getTotal();
        }
        System.out.printf("Total amount in shopping cart: %.2f\n", total);
        clearCart(sCart);
   }
   
    public static void clearCart(ArrayList<Item> sCart) {
        sCart.clear();
   }
}
