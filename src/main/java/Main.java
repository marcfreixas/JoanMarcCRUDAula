import utils.ConnexioBDD;
import view.ProfessorView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    ProfessorView professorView = new ProfessorView();

    public void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcio = 0;
        int opcio_submenu = 0;

        do {

            do {
                try {
                    System.out.println("1. Gestionar professors\n" +
                            "2. Gestionar mòduls professionals\n" +
                            "3. Sortir");
                    opcio = Integer.parseInt(input.next());
                } catch (Exception e) {
                    System.err.println("Valor no acceptat");
                }
            } while (opcio != 1 && opcio != 2 && opcio != 3);

            if (opcio != 3) {

                do {
                    try {
                        System.out.println("1. Alta\n" +
                                "2. Llistar\n" +
                                "3. Actualitzar\n" +
                                "4. Eliminar\n" +
                                "5. Tornar al menú");
                        opcio_submenu = Integer.parseInt(input.next());
                    } catch (Exception e) {
                        System.err.println("Valor no acceptat");
                    }
                } while (opcio_submenu != 1 && opcio_submenu != 2 && opcio_submenu != 3 && opcio_submenu != 4 && opcio_submenu != 5);

                switch (opcio_submenu) {
                    case 1:
                        donarAlta();
                        break;
                    case 2:
                        System.out.println("Llistar");
                        Llistar();
                        break;
                    case 3:
                        Actualitzar();
                        break;
                    case 4:
                        Eliminar();
                        break;
                    case 5:
                        System.out.println("Sortint del programa");
                        break;
                }
            }
        } while (opcio != 3);
    }

    private void donarAlta(){
        professorView.AltaProfessor();
    };
    private void Llistar(){
        professorView.LlegirProfessor();
    };
    private void Actualitzar(){
        professorView.ActualitzarProfessor();
    };
    private void Eliminar(){
        professorView.EliminarProfessor();
    };
}
