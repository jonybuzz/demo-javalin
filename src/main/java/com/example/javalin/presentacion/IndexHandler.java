package com.example.javalin.presentacion;

import com.example.javalin.persistencia.RepositorioMascotas;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;


public class IndexHandler implements Handler {

    private final RepositorioMascotas repoMascotas;

    public IndexHandler() {
        this.repoMascotas = new RepositorioMascotas();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        var mascotas = this.repoMascotas.obtenerTodas();
        Map<String, Object> model = new HashMap<>();
        model.put("listamascotas", mascotas);
        context.render("templates/index.mustache", model);
    }
}
