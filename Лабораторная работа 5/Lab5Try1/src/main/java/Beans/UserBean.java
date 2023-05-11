package Beans;

import Pojoes.Users;
import Utilities.UtilityUser;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("userBean")
public class UserBean implements Serializable {
    private Users user = new Users();
    private List<Users> users = new ArrayList<>();
    private UtilityUser utilityUser = new UtilityUser();

    @PostConstruct
    public void init() {
        this.users = utilityUser.findAllUsers();
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void saveUser() {
        utilityUser.saveUser(user);
        user = new Users();
    }

    public void deleteUser(Users user) {
        utilityUser.deleteUser(user);
    }

    public void updateUser() {
        utilityUser.updateUser(user);
        user = new Users();
    }

    public List<Users> getUsers() {
        return utilityUser.findAllUsers();
    }

    public List<Users> getUsersByLogin(String login) {
        return utilityUser.findLogin(login);
    }
    public void refreshUsers() {
        this.users = utilityUser.findAllUsers();
    }
}

