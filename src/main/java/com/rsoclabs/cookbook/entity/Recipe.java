package com.rsoclabs.cookbook.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "cook-book")
@Builder
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long authorId;
    private String name;
    private String description;
//    @Embedded
    @OneToMany(cascade= CascadeType.ALL)
    private List<Ingredient> ingredients;
    private Date date;
}
