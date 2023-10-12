package com.example.javalin.presentacion;

import com.example.javalin.modelo.Mascota;
import com.example.javalin.persistencia.RepositorioMascotas;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class PostMascotaHandler implements Handler {

    private final RepositorioMascotas repoMascotas;

    public PostMascotaHandler() {
        this.repoMascotas = new RepositorioMascotas();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        String bodyString = context.body();
        Mascota mascota = context.bodyAsClass(Mascota.class);
        System.out.println("Creando mascota: " + bodyString);
        System.out.println(mascota);
        validarNuevaMascota(mascota);
        context.status(201).json(mascota);
    }

    private void validarNuevaMascota(Mascota mascota) {
        if (mascota.getNombre() == null) {
            throw new IllegalArgumentException("El nombre es obligatorio, elegí otro");
        }
    }

}
