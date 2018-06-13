package utils;

import constant.dbconstant.DBConstant;

import java.sql.*;

public class UserBaseDBUtil {
    static Connection connection;
    static Statement statement;
    ResultSet resultSet;
    public static void connectToMySQLDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            connection = DriverManager.getConnection(DBConstant.CONNECTION_URL, DBConstant.NAME, DBConstant.PASS);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getLogin(){
        try {
            resultSet = statement.executeQuery("select * from userbase.userdata");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
