package model;

public interface WeightControlAlgorithm {
	public void execute(String species, int age, double weight);
	public int getFoodTime();
	public double getFoodAmount();
	public String getSpecies();
	public int getAge();
	public double getWeight();
}
