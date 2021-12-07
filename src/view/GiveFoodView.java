package view;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import model.GiveFoodModel;
import model.MainModel;

public class GiveFoodView implements Observer{

	private GiveFoodModel gm = null;
	private MainModel mm =null;
	
	public GiveFoodView(MainModel mm, GiveFoodModel gm) {
		System.out.println("give food menu를 선택하시오\n 1)바로 주기 2)주는 시간 추가 3)시간 초기화 4)메인화면으로 나가기");
		Scanner scn = new Scanner(System.in);
		gm.addObserver(this);
		int choice = scn.nextInt();
		switch (choice) {
		case 1 : gm.giveFood(); mm.setSceneNum(2); break;
		case 2 : gm.checkTime(); gm.addTime(); mm.setSceneNum(2); break;
		case 3 :gm.resetTime(); mm.setSceneNum(2); break;
		default : mm.setSceneNum(2); break;
		}
		this.gm = gm;
		this.mm=mm;
		scn.close();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("시간 설정이 변경되었습니다.");
	}
	

}
