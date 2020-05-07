package sudokuGame;

public class Solver {

	private int[][] sTable;
	private boolean hasSolution;
	
	
	public Solver(int[][] game) 
	{
		sTable = game;
		hasSolution = false;
	}
	
	//Caller method 
	public void solveIt()
	{
		hasSolution = backtrackingSudoku(sTable);		
	}
	
	//Using backtracking fills up the table
	private boolean backtrackingSudoku(int[][] table) 
	{
		
		//Declare variables
		int col = -1, row = -1 , size = table.length;
		boolean empty = true;
		
		//Find next block
		for(int i = 0; i < size; i++) 
		{
			for(int j = 0; j < size; j++) 
			{
				if(table[i][j] == 0) 
				{			//Find and saves variables if empyt spot is found
					col = j;
					row = i;
					empty = false;
					break;
				}				
			}
			if(!empty)
			{		//Breaks outer loop if empty spot is found
				break;
			}
		}
		
		if(empty) 
		{
			return true;
		}
		
		//Assign a number to block and use backtracking to fill up the rest of the table
		for(int i = 1; i <= size; i++) 
		{
			
			if(isSafe(row, col, i, table)) 
			{	//Check if number to be assigned is safe to be used
				table[row][col] = i;			//Assign number
				
				if(backtrackingSudoku(table)) 
				{
					return true;
				}
				else {
					table[row][col] = 0;		//If value is not promising go back to 0
				}				
			}
		}	
		return false;	
	}
	
	//Helper method which determines if value is safe
	//Method checks for three conditions.Wether there are no repeated numbers in the row
	//Whether there are no repeated number in the column
	//Whether there are no repeated number in the rows
	//Whether there are no repeated numbers in the corresponding box
	//If none of the previous is true then it returns true otherwise it returns false
	private boolean isSafe(int row, int col, int value, int[][] table) {
		
		
		//Check for integer == value in the row and columns
		//Returns false if true
		for(int i = 0; i < 9; i++) 
		{
			if(table[row][i] == value ) 
			{
				return false;
			}
			
			if(table[i][col] == value) 
			{
				return false;
			}
		}
		
		
		//Check corresponding box for integer == value
		//Returns false if true
	    int sqrt = 3; 							//Square size of each cube
	    int rowStart = row - row % sqrt; 		//Calculates the starting row
	    int colStart = col - col % sqrt; 		//Calculates the starting column
	  
	    for (int r = rowStart; r < rowStart + sqrt; r++) 
	    { 
	        for (int c = colStart; c < colStart + sqrt; c++) 
	        { 
	            if (table[r][c] == value)
	            { 
	                return false; 
	            } 
	        } 
	    }
	    
	    //If none of the conditions was true then return true
		return true;
	}
	
	public void printTable() {
		
		for(int i = 0; i < 9; i++) 
		{
			for(int r = 0; r < 9; r++) 
			{
				System.out.print(sTable[i][r] + " ");
			}
			System.out.println();
		}
		
	}	
}
