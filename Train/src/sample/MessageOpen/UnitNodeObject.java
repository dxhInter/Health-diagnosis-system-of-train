package sample.MessageOpen;

public class UnitNodeObject {
    public ModularNodeObject mn[];
    public UnitNodeObject()
    {
        mn=new ModularNodeObject[8];
        for(int i=0;i<8;i++)
        {
            mn[i]=new ModularNodeObject(i);
        }
    }
    public void setNode(int id,float nodeif[])
    {
        //id代表节点id
        mn[id].setA_analog(nodeif);
    }
    public void setNode(int id,float nodeif[],long node_num)
    {
        //id代表节点id
        mn[id].setA_analog(nodeif);
        mn[id].setA_analog_num(node_num);
    }
    public void setNode(int id,long node_num)
    {
        //id代表节点id
        mn[id].setA_analog_num(node_num);
    }
    public ModularNodeObject getmn(int i){
        return mn[i];
    }
}
