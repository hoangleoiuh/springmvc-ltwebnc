package managedBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UICommand;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;


import dao.TaiKhoanDAO;
import database.ConnectDB;
import entities.KhachHang;
import entities.Sach;
import entities.TaiKhoan;

@ManagedBean
@SessionScoped
public class TaiKhoanBean {
	public static TaiKhoan tk = new TaiKhoan("", "", "", 1);
	// hiện xin chào
	boolean hien = false;
	// hiện nút DN -DX
	boolean fDN = true;
	// hiện lỗi khi DN
	boolean hienloiDN = false;
	
	// set-get
	public boolean isfDN() {
		return fDN;
	}

	public void setfDN(boolean fDN) {
		this.fDN = fDN;
	}

	public boolean isHienloiDN() {
		return hienloiDN;
	}

	public void setHienloiDN(boolean hienloiDN) {
		this.hienloiDN = hienloiDN;
	}

	public boolean isHien() {
		return hien;
	}

	public void setHien(boolean hien) {
		this.hien = hien;
	}



	public TaiKhoan getTk() {
		return tk;
	}

	public void setTk(TaiKhoan tk) {
		this.tk = tk;
	}
	

	public String themTK() {
		if(TaiKhoanDAO.themTK()==true)
			return "thongbao.xhtml";
		return "loi.xhtml";
	}
	

	public String kiemTraTK() {
		TaiKhoan t1 = TaiKhoanDAO.layTK();
		if(t1.getTenTK()!= null ) {
			if(t1.getQuyen() == 1) {
				hien = true;
				fDN = false;
				GioHangBean.chuaDN = false;
				return "DanhSachSach.xhtml";
			}
			else {
				hien = true;
				fDN = false;
				GioHangBean.chuaDN = false;
				return "NguoiQuanLy.xhtml";
			}
		}
		else {
			fDN = true;
			hien = false;
			hienloiDN = true;
			return null;
		}
	}
	public String dangky() {
		fDN = true ;
		hien = false;
		hienloiDN = false;
		return "DangKy.xhtml";
	}
	public String dangxuat() {
		// hủy session
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		GioHangBean.spGH.clear();
		TaiKhoanBean.tk = new TaiKhoan("", "", "", 1);
		fDN = true;
		hien = false;
		hienloiDN = false;
		return "DanhSachSach.xhtml";
		
	}
	public String dangnhap() {
		return "DangNhap.xhtml";
	}
}
