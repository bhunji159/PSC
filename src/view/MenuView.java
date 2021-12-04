package view;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import model.MainModel;
import model.MenuModel;

public class MenuView implements Observer{
	
	private MainModel mm = null;
	private MenuModel MM = null;
	
	public MenuView(MainModel mm, MenuModel MM) {
		this.mm = mm;
		this.MM =MM;
		MM.addObserver(this);
		this.ShowMenu();
		
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		switch(MM.getNum()) {
		case 1 : System.out.println("CheckFood"); mm.setSceneNum(3); break;
		case 2 : System.out.println("WeightControll"); mm.setSceneNum(4);;
		}
		
	}
	
	public void ShowMenu() {
		System.out.println("Choose Menu");
		System.out.println("1. Check Food");
		System.out.println("2. WeightControll");
		Scanner scn = new Scanner(System.in);
		MM.setNum(scn.nextInt()); 
		scn.close();
	}

}
