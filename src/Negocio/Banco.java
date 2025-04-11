package Negocio;

import java.util.LinkedList;

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
