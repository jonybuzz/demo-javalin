package com.example.javalin.presentacion;

import com.example.javalin.modelo.Dueño;
import com.example.javalin.persistencia.RepositorioDueños;
import com.example.javalin.presentacion.dto.MisDatos;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetPerfilHandler implements Handler {

    private final RepositorioDueños repoDueños;

    public GetPerfilHandler() {
        this.repoDueños = new RepositorioDueños();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {

        int idUsuario = context.pathParamAsClass("idUsuario", Integer.class).get();

        MisDatos misDatos = new MisDatos();
        if (idUsuario == 1) {
            Dueño dueño = repoDueños.obtenerJose();
            misDatos.setNombre(dueño.getNombre());
            misDatos.setMascotas(dueño.getMascotas());
            context.status(200).json(misDatos);
        }
        if (idUsuario == 2) {
            Dueño dueño = repoDueños.obtenerLuna();
            misDatos.setNombre(dueño.getNombre());
            misDatos.setMascotas(dueño.getMascotas());
            context.status(200).json(misDatos);
        }
        context.status(404);

    }

}
