package e1;

public class SavingsAccount extends BankAccount {
    private double commission;
    private double minimumDeposit;
    private double minimumCommission;

    public SavingsAccount(String IBAN) {
        super(IBAN);
        this.commission = 0.04;
        this.minimumDeposit = 1000;
        this.minimumCommission = 3;
    }

    public double getCommission() {
        return commission;
    }
    public double getMinimumDeposit() {
        return minimumDeposit;
    }
    public double getMinimumCommission() {
        return minimumCommission;
    }

    public void setCommission(double commission) {
        if (commission >= 0) {
            this.commission = commission;
        }
    }

    public void setMinimumDeposit(double minimumDeposit) {
        if (minimumDeposit >= 0) {
            this.minimumDeposit = minimumDeposit;
        }
    }
    public void setMinimumCommission(double minimumCommission) {
        if (minimumCommission >= 0) {
            this.minimumCommission = minimumCommission;
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount > this.minimumDeposit) {
            super.deposit(amount);
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            double retirementCharge = amount * this.commission;
            if (retirementCharge < this.minimumCommission) {
                retirementCharge = this.minimumCommission;
            }
            balance -= (amount + retirementCharge);
            return true;
        }
        return false;
    }
}
