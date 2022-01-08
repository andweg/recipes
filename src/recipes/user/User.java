package recipes.user;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table
public class User {

    @Id
    @NotBlank(message = "The e-mail address cannot be empty.")
    @Pattern(regexp = ".+@.+\\..+", message = "You need to provide a valid e-mail address.")
    private String email;

    @NotBlank(message = "You need to pick a password.")
    @Size(min = 8, message = "The password needs to be at least 8 characters long.")
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
