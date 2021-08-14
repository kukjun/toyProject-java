package project_1;

public class InsufficientBalanceException extends Exception {
    InsufficientBalanceException() {}
    InsufficientBalanceException(String message) {
        super(message);
    }
}
