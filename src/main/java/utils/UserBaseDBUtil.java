package utils;

import constant.dbconstant.DBConstant;
import org.apache.commons.logging.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserBaseDBUtil {
    public static void connectToMySQLDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection(DBConstant.CONNECTION_URL, DBConstant.NAME, DBConstant.PASS)){
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
