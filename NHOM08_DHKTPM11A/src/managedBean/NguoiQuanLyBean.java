package managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NguoiQuanLyBean {
	
	
	public String quanlyKH() {
		return "DanhSachKhachHang.xhtml";
	}
	public String quanlyHD() {
		return "DanhSachHoaDon.xhtml";
	}
	public String quanlySach() {
		return "QuanLySach.xhtml";
	}
	public String xemHDKH() {
		return "DanhSachHDCT.xhtml";
	}
	
}
