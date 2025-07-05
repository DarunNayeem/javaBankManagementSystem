import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        
        
        accounts.add(new Account("A001", "Nayeem"));
        accounts.add(new Account("A002", "Tamim", 500));
        accounts.add(new Account("A003", "Pranto", 1000));
        
        while (true) {
            System.out.println("\nChoose operation: \n1) Create Account \n2) Credit \n3) Debit \n4) Transfer  \n0) Exit\n");
            int choice = sc.nextInt();
            sc.nextLine();
            
            if (choice == 1) {
                System.out.print("Enter ID: ");
                String id = sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Balance: ");
                int balance = sc.nextInt();
                accounts.add(new Account(id, name, balance));
                System.out.println("Account created.");
            } else if (choice == 2) {
                System.out.print("Enter Account ID: ");
                String id = sc.nextLine();
                System.out.print("Enter Amount to Credit: ");
                int amount = sc.nextInt();
                Account acc = findAccount(accounts, id);
                if (acc != null) {
                    acc.credit(amount);
                    System.out.println("Credited. " + acc);
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 3) {
                System.out.print("Enter Account ID: ");
                String id = sc.nextLine();
                System.out.print("Enter Amount to Debit: ");
                int amount = sc.nextInt();
                Account acc = findAccount(accounts, id);
                if (acc != null) {
                    acc.debit(amount);
                    System.out.println("Debited. " + acc);
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 4) {
                System.out.print("Enter Source Account ID: ");
                String srcId = sc.nextLine();
                System.out.print("Enter Destination Account ID: ");
                String destId = sc.nextLine();
                System.out.print("Enter Amount to Transfer: ");
                int amount = sc.nextInt();
                Account src = findAccount(accounts, srcId);
                Account dest = findAccount(accounts, destId);
                if (src != null && dest != null) {
                    src.transferTo(dest, amount);
                    System.out.println("Transfer complete.");
                    System.out.println("Source: " + src);
                    System.out.println("Destination: " + dest);
                } else {
                    System.out.println("Account(s) not found.");
                }
            }  else if (choice == 0) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
    
    private static Account findAccount(ArrayList<Account> accounts, String id) {
        for (Account acc : accounts) {
            if (acc.getID().equals(id)) {
                return acc;
            }
        }
        return null;
    }
}
