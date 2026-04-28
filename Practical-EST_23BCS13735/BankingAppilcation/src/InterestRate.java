class InterestRate {

    public double calculateInterest(BankAccount account) {
        double rate = 0.05;
        return account.getBalance() * rate;
    }
}