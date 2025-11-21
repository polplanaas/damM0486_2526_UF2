package dam.uf2;

import dam.uf2.dao.atletaDAO;
import dam.uf2.dao.esportsDAO;
import dam.uf2.model.atleta;
import dam.uf2.model.esport;
import dam.uf2.view.view;

import java.util.List;

public class controller {
    public static void main(String[] args) {
        esportsDAO esportDAO = new esportsDAO();
        atletaDAO atletaDAO = new atletaDAO();
        view view = new view();

        // Mostra esports
        List<esport> esports = esportDAO.getAll();
        view.esportForm(esports);

        // Mostra atletes
        List<atleta> atletes = atletaDAO.getAll();
        view.atletaForm(atletes);
    }
}
