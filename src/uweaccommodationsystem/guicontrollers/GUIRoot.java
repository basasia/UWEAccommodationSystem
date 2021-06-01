/*
 Class: GUIRoot.
 Description: The launching point for this application. Launches the login window.
 Created: 30/01/2020 (Benyadilok).
 Updated: 05/02/2020 (Tonkin).
 Authors: Asia Benyadilok, Michael Tonkin.
 */
package uweaccommodationsystem.guicontrollers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GUIRoot extends Application {

    /*
    Method: start
    Description: creates the gui.
    Parameters: Stage stage - used by JavaFX, please ignore.
    */
    @Override
    public void start(Stage stage) throws Exception {
        // to insert image
        AnchorPane pane = new AnchorPane();
        ImageView image = new ImageView(new Image("/image/UWE_Login.jpg"));
        pane.getChildren().add(image);
        Parent root = FXMLLoader.load(getClass().getResource("fxml/FXMLLoginView.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("University of the West of England Bristol Accommodation");
        stage.getIcons().add(new Image("/image/uwe_logo.jpg"));
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
