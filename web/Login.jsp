<%--
  Created by IntelliJ IDEA.
  User: hilary
  Date: 7/7/18
  Time: 1:11 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");

%>


<html>
<head>
    <base href="<%=basePath%>">
    <title>Login</title>
    <title>登录</title>

    <link rel="stylesheet" href="css/login.css">

</head>
<body>
<div class="wrapper">
    <div class="form">
        <form name="loginForm" action="LoginServlet" method="post">
            <table>
                <tr>
                    <td>用户名：</td>
                    <td><input type="text" name="txtUsername"
                                class="input" placeholder="请输入用户名(hilary)" />
                    </td>
                </tr>

                <tr>

                    <td>密码：</td>
                    <td><input type="password" name="txtPassword"
                               class="input" placeholder="请输入密码(hilary123)" />
                    </td>
                </tr>

                <tr>
                    <td colspan="2" align="center"><input type="submit"
                                                          value="登录" class="input login" />
                    </td>
                </tr>
            </table>
        </form>

        <div class="divider">
            <br>
            <br>
            ——————<span>第三方登录</span>—————
        </div>

        <!-- 页底开始 -->
        <br>
        <br>
        <footer>
            <p>Copyright 2018@Hilary</p>
        </footer>
    </div>

    <!-- 页底结束 -->
</div>


</body>
</html>
