package entities;

public class Donvithuoc {
	private String maDonvi;
	private String tenDonvi;
	public Donvithuoc(String maDonvi, String tenDonvi) {
		this.maDonvi = maDonvi;
		this.tenDonvi = tenDonvi;
	}
	public Donvithuoc() {
		// TODO Auto-generated constructor stub
	}
	
	public Donvithuoc(String maDonvi) {
		this.maDonvi = maDonvi;
	}
	public String getMaDonvi() {
		return maDonvi;
	}
	public void setMaDonvi(String maDonvi) {
		this.maDonvi = maDonvi;
	}
	public String getTenDonvi() {
		return tenDonvi;
	}
	public void setTenDonvi(String tenDonvi) {
		this.tenDonvi = tenDonvi;
	}
	@Override
	public String toString() {
		return "Donvithuoc [maDonvi=" + maDonvi + ", tenDonvi=" + tenDonvi + "]";
	}
	

}
