package first.sample.pgm;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Showing 1 – 24 of 110 results for \"iphone7\"";
		String[] split = str.split(" ");
		int count = Integer.parseInt(split[5]);
		System.out.println(count);
	}

}
