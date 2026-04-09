public class Drink extends MenuItem {

   private String size; //Size of the drink (Small , Mediuam ,Large)


  //Constructor : creates a drink with name,price,size and sets availability
  
   public Drink(String name, double price, String size, boolean available) {
      super(name, price);
      this.size = size;
      super.available = available;
   }
 
 //Copy constructor : creates a new Drink by copying another one
 
   public Drink(Drink obj){
      super(obj);
      this.size = obj.size; 
   }



//Override : calculates total price based on drink size
   public double calculatePrice() {
   
      double total = price;
      if (size == null || size.length() == 0)
         return total ;
   
      if (size.equalsIgnoreCase("Small")){
         total += 10;
      }else if (size.equalsIgnoreCase("Medium")){
         total += 15;
      }else if (size.equalsIgnoreCase("Large")){
         total += 20;
      }
      return total;
   }
  
 
 //Override : prints preparation steps for the drink
 
   public  void prepare() {
      System.out.println("Pouring drink: " + name+ "(" +size+")");
   }

//Override : Method returns a formatted string with the drink details

   public String toString() {
      return "Drink: " + name + ", Size: " + size + ", Price: " + calculatePrice();
   }
}