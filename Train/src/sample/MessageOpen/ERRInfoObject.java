package sample.MessageOpen;

public class ERRInfoObject {
    private short rule_version;
    private short time_ms;
    private short time_m_s;
    private short time_day_h;
    private short time_y_m;
    private short train_num;
    private short system_num;
    private short err_num;
    private short element_code;
    private  ErrNumberObject err[];
    public ERRInfoObject(ErrNumberObject err[]){
        this.err=err;
    }

    public short getElement_code() {
        return element_code;
    }

    public short getErr_num() {
        return err_num;
    }

    public short getRule_version() {
        return rule_version;
    }

    public short getSystem_num() {
        return system_num;
    }

    public short getTime_day_h() {
        return time_day_h;
    }

    public short getTime_m_s() {
        return time_m_s;
    }

    public short getTime_ms() {
        return time_ms;
    }

    public short getTime_y_m() {
        return time_y_m;
    }

    public short getTrain_num() {
        return train_num;
    }

    public void setElement_code(short element_code) {
        this.element_code = element_code;
    }

    public void setErr_num(short err_num) {
        this.err_num = err_num;
    }

    public void setErr(ErrNumberObject[] err) {
        this.err = err;
    }

    public void setRule_version(short rule_version) {
        this.rule_version = rule_version;
    }

    public void setSystem_num(short system_num) {
        this.system_num = system_num;
    }

    public void setTime_day_h(short time_day_h) {
        this.time_day_h = time_day_h;
    }

    public void setTime_m_s(short time_m_s) {
        this.time_m_s = time_m_s;
    }

    public void setTime_ms(short time_ms) {
        this.time_ms = time_ms;
    }

    public void setTime_y_m(short time_y_m) {
        this.time_y_m = time_y_m;
    }

    public void setTrain_num(short train_num) {
        this.train_num = train_num;
    }

    public ErrNumberObject[] getErr() {
        return err;
    }
}
