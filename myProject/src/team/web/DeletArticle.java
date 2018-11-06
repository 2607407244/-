package team.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.dao.ArticleDAO;

@WebServlet("/DeletArticle")
public class DeletArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DeletArticle() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		ArticleDAO dao = new ArticleDAO();
		int i = 0;
		try {
			i = dao.deletArticle(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(i==0) {
			System.out.println("删除失败！");
			response.setHeader("refresh", "1;url=self-Text.jsp");
		}else {
			System.out.println("删除成功！");
			response.setHeader("refresh", "1;url=self-Text.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
