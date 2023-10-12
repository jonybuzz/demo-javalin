package com.example.javalin;

import com.example.javalin.presentacion.GetMascotaIdHandler;
import com.example.javalin.presentacion.GetMascotaImgHandler;
import com.example.javalin.presentacion.GetMascotasHandler;
import com.example.javalin.presentacion.GetPerfilSesionHandler;
import com.example.javalin.presentacion.LoginHandler;
import com.example.javalin.presentacion.PostMascotaHandler;
import io.javalin.Javalin;

public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create(javalinConfig -> {
                            javalinConfig.plugins.enableCors(cors -> {
                                cors.add(it -> it.anyHost());
                            }); // para poder hacer requests de un dominio a otro

                            javalinConfig.staticFiles.add("/"); //recursos estaticos (HTML, CSS, JS, IMG)
                        }

                )
                .get("/", ctx -> ctx.result("Hello World"))
                .start(8080);

        app.get("/api/mascotas", new GetMascotasHandler());
        app.get("/api/mascotas/{id}", new GetMascotaIdHandler());
        app.get("/api/mascotas/{id}/imagen", new GetMascotaImgHandler());
        app.post("/api/mascotas", new PostMascotaHandler());
        app.get("/api/mis-datos", new GetPerfilSesionHandler());

        app.post("/api/login", new LoginHandler());


        app.exception(IllegalArgumentException.class, (e, ctx) -> {
            ctx.status(400);
        });


    }


}
