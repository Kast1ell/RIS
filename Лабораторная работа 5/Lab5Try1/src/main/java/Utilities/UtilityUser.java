package Utilities;

import DAOs.UserDao;
import Pojoes.Users;

import java.util.List;

public class UtilityUser {
    private UserDao usersDao = new UserDao();

    public UtilityUser() {
    }

    public Users findUser(int id) {
        return usersDao.findById(id);
    }

    public void saveUser(Users user) {
        usersDao.save(user);
    }

    public void deleteUser(Users user) {
        usersDao.delete(user);
    }

    public void updateUser(Users user) {
        usersDao.update(user);
    }

    public List<Users> findAllUsers() {
        return usersDao.findAll();

    }
    public List<Users> findLogin(String login) {
        return usersDao.findByLogin(login);
    }


}
