package view;

import Controller.MPController;
import Controller.ModulProfesional;
import Controller.Professor;
import Controller.ProfessorController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ModulProfesionalView {
    Scanner lector = new Scanner(System.in);
    MPController mpController = new MPController();

    public void AltaMD()
    {
        System.out.println("Introdueixi nom del Modul Profesional");
        String nom = lector.nextLine();
        System.out.println("Introdueixi Id del profe");
        Integer prof_id = Integer.parseInt(lector.next());
        ModulProfesional modulProfesional = new ModulProfesional(nom,prof_id);
        mpController.altaMP(modulProfesional);
    }

    public ArrayList<ModulProfesional> LlegirMD(){
        int opcio = 0;
        int id = 0;
        String valor = "";
        ResultSet resultSet = null;

        do {
            try {
                System.out.println("Per quina opcio vols buscar 1.Id modul 2.Nom modul 3.Profe Id 4.Tots");
                opcio = Integer.parseInt(lector.next());
            } catch (RuntimeException e) {
                System.out.println("Opcio no acceptada");
                opcio = 0;
            }
        } while (opcio != 1 && opcio != 2 && opcio != 3 && opcio != 4);

        if (opcio == 2){
            System.out.println("Quin valor vols buscar");
            valor = lector.next().trim();
        } else if (opcio == 1 || opcio == 3) {
            System.out.println("Quin id vols buscar");
            id = Integer.parseInt(lector.next());
        }

        switch (opcio){
            case 1:
                resultSet = mpController.llistarMPId(id);
                break;
            case 2:
                resultSet = mpController.llistarMPNom(valor);
                break;
            case 3:
                resultSet = mpController.llistarMPProfId(id);
                break;
            case 4:
                resultSet = mpController.llistarMPTot();
                break;
        }

        ArrayList<ModulProfesional> arrayProf = new ArrayList<>();
        try (ResultSet rs = resultSet) {
            while (rs.next()) {
                arrayProf.add(new ModulProfesional(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getInt("id_profe")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("|-- Result --|");
        for (int i = 0; i != arrayProf.size(); i++){
            System.out.println(arrayProf.get(i).getId() + "|" + arrayProf.get(i).getNom() + "|" + arrayProf.get(i).getId_profe());
        }

        return arrayProf;

    }

    public void ActualitzarMD(){
        ModulProfesional MPO = null;
        ModulProfesional MPN;
        String name;
        int prof_id;

        System.out.println("What's currently the id of the Profesional module");
        int val = Integer.parseInt(lector.next());

        ResultSet resultSet = mpController.llistarMPId(val);

        try (ResultSet rs = resultSet) {
            while (rs.next()) {
                MPO = new ModulProfesional(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getInt("id_profe"));}
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Nom del professor");
        name = lector.next();
        System.out.println("Id del professor");
        prof_id = Integer.parseInt(lector.next());

        mpController.actualitzarMP(MPO, new ModulProfesional(name, prof_id));
    }

    public void EliminarMD(){
        ModulProfesional MPdel = null;

        System.out.println("What's currently the id of the Profesional Module");
        int val = Integer.parseInt(lector.next());

        ResultSet resultSet = mpController.llistarMPProfId(val);

        try (ResultSet rs = resultSet) {
            while (rs.next()) {
            MPdel = new ModulProfesional(
                    resultSet.getInt("id"),
                    resultSet.getString("nom"),
                    resultSet.getInt("id_profe"));}
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        mpController.elimMP(MPdel);
    }
}
