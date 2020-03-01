package com.hoodee.book.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * Package: com.hoodee.book.pojo
 * Description：Category种类对象
 * Author: jianghao
 * Date:  2020.03.01 18:45
 * Modified By:
 */
@Data
@Entity
@Table(name = "category")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    String name;
}
