package guitest;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class define the class-member fields and methods for the Recipe object that will be created
 * to manages the recipes to be included in the collection. 
 * 
 * @author Eric Lara
 */
public class Recipe {
    /* Igredient class-member fields declaration*/
    private String recipeName                               = "Unamed Recipe";
    private int servings                                    = 0;
    private ArrayList<Ingredient> recipeIngredients         = new ArrayList<>();
    private double totalRecipeCalories                      = 0.0;
    private ArrayList<String> recipeStepbyStepInstruction   = new ArrayList<>();                         
    
    /**
     * Returns a string representing the Recipe's name. 
     * @return recipeName  
     */
    public String getRecipeName( ) {
        return recipeName;
    }
    
    /**
     * Sets the recipe object name attribute value to a given string. 
     * @param recipeName, a string representing the new recipe's name string value.
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    
    /**
     * Returns an integer representing the recipe's servings. 
     * @return servings
     */
    public int getServings() {
        return servings;
    }
    
    /**
     * Set the recipe object servings attribute to a given integer value. 
     * @param servings, an integer representing the new recipe's servings value. 
     */
    public void setServings(int servings) {
        this.servings = servings;
    }
    
    /**
     * Returns an Array List of the recipe's ingredients objects.
     * @return recipeIngredients
     */
    public ArrayList<Ingredient> getRecipeIngredients() {
        return recipeIngredients;
    }
    
    /**
     * Set the recipe's ingredient Array list to a given Array List of ingredients objects. 
     * @param recipeIngredients, representing a new Array List of ingredient objects.  
     */
    public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }
    
    /**
     * Returns a double representing the recipe's total calories value. 
     * @return totalRecipeCalories
     */
    public double getTotalRecipeCalories() {
        return totalRecipeCalories;
    }
    
    /**
     * Sets the recipe's object total recipe calories to a given double.
     * @param totalRecipeCalories, a double representing the new total recipe calories value. 
     */
    public void setTotalRecipeCalories(double totalRecipeCalories) {
        this.totalRecipeCalories = totalRecipeCalories;
    }
    
    /**
     * Prints the recipe object details including the name, servings, ingredient list,
     * and the total calories. If the recipe's ingredient list is empty, it will print
     * the message the recipe does not contains any ingredients. 
     */
    public void printRecipe() {
        System.out.println("\n======Recipe Details===================");
        System.out.println("\nName of recipe: " + getRecipeName());
        System.out.println("Servings: " + getServings());
        System.out.println("------Ingredients----------------------");
        /* Cheking if the recipe's ingredients array list is empty */
        if (recipeIngredients.isEmpty()) {
            System.out.println("This recipe does not contains any ingredients");
        }
        else {
            for (Ingredient ingredient : recipeIngredients) {
                /* Verifying if the ingredient amount is greater than 1 to display 
                the measurment unit in plurar or singular form */
                if(ingredient.getIngredientAmount() > 1){    
                    System.out.println(ingredient.getIngredientAmount() + " " + ingredient.getIngredientAmount() + "s of " + ingredient.getIngredientName());
                }
                else{
                    System.out.println(ingredient.getIngredientAmount() + " " + ingredient.getIngredientAmount() + " of " + ingredient.getIngredientName());
                }
            }
        }
        System.out.println("---------------------------------------");
        System.out.println("Total recipe calories: " + getTotalRecipeCalories());
        System.out.println("=======================================");
    }
    
    /**
     * Clear the recipe's ingredient array list.
     */
    public void deleteAllIngredients() {
        recipeIngredients.clear();
        /* Proving feedback to user */
        System.out.println("\nAll the ingredients has been deleted");
    }
    
    /**
     * Print a list of the recipe ingredients names along with their index value
     * from the recipe ingredient's array list.  
     */
    public void printIngredientsIndex() {
        int indexCounter = 0;
        System.out.println("\n=======Printing Ingredients Indexes===================");
        for (Ingredient ingredient : recipeIngredients) {
            System.out.println(indexCounter + ": " + ingredient.getIngredientName());
            ++indexCounter;
        }
    }
    
    /**
     * Replaces an ingredient object from the recipe's array list given the
     * ingredient object index to replace and the replacing ingredient object. 
     * @param index, and integer representing the index of ingredient object to
     * replace.
     * @param newIngredient, an ingredient object representing the new ingredient 
     * that will replace the ingredient on the array list at the given index.
     */
    public void replaceRecipeIngredient(int index, Ingredient newIngredient) {
        recipeIngredients.set(index, newIngredient);
    }
    
    /**
     * Add strings representing the step-by-steps recipe instructions.
     */
    public void addStepByStepInstructions() {
        Scanner scnr                                    = new Scanner(System.in);
        Boolean addingInstructions                      = true;
        String instruction                              = "";
        char selection                                  = '?';
        
        /* Do while loop to creates the recipe instructions from user input */
        do {
            
            System.out.println("Do you want to add a recipe instruction? (y/n): ");
            selection = scnr.next().charAt(0);
            scnr.nextLine();                        //clearing buffer
            
            switch (selection) {
                
                case 'y':
                    System.out.println("Enter the recipe instruction: ");
                    instruction = scnr.nextLine();
                    recipeStepbyStepInstruction.add(instruction);
                    break;
                case 'n':
                    addingInstructions = false;
                    break;
                default:
                    System.out.println("Invalid selection, please try again");
            }
            
        } while (addingInstructions);  
    }
    
    /**
     * Prints the step-by-steps recipe instructions.
     */
    public void printStepByStepRecipeInstructions() {
        System.out.println("\n======Recipe Instructions==============");
        System.out.println("Recipe name: " + recipeName);
        
        int instructionStep = 0;
        for (String instruction : recipeStepbyStepInstruction) {
            System.out.println("Step " + instructionStep + ": " + instruction);
            ++instructionStep;
        }
        System.out.println("========================================");
    }
    
    /**
     * Default recipe's constructor with no arguments passed in.
     */
    public Recipe(){
        recipeName                  = "Unamed Recipe";
        servings                    = 0;
        recipeIngredients           = new ArrayList<>();
        totalRecipeCalories         = 0.0;
    }
    
    /**
     * Overloaded recipe constructor with a String as a parameter. 
     * @param recipeName, representing the name of the new recipe's object.
     */
    public Recipe(String recipeName){
        this.recipeName             = recipeName;
        servings                    = 0;
        recipeIngredients           = new ArrayList<>();
        totalRecipeCalories         = 0.0;
        
    }
    
    /**
     * Overloaded recipe constructor with a String, integer,
     * array list, and a double as parameters. 
     * @param recipeName, a string representing the name of the new recipe's object.
     * @param servings, an integer representing the servings of the new recipe's object
     * @param recipeIngredients, an array list representing the list of ingredients of the new
     * recipe object. 
     * @param totalRecipeCalories, a double representing the total calories of the 
     * new recipe object. 
     */
    public Recipe(String recipeName, int servings, 
            ArrayList<Ingredient> recipeIngredients, double totalRecipeCalories) {
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.totalRecipeCalories = totalRecipeCalories;
    }
    
    /**
     * Overloaded recipe constructor with a recipe object as a parameter. 
     * @param obj, another recipe object to copy
     */
    public Recipe(Recipe obj) {
        this.recipeName = obj.getRecipeName();
        this.servings = obj.getServings();
        this.recipeIngredients = obj.getRecipeIngredients();
        this.totalRecipeCalories = obj.getTotalRecipeCalories();
    }
    
    
    /**
     * Custom recipe methods that calls the default recipe constructor.
     * @return Recipe, a new recipe object.  
     */
    //Method to construct a Recipe object
    public Recipe addNewRecipe() {
        return new Recipe(); 
    }
    
    /**
     * Compares a recipe to a given recipe and returns true if both recipe have the same fields value
     * or false otherwise. 
     * @param obj, a given recipe to compare 
     * @return Boolean 
     */
    public boolean compareTo(Recipe obj){
        return (this.getRecipeName().equals(obj.getRecipeName()) && this.getServings() == obj.getServings()
                && this.getRecipeIngredients() == obj.getRecipeIngredients() && 
                this.getTotalRecipeCalories() == obj.getTotalRecipeCalories());
    }
}



