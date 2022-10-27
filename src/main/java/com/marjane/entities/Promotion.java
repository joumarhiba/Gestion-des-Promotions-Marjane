package com.marjane.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@NamedQuery(name = "Promotion.byCenter",query = "FROM Promotion p WHERE id =?1")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private Double promo;
    @Column(columnDefinition = "int default 0")
    private int status;



    @ManyToOne
    private Category category;

    @ManyToOne
    private Center center;

}