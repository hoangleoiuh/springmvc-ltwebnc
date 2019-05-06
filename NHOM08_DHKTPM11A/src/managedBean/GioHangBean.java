package managedBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import com.sun.org.apache.regexp.internal.recompile;

import dao.HoaDonDAO;
import dao.KhachHangDAO;
import database.ConnectDB;
import entities.HoaDon;
import entities.Sach;
import entities.TaiKhoan;

@ManagedBean
@SessionScoped
public class GioHangBean {

	public static String diaChiNhanHang;
	public static String sDT;
	public static String email;
	// kiem tra da DN chua
	static boolean chuaDN = false;
	//kiem tra them GH dc không
	boolean tbthem = false;
	// ds sp trong gio hang
	public static ArrayList<Sach> spGH = new ArrayList<Sach>();
	Sach sach;
	
	// set-get
	
	
	public boolean isChuaDN() {
		return chuaDN;
	}

	public boolean isTbthem() {
		return tbthem;
	}

	public void setTbthem(boolean tbthem) {
		this.tbthem = tbthem;
	}

	public void setChuaDN(boolean chuaDN) {
		this.chuaDN = chuaDN;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getsDT() {
		return sDT;
	}


	public void setsDT(String sDT) {
		this.sDT = sDT;
	}


	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}


	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}

	public ArrayList<Sach> getSpGH() {
		return spGH;
	}


	public void setSpGH(ArrayList<Sach> spGH) {
		this.spGH = spGH;
	}


	public Sach getSach() {
		return sach;
	}


	public void setSach(Sach sach) {
		this.sach = sach;
	}

	// hàm
	
	//số lượng sách trong giỏ hàng:
	public int getSoluong() {
		return spGH.size();
	}
	
	public ArrayList<Sach> getAllSachGH(){
		return spGH;
	}
	public void addSPGH(Sach s) {
		// kiem tra sach da co trong gio hang chua
		//neu co cap nhat lai so luong
		for (int i = 0; i < spGH.size(); i++) {
			if(s.getMaSach().equals(spGH.get(i).getMaSach())) {
				int slOld = spGH.get(i).getSoLuong();
				int slNew = slOld+s.getSoLuong();
				
				if(slNew>10)
				{
					return;
				}
				else
				{	
					spGH.get(i).setSoLuong(slNew);
					return;
				}
			}	
		}
		spGH.add(s);
	}
	// lay tong gia hiện lên giỏ hàng
	public double getTotal() {
		double tt= 0.0;

		for (Sach sach : spGH) {
			tt += sach.getGia();
		}

		return tt;
	}
	// lấy tổng giá cho csdl
	public static double getTotalDB() {
		double tt= 0.0;

		for (Sach sach : spGH) {
			tt += sach.getGia();
		}

		return tt;
	}
	
	// cập nhật số lượng trong giỏ hàng
	public String capnhat(ActionEvent a) {
		HtmlDataTable table = ConnectDB.getParenDatatable((UIComponent ) a.getSource());
		Object o = table.getRowData();
		Sach s = (Sach) o;
		if(s.getSoLuong()<=0)
			spGH.remove(s);
		return "GioHang.xhtml";
	}
	
	public String formThanhToan() {
		if(TaiKhoanBean.tk.getTenTK()== "" || spGH.size()==0) {
			chuaDN = true;
			return "GioHang.xhtml";
		}
		else {
			chuaDN = false;
			KhachHangBean.kh = KhachHangDAO.layKH();
			return "ThanhToan.xhtml";
		}
	}
	
}
