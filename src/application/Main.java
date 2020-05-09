package application;
	
import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;
import sudokuGame.Table;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;


public class Main extends Application {
	
	ArrayList<TextField> gridInput = new ArrayList<TextField>();
	@Override
	public void start(Stage primaryStage) {
		try {
			
			BorderPane root = new BorderPane();
			
			Table sudokuTable = new Table();
			
			Text gameTitle = new Text("This is Sudoku beta!!");
			
			
			//Adding nodes to the Border Pane
			root.setCenter(sudokuTable.getGridContainer());
			root.setTop(gameTitle);
			
			sudokuTable.updateBox(1,"9");
			
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
