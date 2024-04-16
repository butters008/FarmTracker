package com.butterfield.farmtracker.database.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "client")
    private String client;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Farm_Animals_Sold> soldClient;
}
