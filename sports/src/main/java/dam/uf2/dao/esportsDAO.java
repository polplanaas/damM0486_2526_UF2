package dam.uf2.dao;

import dam.uf2.model.esport;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class esportsDAO implements dao<esport> {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "pol-pol-10";

    @Override
    public List<esport> getAll() {
        List<esport> llista = new ArrayList<>();
        String query = "SELECT cod, nombre FROM DEPORTES";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                llista.add(new esport(rs.getInt("cod"), rs.getString("nombre")));
            }

        } catch (SQLException e) {
            System.out.println("Error obtenint esports: " + e.getMessage());
        }
        return llista;
    }
}
