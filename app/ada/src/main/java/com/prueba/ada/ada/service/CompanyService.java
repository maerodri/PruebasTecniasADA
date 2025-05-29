package com.prueba.ada.ada.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.ada.ada.models.Company;
import com.prueba.ada.ada.repository.CompanyRepository;


import java.util.List;

import java.util.Optional;


@Service
public class CompanyService {

    @Autowired
    private CompanyRepository Obj_CompanyRepository;


    public List<Company> obtenerTodas(){
        return Obj_CompanyRepository.findAll();
    }

    public Company registrar(Company company){
        return Obj_CompanyRepository.save(company);
    }

    public void eliminar(Integer id){
     Obj_CompanyRepository.deleteById(id);
    }

    public Optional<Company> obtenerPorId(Integer id){
      return Obj_CompanyRepository.findById(id);
    }

}
