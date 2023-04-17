package sample.echartpackage;

import sample.Database.DBOperate;
import sample.FileFounction.StringChange;
import sample.MessageOpen.CheckModulear;
import java.sql.ResultSet;
import java.sql.SQLException;

public class get_Table_Data {
    private StringChange str_change=new StringChange();
    public int get_table_data(DBOperate db2, String l, ResultSet[] ret) throws SQLException{
        int x=str_change.firstString();
        int status=0;
        if(x==1){
            status = get_normal_data1(db2, l, ret);
            return status;
        }
        if(x==2){
            status = get_normal_data2(db2, l, ret);
            return status;
        }if(x==3){
            status = get_normal_data3(db2, l, ret);
            return status;
        }
        if(x==4){
            status = get_normal_data4(db2, l, ret);
            return status;
        }if(x==5){
            status = get_normal_data5(db2, l, ret);
            return status;
        }
        else{
            System.err.print("status获取错误");
            return 0;
        }
    }
    public int get_normal_data1(DBOperate db2, String l, ResultSet[] ret) throws SQLException {
        int status = 0;
        if (CheckModulear.isFirstOpen == 1) {
            long current_page_datanum1 = Integer.parseInt(l) * CheckModulear.num_data_every;//总页数l显示的数据量
            if (current_page_datanum1 <= CheckModulear.normaldata3_num) {
                ret[0] = db2.query("SELECT " + "*" + " FROM normaldata3 where id>" + (Integer.parseInt(l) - 1) * CheckModulear.num_data_every + " AND id<=" + Integer.parseInt(l) * CheckModulear.num_data_every);
                status = 1;
            } else {
                long pagenum1 = db2.page_num(CheckModulear.normaldata3_num);//保存一张表所需页数
                if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum1))) {
                    ret[0] = db2.query("SELECT " + "*" + " FROM normaldata3 where id>" + (Integer.parseInt(l) - 1) * CheckModulear.num_data_every + " AND id<=" + Integer.parseInt(l) * CheckModulear.num_data_every);
                    long difference1 = current_page_datanum1 - CheckModulear.normaldata3_num;
                    ret[1] = db2.query("SELECT " + "*" + " FROM normaldata4 where id>0 AND id<=" + Integer.parseInt(String.valueOf(difference1)));
                    status = 2;
                    return status;
                }
                long difference1=pagenum1 *CheckModulear.num_data_every-CheckModulear.normaldata3_num;
                long current_page_datanum2 = (Integer.parseInt(l) - Integer.parseInt(String.valueOf(pagenum1))) * CheckModulear.num_data_every;
                if (current_page_datanum2 <= CheckModulear.normaldata4_num) {
                    ret[0] = db2.query("SELECT " + "*" + " FROM normaldata4 where id>" + (current_page_datanum2 - CheckModulear.num_data_every+difference1) + " AND id<=" + (current_page_datanum2+difference1));
                    status = 1;
                } else {
                    long pagenum2 = db2.page_num(CheckModulear.normaldata4_num);//保存一张表所需页数
                    long pagenum_all1 = pagenum2 + pagenum1;
                    if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum_all1))) {
                        ret[0] = db2.query("SELECT " + "*" + " FROM normaldata4 where id>" + (current_page_datanum2 - CheckModulear.num_data_every) + " AND id<=" + current_page_datanum2);
                        long difference2 = current_page_datanum2 - CheckModulear.normaldata4_num;
                        ret[1] = db2.query("SELECT " + "*" + " FROM normaldata5 where id>0 AND id<=" + Integer.parseInt(String.valueOf(difference2)));
                        status = 2;
                        return status;
                    }
                    long difference2=pagenum2 *CheckModulear.num_data_every-CheckModulear.normaldata4_num+difference1;
                    long current_page_datanum3 = (Integer.parseInt(l) - Integer.parseInt(String.valueOf(pagenum2)) - Integer.parseInt(String.valueOf(pagenum1))) * CheckModulear.num_data_every;
                    if (current_page_datanum3 <= CheckModulear.normaldata5_num) {
                        ret[0] = db2.query("SELECT " + "*" + " FROM normaldata5 where id>" + (current_page_datanum3 - CheckModulear.num_data_every+difference2) + " AND id<=" + (current_page_datanum3+difference2));
                        status = 1;
                    } else {
                        long pagenum3 = db2.page_num(CheckModulear.normaldata5_num);//保存一张表所需页数
                        long pagenum_all2 = pagenum3 + pagenum2 + pagenum1;
                        if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum_all2))) {
                            ret[0] = db2.query("SELECT " + "*" + " FROM normaldata5 where id>" + (current_page_datanum3 - CheckModulear.num_data_every) + " AND id<=" + current_page_datanum3);
                            long difference3 = current_page_datanum3 - CheckModulear.normaldata5_num;
                            ret[1] = db2.query("SELECT " + "*" + " FROM normaldata where id>0 AND id<" + Integer.parseInt(String.valueOf(difference3)));
                            status = 2;
                            return status;
                        }
                        long difference3=pagenum3 *CheckModulear.num_data_every-CheckModulear.normaldata5_num+difference2;
                        long current_page_datanum4 = (Integer.parseInt(l) - Integer.parseInt(String.valueOf(pagenum3)) - Integer.parseInt(String.valueOf(pagenum2)) - Integer.parseInt(String.valueOf(pagenum1))) * CheckModulear.num_data_every;
                        if (current_page_datanum4 <= CheckModulear.normaldata5_num) {
                            ret[0] = db2.query("SELECT " + "*" + " FROM normaldata where id>" + (current_page_datanum4 - CheckModulear.num_data_every+difference3) + " AND id<=" + (current_page_datanum4+difference3));
                            status = 1;
                        }
                    }
                }
            }
        }
        else {
            ret[0] = db2.query("SELECT " + "*" + " FROM normaldata where id>" + (Integer.parseInt(l) - 1) * CheckModulear.num_data_every + " AND id<=" + Integer.parseInt(l)*CheckModulear.num_data_every);
            status=1;
        }
        return status;
    }

    public int get_normal_data2(DBOperate db2, String l, ResultSet[] ret) throws SQLException {
        int status = 0;
        if (CheckModulear.isFirstOpen==1) {
            long current_page_datanum1 = Integer.parseInt(l) * CheckModulear.num_data_every;//总页数l显示的数据量
            if (current_page_datanum1 <= CheckModulear.normaldata4_num) {
                ret[0] = db2.query("SELECT " + "*" + " FROM normaldata4 where id>" + (Integer.parseInt(l) - 1) * CheckModulear.num_data_every + " AND id<=" + Integer.parseInt(l) * CheckModulear.num_data_every);
                status = 1;
            } else {
                long pagenum1 = db2.page_num(CheckModulear.normaldata4_num);//保存一张表所需页数
                if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum1))) {
                    ret[0] = db2.query("SELECT " + "*" + " FROM normaldata4 where id>" + (Integer.parseInt(l) - 1) * CheckModulear.num_data_every + " AND id<=" + Integer.parseInt(l) * CheckModulear.num_data_every);
                    long difference1 = current_page_datanum1 - CheckModulear.normaldata4_num;
                    ret[1] = db2.query("SELECT " + "*" + " FROM normaldata5 where id>0 AND id<=" + Integer.parseInt(String.valueOf(difference1)));
                    status = 2;
                    return status;
                }
                long difference1=pagenum1*CheckModulear.num_data_every - CheckModulear.normaldata4_num;
                long current_page_datanum2 = (Integer.parseInt(l) - Integer.parseInt(String.valueOf(pagenum1))) * CheckModulear.num_data_every;
                if ((current_page_datanum2) <= CheckModulear.normaldata5_num) {
                    ret[0] = db2.query("SELECT " + "*" + " FROM normaldata5 where id>" + (current_page_datanum2 - CheckModulear.num_data_every) + " AND id<=" + current_page_datanum2);
                    status = 1;
                } else {
                    long pagenum2 = db2.page_num(CheckModulear.normaldata5_num);//保存一张表所需页数
                    long pagenum_all1 = pagenum2 + pagenum1;
                    if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum_all1))) {
                        ret[0] = db2.query("SELECT " + "*" + " FROM normaldata5 where id>" + (current_page_datanum2 - CheckModulear.num_data_every+difference1) + " AND id<=" + (difference1+current_page_datanum2));
                        long difference2 = current_page_datanum2 - CheckModulear.normaldata5_num+difference1;
                        ret[1] = db2.query("SELECT " + "*" + " FROM normaldata where id>0 AND id<=" + Integer.parseInt(String.valueOf(difference2)));
                        status = 2;
                        return status;
                    }
                    long difference2=pagenum2*CheckModulear.num_data_every - CheckModulear.normaldata5_num+difference1;
                    long current_page_datanum3 = (Integer.parseInt(l) - Integer.parseInt(String.valueOf(pagenum2)) - Integer.parseInt(String.valueOf(pagenum1))) * CheckModulear.num_data_every;
                    if (current_page_datanum3 <= CheckModulear.normaldata_num) {
                        ret[0] = db2.query("SELECT " + "*" + " FROM normaldata where id>" + (current_page_datanum3 - CheckModulear.num_data_every) + " AND id<=" + current_page_datanum3);
                        status = 1;
                    } else {
                        long pagenum3 = db2.page_num(CheckModulear.normaldata_num);//保存一张表所需页数
                        long pagenum_all2 = pagenum3 + pagenum2 + pagenum1;
                        if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum_all2))) {
                            ret[0] = db2.query("SELECT " + "*" + " FROM normaldata where id>" + (current_page_datanum3 - CheckModulear.num_data_every) + " AND id<=" + current_page_datanum3);
                            long difference3 = current_page_datanum3 - CheckModulear.normaldata_num;
                            ret[1] = db2.query("SELECT " + "*" + " FROM normaldata2 where id>0 AND id<=" + Integer.parseInt(String.valueOf(difference3)));
                            status = 2;
                            return status;
                        }
                        long difference3=pagenum3*CheckModulear.num_data_every - CheckModulear.normaldata_num+difference2;
                        long current_page_datanum4 = (Integer.parseInt(l) - Integer.parseInt(String.valueOf(pagenum3)) - Integer.parseInt(String.valueOf(pagenum2)) - Integer.parseInt(String.valueOf(pagenum1))) * CheckModulear.num_data_every;
                        if (current_page_datanum4 <= CheckModulear.normaldata2_num) {
                            ret[0] = db2.query("SELECT " + "*" + " FROM normaldata2 where id>" + (current_page_datanum4 - CheckModulear.num_data_every+difference3) + " AND id<=" + (current_page_datanum4+difference3));
                            status = 1;
                        }
                        else {
                            long pagenum4 = db2.page_num(CheckModulear.normaldata2_num);//保存一张表所需页数
                            long pagenum_all3 =pagenum4+ pagenum3 + pagenum2 + pagenum1;
                            if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum_all3))) {
                                ret[0] = db2.query("SELECT " + "*" + " FROM normaldata2 where id>" + (current_page_datanum4 - CheckModulear.num_data_every) + " AND id<=" + current_page_datanum4);
                                status = 1;
                                return status;
                            }
                        }
                    }
                }
            }
        }
        else {
            long current_page_datanum1 = Integer.parseInt(l) * CheckModulear.num_data_every;//总页数l显示的数据量
            if (current_page_datanum1 <= CheckModulear.normaldata_num) {
                ret[0] = db2.query("SELECT " + "*" + " FROM normaldata where id>" + (Integer.parseInt(l) - 1) * CheckModulear.num_data_every + " AND id<=" + Integer.parseInt(l) * CheckModulear.num_data_every);
                status = 1;
            } else {
                long pagenum1 = db2.page_num(CheckModulear.normaldata_num);//保存一张表所需页数
                if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum1))) {
                    ret[0] = db2.query("SELECT " + "*" + " FROM normaldata where id>" + (Integer.parseInt(l) - 1) * CheckModulear.num_data_every + " AND id<=" + Integer.parseInt(l) * CheckModulear.num_data_every);
                    long difference1 = current_page_datanum1 - CheckModulear.normaldata_num;
                    ret[1] = db2.query("SELECT " + "*" + " FROM normaldata2 where id>0 AND id<=" + Integer.parseInt(String.valueOf(difference1)));
                    status = 2;
                    return status;
                }
                long difference1 = pagenum1 * CheckModulear.num_data_every - CheckModulear.normaldata_num;
                long current_page_datanum2 = (Integer.parseInt(l) - Integer.parseInt(String.valueOf(pagenum1))) * CheckModulear.num_data_every;
                if (current_page_datanum2 <= CheckModulear.normaldata2_num) {
                    ret[0] = db2.query("SELECT " + "*" + " FROM normaldata2 where id>" + (current_page_datanum2 - CheckModulear.num_data_every + difference1) + " AND id<=" + (current_page_datanum2 + difference1));
                    status = 1;
                }else {
                    long pagenum2 = db2.page_num(CheckModulear.normaldata2_num);//保存一张表所需页数
                    long pagenum_all1 = pagenum2 + pagenum1;
                    if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum_all1))) {
                        ret[0] = db2.query("SELECT " + "*" + " FROM normaldata2 where id>" + (current_page_datanum2 - CheckModulear.num_data_every) + " AND id<=" + current_page_datanum2);
                        status = 1;
                        return status;
                    }
                }
            }
        }
        return status;
    }

    public int get_normal_data3(DBOperate db2, String l, ResultSet[] ret) throws SQLException {
        int status = 0;
        if (CheckModulear.isFirstOpen==1) {
            long current_page_datanum1 = Integer.parseInt(l) * CheckModulear.num_data_every;//总页数l显示的数据量
            if (current_page_datanum1 <= CheckModulear.normaldata5_num) {
                ret[0] = db2.query("SELECT " + "*" + " FROM normaldata5 where id>" + (Integer.parseInt(l) - 1) * CheckModulear.num_data_every + " AND id<=" + Integer.parseInt(l) * CheckModulear.num_data_every);
                status = 1;
            } else {
                long pagenum1 = db2.page_num(CheckModulear.normaldata5_num);//保存一张表所需页数
                if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum1))) {
                    ret[0] = db2.query("SELECT " + "*" + " FROM normaldata5 where id>" + (Integer.parseInt(l) - 1) * CheckModulear.num_data_every + " AND id<=" + Integer.parseInt(l) * CheckModulear.num_data_every);
                    long difference1 = current_page_datanum1 - CheckModulear.normaldata5_num;
                    ret[1] = db2.query("SELECT " + "*" + " FROM normaldata where id>0 AND id<=" + Integer.parseInt(String.valueOf(difference1)));
                    status = 2;
                    return status;
                }
                long difference1=pagenum1*CheckModulear.num_data_every - CheckModulear.normaldata5_num;
                long current_page_datanum2 = (Integer.parseInt(l) - Integer.parseInt(String.valueOf(pagenum1))) * CheckModulear.num_data_every;
                if (current_page_datanum2 <= CheckModulear.normaldata_num) {
                    ret[0] = db2.query("SELECT " + "*" + " FROM normaldata where id>" + (current_page_datanum2 - CheckModulear.num_data_every+difference1) + " AND id<=" + (current_page_datanum2+difference1));
                    status = 1;
                } else {
                    long pagenum2 = db2.page_num(CheckModulear.normaldata_num);//保存一张表所需页数
                    long pagenum_all1 = pagenum2 + pagenum1;
                    if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum_all1))) {
                        ret[0] = db2.query("SELECT " + "*" + " FROM normaldata where id>" + (current_page_datanum2 - CheckModulear.num_data_every) + " AND id<=" + current_page_datanum2);
                        long difference2 = current_page_datanum2 - CheckModulear.normaldata_num;
                        ret[1] = db2.query("SELECT " + "*" + " FROM normaldata2 where id>0 AND id<=" + Integer.parseInt(String.valueOf(difference2)));
                        status = 2;
                        return status;
                    }
                    long difference2=pagenum2*CheckModulear.num_data_every - CheckModulear.normaldata_num+difference1;
                    long current_page_datanum3 = (Integer.parseInt(l) - Integer.parseInt(String.valueOf(pagenum2)) - Integer.parseInt(String.valueOf(pagenum1))) * CheckModulear.num_data_every;
                    if (current_page_datanum3 <= CheckModulear.normaldata2_num) {
                        ret[0] = db2.query("SELECT " + "*" + " FROM normaldata2 where id>" + (current_page_datanum3 - CheckModulear.num_data_every+difference2) + " AND id<=" + (current_page_datanum3+difference2));
                        status = 1;
                    } else {
                        long pagenum3 = db2.page_num(CheckModulear.normaldata2_num);//保存一张表所需页数
                        long pagenum_all2 = pagenum3 + pagenum2 + pagenum1;
                        if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum_all2))) {
                            ret[0] = db2.query("SELECT " + "*" + " FROM normaldata2 where id>" + (current_page_datanum3 - CheckModulear.num_data_every) + " AND id<=" + current_page_datanum3);
                            long difference3 = current_page_datanum3 - CheckModulear.normaldata2_num;
                            ret[1] = db2.query("SELECT " + "*" + " FROM normaldata3 where id>0 AND id<=" + Integer.parseInt(String.valueOf(difference3)));
                            status = 2;
                            return status;
                        }
                        long difference3=pagenum3*CheckModulear.num_data_every - CheckModulear.normaldata2_num+difference2;
                        long current_page_datanum4 = (Integer.parseInt(l) - Integer.parseInt(String.valueOf(pagenum3)) - Integer.parseInt(String.valueOf(pagenum2)) - Integer.parseInt(String.valueOf(pagenum1))) * CheckModulear.num_data_every;
                        if (current_page_datanum4 <= CheckModulear.normaldata3_num) {
                            ret[0] = db2.query("SELECT " + "*" + " FROM normaldata3 where id>" + (current_page_datanum4 - CheckModulear.num_data_every+difference3) + " AND id<=" + (current_page_datanum4+difference3));
                            status = 1;
                        }
                        else {
                            long pagenum4 = db2.page_num(CheckModulear.normaldata3_num);//保存一张表所需页数
                            long pagenum_all3 =pagenum4+ pagenum3 + pagenum2 + pagenum1;
                            if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum_all3))) {
                                ret[0] = db2.query("SELECT " + "*" + " FROM normaldata3 where id>" + (current_page_datanum4 - CheckModulear.num_data_every) + " AND id<=" + current_page_datanum4);
                                status = 1;
                                return status;
                            }
                        }
                    }
                }
            }
        }
        else {
            long current_page_datanum1 = Integer.parseInt(l) * CheckModulear.num_data_every;//总页数l显示的数据量
            if (current_page_datanum1 <= CheckModulear.normaldata_num) {
                ret[0] = db2.query("SELECT " + "*" + " FROM normaldata where id>" + (Integer.parseInt(l) - 1) * CheckModulear.num_data_every + " AND id<=" + Integer.parseInt(l) * CheckModulear.num_data_every);
                status = 1;
            } else {
                long pagenum1 = db2.page_num(CheckModulear.normaldata_num);//保存一张表所需页数
                if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum1))) {
                    ret[0] = db2.query("SELECT " + "*" + " FROM normaldata where id>" + (Integer.parseInt(l) - 1) * CheckModulear.num_data_every + " AND id<=" + Integer.parseInt(l) * CheckModulear.num_data_every);
                    long difference1 = current_page_datanum1 - CheckModulear.normaldata_num;
                    ret[1] = db2.query("SELECT " + "*" + " FROM normaldata2 where id>0 AND id<=" + Integer.parseInt(String.valueOf(difference1)));
                    status = 2;
                    return status;
                }
                long difference1 = pagenum1 * CheckModulear.num_data_every - CheckModulear.normaldata_num;
                long current_page_datanum2 = (Integer.parseInt(l) - Integer.parseInt(String.valueOf(pagenum1))) * CheckModulear.num_data_every;
                if (current_page_datanum2 <= CheckModulear.normaldata2_num) {
                    ret[0] = db2.query("SELECT " + "*" + " FROM normaldata2 where id>" + (current_page_datanum2 - CheckModulear.num_data_every + difference1) + " AND id<=" + (current_page_datanum2 + difference1));
                    status = 1;
                } else {
                    long pagenum2 = db2.page_num(CheckModulear.normaldata2_num);//保存一张表所需页数
                    long pagenum_all1 = pagenum2 + pagenum1;
                    if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum_all1))) {
                        ret[0] = db2.query("SELECT " + "*" + " FROM normaldata2 where id>" + (current_page_datanum2 - CheckModulear.num_data_every) + " AND id<=" + current_page_datanum2);
                        long difference2 = current_page_datanum2 - CheckModulear.normaldata2_num;
                        ret[1] = db2.query("SELECT " + "*" + " FROM normaldata3 where id>0 AND id<=" + Integer.parseInt(String.valueOf(difference2)));
                        status = 2;
                        return status;
                    }
                    long difference2 = pagenum2 * CheckModulear.num_data_every - CheckModulear.normaldata2_num + difference1;
                    long current_page_datanum3 = (Integer.parseInt(l) - Integer.parseInt(String.valueOf(pagenum2)) - Integer.parseInt(String.valueOf(pagenum1))) * CheckModulear.num_data_every;
                    if (current_page_datanum3 <= CheckModulear.normaldata3_num) {
                        ret[0] = db2.query("SELECT " + "*" + " FROM normaldata3 where id>" + (current_page_datanum3 - CheckModulear.num_data_every + difference2) + " AND id<=" + (current_page_datanum3 + difference2));
                        status = 1;
                    } else {
                        long pagenum3 = db2.page_num(CheckModulear.normaldata3_num);//保存一张表所需页数
                        long pagenum_all2 = pagenum3 + pagenum2 + pagenum1;
                        if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum_all2))) {
                            ret[0] = db2.query("SELECT " + "*" + " FROM normaldata3 where id>" + (current_page_datanum3 - CheckModulear.num_data_every) + " AND id<=" + current_page_datanum3);
                            status = 1;
                            return status;
                        }
                    }
                }
            }
        }
        return status;
    }

    public int get_normal_data4(DBOperate db2, String l, ResultSet[] ret) throws SQLException {
        int status = 0;
        long current_page_datanum1 = Integer.parseInt(l) * CheckModulear.num_data_every;//总页数l显示的数据量
        if (current_page_datanum1 <= CheckModulear.normaldata_num) {
            ret[0] = db2.query("SELECT " + "*" + " FROM normaldata where id>" + (Integer.parseInt(l) - 1) * CheckModulear.num_data_every + " AND id<=" + Integer.parseInt(l) * CheckModulear.num_data_every);
            status = 1;
        } else {
            long pagenum1 = db2.page_num(CheckModulear.normaldata_num);//保存一张表所需页数
            if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum1))) {
                ret[0] = db2.query("SELECT " + "*" + " FROM normaldata where id>" + (Integer.parseInt(l) - 1) * CheckModulear.num_data_every + " AND id<=" + Integer.parseInt(l) * CheckModulear.num_data_every);
                long difference1 = current_page_datanum1 - CheckModulear.normaldata_num;
                ret[1] = db2.query("SELECT " + "*" + " FROM normaldata2 where id>0 AND id<=" + Integer.parseInt(String.valueOf(difference1)));
                status = 2;
                return status;
            }
            long difference1=pagenum1*CheckModulear.num_data_every - CheckModulear.normaldata_num;
            long current_page_datanum2 = (Integer.parseInt(l) - Integer.parseInt(String.valueOf(pagenum1))) * CheckModulear.num_data_every;
            if (current_page_datanum2 <= CheckModulear.normaldata2_num) {
                ret[0] = db2.query("SELECT " + "*" + " FROM normaldata2 where id>" + (current_page_datanum2 - CheckModulear.num_data_every+difference1) + " AND id<=" + (current_page_datanum2+difference1));
                status = 1;
            } else {
                long pagenum2 = db2.page_num(CheckModulear.normaldata2_num);//保存一张表所需页数
                long pagenum_all1 = pagenum2 + pagenum1;
                if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum_all1))) {
                    ret[0] = db2.query("SELECT " + "*" + " FROM normaldata2 where id>" + (current_page_datanum2 - CheckModulear.num_data_every) + " AND id<=" + current_page_datanum2);
                    long difference2 = current_page_datanum2 - CheckModulear.normaldata2_num;
                    ret[1] = db2.query("SELECT " + "*" + " FROM normaldata3 where id>0 AND id<=" + Integer.parseInt(String.valueOf(difference2)));
                    status = 2;
                    return status;
                }
                long difference2=pagenum2*CheckModulear.num_data_every - CheckModulear.normaldata2_num+difference1;
                long current_page_datanum3 = (Integer.parseInt(l) - Integer.parseInt(String.valueOf(pagenum2)) - Integer.parseInt(String.valueOf(pagenum1))) * CheckModulear.num_data_every;
                if (current_page_datanum3 <= CheckModulear.normaldata3_num) {
                    ret[0] = db2.query("SELECT " + "*" + " FROM normaldata3 where id>" + (current_page_datanum3 - CheckModulear.num_data_every+difference2) + " AND id<=" + (current_page_datanum3+difference2));
                    status = 1;
                } else {
                    long pagenum3 = db2.page_num(CheckModulear.normaldata3_num);//保存一张表所需页数
                    long pagenum_all2 = pagenum3 + pagenum2 + pagenum1;
                    if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum_all2))) {
                        ret[0] = db2.query("SELECT " + "*" + " FROM normaldata3 where id>" + (current_page_datanum3 - CheckModulear.num_data_every) + " AND id<=" + current_page_datanum3);
                        long difference3 = current_page_datanum3 - CheckModulear.normaldata3_num;
                        ret[1] = db2.query("SELECT " + "*" + " FROM normaldata4 where id>0 AND id<=" + Integer.parseInt(String.valueOf(difference3)));
                        status = 2;
                        return status;
                    }
                    long difference3=pagenum3*CheckModulear.num_data_every - CheckModulear.normaldata3_num+difference2;
                    long current_page_datanum4 = (Integer.parseInt(l) - Integer.parseInt(String.valueOf(pagenum3)) - Integer.parseInt(String.valueOf(pagenum2)) - Integer.parseInt(String.valueOf(pagenum1))) * CheckModulear.num_data_every;
                    if (current_page_datanum4 <= CheckModulear.normaldata4_num) {
                        ret[0] = db2.query("SELECT " + "*" + " FROM normaldata4 where id>" + (current_page_datanum4 - CheckModulear.num_data_every+difference3) + " AND id<=" + (current_page_datanum4+difference3));
                        status = 1;
                    }
                    else {
                        long pagenum4 = db2.page_num(CheckModulear.normaldata4_num);//保存一张表所需页数
                        long pagenum_all3 =pagenum4+ pagenum3 + pagenum2 + pagenum1;
                        if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum_all3))) {
                            ret[0] = db2.query("SELECT " + "*" + " FROM normaldata4 where id>" + (current_page_datanum4 - CheckModulear.num_data_every) + " AND id<=" + current_page_datanum4);
                            status = 1;
                            return status;
                        }
                    }
                }
            }
        }
        return status;
    }

    public int get_normal_data5(DBOperate db2, String l, ResultSet[] ret) throws SQLException {
        int status = 0;
        long current_page_datanum1 = Integer.parseInt(l) * CheckModulear.num_data_every;//总页数l显示的数据量
        if (current_page_datanum1 <= CheckModulear.normaldata2_num) {
            ret[0] = db2.query("SELECT " + "*" + " FROM normaldata2 where id>" + (Integer.parseInt(l) - 1) * CheckModulear.num_data_every + " AND id<=" + Integer.parseInt(l) * CheckModulear.num_data_every);
            status = 1;
        } else {
            long pagenum1 = db2.page_num(CheckModulear.normaldata2_num);//保存一张表所需页数
            if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum1))) {
                ret[0] = db2.query("SELECT " + "*" + " FROM normaldata2 where id>" + (Integer.parseInt(l) - 1) * CheckModulear.num_data_every + " AND id<=" + Integer.parseInt(l) * CheckModulear.num_data_every);
                long difference1 = current_page_datanum1 - CheckModulear.normaldata2_num;
                ret[1] = db2.query("SELECT " + "*" + " FROM normaldata3 where id>0 AND id<=" + Integer.parseInt(String.valueOf(difference1)));
                status = 2;
                return status;
            }
            long difference1=pagenum1*CheckModulear.num_data_every - CheckModulear.normaldata2_num;
            long current_page_datanum2 = (Integer.parseInt(l) - Integer.parseInt(String.valueOf(pagenum1))) * CheckModulear.num_data_every;
            if (current_page_datanum2 <= CheckModulear.normaldata3_num) {
                ret[0] = db2.query("SELECT " + "*" + " FROM normaldata3 where id>" + (current_page_datanum2 - CheckModulear.num_data_every+difference1) + " AND id<=" + (current_page_datanum2+difference1));
                status = 1;
            } else {
                long pagenum2 = db2.page_num(CheckModulear.normaldata3_num);//保存一张表所需页数
                long pagenum_all1 = pagenum2 + pagenum1;
                if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum_all1))) {
                    ret[0] = db2.query("SELECT " + "*" + " FROM normaldata3 where id>" + (current_page_datanum2 - CheckModulear.num_data_every) + " AND id<=" + current_page_datanum2);
                    long difference2 = current_page_datanum2 - CheckModulear.normaldata3_num;
                    ret[1] = db2.query("SELECT " + "*" + " FROM normaldata4 where id>0 AND id<=" + Integer.parseInt(String.valueOf(difference2)));
                    status = 2;
                    return status;
                }
                long difference2=pagenum2*CheckModulear.num_data_every - CheckModulear.normaldata3_num+difference1;
                long current_page_datanum3 = (Integer.parseInt(l) - Integer.parseInt(String.valueOf(pagenum2)) - Integer.parseInt(String.valueOf(pagenum1))) * CheckModulear.num_data_every;
                if (current_page_datanum3 <= CheckModulear.normaldata4_num) {
                    ret[0] = db2.query("SELECT " + "*" + " FROM normaldata4 where id>" + (current_page_datanum3 - CheckModulear.num_data_every+difference2) + " AND id<=" + (current_page_datanum3+difference2));
                    status = 1;
                } else {
                    long pagenum3 = db2.page_num(CheckModulear.normaldata4_num);//保存一张表所需页数
                    long pagenum_all2 = pagenum3 + pagenum2 + pagenum1;
                    if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum_all2))) {
                        ret[0] = db2.query("SELECT " + "*" + " FROM normaldata4 where id>" + (current_page_datanum3 - CheckModulear.num_data_every) + " AND id<=" + current_page_datanum3);
                        long difference3 = current_page_datanum3 - CheckModulear.normaldata4_num;
                        ret[1] = db2.query("SELECT " + "*" + " FROM normaldata5 where id>0 AND id<=" + Integer.parseInt(String.valueOf(difference3)));
                        status = 2;
                        return status;
                    }
                    long difference3=pagenum3*CheckModulear.num_data_every - CheckModulear.normaldata4_num+difference2;
                    long current_page_datanum4 = (Integer.parseInt(l) - Integer.parseInt(String.valueOf(pagenum3)) - Integer.parseInt(String.valueOf(pagenum2)) - Integer.parseInt(String.valueOf(pagenum1))) * CheckModulear.num_data_every;
                    if (current_page_datanum4 <= CheckModulear.normaldata5_num) {
                        ret[0] = db2.query("SELECT " + "*" + " FROM normaldata5 where id>" + (current_page_datanum4 - CheckModulear.num_data_every+difference3) + " AND id<=" + (current_page_datanum4+difference3));
                        status = 1;
                    }
                    else {
                        long pagenum4 = db2.page_num(CheckModulear.normaldata5_num);//保存一张表所需页数
                        long pagenum_all3 =pagenum4+ pagenum3 + pagenum2 + pagenum1;
                        if (Integer.parseInt(l) == Integer.parseInt(String.valueOf(pagenum_all3))) {
                            ret[0] = db2.query("SELECT " + "*" + " FROM normaldata5 where id>" + (current_page_datanum4 - CheckModulear.num_data_every) + " AND id<=" + current_page_datanum4);
                            status = 1;
                            return status;
                        }
                    }
                }
            }
        }
        return status;
    }
}

