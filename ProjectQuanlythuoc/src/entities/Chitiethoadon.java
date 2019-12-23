package entities;

public class Chitiethoadon {
	private Hoadon maHoadon;
	private Thuoc maThuoc;
	private int soLuong;
	public Chitiethoadon(Hoadon maHoadon, Thuoc maThuoc, int soLuong) {
		this.maHoadon = maHoadon;
		this.maThuoc = maThuoc;
		this.soLuong = soLuong;
	}
	public Chitiethoadon() {
		// TODO Auto-generated constructor stub
	}
	
	public Chitiethoadon(int soLuong) {
		this.soLuong = soLuong;
	}
	public Hoadon getMaHoadon() {
		return maHoadon;
	}
	public void setMaHoadon(Hoadon maHoadon) {
		this.maHoadon = maHoadon;
	}
	public Thuoc getMaThuoc() {
		return maThuoc;
	}
	public void setMaThuoc(Thuoc maThuoc) {
		this.maThuoc = maThuoc;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return "Chitiethoadon [maHoadon=" + maHoadon + ", maThuoc=" + maThuoc + ", soLuong=" + soLuong + "]";
	}
	public long tongTien() {
		return (long) (maThuoc.getDonGia()* soLuong);
	}

}
