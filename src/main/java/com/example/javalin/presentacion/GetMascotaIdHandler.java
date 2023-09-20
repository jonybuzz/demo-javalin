package com.example.javalin.presentacion;

import com.example.javalin.modelo.Mascota;
import com.example.javalin.persistencia.RepositorioMascotas;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class GetMascotaIdHandler implements Handler {

    private final RepositorioMascotas repoMascotas;

    public GetMascotaIdHandler() {
        this.repoMascotas = new RepositorioMascotas();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {

        Integer idBuscado = context.pathParamAsClass("id", Integer.class).get();
        final Optional<Mascota> resultadoBusqueda = repoMascotas.obtenerTodas().stream()
                .filter(m -> m.getId() == idBuscado)
                .findFirst();
        if (resultadoBusqueda.isPresent()) {
            context.status(200).json(resultadoBusqueda.get());
        } else {
            context.status(404);
        }
    }
    
}
