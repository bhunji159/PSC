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
		System.out.println("give food menu를 선택하시오\n 1)바로 주기 2)주는 시간 추가 3)시간 초기화 4)메인화면으로 나가기");
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
	        System.out.println("시간 설정이 변경되었습니다.");
	    	mm.setSceneNum(2);
	}

	public void addTime(){
		Scanner scan = new Scanner(System.in);
		int hour = -1;
		while(hour<0 || hour>24) {
			System.out.print("원하는 시간을 입력하시오.\n시: ");
			hour = scan.nextInt();
		}
		int min = -1;
		while(min<0 || min>60) {
			System.out.print("분: ");
			min = scan.nextInt();
		}
		int n = hour*60 + min;
		if(gm.addTime(n)==-1)
			System.out.println("중복된 시간입니다.");
		
	}
	public void giveFood() {
		System.out.println("사료를 줍니다.");
	}
	public void resetTime() {
		gm.resetTime();
		System.out.println("시간 설정을 초기화 합니다.");
	}

	public void checkTime(){
		System.out.println("현재 설정된 시간입니다.");
		Iterator it = gm.getTime().iterator();
		if(it.hasNext()!=true)
			System.out.println("설정된 시간 정보가 없습니다.");
		while(it.hasNext()) {
			int temp = (int) it.next();
			System.out.printf("%d시 "+"%d분\n",temp/60,temp%60);
		}
	}
}
	
