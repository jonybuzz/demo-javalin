package com.example.javalin.presentacion;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;


public class IndexHandler implements Handler {

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Map<String, Object> model = new HashMap<>();
        model.put("titulo", "Bienvenido");
        model.put("texto", "texto insertado en el modelo");
        context.render("index.vm", model);
    }
}
