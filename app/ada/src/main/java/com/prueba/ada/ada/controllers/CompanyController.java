package com.prueba.ada.ada.controllers;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.ada.ada.models.Company;
import com.prueba.ada.ada.service.CompanyService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;








@RestController
@RequestMapping("/ada/company")
public class CompanyController {


@Autowired
private CompanyService obj_CompanyService;

@GetMapping
public List<Company> obtenerTodas() {
    return obj_CompanyService.obtenerTodas();
}

@GetMapping("/{id}")
public Optional<Company> obtenerPorId(@PathVariable Integer id) {
    return obj_CompanyService.obtenerPorId(id);
}


@DeleteMapping("/{id}")
public void eliminar(@PathVariable Integer id) {
    obj_CompanyService.eliminar(id);
}

@PostMapping()
public Company guardar(@RequestBody Company obj_company) {
   return obj_CompanyService.registrar(obj_company);
}

}