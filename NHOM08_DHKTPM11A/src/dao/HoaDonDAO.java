package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import database.ConnectDB;
import entities.HoaDon;
import entities.TaiKhoan;
import entities.XemCTHD1;
import entities.XemCTHD2;
import managedBean.GioHangBean;
import managedBean.KhachHangBean;
import managedBean.TaiKhoanBean;

public class HoaDonDAO {
	public static String layMaHD() {
		String maHD="HD0";
		Date today = new Date(System.currentTimeMillis());
		SimpleDateFormat timeformat = new SimpleDateFormat("hhmmssddMMyyyy");
		String s = timeformat.format(today.getTime());
		return maHD+s;
	}
	public static String layngay() {
		String ngay;
		Date today = new Date(System.currentTimeMillis());
		SimpleDateFormat timeformat = new SimpleDateFormat("dd/MM/yyyy");
		return ngay=timeformat.format(today.getTime());
	}
	public static String layMaTK() {
		String ten = TaiKhoanBean.tk.getTenTK();
		String matk = "";
		TaiKhoan t = new TaiKhoan();
		try {
			Connection con = ConnectDB.getConnect();
			String sql="select * from dbo.TaiKhoan where tenTK=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ten);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				t = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				matk = t.getMaTK();
			}
			return matk;
		}catch(Exception ex) {
			return "loi.xhtml";
		}
	}
	public static boolean themHD() {		
		String maHD = layMaHD();
		String maTK = layMaTK();
		try {
			Connection con = ConnectDB.getConnect();
			String sql = "insert into HoaDon values(?,?,?,?,?,?,?)"; 
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, maHD);
			ps.setString(2, maTK);
			ps.setString(3, layngay());
			ps.setString(4, KhachHangBean.kh.getDiaChi());
			ps.setString(5, KhachHangBean.kh.getsDT());
			ps.setString(6, KhachHangBean.kh.getEmail());
			ps.setDouble(7, GioHangBean.getTotalDB());
			int x = ps.executeUpdate();
			if(x>0) {
				for (int i = 0; i < GioHangBean.spGH.size(); i++) {
					try {
						String sql1 = "insert into ChiTietHD values(?,?,?)";
						PreparedStatement ps1 = con.prepareStatement(sql1);
						ps1.setString(1, maHD);
						ps1.setString(2, GioHangBean.spGH.get(i).getMaSach());
						ps1.setInt(3, GioHangBean.spGH.get(i).getSoLuong());
						int x1 = ps1.executeUpdate();
					}catch(Exception ex) {
						return false;
					}
				}
			}
			return true;
		}catch(Exception ex){
			return false;
		}
	}

	public static ArrayList<HoaDon> getAllHD(){
		ArrayList<HoaDon> lhd = new ArrayList<HoaDon>();
		try {
			Connection con = ConnectDB.getConnect();
			String sql = "select * from HoaDon";
			ResultSet rs = con.createStatement().executeQuery(sql);
			while(rs.next()) {
				HoaDon h = new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getDouble(7));
				lhd.add(h);
			}
			con.close();
			return lhd;
		}catch(Exception ex) {
			return null;
		}
	}
	public static ArrayList<HoaDon> getAllHDByMATK(){
		ArrayList<HoaDon> lhd = new ArrayList<HoaDon>();
		try {
			Connection con = ConnectDB.getConnect();
			String sql = "select * from HoaDon where maKH=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, layMaTK());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				HoaDon h = new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getDouble(7));
				lhd.add(h);
			}
			con.close();
			return lhd;
		}catch(Exception ex) {
			return null;
		}
	}
	public static XemCTHD1 getHD1(ActionEvent a){
		HtmlDataTable table = ConnectDB.getParenDatatable((UIComponent ) a.getSource());
		Object o = table.getRowData();
		HoaDon h = (HoaDon) o;
		String maHD = h.getMaHD();
		XemCTHD1 xcthd1 = null;
		try {
			Connection con = ConnectDB.getConnect();
			String sql = "SELECT h.maHD, h.ngayMua, h.diaChi, h.sDT, h.email, h.tongGia, k.tenKH FROM HoaDon AS h INNER JOIN KhachHang AS k ON h.maKH = k.maKH where h.maHD=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, maHD);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				xcthd1 = new XemCTHD1(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getString(7));
			}
			con.close();
			return xcthd1;
		}catch(Exception ex) {
			return null;
		}
	}
	public static ArrayList<XemCTHD2> getHD2(ActionEvent a){
		HtmlDataTable table = ConnectDB.getParenDatatable((UIComponent ) a.getSource());
		Object o = table.getRowData();
		HoaDon h = (HoaDon) o;
		String maHD = h.getMaHD();
		ArrayList<XemCTHD2> lsthd2 = new ArrayList<XemCTHD2>();
		try {
			Connection con = ConnectDB.getConnect();
			String sql = "SELECT     s.maSach, s.tenSach, s.gia, c.soLuong FROM         ChiTietHD AS c INNER JOIN Sach AS s ON c.maSach = s.maSach where c.maHD=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, maHD);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				XemCTHD2 xcthd2 = new XemCTHD2(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
				lsthd2.add(xcthd2);
			}
			con.close();
			return lsthd2;
		}catch(Exception ex) {
			return null;
		}
	}
	public static boolean xoaHD(ActionEvent a) {
		HtmlDataTable table = ConnectDB.getParenDatatable((UIComponent ) a.getSource());
		Object o = table.getRowData();
		HoaDon h = (HoaDon) o;
		String maHD = h.getMaHD();
		try {
			Connection con = ConnectDB.getConnect();
			String sql="delete HoaDon where maHD=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, maHD);
			int x = ps.executeUpdate();
			return true; 
		}catch(Exception ex) {
			return false;
		}
	}
}
