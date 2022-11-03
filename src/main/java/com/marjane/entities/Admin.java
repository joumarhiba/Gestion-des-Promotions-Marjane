package com.marjane.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity
@Data
@ToString(exclude = {"email","password","adminGen"})
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    @Column(columnDefinition = "int default 1")
    private int role;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "admingen_adminid", referencedColumnName = "adminid")
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JoinColumn(columnDefinition = "int default 1")
    private AdminGen adminGen;





}
