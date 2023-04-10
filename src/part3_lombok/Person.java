package part3_lombok;

import lombok.*;
import org.junit.Test;

import java.lang.reflect.Type;

@Data
public class Person {

    Type type;
    int id;
    int age;
    String name;
    @Test
    public void test() throws ClassNotFoundException {
        Class aClass = Class.forName("part3_lombok.Person");
        System.out.println(aClass.getName());

    }
}
