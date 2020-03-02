package com.hoodee.book.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * Package: com.hoodee.book.pojo
 * Description：
 * Author: jianghao
 * Date:  2020.03.01 15:53
 * Modified By:
 */

@Data
@Entity
@Table(name = "jotter_article")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class JotterArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String articleTitle;
    private String articleContentHtml;
    private String articleContentMd;
    private String articleAbstract;
    private String articleCover;
    private Date articleDate;
}
