public class LinkedList2  {
	


    private LocNode head;
	private LocNode current;

	public LinkedList2 () {
		head = current = null;
	}

	public boolean empty () {
		return head == null;
	}

	public boolean last () {
		return current.next == null;
	}
        

        public boolean full () {
		return false;
	}
	public void findFirst () {
		current = head;
	}
	public void findNext () {
		current = current.next;
	}
	public char[][] retrieve_data () {
		return current.data;
	}
	
	public int retrieve_opjectiveFunctoin() {
		return current.objectiveFunction;
	}
	
	public LocNode retrieve() {//retrieve the node 
		
		return current;
	}
	
	
       public void insert (char [][] val, int objFunction) {
		LocNode  tmp;
		if (empty()) {
			current = head = new LocNode (val,objFunction );
		}
		else {
			tmp = current.next;
			current.next = new LocNode (val,objFunction );
			current = current.next;
			current.next = tmp;
		}
	} 
       

       public void remove () {
		if (current == head) {
			head = head.next;
		}
		else {
			LocNode tmp = head;

			while (tmp.next != current)
				tmp = tmp.next;

			tmp.next = current.next;
		}

		if (current.next == null)
			current = head;
		else
			current = current.next;
	}
  
       
       public int size(){
   	   
   	   if(empty())
   		   return 0;
   	   
    	 int counter = 0 ;   
   	 LocNode t = head;
    	 
   	 while (t!= null) {
    		 counter++;
    		 
   		 t=t.next;	 
  	 }
   	 return counter ; 
       }
      
 
      

	public LocNode get(int randomIndex) {
		  LocNode t = head; 
   	   for (int x=0;x<randomIndex ;x++) {
   		   
   		   t=t.next;
   	   }
   	   return t; 
	}

	//@Override
	public void updateObjectiveFunction(int objectiveFunction) {
		 current.objectiveFunction = objectiveFunction;
		
	}

	public void updateData(char[][] matrix, int size) {
		 
		for(int i =0 ;i<size ; i++)
			for(int j=0; j< size; j++)
			   current.data[i][j]=matrix[i][j];
		
		
	}
	
	
	
	
	
	
}