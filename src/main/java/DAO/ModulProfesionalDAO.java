package DAO;

import Controller.ModulProfesional;
import utils.ConnexioBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ModulProfesionalDAO {
    public void addModul(ModulProfesional modul)
    {
        ConnexioBDD CBDD = new ConnexioBDD();
        Connection connection = CBDD.getConection();
        String sql = "insert into ModulsProfessionals(nom,id_profe) values (?,?)";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, modul.getNom());
            ps.setInt(2, modul.getId_profe());
            ps.execute();
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void deleteModul(ModulProfesional modul)
    {
        ConnexioBDD CBDD = new ConnexioBDD();
        Connection connection = CBDD.getConection();
        String sql = "delete from ModulsProfessionals where nom = ? and id_profe = ?";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, modul.getNom());
            ps.setInt(2, modul.getId_profe());
            ps.execute();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void updateModul(ModulProfesional modulActual, ModulProfesional modulActualitzat)
    {
        ConnexioBDD CBDD = new ConnexioBDD();
        Connection connection = CBDD.getConection();
        String sql = "update ModulsProfessionals set nom = ?, id_profe = ? WHERE id = ?";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, modulActualitzat.getNom());
            ps.setInt(2, modulActualitzat.getId_profe());
            ps.setInt(3, modulActual.getId());
            ps.execute();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public ResultSet readModuls()
    {
        ConnexioBDD CBDD = new ConnexioBDD();
        Connection connection = CBDD.getConection();

        try{
            Statement statement = connection.createStatement();
            return statement.executeQuery("select * from ModulsProfessionals");
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

    public ResultSet readModulByNom(String nom)
    {
        ConnexioBDD CBDD = new ConnexioBDD();
        Connection connection = CBDD.getConection();

        try{
            String sql = "select * from ModulsProfessionals where nom = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nom);
            return ps.executeQuery();
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

    public ResultSet readModulsByIdProfe(int idProfe)
    {
        ConnexioBDD CBDD = new ConnexioBDD();
        Connection connection = CBDD.getConection();

        try{
            String sql = "select * from ModulsProfessionals where id_profe = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idProfe);
            return ps.executeQuery();
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

    public ResultSet readModulByNomAndIdProfe(String nom, int idProfe)
    {
        ConnexioBDD CBDD = new ConnexioBDD();
        Connection connection = CBDD.getConection();

        try{
            String sql = "select * from ModulsProfessionals where nom = ? and id_profe = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nom);
            ps.setInt(2, idProfe);
            return ps.executeQuery();
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

    public ResultSet readModulByID(int id)
    {
        ConnexioBDD CBDD = new ConnexioBDD();
        Connection connection = CBDD.getConection();

        try{
            String sql = "select * from ModulsProfessionals where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeQuery();
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
}