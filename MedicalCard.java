package com.mims;
import java.util.*;
//import java.io.*;

public class MedicalCard {

	
	private long MCNumber=0;//ҽ������
    private String MPassword;//ҽ����֧������
	private float MBalance;//ҽ�������
	private boolean state;//ҽ����״̬��ָ���뱣���ʧ

	//���캯����ʼ����
	public MedicalCard(){
		
		state=true;
		MCNumber++;	
	}
	
	//����ҽ��������
	public void SetMPassword(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("����������ҽ�������룺");
		String str1=sc.nextLine();
		System.out.println("������һ�Σ�");
		String str2=sc.nextLine();
		if(str1.equals(str2)){	
			MPassword=str1;
			System.out.println("��ϲ�����뱣�ɹ���");
		}
		else{
			System.out.println("�������");
		}
//		System.out.println("����Ϊ"+MPassword);

		
	}
	
	//��ȡҽ������
	public long GetMCNumber(){
		
		return MCNumber;
	}
	
	//ҽ��������
	public float MDeposit(float pay){
		
		MBalance+=pay*0.09;
		return MBalance;
	}
	
	//ҽ����֧��
	public void MWithdraw(float expense){
		
		if((expense<=MBalance)&(state=true))
		MBalance-=expense;
	}
	//�˳�ҽ��
	public void retreat(){
		
		state=false;
		MCNumber--;
	}
	
	//��ʧ
    public void drop(){
    	
    	state=false;
    }
    
    //�ط�
    public void resend(){
    	
    	state=true;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MedicalCard m=new MedicalCard();
		m.SetMPassword();

	}

}

