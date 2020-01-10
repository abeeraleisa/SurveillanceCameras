

import java.io.FileNotFoundException;

import java.util.Random;

public class SimulatedAnnealing {

  private final static double updateTemperature = 0.98;
private static double temperature = 10;
  private static double probability ;

 
  
 public static char [][] SimulatedAnnealing(){
	  
	  System.out.println("Simulated Annealing search\n");
	 
	
	 
	  LocNode  bestSolution =  Shareable.intialState(); // generate the intial statye randomly 
	  
	  System.out.println("The selected intial State: ");
	  
	  Shareable. printMatrix(bestSolution.data);
	  
	  System.out.println();
	  
	
		
		
      while( temperature > 0) {
		
    	
    	  
		System.out.println();
		System.out.println("The chosen neighbor from the previous state: ");
			
		LocNode NewSolution = selectRandomNeighbor(bestSolution); //best neighbor from the neighbors
		
		 Shareable.printMatrix(NewSolution.data);
		
		 
		System.out.println("the objective function is = "+NewSolution.getObjectiveFunction());
		
		if(NewSolution.objectiveFunction < bestSolution.objectiveFunction ) 
		{
			bestSolution=NewSolution;

		}
		else //taking the bad move
			{
			int delta = NewSolution.objectiveFunction - bestSolution.objectiveFunction ;
			
			probability = Math.exp(delta/temperature);
			
			double randomx = Math.random();
			
			if (randomx<=probability) {
				bestSolution=NewSolution;
				
			}

			
			}
		
		  temperature =    temperature * updateTemperature;
		}
		
	
	
	return bestSolution.data;

}	
		
		
 
 
 
 public static  LocNode selectRandomNeighbor(LocNode State) {
	 
	 
	LinkedList2 TheNeighbors=  Shareable.generateNeighbors(State);
	
	
	int numberOfNeighbors= TheNeighbors.size();
	
	 int RandomIndex= (int)(Math.random() *numberOfNeighbors );
	
	  int numberOfIterition =0;
	 
	  TheNeighbors.findFirst();
	  
	 while( numberOfIterition < RandomIndex ) {
		 
		 
		 TheNeighbors.findNext();
		 
		 numberOfIterition ++;
	 }
	 
	 
	 
	 return TheNeighbors.retrieve();
	 
	 
 }

 
 
 
 
 
 
 
  
  
}