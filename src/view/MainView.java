package view;

import model.CheckFoodModel;
import model.LoginModel;
import model.MainModel;
import model.MenuModel;

import java.util.Observable;
import java.util.Observer;

public class MainView  implements Observer{
	
	private MainModel mm = null;
	
	public MainView(MainModel mm) {
		this.mm = mm;
		mm.addObserver(this);
		mm.setSceneNum(1);		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		switch(mm.getScenenum()) {
			case 1 : new LoginView(mm, (LoginModel)mm.getModel("LoginModel")); break;
			case 2 : new MenuView(mm, (MenuModel)mm.getModel("MenuModel")); break;
			case 3 : new CheckFoodView(mm,(CheckFoodModel)mm.getModel("CheckFoodModel")); break;
			case 4 : break;
			case 5 : break;
		}
	}

}
