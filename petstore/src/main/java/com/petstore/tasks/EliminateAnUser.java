package com.petstore.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static com.petstore.enums.EndPoints.USER;

public class EliminateAnUser implements Task {

    private final String username;

    public EliminateAnUser(String username) {
        this.username = username;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from(USER.path().concat(username))
                .with(requestSpecification ->
                        requestSpecification.contentType(ContentType.JSON)
                )
        );
    }
    public static EliminateAnUser withUsername(String username){
        return Tasks.instrumented(EliminateAnUser.class,username);
    }
}
