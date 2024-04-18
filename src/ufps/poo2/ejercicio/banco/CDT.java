package ufps.poo2.ejercicio.banco;

public class CDT extends Account {
    private int months;

    public CDT(double amount, int accnum, int months) {
        super(accnum);
        deposit(amount);
        this.months = months;
    }

    @Override
    public void withdraw(double interest){
        double total = getBalance();

        for (int i = 0; i < months; i++) {
            total += total*interest / 100;
        }
        //Bank.closeAccount(this); // si hace estatico el metodo, en este caso ya no por que los bancos dirijen cuentas diferentes
        System.out.println("Se retiro :" + total);
    }

    
}
