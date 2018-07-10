package model.bo;

import model.dao.NguoiDungDAO;

public class NguoiDungBO {
	NguoiDungDAO nguoidungDAO = new NguoiDungDAO();

	public boolean checkLogin(String tenDangNhap, String matKhau) {
		return nguoidungDAO.checkLogin(tenDangNhap, matKhau);
	}
}
