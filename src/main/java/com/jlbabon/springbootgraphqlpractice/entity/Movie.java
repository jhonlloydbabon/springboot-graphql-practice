package com.jlbabon.springbootgraphqlpractice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String director;
    private String studio;
    private Integer releaseYear;
    @ElementCollection
    @CollectionTable(name = "movie_cast")
    private List<String> movieCast;
}
