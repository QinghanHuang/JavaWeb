package part2_db.statement;

import java.sql.*;

public class StatementTest {
    public static void main(String[] args) {
        //1.2.
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/huang22200282", "root", "Hqh7263658");
             Statement statement = connection.createStatement();) {
            //3.1执行executeQuery查询
//            ResultSet resultSet = statement.executeQuery("select * from candidate where C_SURNAME like 'h%'");

            //3.2 执行executeUpdate
//            int i = statement.executeUpdate("INSERT INTO candidate VALUES ('1','2','3','3','5');");
//            int i1 = statement.executeUpdate("delete from candidate where c_id='1'");

            //3.3执行execute(通用)
//            boolean execute = statement.execute("select * from candidate");
//            boolean execute = statement.execute("update candidate set c_firstname='qqq' where c_firstname='Qinghan'");
            boolean execute = statement.execute("update candidate set c_firstname='Qinghan' where c_firstname='qqq';");
            System.out.println(execute);


            //4.1
//            while(resultSet.next()){
//                System.out.println(resultSet.getString(3));
//            }

            //4.2
//            System.out.println(i1);


            //4.3通过execute boolean 判断
            if (execute) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {

                    System.out.println(resultSet.getString(1));
                }
            } else {
                int updateCount = statement.getUpdateCount();
                System.out.println(updateCount);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

