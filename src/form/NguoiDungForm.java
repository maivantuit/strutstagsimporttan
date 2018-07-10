package form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;

public class NguoiDungForm extends ActionForm{
	private String tenDangNhap; // Form: chua cac thuoc tinh lien quan den chuc nang cua minh.
								// bean: cung chua cac thuoc tinh, nhung de get du lieu len ArrayList<KhachHang>.
	private String matKhau;
	private String thongBao;
	/**
	 * @return the tenDangNhap
	 */
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	/**
	 * @param tenDangNhap the tenDangNhap to set
	 */
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	/**
	 * @return the matKhau
	 */
	public String getMatKhau() {
		return matKhau;
	}
	/**
	 * @param matKhau the matKhau to set
	 */
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	/**
	 * @return the thongBao
	 */
	public String getThongBao() {
		return thongBao;
	}
	/**
	 * @param thongBao the thongBao to set
	 */
	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors actionErrors =new ActionErrors();
		if(StringProcess.notVaild(tenDangNhap)){
			actionErrors.add("tenDangNhapError", new ActionMessage("error.tenDangNhap"));
		}
		if(StringProcess.notVaild(matKhau)){
			actionErrors.add("matKhauError", new ActionMessage("error.matKhau"));
		}
		return actionErrors;
	}
	
	
}
