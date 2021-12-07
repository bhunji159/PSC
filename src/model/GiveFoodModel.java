package model;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;
import java.util.Scanner;

public class GiveFoodModel extends Observable{
	private Deque<Integer> time = new LinkedList<>();
	
	public void addTime() {
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
		time.add(n);
		setChanged();
		notifyObservers();
	}
	
	public void resetTime() {
		time = new LinkedList<Integer>();
		System.out.println("시간 설정을 초기화 합니다.");
	}
	
	public void delTime() {
		time.removeLast();
	}
	
	public void giveFood() {
		System.out.println("사료를 줍니다.");
	}
	
	public void checkTime() {
		System.out.println("현재 설정된 시간입니다.");
		Iterator it = time.iterator();
		if(it.hasNext()!=true)
			System.out.println("설정된 시간 정보가 없습니다.");
		while(it.hasNext()) {
			int temp = (int) it.next();
			System.out.printf("%d시 "+"%d분\n",temp/60,temp%60);
		}
	}

}
