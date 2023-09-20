package com.example.javalin.presentacion;

import com.example.javalin.modelo.Dueño;
import com.example.javalin.persistencia.RepositorioDueños;
import com.example.javalin.presentacion.dto.MisDatos;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Map;

public class GetPerfilSesionHandler implements Handler {

    private final RepositorioDueños repoDueños;

    public GetPerfilSesionHandler() {
        this.repoDueños = new RepositorioDueños();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {

        String idSesion = context.header("Authorization");

        Map<String, Object> atributosSesion = SesionManager.get().obtenerAtributos(idSesion);

        Date fechaInicioSesion = (Date) atributosSesion.get("fechaInicio");

        Dueño dueñoSesion = (Dueño) atributosSesion.get("dueño");
        System.out.println("Obteniendo datos de: " + dueñoSesion);

        if (dueñoSesion == null) {
            context.status(404);
        }

        //lo que quiera hacer con el dueño
        MisDatos misDatos = new MisDatos();
        Dueño dueño = repoDueños.obtenerTodos().stream().filter(d -> d.getId() == dueñoSesion.getId()).findFirst().get();
        misDatos.setNombre(dueño.getNombre());
        misDatos.setMascotas(dueño.getMascotas());


        context.status(200).json(misDatos);

    }

}
