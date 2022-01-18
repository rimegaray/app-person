package com.example.api.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Person {
  private String name;
  private String lastname;
  private String dni;
  private boolean isEmployee;
}
