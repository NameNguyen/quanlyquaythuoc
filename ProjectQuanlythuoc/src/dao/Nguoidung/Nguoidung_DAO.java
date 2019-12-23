package dao.Nguoidung;

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

public class Nguoidung_DAO {
	public Nguoidung_DAO() {
		// TODO Auto-generated constructor stub
	}
	public List<Nguoidung> getAllNguoidung() {
		List<Nguoidung> dsnd = new ArrayList<Nguoidung>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select nd.MSNV, nd.HoTen, nd.gioitinh, nd.diachi, nd.chucvu, tk.pass from NguoiDung nd join TaiKhoan tk on nd.MSNV= tk.MSNV";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String gioitinh = rs.getString(3);
				String diachi = rs.getString(4);
				String chucvu = rs.getString(5);
				String pass = rs.getString(6);
				Nguoidung nd = new Nguoidung(new Taikhoan(ma, pass), ten, gioitinh, diachi, chucvu);
				dsnd.add(nd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnd;
	}
	public boolean taoNguoidung(Nguoidung nd) {
		Connection connection = ConnectDB.getInstance().getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = connection.prepareStatement("insert into NguoiDung values(?, ?, ?, ?, ?)");
			statement.setString(1, nd.getTaiKhoan().getUserName());
			statement.setString(2, nd.getHoten());
			statement.setString(3, nd.getGioiTinh());
			statement.setString(4, nd.getDiachi());
			statement.setString(5, nd.getChucVu());
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
	public List<Nguoidung> timNguoidungByten(String ten) {
		List<Nguoidung> dsnd = new ArrayList<Nguoidung>();
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select nd.MSNV, nd.HoTen, nd.gioitinh, nd.diachi, nd.chucvu, tk.pass from NguoiDung nd join TaiKhoan tk on nd.MSNV= tk.MSNV "
					+ "where nd.HoTen = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, ten);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenND = rs.getString(2);
				String gioitinh = rs.getString(3);
				String diachi = rs.getString(4);
				String chucvu = rs.getString(5);
				String pass = rs.getString(6);
				Taikhoan tk = new Taikhoan(ma, pass);
				Nguoidung nd = new Nguoidung(tk, ten, gioitinh, diachi, chucvu);
				dsnd.add(nd);
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
		
		return dsnd;
	}
	public List<Nguoidung> timNguoidungByGioitinh(String gioitinh) {
		List<Nguoidung> dsnd = new ArrayList<Nguoidung>();
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select nd.MSNV, nd.HoTen, nd.gioitinh, nd.diachi, nd.chucvu, tk.pass from NguoiDung nd join TaiKhoan tk on nd.MSNV= tk.MSNV "
					+ "where nd.gioitinh = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, gioitinh);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenND = rs.getString(2);
				String gioitinhND = rs.getString(3);
				String diachi = rs.getString(4);
				String chucvu = rs.getString(5);
				String pass = rs.getString(6);
				Taikhoan tk = new Taikhoan(ma, pass);
				Nguoidung nd = new Nguoidung(tk, tenND, gioitinhND, diachi, chucvu);
				dsnd.add(nd);
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
		
		return dsnd;
	}
	public List<Nguoidung> timNguoidungByChucvu(String chucvu) {
		List<Nguoidung> dsnd = new ArrayList<Nguoidung>();
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select nd.MSNV, nd.HoTen, nd.gioitinh, nd.diachi, nd.chucvu, tk.pass from NguoiDung nd join TaiKhoan tk on nd.MSNV= tk.MSNV "
					+ "where nd.chucvu = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, chucvu);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenND = rs.getString(2);
				String gioitinhND = rs.getString(3);
				String diachi = rs.getString(4);
				String chucvuND = rs.getString(5);
				String pass = rs.getString(6);
				Taikhoan tk = new Taikhoan(ma, pass);
				Nguoidung nd = new Nguoidung(tk, tenND, gioitinhND, diachi, chucvuND);
				dsnd.add(nd);
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
		
		return dsnd;
	}
	public List<Nguoidung> timNguoidungByDiachi(String diachi) {
		List<Nguoidung> dsnd = new ArrayList<Nguoidung>();
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select nd.MSNV, nd.HoTen, nd.gioitinh, nd.diachi, nd.chucvu, tk.pass from NguoiDung nd join TaiKhoan tk on nd.MSNV= tk.MSNV "
					+ "where nd.diachi = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, diachi);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenND = rs.getString(2);
				String gioitinhND = rs.getString(3);
				String diachiND = rs.getString(4);
				String chucvuND = rs.getString(5);
				String pass = rs.getString(6);
				Taikhoan tk = new Taikhoan(ma, pass);
				Nguoidung nd = new Nguoidung(tk, tenND, gioitinhND, diachiND, chucvuND);
				dsnd.add(nd);
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
		
		return dsnd;
	}
	public boolean updateNguoidung(Nguoidung nd) {
		PreparedStatement stmt = null;
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "update NguoiDung set HoTen = ?, gioitinh = ?, diachi = ?, chucvu=? where MSNV = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nd.getHoten());
			stmt.setString(2, nd.getGioiTinh());
			stmt.setString(3, nd.getDiachi());
			stmt.setString(4, nd.getChucVu());
			stmt.setString(5, nd.getTaiKhoan().getUserName());
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
	public boolean deleteNguoidung(String ma) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("delete from NguoiDung where MSNV = ?");
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
	public Nguoidung timNguoidungByMa(String ma) {
		Nguoidung nd = null;
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select nd.MSNV, nd.HoTen, nd.gioitinh, nd.diachi, nd.chucvu, tk.pass from NguoiDung nd join TaiKhoan tk on nd.MSNV= tk.MSNV "
					+ "where nd.MSNV = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, ma);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String maND = rs.getString(1);
				String tenND = rs.getString(2);
				String gioitinh = rs.getString(3);
				String diachi = rs.getString(4);
				String chucvu = rs.getString(5);
				String pass = rs.getString(6);
				Taikhoan tk = new Taikhoan(maND, pass);
				nd = new Nguoidung(tk, tenND, gioitinh, diachi, chucvu);
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
		
		return nd;
	}
}
