package sudokuGame;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class SolverScreen{

	//Defining attributes
	Stage primaryStage;			//Reference to the original primary stage
	FunctionalityControls fControls;
	
	//Constructor
	public SolverScreen(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.fControls = new FunctionalityControls(primaryStage);
	}

	
	public Scene getScene() {
		
		//Configure primaryStage property
		this.primaryStage.resizableProperty().setValue(false);
		
		//Root Element
		BorderPane root = new BorderPane();
		
		//Adding nodes to the root element
		root.setTop(buildTitle());
		root.setCenter(buildBody());
		root.setBottom(buildBottom());
		
		//Scene declaration and adding root along with config
		Scene scene = new Scene(root, 400, 500);
		
		return scene;
	}

	
	private HBox buildTitle() {
		//Container and configurations
		HBox titleBox = new HBox();
		HBox.setHgrow(titleBox, Priority.NEVER);
		titleBox.setAlignment(Pos.CENTER);
		titleBox.setPadding(new Insets(15,0,15,0));
        titleBox.setSpacing(15);

		//Title Text and configurations
		Text title = new Text("Sudoku Solver");
		title.setTextAlignment(TextAlignment.JUSTIFY);
		title.setFill(Color.ALICEBLUE);
		
		//Add nodes to container
		titleBox.getChildren().add(title);
		
		//Return Container
		return titleBox;
	}


	private HBox buildBody() {
		//Create Container
		HBox bodyContainer = new HBox();
		HBox.setHgrow(bodyContainer, Priority.ALWAYS);
		bodyContainer.setAlignment(Pos.CENTER);
		
		//Grid Pane and configurations
		//GridPane will serve as the table for the sudoku
		GridPane table = new GridPane();
		table.setHgap(8);
		table.setVgap(10);
		table.setPadding(new Insets(10,10,10,10));
		
		//Populating GridPane with TextFields
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				TextField cell = fControls.createTextField();
//				cell.setPrefWidth(30);
				
//				TextField textField = controller.createTextField();
//				gameFunctions.formatTextField(textField);
//				gameFunctions.addBoardField(j - 1, i - 1, textField);
//				gameFunctions.formatBoard(i, j, textField);
				
                table.addRow(i, cell);				
			}
		}
		
		//Insert nodes into bodyContainer
		bodyContainer.getChildren().add(table);
		
		return bodyContainer;
	}
	
	private HBox buildBottom() {
		
		//Main container and configuration
		HBox controlButton = new HBox();
		HBox.setHgrow(controlButton, Priority.ALWAYS);
		controlButton.setPadding(new Insets(15,0,15,0));
		controlButton.setSpacing(10);
		controlButton.setAlignment(Pos.CENTER);
		
		//Creating button
		Button solve = new Button();
		solve.setText("Solve");
//		solve.setOnAction((e) -> gameFunctions.solveSudoku());
		
		controlButton.getChildren().add(solve);
			
		return controlButton;
	}
}

