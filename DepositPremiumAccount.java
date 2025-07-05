public class DepositPremiumAccount extends Account {
    private static final double INTEREST_RATE = 0.07;
    private static final int REQUIRED_INSTALLMENTS = 5;
    private int installmentsPaid = 0;
    
    public DepositPremiumAccount(String id, String name, double balance) {
        super(id, name, balance);
    }
    
    @Override
    public void deposit(double amount) {
        double interest = amount * INTEREST_RATE;
        balance += amount + interest;
        installmentsPaid++;
    }
    
    @Override
    public boolean withdraw(double amount) {
        if (installmentsPaid < REQUIRED_INSTALLMENTS) {
            System.out.println("Cannot withdraw: All installments not yet deposited.");
            return false;
        }
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        System.out.println("Insufficient balance.");
        return false;
    }
    
    
    @Override
    public boolean transferTo(Account another, double amount) {
        System.out.println("Transfers not allowed from Deposit Premium Account.");
        return false;
    }
}
