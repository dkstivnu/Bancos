package Presentacion;

import Negocio.Banco;
import Negocio.Cuenta;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco("Compañia de Financiamiento NU",
                "Crr 12 #3A-4",
                new LinkedList<>());

        int opcion;

        do {
            imprimirMenu();

            System.out.println("Ingrese la opcion que desea elegir: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: {
                    System.out.println("****** Creacion de cuenta *****");
                    System.out.println("Ingrese el numero de cuenta: ");
                    long numeroCuenta = getNumeroCuenta(sc);

                    System.out.println("Ingrese el tipo de cuenta: ");
                    String tipoCuenta = sc.next();

                    System.out.println("Ingrese el saldo de la cuenta: ");
                    double saldo = getSaldo(sc);

                    Cuenta c = new Cuenta(numeroCuenta, tipoCuenta, saldo);

                    if (banco.addCuenta(c)) {
                        System.out.println("Cuenta agregada correctamente");
                    } else {
                        System.out.println("** ERROR ** La cuenta N° " + numeroCuenta + " ya existe");
                    }
                }
                break;
                case 2: {
                    System.out.println("****** Buscar cuenta *****");
                    System.out.println("Ingrese el numero de la cuenta que desea buscar: ");
                    long numeroCuenta = getNumeroCuenta(sc);

                    int indice = banco.searchCuenta(numeroCuenta);

                    if (indice == -1) System.out.println("** ERROR ** La cuenta que no existe");

                    else System.out.println(banco.getListCuentas().get(indice));
                }
                break;
                case 3: {
                    System.out.println("****** Eliminar cuenta *****");
                    System.out.println("Ingrese el numero de la cuenta que desea eliminar: ");
                    long numeroCuenta = getNumeroCuenta(sc);

                    banco.deleteCuenta(numeroCuenta);
                }
                break;
                case 4: {
                    System.out.println("****** Consignar saldo *****");
                    System.out.println("Ingrese el numero de la cuenta: ");
                    long numeroCuenta = getNumeroCuenta(sc);

                    System.out.println("Ingrese el monto que desea consignar: ");
                    double monto = getMonto(sc);

                    int indice = banco.searchCuenta(numeroCuenta);

                    if (indice == -1) System.out.println("** ERROR ** La cuenta que no existe");
                    else {
                        banco.getListCuentas().get(indice).consignar(monto);
                        System.out.println("Se consigo correctamente " + monto + " $ de la cuenta " + numeroCuenta);
                    }
                }
                break;
                case 5: {
                    System.out.println("****** Retirar saldo *****");
                    System.out.println("Ingrese el numero de cuenta: ");
                    long numeroCuenta = getNumeroCuenta(sc);

                    System.out.println("Ingrese el saldo que desea retirar: ");
                    double monto = getMonto(sc);

                    int indice = banco.searchCuenta(numeroCuenta);

                    if (indice == -1) System.out.println("** ERROR ** La cuenta que no existe");
                    else {
                        if (banco.getListCuentas().get(indice).retirar(monto)) {
                            System.out.println("Se retiro correctamente " + monto + " $ de la cuenta " + numeroCuenta);
                        } else {
                            System.out.println("No puedes retirar un monto mayor al saldo de la cuenta");
                        }
                    }
                }
                break;
                case 6: {
                    System.out.println("****** Lista de todas las cuentas *****");
                    for (Cuenta cuenta : banco.getListCuentas()) {
                        System.out.println(cuenta);
                    }
                }
                break;
            }

        } while (opcion != 0);
    }

    private static double getMonto(Scanner sc) {
        double monto;

        do {
            monto = sc.nextDouble();

            if (monto < 0) {
                System.out.println("** ERROR ** Monto negativo");
                System.out.println("Ingrese el monto nuevamente: ");
            }
            if (monto == 0) {
                System.out.println("** ERROR ** El monto no puede ser cero");
                System.out.println("Ingrese el monto nuevamente: ");
            }

        } while (0 >= monto);

        return monto;
    }

    private static double getSaldo(Scanner sc) {
        double saldo;

        do {
            saldo = sc.nextDouble();

            if (saldo == 0) {
                System.out.println("** ERROR ** Saldo de la cuenta no puede ser cero");
                System.out.println("Ingrese el numero de cuenta nuevamente: ");
            } else if (saldo < 0) {
                System.out.println("** ERROR ** Saldo de cuenta negativo");
                System.out.println("Ingrese el saldo de la cuenta nuevamente: ");
            } else if (saldo < 50000) {
                System.out.println("** ERROR ** Saldo de cuenta insuficiente para su creacion");
                System.out.println("Ingrese el saldo de la cuenta nuevamente: ");
            }


        } while (50000 >= saldo);

        return saldo;
    }

    private static long getNumeroCuenta(Scanner sc) {

        long numero;

        do {
            numero = sc.nextLong();

            if (numero < 0) {
                System.out.println("** ERROR ** Numero de cuenta negativo");
                System.out.println("Ingrese el numero de cuenta nuevamente: ");
            }
            if (numero == 0) {
                System.out.println("** ERROR ** Numero de cuenta no puede ser cero");
                System.out.println("Ingrese el numero de cuenta nuevamente: ");
            }

        } while (0 > numero);

        return numero;
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
        System.out.println("------ MENU ------");
    }
}
