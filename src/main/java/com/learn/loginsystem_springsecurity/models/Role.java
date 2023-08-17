package com.learn.loginsystem_springsecurity.models;

import jakarta.persistence.*;
import lombok.*;


import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Role implements GrantedAuthority{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int roleId;
    private String authority;

    public Role(String authority) {
    }
}
