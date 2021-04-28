package com.innowise.darya.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private String email;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "roles")
    private Role role;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;


}
