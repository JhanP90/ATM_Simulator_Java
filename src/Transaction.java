public abstract class Transaction {
    protected int accountNumber;
    protected Screen screen;
    protected BankDatabase bankDatabase;

    public Transaction(int accNum, Screen screen, BankDatabase bankDB) {
        this.accountNumber = accNum;
        this.screen = screen;
        this.bankDatabase = bankDB;
    }

    public abstract void execute();
}
