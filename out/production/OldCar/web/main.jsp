<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
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

    <title>Main Page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <style type="text/css">
        hr{
            border-color:#F7F7F7;
        }
        div{
            float:left;
            margin: 10px;
        }
        div dd{
            margin:0px;
            font-size:10pt;
        }
        div dd.dd_name
        {
            color:blue;
        }
        div dd.dd_miles
        {
            color:#000;
        }
    </style>

</head>

<body>
<h1>商品展示</h1>
<hr>

<center>
    <table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
        <tr>
            <td>
                <%--商品循环开始--%>
                <%
                    AgainCarDao againCarDao = new AgainCarDao();
                    ArrayList<AgainCar> list = againCarDao.getAllCars();
                    for(int i =0;i<list.size();i++)
                    {
                    AgainCar car = list.get(i);
                %>
                <div>
                    <dl>
                        <dt>
                            <a href="details.jsp?carid=<%=car.getCarId()%>"><img src="img/<%=car.getPicture()%>" width="120" height="90" border="1" alt="Jeep"/></a>
                        </dt>
                        <dd class="dd_name"><%=car.getCarName()%></dd>
                        <dd class="dd_miles">行驶公里数:<%=car.getHasRun()%> &nbsp;&nbsp;总价:￥ <%=car.getTotalPrice()%></dd>
                    </dl>
                </div>

                <%--商品循环结束--%>
                <%
    }
                %>

            </td>
        </tr>
    </table>
</center>


</body>
</html>
