package DAO;

import Controller.Professor;
import utils.ConnexioBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProfessorDAO {
    public void addDam2(Professor profe)
    {
        ConnexioBDD CBDD = new ConnexioBDD();
        Connection connection = CBDD.getConection();
        String sql = "insert into Professors(nom,cognoms) values (?,?)";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,profe.getNom());
            ps.setString(2,profe.getCognom());
            ps.execute();
        }catch (Exception e)
        {
            System.out.println(e);
        }



    }
}
