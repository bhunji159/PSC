package model;
import java.util.Observable;

public class CatAlgorithmModel implements WeightControlAlgorithm {
	     private String species;
	     private int age;
	     private double weight;
	     private int foodtime;
	     private double recommended;
	     private double standard_min, standard_max;


	     public CatAlgorithmModel(String a, int b, double c) {
	    	 this.species = a;
	    	 this.age = b;
	    	 this.weight = c;
	     }
	     public void execute(String species, int age, double weight) {
	    	double rer = 30*weight+70;
	    	if(this.species=="Russian Blue") {
	    		this.standard_min = 2.5;
	    		this.standard_max = 3.8;
	    	} 
	    	else if(this.species=="Persian") {
	    		this.standard_min = 3.6;
	    		this.standard_max = 5.7;
	    	}	    		
	    	else {
	    		this.standard_min = 3.0;
	    		this.standard_max = 4.5;
	    	}
	    	//Á¾ Ãß°¡
	    	if(this.age>=9) {
	    		this.foodtime=2;
	            if(this.weight < this.standard_min) {
	                double a=((this.standard_min-this.weight)/(this.standard_min)) + 1.8;
	                double der = rer*a;
	                this.recommended=(der*1000)/(3400*this.foodtime);
	    	    }
	            else if(this.weight > this.standard_max) {
	                double a=1.4-((this.weight-this.standard_max)/(this.standard_max));
	                double der = rer*a;
	                this.recommended=(der*1000)/(3400*this.foodtime);
	    	    }
	            else
	            	this.recommended=(this.weight*0.02*1000)/this.foodtime;
	    	}
	    	else {
	    		if(age<=4) {
	    			this.foodtime=4;
	    		    this.recommended = (this.weight*0.04*1000)/this.foodtime;
	    		}
	    		else  {
	    			this.foodtime=3;
	    		    this.recommended = (this.weight*0.03*1000)/this.foodtime;
	    		}
	    		}
	    	
	     }
	     
	     
	    public String getSpecies() {
	    	return this.species;
	    }
	    
	    
	 	public int getAge() {
	 		return this.age;
	 	}
	 	
	 	
	 	
	 	public double getWeight() {
	 		return this.weight;
	 	}



		@Override
		public int getFoodTime() {
			// TODO Auto-generated method stub
		    return this.foodtime;
		}


		@Override
		public double getFoodAmount() {
			// TODO Auto-generated method stub
		  return this.recommended;
		}
		
        
	     
}