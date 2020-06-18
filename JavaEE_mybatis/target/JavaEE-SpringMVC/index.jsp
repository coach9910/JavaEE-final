<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <link rel="stylesheet" type="text/css" href="css/css.css"/>
</head>
<body>
<form name="form1" action="LoginServlet" method="post">
    <h1>作业管理系统</h1>
    <input class=input_1 id=username size=15  name="username"  placeholder=用户名><br />
    <input class=input_1 id=password type=text size=15 name="password" placeholder=密码><br />

    <span class="radio_box">
               <input type="radio" id="radio_1" name="gettype" value="teacher" checked>
               <label for="radio_1"></label>
              老师
        	</span>
    <span class="radio_box">
               <input type="radio" id="radio_2" name="gettype" value="student">
               <label for="radio_2"></label>
               学生
       		</span><br/>

    <input class=input_3 type="button" onclick="login()" value="登录" />
    <input class=input_3 type="button" onclick="window.location.href='Register.jsp'" value="去注册" />
</form>
<script type="text/javascript" >
    function login(){
    if(form1.username.value==''){
        alert('用户名不能为空！');
        return false;
    }
    if(form1.password.value==''){
        alert('密码不能为空！');
        return false;
    }
    form1.submit();
        if(form1.gettype.value=='teacher'){
            window.location.href = 'teacher.jsp';
        }
        if(form1.gettype.value=='student'){
            window.location.href = 'student.jsp';
        }


}</script>
</body>
</html>

