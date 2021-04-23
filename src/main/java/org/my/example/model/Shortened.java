package org.my.example.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.net.URL;


@Data
@Entity
@Table(name = "url",
        indexes = {
                @Index(name = "url_code_index", columnList = "code", unique = true),
                @Index(name = "url_url_index", columnList = "url"),
                @Index(name = "url_by_user_index", columnList = "by_user"),
        })
public class Shortened {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String code;

    @NotNull
    @Column(nullable = false, unique = true)
    private URL url;

    @NotNull
    @Column(name = "by_user", nullable = false)
    private String byUser;


}
