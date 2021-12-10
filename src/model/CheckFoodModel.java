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
	private String date;
	private SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	{
		for(int i=0;i<10;i++) {
			Date time = new Date();
			date = format1.format(time);
			FoodNode node=new FoodNode(date, i*10);
			dayhistory.add(node);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
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
	
	public class FoodNode{  //
		private String date;
		private FoodSensor foodsensor;
		private SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
			String str = date+"\n¸ÔÀº »ç·á ¾ç : "+eatenfood+"\n";
			return str;
		}
		
	}
}
