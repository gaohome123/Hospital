package ����Һ��շ�;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLOperate {

	// �������ݿ�
	public static Connection Connection() {
		Connection con = null;
		try {
			// �������ݿ�����
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// �������ݿ�����
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital", "sa", "sa");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//����
	public static int SqlUpdata(String sql) {
		Connection con = Connection();
		// ����������
		Statement st = null;
		int yt = 0;
		try {
			st = con.createStatement();
			yt = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return yt;
		// insert,update,delete,ͨ����executeUpdate
	}
	
	//��ѯ
	public static ResultSet SqlSel(String sql) {
		Connection con = Connection();
		// ����������
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		// select�����executeQuery������һ��ResultSet���������ά��
	}
	
}