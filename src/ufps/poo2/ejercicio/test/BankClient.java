package ufps.poo2.ejercicio.test;

import ufps.poo2.ejercicio.banco.*;

public class BankClient{

    public static void main(String[] args) {
        // ================================================
        // TESTING ACCOUNT CLASS    
        // ================================================
        
        System.out.println("test Account");

        // Crear una cuenta de ahorros
        Account account1 = new SavingsAccount(123, 0.15);
        // Realizar un depósito
        account1.deposit(1000);
        // Imprimir el estado de la cuenta
        account1.print();

        // Crear una cuenta corriente
        Account account2 = new CurrentAccount(456, 0);
        // Realizar un depósito
        account2.deposit(500);
        // Imprimir el estado de la cuenta
        account2.print();

        // ================================================
        // TESTING BANK CLASS    
        // ================================================
        
		System.err.println("test Bank");

        // Crear un banco
        Bank bank = new Bank();

        // Abrir cuentas
        bank.openAccount('A',123, 10); // Cuenta de ahorros
        bank.openAccount('A',456, 5); // Cuenta de ahorros
		bank.openAccount('C',789, 2000);// Cuenta corriente

        // Realizar depósitos
        bank.deposit(123, 1000);
        bank.deposit(456, 500);
		bank.deposit(789, 1500);

        // Realizar retiros
        bank.withdraw(123, 200);
        bank.withdraw(456, 300);

        // Pagar dividendos
        bank.deposit(122, 50);

        // Obtener saldo de cuentas
        double balance1 = bank.getBalance(123);
        double balance2 = bank.getBalance(456);
		double balance3 = bank.getBalance(789);

        
        // Imprimir saldo de cuentas
        System.out.println("Saldo de la cuenta 123: " + balance1);
        System.out.println("Saldo de la cuenta 456: " + balance2);
        System.out.println("Saldo de la cuenta 789: " + balance3);


        // Enviar cartas a cuentas en sobregiro
        bank.sendLetterToOverdraftAccounts();
    }   
}
