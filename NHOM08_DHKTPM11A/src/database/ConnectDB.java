package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlDataTable;

import entities.Sach;

public class ConnectDB {
	public static Connection getConnect() {
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=NHOM08_DHKTPM11A", "sa", "sapassword");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return con;
	}
	public static HtmlDataTable getParenDatatable(UIComponent source) {
		if(source == null) {
			return null;
		}
		if(source instanceof HtmlDataTable) {
			return (HtmlDataTable) source;
		}
		return getParenDatatable(source.getParent());
	}

}
