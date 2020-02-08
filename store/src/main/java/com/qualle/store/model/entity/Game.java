package com.qualle.store.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "developer_id")
    private Developer developer;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "game_category",
            joinColumns = @JoinColumn(name="game_id", referencedColumnName = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "category_id")
    )
    private Category category;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "game_genre",
            joinColumns = @JoinColumn(name="game_id", referencedColumnName = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "genre_id")
    )
    private Genre genre;

    public Game() {
    }

    public Game(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
