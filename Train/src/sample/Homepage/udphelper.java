package sample.Homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.*;
import java.util.*;

public class udphelper implements Initializable {
    public homeController hc;
    @FXML
    TextField text_ip,text_port;
    @FXML
    Button open_udp;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        open_udp.setDisable(true);
        new Thread(new GetIpHost(this)).start();;
    }

    public int getIntPort(String port){
        int s=0;
        int l= port.length();
        char[] b=port.toCharArray();
        for(int i=0;i<l;i++)
        {
            s*=10;
            s+=b[i]-'0';
        }
        return s;
    }
    public void open_udp_action(ActionEvent actionEvent) {

        if(text_ip.getText().equals(""))
        {
            hc.setconsole("设置的ip和端口号为："+"localhost"+":"+getIntPort(text_port.getText())+"\n");
            hc.openUdpService("localhost",getIntPort(text_port.getText()));
        }else {
            hc.setconsole("设置的ip和端口号为："+text_ip.getText()+":"+getIntPort(text_port.getText())+"\n");
            hc.openUdpService(text_ip.getText(), getIntPort(text_port.getText()));
        }
        Stage stage = (Stage) open_udp.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

}
class GetIpHost implements Runnable{
    udphelper uh;
    homeController hc;
    private String ip="";
    public GetIpHost(udphelper uh)
    {
        this.uh=uh;
        hc=uh.hc;
    }
    public GetIpHost(homeController hc)
    {
        this.hc=hc;
    }
    @Override
    public void run() {
        try {
            if(uh!=null) {
                uh.hc.setconsole("***获取ip中，请稍后.....\n");
                ip = getLocalIp4Address().get().getHostAddress();
                if (ip.equals("0.0.0.0")) {
                    uh.text_ip.setText(ip);
                    uh.hc.setconsole("***请检查网络,ip为：0.0.0.0\n");
                } else {
                    uh.text_ip.setText(ip);
                    uh.hc.setconsole("***获取ip成功****\n");
                }
                uh.open_udp.setDisable(false);
            }else {
                hc.setconsole("***获取ip中，请稍后.....\n");
                ip = getLocalIp4Address().get().getHostAddress();
                hc.setconsole("获取的ip为 "+ip+"\n");
                if (ip.equals("0.0.0.0")) {
                    hc.setconsole("***请检查网络,ip为：0.0.0.0\n");
                } else {
                    hc.setconsole("***获取ip成功*****\n");
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    public static Optional<Inet4Address> getLocalIp4Address() throws SocketException {
        final List<Inet4Address> ipByNi = getLocalIp4AddressFromNetworkInterface();
        if (ipByNi.isEmpty() || ipByNi.size() > 1) {
            final Optional<Inet4Address> ipBySocketOpt = getIpBySocket();
            if (ipBySocketOpt.isPresent()) {
                return ipBySocketOpt;
            } else {
                return ipByNi.isEmpty() ? Optional.empty() : Optional.of(ipByNi.get(0));
            }
        }
        return Optional.of(ipByNi.get(0));
    }
    public static List<Inet4Address> getLocalIp4AddressFromNetworkInterface() throws SocketException {
        List<Inet4Address> addresses = new ArrayList<>(1);
        Enumeration e = NetworkInterface.getNetworkInterfaces();
        if (e == null) {
            return addresses;
        }
        while (e.hasMoreElements()) {
            NetworkInterface n = (NetworkInterface) e.nextElement();
            if (!isValidInterface(n)) {
                continue;
            }
            Enumeration ee = n.getInetAddresses();
            while (ee.hasMoreElements()) {
                InetAddress i = (InetAddress) ee.nextElement();
                if (isValidAddress(i)) {
                    addresses.add((Inet4Address) i);
                }
            }
        }
        return addresses;
    }

    /**
     * 过滤回环网卡、点对点网卡、非活动网卡、虚拟网卡并要求网卡名字是eth或ens开头
     *
     * @param ni 网卡
     * @return 如果满足要求则true，否则false
     */
    private static boolean isValidInterface(NetworkInterface ni) throws SocketException {
        return !ni.isLoopback() && !ni.isPointToPoint() && ni.isUp() && !ni.isVirtual()
                && (ni.getName().startsWith("eth") || ni.getName().startsWith("ens"));
    }

    /**
     * 判断是否是IPv4，并且内网地址并过滤回环地址.
     */
    private static boolean isValidAddress(InetAddress address) {
        return address instanceof Inet4Address && address.isSiteLocalAddress() && !address.isLoopbackAddress();
    }

    private static Optional<Inet4Address> getIpBySocket() throws SocketException {
        try (final DatagramSocket socket = new DatagramSocket()) {
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            if (socket.getLocalAddress() instanceof Inet4Address) {
                return Optional.of((Inet4Address) socket.getLocalAddress());
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
}
