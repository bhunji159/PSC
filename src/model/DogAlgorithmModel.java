
package model;
import java.util.Observable;

public class DogAlgorithmModel implements WeightControlAlgorithm {
	     private String species;
	     private int age;
	     private double weight;
	     private int foodtime;
	     private double recommended;
	     private double standard_min, standard_max;
	     private double der, rer, a;

	     public DogAlgorithmModel(String a, int b, double c) {
	    	 this.species = a;
	    	 this.age = b;
	    	 this.weight = c;
	     }
	     public void execute(String species, int age, double weight) {
	    	if(this.species=="Pomeranian") {
		    		standard_min = 2.1;
		    		standard_max = 3.2;
		    	}
	    	else if(this.species=="Husky") {
	    		standard_min = 16.1;
	    		standard_max = 27.2;
	    	} 
	    	else {
	    		standard_min = 5.0;
	    		standard_max = 10.0;
	    	}
	    		    		    		    	
	    	//Á¾ Ãß°¡
	    	
	    	if(this.age>=12) {
	    		foodtime=2;
	            if(this.weight < standard_min) {
	            	rer = 30*this.weight+70;
	                a=((standard_min-this.weight)/(standard_min)) + 1.8;
	                der = rer*a;
	                recommended=(0.29*der)/2;
	    	    }
	            else if(this.weight > standard_max) {
	            	rer = 30*this.weight+70;
	                a=1.4-((this.weight-standard_max)/(standard_max));
	                der = rer*a;
	                recommended=(0.29*der)/2;
	    	    }
	            else {
	            	recommended=(this.weight*30)/2;
	            }
	    	}	    	
	    	else if(this.age<=3) {
	    		 	foodtime=4;
	    		    recommended = (this.weight*0.07*1000)/4;
	    		}
	        else if(this.age>3  && this.age <=6) {
	    		    foodtime=3;
	    		    recommended = (this.weight*0.06*1000)/3;
	    		}
	        else if(this.age>6  && this.age <=9) {
	    			foodtime=3;
	    		    recommended = (this.weight*0.05*1000)/3;
	    		}
	        else  {
	    			foodtime=2;
	    		    recommended = (this.weight*0.05*1000)/2;
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