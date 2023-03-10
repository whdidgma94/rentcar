package Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MemberDAO {
	
	private MemberDAO() {}
	static private MemberDAO instance = new MemberDAO();
	static public MemberDAO getInstance() {
		return instance;
	}
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public void getConnect() {
		   String URL="jdbc:mysql://localhost:3307/rentcardb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		   String user="root";
		   String password="root";
		  try {
			  Class.forName("com.mysql.cj.jdbc.Driver");		  
			  conn=DriverManager.getConnection(URL, user, password);
		   } catch (Exception e) {
			  e.printStackTrace();
		  }		   
	}
	
	public int removeMemberVO(String id) {
		String sql = "delete from member where id=?";
		getConnect();
		int check = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			check = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return check;
	}
	
	
	public int addMemberVO(MemberVO vo) {
		String sql = "insert into member(id, pw, name, age, email, phone, gender) values(?,?,?,?,?,?,?)";
		getConnect();
		int check = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPw());
			ps.setString(3, vo.getName());
			ps.setInt(4, vo.getAge());
			ps.setString(5, vo.getEmail());
			ps.setString(6, vo.getPhone());
			ps.setString(7, vo.getGender());
			check = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return check;
	}
	public boolean memberLogin(String id , String pw) {
		String sql = "select pw from member where id=?";
		getConnect();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				 String dbPw = rs.getString("pw");
				 if(dbPw.equals(pw)) {
					 return true;
				 }
			 }			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return false;
	}
	
	public MemberVO getAMember(String id) {
		String SQL = "select * from member where id = ?";
		getConnect();
		MemberVO member = new MemberVO();
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {			
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setAge(rs.getInt("age"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				member.setGender(rs.getString("gender"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return member;
	}
	
	public ArrayList<MemberVO> getMemberList() {
		String SQL = "select * from member";
		getConnect();
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				MemberVO m = new MemberVO();
				m.setId(rs.getString("id"));
				m.setPw(rs.getString("pw"));
				m.setName(rs.getString("name"));
				m.setAge(rs.getInt("age"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setGender(rs.getString("gender"));
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
	
	public void dbClose() {
		  try { 
		   if(rs!=null) rs.close();
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
	}
	public int confirmId(String id) {
		int x = 0;
		getConnect();
		try {
			ps = conn.prepareStatement("select id from member where id = ?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next())
				x = 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			dbClose();
		}
		return x;
	}  
}
