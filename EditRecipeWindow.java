package guitest;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 * This class create a windows with its components to prompt the user to enter the name of the recipe to edit.
 * @author Eric Lara
 */
public class EditRecipeWindow extends JFrame implements ActionListener {

    /* GUI label and fields */
    private JLabel recipeNameLabel;                             // Recipe's name label
    private JTextField recipeNameField;                         // Recipe's name field
    private JButton editRecipeButton;                           // Button that creates a new windows to edit a recipe from user input

    /* Default constructor that creates GUI components and add GUI components 
       using a GridBagLayout */
    public EditRecipeWindow(RecipeBox collection) {

        //Used to specify GUI component layout
        GridBagConstraints layoutConst = null;
        JScrollPane scrollPane = null;                          // Container that adds a scroll bar
        
        //Set frame's title
        setTitle("Edit a Recipe");
        //setSize(550,500);

        /* Setting labels */
        recipeNameLabel = new JLabel("Name of the recipe");

        /* Setting Fields */
        recipeNameField = new JTextField(15);                   // Creating a new field of 15 columns width
        recipeNameField.setEditable(true);                      // Allow user to edit it
        recipeNameField.setText("");
        recipeNameField.addActionListener(this);

        // Use a GridBagLayout
        setLayout(new GridBagLayout());
        
        /* Setting up grid layout for recipeNameLabel */
        layoutConst = new GridBagConstraints();
        layoutConst.anchor = GridBagConstraints.LINE_END;       // Aligns the label text at the end of the line
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(10, 10, 10, 10);        //Setting up the padding for the label grid layout

        /* Adding the recipeNameLabel to the top frame */
        add(recipeNameLabel, layoutConst);

        /* Setting up grid layout for recipeNameField */
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(10, 10, 10, 10);

        /* Adding the recipeNameField to the top frame */
        add(recipeNameField, layoutConst);


        //Creating button to create new recipe
        editRecipeButton = new JButton("Edit Recipe");

        //Creating button to print 
        editRecipeButton.addActionListener(new ActionListener() {

            /* Display Recipe details on the Text Area */
            @Override
            public void actionPerformed(ActionEvent e) {
 
                String recipeName = "";
                // Gets the recipe name from the recipeName text field
                recipeName = recipeNameField.getText();

                //Verifying if the given recipe is in the collection
                if (collection.isRecipeInCollection(recipeName)) {
                    //Creating a new windows to edit the recipe 
                    ModifyRecipeWindow myFrame = new ModifyRecipeWindow(collection, recipeName);
        
                    /* Window Settings */
                    myFrame.pack();                            //Resizing app windows components
                    myFrame.setVisible(true);                  //Display window
                    //FIXME
                } else {
                    //DISPLAY ERROR FEEDBACK TO USER
                    JOptionPane.showMessageDialog(editRecipeButton, "Recipe " + recipeName + " is not in the collection");
                }
            }

        });

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 10);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 8;

        add(editRecipeButton, layoutConst);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //EMPTY 
    }

}
