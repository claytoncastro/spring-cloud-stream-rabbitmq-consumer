package com.codjavando.project.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email implements AbstractEntity {
    private String name;
    private String email;
}
