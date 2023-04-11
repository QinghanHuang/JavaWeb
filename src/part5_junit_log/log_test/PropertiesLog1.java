package part5_junit_log.log_test;

import org.junit.Test;

import java.io.*;
import java.util.Properties;
import java.util.logging.*;

/**
 * 1.通过LogManager,读取配置文件输入流,来配置
 * 2.
 */
public class PropertiesLog1 {
    public static void main(String[] args) throws IOException {

        //1.读取配置
        LogManager logManager = LogManager.getLogManager();
        logManager.readConfiguration(new FileInputStream("test/log.properties"));

        //尝试输出

        Logger logger = Logger.getLogger(PropertiesLog1.class.getName());

        logger.log(Level.SEVERE, "严重的错误");
        logger.log(Level.WARNING, "警告的内容");
        logger.log(Level.INFO, "普通的信息");
        logger.log(Level.CONFIG, "级别低于普通信息");
        logger.log(Level.FINE, "好");



    }
    @Test
    public void test() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("test/log.properties"));
        System.out.println(properties);

    }
}
