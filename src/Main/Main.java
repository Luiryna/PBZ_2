package Main;

import View.MainWindow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static Connection conn;

    public static Connection returnCon() {
        return conn;
    }


    public static Connection connect() throws SQLException {
        final String url = "jdbc:postgresql://localhost/lab2";
        final String user = "postgres";
        final String password = "12384500";
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        connect();
        Statement statement = conn.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM production_area");
//        while(resultSet.next()){
//
//            int id = resultSet.getInt(1);
//            String name = resultSet.getString(2);
//            System.out.printf("%d %s \n", id, name);
//        }
        MainWindow mainWindow = new MainWindow();
    }

}
