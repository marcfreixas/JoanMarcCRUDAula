package view;

import Controller.Professor;
import Controller.ProfessorController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProfessorView {
    Scanner lector = new Scanner(System.in);
    ProfessorController ProfeContr = new ProfessorController();

    public void AltaProfessor()
    {
        System.out.println("Introdueixi nom del profe");
        String nom = lector.nextLine();
        System.out.println("Introdueixi cognom del profe");
        String cognoms = lector.nextLine();
        Professor profe = new Professor(nom,cognoms);
        ProfeContr.altaProfessor(profe);
    }

    public ArrayList<Professor> LlegirProfessor(){
        int opcio = 0;
        int id = 0;
        String valor = "";
        ResultSet resultSet = null;

        do {
            try {
                System.out.println("Per quina opcio vols buscar 1.Id 2.Nom 3.Cognom 4.Tots");
                opcio = Integer.parseInt(lector.next());
            } catch (RuntimeException e) {
                System.out.println("Opcio no acceptada");
                opcio = 0;
            }
        } while (opcio != 1 && opcio != 2 && opcio != 3 && opcio != 4);

        if (opcio == 2 || opcio == 3){
            System.out.println("Quin valor vols buscar");
            valor = lector.next().trim();
        } else if (opcio == 1) {
            System.out.println("Quin id vols buscar");
            id = Integer.parseInt(lector.next());
        }

        switch (opcio){
            case 1:
                resultSet = ProfeContr.llistarProfId(id);
                break;
            case 2:
                resultSet = ProfeContr.llistarProfNom(valor);
                break;
            case 3:
                resultSet = ProfeContr.llistarProfCognom(valor);
                break;
            case 4:
                resultSet = ProfeContr.llistarProfTot();
                break;
        }

        ArrayList<Professor> arrayProf = new ArrayList<>();
        try {

            arrayProf.add(
                    new Professor(
                            resultSet.getInt("id"),
                            resultSet.getString("nom"),
                            resultSet.getString("nom")));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return arrayProf;

    }

    public void ActualitzarProfessor(){
        Professor profO;
        Professor profN;
        String name;
        String surname;

        System.out.println("What's currently the id of the prof");
        int val = Integer.parseInt(lector.next());

        ResultSet resultSet = ProfeContr.llistarProfId(val);

        try {
            profO = new Professor(
                            resultSet.getInt("id"),
                            resultSet.getString("nom"),
                            resultSet.getString("nom"));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Nom del professor");
        name = lector.next();
        System.out.println("Cognom del professor");
        surname = lector.next();

        ProfeContr.actualitzarProf(profO, new Professor(profO.getId(), name,surname));
    }

    public void EliminarProfessor(){
        Professor profDel;

        System.out.println("What's currently the id of the prof");
        int val = Integer.parseInt(lector.next());

        ResultSet resultSet = ProfeContr.llistarProfId(val);

        try {
            profDel = new Professor(
                    resultSet.getInt("id"),
                    resultSet.getString("nom"),
                    resultSet.getString("nom"));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ProfeContr.elimProf(profDel);
    }
}
