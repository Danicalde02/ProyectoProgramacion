package sistemacontratos;

public class PagoTransferencia extends MetodoPago {
    protected String numeroCuentaOrigen;
    protected String bancoOrigen;
    protected String referencia;

    public PagoTransferencia(String nombreTitular, double monto, String numeroCuentaOrigen, String bancoOrigen, String referencia) {
        super(nombreTitular, monto);
        this.numeroCuentaOrigen = numeroCuentaOrigen;
        this.bancoOrigen = bancoOrigen;
        this.referencia = referencia;
    }

    @Override
    public boolean procesarPago() {
        // Lógica simulada para procesar transferencia
        System.out.println("Procesando transferencia desde " + bancoOrigen +
                           " (cuenta: " + numeroCuentaOrigen + ") por $" + monto +
                           " a nombre de " + nombreTitular + ". Referencia: " + referencia);
        return true; // Simulación: siempre es exitosa
    }

    // Getters y setters si los necesitas
    public String getNumeroCuentaOrigen() {
        return numeroCuentaOrigen;
    }

    public String getBancoOrigen() {
        return bancoOrigen;
    }

    public String getReferencia() {
        return referencia;
    }
}

