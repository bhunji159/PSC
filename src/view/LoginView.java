package view;

import java.util.Scanner;


import model.LoginModel;
import model.MainModel;
import java.util.Observable;
import java.util.Observer;

public class LoginView implements Observer {
	
	private LoginModel lm = null;
	private MainModel mm = null;
	
	public LoginView(MainModel mm, LoginModel lm) {
		System.out.println("Enter Your ID");
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println("Enter Your PassWord");
		String pw = scn.next();
		lm.addObserver(this);
		this.lm = lm;
		this.mm=mm;
		int result = lm.login(str, pw);
		scn.close();
	}

	@Override
	public void update(Observable o, Object arg) {
		if (lm.getIsValid() == true) {
			System.out.println("Login Complete");
			mm.setSceneNum(2);
		}
		else
			System.out.println("Login Failed");
            mm.setSceneNum(1);
	}
}
