package entities;

import java.sql.Date;

public class Thuoc {
	private String maThuoc;
	private String tenThuoc;
	private String tinhTrang;
	private double donGia;
	private String danhMucthuoc;
	private Date ngayNhap;
	private Date ngayHethan;
	private Donvithuoc maDonvi;
	private Nuoc maNuoc;
	private Nhacungcap maNhaCC;

	public Thuoc(String maThuoc, String tenThuoc, String tinhTrang) {
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.tinhTrang = tinhTrang;
	}
	public Thuoc(String maThuoc, String tenThuoc, String tinhTrang, double donGia, String danhMucthuoc, Date ngayNhap,
			Date ngayHethan, Donvithuoc maDonvi, Nuoc maNuoc, Nhacungcap maNhaCC) {
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.tinhTrang = tinhTrang;
		this.donGia = donGia;
		this.danhMucthuoc = danhMucthuoc;
		this.ngayNhap = ngayNhap;
		this.ngayHethan = ngayHethan;
		this.maDonvi = maDonvi;
		this.maNuoc = maNuoc;
		this.maNhaCC = maNhaCC;
	}
	public String getMaThuoc() {
		return maThuoc;
	}
	public Thuoc(String maThuoc) {
		this.maThuoc = maThuoc;
	}

	public void setMaThuoc(String maThuoc) {
		this.maThuoc = maThuoc;
	}
	public String getTenThuoc() {
		return tenThuoc;
	}
	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getDanhMucthuoc() {
		return danhMucthuoc;
	}
	public void setDanhMucthuoc(String danhMucthuoc) {
		this.danhMucthuoc = danhMucthuoc;
	}
	public Donvithuoc getMaDonvi() {
		return maDonvi;
	}
	public void setMaDonvi(Donvithuoc maDonvi) {
		this.maDonvi = maDonvi;
	}
	public Nuoc getMaNuoc() {
		return maNuoc;
	}
	public void setMaNuoc(Nuoc maNuoc) {
		this.maNuoc = maNuoc;
	}
	public Nhacungcap getMaNhaCC() {
		return maNhaCC;
	}
	public void setMaNhaCC(Nhacungcap maNhaCC) {
		this.maNhaCC = maNhaCC;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public Date getNgayHethan() {
		return ngayHethan;
	}
	public void setNgayHethan(Date ngayHethan) {
		this.ngayHethan = ngayHethan;
	}
	@Override
	public String toString() {
		return "Thuoc [maThuoc=" + maThuoc + ", tenThuoc=" + tenThuoc + ", tinhTrang=" + tinhTrang + ", donGia="
				+ donGia + ", danhMucthuoc=" + danhMucthuoc + ", ngayNhap=" + ngayNhap + ", ngayHethan=" + ngayHethan
				+ ", maDonvi=" + maDonvi + ", maNuoc=" + maNuoc + ", maNhaCC=" + maNhaCC + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maThuoc == null) ? 0 : maThuoc.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thuoc other = (Thuoc) obj;
		if (maThuoc == null) {
			if (other.maThuoc != null)
				return false;
		} else if (!maThuoc.equalsIgnoreCase(other.maThuoc))
			return false;
		return true;
	}


}
