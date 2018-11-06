package team.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.dao.UserDAO;
import team.dao.UserDAOImpl;
import team.model.User;

@WebServlet("/Dologin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UserLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("hello");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDAO userdao = new UserDAOImpl();
		
		try {
			User user = new User();
			user = userdao.findByName(username);
			if(user!=null) {
				if(password.equals(user.getPassword())) { 
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					System.out.println("验证成功！");
					request.getRequestDispatcher("home.jsp").forward(request, response);
				}else {
					out.println("密码错误，请重新登录...");
					response.setHeader("refresh","3;url=login.jsp");
				}
			}else {
				 out.println("请在注册之后进行登录...");
				 response.setHeader("refresh","3;url=register.jsp");//3秒之后转到注册页面
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
