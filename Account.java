public abstract class Account {
    protected String id;
    protected String name;
    protected double balance;
    
    public Account(String id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    
    public String getID() { return id; }
    public String getName() { return name; }
    public double getBalance() { return balance; }
    
    // Deposit with interest if applicable
    public abstract void deposit(double amount);
    
    // Withdraw with rules
    public abstract boolean withdraw(double amount);
    
    // Transfer with rules
    public boolean transferTo(Account another, double amount) {
        if (this.withdraw(amount)) {
            another.deposit(amount);
            return true;
        }
        return false;
    }
    
    public String toString() {
        return getClass().getSimpleName() + "[id=" + id + ", name=" + name + ", balance=" + balance + "]";
    }
}
