package com.rsoclabs.cookbook.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "cook-book")
@Builder
@ToString(exclude = "ingredients")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long authorId;
    private String name;
    private String description;
//    @Embedded
    @OneToMany(cascade= CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fk_recipe")
    private List<Ingredient> ingredients;
    private Date date;
}
