import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        
        // Sample accounts
        accounts.add(new CurrentAccount("C001", "Nayeem", 2000));
        accounts.add(new SavingsAccount("S001", "Tamim", 1500));
        accounts.add(new DepositPremiumAccount("D001", "Pranto", 0));
        
        while (true) {
            System.out.println("\n1) Deposit \n2) Withdraw \n3) Transfer  \n0) Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            
            if (choice == 1) {
                System.out.print("Enter Account ID: ");
                String id = sc.nextLine();
                Account acc = findAccount(accounts, id);
                if (acc != null) {
                    System.out.print("Enter amount to deposit: ");
                    double amt = sc.nextDouble();
                    acc.deposit(amt);
                    System.out.println("Deposited. " + acc);
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 2) {
                System.out.print("Enter Account ID: ");
                String id = sc.nextLine();
                Account acc = findAccount(accounts, id);
                if (acc != null) {
                    System.out.print("Enter amount to withdraw: ");
                    double amt = sc.nextDouble();
                    boolean ok = acc.withdraw(amt);
                    if (ok) System.out.println("Withdrawn. " + acc);
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 3) {
                System.out.print("Enter Source Account ID: ");
                String srcId = sc.nextLine();
                System.out.print("Enter Destination Account ID: ");
                String destId = sc.nextLine();
                Account src = findAccount(accounts, srcId);
                Account dest = findAccount(accounts, destId);
                if (src != null && dest != null) {
                    System.out.print("Enter amount to transfer: ");
                    double amt = sc.nextDouble();
                    boolean ok = src.transferTo(dest, amt);
                    if (ok) {
                        System.out.println("Transfer complete.");
                        System.out.println("Source: " + src);
                        System.out.println("Destination: " + dest);
                    }
                } else {
                    System.out.println("Account(s) not found.");
                }
            } else if (choice == 4) {
                for (Account acc : accounts) {
                    System.out.println(acc);
                }
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
    
    private static Account findAccount(ArrayList<Account> accounts, String id) {
        for (Account acc : accounts) {
            if (acc.getID().equals(id)) return acc;
        }
        return null;
    }
}
