package com.example.fdchallenge.DTO;

import lombok.*;
import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class CustomerDTO {
    private Long id;
    @NotNull(message = "Name is required")
    @NonNull
    private String name;
    @NotNull(message = "Email is required")
    @NonNull
    private String email;
    @NotNull(message = "Password is required")
    @NonNull
    private String password;
}
