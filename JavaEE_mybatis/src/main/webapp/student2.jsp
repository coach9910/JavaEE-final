<%@ page import="org.example.spring.model.Homework" %>
<%@ page import="org.example.spring.jdbc.HomeworkJdbc" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: win7
  Date: 2020/3/9
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StudentHomework</title>
</head>
<body>
<table align="center" width="960" border="1"
       bgcolor="black" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#7fffd4" height="60">
        <td>作业编号</td>
        <td>作业标题</td>
    </tr>
    <%
        List<Homework> list = HomeworkJdbc.selectAllh();
        if(null == list || ((List) list).size() <= 0){
            out.print("None data.");
        }else {
            for (Homework sh : list){
    %>
    <tr align="center" bgcolor="white" height="60">
        <td><%=sh.getHno()%></td>
        <td><%=sh.getHtitle()%></td>
        <td><input type = "button" value = "选择该作业" style="width:180px;height: 60px;font-size:16px" onclick = "window.location.href = 'handin.jsp?hno=<%=sh.getHno()%>&htitle=<%=sh.getHtitle()%>'"></td>
    </tr>
<%--    <script type="text/javascript">--%>
<%--        $(function(){--%>
<%--            $("#tab").on("click", ":button", function(event){--%>
<%--                $("#text").val($(this).closest("tr").find("td").eq(0).text());--%>
<%--            });--%>
<%--        });--%>
<%--    </script>--%>
    <%
            }
        }
    %>
</table>
</body>
</html>
