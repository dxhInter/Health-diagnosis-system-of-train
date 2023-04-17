package sample.errappear;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Errform extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("err_form.fxml"));
        primaryStage.setTitle("故障出现");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

    }
}
