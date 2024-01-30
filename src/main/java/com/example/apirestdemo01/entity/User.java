/**
 * @author Starling Diaz on 1/28/2024.
 * @Academy StarAcademy
 * @version api-rest-demo-01 1.0
 * @since 1/28/2024.
 */

package com.example.apirestdemo01.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name", nullable=false)
    private String firstName;

    @Column(name="email", nullable=false, unique=true)
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="phone")
    private String phone;

    public User(String firstName, String email, String password, String phone) {
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

}
