package Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class CarDAO {
	private CarDAO() {}
	static private CarDAO instance = new CarDAO();
	static public CarDAO getInstance() {
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
	
	public ArrayList<CarVO> getCarList() {
		String SQL = "select * from rentcar";
		getConnect();
		ArrayList<CarVO> list = new ArrayList<CarVO>();
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				CarVO b = new CarVO();
				b.setNo(rs.getInt("no"));
				b.setName(rs.getString("name"));
				b.setCategory(rs.getInt("category"));
				b.setPrice(rs.getInt("price"));
				b.setUsepeople(rs.getInt("usepeople"));
				b.setCompany(rs.getString("company"));
				b.setImg(rs.getString("img"));
				b.setInfo(rs.getString("info"));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
	
	public CarVO getCarVO(String name) {
		ArrayList<CarVO> list = getCarList();
		for(CarVO car : list) {
			if(name.equals(car.getName())) {
				return car;
			}
		}
		return null;
	}
	public void carused(String name,int qty) {
		String SQL = "update rentcar set usepeople = usepeople-? where name = ?";
		getConnect();
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, qty);
			ps.setString(2, name);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	public void cancleReserve(int carNo,int qty) {
		String SQL = "update rentcar set usepeople = usepeople+? where no = ?";
		getConnect();
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, qty);
			ps.setInt(2, carNo);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
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
