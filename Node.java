public class Node {

    private int c;
    private double f;
    private double h;
    private Node parent;
    public char[][] data;
    
    public Node next;//FOR THE LIST AND Q 
    public double  priority;
    public Node(char[][] matrix ,double h,int c,Node parent) {
        //super();
        this.h=h;
        this.parent=parent;
        this.c=c;
        this.f=h+c; 
        next= null; 
        priority = f ; 
        int dim = matrix[0].length ; 
        data = new char [dim][dim];
        for (int i =0 ; i<matrix[0].length ; i++) {
        	for(int j =0 ; j<matrix[0].length;j++) {
        		data[i][j]=matrix[i][j];
        	}
        }
  
    }


    public double  getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getC() {
        return c;
    }

    public void setC(int g) {
        this.c = c;
    }

    public double getF() {
        return f;
    }

    public void setF(double f) {
        this.f = f;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

  
    public char[][] getData() {
  		return data;
  	}

  	public void setData(char[][] data2) {
  		for(int i =0 ;i<4 ; i++)
 			for(int j=0; j< 4; j++)
 			  data[i][j]=data2[i][j];
  				
  	}
}