package com.postgreesql.oneToMany.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bancos")
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "banco")
    private Set<Cuenta> cuentas = new HashSet<>();

    public Banco() {
    }

    public Banco(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
        cuenta.setBanco(this);
    }

    public Set<Cuenta> getCuentas(){
        return cuentas;
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
