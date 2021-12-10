package model;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;
import java.util.Scanner;

public class GiveFoodModel extends Observable{
	private Deque<Integer> time = new LinkedList<>();
	private boolean isValid = false;
	
	public int addTime(int n) {	
	    Iterator it = time.iterator();	
	    if(!it.hasNext()) {
	    	time.add(n);
	    }
	    else {
	    while(it.hasNext()){
	        if((int)it.next() == n) {
	            return -1;
	        }
	    }
	    time.add(n);
	    }
	
	    isValid = true;
	    setChanged();
	    notifyObservers();
	    return 0; 
	}
	
	public void resetTime() {
		time = new LinkedList<Integer>();		
	}
	
	public void delTime() {
		time.removeLast();
	}
		
	
	public Deque<Integer> getTime() {
		return this.time;		
	}
	
	public boolean getisValid() {
	 	   return isValid;
	    } 
	

}