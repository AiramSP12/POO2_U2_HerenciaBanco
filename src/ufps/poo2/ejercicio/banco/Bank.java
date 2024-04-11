package ufps.poo2.ejercicio.banco;

import java.util.List;
import java.util.ArrayList;

public class Bank {

    public List<Account> accounts;

    public Bank(){
        accounts = new ArrayList<>();
    }

    public void openAccount(Account account) {
        accounts.add(account);
    }

    public void openAccount(char typeAccount, int accnum, double io) { //interest / over
        if (typeAccount == 'A') {
            accounts.add(new SavingsAccount(accnum, io));
        } else if (typeAccount == 'C') {
            accounts.add(new CurrentAccount(accnum, io));
        } else {
            System.err.println("Invalid account type.");
        }
    }

  

    public void closeAccount(Account account) {
        accounts.remove(account);
    }

    public void deposit(int accnum, double sum){ 
        for(Account account : accounts){
            if(account.getAccountNumber() == accnum){
                account.deposit(sum);
                return;
            }
        }
        System.err.println("Account not found with account number: " + accnum);
    }
    public void withdraw(int accnum, double amount) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accnum) {
                account.withdraw(amount);
                return;
            }
        }
        System.err.println("Account not found with account number: " + accnum);
    }

    public double getBalance(int accnum) throws IllegalArgumentException {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accnum) {
                return account.getBalance();
            }
        }
        throw new IllegalArgumentException("Account not found with account number: " + accnum);
    }
    

    public void sendLetterToOverdraftAccounts() {
        for (Account account : accounts) {
            if (account instanceof CurrentAccount) {
                CurrentAccount currentAccount = (CurrentAccount) account;
                if (currentAccount.getBalance() < 0) {
                    System.out.println("Sending letter to this " + currentAccount.getAccountNumber() + " account");
                }
            }
        }
    }

}
