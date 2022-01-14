package com.petstore.tasks;

import com.petstore.enums.EndPoints;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class PetInformation implements Task {
    private final String jsonBody;


    public PetInformation(String jsonBody) {
        this.jsonBody = jsonBody;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(EndPoints.PET.path())
                        .with(requestSpecification ->
                                requestSpecification.contentType(ContentType.JSON)
                                        .body(jsonBody)
                        )
        );
    }

}
