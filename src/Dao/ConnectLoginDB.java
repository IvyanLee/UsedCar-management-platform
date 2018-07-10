package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectLoginDB {

    public static Connection getConnection() throws SQLException {


        Connection connlogin = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/Login";

            connlogin = DriverManager.getConnection(url,"root","liyanyan123");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connlogin;

    }

    public static void closeConnection(Connection connlogin){
        try {
            connlogin.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static  void main(String args[] ){

        try {
            Connection connLogin = ConnectLoginDB.getConnection();
            if(connLogin != null)
            {
                System.out.println("连接成功");
            }
            else{
                System.out.println("连接异常");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }


}


