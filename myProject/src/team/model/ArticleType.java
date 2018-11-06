package team.model;

import java.io.Serializable;

public class ArticleType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String type;
	public ArticleType() {
		
	}
	
	public void setId(int _id) {
		this.id = _id;
	}
	public int getId() {
		return id;
	}
	public void setType(String _type) {
		this.type = _type;
	}
	public String getType() {
		return type;
	}

}
