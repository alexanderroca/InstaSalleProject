import java.util.Scanner;

public class Menu {

    // Main Menu
    public void menuPrincipal(){
        String opcio = new String();
        Scanner sc = new Scanner(System.in);

        System.out.println("BENVINGUT AL NOSTRE PROGRAMA");

        while(!opcio.equals("9")) {
            System.out.println("Tria una opcio:");
            System.out.println("\t1- Importacio de l'estat de l'estructura");
            System.out.println("\t2- Exportacio de l'estat de l'estructura");
            System.out.println("\t3- Visualitzacio de l'estat de l'estructura");
            System.out.println("\t4- Insercio d'informacio");
            System.out.println("\t5- Esborrar informacio");
            System.out.println("\t6- Cercar informacio");
            System.out.println("\t7- Autocompletar");
            System.out.println("\t8- Limitar memoria per autocompletar");
            System.out.println("\t9- Sortir");
            System.out.print("> ");
            opcio = sc.nextLine();

            switch (opcio){
                case "1":
                    //TODO: Importacio
                    break;
                case "2":
                    //TODO: Exportacio
                    break;
                case "3":
                    //TODO: Visualitzacio
                    subMenuPrincipal(opcio);
                    break;
                case "4":
                    //TODO: Insercio
                    subMenuPrincipal(opcio);
                    break;
                case "5":
                    //TODO: Esborra
                    subMenuPrincipal(opcio);
                    break;
                case "6":
                    //TODO: Cerca
                    subMenuPrincipal(opcio);
                    break;
                case "7":
                    //TODO: Autocompletar
                    break;
                case "8":
                    //TODO: Limitar memoria per autocompletar
                    break;
                case "9":
                    break;
                    default:
                        mostrarError();
                        break;
            }   //switch

        }   //while
        System.out.println("\nGRACIES PER USAR EL NOSTRE PROGRAMA");
    }

    public void mostraOpcio(String opcio){
        switch (opcio){
            case "3":
                System.out.println("Visualitzacio de l'estructura");
                System.out.println("Quina estructura desitja visualitzar?");
                break;
            case "4":
                System.out.println("Insercio d'informacio");
                System.out.println("Quin tipus d'informacio vol inserir?");
                break;
            case "5":
                System.out.println("Esborrar informacio");
                System.out.println("Quin tipus d'informacio vol esborrar?");
                break;
            case "6":
                System.out.println("Cercar informacio");
                System.out.println("Quin tipus d'informacio vol cercar?");
                break;
        }   //switch
    }

    // Submenu from principal Menu
    public void subMenuPrincipal(String opcio){
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
            String sub_opcio = sc.nextLine();

            switch (sub_opcio){
                case "1":
                    //TODO: Trie
                    break;
                case "2":
                    //TODO: R-Tree
                    break;
                case "3":
                    //TODO: AVL Tree or Red Black Tree
                    break;
                case "4":
                    //TODO: Taula Hash
                    break;
                case "5":
                    //TODO: Graf
                    break;
                    default:
                        mostrarError();
                        break;
            }   //switch
        }   //while
    }

   public void mostrarError(){
       System.out.println("\nError, opcio incorrecta\n");
   }
}
