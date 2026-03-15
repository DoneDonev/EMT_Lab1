package finki.ukim.mk.lab1.model.domain;

import finki.ukim.mk.lab1.model.enums.Category;
import finki.ukim.mk.lab1.model.enums.State;
import jakarta.persistence.*;

@Entity
@Table(name = "accommodations")
public class Accommodation extends BaseAuditableEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "host_id", nullable = false)
    private Host host;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private State state;

    @Column(nullable = false)
    private Integer numRooms;

    @Column(nullable = false)
    private Boolean rented = Boolean.FALSE;

    public Accommodation() {}

    public Accommodation(String name, Category category, Host host, State state, Integer numRooms, Boolean rented) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.state = state;
        this.numRooms = numRooms;
        this.rented = rented;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public Host getHost() { return host; }
    public void setHost(Host host) { this.host = host; }

    public State getState() { return state; }
    public void setState(State state) { this.state = state; }

    public Integer getNumRooms() { return numRooms; }
    public void setNumRooms(Integer numRooms) { this.numRooms = numRooms; }

    public Boolean getRented() { return rented; }
    public void setRented(Boolean rented) { this.rented = rented; }
}