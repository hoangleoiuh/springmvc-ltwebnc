package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import database.ConnectDB;
import entities.KhachHang;
import entities.TaiKhoan;
import managedBean.KhachHangBean;
import managedBean.TaiKhoanBean;

public class KhachHangDAO {
	public static void themKH(String maKH) {
		try {
			Connection con = ConnectDB.getConnect();
			
			String sql1 = "insert into KhachHang values(?,?,?,?,?,?,?)";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setString(1, maKH);
			ps1.setString(2, KhachHangBean.kh.getTenKH());
			ps1.setString(3, KhachHangBean.kh.getcMND());
			ps1.setString(4, KhachHangBean.kh.getGioiTinh());
			ps1.setString(5, KhachHangBean.kh.getsDT());
			ps1.setString(6, KhachHangBean.kh.getDiaChi());
			ps1.setString(7, KhachHangBean.kh.getEmail());
			
			int x = ps1.executeUpdate();
		}catch(Exception ex){
			
		}
	}
	public static ArrayList<KhachHang> getAllKH(){
		ArrayList<KhachHang> lkh = new ArrayList<KhachHang>();
		try {
			Connection con = ConnectDB.getConnect();
			String sql = "select * from KhachHang";
			ResultSet rs = con.createStatement().executeQuery(sql);
			while (rs.next()){
				KhachHang k = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				lkh.add(k);
			}
			con.close();
			return lkh;
		}catch(Exception ex) {
			
		}
		return null;
	}

	public static boolean xoa(ActionEvent a) {
		HtmlDataTable table = ConnectDB.getParenDatatable((UIComponent ) a.getSource());
		Object o = table.getRowData();
		KhachHang k = (KhachHang) o;
		String makh = k.getMaKH();
		try {
			Connection con = ConnectDB.getConnect();
			String sql = "delete KhachHang where maKH=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, makh);
			int x= ps.executeUpdate();
			if(x>0)
				return true;
		}catch(Exception ex) {
			return false; 
		}
		return false;
	}
	
	public static boolean suaKH(String maKH) {
		try {
			Connection con = ConnectDB.getConnect();
			
			String sql1 = "update KhachHang set tenKH=?, gioiTinh=?, sDT=?, diaChi=?, email=? where maKH=?";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setString(1, KhachHangBean.kh.getTenKH());
			ps1.setString(2, KhachHangBean.kh.getGioiTinh());
			ps1.setString(3, KhachHangBean.kh.getsDT());
			ps1.setString(4, KhachHangBean.kh.getDiaChi());
			ps1.setString(5,  KhachHangBean.kh.getEmail());
			ps1.setString(6, maKH);
			int x = ps1.executeUpdate();
			return true;
		}catch(Exception ex){
			return false;
		}
	}
	public static KhachHang layKH() {
		String id = TaiKhoanBean.tk.getTenTK();
		
		KhachHang k = new KhachHang();
		try {
			Connection con = ConnectDB.getConnect();
			String sql="SELECT k.* FROM KhachHang AS k INNER JOIN TaiKhoan AS t ON k.maKH = t.maTK where t.tenTK=? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				k = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
			return k;
		}catch(Exception ex) {
			
		}
		return null;
	}
}
