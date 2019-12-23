package entities;

public class Nguoidung {
	private Taikhoan taiKhoan;
	private String hoten;
	private String gioiTinh;
	private String diachi;
	private String chucVu;
	
	public Nguoidung(Taikhoan taiKhoan, String hoten, String gioiTinh, String diachi, String chucVu) {
		this.taiKhoan = taiKhoan;
		this.hoten = hoten;
		this.gioiTinh = gioiTinh;
		this.diachi = diachi;
		this.chucVu = chucVu;
	}
	public Nguoidung() {
		// TODO Auto-generated constructor stub
	}
	public Nguoidung(Taikhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public Taikhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(Taikhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	@Override
	public String toString() {
		return "Nguoidung [taiKhoan=" + taiKhoan + ", hoten=" + hoten + ", gioiTinh=" + gioiTinh + ", diachi=" + diachi
				+ ", chucVu=" + chucVu + "]";
	}

}
