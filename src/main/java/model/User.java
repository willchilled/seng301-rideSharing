package model;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * A class defining a generic user
 * Created by wmu16 on 29/03/17.
 */
class User {

    private String username;
    private String password;
    private String givenName;
    private String surname;
    private Integer age;
    private Image photo;
    private String bio;

    User(String username, String password, String givenName, String surname, Integer age) {
        this.username = username;
        this.password = password;
        this.givenName = givenName;
        this.surname = surname;
        this.age = age;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

}
