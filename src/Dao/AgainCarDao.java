package Dao;

import Bean.AgainCar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AgainCarDao {

    //获得所有商品的信息
    public ArrayList<AgainCar> getAllCars() throws ParseException {

        Connection conn = null;
        //sql语句对象
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<AgainCar> list = new ArrayList<AgainCar>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");


        try {
            conn = ConnectCarDB.getConnection();
            String sql = "SELECT * FROM AgainCar;";
            stmt = conn.prepareStatement(sql);
            //获得一个数据集
            rs = stmt.executeQuery();
            while (rs.next()) {
                AgainCar againcar = new AgainCar();
                againcar.setCarId(rs.getInt("carid"));
                againcar.setCarName(rs.getString("carname"));
                againcar.setBuyDate(sdf.parse(rs.getString("buydate")));
                againcar.setHasRun(rs.getDouble("hasrun"));
                againcar.setTotalPrice(rs.getDouble("totalprice"));
                againcar.setFirstPrice(rs.getDouble("firstprice"));
                againcar.setConnectNumber(rs.getString("connectnumber"));
                againcar.setPicture(rs.getString("picture"));
                list.add(againcar);
            }

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {

            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }


    }

    //根据汽车id获取汽车信息

    public AgainCar getItemsByID(int carid) throws ParseException {
        Connection conn = null;
        //sql语句对象
        PreparedStatement stmt = null;
        ResultSet rs = null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");


        try {
            conn = ConnectCarDB.getConnection();
            String sql = "SELECT * FROM AgainCar WHERE carid=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,carid);
            //获得一个数据集
            rs = stmt.executeQuery();
            if (rs.next()) {
                AgainCar againcar = new AgainCar();
                againcar.setCarId(rs.getInt("carid"));
                againcar.setCarName(rs.getString("carname"));
                againcar.setBuyDate(sdf.parse(rs.getString("buydate")));
                againcar.setHasRun(rs.getDouble("hasrun"));
                againcar.setTotalPrice(rs.getDouble("totalprice"));
                againcar.setFirstPrice(rs.getDouble("firstprice"));
                againcar.setConnectNumber(rs.getString("connectnumber"));
                againcar.setPicture(rs.getString("picture"));
                return againcar;
            }

            else
            {   return  null;}

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {

            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }


    }




}
