package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectCarDB {

    public static Connection getConnection() throws SQLException {


        Connection connCar = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/AgainCar";

            connCar = DriverManager.getConnection(url,"root","liyanyan123");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connCar;

    }

    public static void closeConnection(Connection connCar){
        try {
            connCar.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static  void main(String args[] ){

        try {
            Connection connCar = ConnectCarDB.getConnection();
            if(connCar != null)
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


