
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sửa sinh viên</title>
</head>
<body>
	<div>
		<h3>
			Sửa sinh viên:
			<bean:write property="hoTen" name="sinhVienForm" />
		</h3>
	</div>
	<html:form action="/suaSV" method="post">
		<div>
		<div>		
			<div>
				<label>Mã sinh viên</label>
			</div>
			<div>
				<html:text property="msv" readonly="true"></html:text>
			</div>
		</div>
		<div>
			<div>
				<label>Họ tên</label>
			</div>
			<div>
				<html:text property="hoTen"></html:text>
			</div>
		</div>
		<div>
			<div>
				<label>Giới tính</label>
			</div>
			<div>
				<html:radio property="gioiTinh" value="1">Nam</html:radio>
				<html:radio property="gioiTinh" value="0">Nữ</html:radio>
			</div>
		</div>
		<div>
			<div>
				<label>Khoa</label>
			</div>
			<div>
				<html:select property="maKhoa">
					<option value="">--Chọn Khoa--</option>
					<html:optionsCollection name="sinhVienForm" property="listKhoa" label="tenKhoa" value="maKhoa" />
				</html:select>
			</div>
		</div>
	</div>
	<div>
		<html:submit property="submit" value="submit">Sửa</html:submit>
		<button>Quay lại</button>
	</div>
	</html:form>
</body>
</html>