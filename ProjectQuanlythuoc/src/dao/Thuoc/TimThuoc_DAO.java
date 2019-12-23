package dao.Thuoc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectDB;
import entities.Donvithuoc;
import entities.Nhacungcap;
import entities.Nuoc;
import entities.Thuoc;

public class TimThuoc_DAO {
	public TimThuoc_DAO() {
	}
	public List<Thuoc> getAllThuoc() {
		List<Thuoc> dsthuoc = new ArrayList<Thuoc>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select * from Thuoc";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String donvi = rs.getString(3);
				double dongia = rs.getDouble(4);
				String nhaCC = rs.getString(5);
				String nuoc = rs.getString(6);
				String danhmuc = rs.getString(7);
				String tinhtrang = rs.getString(8);
				Date ngaynhap = rs.getDate(9);
				Date ngayhethan = rs.getDate(10);
				Thuoc t = new Thuoc(ma, ten, tinhtrang, dongia, danhmuc, ngaynhap, ngayhethan, 
						new Donvithuoc(donvi), new Nuoc(nuoc), new Nhacungcap(nhaCC));
				dsthuoc.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsthuoc;
	}
	public List<String> getNuoc() {
		List<String> dsten = new ArrayList<String>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select tennuoc from Nuoc";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ten = rs.getString(1);
				dsten.add(ten);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsten;
	}
	public List<String> getNhaCC() {
		List<String> dsten = new ArrayList<String>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select tenNCC from Nhacungcap";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ten = rs.getString(1);
				dsten.add(ten);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsten;
	}
	public List<String> getAllTenThuoc() {
		List<String> dsthuoc = new ArrayList<String>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select tenthuoc from Thuoc";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ten = rs.getString(1);
				dsthuoc.add(ten);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsthuoc;
	}
	public List<String> getAllTenDonvi() {
		List<String> dsDonvi = new ArrayList<String>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select tendonvi from DonViThuoc";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ten = rs.getString(1);
				dsDonvi.add(ten);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsDonvi;
	}
	public List<Thuoc> timThuocByten(String ten) {
		List<Thuoc> dsThuoc = new ArrayList<Thuoc>();
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from Thuoc where tenthuoc = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, ten);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenthuoc = rs.getString(2);
				String donvi = rs.getString(3);
				double dongia = rs.getDouble(4);
				String nhaCC = rs.getString(5);
				String nuoc = rs.getString(6);
				String danhmuc = rs.getString(7);
				String tinhtrang = rs.getString(8);
				Date ngaynhap = rs.getDate(9);
				Date ngayhethan = rs.getDate(10);
				Thuoc t = new Thuoc(ma, ten, tinhtrang, dongia, danhmuc, ngaynhap, ngayhethan, 
						new Donvithuoc(donvi), new Nuoc(nuoc), new Nhacungcap(nhaCC));
				dsThuoc.add(t);
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
		
		return dsThuoc;
	}
	public List<Thuoc> timThuocByTinhtrang(String tinhtrang) {
		List<Thuoc> dsThuoc = new ArrayList<Thuoc>();
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select mathuoc, tenthuoc, tinhtrang from Thuoc where tinhtrang = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, tinhtrang);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenthuoc = rs.getString(2);
				String tinhTrang = rs.getString(3);
				Thuoc thuoc = new Thuoc(ma, tenthuoc, tinhTrang);
				dsThuoc.add(thuoc);
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
		
		return dsThuoc;
	}
	public String timNuocByten(String ten) {
		Nuoc nuoc = new Nuoc();
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from Nuoc where tennuoc = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, ten);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenNuoc = rs.getString(2);
				nuoc = new Nuoc(ma, tenNuoc);
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
		
		return nuoc.getMaLoai();
	}
	public String timNCCByten(String ten) {
		Nhacungcap ncc = new Nhacungcap();
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
				ncc = new Nhacungcap(ma, tenNCC, sdt, email, diachi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ncc.getMaNhaCC();
	}
	public List<Thuoc> timThuocByNCC(String maNCC) {
		List<Thuoc> dsThuoc = new ArrayList<Thuoc>();
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from Thuoc where maNCC = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, maNCC);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenthuoc = rs.getString(2);
				String donvi = rs.getString(3);
				double dongia = rs.getDouble(4);
				String nhaCC = rs.getString(5);
				String nuoc = rs.getString(6);
				String danhmuc = rs.getString(7);
				String tinhtrang = rs.getString(8);
				Date ngaynhap = rs.getDate(9);
				Date ngayhethan = rs.getDate(10);
				Thuoc t = new Thuoc(ma, tenthuoc, tinhtrang, dongia, danhmuc, ngaynhap, ngayhethan, 
						new Donvithuoc(donvi), new Nuoc(nuoc), new Nhacungcap(nhaCC));
				dsThuoc.add(t);
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
		
		return dsThuoc;
	}
	public List<Thuoc> timThuocByDongia(double dongia) {
		List<Thuoc> dsThuoc = new ArrayList<Thuoc>();
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from Thuoc where dongia = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setDouble(1, dongia);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenthuoc = rs.getString(2);
				String donvi = rs.getString(3);
				double dongiathuoc = rs.getDouble(4);
				String nhaCC = rs.getString(5);
				String nuoc = rs.getString(6);
				String danhmuc = rs.getString(7);
				String tinhtrang = rs.getString(8);
				Date ngaynhap = rs.getDate(9);
				Date ngayhethan = rs.getDate(10);
				Thuoc t = new Thuoc(ma, tenthuoc, tinhtrang, dongia, danhmuc, ngaynhap, ngayhethan, 
						new Donvithuoc(donvi), new Nuoc(nuoc), new Nhacungcap(nhaCC));
				dsThuoc.add(t);
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
		
		return dsThuoc;
	}
	public List<Thuoc> timThuocByNuoc(String maNuoc) {
		List<Thuoc> dsThuoc = new ArrayList<Thuoc>();
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from Thuoc where manuoc = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, maNuoc);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenthuoc = rs.getString(2);
				String donvi = rs.getString(3);
				double dongia = rs.getDouble(4);
				String nhaCC = rs.getString(5);
				String nuoc = rs.getString(6);
				String danhmuc = rs.getString(7);
				String tinhtrang = rs.getString(8);
				Date ngaynhap = rs.getDate(9);
				Date ngayhethan = rs.getDate(10);
				Thuoc t = new Thuoc(ma, tenthuoc, tinhtrang, dongia, danhmuc, ngaynhap, ngayhethan, 
						new Donvithuoc(donvi), new Nuoc(nuoc), new Nhacungcap(nhaCC));
				dsThuoc.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return dsThuoc;
	}
	public String timDVByten(String ten) {
		PreparedStatement statement = null;
		Donvithuoc donvi = new Donvithuoc();
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from DonViThuoc where tendonvi = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, ten);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tendv = rs.getString(2);
				donvi = new Donvithuoc(ma, tendv);
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
		
		return donvi.getMaDonvi();
	}
	public boolean updateThuoc(Thuoc t) {
		PreparedStatement stmt = null;
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "update Thuoc set tenthuoc = ?, madonvi = ?, dongia = ?, maNCC = ?,"
					+ "manuoc=?, danhmucthuoc = ?, tinhtrang=?, ngaynhap=?, ngayhetHan= ? where mathuoc = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, t.getTenThuoc());
			stmt.setString(2, t.getMaDonvi().getMaDonvi());
			stmt.setDouble(3, t.getDonGia());
			stmt.setString(4, t.getMaNhaCC().getMaNhaCC());
			stmt.setString(5, t.getMaNuoc().getMaLoai());
			stmt.setString(6, t.getDanhMucthuoc());
			stmt.setString(7, t.getTinhTrang());
			stmt.setDate(8, t.getNgayNhap());
			stmt.setDate(9, t.getNgayHethan());
			stmt.setString(10, t.getMaThuoc());
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
	public String timNuocByMa(String ma) {
		Nuoc nuoc = new Nuoc();
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from Nuoc where manuoc = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, ma);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String maN = rs.getString(1);
				String tenNuoc = rs.getString(2);
				nuoc = new Nuoc(maN, tenNuoc);
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
		
		return nuoc.getTenLoai();
	}
	public String timDVByma(String ma) {
		PreparedStatement statement = null;
		Donvithuoc donvi = new Donvithuoc();
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from DonViThuoc where madonvi = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, ma);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String madv = rs.getString(1);
				String tendv = rs.getString(2);
				donvi = new Donvithuoc(madv, tendv);
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
		
		return donvi.getTenDonvi();
	}
	public String timNCCByma(String ma) {
		Nhacungcap ncc = new Nhacungcap();
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from Nhacungcap where maNCC = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, ma);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String mancc = rs.getString(1);
				String tenNCC = rs.getString(2);
				String sdt = rs.getString(3);
				String email = rs.getString(4);
				String diachi = rs.getString(5);
				ncc = new Nhacungcap(mancc, tenNCC, sdt, email, diachi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ncc.getTenNhaCC();
	}
	public boolean deleteThuoc(String ma) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("delete from Thuoc where mathuoc = ?");
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
	public List<Thuoc> timThuocByDanhmuc(String danhmuc) {
		List<Thuoc> dsThuoc = new ArrayList<Thuoc>();
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select mathuoc, tenthuoc, danhmucthuoc from Thuoc where danhmucthuoc = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, danhmuc);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenthuoc = rs.getString(2);
				String danhmucthuoc = rs.getString(3);
				Thuoc t = new  Thuoc(ma, tenthuoc, null, 0, danhmucthuoc, null, null,
						new Donvithuoc(null), new Nuoc(null), new Nhacungcap(null));
				dsThuoc.add(t);
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
		
		return dsThuoc;
	}
	public List<Thuoc> timThuocByMaDonvi(String madonvi) {
		List<Thuoc> dsThuoc = new ArrayList<Thuoc>();
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select mathuoc, tenthuoc, madonvi from Thuoc where madonvi = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, madonvi);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenthuoc = rs.getString(2);
				String donvi = rs.getString(3);
				Thuoc t = new Thuoc(ma, tenthuoc, null, 0, null, null,
						null, new Donvithuoc(donvi), new Nuoc(null), new Nhacungcap(null));
				dsThuoc.add(t);
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
		
		return dsThuoc;
	}
}
