package sistemacontratos;

public class PagoEfectivo extends MetodoPago {

    public PagoEfectivo(String nombreTitular, double monto) {
        super(nombreTitular, monto);
    }

    @Override
    public boolean procesarPago() {
        // Lógica simulada para procesar un pago en efectivo
        System.out.println("Pago en efectivo recibido de " + nombreTitular + " por $" + monto);
        return true; // Suponemos que el pago en efectivo siempre es exitoso
    }
}


