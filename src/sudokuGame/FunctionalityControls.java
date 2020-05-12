package sudokuGame;

import Solver_Methods.Solver;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FunctionalityControls {
	
	final Stage primaryStage;
	private TextField[][] board = new TextField[9][9];
	
	public FunctionalityControls(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	
	/*
	 Functions when invoked creates a TextField object which is then configured and formated
	 and then returned to the user. 
	 */
	public TextField createTextField() {
		TextField textField = new TextField();
		configureTextField(textField);
		configureConstraints(textField, 1);
		return textField;
	}
	
	/*
	 Helper functions which is invoked by createTextField functions. It sets the formatting of 
	 the textField
	 */
	private void configureTextField(TextField textField) {
		textField.setPrefHeight(30);
		
//		textField.setMaxSize(25, 10);
        textField.setMinWidth(30);
        textField.setAlignment(Pos.CENTER);
        textField.setPadding(new Insets(5, 15, 5, 5));
        textField.setFont(Font.font("Arial",FontWeight.BOLD,15));
	}
	
	
	/*
	 Helper method used by createTextField method. Implements a listener to the passed object.
	 This is meant to apply restrictions to what type of data the object can contain. 
	 */
	private void configureConstraints(TextField textField, int maxSize) {
		textField.textProperty().addListener((ov, oldValue, newValue) -> {
			//Gets the inputed value for validation
			if(textField.getText().length() > maxSize ) {
				String newTextValue = textField.getText().substring(0, maxSize);
//				System.out.println("Value Added");		//For testing purposes. Delete when completed
				textField.setText(newTextValue);
			}
			
			//Updates TextField if inputed value is not numeric
			if(!textField.getText().matches("[1-9]")) {
				textField.setText("");
			}			
		});		
	}
	
	
	/*
	 Functions allows the user to insert an TextField object into the "board" attribute
	 stored within this class. 
	 */
	public void addToBoard(int row, int col, TextField textField) {
		this.board[row][col] = textField;
	}

	//Utility functions used for debbugging purposes.
//	public void printTable(int[][] board) {
//		
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[i].length; j++) {
//				System.out.print(board[i][j] + " ");
//			}		
//			System.out.println();
//		}
//	}
//	
	
	public void solveSudoku() {
		
		//Validate data within the TextField array
//		if(validateTextFieldArray()) {
			
			//Create an int array which will contain data to be passed to "Solve" class
			int[][] sudokuGake = new int[9][9];
			int numberOfValidInputs = 0;					//A valid number is a value grater than 0. To continue the table needs at least one value
			
			String msg, msgTitle;
			
			//Convert data within TextField array to integers
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
						
					String originalValue = board[i][j].getText().trim();
					int convertedValue;
					
					
					if(originalValue.matches("[1-9]")) {
						convertedValue = Integer.parseInt(board[i][j].getText().trim());
						numberOfValidInputs++;
					}
					else {
						convertedValue = 0;
					}
					
					sudokuGake[i][j] = convertedValue;
				}
			}
			
			
			if(numberOfValidInputs > 0) {
				Solver solver = new Solver(sudokuGake);
				solver.solveIt();
				
				
				//Update the User BoardView
				if(solver.hasSolution()) {
					for (int i = 0; i < sudokuGake.length; i++) {
						for (int j = 0; j < sudokuGake[i].length; j++) {
							this.board[i][j].setText(sudokuGake[i][j] + "");
						}
					}
				}
				else {
					msg = "Game has no solution!!";
					msgTitle = "No Solution";
					errorMessage(msg, msgTitle);
				}
			}
			else {
				msg = "Table must have at least one value";
				msgTitle = "Empty Label";
				errorMessage(msg, msgTitle);
			}
//		}
//		else {
//			//Alert the user for non-valid table
//			System.out.println("Table is not completed");
//		}
	}
	
//	//Helper method which validates data stored within the TextField array
//	private boolean validateTextFieldArray() {
//		
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[i].length; j++) {
//				if(!(board[i][j].getText().matches("[1-9]"))) {
//					if(!(board[i][j].getText().equals("")))
//						return false;
//				}
//			}
//		}
//		return true;
//	}
	
	//Deletes all stored values in the board
	public void clearBoard() {
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j].setText("");
			}
		}
	}
	
	/*
	 Function used to display pop windows with error messages.
	 Takes two parameters as input and formats the pop to match the corresponding inputs.
	 */
	private void errorMessage(String errorMessage, String title) {
		//Stage creation and configuration
		Stage emptyTableDisplay = new Stage();		
		emptyTableDisplay.initModality(Modality.APPLICATION_MODAL);
		emptyTableDisplay.setTitle(title);
		
		//Label creation and configuration
		Label message = new Label();
		message.setText(errorMessage);
		message.setStyle("-fx-color: red;");
		
		//Create and configure Closing Button
		Button closeButton = new Button();
		closeButton.setText("Ok");
		closeButton.setOnAction(e -> emptyTableDisplay.close());
		closeButton.setStyle("-fx-background-color: red; -fx-text-fill: white; ");
		
		
		//Layout
		VBox layout = new VBox();
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(message, closeButton);
		layout.setPadding(new Insets(5, 5, 5, 5));
		layout.setSpacing(8);
		layout.setStyle("-fx-background-color: #FFF0E9;");
		
		//Create Scene and display stage
		Scene warningScene = new Scene(layout, 250,50);
		
		emptyTableDisplay.setScene(warningScene);
		emptyTableDisplay.showAndWait();				
	}
}















