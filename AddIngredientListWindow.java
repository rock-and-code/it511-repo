package guitest;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

/**
 * This class create a windows with its components that prompts user to create a list of ingredients.
 * @author Eric Lara
 */

public class AddIngredientListWindow 
{  
    // TextField labels
    private JLabel ingredientNameLabel, unitMeasurementLabel, amountLabel, caloriesPerUnitLabel;
    // TextField
    private JTextField ingredientName, unitMeasurement, amount, caloriesPerUnit;
    // ArrayList
  
    // JTable Header 
    public static final String[] columns = {
        "Ingredient Name", "Unit of measurement", "Amount", "Calories per Unit"
    };
    // Create the table model
    private DefaultTableModel model = new DefaultTableModel(columns, 0);
    // Create the JTable
    private JTable table = new JTable(model);
    // Create the main panel
    private JPanel mainPanel = new JPanel(new BorderLayout());
    

    public AddIngredientListWindow(ArrayList<Ingredient> ingredientList) 
    {
        // Add button
        JButton addButton = new JButton("+ Add");
        // Clear button
        JButton clearButton = new JButton("Clear");
        // Clear button
        JButton createIngredientList = new JButton("Add Ingredient List");
        // Clear button
        JButton clearIngredientListButton = new JButton("Clear list");
        // Button panel
        JPanel buttonPanel = new JPanel();
        // Add buttons to panel
        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(createIngredientList);
        buttonPanel.add(clearIngredientListButton);
        
        // Populate table if the given recipe ingredient's array is not empty
        if (!ingredientList.isEmpty()) {
            for (Ingredient ingredient: ingredientList) {
                // Add ingredient data to the table
                model.addRow(
                     new Object[]{
                           ingredient.getIngredientName(), 
                           ingredient.getUnitMeasurement(),
                           ingredient.getIngredientAmount(),
                           ingredient.getNumOfCaloriesPerUnit()
                     }
                );
            }
        }
    
        // This code is called when the Add button is clicked.
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display Error Message if any of the fields is empty
                if (ingredientName.getText().equals("") || unitMeasurement.getText().equals("") 
                        || amount.getText().equals("") || caloriesPerUnit.getText().equals("")) {
                    JOptionPane.showMessageDialog(addButton,"Please do not leave any of fields empty");
                    return;
                }
                
                // Display Error if ingredient name or unit of measurement is not an alphabetic character
                else if (!ingredientName.getText().matches("[A-Za-z ]*") || !unitMeasurement.getText().matches("\\p{IsAlphabetic}*")) {
                    JOptionPane.showMessageDialog(addButton,"Ingredient name and unit of measurment must start with an alphabetic character");
                    return;
                }
                // Display Error if ingredient name or unit of measurement is not a number
                else if (!amount.getText().matches("[0-9]*") || !caloriesPerUnit.getText().matches("[0-9]*")) {
                    JOptionPane.showMessageDialog(addButton,"Amount and calories per unit must be a numerical value");
                    return;
                }
                // Display Error Message
                else if (Float.parseFloat(amount.getText()) < 0 || Integer.parseInt(caloriesPerUnit.getText()) < 0) {
                    JOptionPane.showMessageDialog(addButton,"Please do not use negative value");
                    return;
                }

                // Add data to the table
                model.addRow(
                     new Object[]{
                           ingredientName.getText(), 
                           unitMeasurement.getText(),
                           Float.parseFloat(amount.getText()),
                           Integer.parseInt(caloriesPerUnit.getText())
                     }
                );
            }
        });
    
        // This code is called when the Clear button is clicked.
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //Clear the form
              ingredientName.setText("");
              unitMeasurement.setText("");
              amount.setText("");
              caloriesPerUnit.setText("");
            }
        });
        
        // This code is called when the add Ingredient button is clicked.
        createIngredientList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // clear ingredientList 
                ingredientList.clear();
                
                int i;
                int numIngredients = model.getRowCount();

                // Returns Ingredient List
                for (i = 0; i < numIngredients; ++i) {
                    /* extracting values from table */
                    String ingredientName = model.getValueAt(i, 0).toString();
                    String unitMeasurement = model.getValueAt(i, 1).toString();
                    float amount = Float.parseFloat(model.getValueAt(i, 2).toString());
                    int caloriesPerUnit = Integer.parseInt(model.getValueAt(i, 3).toString());

                    /* creating a new ingredient object */
                    Ingredient newIngredient = new Ingredient(ingredientName, unitMeasurement, amount, caloriesPerUnit);

                    /* Adding ingredient to the array list */
                    ingredientList.add(newIngredient);

                }
                JOptionPane.showMessageDialog(createIngredientList,"The ingredient list has been added");
            }
        });
        
        // This code is called when the Clear ingredient list button is clicked.
        clearIngredientListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear the form
                // Loop to remove all the rows
                while (model.getRowCount() > 0) {
                    // while loop since every time the loop removes a row, the model vector decreases its length
                    model.removeRow(0);
                    
                }
            }
        });
    
        // Create the JTextFields panel
        JPanel textPanel = new JPanel(new GridBagLayout());
        GridBagConstraints layoutConst1 = new GridBagConstraints();
        GridBagConstraints layoutConst2 = new GridBagConstraints();
        GridBagConstraints layoutConst3 = new GridBagConstraints();
        GridBagConstraints layoutConst4 = new GridBagConstraints();
        GridBagConstraints layoutConst5 = new GridBagConstraints();
        GridBagConstraints layoutConst6 = new GridBagConstraints();
        GridBagConstraints layoutConst7 = new GridBagConstraints();
        GridBagConstraints layoutConst8 = new GridBagConstraints();
        
        // Creating Labels
        ingredientNameLabel = new JLabel("Ingredient Name");
        unitMeasurementLabel = new JLabel("Unit of measurement");
        amountLabel = new JLabel("Amount");
        caloriesPerUnitLabel = new JLabel("Calories per Unit");
        
        // Creating Text Fields
        ingredientName = new JTextField(15);
        unitMeasurement = new JTextField(15);
        amount = new JTextField(15);
        caloriesPerUnit = new JTextField(15);
        
        // layoutConst for ingredientNameLabel
        layoutConst1.gridx = 0;
        layoutConst1.gridy = 0;
        layoutConst1.anchor = GridBagConstraints.LINE_END;
        layoutConst1.insets = new Insets(0,5,0,5);
        
        // layoutConst for ingredientName
        layoutConst2.gridx = 1;
        layoutConst2.gridy = 0;
        layoutConst2.insets = new Insets(0,5,0,5);
        
        // layoutConst for unitMeasurementLabel
        layoutConst3.gridx = 0;
        layoutConst3.gridy = 1;
        layoutConst3.anchor = GridBagConstraints.LINE_END;
        layoutConst3.insets = new Insets(0,5,0,5);
        
        // layoutConst for unitMeasurement
        layoutConst4.gridx = 1;
        layoutConst4.gridy = 1;
        layoutConst4.insets = new Insets(0,5,0,5);
        // layoutConst for amountLabel
        layoutConst5.gridx = 0;
        layoutConst5.gridy = 2;
        layoutConst5.anchor = GridBagConstraints.LINE_END;
        layoutConst5.insets = new Insets(0,5,0,5);
        
        // layoutConst for amount
        layoutConst6.gridx = 1;
        layoutConst6.gridy = 2;
        layoutConst6.insets = new Insets(0,5,0,5);
        
        // layoutConst for caloriesPerUnitLabel
        layoutConst7.gridx = 0;
        layoutConst7.gridy = 3;
        layoutConst7.anchor = GridBagConstraints.LINE_END;
        layoutConst7.insets = new Insets(0,5,0,5);
        
        // layoutConst for totalCaloraiesPerUnit
        layoutConst8.gridx = 1;
        layoutConst8.gridy = 3;
        layoutConst8.insets = new Insets(0,5,0,5);
        
        // Add JTextFields to the panel
        textPanel.add(ingredientNameLabel, layoutConst1);
        textPanel.add(ingredientName, layoutConst2);
        textPanel.add(unitMeasurementLabel, layoutConst3);
        textPanel.add(unitMeasurement, layoutConst4);
        textPanel.add(amountLabel, layoutConst5);
        textPanel.add(amount, layoutConst6);
        textPanel.add(caloriesPerUnitLabel, layoutConst7);
        textPanel.add(caloriesPerUnit, layoutConst8);
  
        // Add panels and table to the main panel
        mainPanel.add(textPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    // Get the main panel
    public JComponent getComponent() {
        return mainPanel;
    }

    // start the application in thread-safe
//    public static void main(String[] args) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                JFrame f = new JFrame("Adding Ingredients");
//                f.getContentPane()
//                 .add(new DynamicTable().getComponent());
//                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                f.setSize(650,350);
//                f.setLocationRelativeTo(null);
//                f.setVisible(true);
//            }
//        });
//    }
}