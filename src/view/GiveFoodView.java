package view;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import model.GiveFoodModel;
import model.MainModel;

public class GiveFoodView implements Observer{

	private GiveFoodModel gm = null;
	private MainModel mm =null;
	
	public GiveFoodView(MainModel mm, GiveFoodModel gm) {
		this.gm = gm;
		this.mm = mm;
		System.out.println("give food menu�� �����Ͻÿ�\n 1)�ٷ� �ֱ� 2)�ִ� �ð� �߰� 3)�ð� �ʱ�ȭ 4)����ȭ������ ������");
		Scanner scn = new Scanner(System.in);
		gm.addObserver(this);
		int choice = scn.nextInt();
		switch (choice) {
		case 1 : this.giveFood(); mm.setSceneNum(2); break;
		case 2 : this.checkTime(); this.addTime(); mm.setSceneNum(2); break;
		case 3 :gm.resetTime(); mm.setSceneNum(2); break;
		default : mm.setSceneNum(2); break;
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(gm.getisValid() == true)
	        System.out.println("�ð� ������ ����Ǿ����ϴ�.");
	    	mm.setSceneNum(2);
	}

	public void addTime(){
		Scanner scan = new Scanner(System.in);
		int hour = -1;
		while(hour<0 || hour>24) {
			System.out.print("���ϴ� �ð��� �Է��Ͻÿ�.\n��: ");
			hour = scan.nextInt();
		}
		int min = -1;
		while(min<0 || min>60) {
			System.out.print("��: ");
			min = scan.nextInt();
		}
		int n = hour*60 + min;
		if(gm.addTime(n)==-1)
			System.out.println("�ߺ��� �ð��Դϴ�.");
		
	}
	public void giveFood() {
		System.out.println("��Ḧ �ݴϴ�.");
	}
	public void resetTime() {
		gm.resetTime();
		System.out.println("�ð� ������ �ʱ�ȭ �մϴ�.");
	}

	public void checkTime(){
		System.out.println("���� ������ �ð��Դϴ�.");
		Iterator it = gm.getTime().iterator();
		if(it.hasNext()!=true)
			System.out.println("������ �ð� ������ �����ϴ�.");
		while(it.hasNext()) {
			int temp = (int) it.next();
			System.out.printf("%d�� "+"%d��\n",temp/60,temp%60);
		}
	}
}
	
