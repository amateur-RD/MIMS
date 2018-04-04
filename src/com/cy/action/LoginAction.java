package com.cy.action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.cy.domain.User;
import com.cy.service.UsersService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	private String username;
	private String password;
	private int sign=1;
	private HttpServletRequest request; 
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSign() {
		return sign;
	}
	public void setSign(int sign) {
		this.sign = sign;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		UsersService usersService=new UsersService();
		User user=new User();
		
		//ActionContext ac=ActionContext.getContext();//���ActionContext����
		//Map session=ac.getSession();
		
		request=ServletActionContext.getRequest();
		
		//���ӱ��л�ȡ�����û��������봫��user����
		user.setUsername(username);//ֱ��ʹ�ñ�������username���Ϳ��Ի�ȡ��login.jspҳ���ύ���û���
		user.setPassword(password);//�����ȡ����ͬ��
		
		//�ж��û��Ƿ�Ϸ���checkUser����ֵ�����ڿգ����û��Ϸ�
		if(usersService.checkUser(user) != null){
			
			//�û��Ϸ�,����user���󱣴浽session�У����ڵ�¼�ɹ����ȡuser�������Ϣ
			request.getSession().setAttribute("userInfo", user);
			
			return SUCCESS;
		}else{
			
			return ERROR;
		}
	}
	
}
