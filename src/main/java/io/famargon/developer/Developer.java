package io.famargon.developer;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Developer
 */
@Entity
public class Developer extends PanacheEntity{

    @NotNull
    public String name;
    public String programmingLanguage;
    public String ide;
    @NotNull
    public int age;
    
}