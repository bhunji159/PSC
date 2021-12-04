package model;

import java.util.Observable;

public class MenuModel extends Observable{

	private int num = 0;
	
	public void setNum(int num) {
		this.num=num;
		setChanged();
		notifyObservers();
	}
	
	public int getNum() {
		return num;
	}
}
