package guitest;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * A class that extends the JFrame class and to create a modular GUI
 *
 * @author Eric Lara
 */
public class PrintRecipeDetailsWindow extends JFrame implements ActionListener {

    /* GUI label and fields */
    private JLabel recipeNameLabel;                             //Recipe's name label
    private JTextField recipeNameField;                         //Recipe's name field
    private JButton printRecipeDetails;                         // Triggers recipe creation
    private JLabel recipeDetailsLabel;
    private JTextArea recipeDetailsArea;                        // Displays recipe details
    private RecipeBox collectionCopy;
    
    public RecipeBox getCollectionCopy() {
        return collectionCopy;
    }
    
    public void setCollectionCopy(RecipeBox collection) {
        this.collectionCopy = collection;
    }

    /* Default constructor that creates GUI components and add GUI components 
       using a GridBagLayout */
    public PrintRecipeDetailsWindow(RecipeBox collection) {

        //Used to specify GUI component layout
        GridBagConstraints layoutConst = null;
        JScrollPane scrollPane = null;                                          // Container that adds a scroll bar
        setCollectionCopy(collection);
        
        //Set frame's title
        setTitle("Print the Recipe Details");
        //setSize(550,500);

        /* Setting labels */
        recipeNameLabel = new JLabel("Name of the recipe");
        recipeDetailsLabel = new JLabel("Recipe Details:");

        /* Setting Fields */
        recipeNameField = new JTextField(15);                                   //Creating a new field of 15 columns width
        recipeNameField.setEditable(true);                                      //Allow user to edit it
        recipeNameField.setText("");
        recipeNameField.addActionListener(this);

        //Add recipeDetails output area and add it to scroll pane
        recipeDetailsArea = new JTextArea(10, 15);
        scrollPane = new JScrollPane(recipeDetailsArea);
        recipeDetailsArea.setEditable(false);

        // Use a GridBagLayout
        setLayout(new GridBagLayout());
        

        /* Setting up grid layout for recipeNameLabel */
        layoutConst = new GridBagConstraints();
        layoutConst.anchor = GridBagConstraints.LINE_END;
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(10, 10, 10, 10);    //Setting up the padding for the label grid layout

        /* Adding the recipeNameLabel to the top frame */
        add(recipeNameLabel, layoutConst);

        /* Setting up grid layout for recipeNameField */
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(10, 10, 10, 10);

        /* Adding the recipeNameField to the top frame */
        add(recipeNameField, layoutConst);

        //Adding text area and label 
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 1, 10);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 6;
        add(recipeDetailsLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(1, 10, 10, 10);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 7;
        layoutConst.gridwidth = 4; // 3 cells wide
        add(scrollPane, layoutConst);

        //Creating button to create new recipe
        printRecipeDetails = new JButton("Print Recipe Details");

        //Creating button to print 
        printRecipeDetails.addActionListener(new ActionListener() {

            /* Display Recipe details on the Text Area */
            @Override
            public void actionPerformed(ActionEvent e) {
                //Clears content    
                recipeDetailsArea.selectAll();                                          //Select the content in the text area
                recipeDetailsArea.replaceSelection("");                                 //Replace all the content      

                String recipeName = "";
                int i;
                //Getting hourly wage from user
                recipeName = recipeNameField.getText();

                //Verifying if the given recipe is in the collection
                if (collection.isRecipeInCollection(recipeName)) {

                    //Getting the recipe 
                    Recipe tempRecipe = collection.getRecipe(recipeName);

                    ArrayList<Ingredient> recipeIngredients = tempRecipe.getRecipeIngredients();

                    //Display recipe by appending component to TextField
                    recipeDetailsArea.append("Recipe name: " + recipeName + "\n");
                    recipeDetailsArea.append("Serves: " + tempRecipe.getServings() + "\n");
                    recipeDetailsArea.append("===================Ingredients=====================\n");
                    for (Ingredient ingredient : recipeIngredients) {
                        if (recipeIngredients.isEmpty()) {
                            recipeDetailsArea.append("There is not ingredients for this recipe");
                        } else {
                            /* displaying ingredient amount */
                            recipeDetailsArea.append(Double.toString(ingredient.getIngredientAmount()) + " ");

                            /* Checking if the ingredient amount is greater than 1 to display unit of measurement on plural form otherwise on singular form. */
                            if (ingredient.getIngredientAmount() > 1) {
                                /* displaying the ingredient's unit of measurement */
                                recipeDetailsArea.append(ingredient.getUnitMeasurement() + "s of ");
                            } else {
                                recipeDetailsArea.append(ingredient.getUnitMeasurement() + " of ");
                            }
                            recipeDetailsArea.append(ingredient.getIngredientName() + "\n");
                        }
                    }
                    recipeDetailsArea.append("===============================================\n");
                    recipeDetailsArea.append("Total calories per serving: " + Math.round(tempRecipe.getTotalRecipeCalories() / tempRecipe.getServings()) + "\n" + "\n");

                } else {

                    //DISPLAY A FEEDBACK TO USER
                    JOptionPane.showMessageDialog(printRecipeDetails, "Recipe " + recipeName + " is not in the collection");
                }
            }

        });

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 10);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 8;

        add(printRecipeDetails, layoutConst);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /* Display Recipe details on the Text Area */

        //Clears content    
        recipeDetailsArea.selectAll();                                          //Select the content in the text area
        recipeDetailsArea.replaceSelection("");                                 //Replace all the content      

        String recipeName = "";
        RecipeBox tempCollection = getCollectionCopy();
        int i;
        //Getting hourly wage from user
        recipeName = recipeNameField.getText();

        //Verifying if the given recipe is in the collection
        if (tempCollection.isRecipeInCollection(recipeName)) {

            //Getting the recipe 
            Recipe tempRecipe = tempCollection.getRecipe(recipeName);

            ArrayList<Ingredient> recipeIngredients = tempRecipe.getRecipeIngredients();

            //Display recipe by appending component to TextField
            recipeDetailsArea.append("Recipe name: " + recipeName + "\n");
            recipeDetailsArea.append("Serves: " + tempRecipe.getServings() + "\n");
            recipeDetailsArea.append("===================Ingredients=====================\n");
            for (Ingredient ingredient : recipeIngredients) {
                if (recipeIngredients.isEmpty()) {
                    recipeDetailsArea.append("There is not ingredients for this recipe");
                } else {
                    /* displaying ingredient amount */
                    recipeDetailsArea.append(Double.toString(ingredient.getIngredientAmount()) + " ");

                    /* Checking if the ingredient amount is greater than 1 to display unit of measurement on plural form otherwise on singular form. */
                    if (ingredient.getIngredientAmount() > 1) {
                        /* displaying the ingredient's unit of measurement */
                        recipeDetailsArea.append(ingredient.getUnitMeasurement() + "s of ");
                    } else {
                        recipeDetailsArea.append(ingredient.getUnitMeasurement() + " of ");
                    }
                    recipeDetailsArea.append(ingredient.getIngredientName() + "\n");
                }
            }
            recipeDetailsArea.append("===============================================\n");
            recipeDetailsArea.append("Total calories per serving: " + Math.round(tempRecipe.getTotalRecipeCalories() / tempRecipe.getServings()) + "\n" + "\n");

        } else {

            //DISPLAY A FEEDBACK TO USER
            JOptionPane.showMessageDialog(printRecipeDetails, "Recipe " + recipeName + " is not in the collection");
        }

    }
}
