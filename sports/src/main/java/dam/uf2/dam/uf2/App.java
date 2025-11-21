package dam.uf2.dam.uf2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    static String url = "jdbc:postgresql://localhost:5432/postgres";
    static String user = "postgres";
    static String password = "pol-pol-10";

    public static void main(String[] args) {
        mostrarEsports();
        mostrarAtletes();
    }

    public static void mostrarEsports() {
        System.out.println("----| LLISTA ESPORTS |----");

        String query = "SELECT cod, nombre FROM DEPORTES";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println(rs.getString("cod") + " - " + rs.getString("nombre"));
            }

        } catch (SQLException e) {
            System.out.println("Error mostrant esports");
        }
    }

    public static void mostrarAtletes() {
        System.out.println("\n----| LLISTA ATLETES |----");

        String query = "SELECT a.cod, a.nombre, d.nombre AS deporte FROM DEPORTISTAS a JOIN DEPORTES d ON a.cod_deporte = d.cod";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println(rs.getString("nombre") + " (Codi: " + rs.getString("cod") + ") - Esport: " + rs.getString("deporte"));
            }

        } catch (SQLException e) {
            System.out.println("Error mostrant atletes");
        }
    }
}