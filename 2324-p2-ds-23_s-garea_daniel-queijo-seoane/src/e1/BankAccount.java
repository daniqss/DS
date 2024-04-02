package e1;

public abstract class BankAccount {
    private final String IBAN;
    protected double balance;

    public BankAccount(String IBAN) {
        this.IBAN = IBAN;
        this.balance = 0.0;
    }
    public String getIBAN() {
        return IBAN;
    }
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    } //Función para ingresar dinero en la cuenta

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }//Función para retirar dinero de la cuenta


}
