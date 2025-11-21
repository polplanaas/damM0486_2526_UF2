// View.java
package dam.uf2.view;

import java.util.List;
import java.util.Scanner;

import dam.uf2.model.atleta;
import dam.uf2.model.esport;

public class view {
    private final Scanner sc = new Scanner(System.in);

    public void esportForm(List<esport> esports) {
        System.out.println("----| Llista d'Esports |----");
        for (esport e : esports) {
            System.out.println(e.getCod() + " - " + e.getNombre());
        }
    }

    public void atletaForm(List<atleta> atletes) {
        System.out.println("----| Llista d'Atletes |----");
        for (atleta a : atletes) {
            System.out.println(a.getNombre() + " (Codi: " + a.getCod() + ") - Esport: " + a.getDeporte().getNombre());
        }
    }
}