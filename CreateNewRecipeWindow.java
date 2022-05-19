
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

/**
 * This class create a windows with its components to create a recipe from user input.
 * @author Eric Lara
 */
public class CreateNewRecipeWindow extends JFrame implements ActionListener {
    
    /* GUI label and fields */
    private JLabel recipeNameLabel;                             //Recipe's name label
    private JLabel servingsLabel;                               //Recipe's servings label
    private JLabel totalRecipeCaloriesLabel;                    //Recipe's total calories label
    private JTextField recipeNameField;                         //Recipe's name field
    private JTextField servingsField;                           //Recipe's servings field
    private JTextField totalRecipeCaloriesField;                //Recipe's total calories field
    private JButton createRecipeButton;                         // Triggers recipe creation
    private JButton addIngredientsButton;                       // Triggers ingredient's table row adjuster
    private ArrayList<Ingredient> ingredientList;
 
    public ArrayList<Ingredient> getIngredientList() {
        return ingredientList;
    }
    
    public void setIngredientList(ArrayList<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
    
    /* Default constructor that creates GUI components and add GUI components 
       using a GridBagLayout */
    public CreateNewRecipeWindow(RecipeBox collection) {
        
        //Used to specify GUI component layout
        GridBagConstraints layoutConst = null;
        ingredientList = new ArrayList<>();                                     //  
        
        //Set frame's title
        setTitle("Add a Recipe");
        //setSize(550,500);
        
        /* Setting labels */
        recipeNameLabel = new JLabel("Name of the recipe");
        servingsLabel = new JLabel("Servings");
        totalRecipeCaloriesLabel = new JLabel("Total recipe calories");      
        
        /* Setting Fields */
        recipeNameField = new JTextField(15);                                   // Creating a new field of 15 columns width
        recipeNameField.setEditable(true);                                      // Allow user to edit it
        recipeNameField.setText("");
        
        servingsField = new JTextField(15);                                     //Creating a new field of 15 columns width
        servingsField.setEditable(true);                     
        servingsField.setText("");
        
        totalRecipeCaloriesField = new JTextField(15);                          //Creating a new field of 15 columns width
        totalRecipeCaloriesField.setEditable(true);                     
        totalRecipeCaloriesField.setText("");
        

        // Use a GridBagLayout
        setLayout(new GridBagLayout());
        
        /* Setting up grid layout for recipeNameLabel */
        layoutConst = new GridBagConstraints();
        layoutConst.anchor = GridBagConstraints.LINE_END;
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(10, 10, 10, 10);    //Setting up the padding for the label grid layout
        
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
        
        /* Adding the totalRecipeCaloriesLabel to the top frame */
        add(totalRecipeCaloriesField, layoutConst);


        // Creating and adding button
        addIngredientsButton = new JButton(new AbstractAction("Add Ingredients"){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame("Adding Ingredients");
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
        
        add(addIngredientsButton, layoutConst);
        
        // Creates button to create new recipe
        createRecipeButton = new JButton("Create Recipe");
        
        // This code is called when the create Recipe button is clicked.
        createRecipeButton.addActionListener(new ActionListener(){
            
            /* Display Recipe details on the Text Area */
            @Override
            public void actionPerformed(ActionEvent e) {    

                String recipeName                               = "";
                int servings                                    = 0;
                double totalRecipeCalories                      = 0;
                ArrayList<Ingredient> recipeIngredients;
                
                // Display Error Message if any of the fields is empty
                if (recipeNameField.getText().equals("") || servingsField.getText().equals("") 
                        || totalRecipeCaloriesField.getText().equals("")) {
                    JOptionPane.showMessageDialog(createRecipeButton,"Please do not leave any of fields empty");
                    return;
                }
                
                // Display Error if ingredient name or unit of measurement is not an alphabetic character
                else if (!recipeNameField.getText().matches("[A-Za-z ]*")) {
                    JOptionPane.showMessageDialog(createRecipeButton,"The Recipe name must contains alphabetic character only");
                    return;
                }
                // Display Error if ingredient name or unit of measurement is not a number
                else if (!servingsField.getText().matches("[0-9]*") || !totalRecipeCaloriesField.getText().matches("[0-9]*")) {
                    JOptionPane.showMessageDialog(createRecipeButton,"Servings and the total recipe calories must contains numbers only");
                    return;
                }
                // Display Error Message
                else if (Float.parseFloat(servingsField.getText()) < 0 || Integer.parseInt(totalRecipeCaloriesField.getText()) < 0) {
                    JOptionPane.showMessageDialog(createRecipeButton,"Please do not use negative value");
                    return;
                }

                // Get recipe name from text field
                recipeName = recipeNameField.getText();

                // Get ingredientList from user input
                recipeIngredients = getIngredientList();

                // Get servings from text field
                servings = Integer.parseInt(servingsField.getText());

                // Get total recipe calories from text field
                totalRecipeCalories = Double.parseDouble(totalRecipeCaloriesField.getText());

                // CREATE A NEW RECIPE OBJECT FROM USER INPUT USING OVERLOADED CONSTRUCTOR
                Recipe newRecipe = new Recipe(recipeName, servings, recipeIngredients, totalRecipeCalories);

                //Verifies if the recipe name is already in the collection
                if (!collection.isRecipeInTheCollection(newRecipe.getRecipeName())) {
                    // ADD RECIPE OBJECT to the Collection
                    collection.addRecipe(newRecipe);
                    // DISPLAY SUCCESS FEEDBACK TO USER
                    JOptionPane.showMessageDialog(createRecipeButton,newRecipe.getRecipeName() + " recipe has been created");

                } else {
                    // DISPLAY ERROR FEEDBACK TO USER
                    JOptionPane.showMessageDialog(createRecipeButton,newRecipe.getRecipeName() + " is already in the collection");
                }
                

                
            }

        });
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 10);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 8;
        
        add(createRecipeButton, layoutConst);    
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //
    }
    
}

