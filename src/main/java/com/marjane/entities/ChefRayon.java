package com.marjane.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @NoArgsConstructor
public class ChefRayon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String email;
    private String password;
    private int categoryId;

    @ManyToOne(cascade=CascadeType.PERSIST )
    @JoinColumn(name = "center_id",referencedColumnName = "id")
    private Center center;



}