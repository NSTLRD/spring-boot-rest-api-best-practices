/**
 * @author Starling Diaz on 1/28/2024.
 * @Academy StarAcademy
 * @version api-rest-demo-01 1.0
 * @since 1/28/2024.
 */

package com.example.apirestdemo01.exceptions;

public class UserNotFoundException extends RuntimeException {

        public UserNotFoundException(Long userId) {
            super("User not Found with ID: " + userId + ".");
        }
}
