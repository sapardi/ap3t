package com.jasoet.ap3t.domain;

import org.hibernate.annotations.Index;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Author : Deny Prasetyo S.T.
 * E-mail : jasoet87@gmail.com
 */

@Entity
@Table(name = "group_")
public class Group implements Serializable {
    /*------------------------------ Fields ------------------------------*/
    @Id
    @GeneratedValue
    @Column(name = "groups_id")
    private Long id;

    @Column(nullable = false, length = 50, name = "name")
    @Size(max = 50, min = 1)
    @Index(name = "groups_name_id")
    private String name;


    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinTable(name = "groups_authority", joinColumns = {@JoinColumn(name = "groups_id")}, inverseJoinColumns = @JoinColumn(name = "authority"))
    private List<Role> roles = new ArrayList<Role>();


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
