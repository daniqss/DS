package e1;

public class VIPClient extends Client{
    public VIPClient(String DNI, BankAccount bankAccount) {
        super(DNI, bankAccount);
        if (bankAccount instanceof SavingsAccount savingsAccount) {

            // Modificar la comisión por retiro
            savingsAccount.setCommission(0);

            // Modificar el límite mínimo de ingreso
            savingsAccount.setMinimumDeposit(0);

            // Modificar el límite mínimo para intereses
            savingsAccount.setMinimumCommission(0);
        }
    }
    public boolean withdraw(double amount) {
        BankAccount account = getBankAccount();
        double balance = account.getBalance();
        return account.withdraw(amount);
    }
}

