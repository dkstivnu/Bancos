package Presentacion;

import Negocio.AreaFuncional;
import Negocio.Banco;
import Negocio.Cuenta;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco("Compañia de Financiamiento NU",
                "Cr 12 #3A-4",
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
                    long numeroCuenta = getNumero(sc);

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
                    long numeroCuenta = getNumero(sc);

                    int indice = banco.searchCuenta(numeroCuenta);

                    if (indice == -1) System.out.println("** ERROR ** La cuenta que no existe");

                    else System.out.println(banco.getListCuentas().get(indice));
                }
                break;
                case 3: {
                    System.out.println("****** Eliminar cuenta *****");
                    System.out.println("Ingrese el numero de la cuenta que desea eliminar: ");
                    long numeroCuenta = getNumero(sc);


                    if (banco.searchCuenta(numeroCuenta) != -1) {
                        banco.deleteCuenta(numeroCuenta);
                    } else {
                        System.out.println("** ERROR ** La cuenta que no existe");
                    }
                }
                break;
                case 4: {
                    System.out.println("****** Consignar saldo *****");
                    System.out.println("Ingrese el numero de la cuenta: ");
                    long numeroCuenta = getNumero(sc);

                    System.out.println("Ingrese el monto que desea consignar: ");
                    double monto = getMonto(sc);

                    int indice = banco.searchCuenta(numeroCuenta);

                    if (indice == -1) System.out.println("** ERROR ** La cuenta que no existe");
                    else {
                        banco.getListCuentas().get(indice).consignar(monto);
                        System.out.println("Se consigno correctamente " + monto + " $ de la cuenta " + numeroCuenta);
                    }
                }
                break;
                case 5: {
                    System.out.println("****** Retirar saldo *****");
                    System.out.println("Ingrese el numero de cuenta: ");
                    long numeroCuenta = getNumero(sc);

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
                case 7: {
                    System.out.println("****** Agregar Area Funcional *****");

                    System.out.println("Ingrese el codigo de la area funcional: ");
                    int codigo = (int) getNumero(sc);

                    System.out.println("Ingrese el nombre que desea para la area funcional: ");
                    String nombre = sc.next();

                    if (banco.addAreaFuncional(codigo, nombre)) {
                        System.out.println("Se agrego el area funcional correctamente");
                    } else {
                        System.out.println("** ERROR ** El area funcional ya existe");
                    }

                }
                break;
                case 8: {
                    System.out.println("****** Buscar area funcional *****");
                    System.out.println("Ingrese el codigo que desea buscar: ");
                    int codigo = (int) getNumero(sc);

                    int indice = banco.searchCuenta(codigo);

                    if (indice != -1)
                        System.out.println(banco.getListAreaFuncional().get(indice));
                    else
                        System.out.println("** ERROR ** La cuenta que no existe");
                }
                break;
                case 9: {
                    System.out.println("****** Eliminar area funcional *****");
                    System.out.println("Ingrese el codigo de la area funcional que desea eliminar: ");
                    int codigo = (int) getNumero(sc);

                    if (banco.deleteAreaFuncional(codigo)) {
                        System.out.println("Se elimino el area funcional correctamente");
                    }else{
                        System.out.println("La area funcional no existe");
                    }
                }
                break;
                case 10: {
                    System.out.println("******* Lista de areas funcionales ********");
                    for (AreaFuncional area : banco.getListAreaFuncional()) {
                        System.out.println(area);
                    }
                }
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


        } while (saldo < 50000);

        return saldo;
    }

    private static long getNumero(Scanner sc) {

        long numero;

        do {
            numero = sc.nextLong();

            if (numero < 0) {
                System.out.println("** ERROR ** Numero negativo");
                System.out.println("Ingrese el numero nuevamente: ");
            }
            if (numero == 0) {
                System.out.println("** ERROR ** Numero no puede ser cero");
                System.out.println("Ingrese el numero nuevamente: ");
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
        System.out.println("7 - Adicionar Area Funcional");
        System.out.println("8 - Buscar Area Funcional");
        System.out.println("9 - Eliminar Area Funcional");
        System.out.println("10 - Mostrar areas funcionales");
        System.out.println("0 - Salir");
        System.out.println("------ MENU ------");
    }
}
