package part2_db.login;

import java.lang.module.Configuration;
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class LoginTest {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ex2", "root", "Hqh7263658");
             Statement statement = connection.createStatement();
             Scanner scanner = new Scanner(System.in)) {
            System.out.print("Input user:");
            String user = scanner.nextLine();
            System.out.print("Input pssword:");
            String pass = scanner.nextLine();

            ResultSet resultSet = statement.executeQuery("select password from account where account='" + user + "';");

            boolean flag=false;
            while(resultSet.next()){
                if(resultSet.getString(1).equals(pass)){
                    System.out.println("Login Success");
                    flag=true;
                    break;
                }
            }
            if(flag==false){
                System.out.println("Login failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
