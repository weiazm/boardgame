<%@ page language="java" import="com.symon.sun.boardgame.dao.PersonDao" pageEncoding="utf-8" %>
<%@page import="com.symon.sun.boardgame.entity.Person,java.util.List" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content=""/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- CSS -->
    <link href="css/font-awesome.css" rel="stylesheet"><!-- Font-awesome-CSS -->
    <link href="css/style2.css" rel='stylesheet' type='text/css'/><!-- style.css -->
    <!-- //CSS -->
    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Josefin+Sans:100,100i,300,300i,400,400i,600,600i,700,700i&amp;subset=latin-ext"
          rel="stylesheet">
    <link href="http://fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700&amp;subset=cyrillic,latin-ext,vietnamese"
          rel="stylesheet">
    <!-- Fonts -->
</head>
<body>
<div id="particles-js"></div>
<div class="main-w3layouts">
    <h1>桌游社积分榜</h1>
    <div class="w3layouts-newsletter">
        <table border="1">
            <tr class="table-title">
                <td>名次</td>
                <td>姓名</td>
                <td>狼人积分</td>
                <td>能力者积分</td>
                <td>村民积分</td>
                <td>总积分</td>
            </tr>
            <%
                PersonDao dao = new PersonDao();
                List<Person> list = dao.readPersonTable();
                for (int i = 0; i < list.size(); i++) {
                    Person p = list.get(i);
            %>
            <tr>
                <td><%=i + 1 %>
                </td>
                <td><%=p.getName() %>
                </td>
                <td><%=p.getWolf_score() %>
                </td>
                <td><%=p.getGod_score() %>
                </td>
                <td><%=p.getVillager_score() %>
                </td>
                <td><%=p.getTotal_score() %>
                </td>

            </tr>

            <% } %>
        </table>
        <!--<div class="clear"></div>-->
    </div>
    <!--<div class="footer-w3l">
        <p class="agileinfo">Copyright &copy; 2017.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
    </div>-->
</div>

<!-- Js-Files -->
<script src="js/particles.js"></script>
<script src="js/app.js"></script>
<!-- //Js-Files -->

</body>
</html>
