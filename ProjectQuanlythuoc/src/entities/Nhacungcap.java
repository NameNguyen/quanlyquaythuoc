package entities;

public class Nhacungcap {

	private String maNhaCC;
	private String tenNhaCC;
	private String email;
	private String sdt;
	private String diachi;
	public Nhacungcap(String maNhaCC, String tenNhaCC, String email, String sdt, String diachi) {
		this.maNhaCC = maNhaCC;
		this.tenNhaCC = tenNhaCC;
		this.email = email;
		this.sdt = sdt;
		this.diachi = diachi;
	}
	public Nhacungcap() {
		// TODO Auto-generated constructor stub
	}
	public Nhacungcap(String maNhaCC) {
		this.maNhaCC = maNhaCC;
	}
	public String getMaNhaCC() {
		return maNhaCC;
	}
	public void setMaNhaCC(String maNhaCC) {
		this.maNhaCC = maNhaCC;
	}
	public String getTenNhaCC() {
		return tenNhaCC;
	}
	public void setTenNhaCC(String tenNhaCC) {
		this.tenNhaCC = tenNhaCC;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	@Override
	public String toString() {
		return "Nhacungcap [maNhaCC=" + maNhaCC + ", tenNhaCC=" + tenNhaCC + ", email=" + email + ", sdt=" + sdt
				+ ", diachi=" + diachi + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNhaCC == null) ? 0 : maNhaCC.hashCode());
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
		Nhacungcap other = (Nhacungcap) obj;
		if (maNhaCC == null) {
			if (other.maNhaCC != null)
				return false;
		} else if (!maNhaCC.equalsIgnoreCase(other.maNhaCC))
			return false;
		return true;
	}
	
	
}
