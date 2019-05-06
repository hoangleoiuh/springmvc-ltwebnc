package entities;

public class ChiTietHD {
	private String maHD, maSach;
	private int soLuong;
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public ChiTietHD(String maHD, String maSach, int soLuong) {
		super();
		this.maHD = maHD;
		this.maSach = maSach;
		this.soLuong = soLuong;
	}
	public ChiTietHD() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
