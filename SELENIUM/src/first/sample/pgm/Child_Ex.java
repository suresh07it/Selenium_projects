package first.sample.pgm;

public class Child_Ex extends Parent_Ex {
	int iChildID = 900;
	String name = "Vijay";
	
	public Child_Ex() {
	
		System.out.println("Child Default Constructor");
	}

	public void print() {
		System.out.println("Method Override");
	}
	
	public void display() {
		System.out.println("Child ID is : "+iChildID);
		System.out.println("Name is : "+name);
	
	}
	

	public static void main(String[] args) {
		Child_Ex oChild = new Child_Ex();
		oChild.print();
		oChild.display();
		System.out.println("======Parent=======");
		Parent_Ex oParent = new Parent_Ex();
		oParent.print();
		System.out.println("======Ref========");
		Parent_Ex oRef = new Child_Ex();
		oRef.print();
			
}
}
