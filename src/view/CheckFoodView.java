package view;

import java.util.Observable;
import java.util.Observer;
import model.MainModel;

import model.CheckFoodModel;

public class CheckFoodView implements Observer {

	private CheckFoodModel cfmodel = null;
	private MainModel mm = null;
	
	public CheckFoodView(MainModel mm, CheckFoodModel model) {
		this.mm = mm;
		model.addObserver(this);
		cfmodel = model;
		System.out.println(cfmodel.getDayHistory());	
		mm.setSceneNum(2);
	}
	@Override
	public void update(Observable o, Object arg) {
		if(cfmodel.isEating()) {
			System.out.println("��Ḧ �Ծ����ϴ�.");
		    mm.setSceneNum(2);
		}
	}

}
