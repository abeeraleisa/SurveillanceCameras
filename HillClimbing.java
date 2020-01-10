

public class HillClimbing {

  
/* this method will do the hillClismbing search by comparing the objective function between the current and
 the best neighbor if it's better it will be the best solution if not the search will stop and return the current solution
 "we aim for minimizing the objective function" */
  public static char [][] HillCliambing(){
	  
	  System.out.println("Hill Climbing search\n");
	 
	  
	 
	  LocNode  bestSolution = Shareable.intialState(); // generate the intial statye randomly 
	  
	  
	  System.out.println("The selected intial State: ");
	  
	  
	  Shareable.  printMatrix(bestSolution.data);
	  
	  
	  System.out.println();
	  
	
		
		
		
		while(true) {
			
	
			
			 System.out.println();
			 
			System.out.println("The chosen neighbor from the prevous state: ");
			
		LocNode NewSolution = chooseTheBestNeighbor(bestSolution); 
		
		Shareable. printMatrix(NewSolution.data);
		
		 
		System.out.println("the objective function is = "+NewSolution.objectiveFunction);
		
		if(NewSolution.objectiveFunction < bestSolution.objectiveFunction ) 
		{
			bestSolution=NewSolution;

		}
		
		else {
			break;
		}
	
	}
		return bestSolution.data;

}	
	
	
 
  
  /* this method aims to choose the best neighbor from the neighbors for the given state  */

  public static LocNode chooseTheBestNeighbor(LocNode state) {
	  
	 
	  
	  LinkedList2 TheNeighbors= Shareable.generateNeighbors(state);
	  
	  int ListSize= TheNeighbors.size();
	  
	  int i=1;
	  
	
	 
	  TheNeighbors.findFirst();
	  
	int best=  TheNeighbors.retrieve_opjectiveFunctoin();
	
	int TheIndexOfTheBest=0;
	
	
	  while(i< ListSize ) {
		  
		
		  TheNeighbors.findNext();
		  
		  if(TheNeighbors.retrieve_opjectiveFunctoin() < best ) { //working in minmaizin the objective function 
			    best= TheNeighbors.retrieve_opjectiveFunctoin();
			    
			    TheIndexOfTheBest=i+1;  
		  
		  }
		  
		 i++;
		  
		}

	  int m=0;
	  TheNeighbors.findFirst();
	  
	  while(m<TheIndexOfTheBest ) {
		  TheNeighbors.findNext(); 
		  m++;
	  }
	  
	  

	
	return TheNeighbors.retrieve();
	  
  }
  
  
  
  
  

  
  
  
	  
	   

  
 
  
  
  
  
   
   
  
 

  



  
  
  
  
  
  
  
 
  
 	  
	
	

}
