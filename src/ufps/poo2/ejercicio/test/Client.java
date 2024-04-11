package ufps.poo2.ejercicio.test;

import ufps.poo2.ejercicio.banco.*;

public class Client{

public static void main(String[] args) {
		/* 
		// ================================================
		// TESTING ACCOUNT CLASS	
		// ================================================
	
		Account acObj = new Account(4); 
		
	
		System.out.println(acObj.getBalance());
		acObj.deposit(10);
		acObj.deposit(40);
		acObj.deposit(20);
		System.out.println(acObj.getBalance());
		acObj.withdraw(20);
		System.out.println(acObj.getBalance());
		
		// ================================================
		// TESTING BANK CLASS	
		// ================================================
		
		
		
		
		Bank bank = new Bank(); 		
		
		bank.openAccount('A', 3354678);
		bank.openAccount('A', 3359302);
		bank.openAccount('C', 3379844);
		
		bank.payDividend(3354678, 10);
		bank.payDividend(3354678, 30);
		
		bank.payDividend(3359302, 50);
		bank.payDividend(3359302, 50);
		
		bank.payDividend(3379844, 10);
		bank.payDividend(3379844, 10);
		
		System.out.println("*** Val = "+bank.getBalance(3379844));
		
		bank.withdrawAccount(3379844, 20);
		bank.withdrawAccount(3379844, 5);
		
		System.out.println("*** Val = "+bank.getBalance(3379844));
		
		bank.withdrawAccount(3379844, 15);
		
		System.out.println("*** Val = "+bank.getBalance(3379844));
		
		bank.sendLetterToOverdraftAccounts();
		
	
		// ==================================================
	
	
		/*
		 	Debería obtener un resultado similar a este:
		 	
		 	*** Val = 20.0
			CurrentAccount.withdraw
			CurrentAccount.withdraw
			Bank.getBalance
			Bank.payDividend ::: ac.getBalance() = -5.0
			*** Val = -5.0
			CurrentAccount.withdraw
			CurrentAccount.withdraw(...): cannot withdraw this amount.
			Bank.getBalance
			Bank.payDividend ::: ac.getBalance() = -5.0
			*** Val = -5.0
			Sending letter to this 3379844 account
		 
		*/
	}
	
	
}
