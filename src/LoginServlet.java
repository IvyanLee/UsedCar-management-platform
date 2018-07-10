
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.ConnectLoginDB;



public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        Connection ct;
        PreparedStatement ps;
        ResultSet rs ;
        // 输入的用户名和密码
        String txtUsername;
        String txtPassword;
        // 数据库中存储的用户名和密码
        String myuserword;
        String mypwd;

        // 接收数据
        txtUsername = request.getParameter("txtUsername");
        txtPassword = request.getParameter("txtPassword");

        //与数据库连接
        try {
            ct = ConnectLoginDB.getConnection();
            String sql = "select * from Login where username=? and passwd=? ";
            ps = ct.prepareStatement(sql);
            ps.setString(1, txtUsername);
            ps.setString(2, txtPassword);
            rs = ps.executeQuery();
            if (rs.next()) {
                myuserword = rs.getString(1);
                mypwd = rs.getString(2);
                System.out.println("成功从login数据库的users表中获取到用户名和密码：");
                System.out.println(myuserword + "\t" + mypwd + "\t");
                response.sendRedirect("main.jsp");

            } else {
                System.out.println("没有该用户，请重新输入");
                response.sendRedirect("Login.jsp");
            }
            ConnectLoginDB.closeConnection(ct);
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
