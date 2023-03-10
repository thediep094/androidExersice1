package com.example.mytest;

public class Work {

    String ten, noidung, gioitinh, ngayhoanthanh;

    public Work(String ten, String noidung, String gioitinh, String ngayhoanthanh) {
        this.ten = ten;
        this.noidung = noidung;
        this.gioitinh = gioitinh;
        this.ngayhoanthanh = ngayhoanthanh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNgayhoanthanh() {
        return ngayhoanthanh;
    }

    public void setNgayhoanthanh(String ngayhoanthanh) {
        this.ngayhoanthanh = ngayhoanthanh;
    }
}
