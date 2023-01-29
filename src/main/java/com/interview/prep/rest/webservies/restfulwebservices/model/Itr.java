package com.interview.prep.rest.webservies.restfulwebservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Itr {
    @Id
    @GeneratedValue
    private Integer id;
    private String type;
    private Integer financialYear;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
}
