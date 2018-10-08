package first.sample.pgm;

public class Array_Ex {
	public static void main(String[] args) {
		
		int a[] = {10,20,30,40,50};
		/*int []b = {10,20,30,40,50};
		int[] c = {10,20,30,40,50};
		int [] d = {10,20,30,40,50};
		int e[] = new int[5];
		e[0] = 30;
		e[1] = 40;*/
		
		System.out.println(a[3]);
		
		for(int i=0;i<5;i++) {
			System.out.println(a[i]);
			
			if(a[i]==30) {
				System.out.println("Value is 30 : "+a[i]);
				break;
			}else {
				System.out.println("Value is not 30 : "+a[i]);
			}
		}
		
		int i=0;
		do {
			System.out.println("This is Do While");
			System.out.println(a[i]);
			i++;
		} while (i<5);
	}
}


