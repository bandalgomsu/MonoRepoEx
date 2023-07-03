package ORD.ORD.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity(name ="ORD")
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 255, nullable = false, name="user_id")
    private String userId;

    @Column(length = 255, nullable = false)
    private String code;

    @Column(nullable = false)
    private int clear;

    public  Load(String userId,String code , int clear){
        this.userId = userId;
        this.code = code;
        this.clear = clear;
    }
    public  Load(){

    }

}
