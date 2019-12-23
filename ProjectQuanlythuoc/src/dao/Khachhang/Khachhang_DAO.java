package dao.Khachhang;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectDB;
import entities.Donvithuoc;
import entities.Khachhang;
import entities.Nhacungcap;
import entities.Nuoc;
import entities.Thuoc;

public class Khachhang_DAO {
	public Khachhang_DAO() {
		// TODO Auto-generated constructor stub
	}
	public List<String> checktrungma() {
		List<String> dsten = new ArrayList<String>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select maKH from KhachHang";
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
	public List<Khachhang> getAllKhachhang() {
		List<Khachhang> dskh = new ArrayList<Khachhang>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select * from KhachHang";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String sdt = rs.getString(3);
				String diachi = rs.getString(4);
				Khachhang kh = new Khachhang(ma, ten, sdt, diachi);
				dskh.add(kh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dskh;
	}
	public boolean taoKhachhang(Khachhang kh) {
		Connection connection = ConnectDB.getInstance().getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = connection.prepareStatement("insert into KhachHang values(?, ?, ?, ?)");
			statement.setString(1, kh.getMaKH());
			statement.setString(2, kh.getHoten());
			statement.setString(3, kh.getSdt());
			statement.setString(4, kh.getDiaChi());
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
	public boolean updateKhachhang(Khachhang kh) {
		PreparedStatement stmt = null;
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "update KhachHang set hotenKH = ?, sdt = ?, diachi = ? where maKH = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, kh.getHoten());
			stmt.setString(2, kh.getSdt());
			stmt.setString(3, kh.getDiaChi());
			stmt.setString(4, kh.getMaKH());
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
			stmt = con.prepareStatement("delete from Khachhang where maKH = ?");
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
	public List<Khachhang> timKhachhangByten(String ten) {
		List<Khachhang> dskh = new ArrayList<Khachhang>();
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from KhachHang where hotenKH = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, ten);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenKH = rs.getString(2);
				String sdt = rs.getString(3);
				String diachi = rs.getString(4);
				Khachhang kh = new Khachhang(ma, tenKH, sdt, diachi);
				dskh.add(kh);
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
		
		return dskh;
	}
	public Khachhang timKhachhangBytenKH(String ten) {
		Khachhang kh = null;
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from KhachHang where hotenKH = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, ten);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenKH = rs.getString(2);
				String sdt = rs.getString(3);
				String diachi = rs.getString(4);
				kh = new Khachhang(ma, tenKH, sdt, diachi);
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
		
		return kh;
	}
	public List<Khachhang> timKhachhangBySDT(String sdt) {
		List<Khachhang> dskh = new ArrayList<Khachhang>();
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from KhachHang where sdt = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, sdt);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenKH = rs.getString(2);
				String sodt = rs.getString(3);
				String diachi = rs.getString(4);
				Khachhang kh = new Khachhang(ma, tenKH, sodt, diachi);
				dskh.add(kh);
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
		
		return dskh;
	}
	public List<Khachhang> timKhachhangByDiachi(String diaChi) {
		List<Khachhang> dskh = new ArrayList<Khachhang>();
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from KhachHang where diachi = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, diaChi);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenKH = rs.getString(2);
				String sdt = rs.getString(3);
				String diachi = rs.getString(4);
				Khachhang kh = new Khachhang(ma, tenKH, sdt, diachi);
				dskh.add(kh);
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
		
		return dskh;
	}
}
