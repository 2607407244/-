package team.model;

import java.io.Serializable;
import java.util.Date;

public class ArticleInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String title;
	private String content;
	private Date pub_date; 
	private int user_id;
	private int articletype_id;
	private String username;
	private String type;
	
	public ArticleInfo() {
		pub_date = new Date();
	}
	
	public void setId(int _id) {
		this.id = _id;
	}
	public int getId() {
		return id;
	}
	public void setTitle(String _title) {
		this.title = _title;
	}
	public String getTitle() {
		return title;
	}
	public void setContent(String _content) {
		this.content = _content;
	}
	public String getContent() {
		return content;
	}
	public void setPub_date(Date date) {
		this.pub_date = date;
	}
	public Date getPub_date() {
		return pub_date;
	}
	public void setUser_id(int _user_id) {
		this.user_id = _user_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setArticletype_id(int _articletype_id) {
		this.articletype_id = _articletype_id;
	}
	public int getArticletype_id() {
		return articletype_id;
	}
	public void setUsername(String _username) {
		this.username = _username;
	}
	public String getUsername() {
		return username;
	}
	public void setType(String _type) {
		this.type = _type;
	}
	public String getType() {
		return type;
	}

}
