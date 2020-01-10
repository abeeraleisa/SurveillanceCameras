import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import java.util.LinkedList;

public class Shareable {
	
	
	
public static char[][] matrix;
	
public static int size;

/* reads the matrix from the given file */
public static void readFromfile(String fileName) throws FileNotFoundException{
		  int counter = 0; 
		  File file = new File (fileName);

		  Scanner	  read = new Scanner(file); 
		  int i=0;
		  int j = 0 ; 

		  int index =0 ; 
		 

		  while (read.hasNext()) {
			  
			  if (counter== 0 )
			  {
				  size =Integer.parseInt(read.next()) ;
				
				  matrix = new char [size][size];	  
			  }
			  counter++ ; 
			
			  //check if work . reads only one piece
		
			  
			  while (i<size) {
				  for (j=0;j<size ; j++) {
					  String line = read.next();
					  matrix[i][j]=line.charAt(index);
				  }
				i++;
			  }

		  }
		  
		  
		  System.out.println("The original matrix from file: ");
		  for (int x=0 ;x<size ;x++) {
			  for(int y=0 ; y<size ; y++) {
				  System.out.print(matrix[x][y]+" ");
			  }
			  System.out.println();
		  }
		  System.out.println();
	}

	

public static int calculateNumberOfCoverage(char[][]matrix) {

	int counter =0 ; 
	int dim = matrix[0].length;
	for (int i=0 ; i<dim ;i++) {
		for (int j= 0;j<dim ;j++) {
			if (matrix[i][j]=='v')
				counter++;
		}
	}
	return counter ;
}

public  static double countNumberOfEmptyPosition(char[][] matrix) {
  	 
	  int count=0;
	  int dim = matrix[0].length;
	  
		  for(int i=0; i<dim; i++) {
			  
			   for(int j=0; j<dim; j++) {
				   
				  if( matrix[i][j]=='-')
					  count++;
			   }
		  
		  
	  }
	  
	  return count;
	  
}

public static char[][] copyMatrix(char[][] matrix) {
	  

	  char[][] coppedMatrix= new  char[matrix[0].length][matrix[0].length];
	  

	  for(int i=0 ; i< matrix[0].length ; i++)
		  

		     for (int j=0; j< matrix[0].length ;j++)
		    	 

		    	 coppedMatrix[i][j]=matrix[i][j];
	  

	  return coppedMatrix;
  }

public static void printMatrix(char[][] matix ) {
	

	

		for(int i=0; i<matix[0].length ; i++) {
			for(int j=0; j< matix[0].length ;j++) {
				

				System.out.print(matix[i][j]+" ");
         	}
			System.out.println();
			

		}
		

	

	}


public static void printPath (Node terminal ) {
	
	
		 LinkedList<Node> list = new LinkedList<Node>();
			list.add(terminal);
			Node current = terminal.getParent();
			while(current!=null) {
				 list.add(current);
				 current=current.getParent();
			}
			System.out.println("Solution Path: ");
			while(!list.isEmpty()) {
				printMatrix(list.removeLast().getData());
				System.out.println("\n-----------------------------");
			}


		}



public static int countNmberOfCameras(char[][] matrix){
	   
	   int count=0;
	   for(int i=0; i<matrix[0].length; i++) {
			  
		   for(int j=0; j<matrix[0].length; j++) {
			   
			  if( matrix[i][j]=='c')
				  count++;
		   }
	  
    }
	   return count;
	   
 }

/* this method set the visibility for a given camera  */
public static  void updateVisibility(int k, int r, char[][] matrix) {
	  int size= matrix[0].length ;
	   

	   

		for (int i =k ;i>=0 ;i--) {//filling what's above the camera 
			if (matrix[i][r]!='v' && matrix[i][r]!='c') {
				if (matrix[i][r]=='o')
					break;
			matrix[i][r]='v';
			

			} 
		}
			

			for (int j =k ;j<size ;j++) {//filling what's under the camera 
				if (matrix[j][r]!='v' && matrix[j][r]!='c') {
					if (matrix[j][r]=='o')
						break;
				matrix[j][r]='v';
				

			} 	
		}
			

			for (int x =r ;x>=0 ;x--) {//filling what's on the camera's left
				if (matrix[k][x]!='v' && matrix[k][x]!='c') {
					if (matrix[k][x]=='o')
						break;
				matrix[k][x]='v';
				

			} 	
		}

			for (int y =r ;y<size ;y++) {//filling what's on the camera's right
				if (matrix[k][y]!='v' && matrix[k][y]!='c') {
					if (matrix[k][y]=='o')
						break;
				matrix[k][y]='v';
			

			} 	
		}
			

			int times =1 ; 
			int cols = r;
			int rows=k;
		

			while (rows-times>=0) {//filling what's on the camera's uper right diagonal
			

					if (cols+times>=size ||rows-times <0)
						break;
					if (matrix[rows-times][cols+times] =='o')
						break;
					if (matrix[rows-times][cols+times]=='-')
					matrix[rows-times][cols+times]='v';
					times++;
				}
		

			

			

			 times =1 ; 
			 cols = r;
			 rows=k;
			while (rows-times>=0) {
			//filling what's on the camera's uper left diagonal it should be one loop 
				if (rows-times<0 ||cols-times<0 ) 
					break;
				if (matrix[rows-times][cols-times] =='o')
					break; 
				if (matrix[rows-times][cols-times]=='-')
					matrix[rows-times][cols-times]='v';
				times++;
			}
			

			

			times =1 ; 
			cols = r;
			rows = k ; 
			while (rows+times<size) {//filling what's on the camera's lower left diagonal
		

					if (cols-times<0||rows+times >=size)//////////check the size thing
						break;
					if (matrix[rows+times][cols-times] =='o')
						break; 
					if (matrix[rows+times][cols-times]=='-')
					matrix[rows+times][cols-times]='v';
					times++;
			}
			

			times =1 ; 
			cols = r;
			rows = k ; 
			while (rows+times<size) {//filling what's on the camera's lower Right diagonal
		

					if (cols+times>=size||rows+times >=size)//////////check the size thing
						break;
					if (matrix[rows+times][cols+times] =='o')
						break; 
					if (matrix[rows+times][cols+times]=='-')
					matrix[rows+times][cols+times]='v';
					times++;
			}
			
	  }

public  static double calculateMaxCoverage(char [][] matrix) {
	double MAX_COVERAGE =0.0;
	int dim = matrix[0].length ;
	char [][]cMatrix = new char [dim][dim];
	//first copy matrix 
	for (int x =0 ; x<dim ;x++) {
		for (int y=0 ; y<dim ;y++) {
			cMatrix[x][y]= matrix[x][y];
		}
	}
	
	//second find max coverage f
	
	
	for (int i =0 ; i< dim ;i++) {
		for (int j=0 ; j<dim ;j++) {
			if (cMatrix[i][j]!='o') {
				cMatrix [i][j]='c';
				updateVisibility(i,j,cMatrix);
				int coverage =calculateNumberOfCoverage( cMatrix);
				if (MAX_COVERAGE<coverage)
					MAX_COVERAGE=coverage ; 
				//return it to original matrix by coping again 
				for (int a=0;a<dim;a++) {
					for (int b =0 ;b<dim ;b++) {
						cMatrix[a][b]= matrix[a][b];
					}
				}
				
			}
		}
		
	}
	return MAX_COVERAGE;
}

public  static double calculattHeuristic(double MAX_COVERAGE , char [][] matrix ) {
	

		
		double emptyCelles =countNumberOfEmptyPosition(matrix);
		if (MAX_COVERAGE==0  && emptyCelles == 0  )return 0;
		double h =  (emptyCelles)/MAX_COVERAGE ; 
		
		return h ; 

	}




/* #cameras + #empty cells */
public static  int calculateOpjectiveFunction(char[][] matrix ) {



    return (int)countNumberOfEmptyPosition(matrix)+countNmberOfCameras( matrix); 

}



/* this method takes a state and generate all possible neighbors */
public static LinkedList2 generateNeighbors(LocNode state) {
	  
	 
	
	  LinkedList2 Neighbors = new  LinkedList2();
	  

	
	char [][] Matrix = state.getData();  
	
	
	
	char [][] Neighbor = copyMatrix(Matrix);

		
		for(int i=0 ;i<size ;i++ ) {
		for (int j=0 ;j<size ;j++) {
			if (Neighbor[i][j]=='-'||Neighbor[i][j]=='v') {
				Neighbor[i][j]='c';
				
				
	          updateVisibility(i,j,Neighbor);
	          
	        Neighbors.insert(Neighbor, calculateOpjectiveFunction(Neighbor));
	        
	        
	        
				Neighbor = copyMatrix(Matrix);
	
			
			}
		}	
		}
		
	LinkedList2 ApplyingRemoveAction=removeOneCamera(state.data);
	

	if(!ApplyingRemoveAction.empty()){
		
		ApplyingRemoveAction.findFirst();
		while(!ApplyingRemoveAction.last()) {
			 Neighbors.insert(ApplyingRemoveAction.retrieve_data(), ApplyingRemoveAction.retrieve_opjectiveFunctoin());
			 ApplyingRemoveAction.findNext();
		}
		
		 Neighbors.insert(ApplyingRemoveAction.retrieve_data(), ApplyingRemoveAction.retrieve_opjectiveFunctoin());
	}
		
		
	 return  Neighbors;
	  
	  
}


/* this method removes one camera at a time from a given state */
public static LinkedList2 removeOneCamera(char[][] Matrix){
	  
	
	
	
	  LinkedList2 AfterRemoving= new LinkedList2();



	  int arraySize=countNmberOfCameras(Matrix);
	  
	
	  
	  if(arraySize<=1) {//why
		  AfterRemoving.insert(matrix, calculateOpjectiveFunction(matrix));
		  return AfterRemoving ;
		 
	  }


	  
	  int[] Ipositions= new int [arraySize];
	  int[] Jpositions= new int [arraySize];
	  
	  int[] NEWIpositions= new int [arraySize]; 
	  int[] NEWJpositions= new int [arraySize];
	  
	  int index=0;

	  for(int k=0; k<size ; k++) {
	  	for(int r=0 ; r<size ; r++) {
	  		
	         if(Matrix[k][r] == 'c' ) {
	  			
	  			 Ipositions[index]=k;
	  			 Jpositions[index]=r;
	  			 
	  			NEWIpositions[index]=k;
	  		      NEWJpositions[index]=r;
	  			 
	  			 index++;
	  			 
	  		}
	  	}
	  }
	  
	  
	  boolean[] haveBeenRemoved= new boolean [arraySize];
	  
	  //the original matrix because i want the o too
	       
	       
	       for(int i =0 ; i< arraySize ; i++) {
	    	   
	    	 	char[][] newMatrix= new char[size][size];
	    	  	
	 	       for(int k=0 ; k< size ; k++)
	 	      	 for(int r=0 ; r<size ; r++)
	 	      		 newMatrix[k][r]=matrix[k][r];
	    	   

	 	       if( ! haveBeenRemoved[i] ) {
	       for(int k=0 ; k<arraySize ;k++) {
	    	   
	      	 if(i==k) //
	      		 continue;
	      	 
	    	   if(NEWIpositions[k]!=-1 || NEWJpositions[k]!=-1) {
	      	 newMatrix[Ipositions[k]][Jpositions[k]]='c';
	      
	   
	     updateVisibility(Ipositions[k], Jpositions[k], newMatrix);
	      	 
	     	NEWIpositions[k]=-1;
	      	NEWJpositions[k]=-1;
	      	
	       }
	    	  
	      }
	       
	       for(int m=0; m<arraySize ;m++ ) {
	    		NEWIpositions[m]= Ipositions[m];
	      	NEWJpositions[m]=Jpositions[m];
	       }
	       
	       haveBeenRemoved[i]=true;
	       AfterRemoving.insert(newMatrix, calculateOpjectiveFunction(newMatrix));
	    }
	       }
	       return AfterRemoving;
}

/*create the initial state by randomly selecting the position of the fist camera */
public static  LocNode intialState() {

	  
	 char[][] newMatrix =copyMatrix(matrix);
	 
	 

	 
	while(true) {
			
			
		int i=getRandomIndex(size);
		int j=getRandomIndex(size);
		
	      if(newMatrix[i][j]=='-') {
	    	
	   
	    	  newMatrix[i][j]='c' ;
	    	  
	    	 
	    	  updateVisibility(i, j, newMatrix);
	    	  
	    	
	    	  LocNode intialState= new LocNode(newMatrix, calculateOpjectiveFunction(newMatrix));
	    	  
	    	
	    	 return intialState;
	      }
	  
	 }
 }

public static int getRandomIndex(int range) {
	  
    final Random random = new Random();

    return random.nextInt(range);
  }

}