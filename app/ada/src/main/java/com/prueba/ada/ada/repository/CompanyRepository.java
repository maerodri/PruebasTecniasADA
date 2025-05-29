package com.prueba.ada.ada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.ada.ada.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{

}
