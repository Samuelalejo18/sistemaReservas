package co.edu.konradlorenz.model.excepciones;

public class SaldoInsuficienteExcepcion extends Throwable {
    public SaldoInsuficienteExcepcion(String message) {
        super(message);
    }
}
