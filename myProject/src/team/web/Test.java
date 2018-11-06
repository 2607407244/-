package team.web;

import java.sql.SQLException;
import java.util.List;

import team.dao.ArticleDAO;
import team.model.ArticleInfo;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ArticleDAO dao = new ArticleDAO();
		
		int i = dao.deletArticle(8);
		if(i==1)
			System.out.println("删除成功！");
		else
			System.out.println("删除失败！");
		
	}
}
