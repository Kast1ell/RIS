package Beans;

import Pojoes.UserProfiles;
import Utilities.UtilityProfiles;

import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("userProfileBean")
public class UserProfilesBean implements Serializable {

    private UserProfiles userProfiles;
    private List<UserProfiles> userProfilesList;

    private UtilityProfiles utilityProfiles = new UtilityProfiles();

    public UserProfilesBean() {
        userProfiles = new UserProfiles();
        userProfilesList = utilityProfiles.findAllUsers();
    }

    public void saveUser() {
        utilityProfiles.saveUser(userProfiles);
        userProfilesList = utilityProfiles.findAllUsers();
        userProfiles = new UserProfiles();
    }

    public void deleteUser(UserProfiles userProfiles) {
        utilityProfiles.deleteUser(userProfiles);
        userProfilesList = utilityProfiles.findAllUsers();
    }

    public void updateUser() {
        utilityProfiles.updateUser(userProfiles);
        userProfilesList = utilityProfiles.findAllUsers();
        userProfiles = new UserProfiles();
    }

    public UserProfiles getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(UserProfiles userProfiles) {
        this.userProfiles = userProfiles;
    }

    public List<UserProfiles> getUserProfilesList() {
        return userProfilesList;
    }

    public void setUserProfilesList(List<UserProfiles> userProfilesList) {
        this.userProfilesList = userProfilesList;
    }

}
