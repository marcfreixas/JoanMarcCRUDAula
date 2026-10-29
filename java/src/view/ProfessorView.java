package view;

import Controller.Professor;
import Controller.ProfessorController;

import java.util.Scanner;

public class ProfessorView {
    public void DemanarProfessor()
    {
        Scanner lector = new Scanner(System.in);
        ProfessorController ProfeContr = new ProfessorController();
        System.out.println("Introdueixi nom del profe");
        String nom = lector.nextLine();
        System.out.println("Introdueixi cognom del profe");
        String cognoms = lector.nextLine();
        Professor profe = new Professor(nom,cognoms);
        ProfeContr.altaProfessor(profe);


    }
}
