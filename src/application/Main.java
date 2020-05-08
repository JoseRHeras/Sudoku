package application;
	
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
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			GridPane root = new GridPane();
			
			TextField text1 = new TextField("0");
			TextField text2 = new TextField("0");
			text1.setPrefWidth(30.0);
			text2.setPrefWidth(30.0);
			
			root.add(text1, 0, 0);
			root.add(text2, 1, 0);
			
			
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


}
