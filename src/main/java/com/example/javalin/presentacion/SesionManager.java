package com.example.javalin.presentacion;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SesionManager {

    private static SesionManager instancia;

    private Map<String, Map<String, Object>> sesiones;

    private SesionManager() {
        this.sesiones = new HashMap<>();
    }

    public static SesionManager get() {
        if (instancia == null) {
            instancia = new SesionManager();
        }
        return instancia;
    }

    public String crearSesion() {
        return this.crearSesion(new HashMap<>());
    }

    public String crearSesion(String clave, Object valor) {
        HashMap<String, Object> atributo = new HashMap<>();
        atributo.put(clave, valor);
        return this.crearSesion(atributo);
    }

    public String crearSesion(Map<String, Object> atributos) {
        String id = UUID.randomUUID().toString();
        this.sesiones.put(id, atributos);
        return id;
    }

    public Map<String, Object> obtenerAtributos(String id) {
        return this.sesiones.get(id);
    }

    public void agregarAtributo(String id, String clave, Object valor) {
        Map<String, Object> atributos = this.sesiones.get(id);
        atributos.put(clave, valor);
    }

    public void agregarAtributos(String id, Map<String, Object> nuevosAtributos) {
        Map<String, Object> atributos = this.sesiones.get(id);
        atributos.putAll(nuevosAtributos);
    }

    public Map<String, Object> eliminar(String id) {
        //esto no elimina la cookie del frontend
        return this.sesiones.remove(id);
    }

}
