package first.sample.pgm;

public interface Bank {
	boolean withdraw(int accountnumber, int amount);
	int enquiry(int accountnumber);
}
