package sample.Database;

import sample.Homepage.homeController;

import java.sql.*;

public class InitDB {
    public static final String url = "jdbc:mysql://localhost:3306/highway?serverTimezone=UTC";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "990530";
    public static final  String dbName="highway";

    public Connection conn = null;
    public PreparedStatement pst = null;
    private homeController hc;

    public InitDB(homeController hc) {
        this.hc =hc;
    }
    public void dropdatabases()
    {
        try {
            String newurl="jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC";
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(newurl,user,password);//获取连接
            Statement stat = conn.createStatement();

            //创建数据库hello
            stat.executeUpdate("drop database highway");
            //打开创建的数据库
            stat.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("数据库出错了");
            hc.setconsole("drop数据库出错了!!!\n");
            e.printStackTrace();
        }
    }

    public void creatdatabases(){
        Creatdatabases db=new Creatdatabases(url,name,user,password,dbName,hc);
    }

}
