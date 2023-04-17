package sample.MessageOpen;

import java.io.IOException;
import java.math.BigInteger;

public class DataTypeExchange {

    public static byte[] intToByteArray(int i) {
        byte[] result = new byte[4];
        result[0] = (byte)((i >> 24) & 0xFF);
        result[1] = (byte)((i >> 16) & 0xFF);
        result[2] = (byte)((i >> 8) & 0xFF);
        result[3] = (byte)(i & 0xFF);
        return result;
    }
    public static int byteArrayToInt(byte[] bytes) {
        int value=0;
        for(int i = 0; i < 4; i++) {
            int shift= (3-i) * 8;
            value +=(bytes[i] & 0xFF) << shift;
        }
        return value;
    }
    //无符号整数的转换
    public static long getUnsignedInt(int num){
        return num &0xFFFFFF;
    }
    public static int  getUnsignedShort(short num){
        return num &0xFFFF;
    }
    public static int getUnsignedByte(byte num){
        return num &0x0FF;
    }
    //byte 转为32位无符号整数用long存储
    public static long getUInt32(byte[] bytes) throws IOException {
        long value = bytes[0] & 0xFF;
        value |= (bytes[1] << 8) & 0xFFFF;
        value |= (bytes[2] << 16) & 0xFFFFFF;
        value |= (bytes[3] << 24) & 0xFFFFFFFF;
        return value;
    }
    public static int getHeight4(byte data){//获取高四位
        int height;
        height = ((data & 0xf0) >> 4);
        return height;
    }

    public static int getLow4(byte data){//获取低四位
        int low;
        low = (data & 0x0f);
        return low;
    }
    public static int unsignedByteToInt(byte b) {
        return (int) b & 0xFF;
    }
    int HexValue(char a)
    {
        a-=48;
        if(a>9)a-=7;
        return a;
    }
    //
    int HexStrValue(char str[])
    {
        int v=0;
        for(int ii=0 ;ii<str.length; ii++) {
            v <<= 4;
            v += HexValue(str[ii]);
        }
        return v;
    }
    //包含正数 hex->float(32位)
    public static float hexToTenz(String changeData){
        return Float.intBitsToFloat(Integer.parseInt(changeData,16));
    }
    //包含负数 hex->float(32位)
    public static float hexToTenf(String changeData){
        return Float.intBitsToFloat(new BigInteger(changeData, 16).intValue());
    }
}
