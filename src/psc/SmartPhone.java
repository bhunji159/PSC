package psc;

import model.MainModel;
import view.MainView;

public class SmartPhone {
	
	public static void main(String[]args)  {
		MainModel mm = new MainModel();
		new MainView(mm);
		
	}

}
