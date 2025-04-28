package Negocio;

public class AreaFuncional {

    /// Atributos

    private String nombre;
    private int codigo;

    /// Constructores

    AreaFuncional(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    AreaFuncional() {
        this.nombre = "";
        this.codigo = -1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "\n------- Area Funcional "+ codigo +"------"+
                "\nNombre: " + nombre + "\nCodigo: " + codigo + "\n";

    }
}
