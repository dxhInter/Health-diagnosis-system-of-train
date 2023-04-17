package sample.FileFounction;
import sample.Database.DBOperate;
import sample.Database.DB_SQL;
import sample.Homepage.homeController;
import sample.MessageOpen.CheckModulear;
import java.sql.SQLException;


public class StringChange {
    private static ForFile ff=new ForFile();
    private static String[] temp;
    private static homeController hc;
    int table_number;
    long l,pagenum;
    private static int a;//保存datatable文件内的数据
    //将文件内的字符串进行分割操作，便于进行读取数据
    public static void devideString() {
        String s=ff.readTXT();
        temp=s.split(",");
    }
    public int firstString(){
        devideString();
        a=Integer.parseInt(temp[0]);
        return a;
    }
    //判断当前正在插入的表是第几张,并设置table_number，决定下一次插入的表
    public int judegTable() {
        int x;
        x = firstString();
        long table_data_num;
        DBOperate db1 = new DBOperate(hc);
        db1.judge_first_open();
        switch (x) {
            case 1:
                try {
                    table_data_num = db1.getCountOfBase(DB_SQL.normal_rows);
                    if (CheckModulear.data_num - table_data_num < 50) {
                        table_number= 2;
                        alterStauts(1);
                    } else
                        table_number= 1;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    table_data_num = db1.getCountOfBase(DB_SQL.normal_rows2);
                    if (CheckModulear.data_num - table_data_num < 50) {
                        table_number= 3;
                        alterStauts(2);
                    } else
                        table_number= 2;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                table_data_num = CheckModulear.normaldata3_num;
                if (CheckModulear.data_num - table_data_num < 50) {
                    table_number= 4;
                    alterStauts(3);
                } else
                    table_number= 3;
                break;
            case 4:
                table_data_num = CheckModulear.normaldata4_num;
                if (CheckModulear.data_num - table_data_num < 50) {
                    table_number= 5;
                    alterStauts(4);
                } else
                    table_number= 4;
                break;
            case 5:
                table_data_num = CheckModulear.normaldata5_num;
                if (CheckModulear.data_num - table_data_num < 50) {
                    table_number= 1;
                    alterStauts(5);
                } else
                    table_number= 5;
                break;
            default:
                System.err.print("判断错误!\n");
        }
        return table_number;
    }
    //更改文件内数据，表满之后，将数据插入其他的表中
    public void alterStauts(int temp){
        DBOperate db1=new DBOperate(hc);
        switch (temp){
            case 1:
                ff.changeTXT("1,2,3,4,5","2,3,4,5,1");
                break;
            case 2:
                ff.changeTXT("2,3,4,5,1","3,4,5,1,2");
                break;
            case 3:
                ff.changeTXT("3,4,5,1,2","4,5,1,2,3");
                break;
            case 4:
                ff.changeTXT("4,5,1,2,3","5,1,2,3,4");
                break;
            case 5:
                ff.changeTXT("5,1,2,3,4","1,2,3,4,5");
                break;
        }
    }
    public long getpasgenum(){
        DBOperate db2 = new DBOperate(hc);
        long l1=0;
        long l2=0;
        long l3=0;
        long l4=0;
        long l5=0;
        int x=firstString();
        switch (x){
            case 1:
                //查询表345
                try {
                    //总number
                    l3 = db2.getCountOfBase(DB_SQL.normal_rows3);
                    l4 = db2.getCountOfBase(DB_SQL.normal_rows4);
                    l5 = db2.getCountOfBase(DB_SQL.normal_rows5);
                    l1 = db2.getCountOfBase(DB_SQL.normal_rows);
                    l=l1+l3+l4+l5;
                    pagenum = l / CheckModulear.num_data_every;
                    if (l % CheckModulear.num_data_every > 0) {
                        pagenum += 1;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                //查询表451
                try {
                    //总number
                    l4 = db2.getCountOfBase(DB_SQL.normal_rows4);
                    l5 = db2.getCountOfBase(DB_SQL.normal_rows5);
                    l1 = db2.getCountOfBase(DB_SQL.normal_rows);
                    l2 = db2.getCountOfBase(DB_SQL.normal_rows2);
                    l=l1+l2+l4+l5;
                    pagenum = l / CheckModulear.num_data_every;
                    if (l % CheckModulear.num_data_every > 0) {
                        pagenum += 1;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                //查询表5123
                try {
                    //总number
                    l3 = db2.getCountOfBase(DB_SQL.normal_rows3);
                    l5 = db2.getCountOfBase(DB_SQL.normal_rows5);
                    l1 = db2.getCountOfBase(DB_SQL.normal_rows);
                    l2 = db2.getCountOfBase(DB_SQL.normal_rows2);
                    l=l3+l2+l1+l5;
                    pagenum = l / CheckModulear.num_data_every;
                    if (l % CheckModulear.num_data_every > 0) {
                        pagenum += 1;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                //查询表123
                try {
                    //总number
                    l4 = db2.getCountOfBase(DB_SQL.normal_rows4);
                    l3 = db2.getCountOfBase(DB_SQL.normal_rows3);
                    l1 = db2.getCountOfBase(DB_SQL.normal_rows);
                    l2 = db2.getCountOfBase(DB_SQL.normal_rows2);
                    l=l1+l2+l4+l3;
                    pagenum = l / CheckModulear.num_data_every;
                    if (l % CheckModulear.num_data_every> 0) {
                        pagenum += 1;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 5:
                //查询表234
                try {
                    //总number
                    l4 = db2.getCountOfBase(DB_SQL.normal_rows4);
                    l5 = db2.getCountOfBase(DB_SQL.normal_rows5);
                    l3 = db2.getCountOfBase(DB_SQL.normal_rows3);
                    l2 = db2.getCountOfBase(DB_SQL.normal_rows2);
                    l=l3+l2+l4+l5;
                    pagenum = l / CheckModulear.num_data_every;
                    if (l % CheckModulear.num_data_every> 0) {
                        pagenum += 1;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.err.print("errorSearch!\n");
        }
        return pagenum;
    }
}
