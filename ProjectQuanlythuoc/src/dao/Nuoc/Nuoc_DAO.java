package dao.Nuoc;

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
import entities.Nhacungcap;
import entities.Nuoc;
import entities.Thuoc;

public class Nuoc_DAO {
	public Nuoc_DAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean taoNuoc(Nuoc n) {
		Connection connection = ConnectDB.getInstance().getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("insert into Nuoc values(?, ?)");
			statement.setString(1, n.getMaLoai());
			statement.setString(2, n.getTenLoai());
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
		String sql = "select manuoc from Nuoc";
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
	public List<Nuoc> getAllNuoc() {
		List<Nuoc> dsNuoc = new ArrayList<Nuoc>();
		Connection connection = new ConnectDB().getInstance().getConnection();
		String sql = "select * from Nuoc";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				Nuoc nuoc = new Nuoc(ma, ten);
				dsNuoc.add(nuoc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsNuoc;
	}
	public boolean updateNuoc(Nuoc n) {
		PreparedStatement stmt = null;
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "update Nuoc set tennuoc = ? where manuoc = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, n.getTenLoai());
			stmt.setString(2, n.getMaLoai());
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
	public boolean deleteNuoc(String ma) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("delete from Nuoc where manuoc = ?");
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
