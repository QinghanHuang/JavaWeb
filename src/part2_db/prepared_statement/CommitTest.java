package part2_db.prepared_statement;

import java.sql.*;
import java.util.Scanner;

public class CommitTest {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ex2", "root", "Hqh7263658");
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT into account values(?,?)");
             Scanner scanner = new Scanner(System.in);) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, "rrr");
            preparedStatement.setString(2, "333333");
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
            preparedStatement.setString(1, "aaa");
            preparedStatement.setString(2, "333333");
            i = preparedStatement.executeUpdate();
            System.out.println(i);
            preparedStatement.setString(1, "sss");
            preparedStatement.setString(2, "333333");
            i = preparedStatement.executeUpdate();
            System.out.println(i);

            connection.commit();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
