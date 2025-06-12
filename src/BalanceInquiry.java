public class BalanceInquiry extends Transaction {
    public BalanceInquiry(int accNum, Screen screen, BankDatabase bankDB) {
        super(accNum, screen, bankDB);
    }

    @Override
    public void execute() {
        double balance = bankDatabase.getAvailableBalance(accountNumber);
        screen.displayMessage("Available Balance: $" + balance + "\n");
    }
}