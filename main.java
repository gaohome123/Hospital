package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

public class main{

	public static void main(String[] args){
		admin();
		
	}
	
	
    public static void admin() {
	//�����µĴ���
	final JFrame frame1 = new JFrame("����Ա��¼");
	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame1.setLayout(null);
	//��������Ļ��λ��
	// �����С
	frame1.setSize(500,300);
	frame1.setLocation(500, 100);
	// ��ʾ����
	frame1.setVisible(true);	
	
	final JTextField  text1=new JTextField(10);
	final JTextField  text2=new JTextField(10);
	JLabel la=new JLabel("ID:");
	JLabel la2=new JLabel("����:");
	JButton jbn=new JButton("��¼");
    frame1.add(la);
    la.setBounds(170,50,50,20);
    frame1.add(text1);
    text1.setBounds(200,50,100,20);
    frame1.add(la2);
    la2.setBounds(170,90,50,20);
    frame1.add(text2);
    text2.setBounds(200,90,100,20);
    frame1.add(jbn);
    jbn.setBounds(200,140,100,30);
    

        

    
	
  //��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
    jbn.addActionListener(new ActionListener(){
    //������ťִ�еķ���
    public void actionPerformed(ActionEvent e) {
		Statement st=null;
		Connection con=null;
    	
		con=DB(con);
    	
    	try {
			st=con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
   	
	       String  m1=null;
	       m1=text1.getText(); 
	       int i1 =0;
	       i1 = Integer.parseInt(m1);
	       String s= null;   
	       s= text2.getText();  
   
		     String sql="select * from Users where userID="+i1+"";
			ResultSet rs=null;	
			try {
				rs=st.executeQuery(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			   
			int i=0;
			String password=null;
			
			try {
				while(rs.next())
				{i=rs.getInt("roleID");
				password=rs.getString("pwd");}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}				
				
			if(i==1)
			{if(s.equals(password))				
	          {	frame1.dispose();
	          adminmenu66();
	         	}		
		    else 
		    	{	frame1.dispose();main(null);adminmenu0();}
			}
		    else 
		    	{  frame1.dispose(); main(null);adminmenu0();}
			
			
    } 
    });
	

}
    
    public static void adminmenu0(){
		//�����µĴ���
		JFrame frame= new JFrame("������ʾ");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(null);
		//��������Ļ��λ��
		// �����С
		frame.setSize(300,100);
		frame.setLocation(600, 200);
		// ��ʾ����
		frame.setVisible(true);	
		
		
		JLabel la2=new JLabel("ID���������");	
        frame.add(la2);
        la2.setBounds(100,20,200,20);	
    	
    }

	public static void adminmenu1(){
	//�����µĴ���
	final JFrame frame = adminframe("����ҽԺ������Ϣ");	

	//��ť1
	JButton button1 =new JButton("1.����ҽԺ������Ϣ");
	//�ڴ�������Ӱ�ť
	frame.add(button1);
	button1.setBounds(145,50,200,30);
	//��ʾ����
	frame.setVisible(true);
	//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
	button1.addActionListener(new  ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
	adminmenu11();
	}


	});
	
	//��ť2
	JButton button2 =new JButton("2.ɾ��ҽԺ������Ϣ");
	//�ڴ�������Ӱ�ť
	frame.add(button2);
	button2.setBounds(145,80,200,30);
	//��ʾ����
	frame.setVisible(true);
	//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
	button2.addActionListener(new ActionListener(){
	//������ťִ�еķ���
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	adminmenu12();
	}
	});
	
	
	
	//��ť3
	JButton button3 =new JButton("3.����ҽԺ������Ϣ");
	//�ڴ�������Ӱ�ť
	frame.add(button3);
	button3.setBounds(145,110,200,30);
	//��ʾ����
	frame.setVisible(true);
	//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
	button3.addActionListener(new ActionListener(){
	//������ťִ�еķ���
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	adminmenu13();
	}
	});

	
	
	//��ť5
	JButton button5 =new JButton("4.�鿴ҽԺ������Ϣ");
	//�ڴ�������Ӱ�ť
	frame.add(button5);
	button5.setBounds(145,140,200,30);
	//��ʾ����
	frame.setVisible(true);
	//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
	button5.addActionListener(new ActionListener(){
	//������ťִ�еķ���
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	adminmenu14();
	}
	});
	
	
	
	
	
	//��ť4
	JButton button4 =new JButton("5.����");
	//�ڴ�������Ӱ�ť
	frame.add(button4);
	button4.setBounds(145,170,200,30);
	//��ʾ����
	frame.setVisible(true);
	//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
	button4.addActionListener(new ActionListener(){
	//������ťִ�еķ���
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	//�����µĴ���
	adminmenu66();
	}


	});
	
	
	
	}

	public static void adminmenu2(){
		//�����µĴ���
		final JFrame frame = adminframe("����ҩƷ��Ϣ");
		
		//��ť1
		JButton button1 =new JButton("1.����ҩƷ��Ϣ");
		//�ڴ�������Ӱ�ť
		frame.add(button1);
		button1.setBounds(145,50,200,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button1.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		 adminmenu21();
		}
		});
		
		//��ť2
		JButton button2 =new JButton("2.ɾ��ҩƷ��Ϣ");
		//�ڴ�������Ӱ�ť
		frame.add(button2);
		button2.setBounds(145,80,200,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button2.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		 adminmenu22();
		}
		});
		
		
		
		//��ť3
		JButton button3 =new JButton("3.����ҩƷ��Ϣ");
		//�ڴ�������Ӱ�ť
		frame.add(button3);
		button3.setBounds(145,110,200,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button3.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		 adminmenu23();
		}
		});
		
		//��ť5
		JButton button5 =new JButton("4.�鿴ҩƷ��Ϣ");
		//�ڴ�������Ӱ�ť
		frame.add(button5);
		button5.setBounds(145,140,200,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button5.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		adminmenu24();
		}
		});
		
		
		//��ť4
		JButton button4 =new JButton("5.����");
		//�ڴ�������Ӱ�ť
		frame.add(button4);
		button4.setBounds(145,170,200,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button4.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		//�����µĴ���
			adminmenu66();
		}
		});
		
		
	}
	
	public static void adminmenu3(){
		//�����µĴ���
		final JFrame frame = adminframe("�����շ���Ϣ");
		
		//��ť1
		JButton button1 =new JButton("1.����ҩƷ����Ϣ");
		//�ڴ�������Ӱ�ť
		frame.add(button1);
		button1.setBounds(145,50,200,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button1.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		//�����µĴ���
		adminmenu31();
		}
		});
		
		//��ť2
		JButton button2 =new JButton("2.�����˵���Ϣ");
		//�ڴ�������Ӱ�ť
		frame.add(button2);
		button2.setBounds(145,80,200,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button2.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		//�����µĴ���
			adminmenu32();
		}
		});
		
		
		
		//��ť3
		JButton button3 =new JButton("3.����");
		//�ڴ�������Ӱ�ť
		frame.add(button3);
		button3.setBounds(145,110,200,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button3.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		//�����µĴ���
		adminmenu66();
		}
		});
				
	}

	public static void adminmenu4(){
		//�����µĴ���
		final JFrame frame = adminframe("�����˺���Ϣ");
	
		//��ť1
		JButton button1 =new JButton("1.�½��˺�");
		//�ڴ�������Ӱ�ť
		frame.add(button1);
		button1.setBounds(145,50,200,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button1.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		adminmenu41();
		}
		});
		
		//��ť2
		JButton button2 =new JButton("2.ɾ���˺�");
		//�ڴ�������Ӱ�ť
		frame.add(button2);
		button2.setBounds(145,80,200,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button2.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		adminmenu42();
		}
		});
		
		
		
		//��ť3
		JButton button3 =new JButton("3.�����˺�");
		//�ڴ�������Ӱ�ť
		frame.add(button3);
		button3.setBounds(145,110,200,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button3.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		adminmenu43();
		}
		});
		
		
		//��ť5
		JButton button5 =new JButton("4.�鿴�˺���Ϣ");
		//�ڴ�������Ӱ�ť
		frame.add(button5);
		button5.setBounds(145,140,200,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button5.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		adminmenu44();
		}
		});
		
		
		//��ť4
		JButton button4 =new JButton("5.����");
		//�ڴ�������Ӱ�ť
		frame.add(button4);
		button4.setBounds(145,170,200,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button4.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		//�����µĴ���
		adminmenu66();
		}
		});
		
		
		
		
	}

	
	public static void adminmenu11(){
		//�����µĴ���
		final JFrame frame = adminframe("����ҽԺ������Ϣ");
		
		final JTextField  text1=new JTextField(10);
		final JTextField  text2=new JTextField(10);
		JLabel la=new JLabel("ID:");
		JLabel la2=new JLabel("����:");
		JButton jbn=new JButton("ȷ��");
        frame.add(la);
        la.setBounds(170,50,50,20);
        frame.add(text1);
        text1.setBounds(200,50,100,20);
        frame.add(la2);
        la2.setBounds(170,90,50,20);
        frame.add(text2);
        text2.setBounds(200,90,100,20);
        frame.add(jbn);
        jbn.setBounds(200,140,100,30);
        
      
        
        jbn.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			  Statement st=null;
			Connection con=null;
			con=DB(con);
		      try {
				st=con.createStatement();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		       String m=text1.getText();
		       int i = Integer.parseInt(m);
		       String s= text2.getText();
		      
		       String sql="set IDENTITY_INSERT Department on;insert into Department (DeptID,DeptName ) values("+i+",'"+s+"')";
			try {
				st.executeUpdate(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			frame.dispose();
		adminmenu1();
		}
		});
		
		//��ť4
		JButton button4 =new JButton("����");
		//�ڴ�������Ӱ�ť
		frame.add(button4);
		button4.setBounds(200,200,100,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button4.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		//�����µĴ���
		adminmenu1();
		}
		});
		
        
	}
	
	public static void adminmenu12(){
		//�����µĴ���
		final JFrame frame = adminframe("ɾ��ҽԺ������Ϣ");
		
		final JTextField  text1=new JTextField(15);
		JLabel la=new JLabel("ID:");
		JButton jbn=new JButton("ɾ��");
        frame.add(la);
        la.setBounds(170,50,50,20);
        frame.add(text1);
        text1.setBounds(200,50,100,20);
        frame.add(jbn);
        jbn.setBounds(200,140,100,30);
        
        
        jbn.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			  Statement st=null;
			Connection con=null;
			con=DB(con);
		      try {
				st=con.createStatement();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		       String m=text1.getText();
		       int i = Integer.parseInt(m);
		
		      
		       String sql="delete from Department where DeptID="+i+"";
			try {
				st.executeUpdate(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			frame.dispose();
		adminmenu1();
		}
		});
        
		//��ť4
		JButton button4 =new JButton("����");
		//�ڴ�������Ӱ�ť
		frame.add(button4);
		button4.setBounds(200,200,100,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button4.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		//�����µĴ���
		adminmenu1();
		}
		});
		
        
        
		
		
		
	}
	
	public static void adminmenu13(){
		//�����µĴ���
		final JFrame frame = adminframe("�޸�ҽԺ������Ϣ");
		
		final JTextField  text1=new JTextField(10);
		final JTextField  text2=new JTextField(10);
		JLabel la=new JLabel("ԭID:");
		JLabel la2=new JLabel("������:");
		JButton jbn=new JButton("ȷ���޸�");
        frame.add(la);
        la.setBounds(170,50,50,20);
        frame.add(text1);
        text1.setBounds(220,50,100,20);
        frame.add(la2);
        la2.setBounds(170,90,50,20);
        frame.add(text2);
        text2.setBounds(220,90,100,20);
        frame.add(jbn);
        jbn.setBounds(200,140,100,30);
		
        
        jbn.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			  Statement st=null;
			Connection con=null;
			con=DB(con);
		      try {
				st=con.createStatement();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		       String m=text1.getText();
		       int i = Integer.parseInt(m);
		       String s= text2.getText();
		      
		       String sql="UPDATE Department SET DeptName='"+s+"'  WHERE DeptID="+i+"";
			try {
				st.executeUpdate(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			frame.dispose();
		adminmenu1();
		}
		});
		
		//��ť4
		JButton button4 =new JButton("����");
		//�ڴ�������Ӱ�ť
		frame.add(button4);
		button4.setBounds(200,200,100,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button4.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		//�����µĴ���
		adminmenu1();
		}
		});
		
		
		
		
	}
	
	public static void adminmenu14() {
		//�����µĴ���
		final JFrame frame = adminframe("�鿴ҽԺ������Ϣ");
		
		JScrollPane scpDemo;
		JTableHeader jth;
	    JTable tabDemo;
	    JScrollPane sc = new JScrollPane();
		sc.setBounds(0,0,500,200);
		frame.add(sc);		
		
		
		//�������ݿ�����	
		//�������ݿ�����	
		Connection conn = null;
		conn=DB(conn);

		// ������ѯ����
		String sql = "select * from Department"; 
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
		} catch (SQLException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		// ִ�в�ѯ
		ResultSet rs = null;
		try {
			rs = pstm.executeQuery();
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		// �����ж�������¼
		int count = 0;
		try {
			while(rs.next()){
			count++;
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			rs = pstm.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
		Object[][] info = new Object[count][2];
		count = 0;
		try {
			while(rs.next()){
			info[count][0] = Integer.valueOf( rs.getInt("DeptID"));
			info[count][1] = rs.getString("DeptName");
			count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// �����ͷ
		String[] title = {"ID","����"};
		// ����JTable
		JTable tab = new JTable(info,title);
		// ��ʾ��ͷ
		jth = tab.getTableHeader();
		// ��JTable���뵽���������������
		sc.getViewport().add(tab); 
		
		
		//��ť4
		JButton button4 =new JButton("����");
		//�ڴ�������Ӱ�ť
		frame.add(button4);
		button4.setBounds(200,200,100,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button4.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		//�����µĴ���
		adminmenu1();
		}
		});
		
		
		
		
		
		
 /*    	JLabel jlb1 = new JLabel();
		frame.add(jlb1);
		jlb1.setBounds(145,50,200,30);
					
		try {
			while(rs.next()){			
				try {
					jlb1.setText("����ID��"+rs.getInt("DeptID"));
					jlb1.setText("�������ƣ�"+rs.getString("DeptName"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
	}
	
	
	public static void adminmenu21(){
		
		//�����µĴ���
		final JFrame frame = adminframe("����ҩƷ��Ϣ");
		
		final JTextField  text1=new JTextField(10);
		final JTextField  text2=new JTextField(25);
		final JTextField  text3=new JTextField(10);
		final JTextField  text4=new JTextField(10);
		JLabel la=new JLabel("ID:");
		JLabel la2=new JLabel("����:");
		JLabel la3=new JLabel("����:");
		JLabel la4=new JLabel("�۸�:");
		JButton jbn=new JButton("ȷ��");
        frame.add(la);
        la.setBounds(170,50,50,20);
        frame.add(text1);
        text1.setBounds(200,50,100,20);
        
        frame.add(la2);
        la2.setBounds(170,70,50,20);
        frame.add(text2);
        text2.setBounds(200,70,100,20);
        
        frame.add(la3);
        la3.setBounds(170,90,50,20);
        frame.add(text3);
        text3.setBounds(200,90,100,20);
        
        frame.add(la4);
        la4.setBounds(170,110,50,20);
        frame.add(text4);
        text4.setBounds(200,110,100,20);
              
        frame.add(jbn);
        jbn.setBounds(200,140,100,30);
		
		
        jbn.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			  Statement st=null;
			Connection con=null;
			con=DB(con);
		      try {
				st=con.createStatement();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		       String m1=text1.getText();
		       int i1= Integer.parseInt(m1);
		       String s= text2.getText();
		       String  m2=text3.getText();
		       int i2 = Integer.parseInt(m2);
		       String m3=text4.getText();
		       float   i3=Float.parseFloat(m3);
		      
		       String sql="insert into Medicine values("+i1+",'"+s+"',"+i2+","+i3+")";
			try {
				st.executeUpdate(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
			frame.dispose();
		adminmenu2();
		}
		});
        
		//��ť4
		JButton button4 =new JButton("����");
		//�ڴ�������Ӱ�ť
		frame.add(button4);
		button4.setBounds(200,200,100,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button4.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		//�����µĴ���
		adminmenu2();
		}
		});
		
		
		
	}
	
	public static void adminmenu22(){
		//�����µĴ���
				final JFrame frame = adminframe("ɾ��ҩƷ��Ϣ");
					
				final JTextField  text1=new JTextField(15);
				JLabel la=new JLabel("ID:");
				JButton jbn=new JButton("ɾ��");
		        frame.add(la);
		        la.setBounds(170,50,50,20);
		        frame.add(text1);
		        text1.setBounds(200,50,100,20);
		        frame.add(jbn);
		        jbn.setBounds(200,140,100,30);
		        
		        
		        jbn.addActionListener(new ActionListener(){
				//������ťִ�еķ���
				public void actionPerformed(ActionEvent e) {
					  Statement st=null;
					Connection con=null;
					con=DB(con);
				      try {
						st=con.createStatement();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				       String m=text1.getText();
				       int i = Integer.parseInt(m);
				
				      
				       String sql="delete from  Medicine where MedID="+i+"";
					try {
						st.executeUpdate(sql);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					frame.dispose();
				adminmenu2();
				}
				});
		
				//��ť4
				JButton button4 =new JButton("����");
				//�ڴ�������Ӱ�ť
				frame.add(button4);
				button4.setBounds(200,200,100,30);
				//��ʾ����
				frame.setVisible(true);
				//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
				button4.addActionListener(new ActionListener(){
				//������ťִ�еķ���
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				//�����µĴ���
				adminmenu2();
				}
				});
				
		
	}
	
	public static void adminmenu23(){
		//�����µĴ���
		final JFrame frame = adminframe("�޸�ҩƷ��Ϣ");

		final JTextField  text1=new JTextField(10);
		final JTextField  text2=new JTextField(25);
		final JTextField  text3=new JTextField(10);
		final JTextField  text4=new JTextField(10);
		JLabel la=new JLabel("��ID:");
		JLabel la2=new JLabel("������:");
		JLabel la3=new JLabel("������:");
		JLabel la4=new JLabel("�¼۸�:");
		JButton jbn=new JButton("ȷ���޸�");
        frame.add(la);
        la.setBounds(170,50,50,20);
        frame.add(text1);
        text1.setBounds(210,50,100,20);
        
        frame.add(la2);
        la2.setBounds(170,70,50,20);
        frame.add(text2);
        text2.setBounds(210,70,100,20);
        
        frame.add(la3);
        la3.setBounds(170,90,50,20);
        frame.add(text3);
        text3.setBounds(210,90,100,20);
        
        frame.add(la4);
        la4.setBounds(170,110,50,20);
        frame.add(text4);
        text4.setBounds(210,110,100,20);
              
        frame.add(jbn);
        jbn.setBounds(200,140,100,30);
		
        
        
        jbn.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			  Statement st=null;
			Connection con=null;
			con=DB(con);
		      try {
				st=con.createStatement();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		       String m1=text1.getText();
		       int i1= Integer.parseInt(m1);
		       String s= text2.getText();
		       String  m2=text3.getText();
		       int i2 = Integer.parseInt(m2);
		       String m3=text4.getText();
		       float   i3=Float.parseFloat(m3);
		      
		       String sql1="UPDATE Medicine SET MedName='"+s+"'  WHERE MedID="+i1+"";
			try {
				st.executeUpdate(sql1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			  String sql2="UPDATE Medicine SET MedNum="+i2+"  WHERE MedID="+i1+"";
			  try {
				st.executeUpdate(sql2);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  
			  String sql3="UPDATE Medicine SET price="+i3+"  WHERE MedID="+i1+"";
			  try {
				st.executeUpdate(sql3);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		frame.dispose();
		adminmenu2();
		}
		});
		
		//��ť4
		JButton button4 =new JButton("����");
		//�ڴ�������Ӱ�ť
		frame.add(button4);
		button4.setBounds(200,200,100,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button4.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		//�����µĴ���
		adminmenu2();
		}
		});
		
        
        
		
		
	}
	
	public static void adminmenu24(){
		//�����µĴ���
		final JFrame frame = adminframe("�鿴ҩƷ��Ϣ");

		JScrollPane scpDemo;
		JTableHeader jth;
	    JTable tabDemo;
	    JScrollPane sc = new JScrollPane();
		sc.setBounds(0,0,500,200);
		frame.add(sc);		
		
		
		//�������ݿ�����	
		//�������ݿ�����	
		Connection conn = null;
		conn=DB(conn);

		// ������ѯ����
		String sql = "select * from Medicine"; 
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
		} catch (SQLException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		// ִ�в�ѯ
		ResultSet rs = null;
		try {
			rs = pstm.executeQuery();
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		// �����ж�������¼
		int count = 0;
		try {
			while(rs.next()){
			count++;
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			rs = pstm.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
		Object[][] info = new Object[count][4];
		count = 0;
		try {
			while(rs.next()){
			info[count][0] = Integer.valueOf( rs.getInt("MedID"));
			info[count][1] = rs.getString("MedName");
			info[count][2] = Integer.valueOf( rs.getInt("MedNum"));
			info[count][3] = Integer.valueOf( rs.getInt("price"));
			count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// �����ͷ
		String[] title = {"ID","����","����","�۸�"};
		// ����JTable
		JTable tab = new JTable(info,title);
		// ��ʾ��ͷ
		jth = tab.getTableHeader();
		// ��JTable���뵽���������������
		sc.getViewport().add(tab); 
		
		
		//��ť4
		JButton button4 =new JButton("����");
		//�ڴ�������Ӱ�ť
		frame.add(button4);
		button4.setBounds(200,200,100,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button4.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		//�����µĴ���
		adminmenu2();
		}
		});
		
		
		
	}
	
	
	
	public static void adminmenu31(){
		//�����µĴ���
		final JFrame frame = adminframe("����ҩƷ����Ϣ");
		
		//��ť1
		JButton button1 =new JButton("1.ɾ��ҩƷ��");
		//�ڴ�������Ӱ�ť
		frame.add(button1);
		button1.setBounds(145,50,200,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button1.addActionListener(new  ActionListener(){
			//������ťִ�еķ���
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
		adminmenu311();
		}


		});
		
		//��ť2
		JButton button2 =new JButton("2.�޸�ҩƷ��");
		//�ڴ�������Ӱ�ť
		frame.add(button2);
		button2.setBounds(145,80,200,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button2.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		adminmenu312();
		}
		});
		
		
		
		//��ť3
		JButton button3 =new JButton("3.�鿴ҩƷ��");
		//�ڴ�������Ӱ�ť
		frame.add(button3);
		button3.setBounds(145,110,200,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button3.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		adminmenu313();
		}
		});
		
		//��ť4
		JButton button4 =new JButton("4.����");
		//�ڴ�������Ӱ�ť
		frame.add(button4);
		button4.setBounds(145,140,200,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button4.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		//�����µĴ���
		adminmenu3();
		}


		});

		
	}
	
	public static void adminmenu311(){
		final JFrame frame = adminframe("ɾ��ҩƷ��");
		
		final JTextField  text1=new JTextField(15);
		JLabel la=new JLabel("ID:");
		JButton jbn=new JButton("ɾ��");
        frame.add(la);
        la.setBounds(170,50,50,20);
        frame.add(text1);
        text1.setBounds(200,50,100,20);
        frame.add(jbn);
        jbn.setBounds(200,140,100,30);
        
        
        jbn.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			  Statement st=null;
			Connection con=null;
			con=DB(con);
		      try {
				st=con.createStatement();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		       String m=text1.getText();
		       int i = Integer.parseInt(m);
		
		      
		       String sql="delete from MedItem where MedItemID="+i+"";
			try {
				st.executeUpdate(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			frame.dispose();
		adminmenu31();
		}
		});
        
		//��ť4
		JButton button4 =new JButton("����");
		//�ڴ�������Ӱ�ť
		frame.add(button4);
		button4.setBounds(200,200,100,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button4.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		//�����µĴ���
		adminmenu31();
		}
		});
		
        
		
		
	}
	
	public static void adminmenu312(){
		final JFrame frame = adminframe("�޸�ҩƷ��");
		final JTextField  text1=new JTextField(10);
		final JTextField  text2=new JTextField(25);
		final JTextField  text3=new JTextField(10);
		final JTextField  text4=new JTextField(10);
		final JTextField  text5=new JTextField(10);
		JLabel la=new JLabel("��ID:");
		JLabel la2=new JLabel("��ҩƷID:");
		JLabel la3=new JLabel("������:");
		JLabel la4=new JLabel("�¼۸�:");
		JLabel la5=new JLabel("�շѵ�ID:");
		JButton jbn=new JButton("ȷ���޸�");
        frame.add(la);
        la.setBounds(150,50,70,20);
        frame.add(text1);
        text1.setBounds(210,50,100,20);
        
        frame.add(la2);
        la2.setBounds(150,70,70,20);
        frame.add(text2);
        text2.setBounds(210,70,100,20);
        
        frame.add(la3);
        la3.setBounds(150,90,70,20);
        frame.add(text3);
        text3.setBounds(210,90,100,20);
        
        frame.add(la4);
        la4.setBounds(150,110,70,20);
        frame.add(text4);
        text4.setBounds(210,110,100,20);
        
        frame.add(la5);
        la5.setBounds(150,130,70,20);
        frame.add(text5);
        text5.setBounds(210,130,100,20);
        
        
        frame.add(jbn);
        jbn.setBounds(200,160,100,30);
		
        
        
        jbn.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			  Statement st=null;
			Connection con=null;
			con=DB(con);
		      try {
				st=con.createStatement();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		       String m1=text1.getText();
		       int i1= Integer.parseInt(m1);
		       String m= text2.getText();
		       int s= Integer.parseInt(m);
		       String  m2=text3.getText();
		       int i2 = Integer.parseInt(m2);
		       String m3=text4.getText();
		       int i3 = Integer.parseInt(m3);
		       String m4=text5.getText();
		       int i4 = Integer.parseInt(m4);
		      
		       String sql1="UPDATE MedItem  SET MedID="+s+"  WHERE MedItemID="+i1+"";
			try {
				st.executeUpdate(sql1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			  String sql2="UPDATE MedItem SET MedNum="+i2+"  WHERE MedItemID="+i1+"";
			  try {
				st.executeUpdate(sql2);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  
			  String sql3="UPDATE MedItem SET price="+i3+"  WHERE MedItemID="+i1+"";
			  try {
				st.executeUpdate(sql3);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			  String sql4="UPDATE MedItem SET chargeID="+i4+"  WHERE MedItemID="+i1+"";
			  try {
				st.executeUpdate(sql4);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  
			
		frame.dispose();
		adminmenu31();
		}
		});
		
		//��ť4
		JButton button4 =new JButton("����");
		//�ڴ�������Ӱ�ť
		frame.add(button4);
		button4.setBounds(200,200,100,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button4.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		//�����µĴ���
		adminmenu31();
		}
		});
		
        
		
		
		
		
	}
	
	public static void adminmenu313(){
		final JFrame frame = adminframe("�鿴ҩƷ��");
		
		JScrollPane scpDemo;
		JTableHeader jth;
	    JTable tabDemo;
	    JScrollPane sc = new JScrollPane();
		sc.setBounds(0,0,500,200);
		frame.add(sc);		
		
		
		//�������ݿ�����	
		//�������ݿ�����	
		Connection conn = null;
		conn=DB(conn);

		// ������ѯ����
		String sql = "select * from MedItem"; 
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
		} catch (SQLException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		// ִ�в�ѯ
		ResultSet rs = null;
		try {
			rs = pstm.executeQuery();
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		// �����ж�������¼
		int count = 0;
		try {
			while(rs.next()){
			count++;
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			rs = pstm.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
		Object[][] info = new Object[count][5];
		count = 0;
		try {
			while(rs.next()){
			info[count][0] = Integer.valueOf( rs.getInt("MedItemID"));
			info[count][1] =  Integer.valueOf( rs.getInt("MedID"));
			info[count][2] =  Integer.valueOf( rs.getInt("MedNum"));
			info[count][3] =  Integer.valueOf( rs.getInt("price"));
			info[count][4] = Integer.valueOf( rs.getInt("chargeID"));
			count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// �����ͷ
		String[] title = {"ID","ҩƷID","ҩƷ����","ҩƷ�۸�","�շѵ�ID"};
		// ����JTable
		JTable tab = new JTable(info,title);
		// ��ʾ��ͷ
		jth = tab.getTableHeader();
		// ��JTable���뵽���������������
		sc.getViewport().add(tab); 
		
		
		//��ť4
		JButton button4 =new JButton("����");
		//�ڴ�������Ӱ�ť
		frame.add(button4);
		button4.setBounds(200,200,100,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button4.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		//�����µĴ���
		adminmenu31();
		}
		});
		
		
		
	}
	
		
	public static void adminmenu32(){
		//�����µĴ���
		final JFrame frame = adminframe("�����շѵ���Ϣ");
	
		//��ť1
		JButton button1 =new JButton("1.ɾ���շѵ�");
		//�ڴ�������Ӱ�ť
		frame.add(button1);
		button1.setBounds(145,50,200,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button1.addActionListener(new  ActionListener(){
			//������ťִ�еķ���
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
		adminmenu321();
		}


		});
		
		//��ť2
		JButton button2 =new JButton("2.�޸��շѵ�");
		//�ڴ�������Ӱ�ť
		frame.add(button2);
		button2.setBounds(145,80,200,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button2.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		adminmenu322();
		}
		});
		
		
		
		//��ť3
		JButton button3 =new JButton("3.�鿴�շѵ�");
		//�ڴ�������Ӱ�ť
		frame.add(button3);
		button3.setBounds(145,110,200,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button3.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		adminmenu323();
		}
		});
		
		//��ť4
		JButton button4 =new JButton("4.����");
		//�ڴ�������Ӱ�ť
		frame.add(button4);
		button4.setBounds(145,140,200,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button4.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		//�����µĴ���
		adminmenu3();
		}


		});
		
		
	}

public static void adminmenu321(){
	final JFrame frame = adminframe("ɾ���շѵ�");
	
	final JTextField  text1=new JTextField(15);
	JLabel la=new JLabel("ID:");
	JButton jbn=new JButton("ɾ��");
    frame.add(la);
    la.setBounds(170,50,50,20);
    frame.add(text1);
    text1.setBounds(200,50,100,20);
    frame.add(jbn);
    jbn.setBounds(200,140,100,30);
    
    
    jbn.addActionListener(new ActionListener(){
	//������ťִ�еķ���
	public void actionPerformed(ActionEvent e) {
		  Statement st=null;
		Connection con=null;
		con=DB(con);
	      try {
			st=con.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	       String m=text1.getText();
	       int i = Integer.parseInt(m);
	
	      
	       String sql="delete from charge where RegID="+i+"";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		frame.dispose();
	adminmenu32();
	}
	});
    
	//��ť4
	JButton button4 =new JButton("����");
	//�ڴ�������Ӱ�ť
	frame.add(button4);
	button4.setBounds(200,200,100,30);
	//��ʾ����
	frame.setVisible(true);
	//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
	button4.addActionListener(new ActionListener(){
	//������ťִ�еķ���
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	//�����µĴ���
	adminmenu32();
	}
	});
	
    
	}

public static void adminmenu322(){
	//�����µĴ���
	final JFrame frame = adminframe("�޸��շѵ�");

	final JTextField  text1=new JTextField(10);
	final JTextField  text2=new JTextField(25);
	final JTextField  text3=new JTextField(10);
	JLabel la=new JLabel("��ID:");
	JLabel la2=new JLabel("���ܼ�:");
	JLabel la3=new JLabel("��״̬:");
	JButton jbn=new JButton("ȷ���޸�");
    frame.add(la);
    la.setBounds(170,50,50,20);
    frame.add(text1);
    text1.setBounds(210,50,100,20);
    
    frame.add(la2);
    la2.setBounds(170,70,50,20);
    frame.add(text2);
    text2.setBounds(210,70,100,20);
    
    frame.add(la3);
    la3.setBounds(170,90,50,20);
    frame.add(text3);
    text3.setBounds(210,90,100,20);
    
          
    frame.add(jbn);
    jbn.setBounds(200,120,100,30);
	
    
    
    jbn.addActionListener(new ActionListener(){
	//������ťִ�еķ���
	public void actionPerformed(ActionEvent e) {
		  Statement st=null;
		Connection con=null;
		con=DB(con);
	      try {
			st=con.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	       String m1=text1.getText();
	       int i1= Integer.parseInt(m1);
	       String s= text2.getText();
	       float   m=Float.parseFloat(s);
	       String  i2=text3.getText();
	       
	      
	       String sql1="UPDATE charge SET sumprice="+m+"  WHERE RegID="+i1+"";
		try {
			st.executeUpdate(sql1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		  String sql2="UPDATE charge SET chargeState='"+i2+"'  WHERE RegID="+i1+"";
		  try {
			st.executeUpdate(sql2);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  
		
	frame.dispose();
	adminmenu32();
	}
	});
	
	//��ť4
	JButton button4 =new JButton("����");
	//�ڴ�������Ӱ�ť
	frame.add(button4);
	button4.setBounds(200,200,100,30);
	//��ʾ����
	frame.setVisible(true);
	//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
	button4.addActionListener(new ActionListener(){
	//������ťִ�еķ���
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	//�����µĴ���
	adminmenu32();
	}
	});
	
    
    
	
	
    }

public static void adminmenu323(){
	final JFrame frame = adminframe("�鿴�շѵ�");
	
	JScrollPane scpDemo;
	JTableHeader jth;
    JTable tabDemo;
    JScrollPane sc = new JScrollPane();
	sc.setBounds(0,0,500,200);
	frame.add(sc);		
	
	
	//�������ݿ�����	
	//�������ݿ�����	
	Connection conn = null;
	conn=DB(conn);

	// ������ѯ����
	String sql = "select * from charge"; 
	PreparedStatement pstm = null;
	try {
		pstm = conn.prepareStatement(sql);
	} catch (SQLException e4) {
		// TODO Auto-generated catch block
		e4.printStackTrace();
	}
	// ִ�в�ѯ
	ResultSet rs = null;
	try {
		rs = pstm.executeQuery();
	} catch (SQLException e3) {
		// TODO Auto-generated catch block
		e3.printStackTrace();
	}
	// �����ж�������¼
	int count = 0;
	try {
		while(rs.next()){
		count++;
		}
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	try {
		rs = pstm.executeQuery();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
	Object[][] info = new Object[count][3];
	count = 0;
	try {
		while(rs.next()){
		info[count][0] = Integer.valueOf( rs.getInt("RegID"));
		info[count][1] = Integer.valueOf( rs.getInt("sumprice"));
		info[count][2] = rs.getString("chargeState");
		count++;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// �����ͷ
	String[] title = {"ID","�ܼ�","�շ�״̬"};
	// ����JTable
	JTable tab = new JTable(info,title);
	// ��ʾ��ͷ
	jth = tab.getTableHeader();
	// ��JTable���뵽���������������
	sc.getViewport().add(tab); 
	
	
	//��ť4
	JButton button4 =new JButton("����");
	//�ڴ�������Ӱ�ť
	frame.add(button4);
	button4.setBounds(200,200,100,30);
	//��ʾ����
	frame.setVisible(true);
	//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
	button4.addActionListener(new ActionListener(){
	//������ťִ�еķ���
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	//�����µĴ���
	adminmenu32();
	}
	});
	
	
	
	
	
    }
	
	
	
	public static void adminmenu41(){
		
		//�����µĴ���
		final JFrame frame = adminframe("�½��˺�");
	
		final JTextField  text2=new JTextField(10);
		final JTextField  text3=new JTextField(10);
		JLabel la2=new JLabel("ְҵID:");
		JLabel la3=new JLabel("����:");
		JButton jbn=new JButton("ȷ��");
        
        frame.add(la2);
        la2.setBounds(170,50,50,20);
        frame.add(text2);
        text2.setBounds(210,50,100,20);
        
        frame.add(la3);
        la3.setBounds(170,70,50,20);
        frame.add(text3);
        text3.setBounds(210,70,100,20);
                     
        frame.add(jbn);
        jbn.setBounds(200,100,100,30);
		
		
        jbn.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			  Statement st=null;
			Connection con=null;
			con=DB(con);
		      try {
				st=con.createStatement();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		       String  m2=text2.getText();
		       int i2 = Integer.parseInt(m2);
		       String s= text3.getText();
		      
		       String sql="insert into Users  values("+i2+",'"+s+"')";
			try {
				st.executeUpdate(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
								
			frame.dispose();
		//adminmenu411();
		adminmenu4();
		}
		});
        
		//��ť4
		JButton button4 =new JButton("����");
		//�ڴ�������Ӱ�ť
		frame.add(button4);
		button4.setBounds(200,200,100,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button4.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		//�����µĴ���
		adminmenu4();
		}
		});
		
		
		
	}
	
	/*public static void adminmenu411(){
		//�����µĴ���
		JFrame frame= new JFrame("�˺�ID");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(null);
		//��������Ļ��λ��
		// �����С
		frame.setSize(300,100);
		frame.setLocation(550, 10);
		// ��ʾ����
		frame.setVisible(true);	
		
		
		JLabel la2=new JLabel("ְҵID:");
        frame.add(la2);
        la2.setBounds(100,20,50,20);

        
        ResultSet rs=null;
		Connection con=null;
		Statement st=null;
        
        try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital","sa","sa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		   
		   try {
			st=con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		   
		   String sql2="select max(userID) from Users";
			try {
				rs=st.executeQuery(sql2);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    
	        JLabel la3=new JLabel("i");
	        frame.add(la3);
	        la3.setBounds(130,20,100,20);
		
		
		
		
	}*/
	
    public static void adminmenu42(){
		
		//�����µĴ���
				final JFrame frame = adminframe("ɾ���˺�");
				
				final JTextField  text1=new JTextField(15);
				JLabel la=new JLabel("ID:");
				JButton jbn=new JButton("ɾ��");
		        frame.add(la);
		        la.setBounds(170,50,50,20);
		        frame.add(text1);
		        text1.setBounds(200,50,100,20);
		        frame.add(jbn);
		        jbn.setBounds(200,140,100,30);
		        
		        
		        jbn.addActionListener(new ActionListener(){
				//������ťִ�еķ���
				public void actionPerformed(ActionEvent e) {
					  Statement st=null;
					Connection con=null;
					con=DB(con);
				      try {
						st=con.createStatement();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				       String m=text1.getText();
				       int i = Integer.parseInt(m);
				
				      
				       String sql="delete from Users where userID="+i+"";
					try {
						st.executeUpdate(sql);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					frame.dispose();
				adminmenu4();
				}
				});
		        
				//��ť4
				JButton button4 =new JButton("����");
				//�ڴ�������Ӱ�ť
				frame.add(button4);
				button4.setBounds(200,200,100,30);
				//��ʾ����
				frame.setVisible(true);
				//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
				button4.addActionListener(new ActionListener(){
				//������ťִ�еķ���
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				//�����µĴ���
				adminmenu4();
				}
				});
				
		        
		        
				
		
		
	}
	
	public static void adminmenu43(){
		//�����µĴ���
		final JFrame frame = adminframe("�޸��˺���Ϣ");

		final JTextField  text1=new JTextField(10);
		final JTextField  text2=new JTextField(10);
		final JTextField  text3=new JTextField(10);
		JLabel la=new JLabel("��ID:");
		JLabel la2=new JLabel("��ְҵID:");
		JLabel la3=new JLabel("������:");
		JButton jbn=new JButton("ȷ���޸�");
        frame.add(la);
        la.setBounds(160,50,60,20);
        frame.add(text1);
        text1.setBounds(210,50,100,20);
        
        frame.add(la2);
        la2.setBounds(160,70,60,20);
        frame.add(text2);
        text2.setBounds(210,70,100,20);
        
        frame.add(la3);
        la3.setBounds(160,90,60,20);
        frame.add(text3);
        text3.setBounds(210,90,100,20);
   
              
        frame.add(jbn);
        jbn.setBounds(200,140,100,30); 
		
        
        
        jbn.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			  Statement st=null;
			Connection con=null;
			con=DB(con);
		      try {
				st=con.createStatement();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		       String m1=text1.getText();
		       int i1= Integer.parseInt(m1);
		       String m2= text2.getText();
		       int i2= Integer.parseInt(m2);
		       String  s=text3.getText();
		      
		       String sql1="UPDATE Users SET roleID="+i2+"  WHERE userID="+i1+"";
			try {
				st.executeUpdate(sql1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			  String sql2="UPDATE Users SET pwd='"+s+"'  WHERE userID="+i1+"";
			  try {
				st.executeUpdate(sql2);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  
			
			
				frame.dispose();
		adminmenu4();
		}
		});
		
		//��ť4
		JButton button4 =new JButton("����");
		//�ڴ�������Ӱ�ť
		frame.add(button4);
		button4.setBounds(200,200,100,30);
		//��ʾ����
		frame.setVisible(true);
		//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
		button4.addActionListener(new ActionListener(){
		//������ťִ�еķ���
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		//�����µĴ���
		adminmenu4();
		}
		});
		
	}
	
	public static void adminmenu44(){
		//�����µĴ���
				final JFrame frame = adminframe("�鿴�˺���Ϣ");
				
				JScrollPane scpDemo;
				JTableHeader jth;
			    JTable tabDemo;
			    JScrollPane sc = new JScrollPane();
				sc.setBounds(0,0,500,200);
				frame.add(sc);		
				
				
				//�������ݿ�����	
				//�������ݿ�����	
				Connection conn = null;
				conn=DB(conn);

				// ������ѯ����
				String sql = "select * from Users"; 
				PreparedStatement pstm = null;
				try {
					pstm = conn.prepareStatement(sql);
				} catch (SQLException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
				// ִ�в�ѯ
				ResultSet rs = null;
				try {
					rs = pstm.executeQuery();
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				// �����ж�������¼
				int count = 0;
				try {
					while(rs.next()){
					count++;
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					rs = pstm.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
				Object[][] info = new Object[count][3];
				count = 0;
				try {
					while(rs.next()){
					info[count][0] = Integer.valueOf( rs.getInt("userID"));
					info[count][1] = Integer.valueOf(rs.getString("roleID"));
					info[count][2] =rs.getInt("pwd");
					count++;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// �����ͷ
				String[] title = {"ID","ְҵID","����"};
				// ����JTable
				JTable tab = new JTable(info,title);
				// ��ʾ��ͷ
				jth = tab.getTableHeader();
				// ��JTable���뵽���������������
				sc.getViewport().add(tab); 
				
				
				//��ť4
				JButton button4 =new JButton("����");
				//�ڴ�������Ӱ�ť
				frame.add(button4);
				button4.setBounds(200,200,100,30);
				//��ʾ����
				frame.setVisible(true);
				//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
				button4.addActionListener(new ActionListener(){
				//������ťִ�еķ���
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				//�����µĴ���
				adminmenu4();
				}
				});	
		
	}
	
	public static void adminmenu66(){
		final JFrame frame = new JFrame("����Ա�ͻ���");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
			
	//�����С
	frame.setSize(500,300);
	frame.setLocation(500, 100);
	//��ť1
	JButton button1 =new JButton("1.����ҽԺ������Ϣ");
	//�ڴ�������Ӱ�ť
	frame.add(button1);
	button1.setBounds(145,50,200,30);
	//��ʾ����
	frame.setVisible(true);
	//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
	button1.addActionListener(new ActionListener(){
	//������ťִ�еķ���
	public void actionPerformed(ActionEvent e) {
	frame.dispose();
	adminmenu1();
	}
	});


	//��ť2
	JButton button2 =new JButton("2.����ҩƷ��Ϣ");
	//�ڴ�������Ӱ�ť
	frame.add(button2);
	button2.setBounds(145,80,200,30);
	//��ʾ����
	frame.setVisible(true);
	//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
	button2.addActionListener(new ActionListener(){
	//������ťִ�еķ���
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	adminmenu2();
	}
	});

	//��ť3
	JButton button3 =new JButton("3.�����շ���Ϣ");
	//�ڴ�������Ӱ�ť
	frame.add(button3);
	button3.setBounds(145,110,200,30);
	//��ʾ����
	frame.setVisible(true);
	//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
	button3.addActionListener(new ActionListener(){
	//������ťִ�еķ���
	public void actionPerformed(ActionEvent e) {
	frame.dispose();
	adminmenu3();
	}
	});

	//��ť4
	JButton button4 =new JButton("4.�����˺���Ϣ");
	//�ڴ�������Ӱ�ť
	frame.add(button4);
	button4.setBounds(145,140,200,30);
	//��ʾ����
	frame.setVisible(true);
	//��ӵ���¼��������������ʹ���κ�������������������ʲô����´����µĴ����ˣ�
	button4.addActionListener(new ActionListener(){
	//������ťִ�еķ���
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	adminmenu4();
	}
	});
		
	}
	
	public static Connection DB(Connection con){
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital","sa","sa");
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} 
	return con;
	}
	
	public static JFrame adminframe(String s){
	final JFrame frame1 = new JFrame(s);
	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame1.setLayout(null);
	//��������Ļ��λ��
	// �����С
	frame1.setSize(500,300);
	frame1.setLocation(500, 100);
	// ��ʾ����
	frame1.setVisible(true);	 
	return frame1;
	}
	
}