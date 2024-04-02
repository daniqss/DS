package e1;

public abstract class Client {
    private String DNI;
    private BankAccount bankAccount;

    public Client(String DNI, BankAccount bankAccount) {
        this.DNI = DNI;
        this.bankAccount = bankAccount;
    }

    public String getDNI() {
        return DNI;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }


}
