package entities;

import java.util.Date;

public class Hoadon {
	private String maHoaDon;
	private Khachhang maKH;
	private Nguoidung maNgdung;
	private Date ngayLap;
	public Hoadon(String maHoaDon, Khachhang maKH, Nguoidung maNgdung, Date ngayLap) {
		this.maHoaDon = maHoaDon;
		this.maKH = maKH;
		this.maNgdung = maNgdung;
		this.ngayLap = ngayLap;
	}
	public Hoadon() {
		// TODO Auto-generated constructor stub
	}
	public Hoadon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public Khachhang getMaKH() {
		return maKH;
	}
	public void setMaKH(Khachhang maKH) {
		this.maKH = maKH;
	}
	public Nguoidung getMaNgdung() {
		return maNgdung;
	}
	public void setMaNgdung(Nguoidung maNgdung) {
		this.maNgdung = maNgdung;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	@Override
	public String toString() {
		return "Hoadon [maHoaDon=" + maHoaDon + ", maKH=" + maKH + ", maNgdung=" + maNgdung + ", ngayLap=" + ngayLap
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHoaDon == null) ? 0 : maHoaDon.hashCode());
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
		Hoadon other = (Hoadon) obj;
		if (maHoaDon == null) {
			if (other.maHoaDon != null)
				return false;
		} else if (!maHoaDon.equalsIgnoreCase(other.maHoaDon))
			return false;
		return true;
	}
	

}
