package sample.echartpackage;

public class Option_Ratio {
    private static boolean openautoAxis=true;
    private static int max_Y=500;
    private static int min_Y=0;
    public static boolean isOpenautoAxis() {
        return openautoAxis;
    }

    public static void setOpenautoAxis(boolean openautoAxis) {
        Option_Ratio.openautoAxis = openautoAxis;
    }

    public static int getMax_Y() {
        return max_Y;
    }

    public static void setMax_Y(int max_Y) {
        Option_Ratio.max_Y = max_Y;
    }

    public static int getMin_Y() {
        return min_Y;
    }

    public static void setMin_Y(int min_Y) {
        Option_Ratio.min_Y = min_Y;
    }

}
