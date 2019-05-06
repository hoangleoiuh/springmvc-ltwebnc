package managedBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import dao.KhachHangDAO;
import database.ConnectDB;
import entities.KhachHang;
import entities.Sach;

@ManagedBean
@SessionScoped
public class KhachHangBean {
	public static KhachHang kh = new KhachHang("", "", "", "", "", "", "");
	// kiem tra có giá trị để sửa hay không
	boolean bSua = false;
	


	public boolean isbSua() {
		return bSua;
	}

	public void setbSua(boolean bSua) {
		this.bSua = bSua;
	}

	public KhachHang getKh() {
		return kh;
	}

	public void setKh(KhachHang kh) {
		this.kh = kh;
	}

	public static void themKH(String maKH) {
		KhachHangDAO.themKH(maKH);
	}
	public ArrayList<KhachHang> getAllKH(){
		ArrayList<KhachHang> lkh = new ArrayList<KhachHang>();
		lkh = KhachHangDAO.getAllKH();
		return lkh;
	}

	public void suaKHForm(ActionEvent a) {
		HtmlDataTable table = ConnectDB.getParenDatatable((UIComponent ) a.getSource());
		Object o = table.getRowData();
		kh = (KhachHang) o;
		bSua = true;
	}
	public String sua() {
		if(bSua==true)
			return "SuaKhachHang.xhtml";
		return "loiNguoiQuanLy.xhtml";
	}

	public String suaKH() {
		if(KhachHangDAO.suaKH(kh.getMaKH())==true)
			return "DanhSachKhachHang.xhtml";
		return "loiNguoiQuanLy.xhtml";
	}
}
