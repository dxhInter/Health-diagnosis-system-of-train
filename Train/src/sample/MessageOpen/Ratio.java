package sample.MessageOpen;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.util.ArrayList;
import java.util.HashMap;

public class Ratio {

    public static HashMap<String, Float> map=new HashMap<>();

    //节点A系数
    public static final float Node1_1=2000;
    public static final float Node1_2=1000;
    public static final float Node1_3=1000;


    public static final float Node1_4=1000;
    public static final float Node1_5=1000;
    //B
    public static final float Node2_1=1000;
    public static final float Node2_2=1000;
    public static final float Node2_3=1000;
    public static final float Node2_4=20000;
    public static final float Node2_5=20000;
    public static final float Node2_6=2000;

    public static final float Node3_1=30000;
    public static final float Node3_2=5000;
    public static final float Node3_3=5000;
    public static final float Node3_4=1;
    public static final float Node3_5=1;

    public static final float Node4_1=5000;
    public static final float Node4_2=20000;
    public static final float Node4_3=30000;
    public static final float Node4_4=5000;
    public static final float Node4_5=5000;

    public static final float Node5_1=1;
    public static final float Node5_2=1;
    public static final float Node5_3=1;
    public static final float Node5_4=1;
    public static final float Node5_5=1;
    public static final float Node5_6=1;
    public static final float Node5_7=1;

    public static final float Node6_1=1;

    public Ratio(){
        setmap();
    }
    private void setmap(){
        map.put(CheckModulear.A1_analog1,Node1_1);
        map.put(CheckModulear.A1_analog2,Node1_2);
        map.put(CheckModulear.A1_analog3,Node1_3);
        map.put(CheckModulear.A1_analog4,Node1_4);
        map.put(CheckModulear.A1_analog5,Node1_5);

        map.put(CheckModulear.A2_analog1,Node2_1);
        map.put(CheckModulear.A2_analog2,Node2_2);
        map.put(CheckModulear.A2_analog3,Node2_3);
        map.put(CheckModulear.A2_analog4,Node2_4);
        map.put(CheckModulear.A2_analog5,Node2_5);
        map.put(CheckModulear.A2_analog6,Node2_6);

        map.put(CheckModulear.A3_analog1,Node3_1);
        map.put(CheckModulear.A3_analog2,Node3_2);
        map.put(CheckModulear.A3_analog3,Node3_3);
        map.put(CheckModulear.A3_analog4,Node3_4);
        map.put(CheckModulear.A3_analog5,Node3_5);

        map.put(CheckModulear.A4_analog1,Node4_1);
        map.put(CheckModulear.A4_analog2,Node4_2);
        map.put(CheckModulear.A4_analog3,Node4_3);
        map.put(CheckModulear.A4_analog4,Node4_4);
        map.put(CheckModulear.A4_analog5,Node4_5);

        map.put(CheckModulear.A5_analog1,Node5_1);
        map.put(CheckModulear.A5_analog2,Node5_2);
        map.put(CheckModulear.A5_analog3,Node5_3);
        map.put(CheckModulear.A5_analog4,Node5_4);
        map.put(CheckModulear.A5_analog5,Node5_5);
        map.put(CheckModulear.A5_analog6,Node5_6);
        map.put(CheckModulear.A5_analog7,Node5_7);

        map.put(CheckModulear.A6_analog1,Node6_1);
    }
    public static HashMap<String, Float> getMap() {
        return map;
    }
}
