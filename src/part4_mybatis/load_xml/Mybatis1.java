package part4_mybatis.load_xml;

import org.apache.ibatis.session.*;
import org.junit.Test;
import part4_mybatis.load_xml.mapper.AccountMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class Mybatis1 {
    /**
     * 总体: SqlSessionFactoryBuilder--(1-1)-->SqlSessionFactory --(1-N)-->SqlSession
     * 1.   获得SqlSessionFactoryBuilder
     * new SqlSessionFactoryBuilder()
     * 2.   获得 SqlSessionFactory
     * sqlSessionFactoryBuilder.build(文件输入流-mybatis设置的xml文件));
     * 3.   获得 sqlSession (可以自动关闭 用 try with resource)
     * SqlSessionFactory.openSession(false开启事务)
     * 4.   创建数据库映射的类 ,这里是Account
     * 5.   创建一个mapper,把sql语句映射成 select id
     * 6.   在mybatis设置的xml文件中添加这个 mapper
     * <mapper url="file:test/mapper/accountTest.xml"/>
     *
     * 7.执行sql操作
     *      selectList()
     *
     */
    @Test
    public void loadXMLTest() throws FileNotFoundException {
        //1.
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //2.
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(new FileInputStream("mybatis-config.xml"));

        //3.false开启事务
        try (SqlSession sqlSession = sqlSessionFactory.openSession(false);) {
            //7.执行sql操作
            List<Account> accounts = sqlSession.selectList("selectAllAccount");
            for(Account a:accounts){
                System.out.println(a);
            }
            Account account1=sqlSession.selectOne("selectOneAccount","eee");
            System.out.println(account1);

        }
    }

    /**
     * 使用工具类封装 获取sqlSession的方法
     */
    @Test
    public void mybatisUtilTest(){
        SqlSession session = MybatisUtil.getSession(true);
        List<Account> selectAllAccount = session.selectList("selectAllAccount");
        selectAllAccount.forEach(System.out::println);
    }

    /**
     * 使用接口绑定mapper
     * 1.创建接口 用namespace绑定mapper.xml
     * 2.获得接口的实现类 (动态代理获得)
     *      sqlSession.getMapper(AccountMapper.class)
     * 3.通过接口的方法执行
     */
    @Test
    public void mapperInterfaceTest(){
        //  1.获得sqlSession
        SqlSession sqlSession = MybatisUtil.getSession(true);

        //  2.获得接口的实现类(动态代理获得)
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        System.out.println(accountMapper.getClass().getName());

        //3. 调用接口的实现类,执行sql
        List<Account> accounts = accountMapper.selectAllAccount();
        accounts.forEach(System.out::println);



    }


}
