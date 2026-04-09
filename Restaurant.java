public class Restaurant {

   private String name;
   private MenuItem[] menu; //Aggregation
   private int menuCount;
   private Order [] orders; //Composition
   private int orderCount;
   private int nextOrderId; 

   public Restaurant(String name , int MenuSize, int OrderSize) {
      this.name =name;
      menu = new MenuItem[MenuSize];
      menuCount=0;
   
      orders = new Order[OrderSize];
      orderCount = 0;
      nextOrderId=1;
   }


// ======= Menu Managment (Aggregation) ======

// Method adds a MenuItem to the restaurant menu

   public boolean addMenuItem(MenuItem item) {
      if ( item == null )
         return false;
   
      if (menuCount < menu.length) {
         menu[menuCount] = item;
         menuCount++;
         return true;
      }
      return false;
   }


//Method searches for a MenuItem by name

   public MenuItem searchMenuItem(String name) {
      if ( name == null )
         return null;
   
      for (int i = 0 ; i < menuCount ; i++){
         if (menu[i] != null && menu[i].getName().equalsIgnoreCase(name)){
            return menu[i]; 
         }
      }
      return null;
   }


//Method removes a MenuItem by name

   public boolean removeMenuItem(String name) {
      if( name == null )
         return false;
   
      for (int i = 0; i < menuCount; i++) {
         if (menu[i] != null && menu[i].getName().equalsIgnoreCase(name)){
         
           //Shift elements left after deleting the item
            for (int j = i; j < menuCount - 1; j++) {
               menu[j] = menu[j + 1];
            }
            menuCount--;
            menu[menuCount] = null;
            return true;
         }
      }
      return false;
   }


// ======= Order Managment (Composition) ======



//Method creates a new order with a unique ID and adds it to the restaurant

   public Order addOrder(int size){
   
      if(orderCount >= orders.length)
         return null;
      Order newOrder = new Order(nextOrderId++,size);
      orders[orderCount++]=newOrder;
      return newOrder;
   
   }


//Method searches for an order by its ID 

   public Order searchOrder(int orderId){
      for(int i = 0 ; i < orderCount;i++){
         if(orders[i] != null && orders[i].getOrderId() == orderId)
            return orders[i];
      
      }
      return null;
   
   }


//Method removes for an order by its ID 

   public boolean removeOrder(int orderId ){
      for (int i = 0 ; i<orderCount ; i++){
         if(orders[i] != null && orders[i].getOrderId() == orderId ){
         
          //Shift elements left after deleting the item
            for ( int j = i ; j<orderCount - 1 ; j++)
               orders[j] =  orders[j + 1];
            orderCount --;
            orders[orderCount] = null;
            return true;
         }
       
      }
      return false;
   }


//Method prints the enitre menu

   public void printMenu() {
      System.out.println("===== "+name+" Menu =====");
      printMenuRecursive(0);
   }
   
   
   //Recursive method to print menu items
   
   public void printMenuRecursive(int index) {
      if (index >= menuCount) {
         return;
      }
   
      if (menu[index] != null ){
         System.out.println(menu[index].toString());
      }
      printMenuRecursive(index + 1);
   }
   
  
  //Method prints all orders in the restaurant
   public void printAllOrders(){
      System.out.println("====== All Orders =====");
      for(int i = 0 ; i< orderCount ; i++){
         if (orders[i] !=null ){
            orders[i].printOrder();
            System.out.println("---------------------");
         }
      }
   }
}