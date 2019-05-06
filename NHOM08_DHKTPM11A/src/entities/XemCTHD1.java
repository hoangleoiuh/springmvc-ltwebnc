package entities;

public class XemCTHD1 {
	private String maHD, ngayMua, diaChi, sDT, email;
	private double tongGia;
	private String tenKH;

	public XemCTHD1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public XemCTHD1(String maHD, String ngayMua, String diaChi, String sDT, String email, double tongGia,
			String tenKH) {
		super();
		this.maHD = maHD;
		this.ngayMua = ngayMua;
		this.diaChi = diaChi;
		this.sDT = sDT;
		this.email = email;
		this.tongGia = tongGia;
		this.tenKH = tenKH;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
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

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	
}
