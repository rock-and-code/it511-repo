package guitest;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
 * This class create a windows with its components to print the recipe names from the collection.
 * @author Eric Lara
 */
public class PrintRecipeNamesInCollectionWindow extends JFrame implements ActionListener {

    /* GUI label and fields */
    private JButton printRecipeNamesInCollectionButton;                         // Triggers recipe creation
    private JLabel textAreaLabel;
    private JTextArea recipeNamesArea;                                          // Displays recipe details

    /* Default constructor that creates GUI components and add GUI components 
       using a GridBagLayout */
    public PrintRecipeNamesInCollectionWindow(RecipeBox collection) {

        // Used to specify GUI component layout
        GridBagConstraints layoutConst = null;
        JScrollPane scrollPane = null;                                          // Container that adds a scroll bar

        
        // Set frame's title
        setTitle("Printing the Recipe Names in the Collection");
        //setSize(550,500);

        /* Setting labels */
        textAreaLabel = new JLabel("Recipe Names in Collection:");


        // Add recipeDetails output area and add it to scroll pane
        recipeNamesArea = new JTextArea(10, 15);
        scrollPane = new JScrollPane(recipeNamesArea);
        recipeNamesArea.setEditable(false);

        // Use a GridBagLayout
        setLayout(new GridBagLayout());
        

        //Adding text area label 
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 1, 10);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 6;
        add(textAreaLabel, layoutConst);
        
        //Adding text area 
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(1, 10, 10, 10);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 7;
        layoutConst.gridwidth = 4; // 3 cells wide
        add(scrollPane, layoutConst);

        // Creating button to create new recipe
        printRecipeNamesInCollectionButton = new JButton("Print Recipe Names");

        // Creating button to print 
        printRecipeNamesInCollectionButton.addActionListener(new ActionListener() {

            /* Display Recipe details on the Text Area */
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clears content    
                recipeNamesArea.selectAll();                                          //Select the content in the text area
                recipeNamesArea.replaceSelection("");                                 //Replace all the content      

                String recipeName = "";


                // Verifies if the given recipe is in the collection
                if (!collection.getListOfRecipes().isEmpty()) {

                    // Getting the Recipe Array list
                    ArrayList<Recipe> recipeCollection = collection.getListOfRecipes();
                    
                    // Range-based for loop to append the recipe names in the text areas
                    int indexCounter = 1;
                    
                    recipeNamesArea.append("=======Recipes in the collection========\n");  // Header
                    for (Recipe recipe : recipeCollection) {
                        // Appends the recipe name to the TextField     
                        recipeNamesArea.append(indexCounter + ": " + recipe.getRecipeName() + "\n");
                        ++indexCounter;
                    }
                    //recipeNamesArea.append("============================");               // Footer

                } else {    // If 

                    // DISPLAY ERROR FEEDBACK TO USER
                    JOptionPane.showMessageDialog(printRecipeNamesInCollectionButton, "The recipe collection is currenty empty");
                }
            }

        });

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 10);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 8;

        add(printRecipeNamesInCollectionButton, layoutConst);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       //

    }
}
