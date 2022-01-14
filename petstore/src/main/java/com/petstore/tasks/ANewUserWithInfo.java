package com.petstore.tasks;

import com.petstore.enums.EndPoints;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class ANewUserWithInfo implements Task {
    private final String jsonBody;

    public ANewUserWithInfo(String jsonBody) {
        this.jsonBody = jsonBody;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Post.to(EndPoints.USER.path())
                        .with(requestSpecification ->
                                requestSpecification.contentType(ContentType.JSON)
                                        .body(jsonBody)
                        )
        );
    }


}
