package fremig.chessfx;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class ChessFX extends Application {

	  private Stage primaryStage;
	  private AnchorPane rootLayout;
	  
	  @Override
	  public void start(Stage primaryStage) {
	      this.primaryStage = primaryStage;
	      this.primaryStage.setTitle("ChessFX");
	      
	      try {
	          // Load the root layout from the fxml file
	          FXMLLoader loader = new FXMLLoader(ChessFX.class.getResource("ChessFX.fxml"));
	          rootLayout = (AnchorPane) loader.load();
	          Scene scene = new Scene(rootLayout);
	          primaryStage.setScene(scene);
	          primaryStage.show();
	      } catch (IOException e) {
	          // Exception gets thrown if the fxml file could not be loaded
	          e.printStackTrace();
	      }
	}

	public static void main(String[] args) {
		launch(args);
	}
}
