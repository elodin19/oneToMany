package com.postgreesql.oneToMany.models;

import javax.persistence.*;

@Entity
@Table(name="cuentas")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String fullname;

    @ManyToOne
    private Banco banco;

    public Cuenta() {
    }

    public Cuenta(Long id, String fullname, Banco banco) {
        this.id = id;
        this.fullname = fullname;
        this.banco = banco;
    }

    public Banco getBanco(){
        return banco;
    }

    public void setBanco(Banco banco)
    {
        this.banco = banco;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", banco=" + banco +
                '}';
    }
}
