import java.util.Scanner;

public class Menu {

    // Main Menu
    public void menuPrincipal(){
        String opcio = new String();
        Scanner sc = new Scanner(System.in);

        System.out.println("BENVINGUT AL NOSTRE PROGRAMA");

        while(!opcio.equals("7")) {
            System.out.println("Tria una opcio:");
            System.out.println("\t1- Importacio de l'estat de l'estructura");
            System.out.println("\t2- Exportacio de l'estat de l'estructura");
            System.out.println("\t3- Visualitzacio de l'estat de l'estructura");
            System.out.println("\t4- Insercio d'informacio");
            System.out.println("\t5- Esborrar informacio");
            System.out.println("\t6- Cercar informacio");
            System.out.println("\t7- Sortir");
            System.out.print("> ");
            opcio = sc.nextLine();

            if(opcio.equals("1") || opcio.equals("2") || opcio.equals("3") || opcio.equals("4") ||
                    opcio.equals("5") || opcio.equals("6"))
                subMenuPrincipal(opcio);

            else if(!opcio.equals("7"))
                System.out.println("Error, opcio incorrecte\n");

        }   //while
        System.out.println("\nGRACIES PER USAR EL NOSTRE PROGRAMA");
    }

    public void mostraOpcio(String opcio){
        System.out.println();
        switch (opcio){
            case "1":
                System.out.println("Importacio de l'estat de l'estructura");
                System.out.println("Quina estructura desitja importar?");
                break;
            case "2":
                System.out.println("Exportacio de l'estat de l'estructura");
                System.out.println("Quina estructura desitja exportar?");
                break;
            case "3":
                System.out.println("Visualitzacio de l'estructura");
                System.out.println("Quina estructura desitja visualitzar?");
                break;
            case "4":
                System.out.println("Insercio d'informacio");
                System.out.println("Quin tipus d'informacio vol inserir?");
                //TODO: subMenu d'insercio
                break;
            case "5":
                System.out.println("Esborrar informacio");
                System.out.println("Quin tipus d'informacio vol esborrar?");
                //TODO: subMenu d'esborrar
                break;
            case "6":
                System.out.println("Cercar informacio");
                System.out.println("Quin tipus d'informacio vol cercar?");
                //TODO: subMenu de cerca
                break;
        }   //switch
    }

    // Submenu from principal Menu
    public void subMenuPrincipal(String opcio){
        String sub_opcio = new String();
        boolean done = false;
        Scanner sc = new Scanner(System.in);

        while(!done){
            mostraOpcio(opcio);
            System.out.println("\t1- Trie");
            System.out.println("\t2- R-Tree");
            System.out.println("\t3- AVL Tree/Red Black Tree");
            System.out.println("\t4- Taula de Hash");
            System.out.println("\t5- Graph");
            System.out.print("> ");
            sub_opcio = sc.nextLine();

            if(sub_opcio.equals("1") || sub_opcio.equals("2") || sub_opcio.equals("3"))
                done = subMenu2(opcio, sub_opcio);

            else if(opcio.equals("4") || opcio.equals("5") || opcio.equals("6"))
                continue;

            else
                System.out.println("Error, opcio incorrecte\n");
        }   //while
    }

    public boolean subMenu2(String opcio, String sub_opcio){
        System.out.println();

        switch (opcio){
            case "1":
                Scanner importa = new Scanner(System.in);
                System.out.println("Especifiqui ruta del fitxer a importar");
                //TODO: importacio, sub_opcio
                break;
            case "2":
                Scanner exporta = new Scanner(System.in);
                System.out.println("Especifiqui ruta del fitxer a exportar");
                //TODO: exportacio, sub_opcio
                break;
            case "3":
                //TODO: visitar, sub_opcio
                break;
        }   //switch

        return true;
    }
}
