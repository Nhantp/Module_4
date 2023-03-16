<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nhân
  Date: 3/16/2023
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Khai Bao Y Te</h1>
    <table border="1">
        <tr>
            <th>Họ Tên</th>
            <th>Năm Sinh</th>
            <th>Giới Tính</th>
            <th>Quốc Tịch</th>
            <th>CMND</th>
            <th>Thông Tin Đi Lại</th>
            <th>Số Phương Tiện</th>
            <th>Số Ghế</th>
            <th>Ngày Khởi Hành</th>
            <th>Ngày Kết Thúc</th>
            <th>Thông tin trong 14 ngày</th>
            <th>Địa Chỉ Liên Lạc</th>
            <th>Địa Chỉ Nơi Ở</th>
            <th>Điện Thoại</th>
            <th>Email</th>
            <th>Sốt</th>
            <th>Ho</th>
            <th>Khó Thở</th>
            <th>Đau Họng</th>
            <th>Nôn</th>
            <th>Tiêu Chảy</th>
            <th>Xuất Huyết</th>
            <th>Nổi Ban</th>
            <th>Tiếp Xúc Với Động Vật</th>
            <th>Tiếp Xúc Với Người</th>
        </tr>
       <c:forEach items="${khaiBao}" var="k">
           <tr>
                <td>${k.ten}</td>
                <td>${k.namSinh}</td>
                <td>${k.gioiTinh}</td>
                <td>${k.quocTich}</td>
                <td>${k.cmnd}</td>
                <td>${k.thongTinDiLai}</td>
                <td>${k.soPhuongTien}</td>
                <td>${k.soGhe}</td>
                <td>${k.ngayKhoiHanh}</td>
                <td>${k.ngayKetThuc}</td>
                <td>${k.trong14Ngay}</td>
                <td>${k.diaChiLienLac}</td>
                <td>${k.diaChiNoiO}</td>
                <td>${k.dienThoai}</td>
                <td>${k.email}</td>
                <td>${k.sot}</td>
                <td>${k.ho}</td>
                <td>${k.khoTho}</td>
                <td>${k.non}</td>
                <td>${k.tieuChay}</td>
                <td>${k.xuatHuyet}</td>
                <td>${k.noiBan}</td>
                <td>${k.tiepXucDV}</td>
                <td>${k.tiepXucGan}</td>
           </tr>
       </c:forEach>
    </table>
</body>
</html>
