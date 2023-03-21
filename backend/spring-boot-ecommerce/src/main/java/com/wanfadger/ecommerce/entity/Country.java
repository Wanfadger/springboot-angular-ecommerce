package com.wanfadger.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "country")
@Setter
@Getter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "code" , unique = true , nullable = false)
    private String code;
    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "country")
    private Set<State> states = new HashSet<>();

    public Country() {
    }
}
