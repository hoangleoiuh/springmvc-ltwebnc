package entities;

public class XemCTHD2 {
	private String maSach, tenSach;
	private double gia;
	private int soLuong;
	public XemCTHD2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public XemCTHD2(String maSach, String tenSach, double gia, int soLuong) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.gia = gia;
		this.soLuong = soLuong;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	
}
