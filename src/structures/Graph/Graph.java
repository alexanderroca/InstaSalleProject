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

    public boolean insert(Object object){
        if(checkUser(object)){
            User user = (User) object;

            if(!objectExists(user, null)){
                users.add(user);

                if(user.getMy_to_follow() != null){
                    //TODO: Check connections
                }   //if
            }
        }   //if
        else if(checkPost(object)){
            Post post = (Post) object;

            if(!objectExists(null, post)){
                posts.add(post);
                //TODO: Check connections
            }   //if
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
