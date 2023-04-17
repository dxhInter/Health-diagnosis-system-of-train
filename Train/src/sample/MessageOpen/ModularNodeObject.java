package sample.MessageOpen;

public class ModularNodeObject {
    private int id;
    private float A_analog[];
    private long A_analog_num;
    public ModularNodeObject(int id){
        this.id=id;
    }

    public float[] getA_analog() {
        return this.A_analog;
    }

    public void setA_analog(float[] a_analog) {
        this.A_analog = a_analog;
    }

    public long getA_analog_num() {
        return A_analog_num;
    }

    public int getId() {
        return id;
    }


    public void setA_analog_num(long a_analog_num) {
        A_analog_num = a_analog_num;
    }
}
