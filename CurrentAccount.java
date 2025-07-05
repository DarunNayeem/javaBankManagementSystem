public class CurrentAccount extends Account {
    public CurrentAccount(String id, String name, double balance) {
        super(id, name, balance);
    }
    
    @Override
    public void deposit(double amount) {
        balance += amount;
    }
    
    @Override
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        System.out.println("Insufficient balance.");
        return false;
    }
}
