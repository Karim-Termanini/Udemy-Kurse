package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;


public class Main extends Application {
	Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
	@Override
	public void start(Stage primaryStage) throws IOException {
		try {
			
			HBox root = new HBox();
			root.setPrefSize(340.0, 70.0);
			root.setSpacing(10);
			root.setAlignment(Pos.CENTER);

            
            Button button1 = new Button();
            Button button2 = new Button();
            Button button3 = new Button();
            Button button4 = new Button();
            Button button5 = new Button();
            
            //----Button Hinzufügen----
            root.getChildren().add(button1);
            root.getChildren().add(button2);
            root.getChildren().add(button3);
            root.getChildren().add(button4);
            root.getChildren().add(button5);
            
            button1.setPrefSize(64.0, 64.0);
            button2.setPrefSize(64.0, 64.0);
            button3.setPrefSize(64.0, 64.0);
            button4.setPrefSize(64.0, 64.0);
            button5.setPrefSize(64.0, 64.0);
            
            //----Button mit CSS verbinden----
            button1.getStyleClass().add("button1");
            button2.getStyleClass().add("button2");
            button3.getStyleClass().add("button3");
            button4.getStyleClass().add("button4");
            button5.getStyleClass().add("button5");
            
            
            
            //----Amazon---
            button1.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					getHostServices().showDocument("https://www.amazon.com/");
					
				}
			});
            
          //----facebook---
            button2.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					getHostServices().showDocument("https://www.facebook.com/");
					
				}
			});
            
          //----twitter---
            button3.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					getHostServices().showDocument("https://www.twitter.com/");
					
				}
			});
            
          //----youtube---
            button4.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					getHostServices().showDocument("https://www.youtube.com/");
					
				}
			});
            
            
          //----Exit---
            button5.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					System.exit(0);
					
				}
			});
            
			Scene scene = new Scene(root);
			scene.setFill(Color.TRANSPARENT);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setX((screenSize.getWidth() / 2) - 220);
			primaryStage.setY(10.0);
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.setTitle("KWedgit");
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
