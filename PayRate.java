package com.mims;

public class PayRate {

	/**
	 * @param args
	 */
	public float Paycost;//֧������
	
	//�Է��������
	public float SelfFinance (float cost){
		
		Paycost=cost;
		return Paycost;
	}
	
	//��ͨ�������
	public float General(float cost){
		
		Paycost=0.7f*cost;
		return Paycost;
	}
	
	//���������
	public float Serious(float cost){
		
		Paycost=0.8f*cost;
		return Paycost;
	}
	//��ӡ����һ����
	public void print(){
		
		System.out.println("****����֧������һ����****");
		System.out.println("�Է������Ҫ֧��ȫ����ҽ�Ʒ���");
		System.out.println("��ͨ�����Ҫ֧��ҽ�Ʒ��õ�70%");
		System.out.println("�������Ҫ֧��ҽ�Ʒ��õ�80%");
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PayRate pr=new PayRate();
		pr.print();

	}

}
