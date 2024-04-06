package ufps.poo2.ejercicio.banco;

public class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount(int a, double overdraftLimit) {
        super(a);
    }

    @Override
    public void withdraw(double sum) {
        if (sum > 0 && sum <= (getBalance() + overdraftLimit)) {
            super.withdraw(sum);
        } else {
            System.err.println("CurrentAccount.withdraw(...): Cannot withdraw more than the balance plus overdraft limit.");
        }
    }
}
