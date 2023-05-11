package Utilities;

import DAOs.UserProfilesDAO;
import Pojoes.UserProfiles;

import java.util.List;

public class UtilityProfiles {
    private UserProfilesDAO profilesDAO = new UserProfilesDAO();

    public UtilityProfiles() {
    }

    public UserProfiles findUser(int id) {
        return profilesDAO.findById(id);
    }

    public void saveUser(UserProfiles user) {
        profilesDAO.save(user);
    }

    public void deleteUser(UserProfiles user) {
        profilesDAO.delete(user);
    }

    public void updateUser(UserProfiles user) {
        profilesDAO.update(user);
    }

    public List<UserProfiles> findAllUsers() {
        return profilesDAO.findAll();
    }

    public List<UserProfiles> findUserProfile(String login) {
        return profilesDAO.findUserProfile(login);
    }


}
