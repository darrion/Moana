package moanainc.com.moana.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by josh baldwin on 2/13/2017.
 */

public class Model {
    private static final Model _instance = new Model();
    public static Model getInstance() { return _instance; }

    private Map<String, User> _users;

    /**
     * make a new model
     */
    public Model() {
        _users = new HashMap<>();

        testUser();
    }

    /**
     * return the list of users
     */
    public Map<String, User> getUsers() { return _users; };

    /**
     * Add a test user
     */
    public void testUser() {
        User datBoi = new User("George P. Burdell", "jackets7");
        _users.put("Georgia P. Burdell", datBoi);
    }

    /**
     * Add a new user to the list.....is this needed??? since arraylist has add method
     */
    public void addUser(User u) {
//        if (_users.add(u)) {
//            //go to successful registration page
//        } else {
//            registrationFailed(u);
//        }

        _users.put(u.getUsername(), u);
    }

    /**
     * Find the cause of a failed registration
     */
    public void registrationFailed(User u) {
        if (_users.containsValue(u)) {
            //user already exists
        } else if (!_users.containsValue(u)) {
            //user input an unacceptable password
        }
    }

    public User findUserByName(String name) {
        return _users.get(name);
    }

    public boolean userExists(String name) {
        return _users.containsKey(name);
    }
}
