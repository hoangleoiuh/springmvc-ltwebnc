package managedBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UICommand;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import com.sun.org.apache.xerces.internal.parsers.XIncludeAwareParserConfiguration;

import dao.SachDAO;
import database.ConnectDB;
import entities.HoaDon;
import entities.Sach;


@ManagedBean
@SessionScoped
public class SachBean {
	ArrayList<Sach> lst = new ArrayList<Sach>();
	public static Sach sach = new Sach("", "", "", 0, "", 0, "", "", 1);
	public static String timSach;
	// kiểm tra có sửa không
	boolean suaS = false;
	// kiểm tra có thể xóa không
	boolean xoaS = false;
	
	public boolean isXoaS() {
		return xoaS;
	}


	public void setXoaS(boolean xoaS) {
		this.xoaS = xoaS;
	}


	public boolean isSuaS() {
		return suaS;
	}


	public void setSuaS(boolean suaS) {
		this.suaS = suaS;
	}


	public String getTimSach() {
		return timSach;
	}


	public void setTimSach(String timSach) {
		this.timSach = timSach;
	}


	public Sach getSach() {
		return sach;
	}


	public void setSach(Sach sach) {
		this.sach = sach;
	}


	public ArrayList<Sach> getLst() {
		return lst;
	}


	public void setLst(ArrayList<Sach> lst) {
		this.lst = lst;
	}



	public ArrayList<Sach> getAllSach(){
		lst = SachDAO.getAllSach();
		return lst;
	}
	public String xemCTSach(Sach s) {
		sach = SachDAO.xemCTSach(s.getMaSach());
		return "XemChiTietSach.xhtml";
	}
	public String btnTimKiem() {
		return "DanhSachTimKiem.xhtml";
	}
	public ArrayList<Sach> getTimKiem(){
		ArrayList<Sach> ls = new ArrayList<Sach>();
		ls = SachDAO.getTimKiem();
		return ls;		
	}
	public String themSachForm() {
		return "ThemSach.xhtml";
	}
	public String themSach() {
		if(SachDAO.themSach()==true)
			return "QuanLySach.xhtml";
		return "loiNguoiQuanLy.xhtml";
	}
	public void xoaSachA(ActionEvent a) {
		if(SachDAO.xoaSach(a)==true)
			xoaS = true;
		else
			xoaS = false;
	}
	public String xoaSach() {
		if(xoaS==true)
			return "QuanLySach.xhtml";
		else
			return "loiNguoiQuanLy.xhtml";
	}
	public void suaSachA(ActionEvent a) {
		HtmlDataTable table = ConnectDB.getParenDatatable((UIComponent ) a.getSource());
		Object o = table.getRowData();
		sach = (Sach) o;
		suaS=true;
	}
	public String suaSachForm() {
		if(suaS == true)
			return "SuaSach.xhtml";
		return "loiNguoiQuanLy.xhtml";
	}
	public String suaSach() {		
		if(SachDAO.suaSach(sach.getMaSach()) == true)
			return "QuanLySach.xhtml";
		else 
			return "loiNguoiQuanLy.xhtml";
	}
}
