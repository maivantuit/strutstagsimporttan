<%@ page import="model.bean.*" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Xóa sinh viên</title>
</head>
<body>
	<div>
		<div>
			<h2>Xóa sinh viên: <bean:write name="sinhVienForm" property="hoTen"/> </h2>
		</div>
		<div>
			<html:form action="/xoaSV" method="post">
				<!-- So sánh với 1 biến riêng biệt 
					1. equal.
					2. !equal.
				-->
				<logic:equal value="S100" property="msv" name="sinhVienForm">
					<h2>Không được xóa: <bean:write  property="msv" name="sinhVienForm"/> <bean:write property="hoTen" name="sinhVienForm"/></h2>
				</logic:equal>
				
				<logic:notEqual value="SV099" property="msv" name="sinhVienForm">
					<h2>Cứ xóa bình thường: <bean:write  property="msv" name="sinhVienForm"/> <bean:write property="hoTen" name="sinhVienForm"/></h2>
				</logic:notEqual>
				<div>
					<h2>Mã sinh viên</h2>
					<html:text readonly="true" property="msv"></html:text>
				</div>
				<div>
					<h2>Họ tên</h2>
					<html:text readonly="true" property="hoTen"></html:text>
				</div>
				<div>
					<h2>Giới tính</h2>
					<html:radio  disabled="true" property="gioiTinh" value="1">Nam</html:radio>
					<html:radio  disabled="true" property="gioiTinh" value="0">Nữ</html:radio>
				</div>
				<div>
					<h2>Khoa</h2>
					<html:select property="maKhoa" disabled="true" >
						<html:optionsCollection name="sinhVienForm" property="listKhoa" label="tenKhoa" value="maKhoa"/>
					</html:select>
				</div>
				<div>
					<html:submit styleClass="btnSubmit"  property="submit" value="submit"></html:submit>
					<button>Quay lại</button>
				</div>
			</html:form>
		</div>
	</div>

</body>
</html>