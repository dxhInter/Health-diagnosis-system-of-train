package sample.echartpackage;

import java.util.ArrayList;
import java.util.List;

public class AccessData {
    //日期
    private String date;
    //访问量
    private double nums;

    // 构造函数
    public AccessData(String date, double nums) {

        this.date = date;
        this.nums = nums;
    }
    // getter,setter方法


    /**
     * 模拟获取数据
     *
     * @return 此处可按照自定义的数据类型
     */
    public static List<AccessData> getWeekData() {
        List<AccessData> list = new ArrayList<AccessData>(7);
//        list.add(new AccessData("09-16", 4));
//        for(int i=0;i<10000;i++)
//        {
//            if(i%4==0){
//                list.add(new AccessData("09-16 "+i, 100));
//            }else{
//                list.add(new AccessData("09-17 "+i, 300));
//            }
//        }
        return list;
    }

    public double getNums() {
        return nums;
    }

    public String getDate() {
        return date;
    }
}