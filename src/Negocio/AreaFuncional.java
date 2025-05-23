package Negocio;

public class AreaFuncional {

    /// Atributos

    private String nombre;
    private int codigo;

    /// Constructores

    public AreaFuncional(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public AreaFuncional() {
        this.nombre = "";
        this.codigo = 0;
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
