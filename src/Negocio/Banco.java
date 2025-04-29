package Negocio;

import java.util.LinkedList;
import java.util.Objects;

public class Banco {

    /// Atributos

    private String nombre;
    private String direccion;
    private LinkedList<Cuenta> listCuentas;
    private LinkedList<AreaFuncional> listAreaFuncional;

    /// Constructores

    public Banco(String nombre, String direccion, LinkedList<Cuenta> listCuentas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.listCuentas = listCuentas;
        this.listAreaFuncional = new LinkedList<>();
    }

    public Banco() {
        this.nombre = "";
        this.direccion = "";
        this.listCuentas = new LinkedList<>();
        this.listAreaFuncional = new LinkedList<>();
    }

    /// Metodos propios

    public boolean addCuenta(Cuenta cuenta) {

        if (searchCuenta(cuenta.getNumero()) == -1) {
            listCuentas.add(cuenta);
            return true;
        }
        return false;
    }

    public int searchCuenta(long numeroCuenta) {
        for (int i = 0; i < listCuentas.size(); i++) {
            Cuenta cuenta = listCuentas.get(i);
            if (cuenta.getNumero() == numeroCuenta)
                //Devuelve el índice que tiene relacion con la cuenta
                return i;
        }
        return -1;
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

    public LinkedList<AreaFuncional> getListAreaFuncional() {
        return listAreaFuncional;
    }

    public void setListAreaFuncional(LinkedList<AreaFuncional> listAreaFuncional) {
        this.listAreaFuncional = listAreaFuncional;
    }

    /// Relacion de composicion

    public boolean addAreaFuncional(int codigo, String nombre) {
        //La clase Banco solo crea el objeto área funcional;
        final AreaFuncional areaFuncional = new AreaFuncional(nombre, codigo);

        if (!listAreaFuncional.contains(areaFuncional)) {
            listAreaFuncional.add(areaFuncional);
            return true;
        }
        return false;
    }

    public int searchAreaFuncional(int codigo) {
        for (int i = 0; i < listAreaFuncional.size(); i++) {
            AreaFuncional area = listAreaFuncional.get(i);
            if (area.getCodigo() == codigo)
                //Devuelve el índice que tiene relacion con el área funcional
                return i;
        }
        return -1;

    }

    public int searchAreaFuncional(String nombreAreaFuncional) {
        for (int i = 0; i < listAreaFuncional.size();i++) {
            AreaFuncional area = listAreaFuncional.get(i);
            if (Objects.equals(area.getNombre(), nombreAreaFuncional))
                return i;
        }
        return -1;
    }

    public boolean deleteAreaFuncional(int codigo) {
        int indiceArea = searchAreaFuncional(codigo);
        if (indiceArea != -1) {
            listAreaFuncional.remove(indiceArea);
            return true;
        }
        return false;
    }
}
