package team.web;

import java.io.IOException;
import java.io.PrintWriter;
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
import team.model.User;

@WebServlet("/UeditorServlet")
public class UeditorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UeditorServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		Date date = new Date();
		String content = request.getParameter("editorValue");
		String title = request.getParameter("title");
		int type_id = Integer.parseInt(request.getParameter("type"));
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println(user.getId());
		
		if(content != null&&title!=null&&(type_id==1||type_id==2)) {
			ArticleInfo info = new ArticleInfo();
			ArticleDAO dao = new ArticleDAO();
			info.setTitle(title);
			info.setContent(content);
			info.setPub_date(date);
			/*根据类型名称查找类型id*/
			info.setArticletype_id(type_id);
			/*根据用户名称查找用户id*/
			info.setUser_id(user.getId());
			/*将数据保存在数据库中*/
			try {
				dao.add(info);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			response.setHeader("refresh","1;url=refer.jsp");
		System.out.println("保存文本");
		}else {
			out.println("输入的文本内容不能为空，请重新输入！");
			response.setHeader("refresh", "1;url=editor.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
