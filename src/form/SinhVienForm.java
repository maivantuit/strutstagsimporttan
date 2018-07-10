package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.Khoa;
import model.bean.SinhVien;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class SinhVienForm extends ActionForm {
	private String msv;
	private String hoTen;
	private String gioiTinh;
	private String maKhoa;
	private String tenKhoa;
	private String action;
	private ArrayList<Khoa> listKhoa;
	private String submit;
	private SinhVien sinhVien;

	/**
	 * @return the msv
	 */
	public String getMsv() {
		return msv;
	}

	/**
	 * @param msv
	 *            the msv to set
	 */
	public void setMsv(String msv) {
		this.msv = msv;
	}

	/**
	 * @return the hoTen
	 */
	public String getHoTen() {
		return hoTen;
	}

	/**
	 * @param hoTen
	 *            the hoTen to set
	 */
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	/**
	 * @return the gioiTinh
	 */
	public String getGioiTinh() {
		return gioiTinh;
	}

	/**
	 * @param gioiTinh
	 *            the gioiTinh to set
	 */
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	/**
	 * @return the maKhoa
	 */
	public String getMaKhoa() {
		return maKhoa;
	}

	/**
	 * @param maKhoa
	 *            the maKhoa to set
	 */
	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}

	/**
	 * @return the tenKhoa
	 */
	public String getTenKhoa() {
		return tenKhoa;
	}

	/**
	 * @param tenKhoa
	 *            the tenKhoa to set
	 */
	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the listKhoa
	 */
	public ArrayList<Khoa> getListKhoa() {
		return listKhoa;
	}

	/**
	 * @param listKhoa
	 *            the listKhoa to set
	 */
	public void setListKhoa(ArrayList<Khoa> listKhoa) {
		this.listKhoa = listKhoa;
	}

	/**
	 * @return the submit
	 */
	public String getSubmit() {
		return submit;
	}

	/**
	 * @param submit
	 *            the submit to set
	 */
	public void setSubmit(String submit) {
		this.submit = submit;
	}

	/**
	 * @return the sinhVien
	 */
	public SinhVien getSinhVien() {
		return sinhVien;
	}

	/**
	 * @param sinhVien
	 *            the sinhVien to set
	 */
	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
