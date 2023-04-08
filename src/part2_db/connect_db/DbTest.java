package part2_db.connect_db;

import java.sql.*;

/**
 * 通过jdbc连接数据库
 */
public class DbTest {
    public static void main(String[] args) {
        //8.0以上的mysql connector已经自动注册驱动

        //1.通过DriverManager获得Connection实例
        //参数是url user password
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/huang22200282", "root", "Hqh7263658");

            //2.通过Connection 对象 获取Statement实例(以上两块放入try()中,为了释放资源)
            Statement statement = connection.createStatement()) {

            //3.通过statement 执行execute 来执行sql语句
            ResultSet resultSet = statement.executeQuery("select * from candidate;");

            //4.使用while(set.next()){} 遍历结果
            while(resultSet.next()){
                System.out.print(resultSet.getString(1)+"\t");
                System.out.print(resultSet.getString(2)+"\t");
                System.out.print(resultSet.getString(3)+"\t");
                System.out.print(resultSet.getString(4)+"\t");
                System.out.print(resultSet.getString(5)+"\t");
                System.out.println();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
