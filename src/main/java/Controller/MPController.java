package Controller;

import DAO.ModulProfesionalDAO;
import DAO.ProfessorDAO;

import java.sql.ResultSet;

public class MPController {

    ModulProfesionalDAO MP = new ModulProfesionalDAO();

    public void altaMP(ModulProfesional modul)
    {
        MP.addModul(modul);
    }

    public ResultSet llistarMPTot(){
        return MP.readModuls();
    }

    public ResultSet llistarMPId(Integer id){
        return MP.readModulByID(id);
    }
    public ResultSet llistarMPNom(String nom){
        return MP.readModulByNom(nom);
    }
    public ResultSet llistarMPProfId(Integer prof_id){
        return MP.readModulsByIdProfe(prof_id);
    }

    public void actualitzarMP(ModulProfesional MPO, ModulProfesional MPN){
        MP.updateModul(MPO, MPN);
    }
    public void elimMP(ModulProfesional modul){
        MP.deleteModul(modul);
    }
}
