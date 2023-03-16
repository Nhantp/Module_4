<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    tr>th{
        text-align: left;
    }


</style>
<body>
<h1>Tờ Khai Y Tế</h1>
<form:form action="khaiBao/create" method="post" modelAttribute="khaiBao">
    <table>
        <tr>
            <th><form:label path="ten"/>Họ Tên (ghi chữ IN HOA)</th
        </tr>
        <tr>
            <td><form:input path="ten"/></td>
        </tr>
        <tr>
            <th><form:label path="namSinh"/>Năm Sinh</th>
            <th><form:label path="gioiTinh" cssStyle="margin-left: -200px"/>Giới Tính</th>
            <th><form:label path="quocTich" cssStyle="margin-left: -100px"/>Quốc Tịch</th>
        </tr>
        <tr>
            <td><form:input path="namSinh"/></td>
            <td><form:select path="gioiTinh" items="${gioiTinh}" cssStyle="margin-left: -200px"/></td>
            <td><form:select path="quocTich" items="${quocTich}" cssStyle="margin-left: -100px"/></td>
        </tr>
        <tr>
            <th><form:label path="cmnd"/>Số hộ chiếu hoặc CMND hoặc giấy thông hành hợp pháp khác</th>
        </tr>
        <tr>
            <td><form:input path="cmnd"/></td>
        </tr>
        <tr>
            <th><form:label path="thongTinDiLai"/>Thông Tin Đi Lại</th>
        </tr>
        <tr>
            <td><form:radiobuttons path="thongTinDiLai" items="${thongTinDiLai}"/></td>
        </tr>
        <tr>
            <th><form:label path="soPhuongTien"/>Số Phương Tiện</th>
            <th><form:label path="soGhe" cssStyle="margin-left: -200px"/>Số Ghế</th>
        </tr>
        <tr>
            <td><form:input path="soPhuongTien"/></td>
            <td><form:input path="soGhe" cssStyle="margin-left: -200px"/></td>
        </tr>
        <tr>
            <th><form:label path="ngayKhoiHanh"/>Ngày Khởi Hành</th>
            <th><form:label path="ngayKetThuc" cssStyle="margin-left: -200px"/>Ngày Kết Thúc</th>
        </tr>
        <tr>
            <td><form:input path="ngayKhoiHanh"/></td>
            <td><form:input path="ngayKetThuc" cssStyle="margin-left: -200px"/></td>
        </tr>
        <tr>
            <th><form:label path="trong14Ngay"/>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?</th>
        </tr>
        <tr>
            <td><form:input path="trong14Ngay"/></td>
        </tr>
        <tr>
            <th><form:label path="diaChiLienLac"/>Địa chỉ liên lạc</th>
        </tr>
        <tr>
            <td><form:input path="diaChiLienLac"/></td>
        </tr>
        <tr>
            <th><form:label path="diaChiNoiO"/>Địa chỉ nơi ở</th>
        </tr>
        <tr>
            <td><form:input path="diaChiNoiO"/></td>
        </tr>
        <tr>
            <th><form:label path="dienThoai"/>Điện Thoại</th>
            <th><form:label path="email" cssStyle="margin-left: -200px"/>Email</th>
        </tr>
        <tr>
            <td><form:input path="dienThoai" /></td>
            <td><form:input path="email" cssStyle="margin-left: -200px"/></td>
        </tr>
        <tr>

        </tr>
        <tr>
            <td>
            <table border="2">
                <tr>
                    <th>Triệu Chứng</th>
                    <th>Có       Không</th>
                </tr>
                <tr>
                    <td><form:label path="sot"/>Sốt</td>
                    <td><form:radiobuttons path="sot" items="${yKien}"/></td>
                </tr>
                <tr>
                    <td><form:label path="ho"/>Ho</td>
                    <td><form:radiobuttons path="ho" items="${yKien}"/></td>
                </tr>
                <tr>
                    <td><form:label path="khoTho"/>Khó Thở</td>
                    <td><form:radiobuttons path="khoTho" items="${yKien}"/></td
                </tr>
                <tr>
                    <td><form:label path="dauHong"/>Đau Họng</td>
                    <td><form:radiobuttons path="dauHong" items="${yKien}"/></td>
                </tr>
            </table>
            </td>
            <td>
            <table border="2">
                <tr>
                    <th>Triệu Chứng</th>
                    <th>Có       Không</th>
                </tr>
                <tr>
                    <td><form:label path="non"/>Nôn</td>
                    <td><form:radiobuttons path="non" items="${yKien}"/></td>
                </tr>
                <tr>
                    <td><form:label path="tieuChay"/>Tiêu Chảy</td>
                    <td><form:radiobuttons path="tieuChay" items="${yKien}"/></td>
                </tr>
                <tr>
                    <td><form:label path="xuatHuyet"/>Xuất Huyết Ngoài Da</td>
                    <td><form:radiobuttons path="xuatHuyet" items="${yKien}"/></td>
                </tr>
                <tr>
                    <td><form:label path="noiBan"/>Nổi Ban Ngoài Da</td>
                    <td><form:radiobuttons path="noiBan" items="${yKien}"/></td>
                </tr>
            </table>
            </td>
        <tr>
        <td><input type="submit" value="Khai Bao"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
