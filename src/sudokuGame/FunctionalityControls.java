package sudokuGame;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FunctionalityControls {
	final Stage primaryStage;
	private TextField[][] cells = new TextField[9][9];
	
	public FunctionalityControls(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	/*
	 * Implement functionsf:
	 * Create TextFields objects with constraits(value lenght = 1 and 1 <= N <=9).
	 * Functionality that solves the puzzle and displays the answer
	 * 
	 */
	
	public TextField createTextField() {
		TextField textField = new TextField();
		configureTextField(textField);
		configureConstraints(textField, 1);
		return textField;
	}
	
	private void configureTextField(TextField textField) {
		textField.setPrefHeight(30);
		
//		textField.setMaxSize(25, 10);
        textField.setMinWidth(30);
        textField.setAlignment(Pos.CENTER);
        textField.setPadding(new Insets(5.5, 15, 5, 5));
	}
	
	
	/*Configures passed TextField Object so it will contain a listener
	 *TextFild length can't be greater than 1 */
	private void configureConstraints(TextField textField, int maxSize) {
		textField.textProperty().addListener((ov, oldValue, newValue) -> {
			//Gets the inputed value for validation
			if(textField.getText().length() > maxSize ) {
				String newTextValue = textField.getText().substring(0, maxSize);
				System.out.println("Value Added");		//For testing purposes. Delete when completed
				textField.setText(newTextValue);
			}
			
			//Updates TextField if inputed value is not numeric
			if(!textField.getText().matches("[1-9]")) {
				textField.setText("");
			}			
		});		
	}

	
	
	
	
}
