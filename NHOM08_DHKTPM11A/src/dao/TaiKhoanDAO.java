package dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import database.ConnectDB;
import entities.TaiKhoan;
import managedBean.KhachHangBean;
import managedBean.TaiKhoanBean;

public class TaiKhoanDAO {
	public static String layMaTK() {
		String maTK="tk";
		Date today = new Date(System.currentTimeMillis());
		SimpleDateFormat timeformat = new SimpleDateFormat("hhmmssddMMyyyy");
		String s = timeformat.format(today.getTime());
		return maTK+s;
	}
	public static String setMatKhau(String mk) 	{
		String passmd5="";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(mk.getBytes());
			BigInteger bigint = new BigInteger(1,md.digest());
			passmd5= bigint.toString(16);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return passmd5;
	}
	public static boolean themTK() {
		String maTK = layMaTK();
		try {
			Connection con = ConnectDB.getConnect();
			String sql = "insert into TaiKhoan values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, maTK);
			ps.setString(2, TaiKhoanBean.tk.getTenTK());
			ps.setString(3, setMatKhau(TaiKhoanBean.tk.getMatKhau()));
			ps.setInt(4, 1);
			int x = ps.executeUpdate();
			if(x>0) {
				try {
					KhachHangBean.themKH(maTK);
					return true;
				}catch(Exception ex) {
					ex.printStackTrace();
					return false;	
				}
			}
		}catch(Exception ex){
			return false;
		}
		return false;
	}
	public static TaiKhoan layTK() {
		String id = TaiKhoanBean.tk.getTenTK();
		String pass = TaiKhoanBean.tk.getMatKhau();
		String mk = setMatKhau(pass);
		TaiKhoan t = new TaiKhoan();
		try {
			Connection con = ConnectDB.getConnect();
			String sql="select * from dbo.TaiKhoan where tenTK=? and matKhau=? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, mk);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				t = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
			return t;
		}catch(Exception ex) {
			
		}
		return null;
	}
}
