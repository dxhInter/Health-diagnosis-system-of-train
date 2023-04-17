package sample.MessageOpen;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class CheckModulear {
    public static List<String> list;
    public static List<String> list_hasnode5;
    //控制每个节点模拟量或者数字量的赋值
    public static final String A1="111111110";
    public static final int A_1=8;
    public static final int A_1_2=0;
    public static final String A2="111111100";
    public static final int A_2=7;
    public static final int A_2_2=0;
    public static final String A3="111111110";
    public static final int A_3=8;
    public static final int A_3_2=0;
    public static final String A4="111111110";
    public static final int A_4=8;
    public static final int A_4_2=0;
    public static final String A5="111100001";
    public static final int A_5=4;
    public static final int A_5_2=1;
    public static final String A6="000000001";
    public static final int A_6=0;
    public static final int A_6_2=1;
    public static final String A7="111000001";
    public static final int A_7=3;
    public static final int A_7_2=1;
    public static final String A8="000000000";
    public static final int A_8=0;
    public static final int A_8_2=0;

    //解析udp格式
    public static final int Head_id=44;
    public static final int node_len=232;
    public static final int[] node_A={0,40,88,128,168,224,232};
    public static final int[] node_A_len={5,6,5,5,7,1};
    public static final int[] node_A_len_true={5,6,5,5,0,1};
    public static final int point_len=8;
    public static final int node_A1_len=0;
    public static final int node_A2_len=40;
    public static final int node_A3_len=88;
    public static final int node_A4_len=128;
    public static final int node_A5_len=168;
    public static final int node_A6_len=224;
    public static final int node_A7_len=232;


    public static int num_data_every=20;
    public static int data_num=500;//每张表最多存储的数据量
    public static long normaldata_num;//表1的数据量
    public static long normaldata2_num;//表2的数据量
    public static long normaldata3_num;//表3的数据量
    public static long normaldata4_num;//表4的数据量
    public static long normaldata5_num;//表5的数据量
    public static int isFirstOpen;//用于判断系统是否第一次开启

    //节点名称
    public static final String car_unit_id="car_unit_id";
    public static final String time_data="time";
    public static final String A1_analog1="A1_analog1";
    public static final String A1_analog2="A1_analog2";
    public static final String A1_analog3="A1_analog3";
    public static final String A1_analog4="A1_analog4";
    public static final String A1_analog5="A1_analog5";
    public static final String A1_analog6="A1_analog6";
    public static final String A1_analog7="A1_analog7";
    public static final String A1_analog8="A1_analog8";

    public static final String A2_analog1="A2_analog1";
    public static final String A2_analog2="A2_analog2";
    public static final String A2_analog3="A2_analog3";
    public static final String A2_analog4="A2_analog4";
    public static final String A2_analog5="A2_analog5";
    public static final String A2_analog6="A2_analog6";
    public static final String A2_analog7="A2_analog7";
    public static final String A2_analog8="A2_analog8";

    public static final String A3_analog1="A3_analog1";
    public static final String A3_analog2="A3_analog2";
    public static final String A3_analog3="A3_analog3";
    public static final String A3_analog4="A3_analog4";
    public static final String A3_analog5="A3_analog5";
    public static final String A3_analog6="A3_analog6";
    public static final String A3_analog7="A3_analog7";
    public static final String A3_analog8="A3_analog8";

    public static final String A4_analog1="A4_analog1";
    public static final String A4_analog2="A4_analog2";
    public static final String A4_analog3="A4_analog3";
    public static final String A4_analog4="A4_analog4";
    public static final String A4_analog5="A4_analog5";
    public static final String A4_analog6="A4_analog6";
    public static final String A4_analog7="A4_analog7";
    public static final String A4_analog8="A4_analog8";

    public static final String A5_analog1="A5_analog1";
    public static final String A5_analog2="A5_analog2";
    public static final String A5_analog3="A5_analog3";
    public static final String A5_analog4="A5_analog4";
    public static final String A5_analog5="A5_analog5";
    public static final String A5_analog6="A5_analog6";
    public static final String A5_analog7="A5_analog7";
    public static final String A5_analog8="A5_analog8";

    public static final String A6_analog1="A6_analog_num";

    public static final String A7_analog_num="A7_analog_num";
    public static final String A7_analog1="A7_analog1";
    public static final String A7_analog2="A7_analog2";
    public static final String A7_analog3="A7_analog3";


    public CheckModulear(){
        list =new ArrayList<>();
        list_hasnode5=new ArrayList<>();
        list.add(A1_analog1);
        list.add(A1_analog2);
        list.add(A1_analog3);
        list.add(A1_analog4);
        list.add(A1_analog5);

        list.add(A2_analog1);
        list.add(A2_analog2);
        list.add(A2_analog3);
        list.add(A2_analog4);
        list.add(A2_analog5);
        list.add(A2_analog6);

        list.add(A3_analog1);
        list.add(A3_analog2);
        list.add(A3_analog3);
        list.add(A3_analog4);
        list.add(A3_analog5);

        list.add(A4_analog1);
        list.add(A4_analog2);
        list.add(A4_analog3);
        list.add(A4_analog4);
        list.add(A4_analog5);

        list.add(A6_analog1);

        list_hasnode5.add(A1_analog1);
        list_hasnode5.add(A1_analog2);
        list_hasnode5.add(A1_analog3);
        list_hasnode5.add(A1_analog4);
        list_hasnode5.add(A1_analog5);

        list_hasnode5.add(A2_analog1);
        list_hasnode5.add(A2_analog2);
        list_hasnode5.add(A2_analog3);
        list_hasnode5.add(A2_analog4);
        list_hasnode5.add(A2_analog5);
        list_hasnode5.add(A2_analog6);

        list_hasnode5.add(A3_analog1);
        list_hasnode5.add(A3_analog2);
        list_hasnode5.add(A3_analog3);
        list_hasnode5.add(A3_analog4);
        list_hasnode5.add(A3_analog5);

        list_hasnode5.add(A4_analog1);
        list_hasnode5.add(A4_analog2);
        list_hasnode5.add(A4_analog3);
        list_hasnode5.add(A4_analog4);
        list_hasnode5.add(A4_analog5);

        list_hasnode5.add(A5_analog1);
        list_hasnode5.add(A5_analog2);
        list_hasnode5.add(A5_analog3);
        list_hasnode5.add(A5_analog4);
        list_hasnode5.add(A5_analog5);
        list_hasnode5.add(A5_analog6);
        list_hasnode5.add(A5_analog7);

        list_hasnode5.add(A6_analog1);
    }

    public static List<String> getList() {
        return list;
    }

    public static List<String> getList_hasnode5() {
        return list_hasnode5;
    }
}
