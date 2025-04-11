package Negocio;

import java.util.LinkedList;

public class Banco {
    /// Atributos
    private String nombre;
    private String direccion;
    private LinkedList<Cuenta> listCuentas;

    public Banco(String nombre, String direccion, LinkedList<Cuenta> listCuentas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.listCuentas = new LinkedList<Cuenta>();
    }


}
