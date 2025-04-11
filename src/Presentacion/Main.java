package Presentacion;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            imprimirMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }

        } while (opcion != 0);
    }

    public static void imprimirMenu() {
        System.out.println("------ MENU ------");
        System.out.println("1 - Adicionar Cuenta");
        System.out.println("2 - Buscar cuenta por numero de cuenta");
        System.out.println("3 - Eliminar cuenta por numero de cuenta");
        System.out.println("4 - Consignar");
        System.out.println("5 - Retirar");
        System.out.println("6 - Mostrar la lista de cuentas");
        System.out.println("0 - Salir");

    }
}
