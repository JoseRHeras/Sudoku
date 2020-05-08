package application;
	
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	
	ArrayList<TextField> gridInput = new ArrayList();
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			
			GridPane root = new GridPane();
			
			addInputsToGrid(root);
			
			gridInput.get(16).setText("9");
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	//Inserts TextInputs objects into grid
	//Saves references to objects to a ArrayList
	public void addInputsToGrid(GridPane grid)
	{		
		for(int r = 0; r < 9; r++){
			for(int c = 0; c < 9; c++) {
				TextField areaOfInput = new TextField();
				areaOfInput.setPrefWidth(30.0);
				
				grid.add(areaOfInput, c, r);				
				gridInput.add(areaOfInput);
			}
		}
	}

}
