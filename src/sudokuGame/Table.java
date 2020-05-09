package sudokuGame;

import java.util.ArrayList;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Table{
	
	
	//Array list will contain the references to the Objects stored within the SudokuTable.
	private ArrayList<TextField> table = new ArrayList<TextField>();
	private GridPane tableContainer = new GridPane();
	
	
	//Constructors
	public Table() {
		createTable();
	}
	
	//Creates TextField and puts them inside the grid.
	//Stores TestField references inside ArrayList "table"
	public void createTable() {
		// TODO Auto-generated method stub
		for(int r = 0; r < 9; r++) {
			for(int c = 0; c < 9; c++) {
				TextField areaOfInput = new TextField();
				areaOfInput.setPrefWidth(30.0);
				
				tableContainer.add(areaOfInput, c, r);			//Inputs TextFields inside grid
				this.table.add(areaOfInput);			//Saves references
			}
		}		
	}
	
	
	public void solveSudoku() {
		// TODO Auto-generated method stub
		
	}
	
	public void updateBox(int index, String value) {
		// TODO Auto-generated method stub
		table.get(index).setText(value);
	}
	
	//Setters and Getters
	
	//Grid Pane Getter
	public GridPane getGridContainer() {
		return tableContainer;
	}
}
