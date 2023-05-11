package Pojoes;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UserProfiles")
public class UserProfiles implements Serializable{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ProfileID")
        private int id;
        @Column(name = "UserLogin")
        private String login;
        //можно не указывать Column name, если оно совпадает с названием столбца в таблице
        @Column(name = "UserName")
        private String name;
    @Column(name = "UserSecondName")
    private String secondName;
    @Column(name = "UserLastName")
    private String lastName;
    @Column(name = "AccessKey")
    private int AccessKey;
    @Column(name = "UserPost")
    private String post;
    @Column(name = "UserPhone")
    private String phone;

        public UserProfiles() {
        }

        public UserProfiles(String login, String name, String secondName, String lastName, int AccessKey, String post, String phone) {
            this.login = login;
            this.name = name;
            this.secondName = secondName;
            this.lastName = lastName;
            this.AccessKey = AccessKey;
            this.post = post;
            this.phone = phone;
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public int getAccessKey() {
        return AccessKey;
    }
    public void setAccessKey(int AccessKey) {
        this.AccessKey = AccessKey;
    }
    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }



        @Override
        public String toString() {
            return "models.User{" +
                    "id=" + id +
                    ", name='" + login + '\'' +
                    ", name='" + name + '\'' +
                    ", name='" + secondName + '\'' +
                    ", name='" + lastName + '\'' +
                    ", name='" + AccessKey + '\'' +
                    ", name='" + post+ '\'' +
                    ", name='" + phone + '\'' +
                    '}';
        }
}

