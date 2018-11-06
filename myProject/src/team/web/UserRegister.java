package team.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import team.dao.UserDAOImpl;
import team.model.User;

@WebServlet("/doRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserRegister() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String qq = request.getParameter("qq");
		String info = request.getParameter("info");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(pwd);
		user.setEmail(email);
		user.setPhone(tel);
		user.setQq(qq);
		user.setInfo(info);
		UserDAOImpl userdao = new UserDAOImpl();
		try {
			userdao.add(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("user", username);
		request.getRequestDispatcher("/home.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
