package com.mims;
import java.util.*;
public class User{

	/**
	 * @param args
	 */
	public long ID; //ְ�����
	public String Name; //ְ������
	public long PCNumber;//���ʿ���
	public float Pay;//����
	public float MBalance;//ҽ�������
    public boolean state;//ҽ����״̬��ָ���뱣���ʧ
//    public MedicalCard *medicalcard;//ҽ����

	public User(){}    
    //���캯����ʼ����  
    public User(String name,float pay){
    	
    	Name=name;
    	Pay=pay;
    }
    
    public String GetName(){
    	
    	return Name;
    }
    
    public float GetPay(){
    	
    	return Pay;
    }
    
    //���ù��ʿ���
    public void SetPCNumber(long number){
    	
    	PCNumber=number;
    }
    
    //��ȡ���ʿ���
    public long GetPCNumber(){
    	
    	return PCNumber;
    }
    
  //ҽ��������
  	public void MDeposit(float pay){
  		
  		MBalance+=pay*0.09;
  	}
   //ҽ����֧��
  	public void MWithdraw(float expense){
  		
  		if((expense<=MBalance)&(state=true))
  		MBalance-=expense;
  	}
    //�뱣
    public void Join(){
    	
    	System.out.println("����������������");
    	Scanner sc=new Scanner(System.in);
    	String name=sc.nextLine();
    	Name=name;
    	System.out.println("���������Ĺ��ʣ�");
    	float pay=sc.nextFloat();
    	Pay=pay;
    	sc.close();
//    	state=true;
    	MedicalCard medicalcard=new MedicalCard();
    	ID=medicalcard.GetMCNumber()+1000; 
    	medicalcard.SetMPassword();
    	
    }
    
    //�˱�
    public void Exit(){
    	
    	System.out.println("�����˳�ҽ�������ǽ��ջ�����ҽ������лл��");
    	MedicalCard medicalcard=new MedicalCard();
    	medicalcard.retreat();
    }
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MedicalCard medicalcard=new MedicalCard();
		User user=new User("С��",2000);
//		System.out.print(user.GetName());
		user.Join();
		System.out.println(medicalcard.GetMCNumber());
		
	}

}
