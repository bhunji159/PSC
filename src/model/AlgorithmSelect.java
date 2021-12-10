package model;
import java.util.Observable;

public class AlgorithmSelect extends Observable {
   private boolean isValid = false;
   private int b;
   private double c;
   private int k;

   
   public void execute(WeightControlAlgorithm a) {
	   String species = a.getSpecies();
	   int age = a.getAge();
	   double weight = a.getWeight();
	   a.execute(species, age, weight);	
	   b = a.getFoodTime();
	   c = a.getFoodAmount();
	   isValid = true;
	   setChanged();
	   notifyObservers();
   }
   
   public double getAmount() {
	   return c;
   }
   
   public int getTime() {
	   return b;
   }
   public boolean getisValid() {
	   return isValid;
   }      
}

