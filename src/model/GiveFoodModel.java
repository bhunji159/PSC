package model;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class GiveFoodModel extends Observable {
	private boolean isValid = false;
	private int foodamount, foodtime;
	private int i,j,k;
	Timer f_timer = new Timer();
	
	public void givefood(int i, int j, int k) {
		this.i = i;
		this.j = j;
		this.k = k;
	}
	
    if(i==1) {
    	setFoodAmount(100);
    	TimerTask f_task = new TimerTask() {
    	public void run() {
    		Fooddrop();
    	}
    	};
    	
    	f_timer.schedule(f_task,0);
    	
    else if(i==2) {
    	  setFoodAmount(j);
    	  setFoodTime(k);
    	}
    isValid = true;
    setChanged();
	notifyObservers();
    
    public void setFoodAmount(int f) {
    	this.foodamount = f;
    }
    
    public void setFoodTime(int num) {
    	this.foodtime = num;
    }
    
    public int Fooddrop() {
    	return this.foodamount;
    }
    
    public boolean getIsValid() {
		return isValid;
	}
    
    
    }
    	