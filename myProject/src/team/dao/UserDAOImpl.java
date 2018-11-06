package team.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import team.db.DBUtils;
import team.model.User;

public class UserDAOImpl implements UserDAO {
	private QueryRunner runner = null;//查询运行器
	     public UserDAOImpl(){
	         runner = new QueryRunner();
	     }
	     
	    //方法：向数据库中添加一条记录
	     @Override
	    public void add(User p) throws SQLException {
	         String sql = "insert into t_user(username,password,email,tel,qq,info)values(?,?,?,?,?)";
	         runner.update(DBUtils.getConnection(), sql, p.getUsername(), p.getPassword(),p.getEmail(),p.getPhone(),p.getQq(),p.getInfo());
	     }
	
	     //方法：根据id向数据库中修改某条记录
	     @Override
	     public void update(User p) throws SQLException {
	         String sql = "update t_user set password=?,email=?,tel=?,qq=?,info=? where username=?";
	         runner.update(DBUtils.getConnection(), sql,p.getPassword(),p.getEmail(),p.getPhone(),p.getQq(),p.getInfo(),p.getUsername());
	     }
	 
	     //方法：根据id删除数据库中的某条记录
	     @Override
	     public void delete(String name) throws SQLException {
	         String sql = "delete from t_user where username=?";
	         runner.update(DBUtils.getConnection(), sql, name);
	     }
	     
	     
	      //方法：使用BeanHandler查询一个对象    
	     @Override
	     public User findByName(String username) throws SQLException {
	         String sql = "select * from t_user where username=?";
	         User p = runner.query(DBUtils.getConnection(), sql, new BeanHandler<User>(User.class),username);
	         return p;
	     }
	 
	     //方法：使用BeanListHandler查询所有对象
	     @Override
	     public List<User> findAll() throws SQLException {
	         String sql = "select * from t_user";
	         List<User> persons = runner.query(DBUtils.getConnection(), sql, new BeanListHandler<User>(User.class));
	         return persons;
	     }
	     
	     //方法：使用ScalarHandler查询一共有几条记录
	     @Override
	     public long personCount()throws SQLException{
	         String sql = "select count(id) from t_user";
	         return runner.query(DBUtils.getConnection(),sql, new ScalarHandler<Long>());
	     }
}
