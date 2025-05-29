package com.prueba.ada.ada.models;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "company")
public class Company {

    @Id
    private int id_company;
    private String codigo_company;
    private String name_company;
    private String description_company;
    public int getId_company() {
        return id_company;
    }
    public void setId_company(int id_company) {
        this.id_company = id_company;
    }
    public String getCodigo_company() {
        return codigo_company;
    }
    public void setCodigo_company(String codigo_company) {
        this.codigo_company = codigo_company;
    }
    public String getName_company() {
        return name_company;
    }
    public void setName_company(String name_company) {
        this.name_company = name_company;
    }
    public String getDescription_company() {
        return description_company;
    }
    public void setDescription_company(String description_company) {
        this.description_company = description_company;
    }
    public Company() {
    }
    public Company(int id_company, String codigo_company, String name_company, String description_company) {
        this.id_company = id_company;
        this.codigo_company = codigo_company;
        this.name_company = name_company;
        this.description_company = description_company;
    }

    

}
