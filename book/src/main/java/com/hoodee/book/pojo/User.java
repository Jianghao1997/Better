package com.hoodee.book.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * Package: com.hoodee.book.pojo
 * Description：
 * Author: jianghao
 * Date:  2020.03.01 15:53
 * Modified By:
 */
@Entity
@Data
@Table(name = "user")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    private String username;
    private String password;
    private String salt;
    private String name;
    private String phone;
    private String email;
    private boolean enabled;
}
