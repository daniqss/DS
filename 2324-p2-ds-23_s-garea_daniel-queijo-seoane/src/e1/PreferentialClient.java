package e1;

public class PreferentialClient extends Client{
    public PreferentialClient(String DNI, BankAccount bankAccount) {
        super(DNI, bankAccount);
        if (bankAccount instanceof SavingsAccount savingsAccount) {

            // Modificar la comisión por retiro
            savingsAccount.setCommission(0.02);

            // Modificar el límite mínimo de ingreso
            savingsAccount.setMinimumDeposit(500.0);

            // Modificar el límite mínimo para intereses
            savingsAccount.setMinimumCommission(1.0);
        }
    }



    public boolean withdraw(double amount) {
        BankAccount account = getBankAccount();
        double balance = account.getBalance();

        if (balance - amount >= -1000) {
            return account.withdraw(amount);
        }

        return false;
    }



}
