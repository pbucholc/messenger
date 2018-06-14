package nm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDatabase {
    private final static String DBURL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7242901";
    private final static String DBUSER = "sql7242901";
    private final static String DBPASS = "RiRiT1Ybri";
    private final static String DBDRIVER = "com.mysql.jdbc.Driver";


    public static boolean logIn(String login, String password) {

        String selectQuery = "select login from user where login='"+login+"' and password='"+password+"';";

        boolean succeed = true;
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(DBDRIVER).newInstance();
            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            if(!resultSet.next())
                succeed = false;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            succeed = false;
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return succeed;
    }

    public static boolean signUp(String login, String password) {

        String selectQuery = "select login from user where login='"+login+"';";
        String insertQuery = "insert into user (id, login, password) values"
                + " (NULL, '"+login+"', '"+password+"');";

        boolean succeed = true;
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(DBDRIVER).newInstance();
            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            if(resultSet.next())
                succeed = false;
            else
                statement.executeUpdate(insertQuery);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            succeed = false;
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return succeed;
    }
}