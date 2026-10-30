package DAO;

import Controller.Professor;
import utils.ConnexioBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
    public void deleteDam2(Professor profe)
    {
        ConnexioBDD CBDD = new ConnexioBDD();
        Connection connection = CBDD.getConection();
        String sql = "delete from Professors where nom = ? and cognoms = ?";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, profe.getNom());
            ps.setString(2, profe.getCognom());
            ps.execute();

        }catch(Exception e)
        {
            System.out.println(e);
        }

    }
    public void updateDam2(Professor profeActual,Professor profeActualitzat)
    {
        ConnexioBDD CBDD = new ConnexioBDD();
        Connection connection = CBDD.getConection();
        String sql = "update Professors set nom = ?, cognoms = ? WHERE id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,profeActualitzat.getNom());
            ps.setString(2,profeActualitzat.getCognom());
            ps.setInt(3,profeActual.getId());
            ps.execute();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public ResultSet readDam2()
    {
        ConnexioBDD CBDD = new ConnexioBDD();
        Connection connection = CBDD.getConection();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Professors");
            return resultSet;
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
    public ResultSet readDam2ByName(String nom)
    {
        ConnexioBDD CBDD = new ConnexioBDD();
        Connection connection = CBDD.getConection();
        try{

            String sql = "Select * From Professors Where name = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,nom);
            ResultSet resultSet = ps.executeQuery();
            return resultSet;

        }catch (Exception e)
        {
            System.out.println(e);
        }
    return null;
    }
    public ResultSet readDam2BySurname(String cognoms)
    {
        ConnexioBDD CBDD = new ConnexioBDD();
        Connection connection = CBDD.getConection();
        try{
            String sql = "Select * from Professors Where cognoms = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,cognoms);
            ResultSet resultSet = ps.executeQuery();
            return resultSet;
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
    public ResultSet readDam2ByNameAndSurname(String nom,String cognoms)
    {
        ConnexioBDD CBDD = new ConnexioBDD();
        Connection connection = CBDD.getConection();

        try{
            String sql = "Select * from Professors where nom = ? And cognoms = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,nom);
            ps.setString(2,cognoms);
            ResultSet resultSet = ps.executeQuery();
            return resultSet;
        }catch (Exception e)
        {

            System.out.println(e);
        }
        return null;
    }
    public ResultSet readDam2ByID(int id)
    {
        ConnexioBDD CBDD = new ConnexioBDD();
        Connection connection = CBDD.getConection();

        try{
            String sql = "Select * from Professors where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();
            return resultSet;

        }catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

}
