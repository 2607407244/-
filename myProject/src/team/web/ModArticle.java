package team.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.dao.ArticleDAO;
import team.model.ArticleInfo;

/**
 * Servlet implementation class ModArticle
 */
@WebServlet("/ModArticle")
public class ModArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ModArticle() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int i=0;
		HttpSession session = request.getSession();
		int id = (int)session.getAttribute("id");
		String title = request.getParameter("title");
		String content = request.getParameter("editorValue");
		Date date = new Date();
		ArticleDAO dao = new ArticleDAO();
		ArticleInfo info = new ArticleInfo();
		try {
			i = dao.modArticle(id, title, content, date);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("refer.jsp").forward(request, response);
		if(i==1) {
			System.out.println("修改文章成功！");	
		}else {
			System.out.println("修改文章失败！");
			request.getRequestDispatcher("self-Text.jsp").forward(request, response);
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
