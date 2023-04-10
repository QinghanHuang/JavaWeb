package part5_junit_log.junit_test;

import org.junit.*;

/**
 *  1.使用Assert的静态方法assert判断test是否成功(期望,获得的运行数据)
 *  2.常用方法: assertEquals(),assertArrayEquals(),assertTrue()
 *  3.@Before 可以添加前置操作,比如连接数据库等等,每次调用test方法都会调用before
 *  4.@After 同理,比如关闭资源等
 */
public class JunitTest {
    @Before
    public void before(){
        System.out.println("Things before test!");
    }

    @Test
    public void test(){
        System.out.println("test body");
        int i=2+2;
        Assert.assertEquals(4,i);
        int[] arr={1,2,3};
        Assert.assertArrayEquals(new int[]{1,2,3},arr);
        boolean flag=true;
        Assert.assertTrue(flag);
    }

    @After
    public void after(){
        System.out.println("Things after test");
    }
}
