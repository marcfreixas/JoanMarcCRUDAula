package Controller;

import DAO.ProfessorDAO;

public class ProfessorController {

    ProfessorDAO pDAO = new ProfessorDAO();

    public void altaProfessor(Professor profe)
    {
        pDAO.addDam2(profe);
    }

    public Professor[] llistarProfTot(){}
    public Professor[] llistarProfId(Integer id){}
    public Professor[] llistarProfNom(String nom){}
    public Professor[] llistarProfCog(String cognom){}
    public void actualitzarProf(Professor profO, Professor profN){}
    public void elimProf(Professor prof){}
}
