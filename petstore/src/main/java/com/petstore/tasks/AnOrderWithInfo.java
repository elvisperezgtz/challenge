package com.petstore.tasks;

import com.petstore.enums.EndPoints;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class AnOrderWithInfo implements Task {

    private final String jsonBody;

    public AnOrderWithInfo(String jsonBody) {
        this.jsonBody = jsonBody;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Post.to(EndPoints.STORE_ORDER.path())
                        .with(requestSpecification ->
                                requestSpecification.contentType(ContentType.JSON)
                                        .body(jsonBody)
                        )
        );
    }

}
