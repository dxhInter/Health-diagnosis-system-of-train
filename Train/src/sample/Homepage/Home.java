package sample.Homepage;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.Database.DBOperate;
import sample.Database.DB_SQL;
import sample.Database.InitDB;
import sample.Homepage.homeController;
import java.awt.*;
import java.util.ArrayList;

public class Home extends Application {
    public static int width;
    public static int height;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("home1.fxml"));
        stage.setTitle("铁路干线重载货运机车在线智能故障诊断装置");
        Dimension screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
         width = (int)screensize.getWidth();
         height = (int)screensize.getHeight();
        stage.setScene(new Scene(root, width, height));
        stage.setResizable(true);//窗体缩放（默认为true）
        stage.getIcons().add(new Image("/sample/resources/housess.png"));
        stage.setMaximized(true);
        stage.show();
//        homeController hm=new homeController();
//        hm.addNum_db();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.print("监听到窗口关闭");
                System.exit(0);
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}
