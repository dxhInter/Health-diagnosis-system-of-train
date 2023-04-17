package sample.FileFounction;


import java.io.*;
import java.util.UUID;
import java.util.HashMap;
import java.util.Map;

public class ForFile {
    //生成文件路径
    private static String path = "D:\\logForUdp\\";

    //文件路径+名称
    private static String filenameTemp;
    /*
     * 创建文件
     * @param fileName  文件名称
     * @param filecontent   文件内容
     * @return  是否创建成功，成功则返回true
     */
    public static void deletelog(String fileName){
        File file=new File(path+fileName+".txt");
        if (file.isFile()) {// 表示该文件不是文件夹
            file.delete();
        } else {
            file.delete();
        }
    }
    public static boolean createFile(String fileName,String filecontent){
        Boolean bool = false;
        File dir = new File(path);
        if (!dir.exists()) {// 判断目录是否存在
            dir.mkdir();
        }
        filenameTemp = path+fileName+".txt";//文件路径+名称+文件类型
        File file = new File(filenameTemp);
        try {
            //如果文件不存在，则创建新的文件
            if(!file.exists()){
                file.createNewFile();
                bool = true;
                System.out.println("success create file,the file is "+filenameTemp);
                //创建文件成功后，写入内容到文件里
                method2(filenameTemp, filecontent+"\n");
            }else {
                method2(filenameTemp, filecontent+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bool;
    }

    /*
     * 向文件中写入内容
     * @param filepath 文件路径与名称
     * @param newstr  写入的内容
     * @return
     * @throws IOException
     */
    public static void method2(String fileName, String content) {
        try {
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean writeFileContent(String filepath,String newstr) throws IOException{
        Boolean bool = false;
        //String filein = newstr+"\r\n";//新写入的行，换行
        String filein = newstr;
        String temp  = "";

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos  = null;
        PrintWriter pw = null;
        try {
            File file = new File(filepath);//文件路径(包括文件名称)
            //将文件读入输入流
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();

            //文件原有内容
            for(int i=0;(temp =br.readLine())!=null;i++){
                buffer.append(temp);
                // 行与行之间的分隔符 相当于“\n”
                buffer = buffer.append(System.getProperty("line.separator"));
            }
            buffer.append(filein);

            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            pw.write(buffer.toString().toCharArray());
            pw.flush();
            bool = true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            //不要忘记关闭
            if (pw != null) {
                pw.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return bool;
    }
    public void inputTXT(String filepath,String newstr) throws IOException {
        Boolean bo;
        bo=writeFileContent(filepath,newstr);
    }

    /**
     * 修改文件内容
     *
     * @param fileName
     * @param oldstr
     * @param newStr
     * @return
     */
    private static boolean modifyFileContent(String fileName, String oldstr, String newStr) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("D:\\logForUdp\\" + fileName, "rw");
            String line = null;
            // 记住上一次的偏移量
            long lastPoint = 0;
            while ((line = raf.readLine()) != null) {
                // 文件当前偏移量
                final long ponit = raf.getFilePointer();
                // 查找要替换的内容
                if (line.contains(oldstr)) {
                    String str = line.replace(oldstr, newStr);
                    System.err.println(str);
                    raf.seek(lastPoint);
                    raf.writeBytes(str);
                }
                lastPoint = ponit;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
    //对txt文件进行修改
    public void changeTXT(String O,String N){
        boolean b=modifyFileContent("datatable.txt",O,N);
    }


    /**
     * 删除文件
     * @param fileName 文件名称
     * @return
     */
    public static boolean delFile(String fileName){
        Boolean bool = false;
        filenameTemp = path+fileName+".txt";
        File file  = new File(filenameTemp);
        try {
            if(file.exists()){
                file.delete();
                bool = true;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return bool;
    }

    //读取txt文件
    public static String readerTxt(String url){
        StringBuffer stringBuffer = new StringBuffer();
        FileReader reader = null;
        BufferedReader br = null;
        try {
            String line;
            reader = new FileReader(url);
            br = new BufferedReader(reader);
            //网友推荐更加简洁的写法
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                stringBuffer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuffer.toString();
    }
    public String readTXT(){
        String a=readerTxt("D:\\logForUdp\\datatable.txt");
        return a;
    }

//    public static void main(String[] args) {
//        createFile("myfile", "hhh");
//    }
}
