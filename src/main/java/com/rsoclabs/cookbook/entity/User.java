package com.rsoclabs.cookbook.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users", schema = "cook-book")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_seq", allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotEmpty(message ="First name cannot be empty.")
    private String firstName;
    @NotEmpty(message ="Last name cannot be empty.")
    private String lastName;
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE,message ="Email should be valid.")
    @Column(nullable = false, unique = true)
    private String email;
    @NotEmpty
    @Size(min = 8, message = "Password must have minimum 8 characters")
    private String password;
}
