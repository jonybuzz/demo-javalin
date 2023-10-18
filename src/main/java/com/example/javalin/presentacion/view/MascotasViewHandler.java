package com.example.javalin.presentacion.view;

import com.example.javalin.persistencia.RepositorioMascotas;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class MascotasViewHandler implements Handler {

    private final RepositorioMascotas repoMascotas;

    public MascotasViewHandler() {
        this.repoMascotas = new RepositorioMascotas();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        var mascotas = repoMascotas.obtenerTodas();
        var model = new HashMap<String, Object>();
        model.put("mascotas", mascotas);
        context.render("index.mustache", model);
    }

}
