package Negocio;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Banco {

    /// Atributos

    private String nombre;
    private String direccion;
    private LinkedList<Cuenta> listCuentas;

    /// Constructores

    public Banco(String nombre, String direccion, LinkedList<Cuenta> listCuentas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.listCuentas = new LinkedList<Cuenta>();
    }

    public Banco() {
        this.nombre = "";
        this.direccion = "";
        this.listCuentas = new LinkedList<Cuenta>();
    }

    /// Metodos propios

    public boolean addCuenta(Cuenta cuenta) {
        // Se necesita un objeto AtomicBoolean debido a que se quiere usar dentro de
        // una fun lambda, asi que no se puede usar el tipo primitivo.
        AtomicBoolean cuentaExists = new AtomicBoolean(false);

        listCuentas.forEach(cuentaL -> {
                    if (cuentaL.getNumero() == cuenta.getNumero())
                        cuentaExists.set(true);
                }
        );

        if (!cuentaExists.get())
            this.listCuentas.add(cuenta);

        return !cuentaExists.get();
    }

    public Cuenta searchCuenta(long numeroCuenta) {
        for (Cuenta cuenta : listCuentas) {
            if (cuenta.getNumero() == numeroCuenta)
                return cuenta;
        }
        return new Cuenta();
    }

    public void deleteCuenta(long numeroCuenta) {
        listCuentas.removeIf(cuenta -> cuenta.getNumero() == numeroCuenta);
    }



    /// Metodos getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LinkedList<Cuenta> getListCuentas() {
        return listCuentas;
    }

    public void setListCuentas(LinkedList<Cuenta> listCuentas) {
        this.listCuentas = listCuentas;
    }
}
