package model;

import java.util.Observable;

public class LoginModel extends Observable {
	private String Id = "asd123";
	private boolean isValid = false;
	
	public void Login(String Id) {
		if (this.Id.equals(Id)) isValid = true;
		setChanged();
		notifyObservers();
	}
	
	public String getId() {
		return this.Id;
	}
	
	public boolean getIsValid() {
		return isValid;
	}

}
