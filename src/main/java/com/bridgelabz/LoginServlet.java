package com.bridgelabz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet(
		description = "Login Servlet Testing",
		urlPatterns = {"/LoginServlet" },
		initParams = {
				@WebInitParam(name = "user",value="Naresh"),
				@WebInitParam(name = "password", value = "Darling")
		}
)*/
public class LoginServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String user = req.getParameter("user");
		String pwd = req.getParameter("pwd");
		
		String userId = "Naresh"; //getServletConfig().getInitParameter("user");
		String password = "Darling"; // getServletConfig().getInitParameter("password");
		
		if(userId.equals(user) && password.equals(pwd)) {
			req.setAttribute("user", user);
			req.getRequestDispatcher("LoginSuccess.jsp").forward(req, res);
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = res.getWriter();
			out.println("<font color = red>Either username or password is wrong.</font>");
			rd.include(req, res);
		}
	}
}
