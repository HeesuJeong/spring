package edu.ssafy.repogitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.Member;


@Repository(value="MemJDBCRepoImpl")
public class MemJDBCRepoImpl implements MemRepo{

	@Autowired
	private DataSource ds;
	
	
	public MemJDBCRepoImpl() {
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
    public void insert(Member m) {
        System.out.println("insert");
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement("insert into members(id, pw, name, email) values(?,?,?,?)");
            pstmt.setString(1, m.getId());
            pstmt.setString(2, m.getPw());
            pstmt.setString(3, m.getName());
            pstmt.setString(4, m.getEmail());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
    }

	@Override
	public void update(Member m) {
		// TODO Auto-generated method stub
		System.out.println("update");
		 Connection conn = null;
	        PreparedStatement pstmt = null;
	        
	        try {
	            conn = ds.getConnection();
	            pstmt = conn.prepareStatement("update members set pw=?,name=?,email=? where id=?");
	            pstmt.setString(1, m.getId());
	            pstmt.setString(2, m.getPw());
	            pstmt.setString(3, m.getName());
	            pstmt.setString(4, m.getEmail());
	            pstmt.executeUpdate();
	            
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally {
	            try {
	                pstmt.close();
	                conn.close();
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	            
	        }
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		System.out.println("delete");
		 Connection conn = null;
	        PreparedStatement pstmt = null;
	        
	        try {
	            conn = ds.getConnection();
	            pstmt = conn.prepareStatement("delete from members where id=?");
	            pstmt.setString(1, id);
	            pstmt.executeUpdate();
	            
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally {
	            try {
	                pstmt.close();
	                conn.close();
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	            
	        }
	}

	@Override
	public Member selectOne(String id) {
		// TODO Auto-generated method stub
		System.out.println("selectone");
		 Connection conn = null;
	        PreparedStatement pstmt = null;
	        
	        try {
	            conn = ds.getConnection();
	            pstmt = conn.prepareStatement("select id,pw,name,email from members where id=?");
	            pstmt.setString(1, id);
	            ResultSet rs=pstmt.executeQuery();
	            Member member=null;
	            while(rs.next()) {
	            	member=new Member(rs.getString("id"),rs.getString("pw"),rs.getString("name"),rs.getString("email"));
	            	
	            }
	            return member;
	            
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally {
	            try {
	                pstmt.close();
	                conn.close();
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	            
	        }
		return null;
	}

	@Override
	public ArrayList<Member> selectList() {
		// TODO Auto-generated method stub
		System.out.println("selectlist");
		Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement("select id,pw,name,email from members");
            
            ResultSet rs=pstmt.executeQuery();
            Member member=null;
            ArrayList<Member>list=new ArrayList<Member>();
            while(rs.next()) {
            	member=new Member(rs.getString("id"),rs.getString("pw"),rs.getString("name"),rs.getString("email"));
            	list.add(member);
            }
            
            return list;
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
		return null;
	}

}
