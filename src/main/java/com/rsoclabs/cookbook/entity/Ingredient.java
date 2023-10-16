package com.rsoclabs.cookbook.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Embeddable
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@AttributeOverrides({
//        @AttributeOverride(name = "name", column = @Column(name = "ingName")),
//        @AttributeOverride(name = "qty", column = @Column(name = "ingQty")),
//})
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String ingName;
    String ingQty;
}
