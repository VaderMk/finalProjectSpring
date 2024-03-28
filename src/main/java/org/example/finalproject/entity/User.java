package org.example.finalproject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.finalproject.enums.*;

import java.util.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
