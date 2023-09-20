package com.example.javalin.presentacion.dto;

import com.example.javalin.modelo.Mascota;

import java.util.List;

public class MisDatos {

    private String nombre;
    private List<Mascota> mascotas;

    // La serializacion JSON funciona basada en getters y setters
    // Si no estan, no los reconoce

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
