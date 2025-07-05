public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.025;
    private static final double MIN_BALANCE = 1000.0;
    
    public SavingsAccount(String id, String name, double balance) {
        super(id, name, balance);
    }
    
    @Override
    public void deposit(double amount) {
        double interest = amount * INTEREST_RATE;
        balance += amount + interest;
    }
    
    @Override
    public boolean withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            return true;
        }
        System.out.println("Cannot withdraw: Minimum balance of " + MIN_BALANCE + " required.");
        return false;
    }
}
