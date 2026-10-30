package Controller;

import DAO.ProfessorDAO;

import java.sql.ResultSet;

public class ProfessorController {

    ProfessorDAO pDAO = new ProfessorDAO();

    public void altaProfessor(Professor profe)
    {
        pDAO.addDam2(profe);
    }

    public ResultSet llistarProfTot(){
        return pDAO.readDam2();
    }

    public ResultSet llistarProfId(Integer id){
        return pDAO.readDam2ByID(id);
    }
    public ResultSet llistarProfNom(String nom){
        return pDAO.readDam2ByName(nom);
    }
    public ResultSet llistarProfCognom(String surname){
        return pDAO.readDam2BySurname(surname);
    }

    public void actualitzarProf(Professor profO, Professor profN){
        pDAO.updateDam2(profO, profN);
    }
    public void elimProf(Professor prof){
        pDAO.deleteDam2(prof);
    }
}
