package entities;

public class Khachhang {
	private String maKH;
	private String hoten;
	private String sdt;
	private String diaChi;
	public Khachhang(String maKH, String hoten, String sdt, String diaChi) {
		this.maKH = maKH;
		this.hoten = hoten;
		this.sdt = sdt;
		this.diaChi = diaChi;
	}
	public Khachhang(String maKH) {
		this.maKH = maKH;
	}
	public Khachhang(String hoten, String sdt, String diaChi) {
		this.hoten = hoten;
		this.sdt = sdt;
		this.diaChi = diaChi;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maKH == null) ? 0 : maKH.hashCode());
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
		Khachhang other = (Khachhang) obj;
		if (maKH == null) {
			if (other.maKH != null)
				return false;
		} else if (!maKH.equalsIgnoreCase(other.maKH))
			return false;
		return true;
	}
	

}
