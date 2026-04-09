public interface Orderable {

 //Method prepares the item and each class implements its own steps
   void prepare();  
   
   //Method checks whether the item is available or not
   boolean isAvailable(); 

}