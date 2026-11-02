import utils.ConnexioBDD;
import view.ModulProfesionalView;
import view.ProfessorView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    ProfessorView professorView = new ProfessorView();
    ModulProfesionalView mdView = new ModulProfesionalView();

    public static void main(String[] args)
    {
        Main main = new Main();
        main.Program();
    }

    public void Program() {
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

                switch(opcio){
                    case 1: //Professors
                        do {
                            try {
                                System.out.println("1. Alta\n" +
                                        "2. Llistar\n" +
                                        "3. Actualitzar\n" +
                                        "4. Eliminar\n" +
                                        "5. Sortir");
                                opcio_submenu = Integer.parseInt(input.next());
                            } catch (Exception e) {
                                System.err.println("Valor no acceptat");
                            }
                        } while (opcio_submenu != 1 && opcio_submenu != 2 && opcio_submenu != 3 && opcio_submenu != 4 && opcio_submenu != 5);

                        switch(opcio_submenu)
                        {
                            case 1:
                                donarAltaProfe();
                                break;

                            case 2:
                                LlistarProfe();
                                break;

                            case 3:
                                ActualitzarProfe();
                                break;
                            case 4:
                                EliminarProfe();
                                break;

                            case 5:
                                System.out.println("Sortint");
                                break;
                        }

                        break;

                    case 2: //Moduls
                        do {
                            try {
                                System.out.println("1. Alta\n" +
                                        "2. Llistar\n" +
                                        "3. Actualitzar\n" +
                                        "4. Eliminar\n" +
                                        "5. Sortir");
                                opcio_submenu = Integer.parseInt(input.next());
                            } catch (Exception e) {
                                System.err.println("Valor no acceptat");
                            }
                        } while (opcio_submenu != 1 && opcio_submenu != 2 && opcio_submenu != 3 && opcio_submenu != 4 && opcio_submenu != 5);

                        switch (opcio_submenu)
                        {
                            case 1:
                                donarAltaModul();
                                break;
                            case 2:
                                LlistarModul();
                                break;
                            case 3:
                                ActualitzarModul();
                                break;
                            case 4:
                                EliminarModul();
                                break;
                            case 5:
                                System.out.println("Sortint");
                                break;
                        }
                        break;
                }

            }
        } while (opcio != 3);
    }

    private void donarAltaProfe(){
        professorView.AltaProfessor();
    };
    private void LlistarProfe(){
        professorView.LlegirProfessor();
    };
    private void ActualitzarProfe(){
        professorView.ActualitzarProfessor();
    };
    private void EliminarProfe(){
        professorView.EliminarProfessor();
    };
    private void donarAltaModul(){
        mdView.AltaMD();
    }
    private void LlistarModul()
    {
        mdView.LlegirMD();
    }
    private void ActualitzarModul()
    {
        mdView.ActualitzarMD();
    }
    private void EliminarModul()
    {
        mdView.EliminarMD();
    }
}
