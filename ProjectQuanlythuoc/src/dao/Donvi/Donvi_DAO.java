package dao.Donvi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectDB;
import entities.Donvithuoc;
import entities.Nuoc;

public class Donvi_DAO {
	public Donvi_DAO() {
		// TODO Auto-generated constructor stub
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
	public List<Donvithuoc> getAllDonVi() {
		List<Donvithuoc> dsdonvi = new ArrayList<Donvithuoc>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select * from DonViThuoc";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				Donvithuoc donvi = new Donvithuoc(ma, ten);
				dsdonvi.add(donvi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsdonvi;
	}
	public boolean taoDonvi(Donvithuoc dv) {
		Connection connection = ConnectDB.getInstance().getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("insert into DonViThuoc values(?, ?)");
			statement.setString(1, dv.getMaDonvi());
			statement.setString(2, dv.getTenDonvi());
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
	public boolean updateDonvi(Donvithuoc dv) {
		PreparedStatement stmt = null;
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "update DonViThuoc set tendonvi = ? where madonvi = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, dv.getTenDonvi());
			stmt.setString(2, dv.getMaDonvi());
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
	public boolean deleteDonvi(String ma) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("delete from DonViThuoc where madonvi = ?");
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
