package com.cy.service;

import java.util.ArrayList;
import com.cy.domain.User;
import com.cy.utils.SqlHelper;

public class UsersService {
	
	public User checkUser(User user){
		
		String sql="select * from user where username=? and password=?";
		String []paras={user.getUsername(),user.getPassword()};
		SqlHelper sqlHelper=new SqlHelper();
		ArrayList al=sqlHelper.executeQuery(sql, paras);//����ѯ�õ������ݴ�ŵ�ArrayList������
		
		if(al.size()==1){
			
			//�û�����,�Ұ�user�������Ϣ��ȫ
			Object objs[]=(Object[]) al.get(0);//get(0)��ʾObject������ֻ��һ��
			
			user.setUserid(objs[0].toString());//objs[1]��ʾ���ݿ���еĵ�2���ֶΣ������Ҳͬ��
			user.setPcnumber(objs[2].toString());
			user.setPay(objs[4].toString());
			user.setMbalance(objs[5].toString());
			user.setState(objs[6].toString());
			return user;
		}else{
			
			return null;
		}
				
	}

}
