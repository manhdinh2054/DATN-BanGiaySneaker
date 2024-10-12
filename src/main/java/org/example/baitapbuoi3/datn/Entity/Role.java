package org.example.baitapbuoi3.datn.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "nameRole", length = 50)
    private String nameRole;

    @OneToMany(mappedBy = "rolesID")
    private Set<Account> accounts = new LinkedHashSet<>();

}