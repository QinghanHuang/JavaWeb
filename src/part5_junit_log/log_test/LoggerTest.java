package part5_junit_log.log_test;

import org.junit.Test;

import java.io.IOException;
import java.util.logging.*;

/**
 * 1.Logger.getLogger()获取logger对象(单例模式)
 * 2.7个等级(低于info默认等级的不会输出,除非设置新的handler)
     *      SEVERE（最高值）- 一般用于代表严重错误
     *      WARNING  - 一般用于表示某些警告，但是不足以判断为错误
     *      INFO （默认级别）  -  常规消息
     *      CONFIG
     *      FINE
     *      FINER
     *      FINEST（最低值）
 * 3. 写日志 logger.log(等级,内容)
 */
public class LoggerTest {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(LoggerTest.class.getName());
        //方式一:最普通的输出形式
        logger.info("我是普通的日志");
        //方式二: 不同等级通用的方法
        logger.log(Level.CONFIG,"我是好的日志");
    }

    /**
     * 写日志的级别:
     * 设置 logger.setLevel(Level.CONFIG) 仅仅是设置了 Logger 对象的日志记录级别，
     * 用于过滤掉低于指定级别的日志信息。
     * 输出日志的级别:
     * 而 ConsoleHandler 是一个日志处理器，
     * 用于将 Logger 对象记录的日志信息输出到控制台或其他设备上。
     * handler.setLevel(Level.CONFIG) 用于设置 ConsoleHandler 的日志处理级别，表示只处理高于等于 CONFIG 级别的日志信息。
     */
    @Test
    public void test(){
        Logger logger = Logger.getLogger(LoggerTest.class.getName());

        //1.修改日志的记录级别
        logger.setLevel(Level.CONFIG);

        //2.不使用父日志处理器
        logger.setUseParentHandlers(false);

        //3.使用自定义日志处理器,设置输出的级别(这里是console输出)
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.CONFIG);
        handler.setFormatter(new XMLFormatter());
        logger.addHandler(handler);

        logger.log(Level.SEVERE, "严重的错误", new IOException("我就是错误"));
        logger.log(Level.WARNING, "警告的内容");
        logger.log(Level.INFO, "普通的信息");
        logger.log(Level.CONFIG, "级别低于普通信息");
        logger.log(Level.FINE, "好");


        //默认的打印器
        System.out.println(logger.getParent().getClass());
    }

    /**
     * 1.可以使用new FileHandler("test.log") 输出日志到文件
     * 2.logger.addHandler(fileHandler);此时加上默认的控制台handler 有两个
     * 因此两边会同时记录
     *
     */
    @Test
    public void FileLogTest() throws IOException {
        Logger logger = Logger.getLogger(LoggerTest.class.getName());
        //   append设置true,就是追加内容不是重写,与输出流同理
        FileHandler fileHandler = new FileHandler("test/test.log",true);

        //控制输出的等级  不是记录的等级
        fileHandler.setLevel(Level.WARNING);

        //控制格式,log文件默认xml格式
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);

        logger.log(Level.SEVERE, "严重的错误");
        logger.log(Level.WARNING, "警告的内容");
        logger.log(Level.INFO, "普通的信息");
        logger.log(Level.CONFIG, "级别低于普通信息");
        logger.log(Level.FINE, "好");

        //输出结果,在控制台,>=默认 在log文件>=Warning
    }
    /**
     * 设置过滤器
     * Application --> Logger(控制记录)-->Handler(控制输出,打印或者写入文件)-->Outside
     *
     * 可以在 logger 和handler设置filter
     *
     */
    @Test
    public void FilterTest(){
        Logger logger = Logger.getLogger(LoggerTest.class.getName());

        //  可以用lambda 表达式简写
//        logger.setFilter(record -> record.getMessage().contains("普通"));
        logger.setFilter( new Filter() {
            @Override
            public boolean isLoggable(LogRecord record) {
                if(record.getMessage().contains("aaa")){
                    return true;
                }
                return false;
            }
        });
        logger.log(Level.WARNING, "警告的内容");
        logger.log(Level.INFO, "aaa的信息");
        logger.log(Level.INFO, "普通的信息");

    }
}
