public class Account {
    private int accountNumber;
    private int pin;
    private double availableBalance;

    public Account(int accountNumber, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.availableBalance = balance;
    }

    public boolean validatePIN(int inputPIN) {
        return pin == inputPIN;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void credit(double amount) {
        availableBalance += amount;
    }

    public void debit(double amount) {
        availableBalance -= amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}