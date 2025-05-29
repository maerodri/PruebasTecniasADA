package com.prueba.ada.ada.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("ada/algoritmos")
public class AlgoritmosController {


        @GetMapping
        public Map<String, Object> calculadora(@RequestParam String operacion, Double valor1, Double valor2){
        
            Map<String, Object> response = new HashMap<>();
            
             Double resultado = 0.0;
             Double resultado2 = 0.0;
             String Detalle ="";


             switch (operacion.toUpperCase()) {
                case "SUMA":
                    resultado = valor1 + valor2;
                    Detalle = "Operacion Exitosa";
                    response.put("Resultado", resultado);
                    break;
                case "RESTA":
                    resultado = valor1 - valor2;
                    Detalle = "Operacion Exitosa";
                    response.put("Resultado", resultado);
                    break;
                case "MULTIPLICACION":
                    resultado = valor1 * valor2;
                    Detalle = "Operacion Exitosa";
                    response.put("Resultado", resultado);
                    break;
                case "DIVISION":
                    resultado = valor1 / valor2;
                    Detalle = "Operacion Exitosa";
                    response.put("Resultado", resultado);
                    break;
                case "RAIZ":
                    resultado = Math.sqrt(valor1);
                    resultado2 = Math.sqrt(valor2);
                    Detalle = "Operacion Exitosa";
                    response.put("Resultado", "La raiz cuadrada del valor1: " +resultado+ " y la del valor2: "+resultado2);
                    break;
             
                default:
                    Detalle = "La operacion no corresponde a una accion valida en este sistema, atualmente tiene las siguientes operaciones disponibles: SUMA, RESTA, MULTIPLICACION, DIVISION , RAIZ";
                    break;
             }

            
            
            
            response.put("operacion", operacion);
            response.put("Detalle", Detalle);


           

            return response;
        }


        @GetMapping("cadena")
        public Map<String, Object> ObtenerPalabras(@RequestParam String param, String palabra) {

             Map<String, Object> response = new HashMap<>();

            String[] partes = param.split(",");

            String resultadocadena = "";
            Boolean obtener = false;
           

            

            for(int i = 0;i < partes.length; i++){
                   resultadocadena = resultadocadena + partes[i];
            }


            char[] valor = resultadocadena.toCharArray();

            while (!obtener) {
                
            
            for (char c : valor) {

                for(int j = 0; j < palabra.length(); j++){
                     if(c != palabra.charAt(j)){
                          obtener = true;
                        break;
                    }
                }
                
            }
            }
            
                if(obtener){
                    response.put("Observacion:", "Si se puede armar esa palabra en el array");
                    response.put("palabra", palabra);
                }else{
                    response.put("Observacion:", "No se puede armar la palabra en el array");
                    response.put("palabra", resultadocadena);
                }
        
            


           return response;
        }
        



}
