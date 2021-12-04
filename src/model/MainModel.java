package model;
import java.util.Observable;

public class MainModel extends Observable{
	
	private int sceneNum ;
	private LoginModel lm = null;
	private MenuModel mm = null;
	
	public MainModel() {
		this.sceneNum = 0;
		lm = new LoginModel();
		mm = new MenuModel();
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
		}
		System.out.println("Something is Wrong");
		return null;
	}


}