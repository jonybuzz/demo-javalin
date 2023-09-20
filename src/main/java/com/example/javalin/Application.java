package com.example.javalin;

import com.example.javalin.presentacion.GetMascotaIdHandler;
import com.example.javalin.presentacion.GetMascotasHandler;
import com.example.javalin.presentacion.LoginHandler;
import com.example.javalin.presentacion.PostMascotaHandler;
import io.javalin.Javalin;
import io.javalin.openapi.plugin.OpenApiConfiguration;
import io.javalin.openapi.plugin.OpenApiPlugin;
import io.javalin.openapi.plugin.swagger.SwaggerConfiguration;
import io.javalin.openapi.plugin.swagger.SwaggerPlugin;

public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
                    config.plugins.register(new OpenApiPlugin(new OpenApiConfiguration()));
                    config.plugins.register(new SwaggerPlugin(new SwaggerConfiguration()));
                })
                .get("/", ctx -> ctx.result("Hello World"))
                .start(4567);
        System.out.println("Check out Swagger UI docs at http://localhost:4567/swagger");


        app.get("/api/mascotas", new GetMascotasHandler());
        app.get("/api/mascotas/{id}", new GetMascotaIdHandler());
        app.post("/api/mascotas", new PostMascotaHandler());

        app.post("/api/login", new LoginHandler());

        app.exception(IllegalArgumentException.class, (e, ctx) -> {
            //tratar excepcion
        });


    }


}
