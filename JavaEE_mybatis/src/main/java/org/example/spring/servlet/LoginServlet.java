package org.example.spring.servlet;

import org.example.spring.model.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println("66666666666666");
        String userName=req.getParameter("username");

        String password=req.getParameter("password");

        String type=req.getParameter("gettype");

        System.out.println(userName);
        System.out.println(password);

        DbUtil db= new DbUtil();
        Role role=new Role(userName,password,type);
        DAO dao=new DAO();

        try {
            Connection con=db.getCon();
            if(dao.login(con, role)!=null) {
                resp.sendRedirect("func.jsp");
            }else {
                resp.setContentType("text/html; charset=UTF-8");
                resp.getWriter().print("<html><body><script type='text/javascript'>alert('用户名密码不一致');window.location='index.jsp'</script></body></html>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}