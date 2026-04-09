public abstract class MenuItem implements Orderable {

   protected String name;
   protected double price;
   protected boolean available;
 
 
/*Constructor : creates a new item with a name , price 
 and default available = true */
 
   public MenuItem(String name, double price) {
      this.name = name;
      this.price = price;
      this.available=true;
   }
 
 //Copy constructor : copies the attributes from another MenuItem object
   public MenuItem (MenuItem obj ){
      this.name = obj.name;
      this.price = obj.price;
      this.available=obj.available;
   
   }
 
 
 //Method to return whether the item is available or not
 
   public  boolean isAvailable(){
      return available;
   }
 
 
//Getter
   public String getName() {
      return name;
   }

   public double getPrice() {
      return price;
   }
 
 //Setter
 
   public void setName(String name){
      this.name = name;
   }
 
   public void setPrice(double price){
      this.price = price;
   }


 //Abstract method : each subclass defines how the item is prepared

   public abstract void prepare();

 //Abstract method : each subclass calculates its final price

   public abstract double calculatePrice();
 
 
 // Method returns a formatted string with item information 
   public String toString(){
   
      return "Name : "+name +", Price : "+price+",Available :"+available ;
   
   }

}