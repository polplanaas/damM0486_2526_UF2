// Atleta.java
package dam.uf2.model;

public class atleta {
    private int cod;
    private String nombre;
    private esport deporte;

    public atleta(int cod, String nombre, esport deporte) {
        this.cod = cod;
        this.nombre = nombre;
        this.deporte = deporte;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public esport getDeporte() {
        return deporte;
    }

    public void setDeporte(esport deporte) {
        this.deporte = deporte;
    }
}