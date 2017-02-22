package moanainc.com.moana.controllers;

/**
 * Created by josh baldwin on 2/13/2017.
 */

public class User {
    //the user's username
    private String _username;
    //the user's password
    private String _password;
    //the user's real name
    private String _name;
    //the user's access level
    private AccountType _accountType;

    public User() {

    }

    /**
     * Makes a new user
     * @param username the username
     * @param password the password
     */

    public User(String username, String password) {

        _username = username;
        _password = password;
    }

    /**
     * Getters and Setters
     */
    public String getUsername() { return _username; }
    public void setUsername(String username) { _username = username; }

    public String getPassword() { return _password; } //if we want to implement "Forgot password"
    public void setPassword(String password) { _password = password; } //if we want to implement "Change password"

    public String getName() { return _name; }
    public void setName(String name) { _name = name; }

    public AccountType getAccountType() { return _accountType; }
    public void setAccountType(AccountType type) { _accountType = type; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User)) {
            return false;
        }

        User u = (User) o;
        return (u.getUsername().equals(_username) && u.getPassword().equals(_password));
    }

    @Override
    public String toString() {
        return _name + " " + _username + " " + _password + " " + _accountType.toString();
    }
}
