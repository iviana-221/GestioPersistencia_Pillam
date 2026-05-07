package Controlador;

import DAO.*;
import Model.*;
import java.util.Scanner;
import java.time.LocalDateTime;
import Excepcions.*;
import Vista.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static final EscaladorDAO escaladorDAO = new EscaladorDAO();
    private static final EscolaDAO escolaDAO = new EscolaDAO();
    private static final ViaDAO viaDAO = new ViaDAO();

    public static void main(String[] args) {
        int num = -1;
        String opcio = "";
        while (num != 0) {
            try{
            Vista.menuPrincipal();
            opcio = sc.nextLine();
                if(!opcio.matches("^[0-3]$")){throw new Exception();}
                num = ExcepcionsPropies.comprovacionNum(opcio);
                switch (num) {
                    case 1: menuEscaladors(); break;
                    case 2: menuEscoles(); break;
                    case 3: menuVies(); break;
                    case 0: System.out.println("Gràcies per usar Pillam DB."); break;
                    default: System.out.println("Opcio no valida.");
                }
            } catch (Exception e) {
                System.out.println(" error: Introdueix un número.");
            }
        }
    }

    private static void menuEscaladors() {
        Vista.menuEscalador();
        String opcio = sc.nextLine();
        try {
            if(!opcio.matches("^[0-2]$")){throw new Exception();}
            int sub = Integer.parseInt(opcio);
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
        Vista.menuEscoles();
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
        Vista.menuVies();
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