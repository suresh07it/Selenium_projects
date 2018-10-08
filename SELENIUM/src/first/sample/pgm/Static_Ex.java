package first.sample.pgm;

public class Static_Ex {
	
	int iRollNo;
	String sName;
	static String sBatch = "WeekEnd";
	 static int iCount;
	
	public Static_Ex(int i,String s) {
		iRollNo = i;
		sName = s;
		iCount++;
	}
	
	public void print() {
		System.out.println("Roll No is : "+iRollNo);
		System.out.println("Name is : "+sName);
		System.out.println("Batch is : "+sBatch);
		System.out.println("Count is : "+iCount);
	}

	public static void display() {
		System.out.println("This is a Static Method");
		
	}
	
	
	
	public static void main(String[] args) {
		
		Static_Ex oBj1 = new Static_Ex(100,"Vijay");
		oBj1.print();
		Static_Ex oBj2 = new Static_Ex(101,"Gopi");
		oBj2.print();
		Static_Ex oBj3 = new Static_Ex(102,"Karthick");
		oBj3.print();
		display();
		//Static_Ex.display();

	}

}