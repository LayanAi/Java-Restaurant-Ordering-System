public class MainMeal extends Meal implements MainExtra {

   private String description;
   private String [] extras;
   private int extraCount; 
    
   /*Constructor : creates a main meal with name , price , type ,
    calories , description and Initializes the extras array */
    
   public MainMeal(String name, double price,String mealType, int calories, String description) {
      super(name, price, mealType,calories); 
      this.description = description;
      extras = new String[5];
      extraCount = 0;
   }
    
   /*Copy constructor : creates a new MainMeal by copying another one , 
   including its extras and description*/
   
   public MainMeal(MainMeal obj){
      super(obj);
      this.description =obj.description;
      extras = new String[5];
      for (int i =0 ; i < obj.extraCount; i++){
         this.extras[i] = obj.extras[i];
      }
    
      this.extraCount = obj.extraCount;
   
   }
    
    
   //Method adds an extra item to the main meal
   public void addExtra(String extra) {
      if (extraCount <extras.length){
         extras[extraCount] = extra ;
         extraCount++;
      } 
      else {
         System.out.println("No more extras can be added ");
      }
   }
    
    
    //Override : calculates final price based on the number of extras
   public double calculatePrice() {
      return price +(extraCount * 10 );
   }

   //Override : prints preparation steps for the meal and its extras 
   public void prepare() {
      System.out.println("Preparing " + name + " - " + description);
      for (int i = 0 ; i< extraCount ; i++ ){
         System.out.println("Adding extra : "+ extras[i]);
      }
   }
    
    //Override:  returns a formatted string with the meal details and extras
   public String toString(){
      String str = super.toString()+", Description : "+description;
    
      if (extraCount> 0 ){
         str += ", Extras : ";
         for (int i = 0 ; i <extraCount ; i++){
            str += extras[i] ;
            if( i < extraCount - 1 ) str += ", " ;
         }
      }
      return str;
   }
}