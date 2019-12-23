package dao.Thongke;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectDB;
import entities.Hoadon;
import entities.Thuoc;

public class ThongKe {
	public ThongKe() {
		// TODO Auto-generated constructor stub
	}
	public List<Thuoc> thongKethuocnhap() {
		List<Thuoc> dsten = new ArrayList<Thuoc>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select ngaynhap, tong = count(mathuoc) from Thuoc group by ngaynhap";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				Date date = rs.getDate(1);
				int soluong = rs.getInt(2);
				Thuoc t = new Thuoc(null, null, null, soluong, null, date, null, null, null, null);
				dsten.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsten;
	}
	public List<Thuoc> thongKethuochethanBieudo() {
		List<Thuoc> dsten = new ArrayList<Thuoc>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select ngayhetHan, tong = count(mathuoc) from Thuoc group by ngayhetHan";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				Date date = rs.getDate(1);
				int soluong = rs.getInt(2);
				Thuoc t = new Thuoc(null, null, null, soluong, null, null, date, null, null, null);
				dsten.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsten;
	}
	public List<Thuoc> thongKethuochethanTable() {
		List<Thuoc> dsten = new ArrayList<Thuoc>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select ngayhetHan, tong = count(mathuoc),tenthuoc from Thuoc group by ngayhetHan, tenthuoc";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				Date date = rs.getDate(1);
				int soluong = rs.getInt(2);
				String ten = rs.getString(3);
				Thuoc t = new Thuoc(null, ten, null, soluong, null, null, date, null, null, null);
				dsten.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsten;
	}
	public List<Thuoc> thongKeHoadon() {
		List<Thuoc> dsten = new ArrayList<Thuoc>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select ngayban, tong = COUNT(maHD) from hoadon group by ngayban";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				Date date = rs.getDate(1);
				int soluong = rs.getInt(2);
				Thuoc t = new Thuoc(null, null, null, soluong, null, null, date, null, null, null);
				dsten.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsten;
	}
	public List<Thuoc> thongKeDoanhthu() {
		List<Thuoc> dsten = new ArrayList<Thuoc>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select hd.ngayban, tong=sum(t.dongia*ct.soluong) from HoaDon hd join ChiTietHoaDon ct on hd.maHD = ct.maHD join Thuoc t on\r\n" + 
				"t.mathuoc = ct.mathuoc group by hd.ngayban";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				Date date = rs.getDate(1);
				int soluong = rs.getInt(2);
				Thuoc t = new Thuoc(null, null, null, soluong, null, null, date, null, null, null);
				dsten.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsten;
	}
}
