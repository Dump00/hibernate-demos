package com.cisco.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "actor")
public class Actor implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @ManyToMany
    @JoinTable(name = "actor_movie",
                joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    private Set<Movie> movieList = new HashSet<>();

    public Actor(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
