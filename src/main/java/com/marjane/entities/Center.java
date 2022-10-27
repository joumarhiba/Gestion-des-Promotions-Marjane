package com.marjane.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ville;

    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)

    private Admin admin;

    @OneToMany(fetch = FetchType.EAGER)
    private List<ChefRayon> chefRayons;


    @OneToMany(mappedBy = "center")
    private List<Promotion> promotions;

}
