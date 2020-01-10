
	import java.util.*;
	
	public class AStar {
		
	    public PriorityQueue frontier;//aka frontier 
	    LinkedList<Node> exp ;//expanded set 
	    public Node initialNode;//parent 
	    public Node finalNode;
	    public  static int dim ;
	    double heur =-1;
	    
	    public  double MAX_COVERAGE=0;
	   
	    
	    public AStar(int dim ,  Node initialNode) {
	    
	    this.initialNode =initialNode; //WE will initilaize it in the main after reading from file;and parent = null  includ all the data 
	    this.dim =dim;
	    frontier = new PriorityQueue();
	    frontier.enqueue(initialNode,initialNode.getF() );
	    exp= new LinkedList();
	     MAX_COVERAGE=Shareable.calculateMaxCoverage(initialNode.getData());
	     popFromFrontier();
	    }
	    
	    /*
	     Taking first element in frontier (priority queue) and check if it's goal or not.
	     if it's not it will generate successors.
	     
	     */
	    public void popFromFrontier() {
	    	
	    	while (heur!=0) {// OUR WE CHANGE IT TO WHILE !openList.empty()********************
	    		if (frontier.length()==0) {//IDK 
	    		
	    		return; 
	    		}
	    	
	       	Node temp = frontier.serve();
	    
	    	
	       	heur = Shareable.calculattHeuristic(MAX_COVERAGE,temp.getData());
	   
	    	if (heur == 0.0 ) {
	    		System .out.println("Goal State:");
	    		char [][] goalState = new char[dim][dim];
	    		goalState  = temp.getData();
	        	Shareable.printMatrix(goalState);
	    		System .out.println("\nPath: ");
	    		finalNode = temp ; 
	    		Shareable.printPath(finalNode);
	    		System .out.println("\nCost: ");
	    		int cost = Shareable.countNmberOfCameras(goalState);
	    		System.out.println(cost+" Cameras");
	    		break; 
	    	}
	    	
	    	else {
	    		
	    		generateSuccssoers(temp);
	    	
	    	}
	    	
	    	
	     }
	   }

	    
	    /*
		 coping the data from the parent and put one camera in every possible place, 
		 calculate heuristic and cost, check if not expanded before if not add to frontier
		  */ 
	    public void generateSuccssoers (Node n ) {
	    	
	    	Node succssoesr = null ;
	    	char [][] matrix = n.getData();//we have to say parent 
	    	char [][] child = new char [dim][dim];
	    	double h = 0 ; 
	    	int c = 0 ; 
	  	   
	 		for(int i =0 ;i<dim ; i++) //copy for first child
	 			for(int j=0; j< dim; j++)
	 				child[i][j]=matrix[i][j];
	 		
	 	
	 		for(int i=0 ;i<dim ;i++ ) {
	    		for (int j=0 ;j<dim ;j++) {
	    			if (child[i][j]=='-'||child[i][j]=='v') {
	    				child[i][j]='c';
	    	
	    				Shareable.updateVisibility(i,j,child);
	    				h=Shareable.calculattHeuristic(MAX_COVERAGE ,child);
	    				c=Shareable.countNmberOfCameras(child);
	    				succssoesr = new Node(child,h,c,n);
	    				int expSize =exp.size();
	    			
	    				if (expSize ==0 ) {
	    					frontier.enqueue(succssoesr, h+c);
	    			
	    				}
	    				
	    				else {//CHECK IF UNIQUE 
	    					
	    					
	    					boolean flag = true;
	    				for (int x=0 ; x<expSize ; x++) {
	    					flag = true; 
	    					char [][]elementInExp =exp.get(x).getData();
	    					for (int row =0 ; row<dim;row++) {
	    						for (int col =0 ; col<dim ;col ++) {
	    							if (child[row][col]!=elementInExp[row][col]) {
	    								flag=false;
	    								break;
	    							}
	    						}
	    						if (flag)
	    							break ; // i found one that matches 
	    					}
	    					
	    				}
	    				
	    				if (!flag)
	    					//System.out.println(openList.length());
	    					frontier.enqueue(succssoesr, h+c);
	    				}
	    					h=0;
	    					c=0;
	    					child = Shareable.copyMatrix(matrix);
	    				
	    			}
	    		}
	    	}
	 		
	 
	 		exp.add(n);
	    	
	    }
	  

	
	
	
	
}
