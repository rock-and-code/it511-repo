package guitest;

import java.util.ArrayList;

/**
 * This class define the class-member fields and methods for the RecipeBox object that will be created
 * to serve as a container to manage the recipes collection.
 *
 * @author Eric Lara
 */
public class RecipeBox {
    /*Class-member field declaration*/
    private ArrayList<Recipe> listOfRecipes;
    
    /**
     * Returns the array list of the recipe's objects 
     * @return listOfRecipes, an array list representing the recipe stored
     * in the collection. 
     */
    public ArrayList<Recipe> getListOfRecipes() {
        return listOfRecipes;
    }
    
    /**
     * Sets the collection's recipe's array list attribute value. 
     * @param listOfRecipesVal, an array list representing the the recipe's
     * stored in the collection. 
     */
    public void setListOfRecipes(ArrayList<Recipe> listOfRecipesVal){ 
        listOfRecipes = listOfRecipesVal;
    }
    
    /**
     * Prints all the details of a recipe that matches the value of a given string. 
     * Prints a message if the given string does not match any of the recipe name in the collection.
     * @param recipeName, a string representing the recipe
     */
    public void printAllRecipeDetails(String recipeName) {
        int countRecipeNameAppearances          =0;                 //A counter to check if recipe name appers in the list
        for (Recipe recipe : listOfRecipes) {
            if (recipe.getRecipeName().equals(recipeName)) {
                countRecipeNameAppearances++;
                recipe.printRecipe();
            }
        }
        // Display error message if supplied name does not match any of the recipe name in the list of recipes
        if (countRecipeNameAppearances == 0) {
            System.out.println("\nNo recipe found under " + recipeName + " name");
        }
    }
    
    /**
     * Prints all the recipe names in the collection. 
     */
    public void printAllRecipeNames(){
        if (listOfRecipes.isEmpty()) {
            System.out.println("\nThe recipe collection is currently empty!");
        }
        else {
            System.out.println("\n===Printing recipes names==================");
            for (Recipe recipe : listOfRecipes) {
                System.out.println(recipe.getRecipeName());
            }
            System.out.println("===========================================");
        }
    }
    
    /**
     * Adds a recipe object in the collection's recipe array list. 
     * @param recipe, an recipe object representing the new recipe to add in the collection.
     */
    public void addRecipe(Recipe recipe){
        listOfRecipes.add(recipe);
    }
    /**
     * Remove a recipe from the collection that matches the given recipe name string. 
     * Prints a message if given string does not match any recipe name in the collection. 
     * @param recipeName, a string representing the recipe name to remove from the collection's 
     * recipe array list. 
     */
    public void deleteRecipe(String recipeName) {
        for (int i = 0; i < listOfRecipes.size(); i++) {
            if (listOfRecipes.get(i).getRecipeName().equals(recipeName)) {
                /*Deleting Recipe from Collection*/
                    System.out.println("\nRecipe (" + listOfRecipes.get(i).getRecipeName() + ") has been deleted");
                    listOfRecipes.remove(i);
            }
            else 
               System.out.println("\nError: No recipe found with " + recipeName + "name"); 
        }
    }
    /**
     * Returns a recipe object that matches the given recipe name string. 
     * Returns a new recipe with Error as its name attribute value if the given
     * string does not matches any of the recipe from the collection. 
     * @param recipeName, a string representing the name of the recipe to return. 
     * @return Recipe
     */   
    public Recipe getRecipe(String recipeName) {
        Recipe tempRecipe = new Recipe();
        int recipeAppearances = 0;
        for (Recipe recipe : listOfRecipes) {
            if (recipe.getRecipeName().equals(recipeName)) {
                /*Getting recipe*/
                tempRecipe = recipe;
                recipeAppearances++;

            }
            else if (recipeAppearances != 1) {
                tempRecipe.setRecipeName("Error");
            }
        }
        return tempRecipe;
    }
    
    /**
     * Returns true if a recipe name in the collections matches a given string
     * and false otherwise. 
     * @param recipeName, a string representing the recipe to lookup in the collection. 
     * @return Boolean
     */
    
    public boolean isRecipeInCollection(String recipeName) {
        /* Verify if given recipe name matches a recipe name in the collection */
        for (Recipe recipe : listOfRecipes) {
            if (recipeName.equals(recipe.getRecipeName())) {
                return true;
            }
        }
        return false;         
    }
    
    /**
     * Returns the recipe index from the collection's array list that matches the given string. 
     * @param recipeName, a string representing the name of the recipe to lookup in 
     * collection the array list. 
     * @return 
     */
    public int getRecipeIndex(String recipeName) {
        int recipeIndex       = 0;
        int recipeAppearances = 0;
        for (Recipe recipe : listOfRecipes) {
            if (recipe.getRecipeName().equals(recipeName)) {
                /*Getting recipe*/
                recipeIndex = listOfRecipes.indexOf(recipe);
                recipeAppearances++;
                break;
            }
            else if (recipeAppearances < 1) {
                recipeIndex =-1;
            }
        }
        return recipeIndex;
    }
    
    /**
     * Add step by step instructions to a given recipe, otherwise display an error.
     * @param recipeName 
     */
    public void addRecipStepbyStepInstructions(String recipeName) {
        if(isRecipeInCollection(recipeName)){
            listOfRecipes.get(getRecipeIndex(recipeName)).addStepByStepInstructions();
        } else {
            System.out.println("\n" + recipeName + " is not in the collection");
        }
    }
    
    /**
     * Add step by step instructions to a given recipe, otherwise display an error.
     * @param recipeName 
     */
    public void printRecipStepbyStepInstructions(String recipeName) {
        if(isRecipeInCollection(recipeName)){
            listOfRecipes.get(getRecipeIndex(recipeName)).printStepByStepRecipeInstructions();
        } else {
            System.out.println("\n" + recipeName + " is not in the collection");
        }
    }
    
    /**
     * Replaces a recipe object in the collection given the index of the recipe to replace and the
     * replacing recipe object.
     * @param index, an integer representing the index of the recipe in the collection array list 
     * to replace. 
     * @param newRecipe, an object that represents the recipe that will replace another recipe
     * in the collection array list at a given index. 
     */
    public void replaceRecipe(int index, Recipe newRecipe) {
        listOfRecipes.set(index, newRecipe);
    }
    
    /**
     * Returns true if given recipe name matches any of the recipe names in the collection.
     * @param recipeName
     * @return a Boolean
     */
    public boolean isRecipeInTheCollection(String recipeName) {
        boolean recipeFound = false;
        
        for (Recipe recipe : listOfRecipes) {
            if (recipeName.equals(recipe.getRecipeName())) {
                recipeFound = true;
                break;
            } //ENDIF   
        } //END ranged-based for loop
        return recipeFound;
    }
    
    /**
     * RecipeBox default constructor with no arguments passed by. 
     */
    public RecipeBox() {
        listOfRecipes = new ArrayList<>();
    }
    /**
     * RecipeBox constructors when an Recipe array list is passed by as the argument. 
     * @param listOfRecipesVal 
     */
    public RecipeBox(ArrayList<Recipe> listOfRecipesVal) {
        listOfRecipes = listOfRecipesVal;
    }
    
}
