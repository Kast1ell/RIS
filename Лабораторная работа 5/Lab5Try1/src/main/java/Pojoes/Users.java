package Pojoes;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "Users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private int id;
    @Column(name = "UserLogin")
    private String login;
    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    @Column(name = "UserPassword")
    private String password;

    public Users() {
    }

    public Users(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "models.User{" +
                "id=" + id +
                ", name='" + login + '\'' +
                ", age=" + password +
                '}';
    }
}