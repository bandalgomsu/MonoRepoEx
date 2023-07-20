package ORD.ORD.domain.load;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity(name ="User")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 255, nullable = false, name="user_id")
    private String userId;

    @Column(length = 255, nullable = false)
    private String pw;

    @Column(length = 255, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    private String Role;
    public User(String userId, String pw) {
        this.userId = userId;
        this.pw = pw;
    }
    public User(String userId, String pw,String email,String Role) {
        this.userId = userId;
        this.pw = pw;
        this.email=email;
        this.Role=Role;
    }

    public User() {
    }
}
