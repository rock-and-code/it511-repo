
package guitest;

/**
 * This class represents recipe's ingredients. The class Ingredient includes methods for 
 * setting up and get the ingredient's name, amount, calories per measurement unit, 
 * the unit of measurement, and to display the ingredient details. 
 * 
 */
public class Ingredient {
    /* Private class-member fields declaration  */
    private String ingredientName;
    private float ingredientAmount;
    private int numberCaloriesPerUnit;
    private String unitMeasurement;
    double totalCalories;
    
    /**
     * Set the ingredient's name attribute to a given string value. 
     * @param ingredientName 
     */
    public void setIngredientName(String ingredientName){
        this.ingredientName = ingredientName;
    }
    
    /**
     * Returns a string that represents the ingredient name.
     * @return nameOfIngredient
     */
    public String getIngredientName(){
        return ingredientName;
    }
    
    /**
     * Set the ingredient's amount attribute to a given double value. 
     * @param ingredientAmount 
     */
    public void setIngredientAmount(float ingredientAmount){
        this.ingredientAmount = ingredientAmount;
    }
    
    /**
     * Returns a double that represents the ingredient amount.  
     * @return ingredientAmount
     */
    public float getIngredientAmount(){
        return ingredientAmount;
    }
    
    /**
     * Set the number of calories attribute per a given measurement unit. 
     * @param numOfCaloriesPerUnit
     */
    public void setNumOfCaloriesPerUnit(int numOfCaloriesPerUnit){
        this.numberCaloriesPerUnit = numOfCaloriesPerUnit;
    }
    
    /**
     * Returns a integer that represents the ingredient's number of calories per a given measurement unit. 
     * @return numOfCaloriesPerUnitMeasurement
     */
    public int getNumOfCaloriesPerUnit(){
        return numberCaloriesPerUnit;
    }
    
    /**
     * Set the ingredient unit of measurement attribute to a given string. 
     * @param unitMeasurement 
     */
    public void setUnitMeasurement(String unitMeasurement){
        this.unitMeasurement = unitMeasurement;
    }
    
    /** 
     * Returns a string that represents the ingredient's measurement unit. 
     * @return unitMeasurement 
     */
    public String getUnitMeasurement(){
        return unitMeasurement;
    }
    
     /** 
     * Set the ingredient's total calories value to a given double.  
     * @param totalCalories
     */
    public void setTotalCalories(double totalCalories){
        this.totalCalories = totalCalories;
    }
    
     /** 
     * Returns a double that represents the ingredient's total calories. 
     * @return totalCalories 
     */
    public double getTotalCalories(){
        return totalCalories;
    }
    
    /**
     * Display all the ingredient details including the name, measurement unit, amount, and the total 
     * calories per measurement unit. 
     */
    public void displayIngredient(){
        System.out.println("\n" + ingredientAmount + " " + unitMeasurement + " of " + ingredientName 
                + " contains " + numberCaloriesPerUnit + " calories");
    }
    
    /* Default Ingredient class constructor */
    public Ingredient(){
        ingredientName          = "Unamed Ingredient";      //Setting default name of the ingredient
        ingredientAmount        = 0;                      //Setting default ingredient abmount
        unitMeasurement         = "cups";                   //Setting default unit of measurement
        numberCaloriesPerUnit    = 0;
        totalCalories           = (double)(numberCaloriesPerUnit * ingredientAmount);
                
    }
    /* Constructor with argument passed in */
    public Ingredient(String ingredientName, String unitMeasurement, float ingredientAmount, 
            int numOfCaloriesPerUnit){
        this.ingredientName          = ingredientName;
        this.unitMeasurement         = unitMeasurement;
        this.ingredientAmount        = ingredientAmount;
        this.numberCaloriesPerUnit    = numOfCaloriesPerUnit;
        this.totalCalories           = (double)(numOfCaloriesPerUnit * ingredientAmount);
                
    }
    
    /**
     * Custom ingredient methods that calls the default ingredient constructor.
     * @return Ingredient, a new ingredient object.  
     */
    public Ingredient addIngredient(){
       return new Ingredient();
    }
}

