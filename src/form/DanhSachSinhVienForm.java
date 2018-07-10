package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.Khoa;
import model.bean.SinhVien;

public class DanhSachSinhVienForm extends ActionForm{
	private String maKhoa;
	private ArrayList<Khoa> listKhoa;
	private ArrayList<SinhVien> listSinhVien;
	/**
	 * @return the maKhoa
	 */
	public String getMaKhoa() {
		return maKhoa;
	}
	/**
	 * @param maKhoa the maKhoa to set
	 */
	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}
	/**
	 * @return the listKhoa
	 */
	public ArrayList<Khoa> getListKhoa() {
		return listKhoa;
	}
	/**
	 * @param listKhoa the listKhoa to set
	 */
	public void setListKhoa(ArrayList<Khoa> listKhoa) {
		this.listKhoa = listKhoa;
	}
	/**
	 * @return the listSinhVien
	 */
	public ArrayList<SinhVien> getListSinhVien() {
		return listSinhVien;
	}
	/**
	 * @param listSinhVien the listSinhVien to set
	 */
	public void setListSinhVien(ArrayList<SinhVien> listSinhVien) {
		this.listSinhVien = listSinhVien;
	}
	
	
}
