package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "function")
public class Function {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int code;
    private String url;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinTable(name = "role_function",
            joinColumns = { @JoinColumn(name = "Function_ID") },
            inverseJoinColumns = { @JoinColumn(name = "Role_ID") })

    private Set<Role> roles = new HashSet<>();



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
