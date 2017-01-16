package com.mims;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class userAdd extends JDialog implements ActionListener{
	
	//����swing���
	JLabel jl1,jl2,jl3,jl4,jl5;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5;
	JPanel jp1,jp2,jp3;
	
	
	//���캯��
	//ownerΪ�����ڼ��������ڣ�titleΪ��������modelָ����ģʽ���ڣ�����������ȴ������ܽ����������������Ƿ�ģʽ����
	public userAdd(Frame owner,String title,boolean model ){
		
		super(owner,title,model);//���ø��๹�췽��
		jl1=new JLabel("����");
		jl2=new JLabel("ҽ������");
		jl3=new JLabel("����");
		jl4=new JLabel("״̬");
		jl5=new JLabel("ҽ��������");
		
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf3=new JTextField();
		jtf4=new JTextField();
		jtf5=new JTextField();
		
		jb1=new JButton("�뱣");
		jb1.addActionListener(this);
		jb2=new JButton("ȡ��");
		jb2.addActionListener(this);
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		//���ò���
		jp1.setLayout(new GridLayout(5,1));
		jp2.setLayout(new GridLayout(5,1));
		
		//������
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1, BorderLayout.WEST);
		this.add(jp2, BorderLayout.CENTER);
		this.add(jp3, BorderLayout.SOUTH);
		
		
		this.setSize(350, 250);
		this.setVisible(true);
			
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==jb1){
			
			String name=this.jtf1.getText().trim();
			String number=this.jtf2.getText().trim();
			float pay=Float.parseFloat(this.jtf3.getText().trim());//��String����ת��float����
			String state=this.jtf4.getText().trim();
			String password=this.jtf5.getText().trim();
			
			MedicalCard mc=new MedicalCard();
			float balance=mc.MDeposit(pay);
//			System.out.println(name);
			
			String sql="insert into user(username,pcnumber,password,pay,mbalance,state) values('"+name+"','"+number+"','"+password+"','"+pay+"','"+balance+"','"+state+"')";
			
			connDB cd=new connDB();
			cd.updExecute(sql);
			
			this.dispose();
			
			JOptionPane.showMessageDialog(this,"��ϲ�����뱣�ɹ���");
			return;
//			this.setVisible(false);
			
		}else if(e.getSource()==jb2){
			
			this.dispose();
//			this.setVisible(false);
		}
	}

}
