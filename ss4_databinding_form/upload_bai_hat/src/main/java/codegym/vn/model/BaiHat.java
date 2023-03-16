package codegym.vn.model;

public class BaiHat {
    private String tenBaiHat;
    private String ngheSi;
    private String theLoaiNhac;
    private String duongDan;

    public BaiHat(String tenBaiHat, String ngheSi, String theLoaiNhac, String duongDan) {
        this.tenBaiHat = tenBaiHat;
        this.ngheSi = ngheSi;
        this.theLoaiNhac = theLoaiNhac;
        this.duongDan = duongDan;
    }

    public BaiHat() {
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getNgheSi() {
        return ngheSi;
    }

    public void setNgheSi(String ngheSi) {
        this.ngheSi = ngheSi;
    }

    public String getTheLoaiNhac() {
        return theLoaiNhac;
    }

    public void setTheLoaiNhac(String theLoaiNhac) {
        this.theLoaiNhac = theLoaiNhac;
    }

    public String getDuongDan() {
        return duongDan;
    }

    public void setDuongDan(String duongDan) {
        this.duongDan = duongDan;
    }
}
