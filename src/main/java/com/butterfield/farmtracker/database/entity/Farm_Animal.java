package com.butterfield.farmtracker.database.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="farm_animals")
public class Farm_Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "alt_name")
    private String alt_name;

    @Column(name = "type")
    private Integer type;

    @Column(name = "sex")
    private String sex;

    @Column(name = "dead")
    private Integer dead;

    // TODO: Might need to rework this or something, in-case cow was not sold.
    @Column(name = "sold")
    private Integer sold;

    @Column(name = "notes")
    private String note;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Farm_Animals_Sold> farm_animal;
}
