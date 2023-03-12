package Board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class BoardDAO {
	private BoardDAO() {}
	static private BoardDAO instance = new BoardDAO();
	static public BoardDAO getInstance() {
		return instance;
	}
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	
	public void getConnect() {
		   String URL="jdbc:mysql://localhost:3306/rentcardb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		   String user="root";
		   String password="root";
		  try {
			  Class.forName("com.mysql.cj.jdbc.Driver");		  
			  conn=DriverManager.getConnection(URL, user, password);
		   } catch (Exception e) {
			  e.printStackTrace();
		  }		   
	}   
	
	public void addBoard(BoardVO vo) {
		String sql = "insert into board(title, content, writer, day, writerId) values(?,?,?,curdate(),?)";
		getConnect();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());
			ps.setString(3, vo.getWriter());
			ps.setString(4, vo.getWriterId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	
	public void deleteBoard(BoardVO vo) {
		String sql = "delete from board where num=?";
		getConnect();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getNum());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	
	public ArrayList<BoardVO> getBoardList() {
		String SQL = "select * from board";
		getConnect();
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardVO b = new BoardVO();
				b.setNum(rs.getInt("num"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setWriter(rs.getString("writer"));
				b.setDay(rs.getString("day"));
				b.setWriterId(rs.getString("writerId"));
				list.add(b);
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
}
