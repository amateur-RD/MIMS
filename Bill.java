package com.mims;
import java.sql.*;
import java.util.*;

public class Bill {
	
	private User user=new User();
	public float expend;//֧������
	
	//���캯������ʼ��ְ����Ϣ
	public Bill(){
		
		for(int i=0;i<1;i++)  
        { 
            System.out.println("�������"+(i+1)+"��ְ�������������ʡ�֧�����ã�");
            Scanner sc=new Scanner(System.in);
            String str=sc.nextLine();
            float pay=sc.nextFloat();
            float expense=sc.nextFloat();
//          System.out.println(str); 
            try {
  		      Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
  		    }
  		    catch (Exception e) {
  		      e.printStackTrace();
  		    }
  		    try {
  		      Connection connect = DriverManager.getConnection(
  		          "jdbc:mysql://localhost:3306/mims","root","admin");
  		           //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������

  		      Statement stmt = connect.createStatement();
//  		      ResultSet rs = stmt.executeQuery("select * from user"); //user Ϊ�������
  		      int rs = stmt.executeUpdate("insert into user(username,pcnumber,pay,mbalance,state) values('"+str+"',1210000,'"+pay+"','"+0.09*pay+"','����')"); //user Ϊ�������
  		                                                             
  		    }
  		    catch (Exception e) {
  		      e.printStackTrace();
  		    }
  		    
//            sc.close();

        }  
		
	}
	
	//��ѯ��ӡְ����Ϣ
		public void Print(){
			
			System.out.println("�����������ѯ��ְ����������");
			Scanner sc=new Scanner(System.in);
		    String str=sc.nextLine();
		    try {
			      Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
			      //Class.forName("org.gjt.mm.mysql.Driver");
			    }
			    catch (Exception e) {
			      e.printStackTrace();
			    }
			    try {
			      Connection connect = DriverManager.getConnection(
			          "jdbc:mysql://localhost:3306/mims","root","admin");
			           //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������

			      Statement stmt = connect.createStatement();
			      ResultSet rs = stmt.executeQuery("select * from user where username='"+str+"'"); //user Ϊ�������
			                                                              
			while (rs.next()) {
				    System.out.println("ְ����ϸ��Ϣ���£�");
//				    System.out.println("����ְ����Ϊ��"+rs1.getString("useid"));
			        System.out.println("���Ĺ��ʿ���Ϊ��"+rs.getString("pcnumber"));
			        System.out.println("���Ĺ���Ϊ��"+rs.getString("pay"));
			        System.out.println("�������Ϊ��"+rs.getString("mbalance"));
			        System.out.println("����ҽ����ʹ��״̬��"+rs.getString("state"));
			      }
			    }
			    catch (Exception e) {
			      e.printStackTrace();
			    }
	}
		    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bill bi=new Bill();
		bi.Print();
		    

	}

}
