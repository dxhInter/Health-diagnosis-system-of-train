package sample.MessageOpen;

public class ErrNumberObject {
    private short err_code;
    private short err_Confidence;
    private short err_advice;
    public ErrNumberObject(){
    }

    public short getErr_advice() {
        return err_advice;
    }

    public short getErr_code() {
        return err_code;
    }

    public short getErr_Confidence() {
        return err_Confidence;
    }

    public void setErr_advice(short err_advice) {
        this.err_advice = err_advice;
    }

    public void setErr_code(short err_code) {
        this.err_code = err_code;
    }

    public void setErr_Confidence(short err_Confidence) {
        this.err_Confidence = err_Confidence;
    }
}
