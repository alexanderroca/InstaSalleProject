import JsonObjects.Objects.Post;
import JsonObjects.Objects.User;
import structures.AVLTree.AVLTree;
import structures.Graph.Graph;
import structures.HashTable.MapHash;
import structures.Trie.Trie;

import java.io.File;
import java.util.Scanner;

import static JsonObjects.Objects.TransferToMyArrayList.transferInfoToMyArraylist;

/**
 * Classe que conte tots els menus del programa
 * @author Alexander Roca
 * @version 0.1
 */
public class Menu {

    //Classes del json
    User[] users;
    Post[] posts;

    //Classes de les estructures
    Graph graph;
    AVLTree avlTreeUser;
    MapHash mapHashUser;
    Trie trieUser;
    AVLTree avlTreePost;
    MapHash mapHashPost;
    Trie triePost;

    private final String DIRECTORY = "jsons";

    /**
     * Procediment que mostra el menu principal del programa
     */
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
                    importacioUsers();
                    importacioPosts();
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

    /**
     * Procediment que mostra el submenu segons la opcio seleccionada anteriorment
     * @param opcio : int
     */
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

    /**
     * Procediment que mostra quina estructura es vol usar
     * @param opcio : int
     */
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

    public String fileSelected(){
        Scanner sc = new Scanner(System.in);

        File dir = new File(DIRECTORY);
        String[] list = dir.list();

        if(list == null || list.length == 0)
            System.out.println("No hi ha elements dins de la carpeta actual");
        else {
            int opcio = -1;

            while (opcio < 0 || opcio > list.length) {
                System.out.println("Seleccioni el fitxer:");
                for (int i = 0; i < list.length; i++)
                    System.out.println(i + "- " + list[i]);

                System.out.print("Opcio: ");
                opcio = sc.nextInt();

                if (opcio < 0 || opcio > list.length)
                    mostrarError();
            }   //while

            return DIRECTORY + "/" + list[opcio];
        }   //else

        return null;
    }

    public void importacioUsers(){

        System.out.println("Seleccion-hi un fitxer d'usuaris:");

        String path = fileSelected();

        if(path.contains("user")) {

            User aux = new User();
            users = (User[]) aux.deserializeJSON(path);
            transferInfoToMyArraylist(users);

            avlTreeUser = new AVLTree();
            mapHashUser = new MapHash(users.length);
            trieUser = new Trie();

            System.out.println("Importacio de Users completada");

        }   //if
        else
            mostrarError();

        System.out.println();
    }

    public void importacioPosts(){

        System.out.println("Seleccion-hi un fitxer de posts:");

        String path = fileSelected();

        if(path.contains("post")) {

            Post aux2 = new Post();
            posts = (Post[]) aux2.deserializeJSON(path);
            transferInfoToMyArraylist(posts);

            graph = new Graph(users, posts);
            avlTreePost = new AVLTree();
            mapHashPost = new MapHash(posts.length);
            triePost = new Trie();

            System.out.println("Importacio de Posts completada");
        }   //if
        else
            mostrarError();

        System.out.println();
    }


    /**
     * Procediment per mostrar un missatge d'error
     */
   public void mostrarError(){
       System.out.println("\nError, opcio incorrecta\n");
   }
}
