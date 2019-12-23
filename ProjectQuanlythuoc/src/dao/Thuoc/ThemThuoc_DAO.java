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
import entities.Thuoc;

public class ThemThuoc_DAO {
	public ThemThuoc_DAO() {
		
	}
	public boolean taoThuoc(Thuoc t) {
		Connection connection = ConnectDB.getInstance().getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = connection.prepareStatement("insert into Thuoc values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setString(1, t.getMaThuoc());
			statement.setString(2, t.getTenThuoc());
			statement.setString(3, t.getMaDonvi().getMaDonvi());
			statement.setDouble(4, t.getDonGia());
			statement.setString(5, t.getMaNhaCC().getMaNhaCC());
			statement.setString(6, t.getMaNuoc().getMaLoai());
			statement.setString(7, t.getDanhMucthuoc());
			statement.setString(8, t.getTinhTrang());
			statement.setDate(9, t.getNgayNhap());
			statement.setDate(10, t.getNgayHethan());
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
	public List<String> checktrungma() {
		List<String> dsten = new ArrayList<String>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select mathuoc from Thuoc";
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
}
