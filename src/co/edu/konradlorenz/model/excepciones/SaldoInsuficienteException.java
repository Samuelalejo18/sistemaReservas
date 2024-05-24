package co.edu.konradlorenz.model.excepciones;

public class SaldoInsuficienteException extends Throwable {
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}
