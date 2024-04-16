package com.butterfield.farmtracker.database.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type_id")
    private Integer type_id ;

    @Column(name = "type_name")
    private String type_name;

/*    @OneToOne(mappedBy = "id", fetch = FetchType.LAZY)
    private Set<Type> farm_animal_type;*/
}
