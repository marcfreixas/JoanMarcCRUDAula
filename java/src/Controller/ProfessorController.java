package Controller;

import DAO.ProfessorDAO;

public class ProfessorController {

    public void altaProfessor(Professor profe)
    {
        ProfessorDAO pDAO = new ProfessorDAO();

        pDAO.addDam2(profe);

    }
}
