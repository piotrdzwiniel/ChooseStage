package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Demo extends Application {
	
	public Parent createContent() {
		
		/* layout */
		BorderPane layout = new BorderPane();
		
		/* layout -> center */
		Button button = new Button("Open ChooseStage");
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				int option = 0;
				ChooseStage chooseStage = new ChooseStage(new String[] {"Yes", "No"}, 
						"Question", "Are you sure you want to close this Demo?", 
						350, 100);
				chooseStage.showAndWait();
				option = chooseStage.getOption();
				
				if (option == 1) {
					System.exit(-1);
				}
			}
		});
		
		/* return layout */
		layout.setCenter(button);
		return layout;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(createContent()));
		stage.setWidth(200);
		stage.setHeight(200);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
