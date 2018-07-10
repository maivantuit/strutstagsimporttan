package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.SinhVien;
import model.bo.KhoaBO;
import model.bo.SinhVienBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.SinhVienForm;

public class SuaSinhVienAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		// form sinh vien:
		SinhVienForm sinhVienForm = (SinhVienForm)form;
		
		//lay danh sach khoa:
		KhoaBO khoaBO = new KhoaBO();
		ArrayList listKhoa=khoaBO.getListKhoa();
		sinhVienForm.setListKhoa(listKhoa);
		
		// lay ma sinh tu action sua(lay tu hai cho, 1:tu submit, 2: link Sua ):
		String msv= sinhVienForm.getMsv();
		// check sua:
		SinhVienBO sinhVienBO = new SinhVienBO();		
		if("submit".equals(sinhVienForm.getSubmit())){			
			String hoTen= sinhVienForm.getHoTen();
			String gioiTinh= sinhVienForm.getGioiTinh();
			String maKhoa = sinhVienForm.getMaKhoa();
			boolean checkSua=sinhVienBO.suaSinhVien(msv, hoTen, gioiTinh, maKhoa);
			if(checkSua){
				return mapping.findForward("suaThanhCong");
			}else{
				return mapping.findForward("suaThatBai");
			}
		}else{
			SinhVien sinhVien = sinhVienBO.getThongTinSinhVien(msv);
			sinhVienForm.setMsv(msv);
			sinhVienForm.setHoTen(sinhVien.getHoTen());
			sinhVienForm.setGioiTinh(sinhVien.getGioiTinh());
			sinhVienForm.setMaKhoa(sinhVien.getMaKhoa());
			return mapping.findForward("suaThatBai");
		}
		
	}
}
