package com.petstore.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.petstore.enums.EndPoints.USER;

public class UserByUsername implements Task {

    private final String username;

    public UserByUsername(String username) {
        this.username = username;
    }


    @Override

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(USER.path().concat(username))
                .with(requestSpecification ->
                        requestSpecification.contentType(ContentType.JSON)
                )
        );
    }

}
