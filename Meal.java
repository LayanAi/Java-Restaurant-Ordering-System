public class Meal extends MenuItem {


   private String mealType; // Type of meal (Lunch , Dinner ,Breakfast)
   private int calories; //Number of calories in the meal
   
   
   //Constructor : create a meal with name , price ,type and calories
   
   public Meal(String name, double price,String mealType, int calories) {
      super(name, price);
      this.mealType = mealType;
      this.calories = calories;
   }


//Copy constructor : creates a new meal by copying another one

   public Meal (Meal obj ){
      super(obj);
      this.mealType = obj.mealType;
      this.calories = obj.calories;
   
   }


//Getters

   public String getMealType(){
      return mealType;
   }


   public int getCalories(){
   
      return calories;
   }


//Setter

   public void setMealType(String mealType ){
      this.mealType = mealType;
   }


   public void setCalories(int calories){
   
      this.calories = calories;
   }



//Override : calculate price based on meal type and calories

   public double calculatePrice() {
     
      double total = price ;
      
      //Add extra cost based on meal type
      if(mealType.equalsIgnoreCase("Dinner")) total+= 20;
      else if(mealType.equalsIgnoreCase("Lunch")) total += 10;
      
      //Add extra cost based on calories
      if(calories > 800) total +=10;
      else   if(calories > 500) total +=5;
      
      return total;
   }
   
   
   //Override : prints preparation steps for the meal
   public void prepare() {
      System.out.println("Preparing meal: " + name);
   }
   
   
   //Override : Method returns a formatted string with the meal details

   public String toString() {
      return super.toString()+", Meal Type : "+mealType+",Calories : "+calories;
   }
}