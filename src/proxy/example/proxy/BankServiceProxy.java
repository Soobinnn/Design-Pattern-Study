package proxy;

public class BankServiceProxy implements BankService {
	// BankService를 실질적으로 수행할 대리자(대표자) 객체
	private BankServiceImpl bankServiceImpl;
	private int balance;
	
	public BankServiceProxy(String username) {
		bankServiceImpl = new BankServiceImpl(username);
		balance = bankServiceImpl.inquery();
	}

	/*
	 * BankServiceImpl에서 구현한 기능은 대리자 객체를 통해 수행시키도록 하였고,
	 * 각 메소드가 동작할 때 상태 메시지를 콘솔에 출력시키는 기능을 추가하였다.
	 * 
	 * Proxy의 역할은 Client 역할의 요구를 할 수 있는 만큼 처리하고,
	 * 만약 자신만으로 처리할 수 없으면 RealSubject에게 처리를 맡긴다.
	 */
	@Override
	public int inquery() {
		printStatus("Inquery", true);
		return balance;
	}
	@Override
	public int deposit(int money) {
		balance = bankServiceImpl.deposit(money);
		printStatus("Deposit", true);
		return balance;
	}
	@Override
	public int withdrawal(int money) {
		try {
			balance = bankServiceImpl.withdrawal(money);
			printStatus("Withdrawal", true);
		} catch (Exception e) {
			printStatus("Withdrawal", false);
		}
		return balance;
	}
	public void printStatus(String status, boolean success) {
		System.out.printf("* %s %s *\n> %d\n", status, success ? "Success" : "Faliure", balance);
	}
}
