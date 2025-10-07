package org.example;

import javax.validation.constraints.NotBlank;

public class Student {

    @NotBlank.List({})
    private int id;
    private String name;
}
