package sample.FileFounction;

import sample.MessageOpen.CheckModulear;
import sample.MessageOpen.Ratio;
import sample.echartpackage.Option_Ratio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ReadInfoForRtio {


    public  static void readFile02() throws IOException {
        FileInputStream fis = new FileInputStream("D:/logForUdp/Ratio.txt");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        String[] arrs = null;
        while ((line = br.readLine()) != null) {
            if(line.contains("analog")) {
                arrs = line.split("=");
                HashMap<String, Float> map = Ratio.getMap();
                map.replace(arrs[0], Float.parseFloat(arrs[1]));
                System.out.println(arrs[0] + " : " + arrs[1]);
            }
            if(line.contains("num_data_every"))
            {
                arrs = line.split("=");
                CheckModulear.num_data_every=Integer.parseInt(arrs[1]);
                System.out.println(arrs[0] + " : " + arrs[1]);
            }
            if(line.contains("openautoAxis")){
                arrs = line.split("=");
                if(Integer.parseInt(arrs[1])==1){
                    Option_Ratio.setOpenautoAxis(true);
                }else {
                    Option_Ratio.setOpenautoAxis(false);
                }
                System.out.println(arrs[0] + " : " + arrs[1]);
            }
            if(line.contains("max_Y")){
                arrs = line.split("=");
                Option_Ratio.setMax_Y(Integer.parseInt(arrs[1]));
                System.out.println(arrs[0] + " : " + arrs[1]);
            }
            if(line.contains("min_Y")){
                arrs = line.split("=");
                Option_Ratio.setMin_Y(Integer.parseInt(arrs[1]));
                System.out.println(arrs[0] + " : " + arrs[1]);
            }

        }
        br.close();
        isr.close();
        fis.close();

    }
}
