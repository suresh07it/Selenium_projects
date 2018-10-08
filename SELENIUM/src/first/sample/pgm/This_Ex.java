package first.sample.pgm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class This_Ex {

		
		int iRoll_No;
		String sName;
		int k=10;
		
		public void dp() {
			int k=20;
			this.k++;
			this.k=this.k+k;
			System.out.println(this.k);
		}
		
		public This_Ex(int iRoll_No,String sName) {
			this();
			this.iRoll_No = iRoll_No;
			this.sName = sName;
		}
	public This_Ex(int i) {
			
			System.out.println("I value is : "+i);
		}
		
		public This_Ex() {
			this(10);
			System.out.println("This is a Default Constructor");
		}
		
		public void print() {
			System.out.println("Roll No is : "+iRoll_No);
			System.out.println("Name is : "+sName);
		}
		
		public void display() {
			print();
			//this.print();
		}
		
		public static void main(String[] args) {
			This_Ex oBj = new This_Ex(10,"Mathan");
			oBj.print();
			oBj.dp();
		}

	}
	

