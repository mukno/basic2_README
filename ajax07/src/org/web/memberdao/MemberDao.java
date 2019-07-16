package org.web.memberdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.web.dbconnect.DBConnect;
import org.web.memberdto.MemberDto;

public class MemberDao {
	private MemberDao() {}
	private static class Singleton{
		private static final MemberDao INSTANCE = new MemberDao();
	}
	public static MemberDao getInstance() {
		return Singleton.INSTANCE;
	}
	
	//아이디 체크
	public int idChecked(String userId) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstm =null;
		ResultSet rs=null;
		
		String query="";
		
		conn=DBConnect.getConnection();
		query="select count(*) from member_reply where userId=?";
		
		try {
			pstm=conn.prepareStatement(query);
			
			pstm.setString(1, userId);
			
			rs=pstm.executeQuery();
			
			while(rs.next()) {
				result=rs.getInt(1);
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstm!=null)pstm.close();
				if(rs!=null)rs.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally {}
			
		}
		
		
		return result;
	}
	
	public int joinOk(String userId,String userPw, String userName,String userAddr) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstm =null;
		
		String query="";
		
		conn=DBConnect.getConnection();
		query="insert into member_reply values(?,?,?,?);";
		
		try {
			pstm=conn.prepareStatement(query);
			
			pstm.setString(1, userId);
			pstm.setString(2, userPw);
			pstm.setString(3, userName);
			pstm.setString(4, userAddr);
			
			result=pstm.executeUpdate();
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstm!=null)pstm.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally {}
			
		}
		
		
		return result;
	}
	

	public int memberdelete(String userId,String userPw) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstm =null;
		
		String query="";
		
		conn=DBConnect.getConnection();
		query="delete from member_reply where userId=? and userPw=?";
		
		try {
			pstm=conn.prepareStatement(query);
			
			pstm.setString(1, userId);
			pstm.setString(2, userPw);
			
			result=pstm.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstm!=null)pstm.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally {}
			
		}
		
		
		return result;
	}
	
	
	
	public int login(String userId,String userPw) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstm =null;
		ResultSet rs=null;
		
		String query="";
		
		conn=DBConnect.getConnection();
		query="select count(*) from member_reply where userId=? and userPw=?";
		
		try {
			pstm=conn.prepareStatement(query);
			
			pstm.setString(1, userId);
			pstm.setString(2, userPw);
			
			rs=pstm.executeQuery();
			
			while(rs.next()) {
				result=rs.getInt(1);
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstm!=null)pstm.close();
				if(rs!=null)rs.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally {}
			
		}
		
		
		return result;
	}
	
	
	public int memberChange(String userId,String userPw,String userName,String userAddr) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstm =null;
		ResultSet rs=null;
		
		String query="";
		
		conn=DBConnect.getConnection();
		query="update member_reply set userPw=?,userName=?,userAddr=? where userId=?;";
		
		try {
			pstm=conn.prepareStatement(query);
			
			pstm.setString(4, userId);
			pstm.setString(1, userPw);
			pstm.setString(2, userName);
			pstm.setString(3,userAddr);
			
			
			result=pstm.executeUpdate();
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstm!=null)pstm.close();
				if(rs!=null)rs.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally {}
			
		}
		
		
		return result;
	}
	public MemberDto memberView(String userId){
		MemberDto dto=null;
		Connection conn=null;
		PreparedStatement pstm =null;
		ResultSet rs=null;
		String query="";
		
		conn=DBConnect.getConnection();
		query="select * from member_reply where userId=?";
		
		try {
			pstm=conn.prepareStatement(query);
			
			pstm.setString(1, userId);
			
			rs=pstm.executeQuery();
			
			while(rs.next()) {
				dto=new MemberDto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstm!=null)pstm.close();
				if(rs!=null)rs.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally {}
			
		}
		
		
		return dto;
	}
	
	
	public ArrayList<MemberDto> memberLists(){
		ArrayList<MemberDto> lists=new ArrayList<MemberDto>();
		Connection conn=null;
		PreparedStatement pstm =null;
		ResultSet rs=null;
		String query="";
		
		conn=DBConnect.getConnection();
		query="select * from member_reply";
		
		try {
			pstm=conn.prepareStatement(query);
			
			rs=pstm.executeQuery();
			
			while(rs.next()) {
				
				lists.add(new MemberDto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));//위의 과정을 한번에 처리
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstm!=null)pstm.close();
				if(rs!=null)rs.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally {}
			
		}
		
		
		return lists;
	}
	
	public ArrayList<MemberDto> memberLists(String searchcode){
		ArrayList<MemberDto> lists=new ArrayList<MemberDto>();
		Connection conn=null;
		PreparedStatement pstm =null;
		ResultSet rs=null;
		String query="";
		
		conn=DBConnect.getConnection();
		query="select * from member_reply where userId like ?";
		
		try {
			pstm=conn.prepareStatement(query);
			pstm.setString(1, "%"+searchcode+"%");
			
			rs=pstm.executeQuery();
			while(rs.next()) {
				
				lists.add(new MemberDto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));//위의 과정을 한번에 처리
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstm!=null)pstm.close();
				if(rs!=null)rs.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally {}
			
		}
		
		
		return lists;
	}

}
