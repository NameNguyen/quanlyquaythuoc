package entities;

public class Taikhoan {

	private String userName;
	private String passWord;
	public Taikhoan(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}
	public Taikhoan(String passWord) {
		this.passWord = passWord;
	}

	public Taikhoan() {
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Override
	public String toString() {
		return "Taikhoan [userName=" + userName + ", passWord=" + passWord + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		Taikhoan other = (Taikhoan) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equalsIgnoreCase(other.userName))
			return false;
		return true;
	}
	

}
