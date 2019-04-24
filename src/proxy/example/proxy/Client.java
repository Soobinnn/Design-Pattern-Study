package proxy;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws Exception {
		Scanner command = new Scanner(System.in);

		System.out.print("S I M P L E   B A N K   S E R V I C E\nI(nquery), D(eposit), W(ithdrawal), Q(uit) \n> Enter your name: ");
		BankService bankService = new BankServiceProxy(command.nextLine());
		
		while(true) {
			System.out.print("> ");
			String argument1 = command.nextLine();
			if(argument1.equalsIgnoreCase("I")) {
				bankService.inquery();
			} else if(argument1.equalsIgnoreCase("D")) {
				System.out.print("How much? ");
				bankService.deposit(command.nextInt());
				command.nextLine();
			} else if(argument1.equalsIgnoreCase("W")) {
				System.out.print("How much? ");
				bankService.withdrawal(command.nextInt());
				command.nextLine();
			} else if(argument1.equalsIgnoreCase("Q")) {
				System.out.println("Service Terminated");
				break;
			} else {
				System.out.println("Wrong Command");
			}
		}
	}
}
