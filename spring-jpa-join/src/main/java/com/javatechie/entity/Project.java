package com.javatechie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;
    private String name;
    private String projectCode;
    @OneToMany(
            cascade = CascadeType.PERSIST,
            orphanRemoval = true
    )
    @JoinColumn(name = "project_engineer_fk",referencedColumnName = "projectId")
    private List<Engineer> engineers;
}
