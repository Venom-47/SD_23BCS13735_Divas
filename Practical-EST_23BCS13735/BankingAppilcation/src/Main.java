public class Main {
    public static void main(String[] args) {

        BankAccount account = new BankAccount("Divas", 10000);

        Payment payment = new Payment();
        InterestRate interestRate = new InterestRate();

        payment.deposit(account, 5000);

        payment.withdraw(account, 2000);

        double interest = interestRate.calculateInterest(account);

        System.out.println("Final Balance: " + account.getBalance());
        System.out.println("Interest: " + interest);
    }
}