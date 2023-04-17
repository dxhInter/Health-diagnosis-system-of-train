package sample.MessageOpen;

import sample.Homepage.homeController;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

public class ParseMessage {
    private String bt_head;
    private String node;
    private NodeByteInfo nodeByteInfo[];
    private HeadInfo headInfo;
    private homeController hc;
    private DataTypeExchange dataTypeExchange;

    //node 节点是批信息
    public ParseMessage(String bt,homeController hc) {
        dataTypeExchange=new DataTypeExchange();
        this.hc=hc;
        this.bt_head = bt.substring(0,CheckModulear.Head_id);
        this.node = bt.substring(CheckModulear.Head_id, CheckModulear.Head_id + 5 * CheckModulear.node_len);
        nodeByteInfo = new NodeByteInfo[5];
        headInfo=new HeadInfo();
        hc.setconsole("解析字符串开始......\n");
        init_head();
        hc.setconsole("解析字符串head成功....\n");
        init_node();
        hc.setconsole("解析字符串节点成功....\n");

    }

    private void init_head() {
        headInfo.setCar_id(dataTypeExchange.HexStrValue(bt_head.substring(0,2).toCharArray()));
        headInfo.setCar_unit_id(dataTypeExchange.HexStrValue(bt_head.substring(2,4).toCharArray()));
        headInfo.setMessage_id(dataTypeExchange.HexStrValue(bt_head.substring(4,12).toCharArray()));
        headInfo.setYear(dataTypeExchange.HexStrValue(bt_head.substring(12,14).toCharArray()));
        headInfo.setMonth(dataTypeExchange.HexStrValue(bt_head.substring(14,16).toCharArray()));
        headInfo.setDay(dataTypeExchange.HexStrValue(bt_head.substring(16,18).toCharArray()));
        headInfo.setHour(dataTypeExchange.HexStrValue(bt_head.substring(18,20).toCharArray()));
        headInfo.setMins(dataTypeExchange.HexStrValue(bt_head.substring(20,22).toCharArray()));
        headInfo.setSecond(dataTypeExchange.HexStrValue(bt_head.substring(22,24).toCharArray()));
        headInfo.setLongitude_1(dataTypeExchange.HexStrValue(bt_head.substring(24,26).toCharArray()));
        headInfo.setLongitude_2(dataTypeExchange.HexStrValue(bt_head.substring(26,28).toCharArray()));
        headInfo.setLongitude_3(dataTypeExchange.HexStrValue(bt_head.substring(28,30).toCharArray()));
        headInfo.setLatitude_1(dataTypeExchange.HexStrValue(bt_head.substring(30,32).toCharArray()));
        headInfo.setLatitude_2(dataTypeExchange.HexStrValue(bt_head.substring(32,34).toCharArray()));
        headInfo.setLatitude_3(dataTypeExchange.HexStrValue(bt_head.substring(34,36).toCharArray()));
    }

    private void init_node() {
       // this.bt_head = Arrays.copyOf(node, CheckModulear.Head_id);
        for (int i = 0; i < 5; i++) {
            nodeByteInfo[i]=new NodeByteInfo();
            nodeByteInfo[i].setNode( this.node.substring(i * CheckModulear.node_len,(i + 1) * CheckModulear.node_len));
            nodeByteInfo[i].get_ele();
        }
    }

    public HeadInfo getHeadInfo() {
        return headInfo;
    }
    public Timestamp gettimestep() throws ParseException {

        String timeStr = "20"+this.headInfo.getYear()+"-"+this.headInfo.getMonth()+"-"+this.headInfo.getDay()+" ";
        String timedady=this.headInfo.getHour()+":"+this.headInfo.getMins()+":"+this.headInfo.getSecond();
        String time=timeStr+timedady;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai")); // 设置北京时区
        Date d = sdf.parse(time);
        //System.out.println(sdf.format(d) + ", " + d.getTime());
//        Date date = new Date();
//        System.out.println(date);
//        date.setYear(this.headInfo.getYear());
//        date.setMonth(this.headInfo.getMonth());
//        date.setDate(this.headInfo.getDay());
//        date.setHours(this.headInfo.getHour());
//        date.setMinutes(this.headInfo.getMins());
//        date.setSeconds(this.headInfo.getSecond());
        Timestamp timeStamep = new Timestamp(d.getTime());
        System.out.println(timeStamep);
        return timeStamep;
    }
    public NodeByteInfo[] getNodeByteInfo() {
        return nodeByteInfo;
    }
}
