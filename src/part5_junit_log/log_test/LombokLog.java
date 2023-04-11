package part5_junit_log.log_test;

import lombok.extern.java.Log;

import java.util.logging.Level;

@Log(topic="qqq")
public class LombokLog {
    public static void main(String[] args) {
        System.out.println(log.getName());
        log.log(Level.INFO,"www");
    }
}
