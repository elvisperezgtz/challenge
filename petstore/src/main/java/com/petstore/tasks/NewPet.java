package com.petstore.tasks;

import com.petstore.enums.EndPoints;
import io.restassured.http.ContentType;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

public class NewPet implements Task {

    private final String jsonBody;

    public NewPet(String jsonBody) {
        this.jsonBody = jsonBody;
    }

    @SneakyThrows
    @Override
    @Step("{0} creates a new pet")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(EndPoints.PET.path())
                        .with(requestSpecification ->
                                requestSpecification.contentType(ContentType.JSON)
                                        .body(jsonBody)
                        )
        );
    }

    public static NewPet withDataFrom(String jsonBody) {
        return Tasks.instrumented(NewPet.class, jsonBody);
    }
}
