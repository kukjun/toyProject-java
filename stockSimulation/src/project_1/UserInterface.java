package project_1;

public interface UserInterface {
    //constant

    // abstract method
    public abstract boolean buy(Stock stock, int count) throws InsufficientBalanceException;
    public abstract boolean sell(Stock stock, int count) throws CountException;
    public abstract boolean show();

    //default method
    //static method

}
