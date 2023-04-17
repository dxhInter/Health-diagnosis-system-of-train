package sample.UdpService;

import sample.Database.DBOperate;
import sample.FileFounction.ForFile;
import sample.FileFounction.StringChange;
import sample.Homepage.homeController;
import sample.MessageOpen.ParseMessage;

import java.io.IOException;
import java.net.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

public class UdpService extends Thread {
    private homeController hc;
    private String ip;
    private  int port;
    public UdpService(homeController hc,String ip,int port)
    {
        this.hc=hc;
        this.ip=ip;
        this.port=port;
    }
    public void startsrever()
    {
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//        try {
//           // init();
//            while(true){
//                try {
//                    byte[] buffer = new byte[1024 * 64]; // 缓冲区
//                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
//                    receive(packet);
//                    new Thread(new ServiceImpl(packet,hc)).start();
//                } catch (Exception e) {
//                }
//                //Thread.sleep(1 * 1000);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    /**
     * 接收数据包，该方法会造成线程阻塞
     * @return
     * @throws Exception
     * @throws IOException
     */
    public static DatagramPacket receive(DatagramPacket packet) throws Exception {
        try {
            datagramSocket.receive(packet);
            return packet;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * 将响应包发送给请求端
     //* @param bt
     * @throws IOException
     */
    public static void response(DatagramPacket packet) {
        try {
            datagramSocket.send(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //数据server转发至其他设备UDP
    public static  void send(byte[] bt) {
        byte[] buffer = new byte[1024 * 64]; // 缓冲区
        DatagramPacket packet = null;
        try {
            packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("localhost"), 6);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        packet.setData(bt);
        try {
            DatagramSocket ds=new DatagramSocket();
            ds.send(packet);
            ds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 初始化连接
     * @throws SocketException
     */
    public void init(){
        try {
            socketAddress = new InetSocketAddress(ip, port);
            datagramSocket = new DatagramSocket(socketAddress);
            datagramSocket.setSoTimeout(5 * 1000);
            System.out.println("服务端已经启动");
            hc.setconsole("服务端启动成功"+"\n");
        } catch (Exception e) {
            //datagramSocket = null;
            System.err.println("服务端启动可能已经启动....");
            hc.setconsole("服务端启动可能已经启动或者启动失败！"+"\n");
            e.printStackTrace();
            hc.setconsole( e.toString()+"\n");
            hc.setconsole( "请检查ip设置是否有问题？"+"\n");
            this.stop();
        }
    }
    private static InetSocketAddress socketAddress = null; // 服务监听个地址
    private static DatagramSocket datagramSocket = null; // 连接对象

    @Override
    public void run() {
        while(true){
            try {
                byte[] buffer = new byte[1024 * 64]; // 缓冲区
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                receive(packet);
                new Thread(new ServiceImpl(packet,hc)).start();
            } catch (Exception e) {
            }finally {

            }
            //Thread.sleep(1 * 1000);
        }
    }
}
/**
 * @说明 打印收到的数据包，并且将数据原封返回，中间设置休眠表示执行耗时
 */
class ServiceImpl implements Runnable {
    private DatagramPacket packet;
    private homeController hc;
    private StringChange str_change=new StringChange();
    public ServiceImpl(DatagramPacket packet,homeController hc){
        this.packet = packet;
        this.hc=hc;
    }
    public void run() {
        try {
            byte[] bt = new byte[packet.getLength()];
            System.arraycopy(packet.getData(), 0, bt, 0, packet.getLength());
            //System.out.println(packet.getAddress().getHostAddress() + "：" + packet.getPort() + "：" + Arrays.toString(bt));
            //hc.setconsole(packet.getAddress().getHostAddress() + "：" + packet.getPort() + "：" + Arrays.toString(bt)+"\n");
            //ForFile.createFile("test_log",packet.getAddress().getHostAddress() + "：" + packet.getPort() + "：" + Arrays.toString(bt));
            if(bt.length>=1204){
                //hc.setconsole("接受数据帧正常！！！\n");
                String s=new String(bt,"ascii");
                //String s="0101000003FF14080E1217300000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003AFC01C03BE0D0803BC1C6C03ADBAD00BA0E9B800000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003AFC01C03BE0D0803BC1C6C03ADBAD00BA0E9B800000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003AFC01C03BE0D0803BC1C6C03ADBAD00BA0E9B800000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003AFC01C03BE0D0803BC1C6C03ADBAD00BA0E9B800000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003AFC01C03BE0D0803BC1C6C03ADBAD00BA0E9B8000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
                System.out.println("******"+s);
                //ForFile.createFile("test_log",packet.getAddress().getHostAddress() + "：" + packet.getPort()+":"+s);
                ParseMessage pm=new ParseMessage(s,hc);
                hc.setconsole("接受 "+pm.getHeadInfo().getMessage_id()+"号 数据帧正常\n");
                DBOperate db2=new DBOperate(hc);
                Date date = new Date();
                Timestamp timeStamep = new Timestamp(date.getTime());
                System.out.println(timeStamep);
                if(hc.op>1000)
                {
                    hc.op=0;
                }
                hc.op++;
               // Timestamp timeStamep=pm.gettimestep();
                int x=hc.decideTable();//判断当前数据应插入原表，还是插入其他表
                switch (x){
                    case 1:
                        db2.insert_normaldata1(timeStamep,pm);
                        break;
                    case 2:
                        db2.insert_normaldata2(timeStamep,pm);
                        break;
                    case 3:
                        db2.insert_normaldata3(timeStamep,pm);
                        break;
                    case 4:
                        db2.insert_normaldata4(timeStamep,pm);
                        break;
                    case 5:
                        db2.insert_normaldata5(timeStamep,pm);
                        break;
                    default:
                        System.err.print("判断应插入的表出现错误!\n");
                }
//                for(int i=0;i<5;i++)
//                {
//                    //db2.add_nomal1(pm.getNodeByteInfo()[i].getUno(),timeStamep,pm.getHeadInfo());
//                    if(homeController.getAlways_switch()==1&&homeController.op%4==0) {
//                        hc.adddataEchart(timeStamep.toString(), pm.getNodeByteInfo()[i].getUno());
//                    }
//                }
            }else {

                hc.setconsole("接受数据帧包字节数不够！！！\n");
            }
//            byte[] bt1={48,49,39};
//            UdpService.send(bt1);
            //Thread.sleep(1 * 1000); // 5秒才返回，标识服务端在处理数据
            // 设置回复的数据，原数据返回，以便客户端知道是那个客户端发送的数据
            //packet.setData(bt);
            //UdpService.response(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            hc=null;
            packet=null;
            System.out.println("释放资源");
        }
    }
}
