package sample.echartpackage;

import com.github.abel533.echarts.AxisPointer;
import com.github.abel533.echarts.DataZoom;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.Tooltip;
import com.github.abel533.echarts.axis.AxisLine;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.SplitLine;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.*;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.style.LineStyle;
import sample.Database.DBOperate;
import sample.FileFounction.StringChange;
import sample.MessageOpen.CheckModulear;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sample.echartpackage.get_Table_Data;

public class myLineChart {
    // 用户数据的数据结构，可后面自己定义
    Map<String, ArrayList<AccessData>> lineDatas;
    private StringChange str_change=new StringChange();
    private get_Table_Data getTableData=new get_Table_Data();

    /**
     * 构造函数
     *
     //* @param datas:利用构造函数传入用户的数据
     */
    public myLineChart() {
        // 获取数据
        //this.lineDatas = datas;
    }

    // 将该方法暴露给JavaScript脚本调用
    //@JavascriptInterface
    public String getLineChartOptions() {

        GsonOption option = (GsonOption) creatLineChartOptions("1");
        System.out.println(option.toString());
        return option.toString();
    }

    public String getLineChartO(String l, String l2) throws SQLException {
        GsonOption option = (GsonOption) creatLineChartOptions(l2);
        System.out.println(l + "-----" + l2 + "----" + option.toString());
        return option.toString();
    }

    //获得下一个页面的数据
    public void getdata_Fornode(String l) throws SQLException {
        List<String> list_string = CheckModulear.getList();
        DBOperate db2 = new DBOperate(null);
        ResultSet[] ret=new ResultSet[2];
        int status;
        status=getTableData.get_table_data(db2,l,ret);
       // ResultSet ret = db2.query("SELECT " + "*" + " FROM normaldata limit " + (Integer.parseInt(l) - 1) * CheckModulear.num_data_every + "," + CheckModulear.num_data_every);
//        ResultSet ret = db2.query("SELECT " + "*" + " FROM normaldata where id>=" + (Integer.parseInt(l) - 1) * CheckModulear.num_data_every + " AND id<" + Integer.parseInt(l)*CheckModulear.num_data_every);
        Map<String, ArrayList<AccessData>> param = new HashMap();
        for (int i = 0; i < CheckModulear.getList().size(); i++) {
            ArrayList<AccessData> list_node = new ArrayList<AccessData>();
            param.put(list_string.get(i), list_node);//将指定的键/值对插入到 HashMap 中。
        }
//        while (ret.next()) {
//            for (int i = 0; i < CheckModulear.getList().size(); i++) {
//                ArrayList<AccessData> list_node = param.get(CheckModulear.getList().get(i));
//                list_node.add(new AccessData(ret.getString("time"), Double.parseDouble(ret.getString(list_string.get(i)))));
//                param.put(list_string.get(i), list_node);
//            }
//        }
        if(status==1){
            while (ret[0].next()) {
                for (int i = 0; i < CheckModulear.getList().size(); i++) {
                    ArrayList<AccessData> list_node = param.get(CheckModulear.getList().get(i));
                    list_node.add(new AccessData(ret[0].getString("time"), Double.parseDouble(ret[0].getString(list_string.get(i)))));
                    param.put(list_string.get(i), list_node);
                }
            }
        }
        else if(status==2) {
            for (int a = 0; a < 2; a++) {
                while (ret[a].next()) {
                    for (int i = 0; i < CheckModulear.getList().size(); i++) {
                        ArrayList<AccessData> list_node = param.get(CheckModulear.getList().get(i));
                        list_node.add(new AccessData(ret[a].getString("time"), Double.parseDouble(ret[a].getString(list_string.get(i)))));
                        param.put(list_string.get(i), list_node);
                    }
                }
            }
        }
        setLineDatas(param);
    }

    // 此函数主要是绘 Line 图
    //@JavascriptInterface
    public Option creatLineChartOptions(String str) {

        String[] types = {"信息号1", "信息号2", "信息号3", "信息号4", "信息号5", "信息号6"};
        // 创建Option对象
        GsonOption option = new GsonOption();
        // 设置图标标题，并且居中显示
        option.title().text("节点" + str + "  ").x(X.left);
        // 设置图例，居中显示
        option.legend(types);
        //option.legend().data("信号值").x(X.right).y(Y.top).borderWidth(1);
        // 设置y轴为值轴，并且不显示y轴，最大值设置400，最小值-100
        if(Option_Ratio.isOpenautoAxis()){
            option.yAxis(new ValueAxis()
                    .name("数值")
                    .axisLine(new AxisLine()
                            .show(true)
                            .lineStyle(new LineStyle().width(0)))
                    //.max(500)
                    //.min(-100)
                    .scale(true));
        }else{
            option.yAxis(new ValueAxis()
                    .name("数值")
                    .axisLine(new AxisLine()
                            .show(true)
                            .lineStyle(new LineStyle().width(0)))
                    .max(Option_Ratio.getMax_Y())
                    .min(Option_Ratio.getMin_Y()));

        }
        // 创建类目轴，并且不显示竖着的分割线
        CategoryAxis categoryAxis = new CategoryAxis()
                .splitLine(new SplitLine().show(false))
                .axisLine(new AxisLine().onZero(false));
        // 不显示表格边框，就是围着图标的方框
        option.grid().borderWidth(0);

        //tooltip
        Tooltip tooltip = new Tooltip();
        tooltip.setTrigger(Trigger.axis);
        AxisPointer axisPointer = new AxisPointer();
        axisPointer.setType(PointerType.line);
        axisPointer.show(true);
        tooltip.setAxisPointer(axisPointer);
        option.tooltip(tooltip);

        // 创建Line数据
        // 此处开始使用用户的数据
        for (int i = 0; i < CheckModulear.node_A_len_true[Integer.parseInt(str) - 1]; i++) {
            Line line;
            line = new Line(types[i]).smooth(true);// 三条线，三个对象
            // String type = types[i];
            //line.name(type).stack("总量");
            ArrayList<AccessData> lineData_1 = lineDatas.get(getString_node(str, i));
            for (AccessData lineData : lineData_1) {
                // 增加类目，值为日期
                if (i == 0) {
                    categoryAxis.data(lineData.getDate());
                }
                // 日期对应的数据
                line.data(Math.abs(lineData.getNums()));
            }
            option.dataZoom(getdatazoom(lineDatas.get(CheckModulear.getList().get(i)).size()));
            option.series(line);
        }

        option.xAxis(categoryAxis);
        // 设置数据

        return option;
    }

    public String getString_node(String str, int ll) {
        int k = Integer.parseInt(str);
        int startnode = 0;
        for (int i = 0; i < k - 1; i++) {
            startnode += CheckModulear.node_A_len_true[i];
        }
        return CheckModulear.getList().get(startnode + ll);
    }

    public void setLineDatas(Map<String, ArrayList<AccessData>> lineDatas) {
        this.lineDatas = lineDatas;
    }

    public List<DataZoom> getdatazoom(int len) {
        List<DataZoom> dataZooms = new ArrayList<>();
        DataZoom dataZoom = new DataZoom();
        dataZoom.show(true);
        dataZoom.type(DataZoomType.slider);
        dataZoom.start(1);
        dataZoom.end(99);
        DataZoom dataZoom1 = new DataZoom();
        dataZoom.show(true);
        dataZoom.type(DataZoomType.inside);
        double p_lin = 1;
        if (len > 100) {
            p_lin = (1 - 100.0 / len) * 100;
        }
        dataZoom.start((int) p_lin);
        dataZoom.end(100);
        dataZooms.add(dataZoom);
        dataZooms.add(dataZoom1);
        return dataZooms;
    }
}