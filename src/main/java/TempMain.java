import view.ProfessorView;

import java.util.Scanner;

public class TempMain {

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
                        donarAlta(opcio, input);
                        break;
                    case 2:
                        Llistar(opcio, input);
                        break;
                    case 3:
                        Actualitzar(opcio, input);
                        break;
                    case 4:
                        Eliminar(opcio, input);
                        break;
                    case 5:
                        System.out.println("Sortint del programa");
                        break;
                }
            }
        } while (opcio != 3);
    }

    private void donarAlta(int table, Scanner input){};
    private void Llistar(int table, Scanner input){
        ProfessorView ProfeView = new ProfessorView();
        ProfeView.DemanarProfessor();
    };
    private void Actualitzar(int table, Scanner input){};
    private void Eliminar(int table, Scanner input){};
}
