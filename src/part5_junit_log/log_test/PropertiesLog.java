package part5_junit_log.log_test;

import java.io.*;
import java.net.URL;
import java.util.Properties;

/**
 * 1.读取properties的两种方式
 * 2.读取和写出
 */

public class PropertiesLog {
    public static void main(String[] args) throws IOException {
        // 方法1;:classLoader
//        ClassLoader classLoader = PropertiesLog.class.getClassLoader();
//        InputStream resource = classLoader.getResourceAsStream("log.properties");
//
        //方法2:fis
        FileInputStream fileInputStream = new FileInputStream("src/log.properties");

        Properties properties = new Properties();
        properties.load(fileInputStream);

        //读取
//        System.out.println(properties.getProperty("name"));
//        System.out.println(properties.getProperty("desc"));

//        properties.setProperty("id","001");
//        System.out.println(properties);

        //写出
//        properties.store(new FileWriter("test/log.properties"), "Comments");

//        保存为XML格式
        properties.storeToXML(new FileOutputStream("test/log.properties"), "xml");


    }
}
