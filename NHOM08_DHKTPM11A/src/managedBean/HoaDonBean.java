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

import dao.HoaDonDAO;
import database.ConnectDB;
import entities.HoaDon;
import entities.KhachHang;
import entities.XemCTHD1;
import entities.XemCTHD2;

@ManagedBean
@SessionScoped
public class HoaDonBean {
	
	XemCTHD1 xemCTHD1 = new XemCTHD1("", "", "", "", "", 0.0, "");
	ArrayList<XemCTHD2> listxemcthd2 = new ArrayList<XemCTHD2>();
	
	
	
	public XemCTHD1 getXemCTHD1() {
		return xemCTHD1;
	}

	public void setXemCTHD1(XemCTHD1 xemCTHD1) {
		this.xemCTHD1 = xemCTHD1;
	}

	public ArrayList<XemCTHD2> getListxemcthd2() {
		return listxemcthd2;
	}

	public void setListxemcthd2(ArrayList<XemCTHD2> listxemcthd2) {
		this.listxemcthd2 = listxemcthd2;
	}

	public String themHD() {		
		if(HoaDonDAO.themHD()==true)
			return "ThongBaoDonHang.xhtml";
		return "loi.xhtml";
	}
	
	public ArrayList<HoaDon> getAllHD(){
		ArrayList<HoaDon> lhd = new ArrayList<HoaDon>();
		lhd = HoaDonDAO.getAllHD();
		return lhd;
	}
	public ArrayList<HoaDon> getAllHDByMaTK(){
		ArrayList<HoaDon> lhd = new ArrayList<HoaDon>();
		lhd = HoaDonDAO.getAllHDByMATK();
		return lhd;
	}
	public String xoaHD(ActionEvent a) {
		if(HoaDonDAO.xoaHD(a)==true)
			return "DanhSachHoaDon.xhtml";
		return "loiNguoiQuanLy.xhtml";
	}
	public void xemCTHD(ActionEvent a) {
		xemCTHD1 = HoaDonDAO.getHD1(a);
		listxemcthd2 = HoaDonDAO.getHD2(a);
	}
	public String xemCTHDF() {
		return "XemCTHD.xhtml";
	}
	
	//tu kh xem cthd cua minh
	public void xemCTHDCT(ActionEvent a) {
		xemCTHD1 = HoaDonDAO.getHD1(a);
		listxemcthd2 = HoaDonDAO.getHD2(a);
	}
	public String xemCTHDFCT() {
		return "XemCTHDCT.xhtml";
	}
}
