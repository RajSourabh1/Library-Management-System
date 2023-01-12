package com.example.LMS_db.Models;


import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table
@Data // contains @Getter @setter @requiredConstructor
@NoArgsConstructor
@Builder // on the top of that class that you want to build. It needs all AllArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false,unique = true)
    private String email;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> bookWrittenByAuthor;
}
