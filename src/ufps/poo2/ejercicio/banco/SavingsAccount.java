package ufps.poo2.ejercicio.banco;

public class SavingsAccount extends Account {

    private double interest;

    public SavingsAccount(int a, double interest) {
        super(a);
        this.interest = interest;
    }

    public void addInterest() {
        double balance = getBalance();
        double interestAmount = balance * interest;
        deposit(interestAmount);
    }
}
