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
	}
	@Override
	public void update(Observable o, Object arg) {
		if(cfmodel.isEating())
			System.out.println("사료를 먹었습니다.");
		mm.setSceneNum(2);
	}

}
