class Payment {

    public void deposit(BankAccount account, double amount) {
        if (amount > 0) {
            account.setBalance(account.getBalance() + amount);
        }
    }

    public void withdraw(BankAccount account, double amount) {
        if (amount > 0 && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
        } else {
            System.out.println("Transaction failed: insufficient balance");
        }
    }
}