package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.SinhVien;

public class SinhVienDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=JavaEE_Example";
	String userName = "sa";
	String password = "123";
	Connection connection;

	void connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Ket noi thanh cong");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		}
	}
	// lay tat ca bang sinh vien:
	public ArrayList<SinhVien> getListSinhVien() {
		connect();
		String sql=	"SELECT sv.msv, sv.HoTen, sv.GioiTinh, k.TenKhoa"+
					" FROM   SinhVien sv INNER JOIN Khoa AS k ON k.MaKhoa = sv.MaKhoa";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		SinhVien sinhVien;
		try {
			while(rs.next()){
				sinhVien = new SinhVien();
				sinhVien.setMsv(rs.getString("msv"));
				sinhVien.setHoTen(rs.getString("HoTen"));
				sinhVien.setGioiTinh(rs.getString("GioiTinh"));
				sinhVien.setTenKhoa(rs.getString("TenKhoa"));
				list.add(sinhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	// lay danh sach sinh vien bang ma khoa:
	public ArrayList<SinhVien> getListSinhVien(String maKhoa) {
		connect();
		String sql=	String.format("SELECT sv.msv, sv.HoTen, sv.GioiTinh, k.TenKhoa"+
					" FROM   SinhVien sv INNER JOIN Khoa AS k ON k.MaKhoa = sv.MaKhoa"+
					" WHERE sv.MaKhoa = '%s'", maKhoa);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		SinhVien sinhVien;
		try {
			while(rs.next()){
				sinhVien = new SinhVien();
				sinhVien.setMsv(rs.getString("msv"));
				sinhVien.setHoTen(rs.getString("HoTen"));
				sinhVien.setGioiTinh(rs.getString("GioiTinh"));
				sinhVien.setTenKhoa(rs.getString("TenKhoa"));
				list.add(sinhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	// them sinh vien:
	public boolean themSinhVien(String msv, String hoTen, String gioiTinh, String maKhoa) {
		connect();
		String sql=	String.format("INSERT INTO SinhVien(msv,HoTen,GioiTinh,MaKhoa) "+
					" VALUES ( '%s',N'%s','%s','%s' )", msv, hoTen, gioiTinh, maKhoa);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// sua sinh vien:
	public boolean suaSinhVien(String msv, String hoTen, String gioiTinh, String maKhoa) {
		connect();
		String sql=	String.format("UPDATE SinhVien "+
					" SET HoTen = N'%s', GioiTinh = %s, MaKhoa = '%s' " +
					" WHERE msv = '%s'", hoTen, gioiTinh, maKhoa, msv);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// get sinh vien bang ma sinh vien:
	public SinhVien getThongTinSinhVien(String msv) {
		connect();
		String sql=	String.format("SELECT HoTen, GioiTinh, MaKhoa, msv "+
					" FROM SinhVien WHERE msv = '%s'", msv);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		SinhVien sinhVien = new SinhVien();
		try {
			while(rs.next()){
				sinhVien.setMsv(msv);
				sinhVien.setHoTen(rs.getString("HoTen"));
				sinhVien.setGioiTinh(rs.getString("GioiTinh"));
				sinhVien.setMaKhoa(rs.getString("MaKhoa"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sinhVien;
	}
	// xoa sinh vien:
	public boolean xoaSinhVien(String msv) {
		connect();
		String sql=	String.format("DELETE FROM SinhVien WHERE msv = '%s'", msv);	
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  false;
	}
	public static void main(String[] args) {
		SinhVienDAO sinhVienDAO = new SinhVienDAO();
		boolean checkThem = sinhVienDAO.xoaSinhVien("SV30");
		if(checkThem){
			System.out.println("ok");
		}else{
			System.out.println("not oke");
		}
	}
	
}
