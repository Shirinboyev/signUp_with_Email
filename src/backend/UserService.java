package backend;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();

    public UserService() {
        this.users.add(new User("gayratbek", 20, "gayratshirinboyev6707@gmail.com","Zubayr007"));
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
