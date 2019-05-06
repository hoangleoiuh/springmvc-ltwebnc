package entities;

public class HoaDon {
	private String maHD, maKH , ngayMua, diaChi, sDT, email;
	private double tongGia;
	public HoaDon(String maHD, String maKH, String ngayMua, String diaChi, String sDT, String email, double tongGia) {
		super();
		this.maHD = maHD;
		this.maKH = maKH;
		this.ngayMua = ngayMua;
		this.diaChi = diaChi;
		this.sDT = sDT;
		this.email = email;
		this.tongGia = tongGia;
	}
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getNgayMua() {
		return ngayMua;
	}
	public void setNgayMua(String ngayMua) {
		this.ngayMua = ngayMua;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getTongGia() {
		return tongGia;
	}
	public void setTongGia(double tongGia) {
		this.tongGia = tongGia;
	}
	
	
	
	
}
