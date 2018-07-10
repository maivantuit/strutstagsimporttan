
<%@page import="model.bean.Khoa"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title><bean:message key="title.themsinhvien" /></title>	
	</head>
	<body>
		<div class="container">
			<h3><bean:message key="h3.themsinhvien" /></h3>
			<br>
			<html:form action="/themSV" method="post"> <!--/themSV: Đường dẫn -->
				<div class="row form-group">
					<label><bean:message key="field.masv" /></label>
					<div>
						<html:text property="msv"></html:text>
					</div>
					<h3 style="color:red">
						<html:errors property="msvError"/>
					</h3>
				</div>
				<div>
					<label><bean:message key="field.hoten" /></label>
					<div>
						<html:text property="hoTen"></html:text>
					</div>
					<h3 style="color:red">
						<html:errors property="hoTenError"/>
					</h3>
				</div>
				<div>
					<label><bean:message key="field.gioitinh"/></label>
					<div>
						<html:text property="gioiTinh"></html:text>
					</div>
					<h3 style="color:red">
						<html:errors property="gioiTinhError"/>
					</h3>
				</div>
				<div>
					<label><bean:message key="field.khoa"/></label>
					<div>
						<html:select property="maKhoa">
							<option value=""><bean:message key="combo.chonkhoa"/></option>
							<html:optionsCollection name="sinhVienForm" property="listKhoa" label="tenKhoa" value="maKhoa"/>
						</html:select>
					</div>
					<h3 style="color:red">
						<html:errors property="khoaError"/>
					</h3>
				</div>
				<div>
					<div>
						<html:submit property="submit" value="submit"></html:submit>
						<html:button property="" value="Quay lại"></html:button>
					</div>
				</div>
			</html:form>
		</div>
	
	</body>
</html>