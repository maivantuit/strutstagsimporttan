<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<h3>Đăng nhập hệ thống</h3>
	<br>
	<html:form action="/dang-nhap" method="post">
		<label>Tên đăng nhập</label>
		<html:text property="tenDangNhap" name="nguoidungForm"></html:text>
		<h3 style="color: red">
			<html:errors property="IDError" />
		</h3>
		<label>Khẩu khẩu</label>
		<html:password property="matKhau" name="nguoidungForm"></html:password>
		<h3 style="color: red">
			<html:errors property="PassError" />
		</h3>
		<html:submit property="submit" value="submit">Đăng nhập</html:submit>
		<button type="reset">Hủy</button>
	</html:form>
</body>
</html>