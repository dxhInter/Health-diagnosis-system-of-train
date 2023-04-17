package sample.MessageOpen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class NodeByteInfo {
    private float A_analog[];
    private long A_analog_num;
    public String node;
    UnitNodeObject uno;
    private DataTypeExchange dataTypeExchange;
    public NodeByteInfo()
    {
        uno=new UnitNodeObject();
        dataTypeExchange=new DataTypeExchange();
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public void get_ele()
    {
        System.out.println("get_ele");
        int ratio_id=0;//for 系数
        for(int i=0;i<CheckModulear.node_A_len.length;i++)
        {
            A_analog=new float[8];
            int len=0;
            String str=node.substring(CheckModulear.node_A[i],CheckModulear.node_A[i+1]);
            for(int j=0;j<CheckModulear.node_A_len[i];j++)
            {
                float a=dataTypeExchange.hexToTenf(str.substring(j*CheckModulear.point_len,(j+1)*CheckModulear.point_len));
                a=a*Ratio.getMap().get(CheckModulear.getList_hasnode5().get(ratio_id++));
                if(Float.isNaN(a))
                {
                    A_analog[len++]=999999;
                }else{
                    A_analog[len++]=a;
                }

            }
            uno.setNode(i,Arrays.copyOfRange(A_analog,0,len));
        }
    }

    public UnitNodeObject getUno() {
        return this.uno;
    }
}
