package entities;

public class Sach {
	private String maSach, tenSach, nXB;
	private int namPH;
	private String tacGia;
	private double gia;
	private String theLoai, hinh;
	private int soLuong;
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
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
	public String getnXB() {
		return nXB;
	}
	public void setnXB(String nXB) {
		this.nXB = nXB;
	}
	public int getNamPH() {
		return namPH;
	}
	public void setNamPH(int namPH) {
		this.namPH = namPH;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public double getGia() {
		return gia*soLuong;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	public String getHinh() {
		return hinh;
	}
	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
	public Sach(String maSach, String tenSach, String nXB, int namPH, String tacGia, double gia, String theLoai,
			String hinh, int soLuong) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.nXB = nXB;
		this.namPH = namPH;
		this.tacGia = tacGia;
		this.gia = gia;
		this.theLoai = theLoai;
		this.hinh = hinh;
		this.soLuong = soLuong;
	}
	public Sach() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}	
