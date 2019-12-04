package hw1015;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component(value="primpl")
public class ProductRepoImpl implements ProductRepo {

	private Connection con;
	private PreparedStatement st;
	private ResultSet rs;
	
	@Override
	public List<Product> selectAll() {
		// TODO Auto-generated method stub
		String sql="select * from product";
		ArrayList<Product> list=new ArrayList<Product>();
		try {
			con=ConnectionProxy.getConnection();
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
			list=new ArrayList<Product>();
			while(rs.next()) {
				Product po=new Product();
				po.setId(rs.getString("id"));
				po.setName(rs.getString("name"));
				po.setPrice(rs.getInt("price"));
				po.setDescription(rs.getString("descrip"));
				list.add(po);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}

	@Override
	public Product select(String id) {
		// TODO Auto-generated method stub
		String str="select * from product where id=?";
		Product po=new Product();
		try {
			con=ConnectionProxy.getConnection();
			st=con.prepareStatement(str);
			st.setString(1, id);
			rs=st.executeQuery();
			if(rs.next()) {
				po.setId(rs.getString("id"));
				po.setName(rs.getString("name"));
				po.setPrice(rs.getInt("price"));
				po.setDescription(rs.getString("descrip"));
			}else {
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return po;
	}

	@Override
	public int insert(Product product) {
		// TODO Auto-generated method stub
		String str="insert into product (id,name,price,descrip) values (?,?,?,?)";
		int res=0; 
		try {
			con=ConnectionProxy.getConnection();
			st=con.prepareStatement(str);
			st.setString(1,product.getId());
			st.setString(2, product.getName());
			st.setInt(3, product.getPrice());
			st.setString(4, product.getDescription());
			st.execute();
			res=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res=0;
			e.printStackTrace();
		}finally {
			close();//0실패 1성공
		}
		
		return res;
	}

	@Override
	public int update(Product product) {
		// TODO Auto-generated method stub
		String str="update product set id=?,name=?,price=?,descrip=? where id=?";
		int res=0; 
		try {
			con=ConnectionProxy.getConnection();
			st=con.prepareStatement(str);
			st.setString(1,product.getId());
			st.setString(2, product.getName());
			st.setInt(3, product.getPrice());
			st.setString(4, product.getDescription());
			st.setString(5,product.getId());
			st.execute();
			res=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res=0;
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		String str="delete from product where id=?";
		int res=0; 
		try {
			con=ConnectionProxy.getConnection();
			st=con.prepareStatement(str);
			st.setString(1,id);
			st.execute();
			res=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res=0;
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	

}
