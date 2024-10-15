package org.example.bmi_calculator;

import javafx.application.Platform; // Importing Platform class for application control
import javafx.fxml.FXML; // Importing FXML for UI components
import javafx.scene.control.*; // Importing control classes for GUI components

/**
 * HelloController class handles the user interactions and calculations for the BMI Calculator application.
 */
public class HelloController {

    @FXML
    private Menu FileMenu; // Menu for file operations

    /**
     * Closes the application when the 'Exit' option is selected.
     */
    @FXML
    private void Close() {
        Platform.exit(); // Exit the JavaFX application
    }

    /**
     * Clears all input fields and result labels for both Metric and English units.
     */
    @FXML
    private void ClearMenu() {
        // Clear the text fields for Metric and English units
        WeightInput1.clear();
        HeightInput1.clear();
        WeightInput2.clear();
        HeightInput2.clear();

        // Optionally clear the results
        ResultText1.setText("Result:");
        ResultText2.setText("Result:");
    }

    @FXML
    private Label BMICalculatorText; // Label for application title
    @FXML
    private Label MetricUnitsText; // Label for Metric units description
    @FXML
    private Label WeightText1; // Label for weight input prompt in Metric
    @FXML
    private Label HeightText1; // Label for height input prompt in Metric
    @FXML
    private TextField WeightInput1; // TextField for Metric weight input
    @FXML
    private TextField HeightInput1; // TextField for Metric height input
    @FXML
    private Label ResultText1; // Label to display BMI result for Metric

    /**
     * Calculates BMI using Metric units (kilograms and centimeters) when the user clicks the Go button.
     */
    @FXML
    private void GoButton1() {
        int weight = Integer.parseInt(WeightInput1.getText());  // Weight in kg
        int heightCm = Integer.parseInt(HeightInput1.getText());  // Height in cm

        // Convert height from cm to meters
        double heightMeters = heightCm / 100.0;

        // Calculate BMI: weight / (height in meters)^2
        double bmi = weight / Math.pow(heightMeters, 2);

        String category; // Variable to hold BMI category
        // Determine the BMI category based on the calculated BMI value
        if (bmi < 18.5) {
            category = "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            category = "Normal";
        } else if (bmi >= 25 && bmi < 30) {
            category = "Overweight";
        } else {
            category = "Obese";
        }

        // Display the result formatted to two decimal places along with the category
        ResultText1.setText(String.format("Result: %.2f - %s", bmi, category));
    }

    @FXML
    private Label EnglishUnitsText; // Label for English units description
    @FXML
    private Label WeightText2; // Label for weight input prompt in English
    @FXML
    private Label HeightText2; // Label for height input prompt in English
    @FXML
    private TextField WeightInput2; // TextField for English weight input
    @FXML
    private TextField HeightInput2; // TextField for English height input
    @FXML
    private Label ResultText2; // Label to display BMI result for English

    /**
     * Calculates BMI using English units (pounds and inches) when the user clicks the Go button.
     */
    @FXML
    private void GoButton2() {
        // Get the weight and height from the text fields
        int weightLbs2 = Integer.parseInt(WeightInput2.getText());  // Weight in pounds
        int heightInches2 = Integer.parseInt(HeightInput2.getText());  // Height in inches

        // Calculate BMI using the formula for pounds and inches
        double bmi2 = (weightLbs2 / Math.pow(heightInches2, 2)) * 703;

        // Display the result formatted to two decimal places
        ResultText2.setText("Result: " + String.format("%.2f", bmi2));

        String category2; // Variable to hold BMI category for English units
        // Determine the BMI category based on the calculated BMI value
        if (bmi2 < 18.5) {
            category2 = "Underweight";
        } else if (bmi2 >= 18.5 && bmi2 < 25) {
            category2 = "Normal";
        } else if (bmi2 >= 25 && bmi2 < 30) {
            category2 = "Overweight";
        } else {
            category2 = "Obese";
        }
        // Display the result formatted to two decimal places along with the category
        ResultText2.setText(String.format("Result: %.2f - %s", bmi2, category2));
    }

    /**
     * Displays a help dialog with instructions on how to use the BMI Calculator.
     */
    @FXML
    private void HelpMenu() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION); // Create an alert of type INFORMATION
        alert.setTitle("Help"); // Set the title of the alert
        alert.setHeaderText("BMI Calculator Help"); // Set header text for the alert
        alert.setContentText("Enter your weight in kilograms and your height in centimeters in the Metric Units or the same measurement in pounds and inches in the English Units.\n \n" +
                "Click 'Go' to see your BMI.\n" +
                "Use 'Clear' to reset the fields.\n" +
                "Click 'Exit' to exit the application."); // Set content text with usage instructions
        alert.showAndWait(); // Show the alert and wait for user confirmation
    }
}
