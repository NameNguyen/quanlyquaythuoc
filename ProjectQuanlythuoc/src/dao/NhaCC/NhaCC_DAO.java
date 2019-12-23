package dao.NhaCC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectDB;
import entities.Khachhang;
import entities.Nhacungcap;

public class NhaCC_DAO {
	public NhaCC_DAO() {
		// TODO Auto-generated constructor stub
	}
	public List<String> checktrungma() {
		List<String> dsten = new ArrayList<String>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select maNCC from NhaCungCap";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				dsten.add(ma);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsten;
	}
	public List<Nhacungcap> getAllNCC() {
		List<Nhacungcap> dsNCC = new ArrayList<Nhacungcap>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select * from Nhacungcap";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String sdt = rs.getString(3);
				String email = rs.getString(4);
				String diachi = rs.getString(5);
				Nhacungcap ncc = new Nhacungcap(ma, ten, email, sdt, diachi);
				dsNCC.add(ncc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsNCC;
	}
	public boolean taoNhacungcap(Nhacungcap ncc) {
		Connection connection = ConnectDB.getInstance().getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = connection.prepareStatement("insert into Nhacungcap values(?, ?, ?, ?, ?)");
			statement.setString(1, ncc.getMaNhaCC());
			statement.setString(2, ncc.getTenNhaCC());
			statement.setString(3, ncc.getSdt());
			statement.setString(4, ncc.getEmail());
			statement.setString(5, ncc.getDiachi());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
				return true;
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return false;
	}
	public List<Nhacungcap> timNhaCCbyTen(String ten) {
		List<Nhacungcap> dsNcc = new ArrayList<Nhacungcap>();
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from Nhacungcap where tenNCC = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, ten);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenNCC = rs.getString(2);
				String sdt = rs.getString(3);
				String email = rs.getString(4);
				String diachi = rs.getString(5);
				Nhacungcap ncc = new Nhacungcap(ma, tenNCC, email, sdt, diachi);
				dsNcc.add(ncc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return dsNcc;
	}
	public List<Nhacungcap> timNhaCCbySDT(String sdt) {
		List<Nhacungcap> dsNcc = new ArrayList<Nhacungcap>();
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from Nhacungcap where sdt = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, sdt);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String sdtNCC = rs.getString(3);
				String email = rs.getString(4);
				String diachi = rs.getString(5);
				Nhacungcap ncc = new Nhacungcap(ma, ten, email, sdtNCC, diachi);
				dsNcc.add(ncc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return dsNcc;
	}
	public List<Nhacungcap> timNhaCCbyEmail(String email) {
		List<Nhacungcap> dsNcc = new ArrayList<Nhacungcap>();
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from Nhacungcap where tenNCC = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenNCC = rs.getString(2);
				String sdt = rs.getString(3);
				String emailNCC = rs.getString(4);
				String diachi = rs.getString(5);
				Nhacungcap ncc = new Nhacungcap(ma, tenNCC, emailNCC, sdt, diachi);
				dsNcc.add(ncc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return dsNcc;
	}
	public List<Nhacungcap> timNhaCCbyDiachi(String diachi) {
		List<Nhacungcap> dsNcc = new ArrayList<Nhacungcap>();
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from Nhacungcap where diachi = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, diachi);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenNCC = rs.getString(2);
				String sdt = rs.getString(3);
				String email = rs.getString(4);
				String diachiNCC = rs.getString(5);
				Nhacungcap ncc = new Nhacungcap(ma, tenNCC, email, sdt, diachiNCC);
				dsNcc.add(ncc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return dsNcc;
	}
	public boolean updateNhacungcap(Nhacungcap ncc) {
		PreparedStatement stmt = null;
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "update Nhacungcap set tenNCC = ?, sdt = ?, email = ?, diachi = ? where maNCC = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ncc.getTenNhaCC());
			stmt.setString(2, ncc.getSdt());
			stmt.setString(3, ncc.getEmail());
			stmt.setString(4, ncc.getDiachi());
			stmt.setString(5, ncc.getMaNhaCC());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false; 
	}
	public boolean deleteKhachhang(String ma) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("delete from Nhacungcap where maNCC = ?");
			stmt.setString(1, ma);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	
}
