package structures.Graph;

import JsonObjects.Objects.Post;
import JsonObjects.Objects.User;

public class Graph {
    private User[] users;
    private Post[] posts;
    private User user;
    private Post post;

    public Graph(Object[] objects) {

        if(objects instanceof User[])
            this.users = (User[]) objects;
        else if(objects instanceof Post[])
            this.posts = (Post[]) objects;
        else
            System.out.println("Error, el graf no es compatible amb l'objecte que se l'hi ha passat");

        user = null;
        post = null;
    }

    public boolean checkUser(Object object){
        return object instanceof User;
    }

    public boolean checkPost(Object object){
        return object instanceof Post;
    }

    public boolean objectExists(User user, Post post){
        boolean found = false;

        if(user != null){
            for(int i = 0; i < users.length && !found; i++){

                if(user.getUsername().equals(users[i].getUsername()))
                    found = true;
            }   //for
        }   //if
        else if(post != null){
            for(int i = 0; i < posts.length && !found; i++){

                if(post.getId() == posts[i].getId())
                    found = true;
            }   //for
        }   //else-if

        return found;
    }

    public boolean insert(Object object){
        if(checkUser(object)){
            user = (User) object;

            if(!objectExists(user, null)){

            }
        }   //if
        else if(checkPost(object)){

        }   //else-if

        return false;
    }

    public Object get(String username, int id){
        return 1;
    }

    public boolean remove(String username, int id){
        return true;
    }
}
