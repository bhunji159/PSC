package model;
import java.util.Observable;

public class MainModel extends Observable{
	
	private int sceneNum ;
	private LoginModel lm = null;
	private MenuModel mm = null;
	private CheckFoodModel fm = null;
	
	public MainModel() {
		this.sceneNum = 0;
		lm = new LoginModel();
		mm = new MenuModel();
		fm = new CheckFoodModel();
	}

	
	public int getScenenum() {
		return sceneNum;
	}
	
	public void setSceneNum(int num) {
		this.sceneNum=num;
		setChanged();
		notifyObservers();
	}
	
	public Object getModel(String str) {
		switch(str) {
			case "LoginModel" : return lm;
			case "MenuModel" : return mm;
			case "CheckFoodModel" : return fm;
		}
		System.out.println("Something is Wrong");
		return null;
	}
	
}