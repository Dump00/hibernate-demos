package com.cisco.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "movie")
public class Movie implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @ManyToMany(mappedBy = "movieList", cascade = CascadeType.PERSIST)
    private List<Actor> actorList;

    public Movie(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Movie(String id, String name, List<Actor> actorList) {
        this.id = id;
        this.name = name;
        this.actorList = actorList;
        this.actorList.forEach(actor -> actor.getMovieList().add(this));
    }

    public void addActor(Actor actor) {
        actorList.add(actor);
        actor.getMovieList().add(this);
    }

    public void removeActor(Actor actor) {
        actor.getMovieList().remove(this);
        this.actorList.remove(actor);
    }

    public void setActorList(List<Actor> actorList) {
        actorList.forEach(actor -> actor.getMovieList().add(this));
        this.actorList = actorList;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

