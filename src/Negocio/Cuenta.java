package Negocio;

public class Cuenta {

    /// Atributos

    private final long numero;
    private String tipoCuenta;
    private double saldo;

    ///  Constructores

    public Cuenta(long numero, String tipoCuenta, double saldo) {
        this.numero = numero;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
    }

    public Cuenta() {
        this.numero = -1;
        this.tipoCuenta = "";
        this.saldo = 0;
    }

    /// Metodos propios

    public void consignar(double monto) {

        this.saldo += monto;
    }

    public boolean retirar(double monto) {

        if (this.saldo >= monto) {
            this.saldo -= monto;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "\n------ Cuenta " + numero + " ------"+
                "\nNumero de cuenta: " + numero +
                "\nTipo de cuenta: " + tipoCuenta +
                "\nSaldo de la cuenta: " + saldo;
    }

    /// Metodos setter y getter

    public long getNumero() {
        return numero;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }
}
