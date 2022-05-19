
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
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 * This class create a windows with its components to edit a recipe from user input.
 * @author Eric Lara
 */
public class ModifyRecipeWindow extends JFrame implements ActionListener {
    
    /* GUI label and fields */
    private JLabel recipeNameLabel;                             // Recipe's name label
    private JLabel servingsLabel;                               // Recipe's servings label
    private JLabel totalRecipeCaloriesLabel;                    // Recipe's total calories label
    private JTextField recipeNameField;                         // Recipe's name field
    private JTextField servingsField;                           // Recipe's servings field
    private JTextField totalRecipeCaloriesField;                // Recipe's total calories field
    private JButton updateRecipeButton;                         // Triggers the method that update a recipe data
    private JButton editIngredientsButton;                      // Triggers ingredient's table row adjuster
    private ArrayList<Ingredient> ingredientList;

    public ArrayList<Ingredient> getIngredientList() {
        return ingredientList;
    }
    
    public void setIngredientList(ArrayList<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
    
    /* Default constructor that creates GUI components and add GUI components 
       using a GridBagLayout */
    public ModifyRecipeWindow(RecipeBox collection, String recipeName) {
        
        // Used to specify GUI component layout
        GridBagConstraints layoutConst = null;
        JScrollPane scrollPane = null;                         // Container that adds a scroll bar
        int i = 0;   
        Recipe tempRecipe = collection.getRecipe(recipeName);
        
        //Copying the ingredient list from the given recipe to display it in the addIngredients table
        ingredientList = tempRecipe.getRecipeIngredients();                                              
        
        /* Set the frame's title */
        setTitle("Edit a Recipe");
        //setSize(550,500);
        
        /* Setting labels */
        recipeNameLabel = new JLabel("Name of the recipe");
        servingsLabel = new JLabel("Servings");
        totalRecipeCaloriesLabel = new JLabel("Total recipe calories");      
        
        /* Setting Fields */
        recipeNameField = new JTextField(15);                                   // Creating a new field of 15 columns width
        recipeNameField.setEditable(true);                                      // Allow user to edit it
        recipeNameField.setText(tempRecipe.getRecipeName());                    // Populating recipe name field with given recipe data
        
        servingsField = new JTextField(15);                                     // Creating a new field of 15 columns width
        servingsField.setEditable(true);                     
        servingsField.setText(Integer.toString(tempRecipe.getServings()));      // Populating servings field with given recipe data
        
        totalRecipeCaloriesField = new JTextField(15);                          // Creating a new field of 15 columns width
        totalRecipeCaloriesField.setEditable(true);                     
        totalRecipeCaloriesField.setText(Double.toString(tempRecipe.getTotalRecipeCalories()));
        

        // Use a GridBagLayout
        setLayout(new GridBagLayout());
        
        /* Setting up grid layout for recipeNameLabel */
        layoutConst = new GridBagConstraints();
        layoutConst.anchor = GridBagConstraints.LINE_END;
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(10, 10, 10, 10);                        //Setting up the padding for the label grid layout
        
        /* Adding the wageLabel to the top frame */
        add(recipeNameLabel, layoutConst);
        
        /* Setting up grid layout for recipeNameField */
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(10, 10, 10, 10);    
        
        /* Adding the wageField to the top frame */
        add(recipeNameField, layoutConst);
        
        /* Setting up grid layout for servingsLabel */
        layoutConst = new GridBagConstraints();
        layoutConst.anchor = GridBagConstraints.LINE_END;
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(10, 10, 10, 10); 
        
        /* Adding the salaryLabel to the top frame */
        add(servingsLabel, layoutConst);
        
        /* Setting up grid layout for servingsField */
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(10, 10, 10, 10); 
        
        /* Adding the servingsField to the top frame */
        add(servingsField, layoutConst);
        
        /* Setting up grid layout for totalRecipeCaloriesLabel */
        layoutConst = new GridBagConstraints();
        layoutConst.anchor = GridBagConstraints.LINE_END;
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        layoutConst.insets = new Insets(10, 10, 10, 10); 
        
        /* Adding the totalRecipeCaloriesLabel to the top frame */
        add(totalRecipeCaloriesLabel, layoutConst);
        
        /* Setting up grid layout for totalRecipeCaloriesField */
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 2;
        layoutConst.insets = new Insets(10, 10, 10, 10); 
        
        /* Adds the totalRecipeCaloriesLabel to the top frame */
        add(totalRecipeCaloriesField, layoutConst);


        // Creates and adds button to the window
        editIngredientsButton = new JButton(new AbstractAction("Edit Ingredients"){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame("Edit Ingredients");
                f.getContentPane()
                 .add(new AddIngredientListWindow(ingredientList).getComponent());
                //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
                f.setSize(650,350);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 5, 10, 10);
        layoutConst.fill = GridBagConstraints.BOTH;
        layoutConst.gridheight = 1;
        layoutConst.gridx = 3;
        layoutConst.gridy = 1;
        
        add(editIngredientsButton, layoutConst);
        
        // Creating button to create new recipe
        updateRecipeButton = new JButton("Update Recipe");
        
        // This code is called when the create Recipe button is clicked.
        updateRecipeButton.addActionListener(new ActionListener(){
            
            /* Display Recipe details on the Text Area */
            @Override
            public void actionPerformed(ActionEvent e) {    

                String recipeName                               = "";
                int servings                                    = 0;
                int recipeIndex;
                double totalRecipeCalories                      = 0;
                ArrayList<Ingredient> recipeIngredients;
                
                // Display Error Message if any of the fields is empty
                if (recipeNameField.getText().equals("") || servingsField.getText().equals("") 
                        || totalRecipeCaloriesField.getText().equals("")) {
                    JOptionPane.showMessageDialog(updateRecipeButton,"Please do not leave any of fields empty");
                    return;
                }
                
                // Display Error if ingredient name or unit of measurement is not an alphabetic character
                else if (!recipeNameField.getText().matches("[A-Za-z ]*")) {
                    JOptionPane.showMessageDialog(updateRecipeButton,"The Recipe name must contains alphabetic character only");
                    return;
                }
                // Display Error if ingredient name or unit of measurement is not a number
                else if (!servingsField.getText().matches("[0-9]*") || !totalRecipeCaloriesField.getText().matches("[0-9]*")) {
                    JOptionPane.showMessageDialog(updateRecipeButton,"Servings and the total recipe calories must contains numbers only");
                    return;
                }
                // Display Error Message
                else if (Float.parseFloat(servingsField.getText()) < 0 || Integer.parseInt(totalRecipeCaloriesField.getText()) < 0) {
                    JOptionPane.showMessageDialog(updateRecipeButton,"Please do not use negative value");
                    return;
                }

                // Get recipe name from user
                recipeName = recipeNameField.getText();
                
                // Get the recipe index from the recipe box collection
                recipeIndex = collection.getRecipeIndex(tempRecipe.getRecipeName());

                // Get ingredientList from user input
                recipeIngredients = getIngredientList();

                // Get servings from user
                servings = Integer.parseInt(servingsField.getText());

                // Get total recipe calories from user
                totalRecipeCalories = Double.parseDouble(totalRecipeCaloriesField.getText());

                //CREATE A NEW RECIPE OBJECT FROM USER INPUT USING OVERLOADED CONSTRUCTOR
                Recipe newRecipe = new Recipe(recipeName, servings, recipeIngredients, totalRecipeCalories);

                // RECIPE OBJECT to the Collection
                collection.replaceRecipe(recipeIndex, newRecipe);

                // DISPLAY SUCCESS FEEDBACK TO USER
                JOptionPane.showMessageDialog(updateRecipeButton,"Recipe " + newRecipe.getRecipeName() + " has been updated");

            }

        });
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 10);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 8;
        
        add(updateRecipeButton, layoutConst);    
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //
    }
    
}

