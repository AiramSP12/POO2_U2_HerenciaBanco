package ufps.poo2.ejercicio.banco;

public class SavingsAccount extends Account {

    private double interest;

    public SavingsAccount(int accnum, double interest) {
        super(accnum);
        this.interest = interest;
    }

    @Override
    public void deposit(double sum){
        double interestAmount = getBalance() * interest;
        super.deposit(sum + interestAmount);

    }

    public void addInteres(){
        double interesAmount = getBalance()*getInteres();
        super.deposit(interesAmount);

    }
    
    
    public double getInteres(){
        return interest;
    }
}
