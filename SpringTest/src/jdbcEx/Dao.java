package jdbcEx;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Dao 
{
	private JdbcTemplate t;
	
	public Dao()
	{
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bds.setUsername("root");
		bds.setPassword("root");
		bds.setUrl("jdbc:mysql://localhost:3306/core");
		t = new JdbcTemplate();
		t.setDataSource(bds);
		
		System.out.println("DAO CREATED");
	}
	public Customer singleselect(String custid) 
	{
		System.out.println("In SINGLE SELECT");
		System.out.println(custid);
		//String sql = "select customer from pass where custid='"+custid+"'";
		String sql = "select customer,city,rewards,passwords from pass where custid=?";
		Object[] params = { custid };
		BeanPropertyRowMapper<Customer> bp = new BeanPropertyRowMapper<Customer>(Customer.class);
		Customer c;
		//System.out.println(params);
		try {
			c=t.queryForObject(sql,params,bp);
			//System.out.println(c);
			System.out.println(bp);
		} catch (Exception e) {
			// TODO: handle exception
			c=new Customer();
			c.setCustid("DAC01");
			e.printStackTrace();
		}
		return c;
		
	}
	
	public boolean updateQuery(Customer cc)
	{
		String sql = "update pass set customer=?,passwords=?,rewards=?,city=? where custid=?";
		Object[] para= {cc.getCustomer(),cc.getPasswords(),cc.getRewards(),cc.getCity(),cc.getCustid()};
		int ra  = t.update(sql,para);
		return ra > 0;
		
	}
	
	public boolean insertDb(Customer c)
	{
		String sql ="insert into pass values (?,?,?,?,?)";
		Object[] para = {c.getCustid(),c.getCustomer(),c.getPasswords(),c.getRewards(),c.getCity()};
		int ra  =t.update(sql,para);
		return ra > 0;
	}
	
	public boolean deleteDb(String id)
	{
		String sql = "delete from pass where custid=?";
		Object[] para = {id};
		int ra = t.update(sql,para);
		return ra > 0;
		
	}
	
	public List<Customer> multiSelect(String city)

	{
		String sql = "select customer,custid,rewards,passwords from pass where city=?";
		Object[] params = {city};
		List<Customer> cust = null;
		BeanPropertyRowMapper<Customer> cp = new BeanPropertyRowMapper<Customer>(Customer.class);
		try {
			cust = t.query(sql,params,cp);
		} catch (DataAccessException e) {
			cust = new ArrayList<>();
			e.printStackTrace();
			// TODO: handle exception
		}
		return cust;
		
	}
}
