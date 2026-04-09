/*Supervised By: Hala Qawara 
Section: 2200 
Group number: 64
Student name :Layan Alblulaihi 444201155
Student name :Joud Alqahtani 446202473
Student name :Reema AlKabi 446202638 */

import java.util.Scanner;

public class TestSystem {

   public static void main(String[] args) {
   
      Scanner input = new Scanner(System.in);
   
      Restaurant restaurant = new Restaurant("Riyadh Restaurant ", 50, 10);//This section initializes the restaurant system by creating a Restaurant object
      // with a name, maximum number of menu items, and maximum number of orders.

      Order order = restaurant.addOrder(20);//An order is been created by using addOrder(), and the program checks whether the order was successfully created.
 

      
      if(order == null ){ //If the order limit has been reached, the system displays an error message and stops execution.
         System.out.println("Cannont create order. Limit reached!"); 
            return;
      }
   
      restaurant.addMenuItem(new MainMeal("Chicken Alfredo", 37.0, "Dinner",850,"Creamy Alfredo sauce"));//// Loading all menu items (meals and drinks) into the restaurant.
      restaurant.addMenuItem(new MainMeal("Risotto", 35.0,"Dinner",600, "Creamy rice"));
      restaurant.addMenuItem(new MainMeal("Gnocchi", 34.0,"Dinner",550,"Potato dumplings"));
      restaurant.addMenuItem(new MainMeal("Tortellini", 33.0,"Lunch",500, "Stuffed pasta"));
      restaurant.addMenuItem(new MainMeal("Beef Burger", 32.0,"Lunch",750,"Grilled beef patty"));
      
      restaurant.addMenuItem(new Drink("Orange Juice", 10.0, "Medium", true));
      restaurant.addMenuItem(new Drink("Coca-Cola", 14.0, "Large", true));
   
      int choice;
   
      System.out.println("************* Online Restaurant Ordering System *************");
   
      do {
         System.out.println("\n===== MAIN MENU =====");
         System.out.println("1. View Menu");
         System.out.println("2. Add Item to Order");
         System.out.println("3. Remove Item from Order");
         System.out.println("4. Search Item in Order");
         System.out.println("5. Display Order Details");
         System.out.println("6. Display Total");
         System.out.println("7. Prepare Order");
         System.out.println("8. Exit");
      
         String userInput;
         boolean valid;
      
         do {
            System.out.print("\nYour choice: ");// Validate user input to ensure it contains digits only.
            userInput = input.nextLine();
            valid = true;
         
            if (userInput.isEmpty()) valid = false;
         
            for (int i = 0; i < userInput.length(); i++) {
               char c = userInput.charAt(i);
               if (c < '0' || c > '9') {
                  valid = false;
                  System.out.println("Invalid input. Enter a number.");
                  break;
               }
            }
         
         } while (!valid);
      
         choice = Integer.parseInt(userInput);
      
         switch (choice) {
         
            case 1:
               System.out.println("\n===== MENU ITEMS =====");// Display all menu items.
               restaurant.printMenu();
               break;
         
            case 2:// Add a selected item from the menu to the order.

               System.out.println("\n=== Add to Order ===");
               System.out.println("Choose item:");
               System.out.println("1. Chicken Alfredo");
               System.out.println("2. Beef Burger");
               System.out.println("3. Orange Juice");
               System.out.println("4. Coca-Cola");
               System.out.println("5. Risotto");
               System.out.println("6. Gnocchi");
               System.out.println("7. Tortellini");
            
               String itemInput;
               boolean ok;
            
               do {
                  System.out.print("Your choice: ");
                  itemInput = input.nextLine();
                  ok = true;
               
                  if (itemInput.isEmpty()) ok = false;
               
                  for (int i = 0; i < itemInput.length(); i++) {
                     char c = itemInput.charAt(i);
                     if (c < '0' || c > '9') {
                        ok = false;
                        System.out.println("Invalid input. Enter a number.");
                        break;
                     }
                  }
               
               } while (!ok);
            
               int itemChoice = Integer.parseInt(itemInput);
            
               MenuItem selected = null;
            
               if (itemChoice == 1)
                  selected = restaurant.searchMenuItem("Chicken Alfredo");
               else if (itemChoice == 2)
                  selected = restaurant.searchMenuItem("Beef Burger");
               else if (itemChoice == 3)
                  selected = restaurant.searchMenuItem("Orange Juice");
               else if (itemChoice == 4)
                  selected = restaurant.searchMenuItem("Coca-Cola");
               else if (itemChoice == 5)
                  selected = restaurant.searchMenuItem("Risotto");
               else if (itemChoice == 6)
                  selected = restaurant.searchMenuItem("Gnocchi");
               else if (itemChoice == 7)
                  selected = restaurant.searchMenuItem("Tortellini");
               else
                  System.out.println("Invalid choice.");
            
               if (selected != null) {
                  order.addItem(selected);
                  System.out.println("Item added to order!");
               }
               break;
         
            case 3:// Show current order and remove an item by name.

               if (order.isEmpty()) {
                  System.out.println("Your order is empty. Nothing to remove.");
                  break;
               }
            
               System.out.println("\n===== CURRENT ORDER =====");
               order.printOrder();  
            
               System.out.print("Enter item name to remove: ");
               String removeName = input.nextLine();
            
               System.out.print("Are you sure you want to remove " + removeName + "? (yes/no): ");
               String confirm = input.next();
               input.nextLine();
            
               if (confirm.equalsIgnoreCase("yes")) {
                  if (order.removeItem(removeName)) {
                     System.out.println("Item removed!");
                  } else {
                     System.out.println("Item not found in order.");
                  }
               } else {
                  System.out.println("Canceled.");
               }
               break;
            case 4:// Search for an item inside the current order.

               System.out.print("Enter item name to search: ");
               String searchName = input.nextLine();
            
               if (order.searchItem(searchName)) {
                  System.out.println("Item exists in your order.");
               } else {
                  System.out.println("Item not found.");
               }
               break;
         
            case 5:// Print all order details including items and prices.

               System.out.println("\n===== ORDER DETAILS =====");
               order.printOrder();
               break;
         
            case 6: // Calculate the total price using recursion.

               System.out.println("\nCalculating total using recursion...");
               double total = order.recursiveTotal(0);
               System.out.println("Total = " + total + " SAR");
               break;
         
            case 7:// Prepare the order if it is not empty.

               if (order.isEmpty()) {
                  System.out.println("Order is empty. Nothing to prepare.");
                  break;
               }
            
               System.out.println("\nPreparing your order...");
               order.prepareOrder();
               System.out.println("Order is ready!");
               break;
         
            case 8:// Exit the system.
               System.out.println("Thank you for using the system!");
               break;
         
            default: // Handle invalid menu choices.
               System.out.println("Invalid choice.");
         }
      
      } while (choice != 8);
   
   }
}