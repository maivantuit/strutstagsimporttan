package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.NguoiDungBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;

import form.NguoiDungForm;

public class NguoiDungAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		NguoiDungForm nguoidungForm = (NguoiDungForm) form;//Not: new NguoiDungForm();
		NguoiDungBO nguoidungBO = new NguoiDungBO();
		// from request of client:
		String tenDangNhap = nguoidungForm.getTenDangNhap();
		String matKhau = nguoidungForm.getMatKhau();
//		if(true){
//			ActionErrors actionErrors = new ActionErrors();
//			if(StringProcess.notVaild(tenDangNhap) ){
//				actionErrors.add("IDError", new ActionMessage("error.tenDangNhap"));
//			}
//			if(StringProcess.notVaild(matKhau)){
//				actionErrors.add("PassError", new ActionMessage("error.matKhau"));
//			}			
//			saveErrors(request, actionErrors);
//			if(actionErrors.size()>0){
//				return mapping.findForward("thatBai");
//			}
//		}
		if(nguoidungBO.checkLogin(tenDangNhap, matKhau)){
			return mapping.findForward("thanhCong");
		}else{
			return mapping.findForward("thatBai");
		}				
	}
}
