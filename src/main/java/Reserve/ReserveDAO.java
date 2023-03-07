package Reserve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class ReserveDAO {
	private ReserveDAO() {}
	static private ReserveDAO instance = new ReserveDAO();
	static public ReserveDAO getInstance() {
		return instance;
	}
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public void getConnect() {
		   String URL="jdbc:mysql://localhost:3307/rentcardb?charaterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		   String user="root";
		   String password="root";
		  try {
			  Class.forName("com.mysql.cj.jdbc.Driver");		  
			  conn=DriverManager.getConnection(URL, user, password);
		   } catch (Exception e) {
			  e.printStackTrace();
		  }		   
	}
	
	public ArrayList<ReserveVO> getIdsReserveVO(String id) {
		ArrayList<ReserveVO> list = getReserveList();
		ArrayList<ReserveVO> idsList = new ArrayList<>();
		for(ReserveVO reserve : list) {
			if(id.equals(reserve.getId())) {
				idsList.add(reserve);
			}
		}
		return idsList;
	}
	
	public void addReserve(ReserveVO vo) {
		String sql = "insert into carreserve(id, qty, dday, rday, usein, usewifi, usenavi, useseat,carNo) values(?,?,?,?,?,?,?,?,?)";
		getConnect();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setInt(2, vo.getQty());
			ps.setInt(3, vo.getDday());
			ps.setString(4, vo.getRday());
			ps.setInt(5, vo.getUsein());
			ps.setInt(6, vo.getUsewifi());
			ps.setInt(7, vo.getUsenavi());
			ps.setInt(8, vo.getUseseat());
			ps.setInt(9, vo.getCarNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	
	private ArrayList<ReserveVO> getReserveList() {
		String SQL = "select * from carreserve";
		getConnect();
		ArrayList<ReserveVO> list = new ArrayList<ReserveVO>();
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				ReserveVO b = new ReserveVO();
				b.setId(rs.getString("id"));
				b.setQty(rs.getInt("qty"));
				b.setDday(rs.getInt("dday"));
				b.setRday(rs.getString("rday"));
				b.setUsein(rs.getInt("usein"));
				b.setUsewifi(rs.getInt("usewifi"));
				b.setUsenavi(rs.getInt("usenavi"));
				b.setUseseat(rs.getInt("useseat"));
				b.setCarNo(rs.getInt("carNo"));
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
