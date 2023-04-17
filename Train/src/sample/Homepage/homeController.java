package sample.Homepage;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.AxisLine;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.SplitLine;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.code.Y;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.style.LineStyle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.PopupFeatures;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Callback;
import netscape.javascript.JSObject;
import sample.Database.DBOperate;
import sample.Database.DB_SQL;
import sample.Database.InitDB;
import sample.FileFounction.ForFile;
import sample.FileFounction.ReadInfoForRtio;
import sample.MessageOpen.CheckModulear;
import sample.MessageOpen.Ratio;
import sample.MessageOpen.UnitNodeObject;
import sample.UdpService.UdpClient;
import sample.UdpService.UdpService;
import sample.echartpackage.AccessData;
import sample.echartpackage.Option_Ratio;
import sample.echartpackage.myLineChart;
import sample.echartpackage.myLineChartReaTime;
import sample.errappear.Errform;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import sample.FileFounction.StringChange;
import javafx.scene.control.TextArea;

import javax.naming.Context;

public class homeController implements Initializable {
    @FXML
    AnchorPane anchorpane;
    @FXML
    WebView webviewforechart;
    @FXML
    Label label_id, label_1;
    @FXML
    public TextArea test_console;
    private UdpService service;
    private int textareSize = 0;
    myLineChart ml;
    myLineChartReaTime mlrt;
    ChangeListener<Worker.State> lk = null;
    long l, pagenum;
    int temp_table_number;
    private Ratio ratio;
    private CheckModulear cm;
    private Option_Ratio option_ratio;
    //是否打开实时显控开关。1-是  0-否
    public static int always_switch=0;
    public static int op=0;
    public static int[] datatable=new int[5];
    private static String path = "D:\\logForUdp\\datatable.txt";
    private StringChange str_change=new StringChange();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //anchorpane.prefWidthProperty().bind();

        //初始化操作
        test_console.setText("Hello,this is console!\n");
        cm=new CheckModulear();
        option_ratio=new Option_Ratio();
//        init_db();
        temp_table_number=str_change.judegTable();
        ratio=new Ratio();
        int a=decideTable();
        try {
            ReadInfoForRtio.readFile02();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //ip端口固定
        //本机测试
        // openUdpService("localhost",5);
        //单元车A
        //openUdpService("169.254.231.220", 5);
        //单元车B

       // openUdpService("169.254.231.221",6);
        openUdpService("localhost",5);
        load_webviewbackground();
        //addNum_db();
    }

    public void init_db() {
        InitDB db = new InitDB(this);
        db.creatdatabases();
        DBOperate db1 = new DBOperate(this);
        db1.creat(DB_SQL.Table_student);
        db1.creat(DB_SQL.Table_errinformation);
        db1.creat(DB_SQL.Table_normaldata);
        db1.creat(DB_SQL.Table_normaldata2);
        db1.creat(DB_SQL.Table_normaldata3);
        db1.creat(DB_SQL.Table_normaldata4);
        db1.creat(DB_SQL.Table_normaldata5);
//        db1.creatProcedure(DB_SQL.create_procedure2);
        //db1.close();
    }
    public void init_arr() throws IOException {
        datatable [0]=1;
        datatable [1]=2;
        datatable [2]=3;
        datatable [3]=4;
        datatable [4]=5;
        ForFile ff=new ForFile();
        String a=datatable[0]+"";
        ff.inputTXT(path,a);
        String b=datatable[1]+"";
        ff.inputTXT(path,b);
        String c=datatable[2]+"";
        ff.inputTXT(path,c);
        String d=datatable[3]+"";
        ff.inputTXT(path,d);
        String e=datatable[4]+"";
        ff.inputTXT(path,e);
    }

    public int decideTable(){
        int a=temp_table_number;
        return a;
    }

    public void btn_home_action(ActionEvent actionEvent) {
    }

    public void btn_help_action(ActionEvent actionEvent) {
    }

    public long getpasgenum() {
        DBOperate db2 = new DBOperate(this);
        try {
            //总number
            l = db2.getCountOfBase(DB_SQL.normal_rows);
            pagenum = l / CheckModulear.num_data_every;
            if (l % CheckModulear.num_data_every > 0) {
                pagenum += 1;
            }
//            ResultSet ret = db2.query("SELECT " + CheckModulear.time_data + "," + CheckModulear.A1_analog1 + " FROM normaldata limit " + "0" + "," + CheckModulear.num_data_every);
//            List<AccessData> list = new ArrayList<AccessData>();
//            while (ret.next()) {
//                list.add(new AccessData(ret.getString("time"), Double.parseDouble(ret.getString("A1_analog1"))));
//            }
            ml = new myLineChart();
           // ret.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pagenum;
    }
    public void load_webviewbackground(){
        always_switch=3;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                WebEngine webEngine = webviewforechart.getEngine();
                if (lk != null) {
                    webEngine.getLoadWorker().stateProperty().removeListener(lk);
                }
                webEngine.getLoadWorker().stateProperty().addListener(lk =new ChangeListener<Worker.State>() {
                    @Override
                    public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                        if (Worker.State.SUCCEEDED == newValue) {
                            System.out.println("background加载完成。。。。");
                        }
                    }
                });
                webEngine.load(this.getClass().getResource("/sample/echartpackage/background.html").toExternalForm());
                label_id.setText(this.getClass().getResource("../echartpackage/background.html").toString());
            }
        });
//        String imgs="";
//        File f = new File("E:\\logForUdp\\homephotonew.png");
//        imgs = "<img src=\""+f+"\" width='50' />";
//        System.out.println(imgs);
//        WebEngine webEngine = webviewforechart.getEngine();
//        webEngine.loadContent("<div id='content'>"+imgs+"</div>");


    }
    public void btn_echatview_Action(ActionEvent actionEvent) {
        always_switch=0;
//        getpasgenum();
        pagenum=str_change.getpasgenum();
        ml = new myLineChart();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                WebEngine webEngine = webviewforechart.getEngine();
                if (lk != null) {
                    webEngine.getLoadWorker().stateProperty().removeListener(lk);
                }
                webEngine.getLoadWorker().stateProperty().addListener(lk = new ChangeListener<Worker.State>() {
                    @Override
                    public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                        if (Worker.State.SUCCEEDED == newValue) {
                            JSObject window = (JSObject) webEngine.executeScript("window");
                            window.setMember("myLine", ml);
                            window.setMember("totalPage", pagenum);
                            // 在web引擎页面中设置一个名为“javaConnector”的接口对象
                            System.out.println("1加载完成。。。。");
                            window.eval("sendToJava()");
                            // 获取Javascript连接器对象。
                            //JSObject javascriptConnector = (JSObject) webEngine.executeScript("getmyLineConnector()");
                        }
                    }
                });
                webEngine.load(this.getClass().getResource("/sample/echartpackage/la.html").toExternalForm());
                label_id.setText(this.getClass().getResource("../echartpackage/la.html").toString());
            }
        });
    }

    public void btn_echat_dataNow_Action(ActionEvent actionEvent) {
        always_switch=1;
        mlrt = new myLineChartReaTime();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("here");
                WebEngine webEngine = webviewforechart.getEngine();
                if (lk != null) {
                    webEngine.getLoadWorker().stateProperty().removeListener(lk);
                }
                //webEngine.setJavaScriptEnabled(true);
                webEngine.getLoadWorker().stateProperty().addListener(lk = new ChangeListener<Worker.State>() {
                    @Override
                    public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                        if (Worker.State.SUCCEEDED == newValue) {
                            // JSObject window = (JSObject) webEngine.executeScript("window");
                            // 在web引擎页面中设置一个名为“javaConnector”的接口对象
                            JSObject window = (JSObject) webEngine.executeScript("window");
                            window.setMember("mlrt", mlrt);
                            // 在web引擎页面中设置一个名为“javaConnector”的接口对象
                            System.out.println("1加载完成。。。。");
                            window.setMember("totalPage", 5);
                            window.setMember("num_data_every", CheckModulear.num_data_every);
                            window.eval("sendToJava()");
                            // 获取Javascript连接器对象。
                            //JSObject javascriptConnector = (JSObject) webEngine.executeScript("getmyLineConnector()");
                        }
                    }
                });
                try {
                    webEngine.load(this.getClass().getResource("/sample/echartpackage/slide.html").toExternalForm());
                    label_id.setText(this.getClass().getResource("/sample/echartpackage/slide.html").toString());
                }catch (Exception e)
                {
                    setconsole(e.toString());
                }
            }
        });
    }

    public void adddataEchart(String time, UnitNodeObject un){

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //更新JavaFX组件的代码
                WebEngine webEngine = webviewforechart.getEngine();
                JSObject window = (JSObject) webEngine.executeScript("window");
                window.setMember("time_st", time);
                window.setMember("unnode", un);
                window.eval("randomData()");
            }
        });
    }
    public void btn_err_chack_action(ActionEvent actionEvent) {
        Platform.runLater(() -> {
            //创建主界面窗口
            try {
                new Errform().start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void setTextareSize(int textareSize) {
        this.textareSize = textareSize;
    }

    public void getTextaresize() {
        if (textareSize > 1000) {
            test_console.clear();
            textareSize = 0;
        }
    }

    public void btn_server_action(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SetUDP_form.fxml"));
        Parent parent = loader.load();
        udphelper target = loader.getController();
        target.hc = this;
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();

    }

    public void openUdpService(String ip, int port) {
        UdpService service = new UdpService(this, ip, port);
        service.startsrever();
        setconsole("设置的ip和端口号为：" + ip + ":" + port + "\n");
        service.start();
    }

    public void btn_client_action(ActionEvent actionEvent) {
    }

    public void btn_con_Action(ActionEvent actionEvent) throws SQLException {
        DBOperate db2 = new DBOperate(this);
        //db2.dffff();
        db2.add("insert into errinformation (rule_version,time_ms) values(?, ?)");
        System.out.println(db2.getCountOfBase(DB_SQL.normal_rows1));
        db2.close();
    }

    public void insert() {
        DBOperate db2 = new DBOperate(this);
        db2.add("insert into errinformation (rule_version,time_ms) values(?, ?)");

    }

    public void setconsole(String str) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ForFile.createFile("test_log_console", str);
                System.out.println(textareSize);
                getTextaresize();
                setTextareSize(textareSize + 1);
                test_console.appendText(str);
            }
        });
    }

    public void btn_delete(ActionEvent actionEvent) {
        test_console.appendText("删除log文件?????\n");
        ForFile.deletelog("test_log");
        test_console.appendText("删除test_log文件\n");
        ForFile.deletelog("test_log_console");
        test_console.appendText("删除test_log_console文件\n");
        DBOperate db1 = new DBOperate(this);
        db1.drop(DB_SQL.drop_nomal);
        db1.creat(DB_SQL.Table_normaldata);
        db1.close();
        test_console.appendText("删除log文件成功！！！\n");
    }

    public static int getAlways_switch() {
        return always_switch;
    }

    public static void setAlways_switch(int always_switch) {
        homeController.always_switch = always_switch;
    }

    public void btn_fristpage_Action(ActionEvent actionEvent) {
        load_webviewbackground();
    }
}
