package proxy;

public class BankServiceImpl implements BankService {
	private String username;
	private int balance;
	
	public BankServiceImpl(String username) {
		this.username = username;
		this.balance = 0;
	}
	
	// 계좌 조회
	@Override
	public int inquery() {
		return balance;
	}
	// 입금
	@Override
	public int deposit(int money) {
		balance += money;
		return balance;
	}
	// 출금. 실패 시 Exception을 던지도록 하였다.
	@Override
	public int withdrawal(int money) throws Exception {
		if(balance < money) {
			throw new Exception("Not enough balance");
		}
		balance -= money;
		return balance;
	}
}
