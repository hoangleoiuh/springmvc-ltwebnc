package entities;


public class TaiKhoan {
	private String maTK, tenTK, matKhau;
	private int quyen;
	public String getMaTK() {
		return maTK;
	}
	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}
	public String getTenTK() {
		return tenTK;
	}
	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public int getQuyen() {
		return quyen;
	}
	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}
	public TaiKhoan(String maTK, String tenTK, String matKhau, int quyen) {
		super();
		this.maTK = maTK;
		this.tenTK = tenTK;
		this.matKhau = matKhau;
		this.quyen = quyen;
	}
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
