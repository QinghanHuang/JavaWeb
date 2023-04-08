package part2_db.db_object;

import java.sql.*;

public class DbClassTest {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/huang22200282", "root", "Hqh7263658");
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery("select * from candidate");

            while (resultSet.next()){
                Person person=new Person(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
                System.out.println(person);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
