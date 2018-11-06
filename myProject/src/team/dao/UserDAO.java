package team.dao;

import java.sql.SQLException;
import java.util.List;

import team.model.User;

public interface UserDAO {
		// 添加方法
	     public void add(User p) throws SQLException;
	 
	    // 更新方法
	     public void update(User p) throws SQLException;
	 
	     // 删除方法
	    public void delete(String name) throws SQLException;
	 
	     // 查找方法
	     public User findByName(String username) throws SQLException;
	 
	    // 查找所有
	     public List<User> findAll() throws SQLException;
	 
	     // 查询有几条记录???
	    public long personCount() throws SQLException;
}
