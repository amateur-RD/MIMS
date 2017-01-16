/**
 * ���ܣ�����MySQL���ݿ�
 */

package com.mims;
import java.sql.*;

public class connDB {

	PreparedStatement stmt=null;
	Connection connect=null;
	ResultSet rs=null;
	String user="root";
	String password="admin";
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/mims";
	
	//�ر����ݿ���Դ
	public void close(){
		
		try{
			 if(rs!=null) rs.close();
			 if(stmt!=null) stmt.close();
			 if(connect!=null) connect.close();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}
	
	//��ѯ���ݿ����������Ҫ����������ѯȫ�����ݣ�
	public ResultSet queryExecute(String sql){
		
		try{
			
			Class.forName(driver);//�������� 
		    Connection connect = DriverManager.getConnection(url,user,password);//�������
		    stmt=connect.prepareStatement(sql);
		    rs=stmt.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return rs;
	}
	//��ѯ���ݿ����(������ѯ��
	public ResultSet queryExecute(String sql,String []paras){
		
		try{
			
			Class.forName(driver);//�������� 
		    Connection connect = DriverManager.getConnection(url,user,password);//�������
		    stmt=connect.prepareStatement(sql);
		    //��ps��ֵ
		    for(int i=0;i<paras.length;i++){
			 
			     stmt.setString(i+1,paras[i]);
		    }
		    rs=stmt.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return rs;
	}
	
	//����һ������
	public boolean updExecute(String sql){
		
		boolean b=true;
		try{
		    Class.forName(driver);//�������� 
		    Connection connect = DriverManager.getConnection(url,user,password);//�������
		    stmt=connect.prepareStatement(sql);
		    //ִ�в���
		    if(stmt.executeUpdate()!=1){
			 
			    b=false;
		    }
		 }catch(Exception e){
			 
			 b=false;
			 e.printStackTrace();
		 }finally{
			 this.close();
		 }
	  return b;
	}
	
	//����ɾ�ĺ���һ��
	public boolean updExecute(String sql,String []paras){
		
		boolean b=true;
		try{
		    Class.forName(driver);//�������� 
		    Connection connect = DriverManager.getConnection(url,user,password);//�������
		    stmt=connect.prepareStatement(sql);
		    //��ps��ֵ
		    for(int i=0;i<paras.length;i++){
			 
			     stmt.setString(i+1,paras[i]);
		    }
		    //ִ�в���
		    if(stmt.executeUpdate()!=1){
			 
			    b=false;
		    }
		 }catch(Exception e){
			 
			 b=false;
			 e.printStackTrace();
		 }finally{
			 this.close();
		 }
	  return b;
     }
	
}
