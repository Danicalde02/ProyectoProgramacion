package sistemacontratos;

public class PagoTarjeta extends MetodoPago {
    protected String numeroTarjeta;
    protected String fechaExpiracion;
    protected String cvv;

    public PagoTarjeta(String nombreTitular, double monto, String numeroTarjeta, String fechaExpiracion, String cvv) {
        super(nombreTitular, monto);
        this.numeroTarjeta = numeroTarjeta;
        this.fechaExpiracion = fechaExpiracion;
        this.cvv = cvv;
    }

    @Override
    public boolean procesarPago() {
        // Lógica simulada para procesar el pago con tarjeta
        System.out.println("Procesando pago con tarjeta para " + nombreTitular + " por $" + monto);
        return true; // Supón que siempre es exitoso en este ejemplo
    }
}

