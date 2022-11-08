import java.lang.Exception;

public class PaymentException extends Exception {
    public PaymentException(String errorMessage) {
        super(errorMessage);
    }
}