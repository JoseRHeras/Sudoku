package sudokuGame;

import Solver_Methods.Solver;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
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
        textField.setPadding(new Insets(5.5, 15, 5, 5));
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
				System.out.println("Value Added");		//For testing purposes. Delete when completed
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
		if(validateTextFieldArray()) {
			
			//Create an int array which will contain data to be passed to "Solve" class
			int[][] sudokuGake = new int[9][9];
			
			//Convert data within TextField array to integers
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
						
					String originalValue = board[i][j].getText().trim();
					int convertedValue;
					
					
					if(originalValue.matches("[1-9]")) {
						convertedValue = Integer.parseInt(board[i][j].getText().trim());
					}
					else {
						convertedValue = 0;
					}
					
					sudokuGake[i][j] = convertedValue;
				}
			}
			
//			printTable(sudokuGake);
			Solver solver = new Solver(sudokuGake);
			solver.solveIt();
			
//			printTable(sudokuGake);
			
			//Update the User BoardView
			if(solver.hasSolution()) {
				for (int i = 0; i < sudokuGake.length; i++) {
					for (int j = 0; j < sudokuGake[i].length; j++) {
						this.board[i][j].setText(sudokuGake[i][j] + "");
					}
				}
			}
			else {
				//Alert the user for non-solvable sudoku
			}		
		}
		else {
			//Alert the user for non-valid table
			System.out.println("Table is not completed");
		}
	}
	
	//Helper method which validates data stored within the TextField array
	private boolean validateTextFieldArray() {
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(!(board[i][j].getText().matches("[1-9]"))) {
					if(!(board[i][j].getText().equals("")))
						return false;
				}
			}
		}
		return true;
	}
}















