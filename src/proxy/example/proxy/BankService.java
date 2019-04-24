package proxy;

public interface BankService {
	public int inquery();
	public int deposit(int money);
	public int withdrawal(int money) throws Exception;
}
