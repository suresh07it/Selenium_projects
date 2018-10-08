package first.sample.pgm;

public class Constructor_Ex {

	int iRollNo=20;
	String sName = "Mathan";
	
	public Constructor_Ex() {
		System.out.println("This is My Default Constructo");
	}
	
	public Constructor_Ex(int i,String s) {
		iRollNo = i;
		sName = s;
	}
	
	public void print() {
		System.out.println("Roll No is : "+iRollNo);
		System.out.println("Name is : "+sName);
	}

	public static void main(String[] args) {
		Constructor_Ex oCon = new Constructor_Ex();
		oCon.print();
		Constructor_Ex oCon1 = new Constructor_Ex(100,"Vijay");
		oCon.print();
		oCon1.print();
		Constructor_Ex oCon2 = new Constructor_Ex(200,"Karthick");
		oCon2.print();
		oCon.print();
		oCon1.print();
	}
}
