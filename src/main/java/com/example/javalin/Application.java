package com.example.javalin;

import com.example.javalin.presentacion.GetMascotaIdHandler;
import com.example.javalin.presentacion.GetMascotasHandler;
import com.example.javalin.presentacion.LoginHandler;
import com.example.javalin.presentacion.PostMascotaHandler;
import io.javalin.Javalin;

public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create()
                .get("/", ctx -> ctx.result("Hello World"))
                .start(4567);

        app.get("/api/mascotas", new GetMascotasHandler());
        app.get("/api/mascotas/{id}", new GetMascotaIdHandler());
        app.post("/api/mascotas", new PostMascotaHandler());

        app.post("/api/login", new LoginHandler());

        app.exception(IllegalArgumentException.class, (e, ctx) -> {
            //tratar excepcion
        });


    }


}
