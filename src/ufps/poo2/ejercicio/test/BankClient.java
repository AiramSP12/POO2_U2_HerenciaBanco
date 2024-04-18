package ufps.poo2.ejercicio.test;

import ufps.poo2.ejercicio.banco.*;

public class BankClient {

    public static void main(String[] args) {
        // ================================================
        // TESTING ACCOUNT CLASS
        // ================================================

        System.out.println("test Account");

        try {
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

        } catch (Exception e) {
            System.err.println("Error al realizar operaciones en la cuenta: " + e.getMessage());
        }

        // ================================================
        // TESTING BANK CLASS
        // ================================================

        System.out.println("test Bank");

        // Crear un banco
        Bank bank = new Bank();

        try {
            // Abrir cuentas
            bank.openAccount('A', 123); // Cuenta de ahorros
            bank.openAccount('A', 456, 5); // Cuenta de ahorros
            bank.openAccount('C', 789, 2000);// Cuenta corriente

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
            bank.deposit(123, 1000);
            System.out.println("Saldo de la cuenta 123: " + bank.getBalance(123));

            // eliminar una cuenta
            bank.closeAccount(bank.accountSearch(456));
            System.out.println("Saldo de la cuenta 456: " + bank.getBalance(456));

        } catch (Exception e) {
            System.err.println("Error en cuenta " + e.getMessage());
        }

        bank.withdraw(789, 2000);
        System.out.println("Saldo de la cuenta 789: " + bank.getBalance(789));
        // Enviar cartas a cuentas en sobregiro
        bank.sendLetterToOverdraftAccounts();
        Bank bank2 = new Bank();

        bank2.openAccount('A', 321); // Cuenta de ahorros
        bank2.openAccount('A', 656, 5); // Cuenta de ahorros
        bank2.openAccount('C', 12, 2000);// Cuenta corriente

        // Realizar depósitos
        bank2.deposit(321, 1000);
        bank2.deposit(656, 500);
        bank2.deposit(12, 1500);

        // Realizar retiros
        bank2.withdraw(321, 200);
        bank2.withdraw(656, 300);
        bank2.closeAccount(bank2.accountSearch(321));
        System.out.println(bank2);
        System.out.println(bank);
        Bank bankCDT = new Bank(1);
        bankCDT.openAccount(new CDT(100000, 1, 12));
        System.out.println(bankCDT);
        bankCDT.withdraw(1, 1);
        System.out.println(bankCDT);

        
    }
}