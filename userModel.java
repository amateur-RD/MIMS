/**
 * ���ܣ�user���һ��ģ��
 */
package com.mims;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.*;
public class userModel extends AbstractTableModel{

	Vector rowData,columnNames;//rowData��������ݣ�columnNames�������
	
	//�������ʼ��ģ��
	public void init(String sql){
		
		if(sql.equals("")){
			
			sql="select * from user";
		}
		//�м䲼��
		columnNames=new Vector();
		columnNames.add("ְ�����");
		columnNames.add("����");
		columnNames.add("ҽ������");
		columnNames.add("ҽ�������");
		columnNames.add("ҽ����״̬");
				
		rowData=new Vector();
				
		try{
//			String sql="select * from user";
//			String sql="select * from user where 1=?";
//		    String paras[]={"1"};
		    	   
			//��ʼ��connDB�࣬���������ĳ�Ա����queryExecute
		    connDB cd=new connDB();
//			ResultSet rs=cd.queryExecute(sql, paras);
			ResultSet rs=cd.queryExecute(sql);
			while (rs.next()) {
					  Vector hang=new Vector();
					  hang.add(rs.getString(1));
					  hang.add(rs.getString(2));
					  hang.add(rs.getString(3));
					  hang.add(rs.getString(6));
					  hang.add(rs.getString(7));
					    
					  rowData.add(hang);//���뵽��rowData
					    
//					  System.out.println(rs.getString("userid"));
//				      System.out.println(rs.getString("username"));
				  }
			}
			catch (Exception e) {
				  e.printStackTrace();
			}		
	}
	
	//��sql���Ĺ��캯��
	public userModel(String sql){
		
		this.init(sql);
	}
	
	//���캯������ʼ������ģ��
	public userModel(){
		
		this.init("");
	}
	
	//�õ����ж�����
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}

	//�õ����ж�����
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	//�õ�ĳ��ĳ�е�����
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(row)).get(column);
	}
	
	//��дģ�͵�������������ҽ�����š����ȵȣ�
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String) this.columnNames.get(column);
	}

}
