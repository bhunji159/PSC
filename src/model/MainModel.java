package model;
import java.util.Observable;

public class MainModel extends Observable{
	
	private int sceneNum ;
	private LoginModel lm = null;
	private MenuModel mm = null;
	private AlgorithmSelect as = null;
	private CheckFoodModel fm = null;
	private GiveFoodModel gm = null;
	
	public MainModel() {
		this.sceneNum = 0;
		lm = new LoginModel();
		mm = new MenuModel();
		as = new AlgorithmSelect();
		fm = new CheckFoodModel();
		gm = new GiveFoodModel();
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
			case "WeightControlModel" : return as;
			case "CheckFoodModel" : return fm;
			case "GiveFoodModel" : return gm;
		}
		System.out.println("Something is Wrong");
		return null;
	}


}