package ufps.poo2.ejercicio.banco;

import java.util.List;
import java.util.ArrayList;

public class Bank {

    private  List<Account> accounts; 
    public   final double cdtInterest;

    public Bank() {
        cdtInterest = 0;
        accounts = new ArrayList<Account>();
    }

    public Bank(double cdtInterest) {
        accounts = new ArrayList<>(); 
        this.cdtInterest = cdtInterest;
    }

    public   double getCdtInterest() {
        return cdtInterest;
    }

    public void openAccount(Account account) {
        accounts.add(account);
    }

    public void openAccount(char typeAccount, int accnum) {
        if (typeAccount == 'A') {
            accounts.add(new SavingsAccount(accnum));
        } else if (typeAccount == 'C') {
            accounts.add(new CurrentAccount(accnum));
        } else {
            System.err.println("Invalid account type.");
        }
    }

    public void openAccount(char typeAccount, int accnum, double io) { // interest / over
        if (typeAccount == 'A') {
            accounts.add(new SavingsAccount(accnum, io));
        } else if (typeAccount == 'C') {
            accounts.add(new CurrentAccount(accnum, io));
        } else {
            System.err.println("Invalid account type.");
        }
    }

    public  void closeAccount(Account account) {
        accounts.remove(account);
    }

    public void deposit(int accnum, double sum) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accnum) {
                account.deposit(sum);
                return;
            }
        }
        System.err.println("Account not found with account number: " + accnum);
    }

    public void withdraw(int accnum, double amount) {
        Account account = accountSearch(accnum);
        if (account != null) {
            if (account instanceof CDT) {
                account.withdraw(getCdtInterest());
                closeAccount(account);
            }
            else
            account.withdraw(amount);
        }
    }
    

    public Account accountSearch(int accnum) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accnum) {
                return account;
            }
        }
        System.err.println("Account not found with account number: " + accnum);
        return null;
    }

    public double getBalance(int accnum) throws IllegalArgumentException {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accnum) {
                return account.getBalance();
            }
        }
        throw new IllegalArgumentException("Account not found with account number: " + accnum);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (accounts.isEmpty()) {
            sb.append("No accounts in the bank.");
        }
        else {
            sb.append("Accounts in the bank:\n");
            for (Account account : accounts) {
            sb.append("---------------\n"); 
                if (account instanceof CDT) {
                    sb.append("Account type: CDT (" + this.cdtInterest + "%)\n");
                } 
                else if (account instanceof SavingsAccount){
                    sb.append("Account type: SavingsAccount \n");
                }
                else if (account instanceof CurrentAccount){
                    sb.append("Account type: CurrentAccount \n");
                }
                else{
                sb.append("Account type: Account \n");
                }
                sb.append("Account number: ").append(account.getAccountNumber()).append("\n");
                sb.append("Balance: ").append(account.getBalance()).append("\n");
            }
            sb.append("---------------\n");
        }
        return sb.toString();
    }

    public void sendLetterToOverdraftAccounts() {
        for (Account account : accounts) {
            if (account instanceof CurrentAccount) {
                CurrentAccount currentAccount = (CurrentAccount) account;
                if (currentAccount.getBalance() < currentAccount.getOverdraftLimit()) {
                    System.out.println("Sending letter to this " + currentAccount.getAccountNumber() + " account");
                }
            }
        }
    }

}
