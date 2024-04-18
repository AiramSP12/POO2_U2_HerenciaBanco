package ufps.poo2.ejercicio.banco;

public class CurrentAccount extends Account {

    private  double overdraftLimit = 5;

    public CurrentAccount(int a) {
        super(a);    }

    public CurrentAccount(int a, double overdraftLimit) {
        super(a);
        this.overdraftLimit = overdraftLimit;
    }
    
    public double getOverdraftLimit(){
        return overdraftLimit;
    }

    @Override
    public void withdraw(double sum) {
        if (sum > 0 && sum <= (getBalance() + overdraftLimit)) {
            super.withdraw(sum);
        } else {
            System.err.println(
                    "CurrentAccount.withdraw(...): cannot withdraw this amount.");
        }
    }
}
