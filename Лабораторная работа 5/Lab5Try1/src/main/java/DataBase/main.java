package DataBase;

import Pojoes.*;
import Utilities.*;

public class main {
    public static void main(String[] args) {
        HibernateClass.getSessionFactory().openSession();
        UtilityUser userService = new UtilityUser();
        userService.findAllUsers();
        /*UtilityAccess accessService = new UtilityAccess();
        UtilityCalculation calculationService = new UtilityCalculation();
        UtilityProfiles profilesService = new UtilityProfiles();
        UtilityReports reportsService = new UtilityReports();
        Users user = new Users("NotMichail477788","2002");
        userService.saveUser(user);
        List<Users> lst = userService.findAllUsers();
        for (Users i : lst) {
            System.out.println(i.toString());
        }
        Access acs = new Access();
        acs.setKey(4);
        acs.setAccess(4);

        Calculating cl = new Calculating(user.getLogin(), "Table", "Graphic", "Enter", "effeective");
        UserProfiles usProf= new UserProfiles(user.getLogin(), "Maksim", "Babinskii", "Aleksandrovich", 1223, "Commander", "+3752921");
        Reports rp = new Reports(user.getLogin(), 1, 1);
        accessService.saveUser(acs);
        calculationService.saveUser(cl);
        profilesService.saveUser(usProf);
        reportsService.saveUser(rp);*/
        //UtilityUser usr = new UtilityUser();
        //System.out.println(usr.findLogin("Mihail"));

    }
}
