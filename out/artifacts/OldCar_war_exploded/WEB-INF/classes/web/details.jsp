<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ page import="Bean.AgainCar"%>
<%@ page import="Dao.AgainCarDao"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>Details page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script>
        function firm() {
            alert("预约成功！");
            if(confirm("你现在要去查看一下预约了哪些车么？"))
            {
                location.href="yuyue.jsp";
            }
        }

    </script>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style type="text/css">
        div{
            float:left;
            margin-left: 30px;
            margin-right:30px;
            margin-top: 5px;
            margin-bottom: 5px;
        }
        div dd{
            margin:0px;
            font-size:10pt;
        }
        div dd.dd_name
        {
            color:blue;
        }
        div dd.dd_city
        {
            color:#000;
        }
    </style>
</head>

<body>
<h1>商品详情</h1>
<hr>
<center>
    <table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
        <tr>
            <!-- 商品详情 -->
            <%
                AgainCarDao againCarDao1 = new AgainCarDao();
                AgainCar car1 = againCarDao1.getItemsByID(Integer.parseInt(request.getParameter("carid")));
                if(car1 != null)
                {
            %>

            <td width="70%" valign="top">
                <table>
                    <tr>
                        <td rowspan="4"><img src="img/<%=car1.getPicture()%>" width="200" height="160"/></td>
                    </tr>
                    <tr>
                        <td><B>车名:<%=car1.getCarName()%></B></td>
                    </tr>
                    <tr>
                        <td>行驶公里数:<%=car1.getHasRun()%> KM</td>
                    </tr>
                    <tr>
                        <td>总价:￥<%=car1.getTotalPrice()%></td>
                    </tr>
                    <tr>
                        <td><img src="img/yuyue.png" width="80" height="30" border="1.5"  alt="预约看车" onclick="firm()">&nbsp;&nbsp; <img src="img/kanjia.png" width="80" height="30" border="1.5" alt="砍价"></td>
                    </tr>
                    <tr>
                        <td>首付:￥<%=car1.getFirstPrice()%></td>
                    </tr>
                    <tr>
                        <td>购买日期：<%=car1.getBuyDate()%></td>
                    </tr>
                    <tr>
                         <td>联系电话: <%=car1.getConnectNumber()%></td>
                    </tr>
                </table>
            </td>
            <%
                }
            %>


        </tr>
    </table>
</center>
</body>
</html>
