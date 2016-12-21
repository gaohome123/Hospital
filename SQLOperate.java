package com.lining;

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
			// con=(Connection)DriverManager.getConnection("jdbc:sqlserver://localhost:1433;integratedSecurity=true;DatabaseName=Hospital");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital", "sa", "sa");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static int SqlUpdata(String sql) {
		Connection con = Connection();
		// ����������
		Statement st = null;
		int yt = 0;
		try {
			st = con.createStatement();
			yt = st.executeUpdate(sql);
			closeCon(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return yt;
		// insert,update,delete,ͨ����executeUpdate
	}

	public static ResultSet SqlSel(String sql) {
		Connection con = Connection();
		// ����������
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			closeCon(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		// select�����executeQuery������һ��ResultSet���������ά��
	}
	
	public static void closeCon(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * //�����Ƿ����ӳɹ� public static void main(String[] args) { Connection
	 * con=Connection(); if(con!=null){ System.out.println("���ӳɹ���"); } }
	 */

}