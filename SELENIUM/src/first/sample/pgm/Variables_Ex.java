package first.sample.pgm;

public class Variables_Ex {
int i=100;
String s="usha";
static int k=25;
public void sum()
{
	int r=15,j=20,c;
	c=r+j;
	System.out.println("Sum is : "+c);
k++;
i++;
	
}

public static void su()
{
	int k=100,j=20,c;
	c=k+j;
	System.out.println("Sum is : "+c);
	
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a=10,b=20,c;
		c = a+b;
		System.out.println("Sum is : "+c);
		Variables_Ex.su();
		Variables_Ex oSum = new Variables_Ex();
		System.out.println("static afer creating obj"+k);
		System.out.println("global after creating obj"+oSum.i);
		oSum.sum();
		System.out.println("static after inc"+k);
		System.out.println("with old obj global variable"+oSum.i);
        Variables_Ex uobj= new Variables_Ex();
        System.out.println("new obj created"+uobj.i);
        System.out.println("staic after inc and new obj created"+k);
		System.out.println(oSum.s);
		
	}
}