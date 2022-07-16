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
@Table(name = "comics")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = "heroesPresent")
public class Comic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Column(name = "executive_editor")
    private String executiveEditor;
    @ElementCollection
    @Column(name = "cover_artists")
    private List<String> coverArtists;
    @ManyToMany(mappedBy = "comicsInWhichPresent")
    private Set<Hero> heroesPresent = new HashSet<>();
}
