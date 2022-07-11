package com.yawkar.marvelcatalog.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "heroes")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "real_name")
    private String realName;
    private String alias;
    @ElementCollection
    private List<String> superpowers;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "heroes_in_comics",
            joinColumns = @JoinColumn(name = "hero_id"),
            inverseJoinColumns = @JoinColumn(name = "comic_id")
    )
    private List<Comic> comicsInWhichPresent;

    public Hero() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<String> getSuperpowers() {
        return superpowers;
    }

    public void setSuperpowers(List<String> superpowers) {
        this.superpowers = superpowers;
    }

    public List<Comic> getComicsInWhichPresent() {
        return comicsInWhichPresent;
    }

    public void setComicsInWhichPresent(List<Comic> comicsInWhichPresent) {
        this.comicsInWhichPresent = comicsInWhichPresent;
    }
}
