import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class MainClass {

	public static Scanner read=new Scanner(System.in);
	
	
	
	public static void main(String[] args)  {
		
		int choice;
		  try {
		File f = new File ("test.txt");
		
		PrintWriter pw = new PrintWriter(f);
		pw.println(4);
		
		pw.println("- - - -");
		pw.println("- o - -");
		pw.println("- - o -");
		pw.println("- - - -");
		
	    pw.close();
		
	  
		Shareable.readFromfile("test.txt");
		
		
		
		System.out.println("Choose search techniqque:\n");
	   
		System.out.println("1- A* Search. \n2- Gready Search. \n3- Hill Climbing Search. \n4- Simulated Annealing Search.  ");
		
		choice = read.nextInt();
		
		 
		 
		
		 switch (choice) {
		 
		 case 1://   public Node(char[][] matrix ,double h,int c,Node parent)
			 char [][] m = Shareable.copyMatrix(Shareable.matrix);
			 double max = Shareable.calculateMaxCoverage(m);
			 double h =Shareable.calculattHeuristic(max,m);
			 int c = Shareable.countNmberOfCameras(m);
			 Node initialNode = new Node (m,h , c,null);
			 int dim = Shareable.size;
			 
			 AStar aStar = new AStar (dim,initialNode);
			
		//	 Shareable.AStar(Shareable.size ,  new Node initialNode)
			 
			 break ;
			 
		 case 2:
			 
			 char [][] mat = Shareable.copyMatrix(Shareable.matrix);
			 double maxCov = Shareable.calculateMaxCoverage(mat);
			 double heu =Shareable.calculattHeuristic(maxCov,mat);
			 int cost = Shareable.countNmberOfCameras(mat);
			 Node initial = new Node (mat,heu , cost,null);
			 int size = Shareable.size;
			 
			 GreedySearch  gready = new GreedySearch  (size,initial);
			
			 break ;
			 
		 case 3:
			 
			 int count=0;
			 for(int i=0; i<Shareable.size;i++)
			    for(int j=0; j<Shareable.size;j++)
			    	 if(Shareable.matrix[i][j]=='o')
			    		 count++;
			 
			 if(count==Shareable.size*Shareable.size) {
				 System.out.println("\nThe solution:\n");
				 Shareable.printMatrix(Shareable.matrix);
			 }
				 
			 else {
			 
			 char [][] solvedByHillCliambing= HillClimbing.HillCliambing();
			 
			 System.out.println("\nThe solution :");
			 Shareable.printMatrix(solvedByHillCliambing);
		
			 System.out.println("The objective function = "+Shareable.calculateOpjectiveFunction(solvedByHillCliambing));
			 }
			 break ;
			 
			 
		 case 4 :
			 
			 int count1=0;
			 for(int i=0; i<Shareable.size;i++)
			    for(int j=0; j<Shareable.size;j++)
			    	 if(Shareable.matrix[i][j]=='o')
			    		 count1++;
			 
			 if(count1==Shareable.size*Shareable.size) {
				 System.out.println("\nThe solution:\n");
				 Shareable.printMatrix(Shareable.matrix);
			 }
				
			 else {
			 
			 char [][] solvedBySimulatedAnnealing= SimulatedAnnealing .SimulatedAnnealing ();
			 System.out.println("\nThe solution :");
			 
			 Shareable.printMatrix(solvedBySimulatedAnnealing);
			 System.out.println("The objective function = "+Shareable.calculateOpjectiveFunction(solvedBySimulatedAnnealing));
			 }
			 break ; 
			 
		
				 
				 
		 }
		
		
		
		
		
	}
	 catch(FileNotFoundException e) {
		 
		 System.out.println("ERORR: File not found sorry");
	 }
	

	
	
	
	
}


}



