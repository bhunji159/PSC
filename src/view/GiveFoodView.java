package view;

import java.util.Scanner;

public class GiveFoodView implements Observer{
	private GiveFoodModel gm;
	private MainModel mm;
	
	public GiveFoodView(MainModel mm, GiveFoodModel gm) {
		int a, b = 0;
		System.out.println("1.바로 주기(100g)  2. 사료양, 배식 빈도 조절하여 배식");
		Scanner sc = new Scanner(System.in);
		int num = sc.next();
		gm.addObserver(this);
		this.gm = gm;
		this.mm=mm;
		if(num==2) {
		  System.out.println("원하는 배식량(g) :");
		  a = sc.next();
		  System.out.println("원하는 배식 빈도 : ");
		  b = sc.next();
		}
		gm.givefood(num, a, b);
	
		sc.close();
	}

	@Override
	public void update(Observable o, Object arg) {
		if (gm.getIsValid() == true) {
			System.out.println("Give Food Complete");
			mm.setSceneNum(2);
		}
		else System.out.println("Error");
		mm.setSceneNum(1);
	}
}
