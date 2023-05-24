package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "function")
public class Function {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int code;
    private String url;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "functions")
    private Set<Role> RoleSet = new HashSet<>();

    public Function() {
    }

    public Function(long id,String name, int code, String url) {
        this.id=id;
        this.name = name;
        this.code = code;
        this.url = url;
    }
    public Function(String name, int code, String url) {
        this.name = name;
        this.code = code;
        this.url = url;
    }

}
