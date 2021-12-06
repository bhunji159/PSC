package view;

import java.util.Observable;
import java.util.Observer;

import model.CheckFoodModel;

public class CheckFoodView implements Observer {

	private CheckFoodModel cfmodel = null;
	
	public CheckFoodView(CheckFoodModel model) {
		model.addObserver(this);
		cfmodel = model;
		System.out.println(cfmodel.getDayHistory());
	}
	@Override
	public void update(Observable o, Object arg) {
		if(cfmodel.isEating())
			System.out.println("사료를 먹었습니다.");
		
	}

}
