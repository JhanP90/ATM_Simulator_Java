public class CashDispenser {
    private int count = 500; // number of $20 bills

    public boolean isSufficientCashAvailable(double amount) {
        return count * 20 >= amount;
    }

    public void dispenseCash(double amount) {
        int bills = (int)(amount / 20);
        count -= bills;
    }
}