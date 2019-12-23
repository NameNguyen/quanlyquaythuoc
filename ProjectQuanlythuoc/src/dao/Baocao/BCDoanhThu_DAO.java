package dao.Baocao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

public class BCDoanhThu_DAO {
	public BCDoanhThu_DAO() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Hoadon> getallHoadon(){
		ArrayList<Hoadon> dsncc = new ArrayList<Hoadon>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "select * from [HoaDon] ";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String mahd = rs.getString(1);
				String manv = rs.getString(2);
				String makh = rs.getString(3);
				Date ngaylap = rs.getDate(4);
				Hoadon hd = new Hoadon(mahd, new Khachhang(makh), new Nguoidung(new Taikhoan(manv)), ngaylap);
				dsncc.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsncc;
	}
	public ArrayList<Chitiethoadon> getsoluong(String ma){
		ArrayList<Chitiethoadon> cthd = new ArrayList<Chitiethoadon>();
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select soluong from ChiTietHoaDon where maHD =?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Integer soluong = rs.getInt(1);
				Chitiethoadon sl = new Chitiethoadon(soluong);
				cthd.add(sl);
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
	public double getallThuoc2(String ma){
		Thuoc dst = null;
		PreparedStatement stmt = null;
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "select * from Thuoc where [mathuoc]=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String mat = rs.getString(1);
				String ten = rs.getString(2);
				String donvi = rs.getString(3);
				double dongia = rs.getDouble(4);
				String nhaCC = rs.getString(5);
				String nuoc = rs.getString(6);
				String danhmuc = rs.getString(7);
				String tinhtrang = rs.getString(8);
				Date ngaynhap = rs.getDate(9);
				Date ngayhethan = rs.getDate(10);
				Thuoc thuoc = new Thuoc(mat, ten, tinhtrang, dongia, danhmuc, ngaynhap, ngayhethan, 
						new Donvithuoc(donvi), new Nuoc(nuoc), new Nhacungcap(nhaCC));
				dst=thuoc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dst.getDonGia();
	}
	public int getsoluongthuoc(String ma, String mathuoc) {
		Chitiethoadon ct = new Chitiethoadon();
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select soluong from ChiTietHoaDon where maHD = ? and mathuoc=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			stmt.setString(2, mathuoc);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Integer soluong = rs.getInt(1);
				Chitiethoadon sl = new Chitiethoadon(soluong);
				ct=sl;
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
		return ct.getSoLuong();
	}
	public ArrayList<Chitiethoadon> getmathuoc(String ma) {
		ArrayList<Chitiethoadon> ct = new ArrayList<Chitiethoadon>();
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from ChiTietHoaDon where maHD = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String mahd = rs.getString(1);
				String mathuoc = rs.getString(2);
				Integer soluong = rs.getInt(3);
				Chitiethoadon sl = new Chitiethoadon(new Hoadon(mahd), new Thuoc(mathuoc), soluong);
				ct.add(sl);
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
		return ct;
	}
	public ArrayList<Hoadon> gethddate(String Day){
		ArrayList<Hoadon> cthd = new ArrayList<Hoadon>();
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from [HoaDon] where  0 = DATEDIFF(day, ngayban, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, Day);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String mahd = rs.getString(1);
				String tennv = rs.getString(2);
				String tenkh = rs.getString(3);
				Date ngaylap = rs.getDate(4);
				Hoadon hd = new Hoadon(mahd, new Khachhang(tenkh), new Nguoidung(new Taikhoan(tennv)), ngaylap);
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
	public String timNguoidungByMa(String ma) {
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
		
		return nd.getHoten();
	}
}
