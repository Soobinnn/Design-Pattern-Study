package proxy;

public class BankServiceProxy implements BankService {
	// BankService를 실질적으로 수행할 대리자(대표자) 객체
	private BankServiceImpl bankServiceImpl;
	
	public BankServiceProxy(String username) {
		bankServiceImpl = new BankServiceImpl(username);
	}

	/*
	 * BankServiceImpl에서 구현한 기능은 대리자 객체를 통해 수행시키도록 하였고,
	 * 각 메소드가 동작할 때 상태 메시지를 콘솔에 출력시키는 기능을 추가하였다.
	 */
	@Override
	public int inquery() {
		int balance = bankServiceImpl.inquery();
		System.out.println("* Inquery Success *\n> " + balance);
		return balance;
	}
	@Override
	public int deposit(int money) {
		int balance = bankServiceImpl.deposit(money);
		System.out.println("* Deposit Success *\n> " + balance);
		return balance;
	}
	@Override
	public int withdrawal(int money) {
		try {
			int balance = bankServiceImpl.withdrawal(money);
			System.out.println("* Withdrawal Success *\n> " + balance);
		} catch (Exception e) {
			System.out.println("* Withdrawal Failure *\n> " + bankServiceImpl.inquery());
		}
		return bankServiceImpl.inquery();
	}
}
