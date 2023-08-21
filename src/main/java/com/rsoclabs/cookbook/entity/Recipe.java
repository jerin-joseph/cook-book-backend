package com.rsoclabs.cookbook.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "cook-book")
public class Recipe {
    @Id
    @GeneratedValue
    private Long id;
    private Long authorId;
    private String name;
    private String description;
    private String ingredients;
    private Date date;
}
