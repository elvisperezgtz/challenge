package com.petstore.tasks;

import com.petstore.enums.EndPoints;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class Login implements Task {
    private final String username;
    private final String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(EndPoints.LOGIN.path())
                        .with(requestSpecification ->
                                requestSpecification
                                        .pathParam("username",username)
                                        .pathParam("password",password)
                        )
        );
    }
    public static Login with(String username, String password){
        return Tasks.instrumented(Login.class, username,password);
    }
}
