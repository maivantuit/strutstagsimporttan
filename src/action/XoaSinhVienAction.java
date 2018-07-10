package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Khoa;
import model.bean.SinhVien;
import model.bo.KhoaBO;
import model.bo.SinhVienBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.SinhVienForm;

public class XoaSinhVienAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		SinhVienForm sinhVienForm = (SinhVienForm) form;
		// lay ma sinh vien tu danh sach sinh vien:
		String msv = sinhVienForm.getMsv();		
		SinhVienBO sinhVienBO = new SinhVienBO();
		

		// lay danh sach khoa:
		KhoaBO khoaBO = new KhoaBO();
		ArrayList<Khoa> listKhoa = khoaBO.getListKhoa();
		sinhVienForm.setListKhoa(listKhoa);
		// submit de xoa:
		if ("submit".equals(sinhVienForm.getSubmit())) {
			boolean checkXoa = sinhVienBO.xoaSinhVien(msv);
			if (checkXoa) {
				return mapping.findForward("xoaThanhCong");
			} else {
				return mapping.findForward("xoaThatBai");
			}
		} else {
			// lay thong sinh vien:
			SinhVien sinhVien = sinhVienBO.getThongTinSinhVien(msv);
			sinhVienForm.setMsv(sinhVien.getMsv());
			sinhVienForm.setHoTen(sinhVien.getHoTen());
			sinhVienForm.setGioiTinh(sinhVien.getGioiTinh());
			sinhVienForm.setMaKhoa(sinhVien.getMaKhoa());
			return mapping.findForward("xoaThatBai");
		}

	}
}
