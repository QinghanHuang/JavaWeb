package part2_db.batch;

import java.sql.*;

/**
 * 在 JDBC 中，addBatch() 和 prepareStatement() 都是用于批处理操作的方法，但是它们的作用和用法是不同的。
 *
 * addBatch() 方法用于将多个 SQL 语句添加到批处理中，它可以在一次批处理中执行多个 SQL 语句，以减少与数据库的通信次数，提高执行效率。
 * addBatch() 方法通常和 Statement 接口一起使用。
 *
 * 而 prepareStatement() 方法则是用于创建预编译 SQL 语句的 PreparedStatement 对象，
 * 它可以重复执行相同的 SQL 语句，并且可以通过设置参数来实现参数化查询，从而提高查询效率。 prepareStatement() 方法通常和 Connection 接口一起使用。
 *
 * 需要注意的是，虽然 addBatch() 方法可以一次执行多个 SQL 语句，但是每个 SQL 语句都必须是独立的，不能有相互依赖的关系。
 * 而 prepareStatement() 方法虽然可以执行多次相同的 SQL 语句，但是它执行的每个 SQL 语句都必须是单独的语句，不能在其中添加多个 SQL 语句。
 */
public class BatchTest {
    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/huang22200282", "root", "Hqh7263658");
        //  注意使用batch,还是使用createStatement()
            Statement statement = connection.createStatement();){
            //statement.addBatch 批量放入缓存
            statement.addBatch("insert into candidate values ('1','2','3','q','5');");
//            statement.addBatch("insert into candidate values ('2','2','3','w','6');");
//            statement.addBatch("insert into candidate values ('3','2','3','e','9');");
//
            statement.addBatch("delete from candidate where c_firstname='2'");

            //statement.executeBatch() 统一执行
            statement.executeBatch();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
