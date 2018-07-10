2<%@page import="model.bean.Khoa"%>
<%@page import="model.bean.SinhVien"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>Danh sách sinh viên</title>
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<html:form action="/danh-sach" method="get">
				<div class="col-lg-4">
					<html:select property="maKhoa" styleClass="form-control">
						<option value="">-- Chọn khoa --</option>
						<html:optionsCollection name="danhSachSinhVienForm"
							property="listKhoa" label="tenKhoa" value="maKhoa" />
					</html:select>
				</div>
				<!-- 
				<script type="text/javascript">
					$("[name='maKhoa']")
							.val(
									'<bean:write name="danhSachSinhVienForm" property="maKhoa"/>');
				</script>
				 -->
				<html:submit styleClass="btn btn-primary">Xem</html:submit>
				<div class="col-lg-2 pull-right">
					<html:link  action="/themSV">Thêm mới</html:link> <!-- /themSV duong path -->
				</div>
			</html:form>
		</div>
		<br>
		<div class="bs-example">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>MSV</th>
						<th>Họ và tên</th>
						<th>Giới tính</th>
						<th>Khoa</th>
						<th>Chức năng</th>
					</tr>
				</thead>
				<tbody>
					<logic:iterate name="danhSachSinhVienForm" property="listSinhVien"
						id="sv">
						<tr>
							<%
								int count=0;
							%>
							<!-- value="S100": là giá trị cần để equal, attribute quan trọng-->
							<logic:equal property="msv" value="S100" name="sv">
								<h2>[<bean:write name="sv" property="msv" />, <bean:write name="sv" property="hoTen" />] Có trong list, là Người yêu cũ, not display</h2>
								<%
									count++;
								%>
							</logic:equal>
							<%
								if(count==0){								
							%>
							<td><bean:write name="sv" property="msv" /></td>
							<td><bean:write name="sv" property="hoTen" /></td>
							<td><bean:write name="sv" property="gioiTinh" /></td>
							<td><bean:write name="sv" property="tenKhoa" /></td>
							<td>
								<bean:define id="msv" name="sv" property="msv"></bean:define>
								<html:link action="/suaSV?msv=${msv}">
									<span>Sửa</span>
								</html:link> 
								<html:link action="/xoaSV?msv=${msv}" style="margin-left: 30px;">
									<span>Xóa</span>
								</html:link>
							</td>
							<%		
								}
							%>																											
							
						</tr>
					</logic:iterate>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>