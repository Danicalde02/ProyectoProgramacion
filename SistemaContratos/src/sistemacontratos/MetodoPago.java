package sistemacontratos;

public abstract class MetodoPago {
    protected String nombreTitular;
    protected double monto;

    public MetodoPago(String nombreTitular, double monto) {
        this.nombreTitular = nombreTitular;
        this.monto = monto;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    // Método abstracto que debe implementarse en las clases derivadas
    public abstract boolean procesarPago();

    // Puedes agregar métodos comunes adicionales si es necesario
}
