package Conexió;

import DAO.*;
import Model.*;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static final EscaladorDAO escaladorDAO = new EscaladorDAO();
    private static final EscolaDAO escolaDAO = new EscolaDAO();
    private static final ViaDAO viaDAO = new ViaDAO();

    public static void main(String[] args) {
        int opcio = -1;

        while (opcio != 0) {
            System.out.println("\n====================================");
            System.out.println("   GESTIÓ DE PERSISTÈNCIA PILLAM");
            System.out.println("====================================");
            System.out.println("1. Gestió d'Escaladors");
            System.out.println("2. Gestió d'Escoles");
            System.out.println("3. Gestió de Vies");
            System.out.println("0. Sortir");
            System.out.print("\nTria una categoria: ");

            try {
                opcio = Integer.parseInt(sc.nextLine());

                switch (opcio) {
                    case 1: menuEscaladors(); break;
                    case 2: menuEscoles(); break;
                    case 3: menuVies(); break;
                    case 0: System.out.println("Gràcies per usar Pillam DB."); break;
                    default: System.out.println("Opcio no valida.");
                }
            } catch (NumberFormatException e) {
                System.out.println(" error: Introdueix un número.");
            }
        }
    }

    private static void menuEscaladors() {
        System.out.println("\n--- SUBMENÚ ESCALADORS ---");
        System.out.println("1. Afegir nou Escalador");
        System.out.println("2. Llistar tots els Escaladors");
        System.out.println("3. Tornar");
        System.out.print("Selecciona: ");

        int sub = Integer.parseInt(sc.nextLine());

        try {
            if (sub == 1) {
                System.out.print("Nom: "); String nom = sc.nextLine();
                System.out.print("Alias (únic): "); String alias = sc.nextLine();
                System.out.print("Edat: "); int edat = Integer.parseInt(sc.nextLine());
                System.out.print("Nivell Màxim (ex: 6a+): "); String nivell = sc.nextLine();
                System.out.print("Nacionalitat: "); String nac = sc.nextLine();

                Escalador e = new Escalador(alias, edat, nivell, nom, nac);
                escaladorDAO.insertar(e);
            } else if (sub == 2) {
                System.out.println("\nLLISTA D'ESCALADORS REGISTRATS:");
                for (Escalador e : escaladorDAO.listarTodos()) {
                    System.out.println("- " + e.getAlias() + " (" + e.getNom() + ") | Nivell: " + e.getNivellMaxim());
                }
            }
        } catch (Exception ex) {
            System.out.println("mal: " + ex.getMessage());
        }
    }

    private static void menuEscoles() {
        System.out.println("\n--- SUBMENÚ ESCOLES ---");
        System.out.println("1. Registrar Escola");
        System.out.println("2. Llistar Escoles");
        System.out.print("Selecciona: ");

        int sub = Integer.parseInt(sc.nextLine());

        try {
            if (sub == 1) {
                System.out.print("Nom: "); String nom = sc.nextLine();
                System.out.print("Població: "); String pob = sc.nextLine();
                System.out.print("Aproximació: "); String aprox = sc.nextLine();
                System.out.print("Popularitat (baixa/mitjana/alta): "); String pop = sc.nextLine();

                Escola esc = new Escola(aprox, 0, nom, pob, pop);
                escolaDAO.insertar(esc);
            } else if (sub == 2) {
                for (Escola esc : escolaDAO.listarTodos()) {
                    System.out.println("- " + esc.getNom() + " en " + esc.getPoblacio());
                }
            }
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }

    private static void menuVies() {
        System.out.println("\n--- SUBMENÚ VIES ---");
        System.out.println("1. Afegir Via");
        System.out.println("2. Llistar Vies");
        System.out.print("Selecciona: ");

        int sub = Integer.parseInt(sc.nextLine());

        try {
            if (sub == 1) {
                System.out.print("Nom de la via: "); String nom = sc.nextLine();
                System.out.print("Grau: "); String grau = sc.nextLine();
                System.out.print("Orientació (N, S, E, O...): "); String ori = sc.nextLine();
                System.out.print("ID Sector: "); int idSec = Integer.parseInt(sc.nextLine());
                System.out.print("ID Creador (ID Escalador): "); int idCre = Integer.parseInt(sc.nextLine());

                Via v = new Via(LocalDateTime.now(), "Apte", grau, idCre, idSec, ori, nom, "Cap", "Calcaria");
                viaDAO.insertar(v);
                System.out.println("Via registrada correctament!");
            } else if (sub == 2) {
                for (Via v : viaDAO.listarTodos()) {
                    System.out.println("- " + v.getNom() + " [" + v.getGrau() + "] - Sector: " + v.getIdSector());
                }
            }
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }
}