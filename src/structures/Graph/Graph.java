package structures.Graph;

import JsonObjects.Objects.Post;
import JsonObjects.Objects.User;
import structures.MyArrayList.MyArrayList;

public class Graph {
    private MyArrayList<User> users;
    private MyArrayList<Post> posts;

    public Graph(User[] users, Post[] posts) {

        this.users = new MyArrayList(users.length);
        this.posts = new MyArrayList<>(posts.length);

        for(User user : users)
            this.users.add(user);

        for(Post post : posts)
            this.posts.add(post);
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
            for(int i = 0; i < users.getSize() && !found; i++){

                if(user.getUsername().equals(users.get(i).getUsername()))
                    found = true;
            }   //for
        }   //if
        else if(post != null){
            for(int i = 0; i < posts.getSize() && !found; i++){

                if(post.getId() == posts.get(i).getId())
                    found = true;
            }   //for
        }   //else-if

        return found;
    }

    public void addUserConnections(User user){

        for(int i = 0; i < users.getSize(); i++)
            for(int j = 0; j < user.getMy_to_follow().getSize(); j++)
                if (users.get(i).getUsername().equals(user.getMy_to_follow().get(j)))
                    users.get(i).getMy_to_follow().add(user.getUsername());
    }

    public boolean insert(Object object){
        if(checkUser(object)){
            User user = (User) object;

            if(!objectExists(user, null)){
                users.add(user);

                if(user.getMy_to_follow() != null)
                    addUserConnections(user);
            }
        }   //if
        else if(checkPost(object)){
            Post post = (Post) object;

            if(!objectExists(null, post))
                posts.add(post);
        }   //else-if

        return false;
    }

    public Object get(String username, int id){
        boolean found = false;

        if(username != null){
            User user = new User();

            for(int i = 0; i < users.getSize() && !found; i++){
                if(users.get(i).getUsername().equals(username)){
                    user = users.get(i);
                    found = true;
                }   //if
            }   //for

            return user;
        }   //if
        else if(id != -1){
            Post post = new Post();

            for(int i = 0; i < posts.getSize() && !found; i++){
                if(posts.get(i).getId() == id){
                    post = posts.get(i);
                    found = true;
                }   //if
            }   //for

            return post;
        }   //else-if

        return null;
    }

    public boolean remove(String username, int id){
        boolean found = false;

        if(username != null){
            User user = null;

            for(int i = 0; i < users.getSize() && !found; i++){

                if(users.get(i).getUsername().equals(username)){

                    user = users.get(i);
                    users.remove(user);
                    found = true;
                }   //if
            }   //for

            if(found) {

                for (int i = 0; i < posts.getSize(); i++) {

                    if (posts.get(i).getPublished_by().equals(username)) {
                        posts.remove(posts.get(i));
                        i--;
                    }   //if
                }   //for
            }   //if

            return found;
        }   //if
        else if(id != -1){
            Post post;

            for(int i = 0; i < posts.getSize() && !found; i++){

                if(posts.get(i).getId() == id){

                    post = posts.get(i);
                    posts.remove(post);
                    found = true;
                }   //if
            }   //for

            return found;
        }   //else-if

        return false;
    }
}
