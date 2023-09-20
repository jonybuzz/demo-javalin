package com.example.javalin.modelo;

import java.util.List;

public class Dueño {

    private Integer id;
    private String nombre;
    private List<Mascota> mascotas;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Dueño{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
