package dao.Hoadon;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool.ManagedBlocker;

import dao.ConnectDB;
import entities.Chitiethoadon;
import entities.Donvithuoc;
import entities.Hoadon;
import entities.Khachhang;
import entities.Nguoidung;
import entities.Nhacungcap;
import entities.Nuoc;
import entities.Taikhoan;
import entities.Thuoc;

public class Hoadon_DAO {
	public Hoadon_DAO() {
		// TODO Auto-generated constructor stub
	}
	public List<Hoadon> getAllHoaDon() {
		List<Hoadon> dshoadon = new ArrayList<Hoadon>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select * from HoaDon";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maHD = rs.getString(1);
				String maND = rs.getString(2);
				String maKH = rs.getString(3);
				Date ngayLap = rs.getDate(4);
				Hoadon hd = new Hoadon(maHD, new Khachhang(maKH), new Nguoidung(new Taikhoan(maND)), ngayLap);
				dshoadon.add(hd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dshoadon;
	}
	public List<Khachhang> getallTenTK() {
		List<Khachhang> dstenKH = new ArrayList<Khachhang>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select maKH, hotenKH,sdt  from KhachHang";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String makh = rs.getString(1);
				String tenkh = rs.getString(2);
				String sdt = rs.getString(3);
				Khachhang kh = new Khachhang(tenkh, makh, sdt);
				dstenKH.add(kh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dstenKH;
	}
	public List<Thuoc> getAllThuoc() {
		List<Thuoc> dsthuoc = new ArrayList<Thuoc>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		PreparedStatement stmt = null;
		String Day = LocalDate.now().toString();
		try {
			String sql = "select * from Thuoc where cast(ngayhethan as date) > ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, Day);
			ResultSet rs = stmt.executeQuery();
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
	public List<Chitiethoadon> getAllCTHoaDon(String ma) {
		List<Chitiethoadon> dshoadon = new ArrayList<Chitiethoadon>();
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from ChiTietHoaDon where maHD=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, ma);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String maHD = rs.getString(1);
				String maThuoc = rs.getString(2);
				int soLuong = rs.getInt(3);
				Chitiethoadon cthd = new Chitiethoadon(new Hoadon(maHD), new Thuoc(maThuoc), soLuong);
				dshoadon.add(cthd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dshoadon;
	}
	public boolean checktrungma(String mahd) {
		boolean flag = false;
		Connection connection = new ConnectDB().getInstance().getConnection();
		ResultSet rs = null;
		try {
			String sql = "select maHD from HoaDon";
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String mancc = rs.getString(1);
				if(mancc.equalsIgnoreCase(mahd)) {
					flag = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	public String timThuocByma(String mathuoc) {
		String tenThuoc = null;
		PreparedStatement statement = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from Thuoc where mathuoc = ?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, mathuoc);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				tenThuoc = ten;
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

		return tenThuoc;
	}
	public Double getAllThuoc2(String mathuoc) {
		Thuoc t = null;
		PreparedStatement stmt = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from Thuoc where [mathuoc]=?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, mathuoc);
			ResultSet rs = stmt.executeQuery();
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
				Thuoc thuoc = new Thuoc(ma, ten, tinhtrang, dongia, danhmuc, ngaynhap, ngayhethan, 
						new Donvithuoc(donvi), new Nuoc(nuoc), new Nhacungcap(nhaCC));
				t = thuoc;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return t.getDonGia();
	}
	public Nguoidung getNuoiDungTheoMa(String manv) {
		Nguoidung nd = new Nguoidung();
		PreparedStatement stmt = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from NguoiDung where MSNV=?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, manv);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenND = rs.getString(2);
				String gioitinh = rs.getString(3);
				String diachi = rs.getString(4);
				String chucvu = rs.getString(5);
				Taikhoan tk = new Taikhoan(ma);
				Nguoidung n = new Nguoidung(tk, tenND, gioitinh, diachi, chucvu);
				nd = n;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return nd;
	}
	public Khachhang getKhachHangTheoMa(String makh) {
		Khachhang kh = null;
		PreparedStatement stmt = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from KhachHang where maKH=?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, makh);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenND = rs.getString(2);
				String sdt = rs.getString(3);
				String diachi = rs.getString(4);
				Khachhang n = new Khachhang(ma, tenND, sdt, diachi);
				kh = n;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return kh;
	}
	public boolean daleteThuoc(String mathuoc, String mahd) {
		PreparedStatement stmt = null;
		Connection connection = new ConnectDB().getInstance().getConnection();
		int n=0;
		try {
			stmt = connection.prepareStatement("delete from ChiTietHoaDon where maHD = ? and mathuoc = ?");
			stmt.setString(1, mahd);
			stmt.setString(2, mathuoc);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	
	public boolean daleteHoaDon(String mahd) {
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		Connection connection = new ConnectDB().getInstance().getConnection();
		int n=0;
		int m=0;
		try {
			stmt = connection.prepareStatement("delete from ChiTietHoaDon where maHD = ?");
			stmt2 = connection.prepareStatement("delete from HoaDon where maHD = ?");
			stmt.setString(1, mahd);
			stmt2.setString(1, mahd);
			n = stmt.executeUpdate();
			m = stmt2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m>0;
	}
	public Khachhang getKhachHangTheoSDT(String sdtkh) {
		Khachhang kh = null;
		PreparedStatement stmt = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from KhachHang where sdt=?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, sdtkh);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenND = rs.getString(2);
				String sdt = rs.getString(3);
				String diachi = rs.getString(4);
				Khachhang n = new Khachhang(ma, tenND, sdt, diachi);
				kh = n;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return kh;
	}
//	public ArrayList<Hoadon> gethddate(String Day){
//		ArrayList<Hoadon> cthd = new ArrayList<Hoadon>();
//		Connection connection = new ConnectDB().getInstance().getConnection();
//		PreparedStatement stmt = null;
//		try {
//			String sql = "select * from HoaDon where  0 = DATEDIFF(day, ngayban, ?)";
//			stmt = connection.prepareStatement(sql);
//			stmt.setString(1, Day);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				String mahd = rs.getString(1);
//				String manv = rs.getString(2);
//				String makh = rs.getString(3);
//				Date ngaylap = rs.getDate(4);
//				Hoadon hd = new Hoadon(mahd, new Khachhang(makh), new Nguoidung(new Taikhoan(manv)), ngaylap);
//				cthd.add(hd);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				stmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return cthd;
//	}
	public ArrayList<Hoadon> getAllHoaDonTheoMaNV(String manv){
		ArrayList<Hoadon> cthd = new ArrayList<Hoadon>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from HoaDon where  MSNV=?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, manv);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String mahd = rs.getString(1);
				String Manv = rs.getString(2);
				String makh = rs.getString(3);
				Date ngaylap = rs.getDate(4);
				Hoadon hd = new Hoadon(mahd, new Khachhang(makh), new Nguoidung(new Taikhoan(Manv)), ngaylap);
				cthd.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cthd;
	}
	public Khachhang getKhachHangTheoTen(String tenKH) {
		Khachhang kh = null;
		PreparedStatement stmt = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select * from KhachHang where hotenKH=?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, tenKH);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenND = rs.getString(2);
				String sdt = rs.getString(3);
				String diachi = rs.getString(4);
				Khachhang n = new Khachhang(ma, tenND, sdt, diachi);
				kh = n;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return kh;
	}
	public boolean taoHoaDon(Hoadon hd) {
		Connection connection = ConnectDB.getInstance().getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = connection.prepareStatement("insert into HoaDon values(?, ?, ?, ?)");
			statement.setString(1, hd.getMaHoaDon());
			statement.setString(2, hd.getMaNgdung().getTaiKhoan().getUserName());
			statement.setString(3, hd.getMaKH().getMaKH());
			statement.setDate(4, (Date) hd.getNgayLap());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n>0;
	}
	public String getThuocTheoTen(String tenthuoc) {
		Thuoc thuoc = null;
		PreparedStatement stmt = null;
		try {
			Connection connection = new ConnectDB().getInstance().getConnection();
			String sql = "select mathuoc from Thuoc where tenthuoc=?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, tenthuoc);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				Thuoc t = new Thuoc(ma);
				thuoc = t;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return thuoc.getMaThuoc();
	}
	public boolean taoCTHoaDon(Chitiethoadon hd) {
		Connection connection = ConnectDB.getInstance().getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = connection.prepareStatement("insert into ChiTietHoaDon values(?, ?, ?)");
			statement.setString(1, hd.getMaHoadon().getMaHoaDon());
			statement.setString(2, hd.getMaThuoc().getMaThuoc());
			statement.setInt(3, hd.getSoLuong());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n>0;
	}
}
