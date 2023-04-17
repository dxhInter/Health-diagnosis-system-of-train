package sample.Database;

import sample.Homepage.homeController;
import sample.MessageOpen.CheckModulear;
import sample.MessageOpen.HeadInfo;
import sample.MessageOpen.ParseMessage;
import sample.MessageOpen.UnitNodeObject;
import sample.FileFounction.ForFile;
import java.sql.*;
import java.util.Date;
import sample.FileFounction.StringChange;

public class DBOperate {
    public static final String DBURL = "jdbc:mysql://localhost:3306/highway?serverTimezone=UTC&useUnocode=true&characterEncodeing=UTF-8";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "990530";
    public static final String dbName = "highway";
    private homeController hc;
    private StringChange str_change=new StringChange();

    java.sql.Connection con = null;
    PreparedStatement stmt;
    CallableStatement clbStmt = null; // CallableStatement对象

    public DBOperate(homeController hc) {
        this.hc = hc;
        try {
            jbInit();
            if (hc != null) {
                hc.setconsole("数据库测试连接正常\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (hc != null) {
                hc.setconsole(e.toString() + "\n");
            }
        }
    }

    private void jbInit() throws Exception {
        Class.forName(name);
        con = DriverManager.getConnection(DBURL, user, password);
    }

    public Statement getStatement() {
        return stmt;
    }

    public void creat(String CREAT_TABLES) {
        try {
            stmt = con.prepareStatement(CREAT_TABLES);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void drop(String drop) {

        try {
            stmt = con.prepareStatement(drop);
            stmt.executeUpdate();
            hc.setconsole("数据库表删除成功！！！\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public long getCountOfBase(String GET_COUNT_DATABASE) throws SQLException {
        stmt = con.prepareStatement(GET_COUNT_DATABASE);
        ResultSet rset = stmt.executeQuery(GET_COUNT_DATABASE);
//        long rowCount=0; //获得ResultSet的总行数
//        if(null!=rset)
//        {
//            while(rset.next())
//            {
//                rowCount=rset.getInt(9); //通过索引返回行数
//            }
//        }
//        System.out.print("----------"+rowCount);
        long rowCount = 0; //获得ResultSet的总行数
        if (null != rset) {
            while (rset.next()) {
                rowCount = rset.getLong(1); //通过索引返回行数
            }
        }
        System.out.print("----------" + rowCount);
        return rowCount;
    }
    public Boolean judgeTableIsNull(String SELECT_NORMALDATA){
        try {
            stmt=con.prepareStatement(SELECT_NORMALDATA);
            ResultSet r=stmt.executeQuery(SELECT_NORMALDATA);
            String s=r.getString("time");
            if(s==null){
                return true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public ResultSet query(String SELECT_USER_SQL) throws SQLException {
        stmt = con.prepareStatement(SELECT_USER_SQL);
        return stmt.executeQuery(SELECT_USER_SQL);
    }

    public void update(String UPDATE_SQL) {
        try {
            stmt = con.prepareStatement(UPDATE_SQL);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(String ADD_SQL) {
        try {
            stmt = con.prepareStatement(ADD_SQL);
            stmt.setInt(1, 1);
            stmt.setString(2, "78");
            stmt.executeUpdate();
            hc.setconsole("数据插入正常...\n");
        } catch (SQLException e) {
            e.printStackTrace();
            hc.setconsole(e.toString() + "\n");
        }
    }

    public long page_num(long l){
        long pagenum=l / CheckModulear.num_data_every;
        if (l  % CheckModulear.num_data_every > 0) {
            pagenum += 1;
        }//保存一张表所需页数
        return pagenum;
    }

    //插入数据到normaldata
    public void insert_normaldata1(Timestamp timeStamep,ParseMessage pm){
        delete("truncate table normaldata2");
        for(int i=0;i<6;i++) {
            add_nomal1(pm.getNodeByteInfo()[i].getUno(),timeStamep,pm.getHeadInfo());
            if(homeController.getAlways_switch()==1&&homeController.op%4==0) {
                hc.adddataEchart(timeStamep.toString(), pm.getNodeByteInfo()[i].getUno());
            }
        }
    }
    //存储过程插入数据到normaldata2
    public void insert_normaldata2(Timestamp timeStamep,ParseMessage pm){
        delete("truncate table normaldata3");
//        int a=0;
//        while(true){
            for(int i=0;i<5;i++) {
                add_nomal2(pm.getNodeByteInfo()[i].getUno(),timeStamep,pm.getHeadInfo());
                if(homeController.getAlways_switch()==1&&homeController.op%4==0) {
                    hc.adddataEchart(timeStamep.toString(), pm.getNodeByteInfo()[i].getUno());
                }
            }
//            if(a>data_num){
//                //判断当前表中数据是否大于指定值data_num，如果大于，将数据插入其他表中
//                str_change.alterStauts(2);
//                break;
//            }
//            a=a+1;
//        }
    }
    //存储过程插入数据到normaldata3
    public void insert_normaldata3(Timestamp timeStamep,ParseMessage pm){
        ResultSet res = null; // 结果集对象
        delete("truncate table normaldata4");
        for(int i=0;i<5;i++) {
            add_nomal3(pm.getNodeByteInfo()[i].getUno(),timeStamep,pm.getHeadInfo());
            if(homeController.getAlways_switch()==1&&homeController.op%4==0) {
                hc.adddataEchart(timeStamep.toString(), pm.getNodeByteInfo()[i].getUno());
            }
        }
    }
    //存储过程插入数据到normaldata4
    public void insert_normaldata4(Timestamp timeStamep,ParseMessage pm){
        ResultSet res = null; // 结果集对象
        delete("truncate table normaldata5");
        for(int i=0;i<5;i++) {
            add_nomal4(pm.getNodeByteInfo()[i].getUno(),timeStamep,pm.getHeadInfo());
            if(homeController.getAlways_switch()==1&&homeController.op%4==0) {
                hc.adddataEchart(timeStamep.toString(), pm.getNodeByteInfo()[i].getUno());
            }
        }
    }
    //存储过程插入数据到normaldata5
    public void insert_normaldata5(Timestamp timeStamep,ParseMessage pm){
        ResultSet res = null; // 结果集对象
        delete("truncate table normaldata");
        for(int i=0;i<5;i++) {
            add_nomal5(pm.getNodeByteInfo()[i].getUno(),timeStamep,pm.getHeadInfo());
            if(homeController.getAlways_switch()==1&&homeController.op%4==0) {
                hc.adddataEchart(timeStamep.toString(), pm.getNodeByteInfo()[i].getUno());
            }
        }
    }

    public void dffff() {
        try {
            stmt = con.prepareStatement(DB_SQL.add_test_data);
            java.util.Date date = new Date();
            date.setDate(20);
            Timestamp timeStamep = new Timestamp(date.getTime());
            stmt.setString(1, timeStamep.toString());
            stmt.executeUpdate();
            hc.setconsole("数据插入正常...\n");
        } catch (SQLException e) {
            e.printStackTrace();
            hc.setconsole(e.toString() + "\n");
        }
    }

    public void add_nomal1(UnitNodeObject uno, Timestamp timeStamep, HeadInfo headInfo) {
        try {
            stmt = con.prepareStatement(DB_SQL.add_nomal_SQL1);
            getValue(uno, timeStamep, headInfo);
            stmt.executeUpdate();
            hc.setconsole("数据插入正常...\n");
        } catch (SQLException e) {
            e.printStackTrace();
            hc.setconsole(e.toString() + "\n");
        }
    }
    public void add_nomal2(UnitNodeObject uno, Timestamp timeStamep, HeadInfo headInfo) {
        try {
            stmt = con.prepareStatement(DB_SQL.add_nomal_SQL2);
            getValue(uno, timeStamep, headInfo);
            stmt.executeUpdate();
            hc.setconsole("数据插入正常...\n");
        } catch (SQLException e) {
            e.printStackTrace();
            hc.setconsole(e.toString() + "\n");
        }
    }
    public void add_nomal3(UnitNodeObject uno, Timestamp timeStamep, HeadInfo headInfo) {
        try {
            stmt = con.prepareStatement(DB_SQL.add_nomal_SQL3);
            getValue(uno, timeStamep, headInfo);
            stmt.executeUpdate();
            hc.setconsole("数据插入正常...\n");
        } catch (SQLException e) {
            e.printStackTrace();
            hc.setconsole(e.toString() + "\n");
        }
    }
    public void add_nomal4(UnitNodeObject uno, Timestamp timeStamep, HeadInfo headInfo) {
        try {
            stmt = con.prepareStatement(DB_SQL.add_nomal_SQL4);
            getValue(uno, timeStamep, headInfo);
            stmt.executeUpdate();
            hc.setconsole("数据插入正常...\n");
        } catch (SQLException e) {
            e.printStackTrace();
            hc.setconsole(e.toString() + "\n");
        }
    }
    public void add_nomal5(UnitNodeObject uno, Timestamp timeStamep, HeadInfo headInfo) {
        try {
            stmt = con.prepareStatement(DB_SQL.add_nomal_SQL5);
            getValue(uno, timeStamep, headInfo);
            stmt.executeUpdate();
            hc.setconsole("数据插入正常...\n");
        } catch (SQLException e) {
            e.printStackTrace();
            hc.setconsole(e.toString() + "\n");
        }
    }

    public void delete(String DELETE_SQL) {
        try {
            stmt = con.prepareStatement(DELETE_SQL);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            stmt.close();
            con.close();
            clbStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void judge_first_open()  {
        try{
            CheckModulear.normaldata_num= getCountOfBase(DB_SQL.normal_rows);
            CheckModulear.normaldata2_num= getCountOfBase(DB_SQL.normal_rows2);
            CheckModulear.normaldata3_num= getCountOfBase(DB_SQL.normal_rows3);
            CheckModulear.normaldata4_num= getCountOfBase(DB_SQL.normal_rows4);
            CheckModulear.normaldata5_num= getCountOfBase(DB_SQL.normal_rows5);
        }catch (SQLException e){
            e.printStackTrace();
        }
        int x=str_change.firstString();
        if(x==1&& CheckModulear.normaldata3_num!=0)
            CheckModulear.isFirstOpen=1;
        else
            CheckModulear.isFirstOpen=0;
    }

    public void getValue(UnitNodeObject uno, Timestamp timeStamep, HeadInfo headInfo) throws SQLException {

        int index = 1;
        for (int i = 0; i < CheckModulear.node_A_len.length; i++) {
            for (int j = 0; j < CheckModulear.node_A_len[i]; j++) {
                stmt.setFloat(index++, uno.mn[i].getA_analog()[j]);
            }
        }
        stmt.setString(index++, timeStamep.toString());
        stmt.setInt(index++, headInfo.getCar_unit_id());
//        for(int i=0;i<CheckModulear.node_A_len[0];i++)
//        {
//            stmt.setInt(i+1,uno.mn[0].getA_analog()[i]);
//        }
//        for(int i=0;i<7;i++)
//        {
//            stmt.setInt(i+9,uno.mn[1].getA_analog()[i]);
//        }
//        for(int i=0;i<8;i++)
//        {
//            stmt.setInt(i+16,uno.mn[2].getA_analog()[i]);
//        }
//        for(int i=0;i<8;i++)
//        {
//            stmt.setInt(i+24,uno.mn[3].getA_analog()[i]);
//        }
//        for(int i=0;i<4;i++)
//        {
//            stmt.setInt(i+32,uno.mn[4].getA_analog()[i]);
//        }
//        stmt.setLong(36,uno.mn[4].getA_analog_num());
//        stmt.setLong(37,uno.mn[5].getA_analog_num());
//        stmt.setLong(38,uno.mn[6].getA_analog_num());
//        for(int i=0;i<3;i++)
//        {
//            stmt.setInt(i+39,uno.mn[6].getA_analog()[i]);
//        }

    }
}
