
public class LocNode {
   public char [][] data;
   public LocNode next;
   public int dim;
  
   public int objectiveFunction ; 


   public LocNode () {
	
      data = null;
      next = null;
      objectiveFunction =0;
  
   }
   
  
 
   
   

   public LocNode (char [][] val,int objFunction ) { 
	  dim = val[0].length; 
	 
	  
	   data = new char[dim][dim];
	   
	   
		for(int k=0 ;k<data[0].length ; k++)
			for(int x=0; x< data[0].length; x++)
			  data[k][x]=val[k][x];
		
		
		
		
      next = null;
      objectiveFunction =objFunction ;

   }

public char[][] getData() {
	return data;
}

public void setData(char[][] data) {
	this.data = data;
}

public LocNode getNext() {
	return next;
}

public void setNext(LocNode next) {
	this.next = next;
}

public int getObjectiveFunction() {
	return objectiveFunction;
}

public void setObjectiveFunction(int objectiveFunction) {
	this.objectiveFunction = objectiveFunction;
}







   // Setters/Getters...
}
