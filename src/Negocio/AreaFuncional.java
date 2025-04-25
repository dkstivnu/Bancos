package Negocio;

public class AreaFuncional {

    /// Atributos

    private String nombre;
    private int direccion;

    /// Constructores

    AreaFuncional(String nombre, int direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    AreaFuncional() {
        this.nombre = "";
        this.direccion = -1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }
}
