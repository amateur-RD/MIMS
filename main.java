/**
 * ����һ��������
 */
package com.mims;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main extends JFrame implements ActionListener{
	
	//��������ؼ�
	JPanel jp1,jp2;
	JLabel jl1;
	JButton jb1,jb2,jb3,jb4,jb5;
	JTable jt;
	JScrollPane jsp;
	JTextField jtf1,jtf2;
	
	userModel um;
	connDB cd;
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	Vector rowData,columnNames;//rowData��������ݣ�columnNames�������
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		main m=new main();

	}
	
	//���캯��
	public main(){
		
		//���沼��
		jp1=new JPanel();
		jtf1=new JTextField(10);
		jb1=new JButton("��ѯ");
		jb1.addActionListener(this);
		jl1=new JLabel("���������");
		jb5=new JButton("����һ����");
		jb5.addActionListener(this);
		jtf2=new JTextField("��¼ʱ�䣺"+df.format(new Date()));
		jtf2.setBorder(new EmptyBorder(0,0,0,0));
		jtf2.setBackground(null);
		
		//�Ѹ����ؼ��ӵ�jp1
		jp1.add(jl1);
		jp1.add(jtf1);
		jp1.add(jb1);
		jp1.add(jb5);
		jp1.add(jtf2);
		
		//���沼��
		jp2=new JPanel();
		jb2=new JButton("�뱣");
		jb2.addActionListener(this);
		jb3=new JButton("�˱�");
		jb3.addActionListener(this);
		jb4=new JButton("��ʧ");
		jb4.addActionListener(this);
		
		//�Ѹ����ؼ��ӵ�jp2
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		
		//�м䲼��
		//��������ģ��userModel����
		um=new userModel();
		
		
		jt=new JTable(um);//��ʼ��JTable
		
		jsp=new JScrollPane(jt);//��ʼ��jsp JScrollPane
		
		this.add(jsp);//jsp���뵽JFrame��
		this.add(jp1,"North");//jp1���뵽JFrame��
		this.add(jp2,"South");//jp2���뵽JFrame��
		
		this.setSize(600, 400);//���ô��ڴ�С
		this.setTitle("ְ��ҽ��������ϵͳ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�ر�JFrameʱ�ر���Դ����
		this.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//�ж����ĸ���ť�����
		if(e.getSource()==jb1){
			
			String sql;
			String name=this.jtf1.getText().trim();//��ȡ����������������
			if(name.equals("")){
				
				sql="select * from user";
			}else{
				sql="select * from user where username='"+name+"'";
			}
//			String sql="select * from user where username='"+name+"'";
			
			//�����µ�����ģ����
			um=new userModel(sql);
			//����JTable
			jt.setModel(um);
			
	   }else if(e.getSource()==jb2){
			
			userAdd us=new userAdd(this,"�뱣",true);
			
			//�����µ�����ģ����
			um=new userModel();
			//����JTable
			jt.setModel(um);
			
		}else if(e.getSource()==jb3){
			
			//getSelectedRow�������û������е��У���û��ѡ���򷵻�-1
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				//������ʾ��
				JOptionPane.showMessageDialog(this, "��ѡ��Ҫ�˱�ְ����");
				return;
			}
			String id=(String) um.getValueAt(rowNum, 0);
			String sql="delete from user where userid='"+id+"'";
			cd=new connDB();
			cd.updExecute(sql);
			
			um=new userModel();
			//����JTable
			jt.setModel(um);
			
			JOptionPane.showMessageDialog(this, "�˱��ɹ���");
			return;
			
//			System.out.println(id);
			
		}else if(e.getSource()==jb4){
			
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "��ѡ��Ҫ��ʧְ����");
				return;
			}
			String id=(String) um.getValueAt(rowNum, 0);
			String sql="update user set state='��ʧ' where userid='"+id+"'";
			cd=new connDB();
			cd.updExecute(sql);
			
			um=new userModel();
			jt.setModel(um);
			
			JOptionPane.showMessageDialog(this, "��ϲ������ʧ�ɹ�!");
			return;
		}else if(e.getSource()==jb5){
			
			PayRate pr=new PayRate();
			pr.print();
			
		}
		
	}
	

}
