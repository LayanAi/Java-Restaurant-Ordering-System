public class Order implements MainExtra{

   private int orderId;
   private MenuItem[] items;
   private int count;

//Constructor : creates an order with id and array size

   public Order(int orderId, int size) {
      this.orderId=orderId;
      items = new MenuItem[size];
      count = 0;
   }
    
    
    //Getter
    
   public int getOrderId(){
      return orderId;
   }

    /*Method adds MenuItem to the order by creating a new object
     of the same type (deep copy)*/
      
   public boolean addItem(MenuItem item) {
      if (item == null || count == items.length)
         return false ;
    
        
      if(!item.isAvailable()){
         System.out.println(item.getName()+" is not available");
         return false;
      }
        
        
      if(item instanceof MainMeal){
         items[count] = new MainMeal((MainMeal) item ); 
      
      } else if ( item instanceof Drink ){
         items[count] = new Drink((Drink) item ); 
       
      } else if(item instanceof Meal){
         items[count] = new Meal((Meal) item ); 
      }else {
         return false;
      }
     
      count ++;
      return true ;
   }
    

    //Method removes an item by name
    
   public boolean removeItem(String name) {
      for (int i = 0; i < count; i++) {
         if (items[i] !=null && items[i].getName().equalsIgnoreCase(name)) {
            
            for (int j = i; j < count - 1; j++) {
               items[j] = items[j + 1];
            }
            count--;
            items[count] =null;
            return true;
         }
      }
      return false;
   }
    
    
    //Method searches for an item by name

   public boolean searchItem(String name) {
      for (int i = 0; i < count; i++) {
         if (items[i] !=null && items[i].getName().equalsIgnoreCase(name)) {
            return true;
         }
      }
    
      return false;
   }


    //Method calculates total price using recursion
    
   public double recursiveTotal(int index) {
      if (index >= count) {
         return 0;
      }
      return items[index].calculatePrice() + recursiveTotal(index + 1);
   }


    //Method prints all items in the order

   public void printOrder() {
      if (count == 0) {
         System.out.println("Order is empty.");
         return;
      }
   
      for (int i = 0; i < count; i++) {
         if(items[i] != null){
            System.out.println(items[i]);
            System.out.println("--------------------");
         }
      }
   
      System.out.println("Total = " + recursiveTotal(0));
   }
    
    
   //Method prepares all items in the order
   
   public void prepareOrder() {
      if (count == 0) {
         System.out.println("Order is empty. Nothing to prepare.");
         return;
      }
   
      for (int i = 0; i < count; i++) {
         if(items[i] != null){
            items[i].prepare();
         }
      }
   
   }


    //Method checks if order is empty
   public boolean isEmpty() {
      return count == 0;
   }


//Method adds an extra to the order 
   public void addExtra(String extra){
   
      System.out.println("Extra added to order #"+orderId+": "+extra);
   }

}