package modelo;

public class clase_principal {
    public String  Referencia;
    public String Nombre;
    public float Precios;
    public int Categoria;

    public clase_principal() {
    }

    public clase_principal(String referencia, String nombre, float precios, int categoria) {
        Referencia = referencia;
        Nombre = nombre;
        Precios = precios;
        Categoria = categoria;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String referencia) {
        Referencia = referencia;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public float getPrecios() {
        return Precios;
    }

    public void setPrecios(float precios) {
        Precios = precios;
    }

    public int getCategoria() {
        return Categoria;
    }

    public void setCategoria(int categoria) {
        Categoria = categoria;
    }

    @Override
    public String toString() {
        return "clase_principal{" +
                "Referencia='" + Referencia + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Precios=" + Precios +
                ", Categoria=" + Categoria +
                '}';
    }
}
