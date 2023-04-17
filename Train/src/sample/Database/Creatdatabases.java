package sample.Database;

import sample.Homepage.homeController;

import java.sql.*;

public class Creatdatabases {
    public  String url = "jdbc:mysql://127.0.0.1:3306/highway?serverTimezone=UTC";
    public  String name = "com.mysql.jdbc.Driver";
    public  String user = "root";
    public  String password = "990530";
    public  String dbName="highway";

    public Connection conn = null;
    public PreparedStatement pst = null;
    private homeController hc;

    public Creatdatabases(String url,String name ,String user,String password,String dbName,homeController hc){
        this.url=url;
        this.name=name;
        this.user=user;
        this.password=password;
        this.dbName=dbName;
        this.hc=hc;
        if(!checkdatabase())
        {
            creatbase();
        }else
        {
            System.out.println("数据库已经存在！！！");
            hc.setconsole("数据库正常，已经存在！！！\n");
        }
    }
    private Boolean checkdatabase()
    {
        try {
            String newurl="jdbc:mysql://127.0.0.1/mysql?serverTimezone=UTC";
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(newurl,user,password);//获取连接

            ResultSet resultSet = conn.getMetaData().getCatalogs();

            while(resultSet.next()) {

                String databaseName = resultSet.getString(1);
                if (databaseName.equals(dbName)) {
                    resultSet.close();
                    conn.close();
                    return true;
                }
            }
            resultSet.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
    private void creatbase()
    {
        try {
            String newurl="jdbc:mysql://127.0.0.1/mysql?serverTimezone=UTC";
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(newurl,user,password);//获取连接
            Statement stat = conn.createStatement();

            //创建数据库hello
            stat.executeUpdate("create database highway");
            hc.setconsole("创建出数据库成功\n");
            //打开创建的数据库
            stat.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("数据库出错了");
            hc.setconsole("数据库出错了！！！\n");
            e.printStackTrace();
        }
    }
}
