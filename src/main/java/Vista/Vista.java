package Vista;

public class Vista {
    public static void menuPrincipal (){
        System.out.println("\n====================================");
        System.out.println("   GESTIÓ DE PERSISTÈNCIA PILLAM");
        System.out.println("====================================");
        System.out.println("1. Gestió d'Escaladors");
        System.out.println("2. Gestió d'Escoles");
        System.out.println("3. Gestió de Vies");
        System.out.println("0. Sortir");
        System.out.print("\nTria una categoria: ");
    }

    public static void menuEscalador (){
        System.out.println("\n--- SUBMENÚ ESCALADORS ---");
        System.out.println("1. Afegir nou Escalador");
        System.out.println("2. Llistar tots els Escaladors");
        System.out.println("3. Tornar");
        System.out.print("Selecciona: ");
    }

    public static void menuEscoles(){
        System.out.println("\n--- SUBMENÚ ESCOLES ---");
        System.out.println("1. Registrar Escola");
        System.out.println("2. Llistar Escoles");
        System.out.println("3. Tornar");
        System.out.print("Selecciona: ");
    }

    public static void menuVies(){
        System.out.println("\n--- SUBMENÚ VIES ---");
        System.out.println("1. Afegir Via");
        System.out.println("2. Llistar Vies");
        System.out.println("3. Tornar");
        System.out.print("Selecciona: ");
    }
}
