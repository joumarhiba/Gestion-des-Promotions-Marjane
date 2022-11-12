package com.marjane.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name = "promotion")
@Data
@NoArgsConstructor
//@NamedQuery(name = "Category.name" , query = "FROM Category order by id desc")
@NamedQuery(name = "Promotion.byCategory",query = "FROM Promotion p")

public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private Double promo;
    @Column(columnDefinition = "int default 0")
    private int status;
    private Double fidelity;



    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
   // @JoinColumn(columnDefinition = "int default 1", referencedColumnName = "id")
    private Category category;

    @ManyToOne(cascade=CascadeType.PERSIST)

    @OnDelete(action = OnDeleteAction.CASCADE)
   // @JoinColumn(columnDefinition = "int default 1", referencedColumnName = "id")
    @JoinColumn(name = "center_id", referencedColumnName = "id")
    private Center center;

}