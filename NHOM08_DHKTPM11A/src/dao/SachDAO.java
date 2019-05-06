package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import database.ConnectDB;
import entities.Sach;
import managedBean.KhachHangBean;
import managedBean.SachBean;
import managedBean.TaiKhoanBean;

public class SachDAO {
	public static ArrayList<Sach> getAllSach(){
		ArrayList<Sach> lst = new ArrayList<Sach>();
		try {
			Connection con = ConnectDB.getConnect();
			ResultSet rs = con.createStatement().executeQuery("select * from Sach");
			while(rs.next()) {
				Sach s =  new Sach(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getInt(9));
				lst.add(s);
			}
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return lst;
	}
	
	public static Sach xemCTSach(String ma) {
		try {
			Connection con = ConnectDB.getConnect();
			String sql="select * from Sach where maSach=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Sach cts = new Sach(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getInt(9));
				SachBean.sach = cts;
			}
			return SachBean.sach;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public static boolean xoaSach(ActionEvent a) {
		HtmlDataTable table = ConnectDB.getParenDatatable((UIComponent ) a.getSource());
		Object o = table.getRowData();
		Sach s = (Sach) o;
		String maS = s.getMaSach();
		try {
			Connection con = ConnectDB.getConnect();
			String sql="delete Sach where maSach=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, maS);
			int x = ps.executeUpdate();
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	public static ArrayList<Sach> getTimKiem(){
		ArrayList<Sach> ls = new ArrayList<Sach>();
		try {
			Connection con = ConnectDB.getConnect();
			String sql = "select * from Sach where tenSach like '%"+SachBean.timSach+"%' ";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Sach s = new Sach(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getInt(9));
				ls.add(s);
			}
			con.close();
			return ls;
		}catch(Exception ex)
		{
			
		}
		return ls;
	}
	public static boolean themSach() {
		try {
			Connection con = ConnectDB.getConnect();
			String sql = "insert into Sach values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, SachBean.sach.getMaSach());
			ps.setString(2, SachBean.sach.getTenSach());
			ps.setString(3, SachBean.sach.getnXB());
			ps.setInt(4, SachBean.sach.getNamPH());
			ps.setString(5, SachBean.sach.getTacGia());
			ps.setDouble(6, SachBean.sach.getGia());
			ps.setString(7, SachBean.sach.getTheLoai());
			ps.setString(8, SachBean.sach.getHinh());
			ps.setInt(9, 1);
			int x = ps.executeUpdate();
			return true;
		}catch(Exception ex){
			return false;
		}
	}
	public static boolean suaSach(String maSach) {
		try {
			Connection con = ConnectDB.getConnect();
			
			String sql1 = "update Sach set tenSach=?, nXB=?, namPH=?, tacGia=?, gia=?,theLoai=?,hinh=? where maSach=?";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setString(1, SachBean.sach.getTenSach());
			ps1.setString(2, SachBean.sach.getnXB());
			ps1.setInt(3, SachBean.sach.getNamPH());
			ps1.setString(4, SachBean.sach.getTacGia());
			ps1.setDouble(5,  SachBean.sach.getGia());
			ps1.setString(6,  SachBean.sach.getTheLoai());
			ps1.setString(7,  SachBean.sach.getHinh());
			ps1.setString(8, maSach);
			int x = ps1.executeUpdate();
			return true;
		}catch(Exception ex){
			return false;
		}
	}
}
