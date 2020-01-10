
public class PriorityQueue {
private Node head; 
private int size ;

public PriorityQueue() {
	head= null; 
	size=0;
}
public int length (){
    return size;
}
public boolean full () {
    return false;
}
public void enqueue(Node e, double pty) {
	
	Node tmp = new Node (e.getData(),e.getH(),e.getC(),e.getParent());
	pty = e.getF();
	
    if((size == 0) || (pty < head.priority)) {
          tmp.next = head;
          head = tmp; 
    }
    
    else {
          Node p = head;
          Node q = null;
          while((p != null) && (pty > p.priority)) 
          {
        	  	q = p;
        	  	p = p.next; 
          }
          	tmp.next = p;
          	if (q!=null)
          	q.next = tmp;
      }
    		size++; 
}
public Node serve() {
	Node t =head ; 
	Node served = new Node (t.getData(),t.getH(),t.getC(),t.getParent());
	head = head.next;
	size--;
	return served; 
}

}