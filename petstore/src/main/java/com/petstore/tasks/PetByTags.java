package com.petstore.tasks;

import com.petstore.enums.EndPoints;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

public class PetByTags implements Task {

    private final String tags;

    public PetByTags(String tags) {
        this.tags = tags;
    }

    @Step("{0} calls the endpoint #endpoint by GET method")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(EndPoints.FIND_PETS_BY_TAGS.path())
                        .with(requestSpecification ->
                                requestSpecification.contentType(ContentType.JSON)
                                        .pathParam("tags",tags)
                        )
        );
    }

}
