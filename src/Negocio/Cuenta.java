package Negocio;

public class Cuenta {

    /// Atributos

    private long numero;
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

    /// Metodos setter y getter

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
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

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
