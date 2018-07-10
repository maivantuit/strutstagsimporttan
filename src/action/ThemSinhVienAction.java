package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Khoa;
import model.bo.KhoaBO;
import model.bo.SinhVienBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;

import form.SinhVienForm;

public class ThemSinhVienAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		// tao doi tuong SinhVienForm:
		SinhVienForm sinhVienForm = (SinhVienForm) form;
		// lay danh sach khoa:
		KhoaBO khoaBO = new KhoaBO();
		ArrayList<Khoa> listKhoa=khoaBO.getListKhoa();
		sinhVienForm.setListKhoa(listKhoa);
		//validate du lieu
		if("submit".equals(sinhVienForm.getSubmit())){
			ActionErrors actionErrors = new ActionErrors();
			if(StringProcess.notVaild(sinhVienForm.getMsv()) ){
				actionErrors.add("msvError", new ActionMessage("error.msv.trong"));
			}
			if(StringProcess.notVaild(sinhVienForm.getHoTen())){
				actionErrors.add("hoTenError", new ActionMessage("error.hoten.trong"));
			}
			if(StringProcess.notVaild(sinhVienForm.getGioiTinh())){
				actionErrors.add("gioiTinhError", new ActionMessage("error.gioitinh.trong"));
			}
			if(StringProcess.notVaild(sinhVienForm.getMaKhoa())){
				actionErrors.add("khoaError", new ActionMessage("error.khoa.trong"));
			}
			saveErrors(request, actionErrors);
			if(actionErrors.size()>0){
				return mapping.findForward("themThatBai");
			}
		}
		
		// check them:
		SinhVienBO sinhvienBO= new  SinhVienBO();
		if("submit".equals(sinhVienForm.getSubmit())){
			String maKhoa= sinhVienForm.getMaKhoa();
			String msv= sinhVienForm.getMsv();
			String hoTen = sinhVienForm.getHoTen();
			String gioiTinh = sinhVienForm.getGioiTinh();
			boolean checkThem=sinhvienBO.themSinhVien(msv, hoTen, gioiTinh, maKhoa);
			if(checkThem){
				return mapping.findForward("themThanhCong");
			}else{
				return mapping.findForward("themThatBai");
			}
		}else{
			return mapping.findForward("themThatBai");
		}
		
		
		
	}
}
