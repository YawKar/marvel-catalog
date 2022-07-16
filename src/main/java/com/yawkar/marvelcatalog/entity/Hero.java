package com.yawkar.marvelcatalog.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "heroes")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = "comicsInWhichPresent")
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
    @JoinTable(name = "heroes_in_comics",
            joinColumns = @JoinColumn(name = "hero_id"),
            inverseJoinColumns = @JoinColumn(name = "comic_id"))
    private Set<Comic> comicsInWhichPresent = new HashSet<>();
}
