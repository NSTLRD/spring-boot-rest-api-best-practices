/**
 * @author Starling Diaz on 1/29/2024.
 * @Academy StarAcademy
 * @version api-rest-demo-01 1.0
 * @since 1/29/2024.
 */

package com.example.apirestdemo01.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String email;
    private String password;
    private String phone;
}
