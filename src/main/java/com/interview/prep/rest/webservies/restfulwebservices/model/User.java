package com.interview.prep.rest.webservies.restfulwebservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_details")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Size(min = 2,message = "name should be of at least 2 characters")
    private String name;
    @Past(message = "birth date should be in past")
    private LocalDate birthDate;
    @JsonProperty("pan_number")
    private String panNumber;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Itr> listOfFiledItr;
}
