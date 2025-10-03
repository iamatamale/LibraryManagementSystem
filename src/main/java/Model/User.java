package Model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String role;

    public User(int id, String name, String email, String password, String role){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public User(String name, String email, String password, String role){
        this(-1, name, email, password, role);
    }

}
