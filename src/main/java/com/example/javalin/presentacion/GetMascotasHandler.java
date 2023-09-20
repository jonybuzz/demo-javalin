package com.example.javalin.presentacion;

import com.example.javalin.persistencia.RepositorioMascotas;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetMascotasHandler implements Handler {

    private final RepositorioMascotas repoMascotas;

    public GetMascotasHandler() {
        this.repoMascotas = new RepositorioMascotas();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        context.json(repoMascotas.obtenerTodas());
    }

}
