package view;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import model.WeightControlAlgorithm;
import model.AlgorithmSelect;
import model.CatAlgorithmModel;
import model.DogAlgorithmModel;
import model.MainModel;

public class WeightControllView implements Observer{
	private AlgorithmSelect as = null;
	private MainModel mm =null; 
	
	public WeightControllView(MainModel mm, AlgorithmSelect as) {
		System.out.println("1. 강아지 2. 고양이 : ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		if(a==1) {
			System.out.println("종을 입력하시오 : ");
			String dspecies = sc.next();
			System.out.println("현재 체중을 입력하시오(kg) : ");
			int dweight = sc.nextInt();
			System.out.println("나이를 입력하시오(개월) : ");
			int dage = sc.nextInt();
			as.addObserver(this);
			this.as = as;
			this.mm = mm;			
			as.execute(new DogAlgorithmModel(dspecies, dage, dweight));				
		}
		
		else if(a==2) {
			System.out.println("종을 입력하시오 : ");
			String cspecies = sc.next();
			System.out.println("현재 체중을 입력하시오(kg) : ");
			int cweight = sc.nextInt();
			System.out.println("나이를 입력하시오(개월) : ");
			int cage = sc.nextInt();
			as.addObserver(this);
			this.as = as;
			this.mm = mm;	
			as.execute(new CatAlgorithmModel(cspecies, cage, cweight));
		}
		else 
			System.out.println("잘못된 입력입니다.");
		    mm.setSceneNum(5);
		   
		sc.close();
	}
	

	public void update(Observable o, Object arg) {
		if (as.getisValid() == true) {
			double fa = as.getAmount();
			int ft = as.getTime();
			System.out.println("사료 1회 급여량(g) : " + fa);
			System.out.println("\n\n");
			int k = 24/ft;
			System.out.println("사료 급여 시간 : ");
			for (int i=1; i<=ft; i++) {
			if(k*(i-1)<=16) {
			System.out.println((k*(i-1)+8) + "시");
			}
			else {
			   System.out.println((k*(i-1)-16) + "시"); 
			   }
			}
			System.out.println("\n\n");
			System.out.println("Mode execute/Give Food\n");
		    mm.setSceneNum(2);
		}
		else System.out.println("Error!\n");
		  mm.setSceneNum(1);
	}
}
