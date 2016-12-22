package com.lining;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Gui {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table;
	private JTable table_2;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�رմ���ʱ�˳�����
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame jFrame = new JFrame("�Һ��շ�");
		jFrame.setBounds(550, 350, 800, 500);
		jFrame.setResizable(false);
		jFrame.setVisible(true);
		JPanel jPanelReg = new JPanel();
		JPanel jPanelCharge = new JPanel();
		JPanel jPanelExit = new JPanel();

		JTabbedPane jTabbedPane = new JTabbedPane(SwingConstants.TOP);// ѡ���������

		JPanel jPanelLogin = new JPanel();
		jTabbedPane.add("��¼", jPanelLogin);
		jTabbedPane.setEnabledAt(0, true);
		jPanelLogin.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u7528\u6237ID\uFF1A");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel.setBounds(234, 164, 97, 31);
		jPanelLogin.add(lblNewLabel);

		JLabel label = new JLabel("\u5BC6\u3000\u7801\uFF1A");
		label.setFont(new Font("����", Font.PLAIN, 20));
		label.setBounds(234, 210, 97, 31);
		jPanelLogin.add(label);

		textField = new JTextField();
		textField.setBounds(357, 164, 233, 31);
		jPanelLogin.add(textField);
		textField.setColumns(1);

		passwordField = new JPasswordField();
		passwordField.setBounds(357, 212, 233, 31);
		jPanelLogin.add(passwordField);

		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userid = textField.getText();
				int UserID = Integer.parseInt(userid);
				String pwd = passwordField.getText();
				String sql = "select * from Users where userID=? and roleID=2";
				try {
					Connection con = SQLOperate.Connection();
					PreparedStatement state = con.prepareStatement(sql);
					state.setInt(1, UserID);
					ResultSet rs = state.executeQuery();
					if (rs.next()) {
						if (pwd.equals(rs.getString("pwd"))) {
							jTabbedPane.setEnabledAt(1, true);
							jTabbedPane.setEnabledAt(2, true);
							jTabbedPane.setEnabledAt(3, true);
							jTabbedPane.setEnabledAt(4, true);
							JOptionPane.showMessageDialog(null, "��¼�ɹ�");
						} else {
							JOptionPane.showMessageDialog(null, "�����������!");
						}
					} else {
						JOptionPane.showMessageDialog(null, "�û���������");
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				textField.setText(null);
				passwordField.setText(null);

				// ResultSet rs = SQLOperate.SqlSel(sql);
				/*
				 * try { JOptionPane.showMessageDialog(null,
				 * rs.getString("pwd")); } catch (HeadlessException e1) { //
				 * TODO Auto-generated catch block e1.printStackTrace(); } catch
				 * (SQLException e1) { // TODO Auto-generated catch block
				 * e1.printStackTrace(); }
				 */
				/*
				 * try { if (!rs.next()) { if (pwd.equals(rs.getString("pwd")))
				 * { JOptionPane.showMessageDialog(null, "��¼�ɹ�");
				 * System.exit(0); } else { JOptionPane.showMessageDialog(null,
				 * "�����������!"); } } else { JOptionPane.showMessageDialog(null,
				 * "�û���������"); } } catch (HeadlessException e1) { // TODO
				 * Auto-generated catch block e1.printStackTrace(); } catch
				 * (SQLException e1) { // TODO Auto-generated catch block
				 * e1.printStackTrace(); }
				 */
				/*
				 * if (!rs.next()) { JOptionPane.showMessageDialog(null,
				 * "�����������������룡"); } else { jTabbedPane.setEnabledAt(1, true);
				 * jTabbedPane.setEnabledAt(2, true);
				 * jTabbedPane.setEnabledAt(3, true);
				 * JOptionPane.showMessageDialog(null, "��¼�ɹ���"); }
				 */
			}
		});
		btnNewButton.setBounds(255, 272, 97, 31);
		jPanelLogin.add(btnNewButton);

		JButton button = new JButton("\u53D6\u6D88");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		button.setBounds(398, 272, 97, 31);
		jPanelLogin.add(button);

		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("F:\\JAVA\u533B\u9662\\\u6302\u53F7\u6536\u8D39\u56FE\u6807.jpg"));
		lblNewLabel_7.setBounds(73, 10, 672, 132);
		jPanelLogin.add(lblNewLabel_7);
		JPanel jPanelApt = new JPanel();
		jTabbedPane.add("�鿴ԤԼ��Ϣ", jPanelApt);
		jPanelApt.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\u9884\u7EA6\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(52, 31, 86, 33);
		jPanelApt.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(148, 27, 200, 33);
		jPanelApt.add(textField_1);
		textField_1.setColumns(10);
		
		String[] columnNames={"ԤԼID","��������","����","ԤԼʱ��"}; //���� 
		Object[][] rowData=new Object[5][4]; //�������
		table_2 = new JTable(rowData,columnNames);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u770B");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Reg=textField_1.getText();
				int RegID = Integer.parseInt(Reg);
				String sql="select Registration.RegID,Patient.PatName,Department.DeptName,Registration.RegTime from Registration,Patient,Department ,Doctor where  Registration.PatientID=Patient.PatID and Department.DeptID=Doctor.DoctorDeptID and Registration.DoctorID=Doctor.DoctorID and RegID=?";
				try {
					Connection con = SQLOperate.Connection();
					PreparedStatement state = con.prepareStatement(sql);
					state.setInt(1, RegID);
					ResultSet rs = state.executeQuery();
					int count=0;

					while (rs.next()){ //������ѯ���
							rowData[count][0]=rs.getString("RegID"); //��ʼ���������� 
							rowData[count][1]=Integer.toString(rs.getInt("PatName"));
							rowData[count][2]=rs.getString("DeptName");
							rowData[count][3]=rs.getString("RegTime");
						count++;
						}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(386, 32, 74, 23);
		jPanelApt.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u67E5\u770B\u5168\u90E8");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="select Registration.RegID,Patient.PatName,Department.DeptName,Registration.RegTime from Registration,Patient,Department ,Doctor where  Registration.PatientID=Patient.PatID and Department.DeptID=Doctor.DoctorDeptID and Registration.DoctorID=Doctor.DoctorID ";
				try {
					
					ResultSet rs = SQLOperate.SqlSel(sql);
					int count=0;

					while (rs.next()){ //������ѯ���
							rowData[count][0]=rs.getString("RegID"); //��ʼ���������� 
							rowData[count][1]=Integer.toString(rs.getInt("PatName"));
							rowData[count][2]=rs.getString("DeptName");
							rowData[count][3]=rs.getString("RegTime");
						count++;
						}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(492, 31, 93, 25);
		jPanelApt.add(btnNewButton_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 77, 769, 356);
		jPanelApt.add(scrollPane);
		
		
		table_2.setShowVerticalLines(false);
		/*table_2.setModel(new DefaultTableModel(new Object[15][4] , new String[] { "\u9884\u7EA6ID",
				"\u60A3\u8005\u59D3\u540D", "\u9884\u7EA6\u79D1\u5BA4", "\u9884\u7EA6\u65F6\u95F4" }));
		table_2.setRowHeight(22);*/
		scrollPane.setViewportView(table_2);

		jTabbedPane.setEnabledAt(1, false);
		jTabbedPane.add("�Һ�", jPanelReg);
		jPanelReg.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("\u59D3\u3000\u3000\u540D\uFF1A");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(198, 36, 110, 30);
		jPanelReg.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u6027\u3000\u3000\u522B\uFF1A");
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(198, 76, 110, 30);
		jPanelReg.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u5E74\u3000\u3000\u9F84\uFF1A");
		lblNewLabel_4.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(198, 116, 110, 30);
		jPanelReg.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		lblNewLabel_5.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(198, 156, 110, 30);
		jPanelReg.add(lblNewLabel_5);

		JLabel label_1 = new JLabel("\u79D1\u3000\u3000\u5BA4\uFF1A");
		label_1.setFont(new Font("����", Font.PLAIN, 20));
		label_1.setBounds(198, 196, 110, 30);
		jPanelReg.add(label_1);

		textField_2 = new JTextField();
		textField_2.setBounds(308, 36, 215, 30);
		jPanelReg.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(308, 76, 215, 30);
		jPanelReg.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(308, 116, 215, 30);
		jPanelReg.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(308, 156, 215, 30);
		jPanelReg.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(308, 196, 215, 30);
		jPanelReg.add(textField_6);

		JButton btnNewButton_3 = new JButton("\u6302\u53F7");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patName = textField_2.getText();
				String patgender = textField_3.getText();
				String patAge = textField_4.getText();
				String patTel = textField_5.getText();
				String patDept = textField_6.getText();
				//String username=patName+new SimpleDateFormat("HH:mm:ss").format(new Date())	;			
				String sql1="insert into Users values(6,'','"+patName+"')";
				SQLOperate.SqlUpdata(sql1);
				String sql2="select * from Users where userName='"+patName+"'";
				ResultSet rs1 =SQLOperate.SqlSel(sql2);
				int userID=-1;
				try {
					while(rs1.next()){
						userID=rs1.getInt(0);
						}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						rs1.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				int doctID;
				String sql3="select * from Doctor where DoctorDeptID=";
				ResultSet rs2 =SQLOperate.SqlSel(sql3);
				try {
					while(rs2.next()){
						doctID=rs2.getInt(0);
						}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						rs2.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				String regtime=new SimpleDateFormat("HH:mm:ss").format(new Date());
				String sql4="insert into Registration(PatientID,DoctorID,RegTime,RegState) values('"
						+ "+userID+','+doctID+','+regtime+','�Һ�')";
				int i=SQLOperate.SqlUpdata(sql4);
				if(i>0){
					JOptionPane.showMessageDialog(null, "�Һųɹ�!");
				}else{JOptionPane.showMessageDialog(null, "�Һ�ʧ��!");}
				
			}
		});
		btnNewButton_3.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton_3.setBounds(226, 264, 93, 30);
		jPanelReg.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("\u53D6\u6D88");
		btnNewButton_4.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton_4.setBounds(376, 264, 93, 30);
		jPanelReg.add(btnNewButton_4);
		jTabbedPane.add("�շ�", jPanelCharge);
		jPanelCharge.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("\u8BF7\u8F93\u5165\u6536\u8D39\u5355\u53F7\uFF1A");
		lblNewLabel_6.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(73, 34, 160, 30);
		jPanelCharge.add(lblNewLabel_6);

		textField_7 = new JTextField();
		textField_7.setBounds(229, 34, 191, 28);
		jPanelCharge.add(textField_7);
		textField_7.setColumns(10);

		JButton btnNewButton_5 = new JButton("\u67E5\u770B");
		btnNewButton_5.setBounds(450, 40, 76, 23);
		jPanelCharge.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("\u67E5\u770B\u5168\u90E8");
		btnNewButton_6.setBounds(565, 34, 93, 29);
		jPanelCharge.add(btnNewButton_6);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 90, 727, 316);
		jPanelCharge.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		jTabbedPane.add("�˳�", jPanelExit);	
		jPanelExit.setLayout(null);
		
		JButton btnNewButton_7 = new JButton("\u9000\u51FA\u767B\u5F55");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTabbedPane.setEnabledAt(1, false);
				jTabbedPane.setEnabledAt(2, false);
				jTabbedPane.setEnabledAt(3, false);
				jTabbedPane.setEnabledAt(4, false);
				JOptionPane.showMessageDialog(null, "���˳�!");
				jTabbedPane.setSelectedIndex(0);
			}
		});
		btnNewButton_7.setBounds(343, 39, 93, 23);
		jPanelExit.add(btnNewButton_7);
		jTabbedPane.setEnabledAt(2, false);
		jTabbedPane.setEnabledAt(3, false);
		jTabbedPane.setEnabledAt(4, false);
		jFrame.getContentPane().add(jTabbedPane);
		JOptionPane.showMessageDialog(null, "��ӭʹ�ã����¼");
		jTabbedPane.setSelectedIndex(0);// ��ʾ��һ��
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�رմ���ʱ�˳�����
		
	}
}
