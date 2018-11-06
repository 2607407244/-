package team.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import team.db.DBUtils;
import team.model.*;

public class ArticleDAO {
	private QueryRunner runner = null;
	public ArticleDAO() {
		runner = new QueryRunner();
	}
	
	/*  像数据库中插入文章 */
	public void add(ArticleInfo p) throws SQLException{
		String sql = "insert into t_article(title,content,pub_date,user_id,articletype_id)values(?,?,?,?,?)";
		runner.update(DBUtils.getConnection(),sql,p.getTitle(),p.getContent(),p.getPub_date(),p.getUser_id(),p.getArticletype_id());
	}
	
	/*根据种类名称查找种类id*/
	public int findTypeId(String type) throws SQLException{
		String sql = "select id from t_articleType where type=?";
		int id = runner.update(DBUtils.getConnection(),sql,new BeanListHandler<ArticleType>(ArticleType.class),type);
		return id;
	}
	
	/*根据用户名查找用户id*/
	public int findUserId(String username) throws SQLException{
		String sql = "select id from t_user where username=?";
		int id = runner.update(DBUtils.getConnection(),sql,new BeanListHandler<User>(User.class),username);
		return id;
	}
	
	/* 查询数据库所有的文章数据 */
	public List<ArticleInfo> findAll() throws SQLException{
		List<ArticleInfo> list= null;
		String sql = "select title,content,pub_date,username,type from t_user "
				+ "join t_article on t_user.id=t_article.user_id "
				+ "join t_articletype on t_article.articletype_id=t_articletype.id";
		list = runner.query(DBUtils.getConnection(),sql,new BeanListHandler<ArticleInfo>(ArticleInfo.class));
		return list;
	}
	
	/*根据文章类型的id查询这一类型的所有文章*/
	public List<ArticleInfo> findAll(int type_id) throws SQLException{
		List<ArticleInfo> list= null;
		String sql = "select title,content,pub_date,username,type from t_user "
				+ "join t_article on t_user.id=t_article.user_id "
				+ "join t_articletype on t_article.articletype_id=t_articletype.id where t_articletype.id=?";
		list = runner.query(DBUtils.getConnection(),sql,new BeanListHandler<ArticleInfo>(ArticleInfo.class),type_id);
		return list;
	}
	
	/*根据作者的名字查询数据库中这个作者的所有文章*/
	public List<ArticleInfo> findAll(String username) throws SQLException{
		List<ArticleInfo> list= null;
		String sql = "select title,content,pub_date,username,type,t_article.id from t_user "
				+ "join t_article on t_user.id=t_article.user_id "
				+ "join t_articletype on t_article.articletype_id=t_articletype.id where t_user.username=?";
		list = runner.query(DBUtils.getConnection(),sql,new BeanListHandler<ArticleInfo>(ArticleInfo.class),username);
		return list;
	}
	
	/*根据输入的文字进行全局模糊查询 */
	public List<ArticleInfo> fuzzyFind(String serach) throws SQLException{
		List<ArticleInfo> list = null;
		String sql = "select username,type,title,content,pub_date from t_user " 
				+"join t_article on t_user.id=t_article.user_id "
				+ "join t_articletype on t_article.articletype_id=t_articletype.id "
				+ "where concat(title,content,username) like '%"+serach+"%'";
		list = runner.query(DBUtils.getConnection(),sql,new BeanListHandler<ArticleInfo>(ArticleInfo.class));
		return list;
	}
	
	/*在某一类类型为id的文章中根据输入的字符串进行模糊查找*/
	public List<ArticleInfo> fuzzyFind(int id,String serach) throws SQLException{
		List<ArticleInfo> list = null;
		String sql = "select username,type,title,content,pub_date from t_user " 
				+"join t_article on t_user.id=t_article.user_id "
				+ "join t_articletype on t_article.articletype_id=t_articletype.id "
				+ "where concat(title,content,username) like '%"+serach+"%' and t_articletype.id=?";
		list = runner.query(DBUtils.getConnection(),sql,new BeanListHandler<ArticleInfo>(ArticleInfo.class),id);
		/*Object[] pram = new Object[] {use,pas};*/
		return list;
	}
	
	/*对于某一个作者的文章中，根据输入的字符串进行模糊查询*/
	public List<ArticleInfo> fuzzyFind(String username,String serach) throws SQLException{
		List<ArticleInfo> list = null;
		String sql = "select username,type,title,content,pub_date from t_user " 
				+"join t_article on t_user.id=t_article.user_id "
				+ "join t_articletype on t_article.articletype_id=t_articletype.id "
				+ "where concat(title,content,username) like '%"+serach+"%' and t_user.username=?";
		list = runner.query(DBUtils.getConnection(),sql,new BeanListHandler<ArticleInfo>(ArticleInfo.class),username);
		return list;
	}
	/*根据文章id进行查询*/
	public ArticleInfo findById(int id) throws SQLException{
		ArticleInfo a = new ArticleInfo();
		String sql ="select title,content,pub_date,username,type from t_user "
				+ "join t_article on t_user.id=t_article.user_id "
				+ "join t_articletype on t_article.articletype_id=t_articletype.id where t_article.id=?";
		a = runner.query(DBUtils.getConnection(),sql, new BeanHandler<ArticleInfo>(ArticleInfo.class),id);
		return a;
	}
	/*修改文章*/
	public int modArticle(int id,String title,String content,Date date) throws SQLException{
		String sql = "update t_article set title=?,content=?,pub_date=? where id=?";
		Object[] pram = new Object[] {title,content,date,id};
		int i = runner.update(DBUtils.getConnection(),sql,pram);
		return i;
	}
	/*根据文章的id删除数据*/
	public int deletArticle(int id) throws SQLException{
		String sql = "delete from t_article where id=?";
		int i = runner.update(DBUtils.getConnection(),sql,id);
		return i;
	}
}
