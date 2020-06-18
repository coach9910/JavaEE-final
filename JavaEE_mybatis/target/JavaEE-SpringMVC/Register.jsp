<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <link rel="stylesheet" type="text/css" href="css/css2.css"/>
</head>
<body>
<form name="form2" action="RegisterServlet" method="post">
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

    <input class=input_3 type="button" onclick="Register()" value="注册" />
</form>
<script type="text/javascript" >
    /**
     * @return {boolean}
     */
    function Register(){
        if(form2.username.value==''){
            alert('用户名不能为空！');
            return false;
        }
        if(form2.password.value==''){
            alert('密码不能为空！');
            return false;
        }
        form2.submit();
        //window.location.href = 'index.jsp';



    }</script>
</body>
</html>

