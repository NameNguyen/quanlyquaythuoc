package dao.Taikhoan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectDB;
import entities.Khachhang;
import entities.Nguoidung;
import entities.Taikhoan;

public class Taikhoan_DAO {
	public Taikhoan_DAO() {
		// TODO Auto-generated constructor stub
	}
	
	public List<String> checktrungma() {
		List<String> dsten = new ArrayList<String>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select MSNV from TaiKhoan";
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
	public boolean taoTaikhoan(Taikhoan tk) {
		Connection connection = ConnectDB.getInstance().getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = connection.prepareStatement("insert into TaiKhoan values(?, ?)");
			statement.setString(1, tk.getUserName());
			statement.setString(2, tk.getPassWord());
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
	public boolean deleteTaikhoan(String ma) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("delete from TaiKhoan where MSNV = ?");
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
	public boolean updateTaikhoan(Taikhoan tk) {
		PreparedStatement stmt = null;
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "update TaiKhoan set pass=? where MSNV = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, tk.getPassWord());
			stmt.setString(2, tk.getUserName());
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
	public Taikhoan timTaikhoanbyMa(String ma) {
		Taikhoan tk = null;
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from TaiKhoan where MSNV = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, ma);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String matk = rs.getString(1);
				String pass = rs.getString(2);
				tk = new Taikhoan(matk, pass);
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
		
		return tk;
	}
	public boolean timTaikhoanbyMa1(String ma) {
		PreparedStatement statement = null;
		Taikhoan tk = null;
		boolean n=false;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from TaiKhoan where MSNV = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, ma);
			statement.execute();
			if(statement.execute()== true) {
				statement.close();
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return n;
	}
	public List<Taikhoan> getAllNguoidung() {
		List<Taikhoan> dstk = new ArrayList<Taikhoan>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select * from TaiKhoan";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				Taikhoan tk = new Taikhoan(ma, ten);
				dstk.add(tk);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dstk;
	}
	public Taikhoan timTaikhoanbyPass(String pass) {
		Taikhoan tk = null;
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from TaiKhoan where pass = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, pass);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String matk = rs.getString(1);
				String passTK = rs.getString(2);
				tk = new Taikhoan(matk, passTK);
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
		
		return tk;
	}
	public boolean taoThongtindangnhap(String ma) {
		Connection connection = ConnectDB.getInstance().getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("insert into thongtindangnhap select nd.MSNV, tk.pass, nd.HoTen, nd.chucvu \r\n" + 
					"from NguoiDung nd join TaiKhoan tk on nd.MSNV= tk.MSNV where nd.MSNV = ?");
			statement.setString(1, ma);
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
	public Taikhoan getThongTindangnhap() {
		Taikhoan tk = null;
		Nguoidung nd = null;
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select * from thongtindangnhap";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String pass = rs.getString(2);
				String hoten = rs.getString(3);
				String chucvu = rs.getString(4);
				tk = new Taikhoan(ma, pass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tk;
	}
	public Nguoidung getThongTindangnhap1() {
		Taikhoan tk = null;
		Nguoidung nd = null;
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select * from thongtindangnhap";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String pass = rs.getString(2);
				String hoten = rs.getString(3);
				String chucvu = rs.getString(4);
				tk = new Taikhoan(ma, pass);
				nd = new Nguoidung(tk, hoten, null, null, chucvu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nd;
	}
	public boolean deleteThongtindangnhap() {
		Connection connection = ConnectDB.getInstance().getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("delete from thongtindangnhap");
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
}

