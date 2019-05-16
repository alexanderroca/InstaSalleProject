import JsonObjects.Objects.Post;
import JsonObjects.Objects.User;
import structures.AVLTree.AVLTree;
import structures.AVLTree.NodeAVL;
import structures.Graph.Graph;
import structures.HashTable.MapHash;
import structures.MyArrayList.MyArrayList;
import structures.Trie.Trie;

import java.io.File;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Vector;

import static JsonObjects.Objects.TransferToMyArrayList.transferInfoToMyArraylist;

/**
 * Classe que conte tots els menus del programa
 * @author Alexander Roca
 * @version 0.1
 */
public class Menu {

    //Classes del json
    public User[] users;
    public Post[] posts;

    //Classes de les estructures
    public Graph graph;
    public Trie trie;
    public AVLTree avlTreeUser;
    public MapHash mapHashUser;
    public AVLTree avlTreePost;
    public MapHash mapHashPost;

    public static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");


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
            System.out.println("\t6- Tornar al menu principal");
            System.out.print("> ");
            String sub_opcio = sc.nextLine();

            switch (sub_opcio){
                case "1":
                    //TODO: Trie
                    trieOption(opcio);
                    break;
                case "2":
                    //TODO: R-Tree
                    break;
                case "3":
                    //TODO: AVL Tree or Red Black Tree
                    avlOption(opcio);
                    break;
                case "4":
                    //TODO: Taula Hash
                    break;
                case "5":
                    //TODO: Graf
                    break;
                case "6":
                    done = true;
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
            trie = new Trie();

            for (int i = 0; i < users.length; i++){
                avlTreeUser.insert_T(users[i].getUsername().hashCode(), users[i]);
                mapHashUser.add(users[i].getUsername().hashCode(), users[i]);
                trie.insert(users[i].getUsername());
            }   //for

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

            for (int i = 0; i < users.length; i++){
                avlTreePost.insert_T(users[i].getUsername().hashCode(), users[i]);
                mapHashPost.add(users[i].getUsername().hashCode(), users[i]);
            }   //for

            System.out.println("Importacio de Posts completada");
        }   //if
        else
            mostrarError();

        System.out.println();
    }

    public void avlOption(String opcio){
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccion-hi sobre quina estructura vol actuar -> Post/User (p/u)");
        System.out.print("Opcio: ");
        String estructura = sc.nextLine();

        if(estructura.equals("p") || estructura.equals("u")) {
            switch (opcio) {
                case "3":
                    System.out.println("\nUsers:");
                    avlTreeUser.inOrder(avlTreeUser.getRoot());
                    System.out.println("\nPosts:");
                    avlTreePost.inOrder(avlTreePost.getRoot());
                    System.out.println();
                    break;
                case "4":
                    Object obj = elementPerInserir(estructura);
                    boolean result_insert = false;
                    if(obj instanceof User) {
                       result_insert = avlTreeUser.insert_T(((User) obj).getUsername().hashCode(), obj);
                    }   //if
                    else if(obj instanceof Post) {
                        result_insert = avlTreePost.insert_T(((Post) obj).getId(), obj);
                    }   //else-if
                    if(result_insert)
                        mostrarExit();
                    else
                        mostrarError();
                    break;
                case "5":
                    //TODO: Esborra
                    break;
                case "6":
                    //TODO: Cerca
                    if(estructura.equals("u")){
                        Scanner sc_search = new Scanner(System.in);
                        System.out.print("Usuari: ");
                        String userToSearch = sc_search.nextLine();
                        NodeAVL user_found = avlTreeUser.search(avlTreeUser.getRoot(), userToSearch.hashCode());
                        if(user_found != null)
                            mostrarExit();
                        else
                            mostrarError();
                    }   //if
                    else if(estructura.equals("p")){
                        Scanner sc_search = new Scanner(System.in);
                        System.out.print("Post: ");
                        int postToSearch = sc_search.nextInt();
                        NodeAVL post_found = avlTreePost.search(avlTreePost.getRoot(), postToSearch);
                        if(post_found != null)
                            mostrarExit();
                        else
                            mostrarError();
                    }   //else-if
                    break;
            }   //switch
        }   //if
        else
            mostrarError();
    }

    public void trieOption(String opcio){

        switch (opcio) {
            case "3":
                //TODO: Visualitzacio
                break;
            case "4":
                 User user = (User) elementPerInserir("u");
                 trie.insert(user.getUsername());
                 mostrarExit();
                break;
            case "5":
                Scanner sc_delete = new Scanner(System.in);
                System.out.print("Usuari: ");
                String userToDelete = sc_delete.nextLine();
                trie.remove_T(userToDelete);
                break;
            case "6":
                Scanner sc_search = new Scanner(System.in);
                System.out.print("Usuari: ");
                String userToSearch = sc_search.nextLine();
                 boolean result_search = trie.search(userToSearch);
                 if(result_search)
                     mostrarExit();
                 else
                     mostrarError();
                break;
        }   //switch
    }

    public User createNewUser(){
        User new_user = new User();

        Scanner sc = new Scanner(System.in);

        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        new_user.setCreation(timestamp.getTime());

        System.out.print("Usuari: ");
        String publicador = sc.nextLine();
        new_user.setUsername(publicador);

        return new_user;
    }

    public Post createNewPost(){

        Post new_post = new Post();

        Scanner sc = new Scanner(System.in);

        new_post.setId((posts[posts.length - 1].getId()) + 1);

        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        new_post.setPublished_when(timestamp.getTime());

        System.out.print("Publicat per: ");
        String publicador = sc.nextLine();
        new_post.setPublished_by(publicador);

        Vector coords = new Vector();

        System.out.println("Localitzacio: ");
        System.out.print("\tX -> ");
        double x = sc.nextDouble();
        coords.add(x);
        System.out.print("\tY -> ");
        double y = sc.nextDouble();
        coords.add(y);
        new_post.setLocation(coords);

        sc.nextLine();

        System.out.println("Hashtags: (Per parar d'inserir hashtags escriu -> esc)");
        int count = 1;
        MyArrayList hashtags = new MyArrayList(5);
        String hashtag_name;
        do{
            System.out.print("\t" + count + "- ");
            hashtag_name = sc.nextLine();
            hashtags.add(hashtag_name);
            count++;
        } while(!hashtag_name.equals("esc"));   //do-while
        hashtags.remove(hashtags.get(hashtags.getSize() - 1));
        new_post.setMy_hashtags(hashtags);

        return new_post;
    }

    public Object elementPerInserir(String estructura){

        if(estructura.equals("p"))
            return createNewPost();
        else if(estructura.equals("u"))
            return createNewUser();

        return null;
    }

    /**
     * Procediment per mostrar un missatge d'error
     */
   public void mostrarError(){
       System.out.println("\nError, opcio incorrecta\n");
   }

   public void mostrarExit(){
       System.out.println("\nEl proces s'ha realitzat correctament\n");
   }
}
