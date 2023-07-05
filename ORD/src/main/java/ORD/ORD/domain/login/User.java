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

    public User(String userId, String pw) {
        this.userId = userId;
        this.pw = pw;
    }

    public User() {
    }
}
