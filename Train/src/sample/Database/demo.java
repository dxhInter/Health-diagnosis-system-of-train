package sample.Database;


import java.sql.ResultSet;
import java.io.*;
import sample.Database.InitDB;
import sample.Homepage.homeController;
import sample.Database.DBOperate;
import sample.Database.DB_SQL;
public class demo {

    static String sql = null;
    static InitDB db1 = null;
    static ResultSet ret = null;

    public static void main(String[] args) {
       // InitDB db=new InitDB();
        //db.creatdatabases();
//        DBOperate db1=new DBOperate();
//        db1.creat(DB_SQL.Table_student);
//        db1.creat(DB_SQL.Table_errinformation);
//        db1.creat(DB_SQL.Table_normaldata);
//        db1.close();
//        DBOperate db2=new DBOperate();
//        db2.add("insert into errinformation values(1,2,1, 2,1, 2,1, 2,1, 2,1, 2,1, 2,1, 2,1, 2,1, 2,1, 2,1, 2,1)");
//       // db2.add("insert into errinformation values(1, 2,1, 2,1, 2,1, 2,1, 2,1, 2,1, 2,1, 2,1, 2,1, 2,1, 2,1, 2,1)");
//        //db2.add("insert into errinformation (rule_version,time_ms) values(1, 2)");
//        db2.close();
    }
}