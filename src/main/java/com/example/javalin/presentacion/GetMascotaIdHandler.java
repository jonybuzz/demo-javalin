package com.example.javalin.presentacion;

import com.example.javalin.modelo.Mascota;
import com.example.javalin.persistencia.RepositorioMascotas;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.openapi.HttpMethod;
import io.javalin.openapi.OpenApi;
import io.javalin.openapi.OpenApiContent;
import io.javalin.openapi.OpenApiParam;
import io.javalin.openapi.OpenApiResponse;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class GetMascotaIdHandler implements Handler {

    private final RepositorioMascotas repoMascotas;

    public GetMascotaIdHandler() {
        this.repoMascotas = new RepositorioMascotas();
    }

    @OpenApi(
            path = "/api/mascotas/{id}",
            methods = {HttpMethod.GET},
            pathParams = @OpenApiParam(name = "id", description = "ID mascota a buscar", required = true, type = Integer.class)
//            responses = {
//                    @OpenApiResponse(status = "200", content = @OpenApiContent(from = Mascota.class)),
//                    @OpenApiResponse(status = "404" )
//            }
    )
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
