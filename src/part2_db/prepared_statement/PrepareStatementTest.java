package part2_db.prepared_statement;

import java.sql.*;
import java.util.Scanner;

/**
 * 执行同样的语句
 */
public class PrepareStatementTest {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ex2", "root", "Hqh7263658");
             PreparedStatement preparedStatement = connection.prepareStatement("select password from account where account=?");
             Scanner scanner = new Scanner(System.in);) {
            String user = scanner.nextLine();

            preparedStatement.setString(1, user);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                System.out.println(resultSet.getString(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
