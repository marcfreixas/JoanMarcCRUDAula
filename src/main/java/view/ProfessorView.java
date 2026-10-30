package view;

import Controller.Professor;
import Controller.ProfessorController;

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

    public Professor[] LlegirProfessor(){
        int menu = 0;
        int id = 0;
        String valor = "";
        do
        {
            try {
                System.out.println("Per quina variable vols buscar 1.Id 2.Nom 3.Cognom 4.Llistar tots");
                menu = Integer.parseInt(lector.next());
            } catch (NumberFormatException e) {
                System.err.println("Opcio no acceptada");
                menu = 0;
            }
        } while (menu != 1 && menu != 2 && menu != 3 && menu != 4);

        if (menu == 2 || menu == 3){
            System.out.println("Entra el valor que vols buscar");
            valor = lector.next().trim();
        } else if (menu == 1) {
            System.out.println("Entra l'id que vols buscar");
            id = Integer.parseInt(lector.next());
        }

        switch (menu){
            case 1:
                return ProfeContr.llistarProfId(id);
            case 2:
                return ProfeContr.llistarProfNom(valor);
            case 3:
                return ProfeContr.llistarProfCog(valor);
            case 4:
                return ProfeContr.llistarProfTot();
        }

        return new Professor[0];
    }

    public void ActualitzarProfessor(){
            ProfeContr.actualitzarProf(OrigProf, NewProf);
    }

    public void EliminarProfessor(){

    }
}
