package dam.uf2.dao;

import dam.uf2.model.atleta;
import dam.uf2.model.esport;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class atletaDAO implements dao<atleta> {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "pol-pol-10";

    @Override
    public List<atleta> getAll() {
        List<atleta> llista = new ArrayList<>();
        String query = "SELECT a.cod, a.nombre, d.cod AS cod_deporte, d.nombre AS nombre_deporte " +
                       "FROM DEPORTISTAS a JOIN DEPORTES d ON a.cod_deporte = d.cod";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                esport e = new esport(rs.getInt("cod_deporte"), rs.getString("nombre_deporte"));
                atleta a = new atleta(rs.getInt("cod"), rs.getString("nombre"), e);
                llista.add(a);
            }

        } catch (SQLException e) {
            System.out.println("Error obtenint atletes: " + e.getMessage());
        }

        return llista;
    }
}