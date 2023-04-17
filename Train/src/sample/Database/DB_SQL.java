package sample.Database;

import sun.usagetracker.UsageTrackerClient;

public class DB_SQL {
    //创建表
    public static final String Table_student="create table if not exists student(id int, name varchar(80))";
    public static final String Table_errinformation="create table if not exists errinformation(id int primary key auto_increment, " +
            "rule_version smallint," + "time_ms smallint,"+"time_m_s smallint,"+
            "time_day_h smallint," + "time_y_m smallint,"+"train_num smallint,"+
            "system_num smallint," + "err_num smallint,"+"element_code smallint,"+
            "err1_code smallint," + "err1_Confidence smallint,"+"err1_advice smallint,"+
            "err2_code smallint NULL," + "err2_Confidence smallint NULL,"+"err2_advice smallint NULL,"+
            "err3_code smallint NULL," + "err3_Confidence smallint NULL,"+"err3_advice smallint NULL,"+
            "err4_code smallint NULL," + "err4_Confidence smallint NULL,"+"err4_advice smallint NULL,"+
            "err5_code smallint NULL," + "err5_Confidence smallint NULL,"+"err5_advice smallint NULL"+
            ")";

    public static final String Table_normaldata="create table if not exists normaldata(id int primary key auto_increment, "+"car_unit_id int,"+"time datetime," +
            "A1_analog1 double," + "A1_analog2 double,"+"A1_analog3 double,"+"A1_analog4 double," + "A1_analog5 double,"+"A1_analog6 double,"+"A1_analog7 double," + "A1_analog8 double,"+
            "A2_analog1 double," + "A2_analog2 double,"+"A2_analog3 double,"+"A2_analog4 double," + "A2_analog5 double,"+"A2_analog6 double,"+"A2_analog7 double," +
            "A3_analog1 double," + "A3_analog2 double,"+"A3_analog3 double,"+"A3_analog4 double," + "A3_analog5 double,"+"A3_analog6 double,"+"A3_analog7 double," + "A3_analog8 double,"+
            "A4_analog1 double," + "A4_analog2 double,"+"A4_analog3 double,"+"A4_analog4 double," + "A4_analog5 double,"+"A4_analog6 double,"+"A4_analog7 double," + "A4_analog8 double,"+
            "A5_analog1 double," + "A5_analog2 double,"+"A5_analog3 double,"+"A5_analog4 double," + "A5_analog5 double,"+"A5_analog6 double,"+"A5_analog7 double," +"A5_analog_num int unsigned,"+
            "A6_analog_num double,"+
            "A7_analog_num double," + "A7_analog1 double,"+"A7_analog2 double,"+"A7_analog3 double," +
            "A8_analog int NULL" +
            ")";
    //test
    public static final String Table_normaldata2="create table if not exists normaldata2(id int primary key auto_increment, "+"car_unit_id int,"+"time datetime," +
            "A1_analog1 double," + "A1_analog2 double,"+"A1_analog3 double,"+"A1_analog4 double," + "A1_analog5 double,"+"A1_analog6 double,"+"A1_analog7 double," + "A1_analog8 double,"+
            "A2_analog1 double," + "A2_analog2 double,"+"A2_analog3 double,"+"A2_analog4 double," + "A2_analog5 double,"+"A2_analog6 double,"+"A2_analog7 double," +
            "A3_analog1 double," + "A3_analog2 double,"+"A3_analog3 double,"+"A3_analog4 double," + "A3_analog5 double,"+"A3_analog6 double,"+"A3_analog7 double," + "A3_analog8 double,"+
            "A4_analog1 double," + "A4_analog2 double,"+"A4_analog3 double,"+"A4_analog4 double," + "A4_analog5 double,"+"A4_analog6 double,"+"A4_analog7 double," + "A4_analog8 double,"+
            "A5_analog1 double," + "A5_analog2 double,"+"A5_analog3 double,"+"A5_analog4 double," + "A5_analog5 double,"+"A5_analog6 double,"+"A5_analog7 double," +"A5_analog_num int unsigned,"+
            "A6_analog_num double,"+
            "A7_analog_num double," + "A7_analog1 double,"+"A7_analog2 double,"+"A7_analog3 double," +
            "A8_analog int NULL" + ")";
    public static final String Table_normaldata3="create table if not exists normaldata3(id int primary key auto_increment, "+"car_unit_id int,"+"time datetime," +
            "A1_analog1 double," + "A1_analog2 double,"+"A1_analog3 double,"+"A1_analog4 double," + "A1_analog5 double,"+"A1_analog6 double,"+"A1_analog7 double," + "A1_analog8 double,"+
            "A2_analog1 double," + "A2_analog2 double,"+"A2_analog3 double,"+"A2_analog4 double," + "A2_analog5 double,"+"A2_analog6 double,"+"A2_analog7 double," +
            "A3_analog1 double," + "A3_analog2 double,"+"A3_analog3 double,"+"A3_analog4 double," + "A3_analog5 double,"+"A3_analog6 double,"+"A3_analog7 double," + "A3_analog8 double,"+
            "A4_analog1 double," + "A4_analog2 double,"+"A4_analog3 double,"+"A4_analog4 double," + "A4_analog5 double,"+"A4_analog6 double,"+"A4_analog7 double," + "A4_analog8 double,"+
            "A5_analog1 double," + "A5_analog2 double,"+"A5_analog3 double,"+"A5_analog4 double," + "A5_analog5 double,"+"A5_analog6 double,"+"A5_analog7 double," +"A5_analog_num int unsigned,"+
            "A6_analog_num double,"+
            "A7_analog_num double," + "A7_analog1 double,"+"A7_analog2 double,"+"A7_analog3 double," +
            "A8_analog int NULL" + ")";
    public static final String Table_normaldata4="create table if not exists normaldata4(id int primary key auto_increment, "+"car_unit_id int,"+"time datetime," +
            "A1_analog1 double," + "A1_analog2 double,"+"A1_analog3 double,"+"A1_analog4 double," + "A1_analog5 double,"+"A1_analog6 double,"+"A1_analog7 double," + "A1_analog8 double,"+
            "A2_analog1 double," + "A2_analog2 double,"+"A2_analog3 double,"+"A2_analog4 double," + "A2_analog5 double,"+"A2_analog6 double,"+"A2_analog7 double," +
            "A3_analog1 double," + "A3_analog2 double,"+"A3_analog3 double,"+"A3_analog4 double," + "A3_analog5 double,"+"A3_analog6 double,"+"A3_analog7 double," + "A3_analog8 double,"+
            "A4_analog1 double," + "A4_analog2 double,"+"A4_analog3 double,"+"A4_analog4 double," + "A4_analog5 double,"+"A4_analog6 double,"+"A4_analog7 double," + "A4_analog8 double,"+
            "A5_analog1 double," + "A5_analog2 double,"+"A5_analog3 double,"+"A5_analog4 double," + "A5_analog5 double,"+"A5_analog6 double,"+"A5_analog7 double," +"A5_analog_num int unsigned,"+
            "A6_analog_num double,"+
            "A7_analog_num double," + "A7_analog1 double,"+"A7_analog2 double,"+"A7_analog3 double," +
            "A8_analog int NULL" + ")";
    public static final String Table_normaldata5="create table if not exists normaldata5(id int primary key auto_increment, "+"car_unit_id int,"+"time datetime," +
            "A1_analog1 double," + "A1_analog2 double,"+"A1_analog3 double,"+"A1_analog4 double," + "A1_analog5 double,"+"A1_analog6 double,"+"A1_analog7 double," + "A1_analog8 double,"+
            "A2_analog1 double," + "A2_analog2 double,"+"A2_analog3 double,"+"A2_analog4 double," + "A2_analog5 double,"+"A2_analog6 double,"+"A2_analog7 double," +
            "A3_analog1 double," + "A3_analog2 double,"+"A3_analog3 double,"+"A3_analog4 double," + "A3_analog5 double,"+"A3_analog6 double,"+"A3_analog7 double," + "A3_analog8 double,"+
            "A4_analog1 double," + "A4_analog2 double,"+"A4_analog3 double,"+"A4_analog4 double," + "A4_analog5 double,"+"A4_analog6 double,"+"A4_analog7 double," + "A4_analog8 double,"+
            "A5_analog1 double," + "A5_analog2 double,"+"A5_analog3 double,"+"A5_analog4 double," + "A5_analog5 double,"+"A5_analog6 double,"+"A5_analog7 double," +"A5_analog_num int unsigned,"+
            "A6_analog_num double,"+
            "A7_analog_num double," + "A7_analog1 double,"+"A7_analog2 double,"+"A7_analog3 double," +
            "A8_analog int NULL" + ")";
    //建立存储过程test1~5
    public static final String create_procedure2=
//    "CREATE PROCEDURE insertProcedure2(IN `car_unit_id` INT,"+"IN `A1_analog1` DOUBLE,"+"IN `A1_analog2` DOUBLE,"+"IN `A1_analog3` DOUBLE,"+"IN `A1_analog4` DOUBLE,"+"IN `A1_analog5` DOUBLE,"+
//            "IN `A1_analog6` DOUBLE,"+"IN `A1_analog7` DOUBLE,"+"IN `A1_analog8` DOUBLE,"+"IN `A2_analog1` DOUBLE,"+"IN `A2_analog2` DOUBLE,"+"IN `A2_analog3` DOUBLE,"+"IN `A2_analog4` DOUBLE,"+
//            "IN `A2_analog5` DOUBLE,"+"IN `A2_analog6` DOUBLE,"+"IN `A2_analog7` DOUBLE,"+"IN `A3_analog1` DOUBLE,"+"IN `A3_analog2` DOUBLE,"+"IN `A3_analog3` DOUBLE,"+"IN `A3_analog4` DOUBLE,"+
//            "IN `A3_analog5` DOUBLE,"+"IN `A3_analog6` DOUBLE,"+"IN `A3_analog7` DOUBLE,"+"IN `A3_analog8` DOUBLE,"+"IN `A4_analog1` DOUBLE,"+"IN `A4_analog2` DOUBLE,"+"IN `A4_analog3` DOUBLE,"+
//            "IN `A4_analog4` DOUBLE,"+"IN `A4_analog5` DOUBLE,"+"IN `A4_analog6` DOUBLE,"+"IN `A4_analog7` DOUBLE,"+"IN `A4_analog8` DOUBLE,"+"IN `A5_analog1` DOUBLE,"+"IN `A5_analog2` DOUBLE,"+
//            "IN `A5_analog3` DOUBLE,"+"IN `A5_analog4` DOUBLE,"+"IN `A5_analog5` DOUBLE,"+"IN `A5_analog6` DOUBLE,"+"IN `A5_analog7` DOUBLE,"+"IN `A5_analog_num` INT,"+"IN `A6_analog_num` DOUBLE,"+
//            "IN `A7_analog_num` DOUBLE,"+"IN `A7_analog1` DOUBLE,"+"IN `A7_analog2` DOUBLE,"+"IN `A7_analog3` DOUBLE,"+"IN `A8_analog` INT"+")"+
//    "BEGIN"+
//            "insert into `normaldata2`(time,car_unit_id,A1_analog1,A1_analog2,A1_analog3,A1_analog4,"+
//            "A1_analog5,A1_analog6,A1_analog7, A1_analog8,A2_analog1,A2_analog2,A2_analog3,A2_analog4,A2_analog5,A2_analog6,A2_analog7,A3_analog1,A3_analog2,A3_analog3,A3_analog4,A3_analog5,A3_analog6," +
//            "A3_analog7,A3_analog8,A4_analog1,A4_analog2,A4_analog3,A4_analog4,A4_analog5,A4_analog6,A4_analog7,A4_analog8,A5_analog1,A5_analog2,A5_analog3,A5_analog4,A5_analog5,A5_analog6,A5_analog7," +
//            "A5_analog_num,A6_analog_num,A7_analog_num,A7_analog1,A7_analog2,A7_analog3,A8_analog" +
//            ")"+
//            "values(now(),car_unit_id,A1_analog1,A1_analog2,A1_analog3,A1_analog4, A1_analog5,A1_analog6,A1_analog7,A1_analog8,A2_analog1,A2_analog2,A2_analog3,A2_analog4,A2_analog5,A2_analog6,A2_analog7," +
//            "A3_analog1,A3_analog2,A3_analog3,A3_analog4,A3_analog5,A3_analog6,A3_analog7, A3_analog8,A4_analog1,A4_analog2,A4_analog3,A4_analog4,A4_analog5,A4_analog6,A4_analog7, A4_analog8,A5_analog1," +
//            "A5_analog2,A5_analog3,A5_analog4,A5_analog5,A5_analog6,A5_analog7,A5_analog_num,A6_analog_num,A7_analog_num,A7_analog1,A7_analog2,A7_analog3,A8_analog"+")"+";"+
//    "END";
            "CREATE DEFINER=`root`@`localhost` PROCEDURE `insertProcedure2`(IN `car_unit_id` INT,IN `A1_analog1` DOUBLE,IN `A1_analog2` DOUBLE,IN `A1_analog3` DOUBLE,IN `A1_analog4` DOUBLE,IN `A1_analog5` DOUBLE," +
                    "IN `A1_analog6` DOUBLE,IN `A1_analog7` DOUBLE,IN `A1_analog8` DOUBLE,IN `A2_analog1` DOUBLE,IN `A2_analog2` DOUBLE,IN `A2_analog3` DOUBLE,IN `A2_analog4` DOUBLE,IN `A2_analog5` DOUBLE," +
                    "IN `A2_analog6` DOUBLE,IN `A2_analog7` DOUBLE,IN `A3_analog1` DOUBLE,IN `A3_analog2` DOUBLE,IN `A3_analog3` DOUBLE,IN `A3_analog4` DOUBLE,IN `A3_analog5` DOUBLE,IN `A3_analog6` DOUBLE," +
                    "IN `A3_analog7` DOUBLE,IN `A3_analog8` DOUBLE,IN `A4_analog1` DOUBLE,IN `A4_analog2` DOUBLE,IN `A4_analog3` DOUBLE,IN `A4_analog4` DOUBLE,IN `A4_analog5` DOUBLE,IN `A4_analog6` DOUBLE," +
                    "IN `A4_analog7` DOUBLE,IN `A4_analog8` DOUBLE,IN `A5_analog1` DOUBLE,IN `A5_analog2` DOUBLE,IN `A5_analog3` DOUBLE,IN `A5_analog4` DOUBLE,IN `A5_analog5` DOUBLE,IN `A5_analog6` DOUBLE," +
                    "IN `A5_analog7` DOUBLE,IN `A5_analog_num` INT,IN `A6_analog_num` DOUBLE,IN `A7_analog_num` DOUBLE,IN `A7_analog1` DOUBLE,IN `A7_analog2` DOUBLE,IN `A7_analog3` DOUBLE,IN `A8_analog` INT"+")"+
                    "BEGIN" +
                    "INSERT INTO normaldata (A1_analog1,A1_analog2,A1_analog3,A1_analog4,A1_analog5,A1_analog6,A1_analog7, A1_analog8,A2_analog1,A2_analog2,A2_analog3,A2_analog4,A2_analog5,A2_analog6,A2_analog7,A3_analog1,A3_analog2,A3_analog3,A3_analog4,A3_analog5,A3_analog6,A3_analog7,A3_analog8,A4_analog1,A4_analog2,A4_analog3,A4_analog4,A4_analog5,A4_analog6,A4_analog7,A4_analog8,A5_analog1,A5_analog2,A5_analog3,A5_analog4,A5_analog5,A5_analog6,A5_analog7,A5_analog_num,A6_analog_num,A7_analog_num,A7_analog1,A7_analog2,A7_analog3,A8_analog"+")"+
                    "values(A1_analog1,A1_analog2,A1_analog3,A1_analog4, A1_analog5,A1_analog6,A1_analog7,A1_analog8,A2_analog1,A2_analog2,A2_analog3,A2_analog4,A2_analog5,A2_analog6,A2_analog7,A3_analog1,A3_analog2,A3_analog3,A3_analog4,A3_analog5,A3_analog6,A3_analog7, A3_analog8,A4_analog1,A4_analog2,A4_analog3,A4_analog4,A4_analog5,A4_analog6,A4_analog7, A4_analog8,A5_analog1,A5_analog2,A5_analog3,A5_analog4,A5_analog5,A5_analog6,A5_analog7,A5_analog_num,A6_analog_num,A7_analog_num,A7_analog1,A7_analog2,A7_analog3,A8_analog"+");"+
                    "END";
    //查询语句
    public static final String select_SQL="select * from test";

    public static final String drop_nomal="DROP TABLE IF EXISTS normaldata";

    //删除语句
    public static final String delet_SQL="create table student(id int, name varchar(80))";


    //添加数据
    public static final String add__SQL="insert into test values(1, '张三')\"";

    //修改数据
    public static final String update__SQL="UPDATE users SET type=1 WHERE userid=''";

    public static final String deletetable__SQL="truncate table 表名;";
    public static final String add_nomal_SQL1="insert into normaldata(A1_analog1, A1_analog2,A1_analog3,A1_analog4, A1_analog5," +
            "A2_analog1,A2_analog2,A2_analog3,A2_analog4,A2_analog5,A2_analog6," +
            "A3_analog1,A3_analog2,A3_analog3 ,A3_analog4,A3_analog5,"+
            "A4_analog1," + "A4_analog2,"+"A4_analog3,"+"A4_analog4," + "A4_analog5,"+
            "A5_analog1," + "A5_analog2,"+"A5_analog3,"+"A5_analog4," +"A5_analog5," +"A5_analog6," +"A5_analog7," +
            "A6_analog_num,"+
            "time,"+"car_unit_id"+")"+
            "values(?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?)";
    public static final String add_nomal_SQL2="insert into normaldata2(A1_analog1, A1_analog2,A1_analog3,A1_analog4, A1_analog5," +
            "A2_analog1,A2_analog2,A2_analog3,A2_analog4,A2_analog5,A2_analog6," +
            "A3_analog1,A3_analog2,A3_analog3 ,A3_analog4,A3_analog5,"+
            "A4_analog1," + "A4_analog2,"+"A4_analog3,"+"A4_analog4," + "A4_analog5,"+
            "A5_analog1," + "A5_analog2,"+"A5_analog3,"+"A5_analog4," +"A5_analog5," +"A5_analog6," +"A5_analog7," +
            "A6_analog_num,"+
            "time,"+"car_unit_id"+")"+
            "values(?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?)";
    public static final String add_nomal_SQL3="insert into normaldata3(A1_analog1, A1_analog2,A1_analog3,A1_analog4, A1_analog5," +
            "A2_analog1,A2_analog2,A2_analog3,A2_analog4,A2_analog5,A2_analog6," +
            "A3_analog1,A3_analog2,A3_analog3 ,A3_analog4,A3_analog5,"+
            "A4_analog1," + "A4_analog2,"+"A4_analog3,"+"A4_analog4," + "A4_analog5,"+
            "A5_analog1," + "A5_analog2,"+"A5_analog3,"+"A5_analog4," +"A5_analog5," +"A5_analog6," +"A5_analog7," +
            "A6_analog_num,"+
            "time,"+"car_unit_id"+")"+
            "values(?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?)";
    public static final String add_nomal_SQL4="insert into normaldata4(A1_analog1, A1_analog2,A1_analog3,A1_analog4, A1_analog5," +
            "A2_analog1,A2_analog2,A2_analog3,A2_analog4,A2_analog5,A2_analog6," +
            "A3_analog1,A3_analog2,A3_analog3 ,A3_analog4,A3_analog5,"+
            "A4_analog1," + "A4_analog2,"+"A4_analog3,"+"A4_analog4," + "A4_analog5,"+
            "A5_analog1," + "A5_analog2,"+"A5_analog3,"+"A5_analog4," +"A5_analog5," +"A5_analog6," +"A5_analog7," +
            "A6_analog_num,"+
            "time,"+"car_unit_id"+")"+
            "values(?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?)";
    public static final String add_nomal_SQL5="insert into normaldata5(A1_analog1, A1_analog2,A1_analog3,A1_analog4, A1_analog5," +
            "A2_analog1,A2_analog2,A2_analog3,A2_analog4,A2_analog5,A2_analog6," +
            "A3_analog1,A3_analog2,A3_analog3 ,A3_analog4,A3_analog5,"+
            "A4_analog1," + "A4_analog2,"+"A4_analog3,"+"A4_analog4," + "A4_analog5,"+
            "A5_analog1," + "A5_analog2,"+"A5_analog3,"+"A5_analog4," +"A5_analog5," +"A5_analog6," +"A5_analog7," +
            "A6_analog_num,"+
            "time,"+"car_unit_id"+")"+
            "values(?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?)";
    public static final String add_test_data="insert into normaldata(time) values(?)";
    public static final String add_nomal_getdate="SELECT * FROM normaldata";
    public static final String  normal_rows=" select count(*) from normaldata";
    public static final String  normal_rows2=" select count(*) from normaldata2";
    public static final String  normal_rows3=" select count(*) from normaldata3";
    public static final String  normal_rows4=" select count(*) from normaldata4";
    public static final String  normal_rows5=" select count(*) from normaldata5";
    public static final String  normal_rows1=" explain select * from normaldata";
}
