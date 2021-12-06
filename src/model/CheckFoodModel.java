package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Observable;

import sensors.FoodSensor;

public class CheckFoodModel extends Observable{
	private ArrayList<FoodNode> dayhistory = new ArrayList<FoodNode>();
	private ArrayList<ArrayList<FoodNode>> history = new ArrayList<>();
	private boolean eating;
	
	public void recordNew(String date, double eatenfood) {
		FoodNode temp = new FoodNode(date, eatenfood);
		dayhistory.add(temp);
	}
	
	public void recordDay(ArrayList<FoodNode> day) {
		history.add(day);
	}
	
	public String getDayHistory() {
		String str = "";
		Iterator it = dayhistory.iterator();
		while(it.hasNext()) {
			str += it.next().toString();
		}
		return str;
	}
	
	public boolean isEating() {
		return eating;
	}
	
	public class FoodNode{  //먹은 양
		private String date;
		private FoodSensor foodsensor;
		private static SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		private double eatenfood;
		
		public FoodNode(String date, double eatenfood) {
			this.date=date;
			this.eatenfood = eatenfood;
		}
		
		public void initFoodSensor() {
			foodsensor = new FoodSensor();
		}
		
		public void setDate() {
			Date time = new Date();
			date = format1.format(time);
		}
		
		public void calEatenFood() {
			eatenfood = foodsensor.getBeforeeat()-foodsensor.getAftereat();
			setChanged();
			notifyObservers();
		}
		
		public void isEating() {
			if((foodsensor.getBeforeeat() - foodsensor.getAftereat())>5)
				eating = true;
			else
				eating = false;
		}
		
		public void resetEatenFood() {
			eatenfood = 0;
		}
		
		@Override
		public String toString() {
			String str =date+"\n먹은 사료 양 : "+eatenfood+"\n";
			return str;
		}
		
	}
	
	
}
