package sample;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("samples.fxml"));
        primaryStage.setTitle("Web View Sample");
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load("la.html");

        Scene scene = new Scene(webView, 850, 550, Color.web("lightgray"));
        primaryStage.setScene(scene);

        webEngine.getLoadWorker().stateProperty().addListener((ObservableValue<? extends State> ov, State oldState, State newState) -> {

            if (newState == State.SUCCEEDED) {
//				StringBuilder js = new StringBuilder();
//				js.append("loadChartData(");
//				js.append(jsBean);
//				js.append(");");
//				System.out.println(js.toString());
//				webEngine.executeScript(js.toString());


            }
        });
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
