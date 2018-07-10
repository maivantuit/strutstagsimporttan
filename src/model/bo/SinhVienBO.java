package model.bo;

import java.util.ArrayList;

import model.bean.SinhVien;
import model.dao.SinhVienDAO;

public class SinhVienBO {
	SinhVienDAO sinhvienDAO = new SinhVienDAO();

	// lay tat ca bang sinh vien:
	public ArrayList<SinhVien> getListSinhVien() {
		return sinhvienDAO.getListSinhVien();
	}

	// lay danh sach sinh vien bang ma khoa:
	public ArrayList<SinhVien> getListSinhVien(String maKhoa) {
		return sinhvienDAO.getListSinhVien(maKhoa);
	}

	// them sinh vien:
	public boolean themSinhVien(String msv, String hoTen, String gioiTinh,
			String maKhoa) {
		return sinhvienDAO.themSinhVien(msv, hoTen, gioiTinh, maKhoa);
	}

	// sua sinh vien:
	public boolean suaSinhVien(String msv, String hoTen, String gioiTinh,
			String maKhoa) {
		return sinhvienDAO.suaSinhVien(msv, hoTen, gioiTinh, maKhoa);
	}

	// get sinh vien bang ma sinh vien:
	public SinhVien getThongTinSinhVien(String msv) {
		return sinhvienDAO.getThongTinSinhVien(msv);
	}

	// xoa sinh vien:
	public boolean xoaSinhVien(String msv) {
		return sinhvienDAO.xoaSinhVien(msv);
	}
}
